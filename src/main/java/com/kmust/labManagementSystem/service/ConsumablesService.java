package com.kmust.labManagementSystem.service;

import com.kmust.labManagementSystem.dao.*;

import java.util.List;

public interface ConsumablesService {
    void addBc(BcDao bcDao);
    List<BcDao> queryBc(BcDao bcDao);
    void addBb(BbDao bbDao);
    void addBd(BdDao bdDao);
    void modifyBc05(BcDao bcDao);
    void addBe(BeDao beDao);
    List<BeDao> queryBe(BeDao beDao);
    List<BdDao> queryBd(BdDao bdDao);
    List<BbDao> queryBb(BbDao bbDao);
    List<String> queryBB14();
    List<String> queryBD11();
    List<String> queryBE11();
    void modifyBb17(BbDao bbDao);

}
