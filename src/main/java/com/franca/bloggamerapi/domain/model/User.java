package com.franca.bloggamerapi.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.franca.bloggamerapi.domain.enums.UserType;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Data
@NoArgsConstructor
@Entity(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;

    @Column(unique = true, length = 20)
    private String nickname;

    @Column(unique = true, length = 20)
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_created")
    @JsonIgnore
    private Date dateCreated;

    private String password;
    @JsonIgnore
    @Enumerated(EnumType.STRING)
    private UserType type;


    @PrePersist
    protected void onCreate() {
        long currentTime = System.currentTimeMillis();
        java.sql.Date sqlDate = new java.sql.Date(currentTime);
        dateCreated = sqlDate;
        this.type = UserType.NORMAL;
    }

}
