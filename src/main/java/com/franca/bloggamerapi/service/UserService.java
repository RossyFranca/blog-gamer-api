package com.franca.bloggamerapi.service;

import com.franca.bloggamerapi.domain.dtos.UserDTO;
import com.franca.bloggamerapi.domain.model.User;

public interface UserService {
    UserDTO findById(Long id);
    User create(User user);
}
