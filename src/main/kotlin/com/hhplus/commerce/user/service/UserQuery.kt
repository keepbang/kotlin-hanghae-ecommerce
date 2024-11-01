package com.hhplus.commerce.user.service

import com.hhplus.commerce.user.dto.UserResponse
import java.util.*

/**
 *
 * <p> 사용자 검색 interface </p>
 *
 * @author Gibyung Chae (Keepbang)
 * @version 1.0
 * @since 1.0
 */

interface UserQuery {
    fun getUserIdByUserKey(userKey: UUID): String
    fun findByUserKey(userKey: UUID): UserResponse
}