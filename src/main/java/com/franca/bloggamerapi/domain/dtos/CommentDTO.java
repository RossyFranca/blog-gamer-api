package com.franca.bloggamerapi.domain.dtos;

import com.franca.bloggamerapi.domain.model.Topic;
import com.franca.bloggamerapi.domain.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class CommentDTO {
    private Long idComment;

    private String body;
    private int likes;
    private Date dateCreated;

    private Topic topic;
    private User author;
}
