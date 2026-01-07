package com.sellify.platform.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;

import java.time.Instant;

@Getter
@MappedSuperclass
public abstract class BaseAuditEntity {
    @Column(name="created_at",updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @PrePersist
    protected void onCreate(){
        createdAt=Instant.now();
        updatedAt=Instant.now();
    }
    @PreUpdate
    protected void onUpdate(){
        updatedAt=Instant.now();
    }

}
