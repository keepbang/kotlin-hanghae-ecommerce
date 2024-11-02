package com.hhplus.commerce.user.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.util.*

class UserTest: StringSpec({
    "User 생성 테스트" {
        shouldNotThrow<Exception> {
            val user = User(
                userKey = UUID.randomUUID(),
                name = "testUser",
                address = "testAddress")
            user.name shouldBe "testUser"
            user.address shouldBe "testAddress"
        }
    }
})