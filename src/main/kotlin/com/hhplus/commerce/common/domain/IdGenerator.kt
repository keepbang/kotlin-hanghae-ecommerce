package com.hhplus.commerce.common.domain

import org.apache.naming.SelectorContext.prefix
import org.hibernate.engine.spi.SharedSessionContractImplementor
import org.hibernate.id.IdentifierGenerator
import org.hibernate.service.ServiceRegistry
import org.hibernate.type.Type
import java.time.Instant
import java.util.*

class IdGenerator(
    config: CustomIdGenerator
) : IdentifierGenerator {

    private val prefix: String = config.prefix

    override fun generate(session: SharedSessionContractImplementor?, `obj`: Any?): Any {
        return prefix + Instant.now().toEpochMilli().toString()
    }
}
