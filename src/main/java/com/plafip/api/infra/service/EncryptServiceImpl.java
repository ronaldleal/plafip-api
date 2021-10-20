package com.plafip.api.infra.service;

import com.plafip.api.domain.port.EncryptService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptServiceImpl implements EncryptService {
    private final BCryptPasswordEncoder encoder;

    public EncryptServiceImpl(BCryptPasswordEncoder encoder){
        this.encoder = encoder;
    }

    @Override
    public String encode(String input) {
        return encoder.encode(input);
    }

    @Override
    public boolean isMatched(String input, String encodedValue) {
        return encoder.matches(input, encodedValue);
    }
}
