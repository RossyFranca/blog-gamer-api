package com.franca.bloggamerapi.service;

import com.franca.bloggamerapi.domain.dtos.UserDTO;
import com.franca.bloggamerapi.domain.model.User;

public interface UserService {
    User findById(Long id);
    UserDTO create(User user);
}
