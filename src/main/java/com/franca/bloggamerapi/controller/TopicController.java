package com.franca.bloggamerapi.controller;

import com.franca.bloggamerapi.domain.model.Topic;
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


    @GetMapping("/{id}")
    public ResponseEntity<Topic> findById(@PathVariable Long id){
        var topic = topicService.findById(id);

        return ResponseEntity.ok(topic);

    }

    @GetMapping
    public ResponseEntity<ArrayList<Topic>> findAll(){
        var response = topicService.findAll();

        return ResponseEntity.ok((ArrayList<Topic>) response);
    }

    @PostMapping
    public ResponseEntity<Topic> createNewTopic(@RequestBody Topic newTopic){
        newTopic.setComments(new ArrayList<>());
        var createdTopic = topicService.create(newTopic);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdTopic.getIdTopic()).toUri();
        return ResponseEntity.created(location).body(createdTopic);
    }

}
