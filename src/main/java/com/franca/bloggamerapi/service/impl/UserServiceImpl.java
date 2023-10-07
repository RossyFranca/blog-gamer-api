package com.franca.bloggamerapi.service.impl;

import com.franca.bloggamerapi.domain.model.User;
import com.franca.bloggamerapi.repository.UserRepository;
import com.franca.bloggamerapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
    @Override
    public User findById(Long id) {

        return  userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User user) {
        if(userRepository.existsByNickname(user.getNickname()))
            throw  new IllegalArgumentException("This nickname already exists.");
//TODO: COdificar senha
//        var senhaCodificada = passwordEncoder.encode(user.getPassword());
//        user.setPassword(senhaCodificada);

        return  userRepository.save(user);
    }
}
