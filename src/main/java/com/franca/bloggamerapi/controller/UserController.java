package com.franca.bloggamerapi.controller;

import com.franca.bloggamerapi.domain.dtos.UserDTO;
import com.franca.bloggamerapi.domain.model.User;
import com.franca.bloggamerapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        var response = userService.findById(id);

        UserDTO findedUser = new UserDTO();
        findedUser.setNickname(response.getNickname());
        findedUser.setId(response.getId());
        findedUser.setEmail(response.getEmail());
        findedUser.setDataCriacao(response.getDateCreated());
        findedUser.setTipo(response.getTipo());
        return ResponseEntity.ok(findedUser);
    }
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody User user){
        var response =  userService.create(user);
        UserDTO userCreated = new UserDTO();

        userCreated.setNickname(response.getNickname());
        userCreated.setId(response.getId());
        userCreated.setEmail(response.getEmail());
        userCreated.setDataCriacao(response.getDateCreated());
        userCreated.setTipo(response.getTipo());


        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(userCreated.getId()).toUri();
        return ResponseEntity.created(location).body(userCreated);
    }



}
