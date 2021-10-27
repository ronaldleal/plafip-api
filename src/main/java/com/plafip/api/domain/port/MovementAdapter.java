package com.plafip.api.domain.port;

import com.plafip.api.domain.model.Movement;

import java.util.List;

public interface MovementAdapter {
    List<Movement> getMovementsByUser(String email);
    Movement createMovement(Movement movement);
    void deleteMovement(Movement movement);
    Movement updateMovement(Movement movement);
}
