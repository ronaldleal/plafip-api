package com.plafip.api.domain.usecase;

import com.plafip.api.domain.model.Balance;
import com.plafip.api.domain.model.Movement;
import com.plafip.api.domain.port.MovementAdapter;

import java.util.List;

public class MovementUseCase {
    private final MovementAdapter movementAdapter;

    public MovementUseCase(MovementAdapter movementAdapter) {
        this.movementAdapter = movementAdapter;
    }

    public Movement createMovement(Movement movement) {
        return movementAdapter.createMovement(movement);
    }

    public void deleteMovement(Long id) {
        movementAdapter.deleteMovement(id);
    }

    public Movement updateMovement(Movement movement) {
        return movementAdapter.updateMovement(movement);
    }

    public List<Movement> getMovements(Long userId){
        return movementAdapter.getMovementsByUser(userId);
    }

    public Balance getBalance(Long userId) {
        var movementList = movementAdapter.getMovementsByUser(userId);
        var balance = new Balance();
        var ingreso = 0.0;
        var egreso = 0.0;

        for (Movement movement : movementList) {
            if ("ingreso".equals(movement.getTipo())) {
                ingreso = ingreso + movement.getMonto();
            } else {
                egreso = egreso + movement.getMonto();
            }
        }
        balance.setIngresos(ingreso);
        balance.setEgresos(egreso);

        return balance;
    }
}
