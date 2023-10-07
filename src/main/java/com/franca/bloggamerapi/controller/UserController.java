package com.franca.bloggamerapi.controller;

import com.franca.bloggamerapi.domain.dtos.UserDTO;
import com.franca.bloggamerapi.domain.model.User;
import com.franca.bloggamerapi.service.TopicService;
import com.franca.bloggamerapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TopicService topicService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        var response = userService.findById(id);

        UserDTO findedUser = new UserDTO();
        findedUser.setNickname(response.getNickname());
        findedUser.setIdUser(response.getId());
        findedUser.setEmail(response.getEmail());
        findedUser.setDateCreated(response.getDateCreated());
        findedUser.setTipo(response.getTipo());

        var topics = topicService.getTopicsByUserId(id);
        findedUser.setTopics(topics);

        return ResponseEntity.ok(findedUser);
    }
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody User user){
        var response =  userService.create(user);
        UserDTO userCreated = new UserDTO();

        userCreated.setNickname(response.getNickname());
        userCreated.setIdUser(response.getId());
        userCreated.setEmail(response.getEmail());
        userCreated.setDateCreated(response.getDateCreated());
        userCreated.setTipo(response.getTipo());
        userCreated.setTopics(new ArrayList<>());


        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(userCreated.getIdUser()).toUri();
        return ResponseEntity.created(location).body(userCreated);
    }



}
