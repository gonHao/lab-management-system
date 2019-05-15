package com.kmust.labManagementSystem.service.impl;

import com.kmust.labManagementSystem.dao.BasicInfoDao;
import com.kmust.labManagementSystem.dao.BfDao;
import com.kmust.labManagementSystem.mapper.labMapper.LabInfoMapper;
import com.kmust.labManagementSystem.service.LabInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabInfoServiceImpl implements LabInfoService {
    @Autowired
    private LabInfoMapper labInfoMapper;
    @Override
    public void addLabInfo(BasicInfoDao basicInfoDao) {
        labInfoMapper.addLabInfo(basicInfoDao);

    }

    @Override
    public void deleteLabInfo(BasicInfoDao basicInfoDao) {

    }

    @Override
    public void modifyLabInfo(BasicInfoDao basicInfoDao) {
           labInfoMapper.modifyLabInfo(basicInfoDao);
    }

    @Override
    public BasicInfoDao selectLabInfoByNew(BasicInfoDao basicInfoDao) {
        return labInfoMapper.selectLabInfoByNew(basicInfoDao);
    }

    @Override
    public List<BasicInfoDao> selctAllLabInfo() {
        return labInfoMapper.selctAllLabInfo();
    }

    @Override
    public List<BasicInfoDao> selctSomeLabInfo(BasicInfoDao basicInfoDao) {
        return labInfoMapper.selctSomeLabInfo(basicInfoDao);
    }

    @Override
    public BasicInfoDao selctLabInfoByAA01(BasicInfoDao basicInfoDao) {
        return labInfoMapper.selctLabInfoByAA01(basicInfoDao);
    }

    @Override
    public void addBorrow(BfDao bfDao) {
        labInfoMapper.addBorrow(bfDao);
    }

    @Override
    public BfDao selectBfByBf01(BfDao bfDao) {
        return labInfoMapper.selectBfByBf01(bfDao);
    }

    @Override
    public void ModifyBf06(BfDao bfDao) {
        labInfoMapper.ModifyBf06(bfDao);
    }

    @Override
    public List<BfDao> queryBf(BfDao bfDao) {
        return labInfoMapper.queryBf(bfDao);
    }
}
