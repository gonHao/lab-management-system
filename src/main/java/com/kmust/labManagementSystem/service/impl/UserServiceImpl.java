package com.kmust.labManagementSystem.service.impl;

import com.kmust.labManagementSystem.dao.UserInfo;
import com.kmust.labManagementSystem.dao.userDao.UserPerission;
import com.kmust.labManagementSystem.mapper.labMapper.UserMapper;
import com.kmust.labManagementSystem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserInfo selectByUserNm(String username) {
        return userMapper.selectByUserNm(username);
    }

    @Override
    public List<UserInfo> findAllUserInfo() {
        return userMapper.findAllUserInfo();
    }

    @Override
    public boolean addUser(UserPerission userPerission){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserNm(userPerission.getUserNm());
        userInfo.setName(userPerission.getName());
        userInfo.setUserType(userPerission.getUserType());
        userInfo.setState(userPerission.getState());
        //第一次新建用户名和密码相同
        String password=passwordEncoder.encode(userPerission.getUserNm());
        userInfo.setUserPwd(password);
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
        userInfo.setCreateDate(df.format(new Date()));//获取当前系统时间
        userInfo.setNote(userPerission.getNote());
        logger.info("添加的 用户信息："+userInfo);
        if(userMapper.addUser(userInfo)==1){
            return true;
        }else {
            return false;
        }

    }
}
