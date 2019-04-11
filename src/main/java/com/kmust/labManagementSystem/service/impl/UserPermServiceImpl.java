package com.kmust.labManagementSystem.service.impl;

import com.kmust.labManagementSystem.mapper.userMapper.UserPerissionMapper;
import com.kmust.labManagementSystem.service.UserPermService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPermServiceImpl implements UserPermService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserPerissionMapper userPerissionMapper;
    @Override
    public List<String> selectByUserNm(String username) {
        List<String> list=userPerissionMapper.selectByUserNm(username);
        System.out.println("用户权限："+list);
        return list;
    }
}
