package com.sellify.platform.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "tenant")
public class TenantEntity {

    @Id
    @Column(name = "tenant_id")
    private String tenantId;

    @Column(name = "business_name",nullable = false)
    private String businessName;

    @Column(name = "primary_domain",unique = true)
    private String primaryDomain;

    @Column(name = "status")
    private String status;

}
