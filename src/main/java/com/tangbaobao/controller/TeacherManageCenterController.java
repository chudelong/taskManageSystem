package com.tangbaobao.controller;

import com.tangbaobao.pojo.Teacher;
import com.tangbaobao.service.TeacherManageCenterService;
import com.tangbaobao.vo.CourseAndCount;
import com.tangbaobao.vo.SubmitTaskInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

/**
 * 教师管理中心
 *
 * @author 唐学俊
 * @create 2018/04/30
 **/
@Controller
@RequestMapping("/teacher")
public class TeacherManageCenterController {
    @Autowired
    TeacherManageCenterService teacherManageCenterService;

    @RequestMapping("/manageCenter.action")
    public String showCourse(@SessionAttribute Teacher teacher, ModelMap map) {
        //卡片信息封装
        List<CourseAndCount> courseAndCountList = teacherManageCenterService.findAllCource(teacher);
        map.addAttribute("courseAndCountList",courseAndCountList);

        //表格信息封装
        List<SubmitTaskInfo> submitTaskInfoList = teacherManageCenterService.findAllSubmitInfo(teacher);
        map.addAttribute("submitListInfo",submitTaskInfoList);
        return "/teacher/manageCenter";
    }

}
