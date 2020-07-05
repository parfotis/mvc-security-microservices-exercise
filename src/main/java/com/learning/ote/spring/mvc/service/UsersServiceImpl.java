package com.learning.ote.spring.mvc.service;

import com.learning.ote.spring.mvc.auth.domain.UserInfo;
import com.learning.ote.spring.mvc.auth.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    private final UserRepository userRepository;

    public UsersServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserInfo> getUsers() {
        return userRepository.findAll();
    }
}
