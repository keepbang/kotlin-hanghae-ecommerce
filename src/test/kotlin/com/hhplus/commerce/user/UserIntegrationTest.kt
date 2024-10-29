package com.hhplus.commerce.user

import com.fasterxml.jackson.databind.ObjectMapper
import com.hhplus.commerce.user.api.UserController
import com.hhplus.commerce.user.dto.UserCreateRequest
import com.hhplus.commerce.user.dto.UserResponse
import com.hhplus.commerce.user.service.UserCommand
import com.hhplus.commerce.user.service.UserQuery
import com.ninjasquad.springmockk.MockkBean
import io.kotest.core.spec.style.FunSpec
import io.mockk.every
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import java.util.*

@WebMvcTest(UserController::class)
class UserIntegrationTest(
    @Autowired val mockMvc: MockMvc,
    @Autowired val objectMapper: ObjectMapper,
    @MockkBean
    var userCommand: UserCommand,
    @MockkBean
    var userQuery: UserQuery
) : FunSpec() {





    init {
        test("Post /users") {

            // given
            val response = UserResponse(UUID.randomUUID(), "testUserName", "testAddress")
            every { userCommand.save(any()) } returns response

            // when
            val request = UserCreateRequest("testUserName", "testAddress")
            mockMvc.post("/users")
            mockMvc.post("/users") {
                content = objectMapper.writeValueAsString(request)
                contentType = MediaType.APPLICATION_JSON
                accept = MediaType.APPLICATION_JSON
            }
            .andExpect {
                status { isOk() }
                jsonPath("\$.name") { value("testUserName") }
                jsonPath("\$.address") { value("testAddress") }
            }.andDo { print() }
        }
    }
}