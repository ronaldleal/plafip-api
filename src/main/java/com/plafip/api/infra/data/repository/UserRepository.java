package com.plafip.api.infra.data.repository;

import com.plafip.api.infra.data.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<UserEntity, UUID> {

    UserEntity findByEmail(String email);
    UserEntity findByEmailAndPassword(String email, String password);
}
