package com.kmust.labManagementSystem.service;

import com.kmust.labManagementSystem.dao.UserInfo;

import java.util.List;

public interface UserService {
    UserInfo selectByUserId(String userId);
    UserInfo selectByUserNm(String username);
    List<UserInfo> findAllUserInfo();
}
