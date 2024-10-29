package com.hhplus.commerce.user.domain

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "users")
data class User(
    @Column(name = "user_key")
    internal val userKey: UUID,
    @Column(name = "name", length = 100)
    private var _name: String,
    @Column(name = "address")
    private var _address: String
) {

    val name: String
        get() = _name

    val address: String
        get() = _address

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq_id")
    internal val id: Long? = null


    fun update(name: String, address: String) {
        this._name = name
        this._address = address
    }
}
