package com.kmust.labManagementSystem.service.impl;

import com.kmust.labManagementSystem.dao.UserInfo;
import com.kmust.labManagementSystem.dao.userDao.UserPerission;
import com.kmust.labManagementSystem.mapper.UserMapper;
import com.kmust.labManagementSystem.mapper.userMapper.UserPerissionMapper;
import com.kmust.labManagementSystem.service.UserPermService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserPermServiceImpl implements UserPermService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserPerissionMapper userPerissionMapper;
    @Autowired
    private UserMapper userMapper;


    @Override
    public List<String> selectByUserNm(String username) {
        List<String> list=userPerissionMapper.selectByUserNm(username);
        System.out.println("用户权限："+list);
        return list;
    }

    @Override
    public List<UserPerission> findUserPerm(Map<String, String> map) {
        List<UserInfo> userInfoList= userMapper.findUserInfo(map);
        List<UserPerission> userPerissionList = new ArrayList<>();
        for(UserInfo a: userInfoList){
            UserPerission userPerission = new UserPerission();
            userPerission.setUserNm(a.getUserNm());
            userPerission.setName(a.getName());
            userPerission.setCreateDate(a.getCreateDate());
            userPerission.setNote(a.getNote());
            List<String> userPermList =  userPerissionMapper.selectByUserNm(map.get("userNm"));
            userPerission.setUserModule(userPermList);
            userPerissionList.add(userPerission);
        }
        return userPerissionList;
    }


}
