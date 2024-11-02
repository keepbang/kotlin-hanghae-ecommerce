package com.hhplus.commerce.user.domain

import com.hhplus.commerce.common.domain.AuditEntity
import com.hhplus.commerce.common.exception.BalanceException
import jakarta.persistence.*

@Entity
data class Wallet(
    @Column(nullable = false)
    private var _userId: Long,
    @Column(nullable = false)
    private var _balance: Long,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    internal val id: Long? = null,
) : AuditEntity() {

    val userId: Long
        get() = _userId

    val balance: Long
        get() = _balance

    fun charge(amount: Long): Wallet {
        return this.copy(_balance = _balance + amount)
    }

    fun use(amount: Long): Wallet {
        if (amount > this.balance) throw BalanceException()
        return this.copy(_balance = _balance - amount)
    }

}