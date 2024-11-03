package com.hhplus.commerce.user.repository

import com.hhplus.commerce.user.domain.WalletHistory
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*


interface WalletHistoryJpaRepository: JpaRepository<WalletHistory, UUID> {
    fun findAllByUserIdOrderByCreatedAtDesc(userId: Long): List<WalletHistory>
}