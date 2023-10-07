package com.franca.bloggamerapi.domain.dtos;

import com.franca.bloggamerapi.domain.model.Comment;
import com.franca.bloggamerapi.domain.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
@NoArgsConstructor
public class TopicDTO {

    private Long idTopic;
    private String title;
    private String body;
    private int likes;
    private Date dateCreated;

    private User user;

    private ArrayList<Comment> comments;


    public void setUser(User user) {
        this.user = user;
    }
}
