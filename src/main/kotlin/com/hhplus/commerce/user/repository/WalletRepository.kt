package com.hhplus.commerce.user.repository

import com.hhplus.commerce.user.domain.Wallet

interface WalletRepository {
    fun findByUserId(userId: Long): Wallet
    fun merge(wallet: Wallet): Wallet
}