package com.plafip.api.domain.port;

public interface EncryptService {
    String encode(String input);

    boolean isMatched(String input, String encodedValue);
}
