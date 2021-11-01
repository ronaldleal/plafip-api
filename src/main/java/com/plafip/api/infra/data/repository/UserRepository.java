package com.plafip.api.infra.data.repository;

import com.plafip.api.infra.data.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<UserEntity, UUID> {

    UserEntity findByExternalId(Long id);
    UserEntity findByEmailOrUsername(String email, String username);
}
