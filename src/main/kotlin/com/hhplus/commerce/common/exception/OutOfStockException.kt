package com.hhplus.commerce.common.exception

class OutOfStockException(
    productId: Long
) : RuntimeException("${productId} : ${ErrorMessage.OUT_OF_STOCK_MESSAGE.message}") {
}