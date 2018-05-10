package com.tangbaobao.service.impl;

import com.tangbaobao.dao.TeacherManageCenterDao;
import com.tangbaobao.pojo.Course;
import com.tangbaobao.pojo.Teacher;
import com.tangbaobao.service.TeacherManageCenterService;
import com.tangbaobao.vo.CourseAndCount;
import com.tangbaobao.vo.SubmitTaskInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 唐学俊
 * @create 2018/04/30
 **/
@Service
public class TeacherManageCenterServiceImpl implements TeacherManageCenterService {
    @Autowired
    TeacherManageCenterDao teacherManageCenterDao;

    @Override
    public List<CourseAndCount> findAllCource(Teacher teacher) {

        List<CourseAndCount> courseAndCountList = new ArrayList<>();
        //查询该教师的所有课程
        List<Course> courseList = teacherManageCenterDao.findAllCourse(teacher.getTeacherNo());
        for (Course course : courseList) {
            //对course和数量进行封装
            CourseAndCount courseAndCount = new CourseAndCount();
            courseAndCount.setCount(teacherManageCenterDao.findCountByCourseId(teacher.getTeacherNo(), course.getCourseId()));
            courseAndCount.setCourse(course);
            courseAndCountList.add(courseAndCount);
        }
        return courseAndCountList;
    }

    @Override
    public List<SubmitTaskInfo> findAllSubmitInfo(Teacher teacher) {
        return teacherManageCenterDao.findAllSubmitInfo(teacher.getTeacherNo());
    }
}
