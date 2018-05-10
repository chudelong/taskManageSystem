package com.tangbaobao.dao;

import com.tangbaobao.pojo.Course;
import com.tangbaobao.pojo.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 唐学俊
 * @create 2018/04/17
 **/
public interface StudentCourseCenterDao {
    /**
     * 获取课程类型
     *
     * @param studentNo
     * @return
     */
    List<Course> getCourseCategory(@Param(value = "studentNo") String studentNo);

    /**
     * 获取每门课程的未提交作业的数量
     *
     * @param studentNo
     * @param courseId
     * @return
     */
    int getCourseCategoryCount(@Param(value = "studentNo") String studentNo, @Param("courseId") int courseId);

    /**
     * 根据学号获取所有的作业
     *
     * @param studentNo
     * @param courseId
     * @return
     */
    List<Task> getAllTask(@Param(value = "studentNo") String studentNo,@Param("courseId") Integer courseId);
}
