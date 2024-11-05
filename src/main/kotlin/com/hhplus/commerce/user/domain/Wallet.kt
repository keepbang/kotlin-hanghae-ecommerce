package com.hhplus.commerce.user.domain

import com.hhplus.commerce.common.domain.AuditEntity
import com.hhplus.commerce.common.exception.BalanceException
import jakarta.persistence.*

@Entity
data class Wallet(
    @Column(nullable = false)
    val userId: Long,
    @Column(nullable = false)
    val balance: Long,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    internal val id: Long? = null,
) : AuditEntity() {

    fun charge(amount: Long): Wallet {
        return this.copy(balance = balance + amount)
    }

    fun use(amount: Long): Wallet {
        if (amount > this.balance) throw BalanceException()
        return this.copy(balance = balance - amount)
    }

}