package com.sellify.platform.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "app_user",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"tenant_id","email"})
})
public class UserEntity extends BaseTenantEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean active=true;
}
