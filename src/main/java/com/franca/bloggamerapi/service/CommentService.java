package com.franca.bloggamerapi.service;

import com.franca.bloggamerapi.domain.model.Comment;
import com.franca.bloggamerapi.domain.model.Topic;

public interface CommentService {

    Comment create(Comment comment);
    Comment put(Comment comment);
}
