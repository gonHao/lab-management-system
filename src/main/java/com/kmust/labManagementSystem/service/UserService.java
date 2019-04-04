package com.kmust.labManagementSystem.service;

import com.kmust.labManagementSystem.dao.User;
import com.kmust.labManagementSystem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserMapper{
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
