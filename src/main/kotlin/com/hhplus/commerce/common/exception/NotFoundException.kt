package com.hhplus.commerce.common.exception

class NotFoundException: RuntimeException(
    ErrorMessage.NOT_FOUND_MESSAGE.toString()
) {
}