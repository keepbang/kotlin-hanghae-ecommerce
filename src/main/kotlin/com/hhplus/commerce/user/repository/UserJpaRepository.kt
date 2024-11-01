package com.hhplus.commerce.user.repository

import com.hhplus.commerce.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserJpaRepository: JpaRepository<User, String> {
    fun findByUserKey(userKey: UUID): User?
}