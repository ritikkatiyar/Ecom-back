package com.sellify.platform.infrastructure.persistence.repository;

import com.sellify.platform.infrastructure.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,String> {

    Optional<UserEntity> findByEmailAndTenantId(String email,String tenantId);

}
