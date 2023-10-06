package com.franca.bloggamerapi.service;

import com.franca.bloggamerapi.domain.model.User;

public interface UserService {
    User findById(Long id);
    User create(User user);
}
