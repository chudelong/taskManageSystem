package com.tangbaobao.interceptor;

import com.tangbaobao.pojo.Student;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 唐学俊
 * @create 2018/04/24
 **/

public class StudentIntecptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("student");
        if(student != null){
            return true;
        }
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("<script>alert('未登录,请登录后操作!');window.location.href='/login.action'</script>");
        return false;
    }
}
