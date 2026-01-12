package com.sellify.platform.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
public class ProductEntity extends BaseTenantEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String productId;

    private String name;
    private String description;
    private BigDecimal price;
    private boolean isActive=true;

}
