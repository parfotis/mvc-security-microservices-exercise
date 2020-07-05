package com.learning.ote.spring.mvc.service;

import com.learning.ote.spring.mvc.auth.domain.UserInfo;
import com.learning.ote.spring.mvc.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HelloServiceImpl implements HelloService{

    @Autowired
    private UserRepository repository;

    @Override
    public String getUsernameFromId(String id) {

         Optional<String> username = repository.findByUsername(id)
                 .map(UserInfo::getFirstName);

         return username.orElse("unknown user");

    }
}
