package com.kmust.labManagementSystem.mapper.labMapper;

import com.kmust.labManagementSystem.dao.AcDao;
import com.kmust.labManagementSystem.dao.AdDao;
import com.kmust.labManagementSystem.dao.BsDao;
import com.kmust.labManagementSystem.dao.LabAssetsDao;

import java.util.List;

public interface LabAssetsMapper {
    void addAssets(LabAssetsDao labAssetsDao);
    List<LabAssetsDao> queryAll(LabAssetsDao labAssetsDao);
    void ModifyAb14(LabAssetsDao labAssetsDao);
    void addFeedback(AcDao acDao);
    void addAd(AdDao adDao);
    List<AdDao> queryCodeMissing(AdDao adDao);
    List<AdDao> queryCodeMissingByAd01(AdDao adDao);
    LabAssetsDao queryAssetsByAb01(LabAssetsDao labAssetsDao);
    void setNewCode(LabAssetsDao labAssetsDao);
    void setAd04(AdDao adDao);
    List<AcDao> queryAc(AcDao acDao);
    void setAc04(AcDao acDao);
    AcDao getAcDaoByac01(AcDao acDao);
    void addBs(BsDao bsDao);
    List<BsDao> querybs(BsDao bsDao);
    BsDao queryBsByBs01(BsDao bsDao);
    void modifyBs07(BsDao bsDao);

}
