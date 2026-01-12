package com.sellify.platform.application.service;

import com.sellify.platform.api.dto.product.CreateProductRequest;
import com.sellify.platform.infrastructure.multitenancy.TenantContext;
import com.sellify.platform.infrastructure.persistence.entity.ProductEntity;
import com.sellify.platform.infrastructure.persistence.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductEntity create(CreateProductRequest req) {
        ProductEntity product = new ProductEntity();
        product.setName(req.name());
        product.setDescription(req.description());
        product.setPrice(req.price());
        return repository.save(product);
    }

    public Page<ProductEntity> list(Pageable pageable) {
        return repository.findByTenantIdAndIsActiveTrue(
                TenantContext.getTenantId(),
                pageable
        );
    }
}
