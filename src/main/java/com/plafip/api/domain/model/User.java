package com.plafip.api.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String fullname;
    private String username;
    private String email;
    private String password;
    private String token;
}
