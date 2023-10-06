package com.franca.bloggamerapi.repository;

import com.franca.bloggamerapi.domain.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic,Long> {
    boolean existsByTitle(String title);
}
