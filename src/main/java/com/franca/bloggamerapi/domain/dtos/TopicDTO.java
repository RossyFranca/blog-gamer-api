package com.franca.bloggamerapi.domain.dtos;

import com.franca.bloggamerapi.domain.model.Comment;
import com.franca.bloggamerapi.domain.model.Topic;
import com.franca.bloggamerapi.domain.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class TopicDTO {

    private Long idTopic;
    private String title;
    private String body;
    private int likes;
    private Date dateCreated;

    private UserDTO user;

    private ArrayList<CommentDTO> comments;

    private TopicDTO(Long idTopic, String title, String body, int likes, Date dateCreated, UserDTO user, ArrayList<CommentDTO> comments) {
        this.idTopic = idTopic;
        this.title = title;
        this.body = body;
        this.likes = likes;
        this.dateCreated = dateCreated;
        this.user = user;
        this.comments = comments;
    }

    public static TopicDTO createTopicDTO(Topic topic, ArrayList<Comment> comments) {
        ArrayList<CommentDTO> commentDTOs = new ArrayList<>();
        if (comments != null) {
            for (Comment comment : comments) {
                commentDTOs.add(CommentDTO.createCommentDTO(comment));
            }
        }

        return new TopicDTO(
                topic.getIdTopic(),
                topic.getTitle(),
                topic.getBody(),
                topic.getLikes(),
                topic.getDateCreated(),
                UserDTO.createUserDTO(topic.getAuthor(),new ArrayList<>()),
                commentDTOs
        );
    }

}
