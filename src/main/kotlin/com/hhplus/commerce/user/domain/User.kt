package com.hhplus.commerce.user.domain

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "users")
data class User(
    @Column(name = "user_key")
    val userKey: UUID,
    @Column(name = "name", length = 100)
    val name: String,
    @Column
    val address: String,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq_id")
    val id: Long?,
) {

    constructor() : this(UUID.randomUUID(), "", "", null)
    constructor(userKey: UUID, name: String, address: String) : this(userKey, name, address, null)
}
