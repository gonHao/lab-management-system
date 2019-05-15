package com.kmust.labManagementSystem.dao;

import java.util.Objects;

/**
 * 实验室基础信息
 */
public class BasicInfoDao {

    private  String aa01;
    private  String aa02;
    private  String aa03;
    private  String aa04;
    private  String aa05;
    private  String aa06;
    private  String aa07;
    private String aa08;
    private String aa09;

    public String getAa09() {
        return aa09;
    }

    public void setAa09(String aa09) {
        this.aa09 = aa09;
    }

    public String getAa01() {
        return aa01;
    }

    public void setAa01(String aa01) {
        this.aa01 = aa01;
    }

    public String getAa02() {
        return aa02;
    }

    public void setAa02(String aa02) {
        this.aa02 = aa02;
    }

    public String getAa03() {
        return aa03;
    }

    public void setAa03(String aa03) {
        this.aa03 = aa03;
    }

    public String getAa04() {
        return aa04;
    }

    public void setAa04(String aa04) {
        this.aa04 = aa04;
    }

    public String getAa05() {
        return aa05;
    }

    public void setAa05(String aa05) {
        this.aa05 = aa05;
    }

    public String getAa06() {
        return aa06;
    }

    public void setAa06(String aa06) {
        this.aa06 = aa06;
    }

    public String getAa07() {
        return aa07;
    }

    public void setAa07(String aa07) {
        this.aa07 = aa07;
    }

    @Override
    public String toString() {
        String aa04_new=aa04;
        if(aa04!=null&&aa04.length()<2){
            aa04_new="0"+aa04;
        }
        return "BasicInfoDao{" +
                "aa02='" + aa02 + '\'' +
                ", aa03='" + aa03 + '\'' +
                ", aa04='" + aa04_new + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicInfoDao that = (BasicInfoDao) o;
        return
                Objects.equals(aa02, that.aa02) &&
                Objects.equals(aa03, that.aa03) &&
                Objects.equals(aa04, that.aa04)
                ;
    }

    public String getAa08() {
        String aa04_new=aa04;
        if(aa04!=null&&aa04.length()<2){
            aa04_new="0"+aa04;
        }
        return aa02+aa03+aa04_new;
    }
}
