package com.kmust.labManagementSystem.service;

import com.kmust.labManagementSystem.dao.UserInfo;
import com.kmust.labManagementSystem.dao.userDao.UserPerission;

import java.util.List;

public interface UserService {
    /**
     * 根据用户名查询单个用户信息
     *
     * @param username
     * @return
     */
    UserInfo selectByUserNm(String username);

    /**
     * 查询 所有用户信息
     *
     * @return
     */
    List<UserInfo> findAllUserInfo();

    /**
     * 添加用户信息
     *
     * @param userPerission
     * @return
     */
    boolean addUser(UserPerission userPerission);

    /**
     * 修改密码
     * @param userNm
     * @param userPwd
     * @return
     */
    boolean updatePwd(String userNm, String userPwd);
}
