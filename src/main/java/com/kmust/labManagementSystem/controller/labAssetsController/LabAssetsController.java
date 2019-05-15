package com.kmust.labManagementSystem.controller.labAssetsController;

import com.kmust.labManagementSystem.dao.*;

import com.kmust.labManagementSystem.service.LabInfoService;
import com.kmust.labManagementSystem.service.impl.LabAssetsServiceImpl;
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
@RequestMapping("/labAssets")
public class LabAssetsController {
    @Autowired
    private LabAssetsServiceImpl labAssetsService;
    @Autowired
    private LabInfoServiceImpl labInfoService;
    /**
     * 资产添加
     * @return
     */
    @RequestMapping("/initAdd")
    public String initAdd(){
        return "/labAssets/addLabAssets";
    }

    /**
     * 添加资产
     * @param request
     * @return
     */
    @RequestMapping("/addAssets")
    @ResponseBody
    public String add(HttpServletRequest request){
        LabAssetsDao labAssetsDao=new LabAssetsDao();
        String lab[] =new String[18];
        String b;
        for(int i=2;i<18;i++){
            b=i+"";
            if(i<10){
                b="0"+i;
            }
            lab[i]=request.getParameter("ab"+b);
        }
        labAssetsDao.setAb02(lab[2]);
        labAssetsDao.setAb03(lab[3]);
        labAssetsDao.setAb04(lab[4]);
        labAssetsDao.setAb05(lab[5]);
        labAssetsDao.setAb06(lab[6]);
        labAssetsDao.setAb07(lab[7]);
        labAssetsDao.setAb08(lab[8]);
        labAssetsDao.setAb09(lab[9]);
        labAssetsDao.setAb10(lab[10]);
        labAssetsDao.setAb11(lab[11]);
        labAssetsDao.setAb12(lab[12]);
        labAssetsDao.setAb13(lab[13]);
        labAssetsDao.setAb14(lab[14]);
        labAssetsDao.setAb15(lab[15]);
        labAssetsDao.setAb16(lab[16]);
        labAssetsDao.setAb17(lab[17]);
        try{
            labAssetsService.addAssets(labAssetsDao);
        }catch (Exception e){
            return "添加失败，原因可能是资产条码重复";
        }

         return "添加成功";
    }
    @RequestMapping("/initMaintain")
    public String initMaintain(){
        return "/labAssets/maintainAssets";
    }

    /**
     * 资产查询
     * @param request
     * @return
     */
    @RequestMapping("/queryAssets")
    @ResponseBody
    public List<LabAssetsDao> queryAssets(HttpServletRequest request){
        LabAssetsDao labAssetsDao=new LabAssetsDao();
        labAssetsDao.setAb04(request.getParameter("ab04"));
        labAssetsDao.setAb14(request.getParameter("ab14"));
        return labAssetsService.queryAll(labAssetsDao);
    }

    /**
     * 管理人变更
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/ModifyAb14")
    public String ModifyAb14(HttpServletRequest request){
        LabAssetsDao labAssetsDao=new LabAssetsDao();
        labAssetsDao.setAb01(request.getParameter("ab01"));
        labAssetsDao.setAb14(request.getParameter("ab14"));
        labAssetsDao.setAb15(request.getParameter("ab15"));
        labAssetsService.ModifyAb14(labAssetsDao);
        return "变更成功";
    }

    /**
     * 条码申请页面
     * @return
     */
    @RequestMapping("/initCodeMissing")
    public String initCodeMissing(){
        return "/labAssets/codeMissing";
    }

    /**
     * 资产清点页面
     * @return
     */
    @RequestMapping("/initInventory")
    public String initInventory(){
        return "/labAssets/inventory";
    }

    /**
     * 问题反馈页面
     * @return
     */
    @RequestMapping("/initFeedback")
    public String initFeedback(){
        return "/labAssets/feedback";
    }

    /**
     * 问题反馈
     * @param request
     * @return
     */
    @RequestMapping("/feedback")
    @ResponseBody
    public String feedback(HttpServletRequest request){
        /**
         * 此处差一个添加反馈人id
         */
        AcDao acDao=new AcDao();
        acDao.setAc02("");//问题反馈人？？？
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        acDao.setAc03(request.getParameter("ac03"));
        acDao.setAc05(df.format(new Date()));
        labAssetsService.addFeedback(acDao);
        return  "反馈成功";
    }

    /**
     * 申请条码
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/ApplyNewCode")
    public String addAd(HttpServletRequest request){
        AdDao adDao=new AdDao();
        adDao.setAd02("");//申请人编号  ？？？？
        adDao.setAd03(request.getParameter("ab01"));
        adDao.setAd05(request.getParameter("ad05"));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        adDao.setAd06(df.format(new Date()));
        labAssetsService.addAd(adDao);
        return "申请发起成功!";
    }

    /**
     * 条码申请处理
     * @return
     */
    @RequestMapping("/initCodeMissingShow")
    public String initCodeMissingShow(){
        return "/labAssets/codeMissingShow";
    }
    /**
     * 问题反馈查看
     * @return
     */
    @RequestMapping("/initFeedbackShow")
    public String initFeedbackShow(){
        return "/labAssets/feedbackShow";
    }
    @ResponseBody
    @RequestMapping("/queryCodeMissing")
    public List<AdDao> queryCodeMissing(HttpServletRequest request){
        AdDao adDao =new AdDao();
        adDao.setAd04New(request.getParameter("ad04"));
        return labAssetsService.queryCodeMissing(adDao);
    }

    @ResponseBody
    @RequestMapping("/AddNewCode")
    public String AddNewCode(HttpServletRequest request){
        String ad01=request.getParameter("ad01");
        String ab05=request.getParameter("ab05");
        AdDao adDao=new AdDao();
        adDao.setAd01(ad01);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        List<AdDao> adDaos=labAssetsService.queryCodeMissingByAd01(adDao);
        adDao.setAd07(df.format(new Date()));

        String ab01= adDaos.get(0).getAd03();
        LabAssetsDao labAssetsDao=new LabAssetsDao();
        labAssetsDao.setAb01(ab01);
        LabAssetsDao newL=labAssetsService.queryAssetsByAb01(labAssetsDao);
        labAssetsDao.setAb05(ab05);
        labAssetsDao.setAb17(newL.getAb05());
        labAssetsService.setAd04(adDao);
        return "处理成功";
    }
    @ResponseBody
    @RequestMapping("/isLeaf")
    public String isLeaf(HttpServletRequest request){
        AdDao adDao=new AdDao();
        adDao.setAd01(request.getParameter("ad01"));
        List<AdDao> adDaos=labAssetsService.queryCodeMissingByAd01(adDao);
        String ad04= adDaos.get(0).getAd04();
        System.out.println(ad04);
        if("已处理".equals(ad04)||ad04=="已处理"){
            return "0";
        }
        return "1";
    }

    @ResponseBody
    @RequestMapping("/queryFeedback")
    public List<AcDao> queryFeedback(HttpServletRequest request){
        AcDao acDao=new AcDao();
        acDao.setAc04New(request.getParameter("ac04"));
        return labAssetsService.queryAc(acDao);
    }

    @ResponseBody
    @RequestMapping("/modifyIsleaf")
    public String modifyIsleaf(HttpServletRequest request){
        AcDao acDao=new AcDao();
        acDao.setAc01(request.getParameter("ac01"));
        labAssetsService.setAc04(acDao);
        return "操作成功";
    }
    @ResponseBody
    @RequestMapping("/isLeaf2")
    public String isLeaf2(HttpServletRequest request){
        AcDao acDao=new AcDao();
        acDao.setAc01(request.getParameter("ac01"));
        AcDao acDao1=new AcDao();
        acDao1=labAssetsService.getAcDaoByac01(acDao);
        if(acDao1.getAc04()=="已查阅"||"已查阅".equals(acDao1.getAc04())){
            return "0";
        }
        return "1";
    }

    @RequestMapping("/initAssestInAndOut")
    public String initAssestInAndOut(){
        return "/labAssets/AssestInAndOut";
    }

    @ResponseBody
    @RequestMapping("/addBs")
    public String addBs(String bs02,String bs08,String bs05,String ab04,String ab05){
        BsDao bsDao=new BsDao();
        bsDao.setBs02(bs02);
        bsDao.setBs08(bs08);
        bsDao.setBs05(bs05);

        BasicInfoDao basicInfoDao=new BasicInfoDao();
        basicInfoDao.setAa01(ab04);
        String bs03=labInfoService.selctLabInfoByAA01(basicInfoDao).getAa08();
        basicInfoDao.setAa01(ab05);
        String bs04=labInfoService.selctLabInfoByAA01(basicInfoDao).getAa08();
        if(bs03.equals(bs04)){
            return "失败，原因是对象与目标相同";
        }else{
            bsDao.setBs03(bs03);
            bsDao.setBs04(bs04);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            bsDao.setBs06(df.format(new Date()));
            labAssetsService.addBs(bsDao);
            return "借出登记成功";
        }
    }

    @RequestMapping("/querybs")
    @ResponseBody
    public List<BsDao> querybs(String bs03){
        BsDao bsDao=new BsDao();
        if(bs03!=null&&bs03!=""){
            BasicInfoDao basicInfoDao=new BasicInfoDao();
            basicInfoDao.setAa01(bs03);
            bs03=labInfoService.selctLabInfoByAA01(basicInfoDao).getAa08();
            bsDao.setBs03(bs03);
        }
        return labAssetsService.querybs(bsDao);
    }

    @ResponseBody
    @RequestMapping("/isLeafBs07")
    public String isLeafBs07(String bs01){
        BsDao bsDao=new BsDao();
        bsDao.setBs01(bs01);
        bsDao=labAssetsService.queryBsByBs01(bsDao);
        if(bsDao.getBs07()==null||"".equals(bsDao.getBs07())){
            return "1";
        }
        return "0";
    }

    @RequestMapping("/modifyBs07")
    @ResponseBody
    public String modifyBs07(String bs01){
        BsDao bsDao=new BsDao();
        bsDao.setBs01(bs01);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        bsDao.setBs07(df.format(new Date()));
        labAssetsService.modifyBs07(bsDao);
        return "归还成功";
    }

}
