package com.franca.bloggamerapi.service.impl;

import com.franca.bloggamerapi.domain.model.Comment;
import com.franca.bloggamerapi.repository.CommentRepository;
import com.franca.bloggamerapi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Override
    public Comment create(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment put(Comment comment) {
        return commentRepository.save(comment);
    }
}
