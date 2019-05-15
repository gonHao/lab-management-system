package com.kmust.labManagementSystem.controller.teachingManagement;

import com.kmust.labManagementSystem.dao.teachingManagementDao.ClassProject;
import com.kmust.labManagementSystem.dao.userDao.UserPerission;
import com.kmust.labManagementSystem.service.ClassProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/class")
public class ClassPorjectControler {
    @Autowired
    private ClassProService classProService;

    @RequestMapping("/classPro")
    public String timeTable(){
        return "/timeTables/classProject";
    }

    @RequestMapping(value = "/findClassPro",method = RequestMethod.GET)
    @ResponseBody
    public List<ClassProject> findClassPro(@RequestParam String courseName){
        return classProService.selectByCourseName(courseName);
    }

    @RequestMapping("/deleteClassPro")
    @ResponseBody
    public String deleteClassPro(@RequestBody String[] arr) {
        System.out.println("进入删除操作：" + arr[0]);
        if (classProService.deleteClassPro(arr)) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @RequestMapping("/updateClassPro")
    @ResponseBody
    public String updateUser(@RequestBody ClassProject formDate) {
        if (classProService.updateClassPro(formDate)) {
            return "修改课程信息成功";
        }
        return "修改课程信息失败";
    }
    @RequestMapping("/addClassPro")
    @ResponseBody
    public String addClassPro(@RequestBody ClassProject formDate) {
        if (classProService.addClassPro(formDate)) {
            return "修改课程信息成功";
        }
        return "修改课程信息失败";
    }
}
