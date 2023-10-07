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
        var user = userService.findById(id);
        var topics = topicService.getTopicsByUserId(id);

        UserDTO findedUser = UserDTO.createUserDTO(user, topics);

        return ResponseEntity.ok(findedUser);
    }
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody User user){
        var createdUser =  userService.create(user);

        UserDTO userCreated = UserDTO.createUserDTO(createdUser, new ArrayList<>());

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(userCreated.getIdUser()).toUri();
        return ResponseEntity.created(location).body(userCreated);
    }



}
