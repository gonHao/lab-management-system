package com.kmust.labManagementSystem.mapper;

import com.kmust.labManagementSystem.dao.UserInfo;
import com.kmust.labManagementSystem.dao.userDao.UserPerission;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public interface UserMapper {
     UserInfo selectByUserNm(String username);
     List<UserInfo> findAllUserInfo();
     List<UserInfo> findUserInfo(Map<String,String> map);
}
