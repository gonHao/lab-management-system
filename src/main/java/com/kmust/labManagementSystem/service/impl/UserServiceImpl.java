package com.kmust.labManagementSystem.service.impl;

import com.kmust.labManagementSystem.dao.UserInfo;
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
    public UserInfo selectByUserNm(String username) {
        return userMapper.selectByUserNm(username);
    }

    @Override
    public List<UserInfo> findAllUserInfo() {
        return userMapper.findAllUserInfo();
    }
}
