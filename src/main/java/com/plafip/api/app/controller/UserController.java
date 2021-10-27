package com.plafip.api.app.controller;

import com.plafip.api.app.dto.UserAuthDto;
import com.plafip.api.app.dto.UserSignInDto;
import com.plafip.api.app.dto.UserSignUpDto;
import com.plafip.api.domain.model.User;
import com.plafip.api.domain.port.ModelMapperService;
import com.plafip.api.domain.usecase.UserUseCase;
import lombok.extern.java.Log;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Optional;

@Log
@RestController("/users")
public class UserController {

    private final UserUseCase userUseCase;
    private final ModelMapperService modelMapperService;

    public UserController(UserUseCase userUseCase, ModelMapperService modelMapperService){
        this.userUseCase = userUseCase;
        this.modelMapperService = modelMapperService;
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/sign-in")
    public UserAuthDto doLogin(@RequestBody UserSignInDto user){
        log.info(user.toString());
        var token = userUseCase.signIn(modelMapperService.map(user, User.class));
        if (Objects.isNull(token)){
            throw new RuntimeException();
        }

        return UserAuthDto.builder()
                .email(user.getEmail())
                .jwt(token)
                .build();
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/sign-up")
    public void doSignUp(@RequestBody UserSignUpDto user){
        userUseCase.signUp(modelMapperService.map(user, User.class));
    }

}
