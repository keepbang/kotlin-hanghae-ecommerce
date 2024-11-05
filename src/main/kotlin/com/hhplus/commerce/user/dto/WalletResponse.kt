package com.hhplus.commerce.user.dto

import java.time.LocalDateTime
import java.util.UUID

class WalletResponse(
    val userKey: UUID,
    val balance: Long,
    val updateAt: LocalDateTime
)