package com.kmust.labManagementSystem.controller.basicInfoController;

import com.kmust.labManagementSystem.dao.BasicInfoDao;
import com.kmust.labManagementSystem.dao.BfDao;
import com.kmust.labManagementSystem.service.impl.LabInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 实验室基础信息
 */
@Controller
@RequestMapping("/LabInfo")
public class BasicInfoController {
    @Autowired
    private LabInfoServiceImpl labInfoService;

    @RequestMapping("/init")
    public String init(){
        return "/addBasicinfo";
    }

    @RequestMapping("/addBasicInfo01")
    @ResponseBody
    public String addBasicInfo01(String aa02, String aa04, String aa03, String aa05, String aa06,
                                       String aa07,String aa09, ModelMap modleMap){
           BasicInfoDao basicInfoDao=new BasicInfoDao();
           basicInfoDao.setAa02(aa02);
           basicInfoDao.setAa03(aa03);
           basicInfoDao.setAa04(aa04);
           basicInfoDao.setAa05(aa05);
           basicInfoDao.setAa06(aa06);
           basicInfoDao.setAa07(aa07);
           basicInfoDao.setAa09(aa09);
           if(aa02!=null&&aa03!=null&&aa04!=null&&aa03.matches("\\d+")&&aa04.matches("\\d+")&&aa06.matches("\\d+")&&labInfoService.selectLabInfoByNew(basicInfoDao)==null){
               labInfoService.addLabInfo(basicInfoDao);
               //System.out.println(basicInfoDao);
               return "添加成功";
           }
          return "添加失败，原因可能是已有此实验室或者数据格式不对";
    }

    @RequestMapping("/initModify")
    public String initModify(){
        return "/modifyLabInfo";
    }

    @RequestMapping("/getAllInfo")
    @ResponseBody
    public List<BasicInfoDao> getAllInfo(String aa02,String aa03){
        BasicInfoDao basicInfoDao=new BasicInfoDao();
        basicInfoDao.setAa02(aa02);
        basicInfoDao.setAa03(aa03);
        System.out.println(basicInfoDao);
        return labInfoService.selctSomeLabInfo(basicInfoDao);
    }
//根据序号查询实验室
    @RequestMapping("/getLabInfoByAA01")
    @ResponseBody
    public BasicInfoDao getLabInfoByAA01(String aa01){
        BasicInfoDao basicInfoDao=new BasicInfoDao();
        basicInfoDao.setAa01(aa01);
        return labInfoService.selctLabInfoByAA01(basicInfoDao);
    }

//修改实验室信息
    @ResponseBody
    @RequestMapping("/ModifyLabInfoByAA01")
    public String ModifyLabInfoByAA01(String aa01,String aa05,String aa06,String aa07,String aa09){
        BasicInfoDao basicInfoDao=new BasicInfoDao();
        basicInfoDao.setAa01(aa01);
        basicInfoDao.setAa05(aa05);
        basicInfoDao.setAa06(aa06);
        basicInfoDao.setAa07(aa07);
        basicInfoDao.setAa09(aa09);
        labInfoService.modifyLabInfo(basicInfoDao);
        return "修改成功";
    }

    @RequestMapping("/initBorrow")
    public String initBorrow(){
        return "/borrow";
    }
    @RequestMapping("/addBorrow")
    @ResponseBody
    public String addBorrow(String bf02,String bf07,String ab04,String bf08){
        BfDao bfDao=new BfDao();
        bfDao.setBf02(bf02);
        bfDao.setBf07(bf07);
        bfDao.setBf08(bf08);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        bfDao.setBf05(df.format(new Date()));
        BasicInfoDao basicInfoDao=new BasicInfoDao();
        basicInfoDao.setAa01(ab04);
        BasicInfoDao basicInfoDao1=labInfoService.selctLabInfoByAA01(basicInfoDao);
        bfDao.setBf04(basicInfoDao1.getAa08());
        String bf09=basicInfoDao1.getAa09();
        bfDao.setBf03(bf09);//需要一个接口查询是谁
        labInfoService.addBorrow(bfDao);
        return "借用登记成功";
    }

    @ResponseBody
    @RequestMapping("/querybf")
    public List<BfDao> querybf(String bf06){
        BfDao bfDao=new BfDao();
        bfDao.setBf06(bf06);
        return labInfoService.queryBf(bfDao);
    }

    @RequestMapping("/isLeafBf06")
    @ResponseBody
    public String isLeafBf06(String bf01){
        BfDao bfDao=new BfDao();
        bfDao.setBf01(bf01);
        bfDao=labInfoService.selectBfByBf01(bfDao);
        if("".equals(bfDao.getBf06())||bfDao.getBf06()==null){
            return "1";
        }else{
            return "0";
        }
    }

    @ResponseBody
    @RequestMapping("/modifyBf06")
    public String modifyBf06(String bf01){
        BfDao bfDao=new BfDao();
        bfDao.setBf01(bf01);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        bfDao.setBf06(df.format(new Date()));
        labInfoService.ModifyBf06(bfDao);
        return "归还成功！";
    }

}
