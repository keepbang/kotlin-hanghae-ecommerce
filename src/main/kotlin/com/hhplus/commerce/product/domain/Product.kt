package com.hhplus.commerce.product.domain

import com.hhplus.commerce.common.domain.AuditEntity
import jakarta.persistence.*

@Entity
@Table(name = "product")
class Product(
    name: String,
    price: Long,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    internal val productId: Long? = null
): AuditEntity() {

    @Column(name = "name", nullable = false, length = 100)
    var name: String = name
        protected set

    @Column(name = "price", nullable = false)
    var price: Long = price
        protected set



}