package com.tangbaobao.dao;

import com.tangbaobao.pojo.Course;
import com.tangbaobao.vo.SubmitTaskInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 唐学俊
 * @create 2018/04/30
 **/
public interface TeacherManageCenterDao {
    List<Course> findAllCourse(@Param("teacherNo") String teacherNo);

    int findCountByCourseId(@Param("teacherNo") String teacherNo, @Param("courseId") int courseId);

    List<SubmitTaskInfo> findAllSubmitInfo(@Param(value = "teacherNo") String teacherNo);
}
