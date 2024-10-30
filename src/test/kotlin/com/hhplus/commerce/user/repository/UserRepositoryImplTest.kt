package com.hhplus.commerce.user.repository

import com.hhplus.commerce.common.exception.NotFoundException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.mockk
import java.util.*

private val userJpaRepository: UserJpaRepository = mockk(relaxed = true)
@InjectMockKs
val userRepository: UserRepositoryImpl = UserRepositoryImpl(
    userJpaRepository
)


class UserRepositoryImplTest: FunSpec () {
    init {
        test("사용자가 없을 경우 exception") {
            every { userJpaRepository.findByUserKey(any()) } returns null

            // then
            shouldThrow<NotFoundException> {
                userRepository.findByUserKeyOrThrows(UUID.randomUUID())
            }

        }
    }
}