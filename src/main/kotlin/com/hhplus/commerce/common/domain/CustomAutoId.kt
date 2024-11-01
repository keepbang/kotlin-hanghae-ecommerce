package com.hhplus.commerce.common.domain

import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.Parameter

@MappedSuperclass
abstract class CustomAutoId(
    @Id
    @GeneratedValue(generator = "prefix_id_generator")
    @CustomIdGenerator(
        name = "prefix_id_generator",
        prefix = "P"
    )
    internal val id: String? = null
)