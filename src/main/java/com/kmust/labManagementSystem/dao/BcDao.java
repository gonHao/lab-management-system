package com.kmust.labManagementSystem.dao;

public class BcDao {
    private String bc01;
    private String bc02;
    private String bc03;
    private String bc04;//前端得到名字
    private String bc05;
    private String bc06;

    public String getBc06() {
        return bc06;
    }

    public void setBc06(String bc06) {
        this.bc06 = bc06;
    }

    public String getBc01() {
        return bc01;
    }

    public void setBc01(String bc01) {
        this.bc01 = bc01;
    }

    public String getBc02() {
        return bc02;
    }

    public void setBc02(String bc02) {
        this.bc02 = bc02;
    }

    public String getBc03() {
        return bc03;
    }

    public void setBc03(String bc03) {
        this.bc03 = bc03;
    }

    @Override
    public String toString() {
        return "BcDao{" +
                "bc01='" + bc01 + '\'' +
                ", bc02='" + bc02 + '\'' +
                ", bc03='" + bc03 + '\'' +
                '}';
    }

    public String getBc04() {
        return bc02+"("+bc03+")";
    }

    public String getBc05() {
        return bc05;
    }

    public void setBc05(String bc05) {
        this.bc05 = bc05;
    }
}
