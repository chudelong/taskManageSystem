package com.tangbaobao.service;

import com.tangbaobao.pojo.College;
import com.tangbaobao.pojo.Profession;
import com.tangbaobao.pojo.Sclass;
import com.tangbaobao.pojo.Student;

import java.util.List;

/**
 * @author 唐学俊
 * @create 2018/02/20
 **/
public interface LoginAndRegisterService {
    /**
     * 校验用户名是否正确
     * @param student
     * @return
     */
    public Student checkLogin(Student student);

    /**
     * 注册新用户
     *
     * @param student 将用户所有信息封装在Student中
     * @return
     */
    public boolean register(Student student);


    /**
     * 检查用户是否存在
     *
     * @param sno 学号
     * @return
     */
    boolean checkStudentIsExist(String sno);

    /**
     * 加载所有学院
     *
     * @return
     */
    List<College> selectCollege();

    /**
     * 根据学院加载专业
     *
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
