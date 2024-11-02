package com.hhplus.commerce.user.repository

import com.hhplus.commerce.user.domain.Wallet
import org.springframework.stereotype.Repository

@Repository
class WalletRepositoryImpl(
    private val walletJpaRepository: WalletJpaRepository
) : WalletRepository {
    override fun findByUserId(userId: Long): Wallet =
        walletJpaRepository.findByUserId(userId) ?: Wallet(userId, 0L)

    override fun merge(wallet: Wallet): Wallet = walletJpaRepository.saveAndFlush(wallet)
}