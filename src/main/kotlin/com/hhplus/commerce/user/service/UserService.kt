package com.hhplus.commerce.user.service

import com.hhplus.commerce.user.domain.User
import com.hhplus.commerce.user.dto.UserCreateRequest
import com.hhplus.commerce.user.dto.UserResponse
import com.hhplus.commerce.user.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional(readOnly = true)
class UserService(
    private val userRepository: UserRepository,
): UserQuery, UserCommand {
    override fun getUserIdByUserKey(userKey: UUID): Long {
        return userRepository.findByUserKeyOrThrows(userKey).id!!
    }

    override fun findByUserKey(userKey: UUID): UserResponse {
        return userRepository.findByUserKeyOrThrows(userKey)
            .let {user ->
                UserResponse(
                    user.userKey,
                    user.name,
                    user.address
                )
            }

    }

    @Transactional
    override fun save(request: UserCreateRequest): UserResponse {
        return userRepository.save(
            User(
                UUID.randomUUID(),
                request.name,
                request.address
            )
        ).let {user ->
            UserResponse(
                user.userKey,
                user.name,
                user.address
            )
        }
    }

}