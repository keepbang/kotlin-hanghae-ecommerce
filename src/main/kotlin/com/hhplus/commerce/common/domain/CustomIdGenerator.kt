package com.hhplus.commerce.common.domain

import org.hibernate.annotations.IdGeneratorType
import org.hibernate.annotations.Parameter

@IdGeneratorType(IdGenerator::class)
@Target(AnnotationTarget.FIELD, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class CustomIdGenerator(
    val name: String,
    val prefix: String = ""
)
