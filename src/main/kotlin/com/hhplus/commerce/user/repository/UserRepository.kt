package com.hhplus.commerce.user.repository

import com.hhplus.commerce.user.domain.User
import java.util.*

interface UserRepository {
    fun findByUserKeyOrThrows(userKey: UUID): User

    fun save(user: User): User
}