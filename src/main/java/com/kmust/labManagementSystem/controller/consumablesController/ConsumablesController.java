package com.kmust.labManagementSystem.controller.consumablesController;


import com.kmust.labManagementSystem.dao.*;
import com.kmust.labManagementSystem.service.impl.ConsumablesServiceImpl;
import com.kmust.labManagementSystem.service.impl.LabInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/consumables")
public class ConsumablesController {
    @Autowired
    private ConsumablesServiceImpl consumablesService;
    @Autowired
    private LabInfoServiceImpl labInfoService;


    @RequestMapping("/initAddbc")
    public String initAddBc(){
        return "/consumables/addBc";
    }
    @ResponseBody
    @RequestMapping("/addBc")
    public String addBc(HttpServletRequest request){
        BcDao bcDao =new BcDao();
        bcDao.setBc02(request.getParameter("bc02"));
        bcDao.setBc03(request.getParameter("bc03"));
        bcDao.setBc06(request.getParameter("bc06"));
        bcDao.setBc05("0");
        List<BcDao> bcDaos = consumablesService.queryBc(bcDao);
        System.out.println(bcDaos.size());
        if(consumablesService.queryBc(bcDao).isEmpty()) {
            consumablesService.addBc(bcDao);
            return "添加成功";
        }
        return "添加失败，已经有此类型的耗材";
    }
    @RequestMapping("/queryBc")
    @ResponseBody
    public List<BcDao> queryBc(){
        return consumablesService.queryBc(new BcDao());
    }

    @RequestMapping("/initAddbb")
    public String initAddBb(){
        return "/consumables/addBb";
    }

    @ResponseBody
    @RequestMapping("/addBb")
    public String addBb(HttpServletRequest request){
        try {
            BcDao bcDao = new BcDao();
            bcDao.setBc01(request.getParameter("bb12"));
            List<BcDao> bcDaos = consumablesService.queryBc(bcDao);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            BasicInfoDao basicInfoDao = new BasicInfoDao();
            basicInfoDao.setAa01(request.getParameter("bb10"));
            BbDao bbDao = new BbDao();
            bbDao.setBb02(bcDaos.get(0).getBc02());
            bbDao.setBb03(bcDaos.get(0).getBc03());
            bbDao.setBb04(request.getParameter("bb04"));
            bbDao.setBb05(request.getParameter("bb05"));
            bbDao.setBb06(request.getParameter("bb06"));
            bbDao.setBb07(request.getParameter("bb07"));
            bbDao.setBb08(request.getParameter("bb08"));
            bbDao.setBb09(request.getParameter("bb09"));
            bbDao.setBb10(request.getParameter("bb10"));
            bbDao.setBb11(request.getParameter("bb11"));
            bbDao.setBb12(request.getParameter("bb12"));
            bbDao.setBb13(request.getParameter("bb12"));
            bbDao.setBb14(request.getParameter("bb14"));
            bbDao.setBb15(request.getParameter("bb15"));
            bbDao.setBb17("未处理");
            basicInfoDao = labInfoService.selctLabInfoByAA01(basicInfoDao);
            bbDao.setBb16(basicInfoDao.getAa08());
            consumablesService.addBb(bbDao);
        }catch (Exception e){
            return "系统错误，请检查数据或者联系管理员";
        }
        return "申报成功";
    }

    @RequestMapping("/initAddbd")
    public String initAddBd(){
        return "/consumables/addBd";
    }

    @RequestMapping("/initBbManage")
    public String initBbManage(){
        return "/consumables/BbManage";
    }

    @ResponseBody
    @RequestMapping("/addBd")
    public String addBd(HttpServletRequest request){
        BdDao bdDao =new BdDao();
        BcDao bcDao = new BcDao();
        try {
            bcDao.setBc01(request.getParameter("bd12"));
            List<BcDao> bcDaos = consumablesService.queryBc(bcDao);
            bdDao.setBd03(bcDaos.get(0).getBc02());
            bdDao.setBd04(bcDaos.get(0).getBc03());
            bdDao.setBd02(request.getParameter("bd02"));
            bdDao.setBd05(request.getParameter("bd05"));
            bdDao.setBd06(request.getParameter("bd06"));
            bdDao.setBd07(request.getParameter("bd07"));
            bdDao.setBd08(request.getParameter("bd08"));
            bdDao.setBd09(request.getParameter("bd09"));
            bdDao.setBd10(request.getParameter("bd10"));
            bdDao.setBd11(request.getParameter("bd11"));
            bdDao.setBd12(request.getParameter("bd12"));
            double i = Double.parseDouble(bdDao.getBd07());
            double j = Double.parseDouble(bcDaos.get(0).getBc05());
            j = i + j;
            bcDao.setBc05(j + "");
            consumablesService.modifyBc05(bcDao);
            consumablesService.addBd(bdDao);
            return "建账成功";
        }catch (Exception e){
            return "建账失败，请检查数据格式或者联系管理员!";
        }
    }
    @RequestMapping("/querybc")
    public String querybc(){
        return "/consumables/queryBc";
    }

    @RequestMapping("/initAddbe")
    public String initAddbe(){
        return "/consumables/addBe";
    }

    @ResponseBody
    @RequestMapping("/addBe")
    public String addBe(HttpServletRequest request){
        BeDao beDao =new BeDao();
        BcDao bcDao = new BcDao();
        try {
            bcDao.setBc01(request.getParameter("bd12"));
            List<BcDao> bcDaos = consumablesService.queryBc(bcDao);
            beDao.setBe02(request.getParameter("be02"));
            beDao.setBe03(bcDaos.get(0).getBc02());
            beDao.setBe12(bcDaos.get(0).getBc03());
            beDao.setBe04(request.getParameter("be04"));
            beDao.setBe05(request.getParameter("be05"));
            beDao.setBe07(request.getParameter("be07"));
            beDao.setBe08(request.getParameter("be08"));
            beDao.setBe09(request.getParameter("be09"));
            beDao.setBe11(request.getParameter("be11"));
            beDao.setBe10("");
            BasicInfoDao basicInfoDao = new BasicInfoDao();
            basicInfoDao.setAa01(request.getParameter("be06"));
            basicInfoDao = labInfoService.selctLabInfoByAA01(basicInfoDao);
            String name = basicInfoDao.getAa09();//差个借口调用名字
            beDao.setBe10(name);
            beDao.setBe06(basicInfoDao.getAa08());
            double i = Double.parseDouble(beDao.getBe05());
            double j = Double.parseDouble(bcDaos.get(0).getBc05());
            System.out.println("I："+i+"||j:"+j);
            if (j >= i) {
                j = j - i;
                System.out.println(j);
                bcDao.setBc05(j + "");
                consumablesService.modifyBc05(bcDao);
                consumablesService.addBe(beDao);
                return "领用登记成功！";
            } else {
                return "领用数量大于库存，失败！";
            }
        }catch (Exception e){
            return "error,请检查数据或者联系管理员";
        }


    }

    @ResponseBody
    @RequestMapping("/queryBe")
    public List<BeDao> queryBe(HttpServletRequest request){
        BeDao beDao=new BeDao();
       beDao.setBe11(request.getParameter("be11"));
        return consumablesService.queryBe(beDao);


    }

    @ResponseBody
    @RequestMapping("/queryBd")
    public List<BdDao> queryBd(HttpServletRequest request){
        BdDao bdDao=new BdDao();
       bdDao.setBd11(request.getParameter("bd11"));
        return consumablesService.queryBd(bdDao);
    }

    @ResponseBody
    @RequestMapping("/queryBb")
    public List<BbDao> queryBb(HttpServletRequest request){
        BbDao bbDao = new BbDao();
        bbDao.setBb14(request.getParameter("bb14"));
        bbDao.setBb17(request.getParameter("bb17"));
        return consumablesService.queryBb(bbDao);
    }

    @ResponseBody
    @RequestMapping("/queryBB14")
    public List<String> queryBB14(){
      return consumablesService.queryBB14();
    }

    @ResponseBody
    @RequestMapping("/queryBD11")
    public List<String> queryBD11(){
        return consumablesService.queryBD11();
    }

    @ResponseBody
    @RequestMapping("/queryBE11")
    public List<String> queryBE11(){
        return consumablesService.queryBE11();
    }

    @ResponseBody
    @RequestMapping("/queryBC06")
    public String queryBC06(String bc01){
      BcDao bcDao=new BcDao();
      bcDao.setBc01(bc01);
      List<BcDao> bcDaos=consumablesService.queryBc(bcDao);
      return bcDaos.get(0).getBc06();
    }

    @RequestMapping("/isLeaf")
    @ResponseBody
    public String isLeaf(String bb01){
        BbDao bbDao=new BbDao();
        bbDao.setBb01(bb01);
        List<BbDao> bbDaos= consumablesService.queryBb(bbDao);
        String leaf=bbDaos.get(0).getBb17();
        if("未处理".equals(leaf)){
            return "1";
        }else{
            return "0";
        }
    }
    @RequestMapping("/modifyBb17")
    @ResponseBody
    public String modifyBb17(String bb01,String bb17){
        BbDao bbDao=new BbDao();
        bbDao.setBb01(bb01);
        bbDao.setBb17(bb17);
        try {
            consumablesService.modifyBb17(bbDao);
        }catch (Exception e){
            return "处理失败";
        }
        return "处理成功";
    }


}
