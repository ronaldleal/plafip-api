package com.plafip.api.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Movement {
    @JsonProperty("id")
    private Long externalId;
    private Long userId;
    private String tipo;
    private LocalDate fecha;
    private Double monto;
    private String descripcion;
}
