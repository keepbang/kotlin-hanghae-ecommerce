package com.hhplus.commerce.user.repository

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.mockk

val walletJpaRepository: WalletJpaRepository = mockk(relaxed = true)

@InjectMockKs
val  walletRepository: WalletRepositoryImpl = WalletRepositoryImpl(walletJpaRepository)

class WalletRepositoryImplTest : FunSpec({
    test("지갑 정보가 존재하지 않을 경우 잔액 0으로 반환") {
        // given
        every { walletJpaRepository.findByUserId(any()) } returns null

        // when
        val wallet = walletRepository.findByUserId(1L)

        // then
        wallet.balance shouldBe 0L
    }
})