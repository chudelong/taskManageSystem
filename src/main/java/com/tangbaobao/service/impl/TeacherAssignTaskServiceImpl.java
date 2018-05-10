package com.tangbaobao.service.impl;

import com.tangbaobao.dao.TeacherAssignTaskDao;
import com.tangbaobao.pojo.Course;
import com.tangbaobao.pojo.Task;
import com.tangbaobao.pojo.Teacher;
import com.tangbaobao.pojo.Type;
import com.tangbaobao.service.TeacherAssignTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 唐学俊
 * @create 2018/04/22
 **/
@Service
public class TeacherAssignTaskServiceImpl implements TeacherAssignTaskService {

    @Autowired
    TeacherAssignTaskDao teacherAssignTaskDao;


    @Override
    public List<Course> loadAllCourse(Teacher teacher) {
        return teacherAssignTaskDao.loadAllCourse(teacher.getTeacherNo());
    }

    @Override
    public List<Type> loadAllCourseByCourseId() {
        return teacherAssignTaskDao.loadAllCourseByCourseId();
    }

    @Override
    public boolean assignTask(Task task) {

        //对task进行封装
        task.setTaskTime(new Date());

        return teacherAssignTaskDao.assignTask(task) > 1 ? true : false;
    }
}
