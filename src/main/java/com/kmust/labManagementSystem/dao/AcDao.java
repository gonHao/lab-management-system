package com.kmust.labManagementSystem.dao;

public class AcDao {
    private String ac01;
    private String ac02;
    private String ac03;
    private String ac04;
    private  String ac05;
    private String ac04New;
    public String getAc01() {
        return ac01;
    }

    public void setAc01(String ac01) {
        this.ac01 = ac01;
    }

    public String getAc02() {
        return ac02;
    }

    public void setAc02(String ac02) {
        this.ac02 = ac02;
    }

    public String getAc03() {
        return ac03;
    }

    public void setAc03(String ac03) {
        this.ac03 = ac03;
    }

    public String getAc04() {
        if(ac04=="0"||"0".equals(ac04)){
            return "已查阅";
        }
        return "未查阅";
    }

    public void setAc04(String ac04) {
        this.ac04 = ac04;
    }

    public String getAc05() {
        return ac05;
    }

    public String getAc04New() {
        return ac04New;
    }

    public void setAc04New(String ac04New) {
        this.ac04New = ac04New;
    }

    public void setAc05(String ac05) {
        this.ac05 = ac05;
    }

    @Override
    public String toString() {
        return "AcDao{" +
                "ac01='" + ac01 + '\'' +
                ", ac02='" + ac02 + '\'' +
                ", ac03='" + ac03 + '\'' +
                ", ac04='" + ac04 + '\'' +
                '}';
    }
}
