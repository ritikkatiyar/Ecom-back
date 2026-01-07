package com.sellify.platform.infrastructure.persistence.entity;

import com.sellify.platform.infrastructure.multitenancy.TenantContext;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Getter;

@Getter
@MappedSuperclass //inherited by all entites
public abstract class BaseTenantEntity {
    @Column(name="tenant_id",nullable = false,updatable = false)
    private String tenantId;

    @PrePersist  //tenant auto-assigned
    protected void assignTenant(){
        String tenant= TenantContext.getTenantId();
        if(tenant==null){
            throw new IllegalStateException("Tenant not set in TenantContext");
        }
        this.tenantId=tenant;
    }
}
