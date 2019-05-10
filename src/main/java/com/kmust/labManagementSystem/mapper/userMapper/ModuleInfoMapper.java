package com.kmust.labManagementSystem.mapper.userMapper;

import com.kmust.labManagementSystem.dao.userDao.ModuleInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModuleInfoMapper {
    /**
     * 根据权限名查询权限信息
     * @param moduleNm
     * @return
     */
    ModuleInfo selectByModuleNm(String moduleNm);

    /**
     * 根据用户名查询用户权限
     * @param username
     * @return
     */
    List<String> selectByUserNm(@Param("username") String username);
}
