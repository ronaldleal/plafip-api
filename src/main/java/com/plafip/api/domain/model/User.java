package com.plafip.api.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    @JsonProperty("id")
    private Long externalId;
    private String fullname;
    private String username;
    private String email;
    private String password;
}
