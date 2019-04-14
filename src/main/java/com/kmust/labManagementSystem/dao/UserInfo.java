package com.kmust.labManagementSystem.dao;

public class UserInfo {
    private String userNm;
    private String userPwd;
    private String name;
    private String createDate;
    private String note;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userNm='" + userNm + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", name='" + name + '\'' +
                ", createDate='" + createDate + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
