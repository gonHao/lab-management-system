package com.kmust.labManagementSystem.service;

import com.kmust.labManagementSystem.dao.UserInfo;

import java.util.List;

public interface UserService {
    UserInfo selectByUserNm(String username);
    List<UserInfo> findAllUserInfo();
}
