package com.tangbaobao.controller;

import com.tangbaobao.common.SessionManage;
import com.tangbaobao.pojo.Student;
import com.tangbaobao.pojo.Teacher;
import com.tangbaobao.service.TeacherLoginService;
import com.tangbaobao.utils.CheckIdentifyCode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

/**
 * 教师端个人中心
 *
 * @author 唐学俊
 * @create 2018/04/21
 **/
@Controller
public class TeacherLoginController {

    Logger logger = LogManager.getLogger(TeacherLoginController.class);

    /**
     * 注入验证码校验类
     */
    @Autowired
    private CheckIdentifyCode checkIdentifyCode;
    /**
     * 注入session管理类
     */
    @Autowired
    SessionManage sessionManage;

    @Autowired
    TeacherLoginService teacherLoginService;

    @RequestMapping("/teacher/checkLogin.action")
    public String checkLogin(Teacher teacher, HttpSession map, HttpSession session, String checkCode) {


        Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

        //1.校验验证码
        boolean isCheckCodeCurrect = checkIdentifyCode.checkIdentifyCode(checkCode, session);

        logger.info(checkCode);
        //2.定义是否校验成功标志
        boolean isSuccessfulLogin = false;

        //3.返回消息
        String message;

        if (isCheckCodeCurrect) {
            //2.调用servie层方法
            Teacher teacherReturn = teacherLoginService.checkLogin(teacher);
            if (teacherReturn != null) {
                //将用户保存在session域中
                session.setAttribute("teacher", teacherReturn);
                logger.info("session中的数据"+session.getAttribute("teacher"));
                //验证完成,转向成功页面
                //判断session中是否有错误提示信息,如果有,移除
                if(session.getAttribute("message")!= null){
                    session.removeAttribute("message");
                }
                return "redirect:/teacher/index.action";
            } else {
                message = "用户名或密码错误";
            }
        } else {
            message = "验证码错误";
        }
        map.setAttribute("loginStatue", message);
        return "redirect:/teacher/login.do";
    }


    @RequestMapping("/teacher/logOut.action")
    public String logOut(HttpSession httpsession){
       httpsession.removeAttribute("teacher");
        //判断session中是否有错误提示信息,如果有,移除
        if (httpsession.getAttribute("loginStatue") != null) {
            httpsession.removeAttribute("loginStatue");
        }
       logger.info("已经退出登陆");
       return "redirect:/teacher/login.do";
    }

}
