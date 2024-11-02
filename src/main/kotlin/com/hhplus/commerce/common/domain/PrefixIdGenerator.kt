package com.hhplus.commerce.common.domain

import org.hibernate.engine.spi.SharedSessionContractImplementor
import org.hibernate.id.IdentifierGenerator
import org.hibernate.service.ServiceRegistry
import org.hibernate.type.Type
import java.util.*
import kotlin.jvm.optionals.getOrElse

class PrefixIdGenerator(
    config: PrefixId
) : IdentifierGenerator {

    private val prefix: String = config.prefix

    override fun generate(session: SharedSessionContractImplementor, `obj`: Any): Any {

        val identifierPropertyName = session.getEntityPersister(obj.javaClass.name, obj)
            .identifierPropertyName

        val query = java.lang.String.format(
            "select %s from %s order by %s desc limit 1",
            identifierPropertyName,
            obj.javaClass.getSimpleName(),
            identifierPropertyName
        )


        val ids = session.createQuery(query, String::class.java)
            .stream()


        val max: Long = ids.findFirst()
            .map { o -> o.toString().replace(prefix, "").toLong() }
            .getOrElse {0L}

        return prefix + (max + 1)
    }

    override fun configure(
        type: Type?,
        parameters: Properties?,
        serviceRegistry: ServiceRegistry?
    ) {
        super.configure(type, parameters, serviceRegistry)
    }

}
