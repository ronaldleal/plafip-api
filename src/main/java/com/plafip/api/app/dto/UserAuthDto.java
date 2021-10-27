package com.plafip.api.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Jacksonized
public class UserAuthDto {
    @JsonProperty("correo")
    private String email;
    private String jwt;
}
