package com.franca.bloggamerapi.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "tb_comments")
@Data
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String body;
    private int curtidas;
    @Column(name = "dt_criacao")
    private Date dataCriacao;


    @JoinColumn(name = "id_user", referencedColumnName = "id_user") // Chave estrangeira para User
    private Long idUser; // Relacionamento com User


    @JoinColumn(name = "id_topic", referencedColumnName = "id_topic") // Chave estrangeira para User
    private Long idTopic; // Relacionamento com User
}
