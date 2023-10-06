package com.franca.bloggamerapi.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity(name = "tb_topics")
@Data
@NoArgsConstructor
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String body;
    private int curtidas;
    @Column(name = "dt_criacao")
    private Date dataCriacao;

    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @Column(name = "id_user")
    private Long idUser;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Comment> comentarios;

}
