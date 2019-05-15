package com.kmust.labManagementSystem.service;

import com.kmust.labManagementSystem.dao.BasicInfoDao;
import com.kmust.labManagementSystem.dao.BfDao;

import java.util.List;

public interface LabInfoService {
    void addLabInfo(BasicInfoDao basicInfoDao);
    void deleteLabInfo(BasicInfoDao basicInfoDao);
    void modifyLabInfo(BasicInfoDao basicInfoDao);
    BasicInfoDao selectLabInfoByNew(BasicInfoDao basicInfoDao);
    List<BasicInfoDao> selctAllLabInfo();
    List<BasicInfoDao> selctSomeLabInfo(BasicInfoDao basicInfoDao);
    BasicInfoDao selctLabInfoByAA01(BasicInfoDao basicInfoDao);
    void addBorrow(BfDao bfDao);
    BfDao selectBfByBf01(BfDao bfDao);
    void ModifyBf06(BfDao bfDao);
    List<BfDao> queryBf(BfDao bfDao);
}
