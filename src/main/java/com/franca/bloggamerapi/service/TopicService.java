package com.franca.bloggamerapi.service;

import com.franca.bloggamerapi.domain.model.Topic;

import java.util.List;


public interface TopicService {
    Topic findById(Long id);
    Topic create(Topic user);

    List<Topic> findAll();
}
