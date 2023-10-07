package com.franca.bloggamerapi.repository;

import com.franca.bloggamerapi.domain.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
