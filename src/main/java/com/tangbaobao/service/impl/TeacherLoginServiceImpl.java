package com.tangbaobao.service.impl;

import com.tangbaobao.dao.TeacherLoginDao;
import com.tangbaobao.pojo.Teacher;
import com.tangbaobao.service.TeacherLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 唐学俊
 * @create 2018/04/22
 **/
@Service
public class TeacherLoginServiceImpl implements TeacherLoginService {
    @Autowired
    TeacherLoginDao teacherLoginDao;
    @Override
    public Teacher checkLogin(Teacher teacher) {
        Teacher teacherReturn = teacherLoginDao.checkLogin(teacher);
        return teacherReturn;
    }
}
