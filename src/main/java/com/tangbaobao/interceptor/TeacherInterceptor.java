package com.tangbaobao.interceptor;

import com.tangbaobao.pojo.Student;
import com.tangbaobao.pojo.Teacher;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 教师拦截器
 *
 * @author 唐学俊
 * @create 2018/04/30
 **/

public class TeacherInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        if (teacher != null) {
            return true;
        }
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("<script>alert('未登录,请登录后操作!');window.location.href='/teacher/login.do'</script>");
        return false;
    }

}
