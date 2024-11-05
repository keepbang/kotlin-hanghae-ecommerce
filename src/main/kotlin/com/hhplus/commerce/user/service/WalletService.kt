package com.hhplus.commerce.user.service

import com.hhplus.commerce.user.domain.TransactionType
import com.hhplus.commerce.user.domain.Wallet
import com.hhplus.commerce.user.domain.WalletHistory
import com.hhplus.commerce.user.dto.ChargeRequest
import com.hhplus.commerce.user.dto.UseRequest
import com.hhplus.commerce.user.dto.WalletResponse
import com.hhplus.commerce.user.repository.WalletHistoryRepository
import com.hhplus.commerce.user.repository.WalletRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.util.*

@Service
@Transactional(readOnly = true)
class WalletService(
    private val userQuery: UserQuery,
    private val walletRepository: WalletRepository,
    private val walletHistoryRepository: WalletHistoryRepository
) {

    fun getUserWallet(userKey: UUID): WalletResponse {
        val userId: Long = userQuery.getUserIdByUserKey(userKey)
        val wallet: Wallet = walletRepository.findByUserId(userId)

        return WalletResponse(
            userKey,
            wallet.balance,
            wallet.modifiedAt
        )
    }

    @Transactional
    fun charge(request: ChargeRequest) {
        amountValidation(request.amount)

        val foundWallet = getWalletByUserKey(request.userKey)

        val charedWallet = foundWallet.charge(request.amount)

        walletRepository.merge(charedWallet)

        // history 저장
        saveHistory(charedWallet.userId, TransactionType.CHARGE, request.amount)
    }

    @Transactional
    fun use(request: UseRequest): String {
        amountValidation(request.amount)

        val foundWallet = getWalletByUserKey(request.userKey)

        val usedWallet = foundWallet.use(request.amount)

        walletRepository.merge(usedWallet)

        // history 저장
        val walletHistory = saveHistory(usedWallet.userId, TransactionType.USE, request.amount)

        // 사용자 지갑의 경우 id를 결제 트랜젝션 아이디로 사용
        return walletHistory.id.toString()

    }

    private fun getWalletByUserKey(userKey: UUID): Wallet {
        val userId = userQuery.getUserIdByUserKey(userKey)
        return walletRepository.findByUserId(userId)
    }

    private fun saveHistory(
        userId: Long,
        transactionType: TransactionType,
        amount: Long
    ): WalletHistory {
        return walletHistoryRepository.save(
            WalletHistory(
                userId, transactionType, amount, LocalDateTime.now()
            )
        )
    }

}