package com.hhplus.commerce.product.domain

import com.hhplus.commerce.common.domain.AuditEntity
import com.hhplus.commerce.common.exception.OutOfStockException
import jakarta.persistence.*

@Entity
@Table(name = "inventory")
class Inventory (
    @Column(name = "current_stock")
    val currentStock: Int,
    @Id
    val productId: Long
) : AuditEntity() {

    // 재고 차감
    fun deduction(quantity: Int): Inventory {
        if (quantity <= currentStock) {
            return Inventory(
                productId = this.productId,
                currentStock = this.currentStock - quantity
            )
        }

        throw OutOfStockException(this.productId)
    }

    // 재고 증가
    fun addStock(quantity: Int): Inventory {
        return Inventory(
            productId = this.productId,
            currentStock = this.currentStock + quantity
        )
    }

}