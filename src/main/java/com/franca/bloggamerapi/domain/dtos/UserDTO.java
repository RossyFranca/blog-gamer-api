package com.franca.bloggamerapi.domain.dtos;

import com.franca.bloggamerapi.domain.enums.UserType;
import com.franca.bloggamerapi.domain.model.Topic;
import com.franca.bloggamerapi.domain.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
@NoArgsConstructor
public class UserDTO {
    private UserType type;
    private Long idUser;
    private String nickname;
    private String email;
    private Date dateCreated;
    private ArrayList<Topic> topics;

    private UserDTO(Long id, String nickname, String email, Date dateCreated, UserType type, ArrayList<Topic> topics) {
        this.idUser = id;
        this.nickname = nickname;
        this.email = email;
        this.dateCreated = dateCreated;
        this.type = type;
        this.topics = topics;
    }

    public static UserDTO createUserDTO(User user, ArrayList<Topic> topics){
        return new UserDTO(
                user.getId(),
                user.getNickname(),
                user.getEmail(),
                user.getDateCreated(),
                user.getType(),
                topics

    );
    }
}
