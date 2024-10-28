package com.hhplus.commerce.user.service

import com.hhplus.commerce.user.dto.UserCreateRequest
import com.hhplus.commerce.user.dto.UserResponse

interface UserCommand {
    fun save(request: UserCreateRequest): UserResponse
}