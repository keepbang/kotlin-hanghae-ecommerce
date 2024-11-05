package com.hhplus.commerce.user.dto

import java.util.UUID

class ChargeRequest(
    val userKey: UUID,
    val amount: Long
)
