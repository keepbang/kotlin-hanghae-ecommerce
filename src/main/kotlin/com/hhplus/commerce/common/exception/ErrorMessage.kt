package com.hhplus.commerce.common.exception

enum class ErrorMessage(
    val message: String
) {
    BALANCE_ERROR_MESSAGE("잔고가 부족합니다."),
    NOT_FOUND_MESSAGE("데이터를 찾을 수 없습니다."),
    OUT_OF_STOCK_MESSAGE("상품 재고가 부족합니다."),
    LOCK_ERROR_MESSAGE("락 처리중에 에러가 발생했습니다.");
}