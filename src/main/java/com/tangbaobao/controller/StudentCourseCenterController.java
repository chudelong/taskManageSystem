package com.tangbaobao.controller;

import com.tangbaobao.pojo.Course;
import com.tangbaobao.pojo.Student;
import com.tangbaobao.pojo.Task;
import com.tangbaobao.service.StudentCourseCenterService;
import com.tangbaobao.vo.CourseAndCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

/**
 * 学生课程中心
 *
 * @author 唐学俊
 * @create 2018/04/16
 **/
@Controller
public class StudentCourseCenterController {
    /**
     * 注入service
     */
    @Autowired
    StudentCourseCenterService studentCourseCenterService;

    /**
     * 普通加载该学生的所有Task
     *
     * @param map
     * @return
     */
    @RequestMapping("/student/courseCenter.action")
    public String getCourseAndCount(ModelMap map,@SessionAttribute Student student) {

        //给页面加入作业类型和提交数量
        List<CourseAndCount> courseAndCountList = studentCourseCenterService.getCourseAndCount(student);
        map.addAttribute("AllCourse", courseAndCountList);

        //给页面加入所有作业以及提交信息
        List<Task> taskList = studentCourseCenterService.getAllTask(student);
        map.addAttribute("allTaskInfos", taskList);
        return "courseCenter";
    }

    @RequestMapping("/student/getAllTaskByCourseId.action")
    public
    @ResponseBody
    List<Task> getTaskByCourseId(int courseId, @SessionAttribute Student student) {
        return studentCourseCenterService.getAllTask(courseId,student);
    }


}
