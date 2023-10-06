package com.franca.bloggamerapi.domain.model;

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
    @Column(name = "dt_criacao")
    private Date dataCriacao;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserType tipo;


    @PrePersist
    protected void onCreate() {
        long currentTime = System.currentTimeMillis();
        java.sql.Date sqlDate = new java.sql.Date(currentTime);
        dataCriacao = sqlDate;
    }

}
