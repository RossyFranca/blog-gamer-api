package com.franca.bloggamerapi.controller;

import com.franca.bloggamerapi.domain.model.Comment;
import com.franca.bloggamerapi.domain.model.Topic;
import com.franca.bloggamerapi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(path = "/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @PostMapping
    public ResponseEntity<Comment> createNewComment(@RequestBody Comment newComment){
        var createdComment = commentService.create(newComment);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdComment.getIdComment()).toUri();
        return ResponseEntity.created(location).body(createdComment);
    }

    @PutMapping
    public ResponseEntity<Comment> editeComment(@RequestBody Comment comment){
        var editedComment = commentService.create(comment);

        return ResponseEntity.ok(editedComment);
    }

}
