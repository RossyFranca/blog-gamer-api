package com.franca.bloggamerapi.domain.dtos;

import com.franca.bloggamerapi.domain.enums.UserType;
import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {
    private UserType tipo;
    private Long id;
    private String nickname;
    private String email;
    private Date dataCriacao;


    public UserDTO(Long id, String nickname, String email, UserType tipo, Date dataCriacao) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.tipo = tipo;
        this.dataCriacao = dataCriacao;
    }

    public UserDTO(String nickname, Date dataDeCriacao, UserType tipo, String email) {
    }
}
