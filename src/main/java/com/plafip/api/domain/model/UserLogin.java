package com.plafip.api.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserLogin {
    private User user;
    private String token;
}
