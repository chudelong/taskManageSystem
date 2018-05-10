package com.tangbaobao.dao;

import com.tangbaobao.pojo.Course;
import com.tangbaobao.pojo.Task;
import com.tangbaobao.pojo.Type;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 唐学俊
 * @create 2018/04/22
 **/
public interface TeacherAssignTaskDao {
    List<Course> loadAllCourse(@Param("teacherNo") String teacherNo);

    List<Type> loadAllCourseByCourseId();

    long assignTask(Task task);
}
