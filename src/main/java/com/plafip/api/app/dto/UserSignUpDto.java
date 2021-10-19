package com.plafip.api.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Jacksonized
public class UserSignUpDto {
    @JsonProperty("nombre")
    private String fullname;

    @JsonProperty("correo")
    private String email;

    @JsonProperty("usuario")
    private String username;

    private String password;
}
