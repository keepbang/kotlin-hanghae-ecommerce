package com.hhplus.commerce.common.domain

import org.hibernate.annotations.IdGeneratorType

@IdGeneratorType(PrefixIdGenerator::class)
@Target(AnnotationTarget.FIELD, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class PrefixId(
    val name: String,
    val prefix: String = ""
)
