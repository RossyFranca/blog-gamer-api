package com.franca.bloggamerapi.controller;

import com.franca.bloggamerapi.domain.dtos.CommentDTO;
import com.franca.bloggamerapi.domain.dtos.UserDTO;
import com.franca.bloggamerapi.domain.model.Comment;
import com.franca.bloggamerapi.domain.model.Topic;
import com.franca.bloggamerapi.service.CommentService;
import com.franca.bloggamerapi.service.TopicService;
import com.franca.bloggamerapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;

@RestController
@RequestMapping(path = "/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;
    @Autowired
    private TopicService topicService;
    @PostMapping
    public ResponseEntity<CommentDTO> createNewComment(@RequestBody Comment newComment){
        var createdComment = commentService.create(newComment);
        var user = userService.findById(newComment.getUser().getId());
        var topic = topicService.findById(newComment.getTopic().getIdTopic());

        createdComment.setUser(user);
        createdComment.setTopic(topic);

        CommentDTO comment = CommentDTO.createCommentDTO(createdComment);


        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(comment.getIdComment()).toUri();
        return ResponseEntity.created(location).body(comment);
    }

    @PutMapping
    public ResponseEntity<Comment> editeComment(@RequestBody Comment comment){
        var editedComment = commentService.create(comment);

        return ResponseEntity.ok(editedComment);
    }

}
