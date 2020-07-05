package com.learning.ote.spring.mvc.auth.repository;

import com.learning.ote.spring.mvc.auth.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserInfo, Long> {
    Optional<UserInfo> findByUsername(@Param("username") String username);
}
