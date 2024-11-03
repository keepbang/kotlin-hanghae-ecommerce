package com.hhplus.commerce.user.service

import com.hhplus.commerce.user.repository.WalletHistoryRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class WalletService(
    private val userQuery: UserQuery,
    private val walletRepository: WalletService,
    private val walletHistoryRepository: WalletHistoryRepository
) {

}