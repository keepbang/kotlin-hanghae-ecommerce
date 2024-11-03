package com.hhplus.commerce.user.repository

import com.hhplus.commerce.user.domain.WalletHistory

interface WalletHistoryRepository {
    fun save(walletHistory: WalletHistory): WalletHistory
    fun findByUserId(userId: Long): List<WalletHistory>
}