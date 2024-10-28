package com.hhplus.commerce.user.dto

import java.util.UUID

data class UserResponse(
    val userKey: UUID,
    val name: String,
    val address: String
)
