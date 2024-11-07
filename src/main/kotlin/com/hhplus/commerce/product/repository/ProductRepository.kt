package com.hhplus.commerce.product.repository

import com.hhplus.commerce.product.domain.Product

interface ProductRepository {
    fun save(product: Product): Product
    fun findByIdOrThrows(id: Long): Product
}