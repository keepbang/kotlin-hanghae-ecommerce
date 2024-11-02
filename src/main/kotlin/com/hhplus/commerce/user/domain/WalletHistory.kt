package com.hhplus.commerce.user.domain

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity
data class WalletHistory(
    @Column
    val userId: Long,
    @Column
    @Enumerated(EnumType.STRING)
    val type: TransactionType,
    @Column
    val amount: Long,
    @Column
    val createdAt: LocalDateTime,
    @Id
    val id: UUID = UUID.randomUUID()
) {
}

enum class TransactionType {
    CHARGE, USE
}
