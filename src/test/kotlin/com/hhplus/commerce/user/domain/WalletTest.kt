package com.hhplus.commerce.user.domain

import com.hhplus.commerce.common.exception.ErrorMessage
import io.kotest.assertions.throwables.shouldThrowMessage
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class WalletTest : FunSpec({
    test("사용자 지갑 충전") {
        // given
        val wallet = Wallet(1L, 1L)
        val amount = 1L

        // when
        val charged = wallet.charge(amount)

        // then
        charged.balance shouldBe 1L + 1L
    }

    test("지갑 잔액이 부족할 경우 Exception 발생") {
        // given
        val wallet = Wallet(1L, 0L)
        val amount = 1L
        // when
        // then
        shouldThrowMessage(ErrorMessage.BALANCE_ERROR_MESSAGE.message) {
            wallet.use(amount)
        }
    }
})