package com.franca.bloggamerapi.domain.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.franca.bloggamerapi.domain.enums.UserType;
import com.franca.bloggamerapi.domain.model.Topic;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDTO {
    private UserType tipo;
    private Long idUser;
    private String nickname;
    private String email;
    private Date dateCreated;
    private ArrayList<Topic> topics;

}
