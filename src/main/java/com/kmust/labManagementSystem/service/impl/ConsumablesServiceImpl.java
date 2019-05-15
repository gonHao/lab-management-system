package com.kmust.labManagementSystem.service.impl;

import com.kmust.labManagementSystem.dao.BbDao;
import com.kmust.labManagementSystem.dao.BcDao;
import com.kmust.labManagementSystem.dao.BdDao;
import com.kmust.labManagementSystem.dao.BeDao;
import com.kmust.labManagementSystem.mapper.ConsumablesMapper;
import com.kmust.labManagementSystem.service.ConsumablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumablesServiceImpl  implements ConsumablesService {

    @Autowired
    private ConsumablesMapper consumablesMapper;


    @Override
    public void addBc(BcDao bcDao) {
        consumablesMapper.addBc(bcDao);
    }

    @Override
    public List<BcDao> queryBc(BcDao bcDao) {
        return consumablesMapper.queryBc(bcDao);
    }

    @Override
    public void addBb(BbDao bbDao) {
        consumablesMapper.addBb(bbDao);
    }

    @Override
    public void addBd(BdDao bdDao) {
        consumablesMapper.addBd(bdDao);
    }

    @Override
    public void modifyBc05(BcDao bcDao) {
        consumablesMapper.modifyBc05(bcDao);
    }

    @Override
    public void addBe(BeDao beDao) {
        consumablesMapper.addBe(beDao);
    }

    @Override
    public List<BeDao> queryBe(BeDao beDao) {
        return consumablesMapper.queryBe(beDao);
    }

    @Override
    public List<BdDao> queryBd(BdDao bdDao) {
        return consumablesMapper.queryBd(bdDao);
    }

    @Override
    public List<BbDao> queryBb(BbDao bbDao) {
        return consumablesMapper.queryBb(bbDao);
    }

    @Override
    public List<String> queryBB14() {
        return consumablesMapper.queryBB14();
    }

    @Override
    public List<String> queryBD11() {
        return consumablesMapper.queryBD11();
    }

    @Override
    public List<String> queryBE11() {
        return consumablesMapper.queryBE11();
    }

    @Override
    public void modifyBb17(BbDao bbDao) {
        consumablesMapper.modifyBb17(bbDao);
    }


}
