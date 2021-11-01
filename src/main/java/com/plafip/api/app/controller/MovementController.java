package com.plafip.api.app.controller;


import com.plafip.api.app.dto.MovementDto;
import com.plafip.api.app.dto.MovementUpdateDto;
import com.plafip.api.domain.model.Balance;
import com.plafip.api.domain.model.Movement;
import com.plafip.api.domain.port.ModelMapperService;
import com.plafip.api.domain.usecase.MovementUseCase;
import lombok.extern.java.Log;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@RestController
@RequestMapping("/movements")
public class MovementController {

    private final MovementUseCase movementUseCase;
    private final ModelMapperService modelMapperService;

    public MovementController(MovementUseCase movementUseCase,
                              ModelMapperService modelMapperService) {
        this.movementUseCase = movementUseCase;
        this.modelMapperService = modelMapperService;
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/users/{id}")
    public List<Movement> getMovementByUser(@PathVariable Long id){
        return movementUseCase.getMovements(id);
    }

    @PreAuthorize("permitAll()")
    @PostMapping
    public void createMovement(@RequestBody MovementDto movementDto){
        var movement = modelMapperService.map(movementDto, Movement.class);
        movementUseCase.createMovement(movement);
    }
    
    @PreAuthorize("permitAll()")
    @PostMapping("/delete/{id}")
    public void deleteMovement(@PathVariable Long id){
        movementUseCase.deleteMovement(id);
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/update")
    public Movement updateMovement(@RequestBody MovementUpdateDto movementUpdateDto){
        var movement = modelMapperService.map(movementUpdateDto,Movement.class);
        movement = movementUseCase.updateMovement(movement);
        return movement;
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/balance/users/{id}")
    public Balance getBalance(@PathVariable Long id){
        return movementUseCase.getBalance(id);
    }
}
