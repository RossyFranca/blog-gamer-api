package com.franca.bloggamerapi.service;

import com.franca.bloggamerapi.domain.model.Comment;
import com.franca.bloggamerapi.domain.model.Topic;

import java.util.ArrayList;

public interface CommentService {

    Comment create(Comment comment);
    Comment put(Comment comment);

    ArrayList<Comment> findCommentsByTopicId(Long topicId);
}
