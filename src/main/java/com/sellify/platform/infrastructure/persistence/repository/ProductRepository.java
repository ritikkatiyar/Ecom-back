package com.sellify.platform.infrastructure.persistence.repository;

import com.sellify.platform.infrastructure.persistence.entity.ProductEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,String> {
    Page<ProductEntity> findByTenantIdAndIsActiveTrue(String tenantId, Pageable pageable);
}
