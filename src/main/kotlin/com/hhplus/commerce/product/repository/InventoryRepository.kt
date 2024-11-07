package com.hhplus.commerce.product.repository

import com.hhplus.commerce.product.domain.Inventory

interface InventoryRepository {
    fun save(inventory: Inventory): Inventory
    fun findById(productId: Long): Inventory
}