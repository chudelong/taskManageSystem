package com.tangbaobao.utils;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * 验证码校验类
 *
 * @author 唐学俊
 * @create 2018/04/14
 **/
@Component
public class CheckIdentifyCode {
    /**
     * 校验验证码
     *
     * @param pageCode
     * @param session
     * @return
     */
    public boolean checkIdentifyCode(String pageCode, HttpSession session) {
        //1.获取session中的验证码
        String checkcode = (String) session.getAttribute("checkcode");

        //2.比对
        if (pageCode.equalsIgnoreCase(checkcode)) {
            return true;
        }
        return false;
    }
}
