package com.tangbaobao.controller;

import com.tangbaobao.pojo.Teacher;
import com.tangbaobao.service.TeacherIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

/**
 * 教师首页
 *
 * @author 唐学俊
 * @create 2018/04/30
 **/
@Controller
@RequestMapping("/teacher")
public class TeacherIndexController {
    @Autowired
    TeacherIndexService teacherIndexService;

    @RequestMapping("/index.action")
    public String teacherIndex(@SessionAttribute Teacher teacher, ModelMap map) {
        //1.教师信息
        Teacher teacherInfo = teacherIndexService.getTeacherInfo(teacher.getTeacherNo());
        map.addAttribute("teacherInfo",teacherInfo);
        return "/teacher/index";
    }
}
