package com.plafip.api.app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Jacksonized
public class MovementUpdateDto {
    @JsonProperty("id")
    public Long externalId;
    private String tipo;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fecha;
    private Double monto;
    private String descripcion;
}
