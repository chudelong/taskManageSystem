package com.tangbaobao.dao;

import com.tangbaobao.pojo.Course;
import com.tangbaobao.pojo.Task;
import com.tangbaobao.pojo.Work;
import com.tangbaobao.vo.FileName;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author 唐学俊
 * @create 2018/04/19
 **/
public interface StudentSubmitTaskDao {
    List<Course> getAllCourse(@Param("studentNo") String studentNo);

    List<Task> getAllTaskByCourseId(@Param("studentNo")String studentNo, @Param("courseId") int courseId);

    FileName getFileName(@Param("taskId") int taskId, @Param("studentNo")String studentNo);

    void insertTable(Work work);

    Date checkDeadLine(int taskId);
}
