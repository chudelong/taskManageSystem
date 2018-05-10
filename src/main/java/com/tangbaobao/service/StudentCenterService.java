package com.tangbaobao.service;

import com.tangbaobao.pojo.Student;

/**
 * @author 唐学俊
 * @create 2018/04/15
 **/
public interface StudentCenterService {
    /**
     * 获取个人信息
     * @return
     */
    public Student getStudentInfo(Student student);

    /**
     * 获取已经提交的作业
     * @return
     */
    public int countSubmitted(Student student);

    /**
     * 全部作业
     * @return
     */
    int countTask(Student student);
}
