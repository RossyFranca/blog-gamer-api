package com.franca.bloggamerapi.controller;

import com.franca.bloggamerapi.domain.dtos.TopicDTO;
import com.franca.bloggamerapi.domain.model.Comment;
import com.franca.bloggamerapi.domain.model.Topic;
import com.franca.bloggamerapi.domain.model.User;
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
@RequestMapping(path = "/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;


    @GetMapping("/{id}")
    public ResponseEntity<TopicDTO> findById(@PathVariable Long id){
        Topic topic = topicService.findById(id);
        User user = userService.findById(topic.getIdUser());
        ArrayList<Comment> comments = commentService.findCommentsByTopicId(id);
        TopicDTO findedTopic = new TopicDTO();
        findedTopic.setUser(user);
        findedTopic.setIdTopic(topic.getIdTopic());
        findedTopic.setTitle(topic.getTitle());
        findedTopic.setBody(topic.getBody());
        findedTopic.setLikes(topic.getLikes());
        findedTopic.setDateCreated(topic.getDateCreated());
        findedTopic.setComments(comments);

        return ResponseEntity.ok(findedTopic);

    }

    @GetMapping
    public ResponseEntity<ArrayList<Topic>> findAll(){
        var response = topicService.findAll();

        return ResponseEntity.ok((ArrayList<Topic>) response);
    }

    @PostMapping
    public ResponseEntity<TopicDTO> createNewTopic(@RequestBody Topic newTopic){

        var createdTopic = topicService.create(newTopic);


        TopicDTO  topic = new TopicDTO();

        topic.setIdTopic(createdTopic.getIdTopic());
        topic.setTitle(createdTopic.getTitle());
        topic.setBody(createdTopic.getBody());
        topic.setComments(new ArrayList<>());
        topic.setDateCreated(createdTopic.getDateCreated());
        topic.setLikes(0);

        User user = userService.findById(newTopic.getIdUser());

        topic.setUser(user);
        

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(topic.getIdTopic()).toUri();
        return ResponseEntity.created(location).body(topic);
    }

}
