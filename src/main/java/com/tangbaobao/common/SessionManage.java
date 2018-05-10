package com.tangbaobao.common;

import com.tangbaobao.pojo.Student;
import com.tangbaobao.pojo.Teacher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * 管理session
 *
 * @author 唐学俊
 * @create 2018/04/17
 **/
@Component
public class SessionManage {

   private HttpSession session;

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public HttpSession getSession(HttpSession session) {
        if (session != null) {
            return session;
        } else {
            throw new RuntimeException("sesssion域中为空");
        }
    }

    public Student getStudentInfoFormSession() {
        if (session != null) {
            return (Student) session.getAttribute("student");
        }
        return null;
    }

    public Teacher getTeacherInfoFormSession() {
        if (session != null) {
            return (Teacher) session.getAttribute("teacher");
        }
        return null;
    }

}
