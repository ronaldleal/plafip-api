package com.plafip.api.domain.port;

import com.plafip.api.domain.model.User;

public interface SecurityService {
    String generateToken(User user);
}
