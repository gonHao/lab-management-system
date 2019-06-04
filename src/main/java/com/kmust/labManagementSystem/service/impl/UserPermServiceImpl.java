package com.kmust.labManagementSystem.service.impl;

import com.kmust.labManagementSystem.dao.UserInfo;
import com.kmust.labManagementSystem.dao.userDao.ModuleInfo;
import com.kmust.labManagementSystem.dao.userDao.UserModuleMap;
import com.kmust.labManagementSystem.dao.userDao.UserPerission;
import com.kmust.labManagementSystem.mapper.labMapper.UserMapper;
import com.kmust.labManagementSystem.mapper.userMapper.ModuleInfoMapper;
import com.kmust.labManagementSystem.mapper.userMapper.UserModuleMapMapper;
import com.kmust.labManagementSystem.service.UserPermService;
import com.kmust.labManagementSystem.service.UserService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserPermServiceImpl implements UserPermService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserModuleMapMapper userModuleMapMapper;
    @Autowired
    private ModuleInfoMapper moduleInfoMapper;
    @Autowired
    private UserService userService;


    @Override
    public List<String> selectByUserNm(String username) {
        List<String> list = moduleInfoMapper.selectByUserNm(username);
        System.out.println("用户权限：" + list);
        return list;
    }

    /**
     * 根据输入信息组，查询多个用户信息，以list返回
     *
     * @param map
     * @return List<UserPerission>
     */
    @Override
    public List<UserPerission> findUserPerm(Map<String, String> map) {
        List<UserInfo> userInfoList = userMapper.findUserInfo(map);
        List<UserPerission> userPerissionList = new ArrayList<>();
        for (UserInfo a : userInfoList) {
            UserPerission userPerission = new UserPerission();
            userPerission.setUserNm(a.getUserNm());
            userPerission.setName(a.getName());
            userPerission.setCreateDate(a.getCreateDate());
            userPerission.setNote(a.getNote());
            List<String> userPermList = moduleInfoMapper.selectByUserNm(a.getUserNm());
            userPerission.setUserModule(userPermList);
            userPerissionList.add(userPerission);
        }
        return userPerissionList;
    }

    @Override
    public boolean addUserPermission(UserPerission userPerission) {
        try {
            List<String> moduleList = userPerission.getUserModule();
            for (String str : moduleList) {
                UserModuleMap userModuleMap = new UserModuleMap();
                userModuleMap.setUserNm(userPerission.getUserNm());
                if (str != null && str != "") {
                    ModuleInfo moduleInfo = moduleInfoMapper.selectByModuleNm("ROLE_" + str);
                    userModuleMap.setModuleId(moduleInfo.getModuleId());
                    userModuleMapMapper.addMap(userModuleMap);
                }

            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteUsers(String[] arr) {
        for (String userNm : arr) {
            return userMapper.deleteUser(userNm) == 1;
        }
        return false;

    }

    @Override
    public boolean updateUsers(UserPerission userPerission) {
        List<UserModuleMap> list = userModuleMapMapper.selectByUserNm(userPerission.getUserNm());
        UserInfo userInfo = new UserInfo();
        userInfo.setUserNm(userPerission.getUserNm());
        userInfo.setUserType(userPerission.getUserType());
        userInfo.setName(userPerission.getName());
        userInfo.setState(userPerission.getState());
        userInfo.setNote(userPerission.getNote());
        if (userMapper.updateInfo(userInfo) != 1) {
            return false;
        }
        for (UserModuleMap umm : list) {
            if (userModuleMapMapper.deleteMap(umm) != 1) {
                return false;
            }
        }
        if (addUserPermission(userPerission)) {
            return true;
        }
        return false;
    }

    @Override
    public String addUsersByExcel(MultipartFile mFile) throws IOException {
        Workbook workbook = null;
        String fileName =  mFile.getOriginalFilename();
        assert fileName != null;
        String[] arr = fileName.split("\\.");
        for (String anArr : arr) {
            logger.info("得到文件名：" + anArr);
        }
        switch (arr[arr.length - 1]) {
            case "xls":   //Excel 2003
                workbook = new HSSFWorkbook(mFile.getInputStream());
                break;
            case "xlsx":   // Excel 2007/2010
                workbook = new XSSFWorkbook(mFile.getInputStream());
                break;
            default:
                return "文件格式不对";
        }
        int sheetCount = workbook.getNumberOfSheets();
        Sheet sheet = workbook.getSheetAt(0);
        int count = 1;
        for(Row row:sheet){
            if(count<=1){
                count++;
                continue;
            }
            try{
                if(row.getCell(0)==null){
                    return"用户新增完成";
                }
                //获取总列数(空格的不计算)
                int columnTotalNum = row.getPhysicalNumberOfCells();
                logger.info("总列数：" + columnTotalNum);
                logger.info("最大列数：" + row.getLastCellNum());


                UserPerission userPerission = new UserPerission();

                String userNm = getCellValue(row,0);
                if(userNm==null||"".equals(userNm)){
                    return "第"+count+"行，第1格为空，后续用户信息新增失败";
                }
                userPerission.setUserNm(userNm);
                String name = getCellValue(row,1);
                if(name==null||"".equals(name)){
                    return "第"+count+"行，第2格为空，后续用户信息新增失败";
                }
                userPerission.setName(name);
                String ut = getCellValue(row,2);
                if(ut==null||"".equals(ut)){
                    return "第"+count+"行，第3格为空，后续用户信息新增失败";
                }
                userPerission.setUserType(ut);
                ArrayList<String> moduleList = new ArrayList<>(8);
                if(("管理员").equals(ut)){
                    moduleList.add("admin");
                    moduleList.add("consumable");
                    moduleList.add("assets");
                    moduleList.add("baseInfo");
                    moduleList.add("key");
                    moduleList.add("checkTable");
                    moduleList.add("teachingAdmin");
                    moduleList.add("simulate");
                    userPerission.setUserModule(moduleList);
                }else if(("老师").equals(ut)){
                    moduleList.add("consumable");
                    moduleList.add("assets");
                    moduleList.add("baseInfo");
                    moduleList.add("key");
                    moduleList.add("checkTable");
                    moduleList.add("teachingAdmin");
                    moduleList.add("simulate");
                    userPerission.setUserModule(moduleList);
                }else if(("学生").equals(ut)){
                    moduleList.add("baseInfo");
                    moduleList.add("key");
                    moduleList.add("simulate");
                    userPerission.setUserModule(moduleList);
                }else {
                    return "第"+count+"行，不存在该用户类型";
                }
                String state = getCellValue(row,3);;
                if(state==null||"".equals(state)){
                    return "第"+count+"行，第4格为空，后续用户信息新增失败";
                }
                userPerission.setState(state);
                String note = getCellValue(row,4);;
                userPerission.setNote(note);
                if(!userService.addUser(userPerission)){
                    return"第"+count+"行用户信息添加失败";
                }
                if(!addUserPermission(userPerission)){
                    return"第"+count+"行用户权限添加失败";
                }
            }catch (Exception e){
                e.printStackTrace();
                return "执行第"+count+"行程序出现异常，后续用户信息新增失败";
            }

        }
        return "所有用户信息新增成功";
    }

    private String getCellValue(Row row,int n){
        Cell cell = row.getCell(n);
        if(cell==null){
            return "";
        }
        cell.setCellType(CellType.STRING);
        return cell.getStringCellValue();
    }

}

