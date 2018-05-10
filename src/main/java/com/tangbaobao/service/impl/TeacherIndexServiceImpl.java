package com.tangbaobao.service.impl;

import com.tangbaobao.dao.TeacherIndexDao;
import com.tangbaobao.pojo.Teacher;
import com.tangbaobao.service.TeacherIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 唐学俊
 * @create 2018/04/30
 **/
@Service
public class TeacherIndexServiceImpl implements TeacherIndexService {

    @Autowired
    TeacherIndexDao teacherIndexDao;

    @Override
    public Teacher getTeacherInfo(String teacherNo) {
        return teacherIndexDao.getTeacherInfo(teacherNo);
    }
}
