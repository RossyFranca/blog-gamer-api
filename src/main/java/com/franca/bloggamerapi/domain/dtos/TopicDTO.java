package com.franca.bloggamerapi.domain.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class TopicDTO {

    private Long idTopic;
    private String title;
    private String body;
    private int likes;
    private Date dateCreated;

    private UserDTO user;

}
