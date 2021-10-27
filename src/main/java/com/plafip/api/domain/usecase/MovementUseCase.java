package com.plafip.api.domain.usecase;

import com.plafip.api.domain.model.Movement;
import com.plafip.api.domain.model.User;
import com.plafip.api.domain.port.MovementAdapter;

public class MovementUseCase {
    private final MovementAdapter movementAdapter;

    public MovementUseCase(MovementAdapter movementAdapter) {
        this.movementAdapter = movementAdapter;
    }

    public Movement createMovement(Movement movement){
        return movementAdapter.createMovement(movement);
    }

    public Movement movementByUser(User user){
        return null;
    }

    public void movimientoResumen(){

    }

    public void movimientoBorrar(){

    }
}
