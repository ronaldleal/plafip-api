package com.plafip.api.infra.data.entity;

import lombok.Data;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity(name = "movimiento")
@Table(name = "movement")
public class MovementEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "BINARY(16)", updatable = false, nullable = false)
    private UUID id;

    @Generated(GenerationTime.INSERT)
    @Column(name = "external_id", columnDefinition = "serial", updatable = false, nullable = false)
    private Long externalId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "type", nullable = false)
    private String tipo;

    @Column(name = "created", nullable = false)
    private LocalDate fecha;

    @Column(name = "amount", nullable = false)
    private Double monto;

    @Column(name = "description", nullable = false)
    private String descripcion;
}
