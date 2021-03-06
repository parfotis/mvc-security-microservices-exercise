package com.learning.ote.spring.mvc.service;

import com.learning.ote.spring.mvc.auth.domain.UserInfo;

import java.util.List;

public interface UsersService {
    String getUsernameFromId(String id);
    List<UserInfo> getUsers();
}
