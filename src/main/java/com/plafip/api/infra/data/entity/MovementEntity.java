package com.plafip.api.infra.data.entity;

import lombok.Data;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Data
@Entity(name = "movimiento")
@Table
public class MovementEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Generated(GenerationTime.INSERT)
    @Column(name = "external_id", columnDefinition = "serial", updatable = false, nullable = false)
    private Long externalId;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "tipo", nullable = false)
    private String tipo;
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;
    @Column(name = "monto", nullable = false)
    private Double monto;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
}
