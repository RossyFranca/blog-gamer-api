package com.franca.bloggamerapi.domain;

import lombok.*;
import org.hibernate.usertype.UserType;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, length = 20)
    private String nickname;
    @Column(unique = true, length = 20)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserType tipo;
}
