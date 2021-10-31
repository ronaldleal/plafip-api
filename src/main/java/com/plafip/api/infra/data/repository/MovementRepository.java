package com.plafip.api.infra.data.repository;

import com.plafip.api.infra.data.entity.MovementEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MovementRepository extends CrudRepository<MovementEntity, UUID> {
    MovementEntity findByExternalId(Long externalId);
}
