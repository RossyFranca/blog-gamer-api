package com.franca.bloggamerapi.domain.dtos;

import com.franca.bloggamerapi.domain.enums.UserType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class UserDTO {
    private UserType tipo;
    private Long id;
    private String nickname;
    private String email;
    private Date dataCriacao;

}
