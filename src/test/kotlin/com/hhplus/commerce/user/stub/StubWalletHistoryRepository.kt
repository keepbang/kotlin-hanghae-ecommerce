package com.hhplus.commerce.user.stub

import com.hhplus.commerce.user.domain.WalletHistory
import com.hhplus.commerce.user.repository.WalletHistoryRepository

class StubWalletHistoryRepository : WalletHistoryRepository {

    val walletHistories: MutableList<WalletHistory> = mutableListOf()

    override fun save(walletHistory: WalletHistory): WalletHistory {
        this.walletHistories.add(walletHistory)
        return walletHistory
    }

    override fun findByUserId(userId: Long): List<WalletHistory> {
        return this.walletHistories.filter { it.userId == userId }
            .toList()
    }
}