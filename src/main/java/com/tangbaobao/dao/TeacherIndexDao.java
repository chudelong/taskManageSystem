package com.tangbaobao.dao;

import com.tangbaobao.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

/**
 * @author 唐学俊
 * @create 2018/04/30
 **/
public interface TeacherIndexDao {
    Teacher getTeacherInfo(@Param(value = "teacherNo") String teacherNo);
}
