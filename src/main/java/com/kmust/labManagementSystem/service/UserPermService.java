package com.kmust.labManagementSystem.service;


import com.kmust.labManagementSystem.dao.userDao.UserPerission;

import java.util.List;
import java.util.Map;

public interface UserPermService {
    /**
     * 根据用户名查询单个用户权限信息
     * @param username
     * @return
     */
    List<String> selectByUserNm(String username);

    /**
     * 查询多个用户信息
     * @param map
     * @return
     */
    List<UserPerission> findUserPerm(Map<String,String> map);

    /**
     * 判断 添加用户权限是否成功
     * @param userPerission
     * @return
     */
    boolean addUserPermission(UserPerission userPerission);
}
