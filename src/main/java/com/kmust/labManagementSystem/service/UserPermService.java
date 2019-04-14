package com.kmust.labManagementSystem.service;


import com.kmust.labManagementSystem.dao.userDao.UserPerission;

import java.util.List;
import java.util.Map;

public interface UserPermService {
    List<String> selectByUserNm(String username);
    List<UserPerission> findUserPerm(Map<String,String> map);
}
