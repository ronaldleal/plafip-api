package com.plafip.api.app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Jacksonized
public class MovementDto {
    @JsonProperty
    public Long externalId;
    private String username;
    private String tipo;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fecha;
    private Double monto;
    private String descripcion;
}
