package com.kmust.labManagementSystem.service.impl;

import com.kmust.labManagementSystem.dao.User;
import com.kmust.labManagementSystem.mapper.UserMapper;
import com.kmust.labManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByUserId(String userId) {
        return userMapper.selectByUserId(userId);
    }

    @Override
    public List<User> findAllUserInfo() {
        return userMapper.findAllUserInfo();
    }
}
