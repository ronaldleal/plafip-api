package com.plafip.api.infra.data.repository;

import com.plafip.api.infra.data.entity.MovementEntity;
import com.plafip.api.infra.data.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface MovementRepository extends CrudRepository<MovementEntity, UUID> {
    MovementEntity findByExternalId(Long externalId);
    List<MovementEntity> findByUser(UserEntity userEntity);
}
