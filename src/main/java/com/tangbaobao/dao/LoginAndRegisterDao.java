package com.tangbaobao.dao;

import com.tangbaobao.pojo.College;
import com.tangbaobao.pojo.Profession;
import com.tangbaobao.pojo.Sclass;
import com.tangbaobao.pojo.Student;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 唐学俊
 * @create 2018/02/20
 **/
public interface LoginAndRegisterDao {
    /**
     * 查询器,执行此模块中所有的查询功能
     *
     * @param student
     * @return
     */
    List<Student> executeQuery(Student student);

    /**
     * dao调用注册方法
     *
     * @param student
     * @return
     */
    int register(Student student);


    /**
     * 加载所有学院
     *
     * @return
     */
    List<College> selectCollege();

    /**
     * 根据学院加载专业
     *
     * @param collegeId
     * @return
     */
    List<Profession> selectProfession(String collegeId);

    /**
     * 根据专业加载班级
     * @param professionId
     * @return
     */
    List<Sclass> selectClass(String professionId);
}
