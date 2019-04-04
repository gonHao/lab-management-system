package com.kmust.labManagementSystem.mapper;

import com.kmust.labManagementSystem.dao.User;

import java.util.List;

public interface UserMapper {
     User selectByUserId(String userId);
     List<User> findAllUserInfo();
}
