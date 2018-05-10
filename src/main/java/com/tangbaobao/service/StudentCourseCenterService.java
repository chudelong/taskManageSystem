package com.tangbaobao.service;

import com.tangbaobao.pojo.Course;
import com.tangbaobao.pojo.Student;
import com.tangbaobao.pojo.Task;
import com.tangbaobao.vo.CourseAndCount;

import java.util.List;

/**
 * @author 唐学俊
 * @create 2018/04/17
 **/
public interface StudentCourseCenterService {
    /**
     * 获取作业和数量
     * 拼装
     * @return
     */
    List<CourseAndCount> getCourseAndCount(Student student);

    /**
     * 获取所有
     * @return
     */
    List<Task> getAllTask(Student student);

    /**
     * 根据CourseId获取所有课程
     * @param courseId
     * @return
     */
    List<Task> getAllTask(Integer courseId,Student student);
}
