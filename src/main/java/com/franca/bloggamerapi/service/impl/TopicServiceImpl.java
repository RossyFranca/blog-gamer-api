package com.franca.bloggamerapi.service.impl;

import com.franca.bloggamerapi.domain.model.Topic;
import com.franca.bloggamerapi.repository.TopicRepository;
import com.franca.bloggamerapi.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicRepository  topicRepository;
    @Override
    public Topic findById(Long id) {

        return topicRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Topic create(Topic newTopic) {
        if(topicRepository.existsByTitle(newTopic.getTitle()))
            throw  new IllegalArgumentException("This Topic already exists.");
        return topicRepository.save(newTopic);
    }

    @Override
    public Topic put(Topic topic) {
        return null;
    }

    @Override
    public ArrayList<Topic> findAll() {

        return (ArrayList<Topic>) topicRepository.findAll();
    }
}
