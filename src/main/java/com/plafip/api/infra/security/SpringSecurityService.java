package com.plafip.api.infra.security;

import com.plafip.api.domain.model.User;
import com.plafip.api.domain.port.SecurityService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SpringSecurityService  implements SecurityService {

    private final BCryptPasswordEncoder encoder;

    public SpringSecurityService(BCryptPasswordEncoder encoder){
        this.encoder = encoder;
    }

    @Override
    public String generateToken(User user) {
        return "token";
    }
}
