package com.tangbaobao.dao;

import com.tangbaobao.pojo.Teacher;

/**
 * @author 唐学俊
 * @create 2018/04/22
 **/
public interface TeacherLoginDao {
    Teacher checkLogin(Teacher teacher);
}
