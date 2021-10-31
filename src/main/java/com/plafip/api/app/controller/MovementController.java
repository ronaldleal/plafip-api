package com.plafip.api.app.controller;


import com.plafip.api.app.dto.MovementDto;
import com.plafip.api.app.dto.MovementUpdateDto;
import com.plafip.api.domain.model.Movement;
import com.plafip.api.domain.model.User;
import com.plafip.api.domain.port.ModelMapperService;
import com.plafip.api.domain.usecase.MovementUseCase;
import lombok.extern.java.Log;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping
    public User getMovementByUser(@RequestBody User user){
        log.info(user.toString());

        return null;
    }

    @PreAuthorize("permitAll()")
    @PostMapping
    public void createMovement(@RequestBody MovementDto movementDto){
        var movement = modelMapperService.map(movementDto, Movement.class);
        movementUseCase.createMovement(movement);
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/{id}/resume")
    public void getResumen(@RequestBody Long id){

    }

    @PreAuthorize("permitAll()")
    @DeleteMapping
    public void deleteMovement(@RequestBody MovementDto movementDto){
        var movement = modelMapperService.map(movementDto,Movement.class);
        movementUseCase.deleteMovement(movement);
    }

    @PreAuthorize("permitAll()")
    @PatchMapping
    public Movement updateMovement(@RequestBody MovementUpdateDto movementUpdateDto){
        var movement = modelMapperService.map(movementUpdateDto,Movement.class);
        movement = movementUseCase.updateMovement(movement);
        return movement;
    }
}
