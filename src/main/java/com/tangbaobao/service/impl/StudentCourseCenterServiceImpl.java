package com.tangbaobao.service.impl;

import com.tangbaobao.dao.StudentCourseCenterDao;
import com.tangbaobao.pojo.Course;
import com.tangbaobao.pojo.Student;
import com.tangbaobao.pojo.Task;
import com.tangbaobao.service.StudentCourseCenterService;
import com.tangbaobao.common.SessionManage;
import com.tangbaobao.vo.CourseAndCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 唐学俊
 * @create 2018/04/17
 **/
@Service
public class StudentCourseCenterServiceImpl implements StudentCourseCenterService {

    @Autowired
    private StudentCourseCenterDao studentCourseCenterDao;

    //@Override
    public List<CourseAndCount> getCourseAndCount(Student student) {
        //初始化接受容器
        List<CourseAndCount> courseAndCountList = new ArrayList<>();
        String studentNo = student.getStudentNo();
        //获取该学生的课程
        List<Course> courseList = studentCourseCenterDao.getCourseCategory(studentNo);


        for (Course course : courseList) {
            CourseAndCount courseAndCount = new CourseAndCount();
            //获取该没门课程未提交的数
            int count = studentCourseCenterDao.getCourseCategoryCount(studentNo, course.getCourseId());
            //对数量进行封装,并加入集合
            courseAndCount.setCourse(course);
            courseAndCount.setCount(count);
            courseAndCountList.add(courseAndCount);
        }
        return courseAndCountList;
    }

    @Override
    public List<Task> getAllTask(Student student) {
       return this.getAllTask(null,student);
    }

    @Override
    public List<Task> getAllTask(Integer courseId,Student student) {

        return studentCourseCenterDao.getAllTask(student.getStudentNo(),courseId);
    }
}
