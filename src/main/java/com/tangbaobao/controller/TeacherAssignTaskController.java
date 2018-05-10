package com.tangbaobao.controller;

import com.tangbaobao.pojo.Course;
import com.tangbaobao.pojo.Task;
import com.tangbaobao.pojo.Teacher;
import com.tangbaobao.pojo.Type;
import com.tangbaobao.service.TeacherAssignTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.Date;
import java.util.List;

/**
 * @author 唐学俊
 * @create 2018/04/21
 * 教师发布作业控制器
 **/
@Controller
@RequestMapping("/teacher")
public class TeacherAssignTaskController {


    @Autowired
    TeacherAssignTaskService teacherAssignTaskService;

    @RequestMapping("/assignTask.do")
    public String assignTask() {
        return "teacher/assignTask";
    }

    /**
     * Ajax根据该教师加其课程
     *
     * @return
     */
    @RequestMapping("/loadAllCourse.action")
    public
    @ResponseBody
    List<Course> loadAllCourse(@SessionAttribute Teacher teacher) {
        List<Course> courseList = teacherAssignTaskService.loadAllCourse(teacher);
        return courseList;

    }


    @RequestMapping("/loadAllCourseByCourseId.action")
    public
    @ResponseBody
    List<Type> loadAllCourseByCourseId() {
        return teacherAssignTaskService.loadAllCourseByCourseId();
    }

    /**
     * 布置作业
     *
     * @param
     * @return
     */
    @RequestMapping("/assignTask.action")
    public
    void assingTask(Task task) {
        System.out.println(task);
        boolean isAssignSuccessful = teacherAssignTaskService.assignTask(task);
    }


}
