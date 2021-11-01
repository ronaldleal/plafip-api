package com.plafip.api.domain.port;

import com.plafip.api.domain.model.Movement;

import java.util.List;

public interface MovementAdapter {
    List<Movement> getMovementsByUser(Long userId);
    Movement createMovement(Movement movement);
    void deleteMovement(Long id);
    Movement updateMovement(Movement movement);
}
