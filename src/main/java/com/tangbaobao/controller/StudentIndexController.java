package com.tangbaobao.controller;

import com.tangbaobao.pojo.Student;
import com.tangbaobao.service.StudentCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

/**
 * 学生个人中心控制器
 *
 * @author 唐学俊
 * @create 2018/04/14
 **/
@Controller
public class StudentIndexController {
    /**
     * 注入service
     */
    @Autowired
    StudentCenterService studentCenterService;

    @RequestMapping("/student/index.action")
    public String getStudentInfo(HttpSession session, Model map,@SessionAttribute Student student) {
        //1.显示个人资料
        Student studentReturn = studentCenterService.getStudentInfo(student);
        //2.显示提交作的数量
        int submittedTask = studentCenterService.countSubmitted(student);

        //待提交作业数量
        int totalTask = studentCenterService.countTask(student);
        //3.显示以经提交作业的数量
        map.addAttribute("student",studentReturn);
        map.addAttribute("submittedTask",submittedTask);
        map.addAttribute("totalTask",totalTask);
        return "index";
    }
}
