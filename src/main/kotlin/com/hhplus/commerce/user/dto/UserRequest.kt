package com.hhplus.commerce.user.dto

import java.util.UUID

data class UserRequest(
    val userKey: UUID,
    val amount: Long
)
