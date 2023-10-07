package com.franca.bloggamerapi.repository;

import com.franca.bloggamerapi.domain.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    ArrayList<Comment> findByTopicIdTopic(Long topicId);
}
