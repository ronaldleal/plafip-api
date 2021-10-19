package com.plafip.api.infra.data.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;


@Data
@Entity(name = "users")
@Table(indexes = {
        @Index(columnList = "username", name = "username_uq_index", unique = true),
        @Index(columnList = "email", name = "email_uq_index", unique = true)
})
public class UserEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "fullname", nullable = false)
    private String fullname;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "email", updatable = false, nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
}
