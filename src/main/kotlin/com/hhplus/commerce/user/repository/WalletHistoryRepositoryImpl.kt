package com.hhplus.commerce.user.repository

import com.hhplus.commerce.user.domain.WalletHistory
import org.springframework.stereotype.Repository

@Repository
class WalletHistoryRepositoryImpl(
    private val walletHistoryJpaRepository: WalletHistoryJpaRepository
): WalletHistoryRepository {
    override fun save(walletHistory: WalletHistory): WalletHistory {
        return walletHistoryJpaRepository.save(walletHistory)
    }

    override fun findByUserId(userId: Long): List<WalletHistory> {
        return walletHistoryJpaRepository.findAllByUserIdOrderByCreatedAtDesc(userId)
    }
}