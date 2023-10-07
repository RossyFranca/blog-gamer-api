package com.franca.bloggamerapi.service;

import com.franca.bloggamerapi.domain.model.Topic;

import java.util.ArrayList;
import java.util.List;


public interface TopicService {
    Topic findById(Long id);
    Topic create(Topic topic);
    Topic put(Topic topic);
    List<Topic> findAll();

    ArrayList<Topic> getTopicsByUserId(Long userId);
}
