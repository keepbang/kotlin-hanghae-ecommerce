package com.hhplus.commerce.user.repository

import com.hhplus.commerce.user.domain.Wallet
import org.springframework.data.jpa.repository.JpaRepository

interface WalletJpaRepository: JpaRepository<Wallet, Long> {
    fun findByUserId(userId: Long): Wallet?
}