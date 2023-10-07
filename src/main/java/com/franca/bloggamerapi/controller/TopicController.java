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
        Topic findedTopic = topicService.findById(id);
        User user = userService.findById(findedTopic.getAuthor().getId());
        ArrayList<Comment> comments = commentService.findCommentsByTopicId(id);

        findedTopic.setAuthor(user);
        TopicDTO newTopic = TopicDTO.createTopicDTO(findedTopic, comments);


        return ResponseEntity.ok(newTopic);

    }

    @GetMapping
    public ResponseEntity<ArrayList<Topic>> findAll(){
        var response = topicService.findAll();

        return ResponseEntity.ok((ArrayList<Topic>) response);
    }

    @PostMapping
    public ResponseEntity<TopicDTO> createNewTopic(@RequestBody Topic newTopic){

        var createdTopic = topicService.create(newTopic);
        var user = userService.findById(newTopic.getAuthor().getId());
        createdTopic.setAuthor(user);
        TopicDTO  topic = TopicDTO.createTopicDTO(createdTopic, new ArrayList<>());


        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(topic.getIdTopic()).toUri();
        return ResponseEntity.created(location).body(topic);
    }

}
