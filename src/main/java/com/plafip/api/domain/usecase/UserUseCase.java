package com.plafip.api.domain.usecase;

import com.plafip.api.domain.model.User;
import com.plafip.api.domain.port.SecurityService;
import com.plafip.api.domain.port.UserAdapter;

import java.util.Optional;

public class UserUseCase {

    private final SecurityService securityService;
    private final UserAdapter userAdapter;

    public UserUseCase(UserAdapter userAdapter, SecurityService securityService){
        this.userAdapter = userAdapter;
        this.securityService = securityService;
    }

    public void signUp(User user){
        userAdapter.createUser(user);
    }

    public String signIn(User user) {
        var response = userAdapter.doLogin(user);
        return Optional.ofNullable(response)
                .map(securityService::generateToken)
                .orElse(null);
    }
}
