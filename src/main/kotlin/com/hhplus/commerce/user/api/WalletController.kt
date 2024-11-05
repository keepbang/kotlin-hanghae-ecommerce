package com.hhplus.commerce.user.api

import com.hhplus.commerce.user.dto.WalletResponse
import com.hhplus.commerce.user.service.WalletService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/wallet")
class WalletController(
    private val walletService: WalletService
) {

    /**
     * 특정 사용자 잔액 조회
     *
     * @param userKey 사용자 아이디(uuid)
     * @return 잔액 정보 response
     */
    @GetMapping("/users/{userKey}")
    fun getUserWallet(
        @PathVariable userKey: UUID
    ) : ResponseEntity<WalletResponse> {
        return ResponseEntity<WalletResponse>(
            walletService.getUserWallet(userKey),
            HttpStatus.OK
        )
    }

}