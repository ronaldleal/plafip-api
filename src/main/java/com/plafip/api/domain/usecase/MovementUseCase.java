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

    public void deleteMovement(Movement movement){
        movementAdapter.deleteMovement(movement); }

    public Movement updateMovement(Movement movement){
        return movementAdapter.updateMovement(movement); }

    public void movimientoBorrar(){

    }
}
