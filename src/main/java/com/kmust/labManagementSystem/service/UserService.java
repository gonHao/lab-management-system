package com.kmust.labManagementSystem.service;

import com.kmust.labManagementSystem.dao.User;

import java.util.List;

public interface UserService {
    User selectByUserId(String userId);
    List<User> findAllUserInfo();
}
