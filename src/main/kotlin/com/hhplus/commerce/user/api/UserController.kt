package com.hhplus.commerce.user.api

import com.hhplus.commerce.user.dto.UserCreateRequest
import com.hhplus.commerce.user.dto.UserResponse
import com.hhplus.commerce.user.service.UserCommand
import com.hhplus.commerce.user.service.UserQuery
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/users")
class UserController(
    private val userQuery: UserQuery,
    private val userCommand: UserCommand
) {

    /**
     * 사용자 조회.
     *
     * @param userKey 사용자 아이디(uuid).
     * @return 사용자 정보 response.
     */
    @GetMapping("/{key}")
    fun getUserWallet(
        @PathVariable("key") userKey: UUID,
    ): ResponseEntity<UserResponse> {
        return ResponseEntity(
            userQuery.findByUserKey(userKey),
            HttpStatus.OK
        )
    }

    /**
     * 사용자 저장.
     *
     * @param request 사용자 정보 request.
     */
    @PostMapping
    fun save(
        @RequestBody request: UserCreateRequest,
    ): ResponseEntity<UserResponse> {
        return ResponseEntity(
            userCommand.save(request),
            HttpStatus.OK
        )
    }
}