package com.tangbaobao.controller;

import com.tangbaobao.pojo.Course;
import com.tangbaobao.pojo.Student;
import com.tangbaobao.pojo.Task;
import com.tangbaobao.pojo.Work;
import com.tangbaobao.service.StudentSubmitTaskService;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 学生提交作业控制器
 *
 * @author 唐学俊
 * @create 2018/04/19
 **/
@Controller
public class StudentSubmitTaskController {

    /**
     * 注入service
     */
    @Autowired
    private StudentSubmitTaskService studentSubmitTaskService;


    /**
     * 对submitTask试图映射
     *
     * @return
     */
    @RequestMapping("/student/submitTask.do")
    public String submitTask() {
        return "submitTask";
    }

    /**
     * ajax加载所有课程
     *
     * @return
     */
    @RequestMapping("/student/getAllCourse.action")
    public
    @ResponseBody
    List<Course>
    findAllCourse(@SessionAttribute Student student) {
        List<Course> courseList = studentSubmitTaskService.getAllCourse(student);
        return courseList;
    }

    @RequestMapping("/student/getTaskByCourseId.action")
    public @ResponseBody
    List<Task>
    getAllTaskByCourseId(int courseId,@SessionAttribute Student student) {
        System.out.println(courseId);
        return studentSubmitTaskService.getAllTaskByCourseId(courseId,student);
    }


    @RequestMapping("/student/checkDeadLine.action")
    public
    @ResponseBody Date checkDeadLine(int taskId){
        Date deadLine = studentSubmitTaskService.checkDeadLine(taskId);
        return deadLine;
    }

    @RequestMapping("/student/submitTask.action")
    public
    @ResponseBody void submitTask(MultipartFile uploadFile, Work work,@SessionAttribute Student student, HttpServletResponse response) {
       studentSubmitTaskService.submitTask(uploadFile, work,student);
        try {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("<script>alert('提交成功!');window.location.href='/student/submitTask.do'</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
