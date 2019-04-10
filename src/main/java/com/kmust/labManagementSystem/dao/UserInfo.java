package com.kmust.labManagementSystem.dao;

public class UserInfo {
    private String userId;
    private String userNm;
    private String userPwd;

    public UserInfo(String userName, String password) {
        this.userNm = userName;
        this.userPwd = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserNm() {
        return userNm;
    }

    public void setUserNm(String userNm) {
        this.userNm = userNm;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId='" + userId + '\'' +
                ", userNm='" + userNm + '\'' +
                ", userPwd='" + userPwd + '\'' +
                '}';
    }
}
