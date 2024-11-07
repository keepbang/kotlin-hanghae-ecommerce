package com.hhplus.commerce.user.stub

import com.hhplus.commerce.common.exception.NotFoundException
import com.hhplus.commerce.user.domain.User
import com.hhplus.commerce.user.repository.UserRepository
import java.util.*

class StubUserRepository: UserRepository {

    val users: MutableList<User> = mutableListOf()

    constructor(userKey: UUID) {
        this.users.add(
            User(
                userKey,
                "kim",
                "서울 강남구"
            )
        )
    }

    override fun findByUserKeyOrThrows(userKey: UUID): User {
        return this.users.find { it.userKey == userKey }
            ?: throw NotFoundException()
    }

    override fun save(user: User): User {
        this.users.add(user)
        return user
    }
}