package com.tangbaobao.service;

import com.tangbaobao.pojo.Course;
import com.tangbaobao.pojo.Task;
import com.tangbaobao.pojo.Teacher;
import com.tangbaobao.pojo.Type;

import java.util.List;

/**
 * @author 唐学俊
 * @create 2018/04/22
 **/
public interface TeacherAssignTaskService {
    /**
     * 加载课程
     * @return
     */
    List<Course> loadAllCourse(Teacher teacher);

    /**
     * 加载类型
     * @param
     * @return
     */
    List<Type> loadAllCourseByCourseId();

    /**
     * 布置作业
     * @param task
     * @return
     */
    boolean assignTask(Task task);
}
