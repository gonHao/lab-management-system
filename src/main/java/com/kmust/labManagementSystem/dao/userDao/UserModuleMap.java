package com.kmust.labManagementSystem.dao.userDao;

/**
 * 用户名与权限映射关系实体类
 */
public class UserModuleMap {
    private String userNm;
    private String moduleId;

    public String getUserNm() {
        return userNm;
    }

    public void setUserNm(String userNm) {
        this.userNm = userNm;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    @Override
    public String toString() {
        return "UserModuleMap{" +
                "userNm='" + userNm + '\'' +
                ", moduleId='" + moduleId + '\'' +
                '}';
    }
}
