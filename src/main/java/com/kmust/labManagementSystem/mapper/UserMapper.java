package com.kmust.labManagementSystem.mapper;

import com.kmust.labManagementSystem.dao.UserInfo;

import java.util.List;

public interface UserMapper {
     UserInfo selectByUserId(String userId);
     UserInfo selectByUserNm(String username);
     List<UserInfo> findAllUserInfo();
}
