package com.kmust.labManagementSystem.service.impl;

import com.kmust.labManagementSystem.dao.UserInfo;
import com.kmust.labManagementSystem.dao.userDao.ModuleInfo;
import com.kmust.labManagementSystem.dao.userDao.UserModuleMap;
import com.kmust.labManagementSystem.dao.userDao.UserPerission;
import com.kmust.labManagementSystem.mapper.UserMapper;
import com.kmust.labManagementSystem.mapper.userMapper.ModuleInfoMapper;
import com.kmust.labManagementSystem.mapper.userMapper.UserModuleMapMapper;
import com.kmust.labManagementSystem.service.UserPermService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserPermServiceImpl implements UserPermService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserModuleMapMapper userModuleMapMapper;
    @Autowired
    private ModuleInfoMapper moduleInfoMapper;


    @Override
    public List<String> selectByUserNm(String username) {
        List<String> list=moduleInfoMapper.selectByUserNm(username);
        System.out.println("用户权限："+list);
        return list;
    }

    /**
     * 根据输入信息组，查询多个用户信息，以list返回
     * @param map
     * @return List<UserPerission>
     */
    @Override
    public List<UserPerission> findUserPerm(Map<String, String> map) {
        List<UserInfo> userInfoList= userMapper.findUserInfo(map);
        List<UserPerission> userPerissionList = new ArrayList<>();
        for(UserInfo a: userInfoList){
            UserPerission userPerission = new UserPerission();
            userPerission.setUserNm(a.getUserNm());
            userPerission.setName(a.getName());
            userPerission.setCreateDate(a.getCreateDate());
            userPerission.setNote(a.getNote());
            List<String> userPermList =  moduleInfoMapper.selectByUserNm(map.get("userNm"));
            userPerission.setUserModule(userPermList);
            userPerissionList.add(userPerission);
        }
        return userPerissionList;
    }

    @Override
    public boolean addUserPermission(UserPerission userPerission) {
        try {
            List<String> moduleList = userPerission.getUserModule();
            for(String list:moduleList){
                UserModuleMap userModuleMap = new UserModuleMap();
                userModuleMap.setUserNm(userPerission.getUserNm());
                ModuleInfo moduleInfo = moduleInfoMapper.selectByModuleNm("ROLE_"+list);
                userModuleMap.setModuleId(moduleInfo.getModuleId());
                userModuleMapMapper.addMap(userModuleMap);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


}
