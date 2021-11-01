package com.plafip.api.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Balance {
    private Long userId;
    private Double ingresos;
    private Double egresos;
}
