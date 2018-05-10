package com.tangbaobao.service.impl;

import com.tangbaobao.dao.LoginAndRegisterDao;
import com.tangbaobao.pojo.College;
import com.tangbaobao.pojo.Profession;
import com.tangbaobao.pojo.Sclass;
import com.tangbaobao.pojo.Student;
import com.tangbaobao.service.LoginAndRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 唐学俊
 * @create 2018/02/20
 **/
@Service
public class LoginAndRegisterImpl implements LoginAndRegisterService {

    /**
     * 注入dao
     */
    @Autowired
    private LoginAndRegisterDao dao;


    public void setDao(LoginAndRegisterDao dao) {
        this.dao = dao;
    }

    @Override
    public Student checkLogin(Student student) {
        //1.调用dao校验基本数据
        Student studentReturn = this.queryOne(student);

        //3.返回数据
        if (studentReturn != null) {
            studentReturn.setStudentPassword("");
            return studentReturn;
        }

        return null;

    }

    @Override
    public boolean register(Student student) {

        //对为封装的信息进行封装
        student.setReg_time(new Date());
        /**
         *  利用学号提取性别,年级
         * 学号:  2015214326  2017224563
         * 年级:  2015        2017
         * 性别:  21->男      22->女
         */
        String studentNo = student.getStudentNo();
        final String studentGrade = studentNo.substring(0, 4);
        final String studentSex = studentNo.substring(4, 6);

        student.setStudentSex(studentSex);
        student.setStudentGrade(studentGrade);
        //新注册默认已经激活
        student.setStudentStatue("1");

        //返回注册的条数
        int row = dao.register(student);

        if (row == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean checkStudentIsExist(String sno) {

        //包装student,调用查询器
        Student student = new Student();
        student.setStudentNo(sno);
        student = this.queryOne(student);

        if (student == null) {
            return true;
        }
        return false;
    }

    @Override
    public List<College> selectCollege() {
        return dao.selectCollege();
    }

    @Override
    public List<Profession> selectProfession(String collegeId) {
        //调用dao
        return dao.selectProfession(collegeId);

    }

    @Override
    public List<Sclass> selectClass(String professionId) {
        return dao.selectClass(professionId);
    }

    /**
     * 执行查询方法
     *
     * @param student
     * @return
     */
    public List<Student> executeQuery(Student student) {
        List<Student> studentList = dao.executeQuery(student);
        return studentList;
    }

    /**
     * 只返回一条记录的方法
     *
     * @param student
     * @return
     */
    public Student queryOne(Student student) {
        List<Student> studentList = this.executeQuery(student);
        if (studentList.size() > 1) {
            try {
                throw new Exception("此方法只能返回一个值,你调用此方法返回了" + studentList.size() + "个值");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (studentList.size() == 1) {
            return studentList.get(0);
        }
        return null;
    }

}
