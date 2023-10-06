package com.franca.bloggamerapi.service.impl;

import com.franca.bloggamerapi.domain.dtos.UserDTO;
import com.franca.bloggamerapi.domain.model.User;
import com.franca.bloggamerapi.repository.UserRepository;
import com.franca.bloggamerapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User findById(Long id) {

        return null;
    }

    @Override
    public UserDTO create(User user) {
        if(userRepository.existsByNickname(user.getNickname()))
            throw  new IllegalArgumentException("This nickname already exists.");

        var senhaCodificada = passwordEncoder.encode(user.getPassword());
        user.setPassword(senhaCodificada);
        var response = userRepository.save(user);
        UserDTO createdUser = new UserDTO(
                response.getNickname(),
                response.getDataCriacao(),
                response.getTipo(),
                response.getEmail()
        );


        return createdUser;
    }
}
