package com.kmust.labManagementSystem.dao;

public class AdDao {
    private String ad01;
    private String ad02;
    private String ad03;
    private String ad04;
    private String ad05;
    private String ad06;
    private String ad07;
    private String ad04New;
    public String getAd01() {
        return ad01;
    }

    public void setAd01(String ad01) {
        this.ad01 = ad01;
    }

    public String getAd02() {
        return ad02;
    }

    public void setAd02(String ad02) {
        this.ad02 = ad02;
    }

    public String getAd03() {
        return ad03;
    }

    public void setAd03(String ad03) {
        this.ad03 = ad03;
    }

    public String getAd04() {
        if(ad04=="0"||"0".equals(ad04))
        {
            return "已处理";
        }
        return "未处理";
    }

    public String getAd04New() {
        return ad04New;
    }

    public void setAd04New(String ad04New) {
        this.ad04New = ad04New;
    }

    public void setAd04(String ad04) {
        this.ad04 = ad04;
    }

    public String getAd05() {
        return ad05;
    }

    public void setAd05(String ad05) {
        this.ad05 = ad05;
    }

    public String getAd06() {
        return ad06;
    }

    public void setAd06(String ad06) {
        this.ad06 = ad06;
    }

    public String getAd07() {
        return ad07;
    }

    public void setAd07(String ad07) {
        this.ad07 = ad07;
    }

    @Override
    public String toString() {
        return "AdDao{" +
                "ad01='" + ad01 + '\'' +
                ", ad02='" + ad02 + '\'' +
                ", ad03='" + ad03 + '\'' +
                ", ad04='" + ad04 + '\'' +
                ", ad05='" + ad05 + '\'' +
                '}';
    }
}
