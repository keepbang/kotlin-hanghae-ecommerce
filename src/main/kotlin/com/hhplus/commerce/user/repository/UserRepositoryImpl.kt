package com.hhplus.commerce.user.repository

import com.hhplus.commerce.common.exception.NotFoundException
import com.hhplus.commerce.user.domain.User
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class UserRepositoryImpl(
    private val userJpaRepository: UserJpaRepository,
): UserRepository {

    override fun findByUserKeyOrThrows(userKey: UUID): User {
        return userJpaRepository.findByUserKey(userKey)
            ?: throw NotFoundException()
    }

    override fun save(user: User): User {
        return userJpaRepository.save(user)
    }
}