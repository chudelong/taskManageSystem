package com.tangbaobao.service.impl;

import com.tangbaobao.dao.StudentCenterDao;
import com.tangbaobao.pojo.Student;
import com.tangbaobao.pojo.Work;
import com.tangbaobao.service.StudentCenterService;
import com.tangbaobao.common.SessionManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 唐学俊
 * @create 2018/04/15
 **/
@Service
public class StudentCenterServiceImpl implements StudentCenterService {
    /**
     * 注入dao
     */
    @Autowired
    StudentCenterDao studentCenterDao;


    @Override
    public Student getStudentInfo(Student student) {
        //2.调用dao
        return studentCenterDao.getStudentInfo(student.getStudentNo());

    }

    @Override
    public int countSubmitted(Student student) {
        List<Work> workList = studentCenterDao.countSubmittedTask(student.getStudentNo());
        return workList.size();
    }

    @Override
    public int countTask(Student student) {
        return studentCenterDao.countTask(student.getStudentNo());
    }


}
