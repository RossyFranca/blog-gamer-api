package com.franca.bloggamerapi.repository;

import com.franca.bloggamerapi.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByNickname(String nickname);
}
