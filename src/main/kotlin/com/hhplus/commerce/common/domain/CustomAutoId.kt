package com.hhplus.commerce.common.domain

import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass

@MappedSuperclass
abstract class CustomAutoId(
    @Id
    @GeneratedValue(generator = "prefix_id_generator")
    @PrefixId(
        name = "prefix_id_generator",
        prefix = "P"
    )
    internal val id: String? = null
)