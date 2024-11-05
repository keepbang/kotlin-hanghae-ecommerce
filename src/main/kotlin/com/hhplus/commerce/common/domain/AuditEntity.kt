package com.hhplus.commerce.common.domain

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class AuditEntity(
    createdAt: LocalDateTime = LocalDateTime.now(),
    modifiedAt: LocalDateTime = LocalDateTime.now()
) {
    @CreatedDate
    @Column(updatable = false)
    var createdAt: LocalDateTime = createdAt
        private set

    @LastModifiedDate
    var modifiedAt: LocalDateTime = modifiedAt
        protected set
}