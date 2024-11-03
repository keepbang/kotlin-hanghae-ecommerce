package com.hhplus.commerce.user.service

import com.hhplus.commerce.common.exception.InvalidRequestException

private const val LIMIT_NUMBER: Long = 1L;

fun amountValidation(amount: Long) {
    if (amount < LIMIT_NUMBER) {
        throw InvalidRequestException("0보다 큰 양수만 입력 가능합니다.")
    }
}
