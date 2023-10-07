package com.franca.bloggamerapi.domain.dtos;

import com.franca.bloggamerapi.domain.model.Comment;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
@NoArgsConstructor
public class CommentDTO {
    private Long idComment;

    private String body;
    private int likes;
    private Date dateCreated;

    private TopicDTO topic;
    private UserDTO commentAuthor;

    private CommentDTO(Long idComment, String body, int likes, Date dateCreated, TopicDTO topic, UserDTO commentAuthor) {
        this.idComment = idComment;
        this.body = body;
        this.likes = likes;
        this.dateCreated = dateCreated;
        this.topic = topic;
        this.commentAuthor = commentAuthor;
    }

    // Método de fábrica estático para criar instâncias de CommentDTO
    public static CommentDTO createCommentDTO(Comment comment) {
        return new CommentDTO(
                comment.getIdComment(),
                comment.getBody(),
                comment.getLikes(),
                comment.getDateCreated(),
                TopicDTO.createTopicDTO(comment.getTopic(), new ArrayList<>()),
                UserDTO.createUserDTO(comment.getUser(), new ArrayList<>())
        );
    }
}
