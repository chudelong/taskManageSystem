package com.tangbaobao.utils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * 项目中公共的工具
 *
 * @author 唐学俊
 * @create 2018/02/20
 **/
@Controller
public class CommonUtils {
    @GetMapping("/head.action")
    public String getHead(){
        return "head";
    }

    @GetMapping("/footer.action")
    public String getFooter(){
        return "footer";
    }

    @RequestMapping("/teacher/head.do")
    public String getTeacherHead(){
        return "teacher/head";
    }
    @RequestMapping("/teacher/index.do")
    public String getTeacherIndex(){
        return "/teacher/index";
    }
    @RequestMapping("/teacher/login.do")
    public String getTeacherLogin(HttpSession httpsession){
        //判断session中是否有错误提示信息,如果有,移除
        if (httpsession.getAttribute("loginStatue") != null) {
            httpsession.removeAttribute("loginStatue");
        }
        return "/teacher/login";
    }

}
