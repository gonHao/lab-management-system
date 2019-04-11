package com.kmust.labManagementSystem.dao.userDao;

public class UserPerission {
    private String userNm;
    private String userModule;

    public String getUserNm() {
        return userNm;
    }

    public void setUserNm(String userNm) {
        this.userNm = userNm;
    }

    public String getUserModule() {
        return userModule;
    }

    public void setUserModule(String userModule) {
        this.userModule = userModule;
    }

    @Override
    public String toString() {
        return "UserPerission{" +
                "userNm='" + userNm + '\'' +
                ", userModule='" + userModule + '\'' +
                '}';
    }
}
