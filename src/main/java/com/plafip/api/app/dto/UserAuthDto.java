package com.plafip.api.app.dto;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Jacksonized
public class UserAuthDto {
    private String email;
    private String jwt;
}
