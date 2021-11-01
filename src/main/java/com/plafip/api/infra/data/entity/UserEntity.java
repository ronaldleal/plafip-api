package com.plafip.api.infra.data.entity;

import lombok.Data;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;


@Data
@Entity(name = "user")
@Table(indexes = {
        @Index(columnList = "username", name = "username_uq_index", unique = true),
        @Index(columnList = "email", name = "email_uq_index", unique = true)
})
public class UserEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "BINARY(16)", updatable = false, nullable = false)
    private UUID id;

    @Generated(GenerationTime.INSERT)
    @Column(name = "external_id", columnDefinition = "serial", updatable = false, nullable = false)
    private Long externalId;

    @Column(name = "fullname", nullable = false)
    private String fullname;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", updatable = false, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<MovementEntity> movementEntities;
}
