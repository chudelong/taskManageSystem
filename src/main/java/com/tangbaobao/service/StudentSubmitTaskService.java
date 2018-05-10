package com.tangbaobao.service;

import com.tangbaobao.pojo.Course;
import com.tangbaobao.pojo.Student;
import com.tangbaobao.pojo.Task;
import com.tangbaobao.pojo.Work;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * @author 唐学俊
 * @create 2018/04/19
 **/
public interface StudentSubmitTaskService {
    /**
     * 加载所有课程
     * @return
     */
    List<Course> getAllCourse(Student student);

    /**
     * 根据课程id加载task
     * @param courseId
     * @return
     */
    List<Task> getAllTaskByCourseId(int courseId,Student student);

    /**
     * 提交作业
     * @param uploadFile
     * @param work
     * @return
     */
    boolean submitTask(MultipartFile uploadFile, Work work,Student student);

    Date checkDeadLine(@Param("taskId") int taskId);
}
