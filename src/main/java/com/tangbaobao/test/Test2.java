package com.tangbaobao.test;

import com.tangbaobao.dao.StudentCenterDao;
import com.tangbaobao.dao.StudentCourseCenterDao;
import com.tangbaobao.pojo.Task;
import com.tangbaobao.service.LoginAndRegisterService;
import com.tangbaobao.service.StudentCourseCenterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * ceshi
 *
 * @author 唐学俊
 * @create 2018/04/14
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
public class Test2 {

    @Autowired
    LoginAndRegisterService service;
    @Autowired
    StudentCenterDao studentCenterDao;

    @Autowired
    StudentCourseCenterService studentCourseCenterDao;



    @Test
    public void fun1() {
//        List<Task> allTask = studentCourseCenterDao.getAllTask(1);
//
//        allTask.forEach(x-> System.out.println(x));
    }
}
