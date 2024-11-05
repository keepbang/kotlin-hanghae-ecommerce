package com.hhplus.commerce.user.domain

import com.hhplus.commerce.common.domain.AuditEntity
import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "users")
class User(
    userKey: UUID,
    name: String,
    address: String,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    internal val id: Long? = null
) : AuditEntity() {

    @Column(name = "user_key")
    var userKey: UUID = userKey
        protected set

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
