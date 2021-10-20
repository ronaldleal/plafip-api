package com.plafip.api.domain.port;

import com.plafip.api.domain.model.User;

public interface UserAdapter {
    User createUser(User user);
    User doLogin(User user);
    User findUser(User user);
}
