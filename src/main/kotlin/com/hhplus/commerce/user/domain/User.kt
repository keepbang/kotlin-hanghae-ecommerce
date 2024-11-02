package com.hhplus.commerce.user.domain

import com.hhplus.commerce.common.domain.CustomAutoId
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "users")
class User(
    name: String,
    address: String,
    @Column(name = "user_key")
    internal val userKey: UUID = UUID.randomUUID(),
): CustomAutoId() {

    @Column(name = "name", length = 100)
    var name: String = name
        protected set

    @Column(name = "address")
    var address: String = address
        protected set


    fun update(name: String, address: String) {
        this.name = name
        this.address = address
    }
}
