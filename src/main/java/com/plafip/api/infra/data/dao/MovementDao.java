package com.plafip.api.infra.data.dao;

import com.plafip.api.domain.model.Movement;
import com.plafip.api.domain.port.ModelMapperService;
import com.plafip.api.domain.port.MovementAdapter;
import com.plafip.api.infra.data.entity.MovementEntity;
import com.plafip.api.infra.data.repository.MovementRepository;
import com.plafip.api.infra.data.repository.UserRepository;

import java.util.List;
import java.util.Optional;


public class MovementDao implements MovementAdapter {

    private final ModelMapperService modelMapperService;
    private final UserRepository userRepository;
    private final MovementRepository movementRepository;

    public MovementDao(ModelMapperService modelMapperService,
                       UserRepository userRepository,
                       MovementRepository movementRepository) {
        this.modelMapperService = modelMapperService;
        this.userRepository = userRepository;
        this.movementRepository = movementRepository;
    }

    @Override
    public List<Movement> getMovementsByUser(String email) {
        return null;
    }

    @Override
    public Movement createMovement(Movement movement) {
        var userEntity = userRepository.findByExternalId(movement.getUserId());
        var movementEntity = modelMapperService.map(movement, MovementEntity.class);
        movementEntity.setUser(userEntity);
        movementEntity = movementRepository.save(movementEntity);
        return modelMapperService.map(movementEntity, Movement.class);
    }

    @Override
    public void deleteMovement(Movement movement) {
        var movementEntity = movementRepository.findByExternalId(movement.getExternalId());
        movementRepository.delete(movementEntity);
    }

    @Override
    public Movement updateMovement(Movement movement) {
        var movementEntity = movementRepository.findByExternalId(movement.getExternalId());
        movementEntity.setDescripcion(movement.getDescripcion());
        Optional.ofNullable(movement.getTipo()).ifPresent(movementEntity::setTipo);
        Optional.ofNullable(movement.getFecha()).ifPresent(movementEntity::setFecha);
        Optional.ofNullable(movement.getMonto()).ifPresent(movementEntity::setMonto);
        Optional.ofNullable(movement.getDescripcion()).ifPresent(movementEntity::setDescripcion);
        movementEntity = movementRepository.save(movementEntity);
        return modelMapperService.map(movementEntity, Movement.class);
    }
}
