package com.hhplus.commerce.user.service

import com.hhplus.commerce.common.exception.InvalidRequestException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class WalletValidatorKtTest: StringSpec({

}) {
    init {
        "0이 들어올 경우 exception 발생" {
            val value: Long = 0L

            shouldThrow<InvalidRequestException> {
                amountValidation(value)
            }

        }

        "음수가 들어올 경우 exception 발생" {
            val value: Long = 1L

            shouldThrow<InvalidRequestException> {
                amountValidation(value)
            }
        }
    }
}