package com.kmust.labManagementSystem.service.impl;

import com.kmust.labManagementSystem.dao.AcDao;
import com.kmust.labManagementSystem.dao.AdDao;
import com.kmust.labManagementSystem.dao.BsDao;
import com.kmust.labManagementSystem.dao.LabAssetsDao;
import com.kmust.labManagementSystem.mapper.LabAssetsMapper;
import com.kmust.labManagementSystem.service.LabAssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabAssetsServiceImpl  implements LabAssetsService {
    @Autowired
    private LabAssetsMapper labAssetsMapper;

    /**
     * 添加实验室资产
     * @param labAssetsDao
     */
    @Override
    public void addAssets(LabAssetsDao labAssetsDao) {
        labAssetsMapper.addAssets(labAssetsDao);
    }

    /**
     * 查询实验室资产
     * @param labAssetsDao
     * @return
     */
    @Override
    public List<LabAssetsDao> queryAll(LabAssetsDao labAssetsDao) {
        return labAssetsMapper.queryAll(labAssetsDao);
    }

    /**
     * 变更管理人
     * @param labAssetsDao
     */
    @Override
    public void ModifyAb14(LabAssetsDao labAssetsDao) {
        labAssetsMapper.ModifyAb14(labAssetsDao);
    }

    /**
     * 添加反馈
     * @param acDao
     */
    @Override
    public void addFeedback(AcDao acDao) {
        labAssetsMapper.addFeedback(acDao);
    }

    /**
     * 申请条码
     * @param adDao
     */
    @Override
    public void addAd(AdDao adDao) {
        labAssetsMapper.addAd(adDao);
    }

    /**
     * 查询申请
     * @return
     */
    @Override
    public List<AdDao> queryCodeMissing(AdDao adDao) {
        return labAssetsMapper.queryCodeMissing(adDao);
    }

    @Override
    public List<AcDao> queryAc(AcDao acDao) {
        return labAssetsMapper.queryAc(acDao);
    }

    @Override
    public void setAc04(AcDao acDao) {
        labAssetsMapper.setAc04(acDao);
    }

    @Override
    public AcDao getAcDaoByac01(AcDao acDao) {
        return labAssetsMapper.getAcDaoByac01(acDao);
    }

    @Override
    public void addBs(BsDao bsDao) {
        labAssetsMapper.addBs(bsDao);
    }

    @Override
    public List<BsDao> querybs(BsDao bsDao) {
        return labAssetsMapper.querybs(bsDao);
    }

    @Override
    public BsDao queryBsByBs01(BsDao bsDao) {
        return  labAssetsMapper.queryBsByBs01(bsDao);
    }

    @Override
    public void modifyBs07(BsDao bsDao) {
            labAssetsMapper.modifyBs07(bsDao);
    }

    @Override
    public List<AdDao> queryCodeMissingByAd01(AdDao adDao) {
        return labAssetsMapper.queryCodeMissingByAd01(adDao);
    }


    @Override
    public LabAssetsDao queryAssetsByAb01(LabAssetsDao labAssetsDao) {
        return labAssetsMapper.queryAssetsByAb01(labAssetsDao);
    }

    /**
     * 设置新的条码
     * @param labAssetsDao
     */
    @Override
    public void setNewCode(LabAssetsDao labAssetsDao) {
        labAssetsMapper.setNewCode(labAssetsDao);
    }

    /**
     * 设置处理标志
     * @param adDao
     */
    @Override
    public void setAd04(AdDao adDao) {
        labAssetsMapper.setAd04(adDao);
    }

}
