package com.kmust.labManagementSystem.mapper.labMapper;

import com.kmust.labManagementSystem.dao.UserInfo;
import com.kmust.labManagementSystem.dao.userDao.UserPerission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public interface UserMapper {
     /**
      * 根据用户名查询单个用户信息
      * @param username
      * @return
      */
     UserInfo selectByUserNm(String username);

     /**
      * 查询 所有用户信息
      * @return
      */
     List<UserInfo> findAllUserInfo();

     /**
      * 根据对应信息查询用户信息
      * @param map
      * @return
      */
     List<UserInfo> findUserInfo(Map<String,String> map);

     /**
      * 添加用户信息
      * @param userInfo
      * @return
      */
     int addUser(UserInfo userInfo);

     /**
      * 更新用户 信息
      * @param userInfo
      * @return
      */
     int updateInfo(UserInfo  userInfo);

     /**
      * 删除用户
      * @param userNm
      * @return
      */
     int deleteUser(@Param("userNm") String userNm);
}
