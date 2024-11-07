package com.hhplus.commerce.user.stub

import com.hhplus.commerce.common.exception.NotFoundException
import com.hhplus.commerce.user.domain.Wallet
import com.hhplus.commerce.user.repository.WalletRepository

class StubWalletRepository : WalletRepository {

    val wallets: MutableMap<Long, Wallet> = mutableMapOf()

    constructor(userId: Long) {
        this.wallets.put(userId, Wallet(userId, 0L))
    }

    override fun findByUserId(userId: Long): Wallet {
        return wallets[userId] ?: throw NotFoundException()
    }

    override fun merge(wallet: Wallet): Wallet {
        this.wallets.putIfAbsent(wallet.userId, wallet)
        return wallet
    }
}