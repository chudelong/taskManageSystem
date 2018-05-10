package com.tangbaobao.controller;

import com.tangbaobao.pojo.College;
import com.tangbaobao.pojo.Profession;
import com.tangbaobao.pojo.Sclass;
import com.tangbaobao.pojo.Student;
import com.tangbaobao.service.LoginAndRegisterService;
import com.tangbaobao.utils.CheckIdentifyCode;
import com.tangbaobao.common.SessionManage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.List;

/**
 * 登陆和注册页面
 *
 * @author 唐学俊
 * @create 2018/02/20
 **/
@Controller

public class LoginAndRegisterController {
    /**
     * 注入serivice
     */
    @Autowired
    LoginAndRegisterService loginAndRegisterService;

    /**
     * 注入验证码校验类
     */
    @Autowired
    private CheckIdentifyCode checkIdentifyCode;

    /**
     * 登陆入口
     *
     * @return
     */
    @RequestMapping("/login.action")
    public String login(HttpSession httpsession) {
        //判断session中是否有错误提示信息,如果有,移除
        if (httpsession.getAttribute("loginStatue") != null) {
            httpsession.removeAttribute("loginStatue");
        }
        return "login";
    }

    /**
     * 注册入口
     *
     * @return
     */
    @RequestMapping("/register.action")
    public String register() {
        return "register";
    }


    /**
     * 校验用户名密码是否正确
     * <p>
     * 校验思路:
     * 先校验验证码是否正确
     * 如果正确,在调用service校验
     * 否则,直接返回验证码错误提示信息
     *
     * @param student
     * @param map
     * @return
     */
    @RequestMapping("/checkLogin.action")
    public String checkLogin(Student student, HttpSession map, HttpSession session, String checkCode) {

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
            Student studentReturn = loginAndRegisterService.checkLogin(student);
            if (studentReturn != null) {
                //将用户保存在session域中
                session.setAttribute("student", studentReturn);
                logger.info("sessionId" + session.getId());
                logger.info("session创建时间" + session.getCreationTime());

                return "redirect:/student/index.action";
            } else {
                message = "用户名或密码错误";
            }
        } else {
            message = "验证码错误";
        }
        map.setAttribute("loginStatue", message);
        return "redirect:/login.action";
    }


    /**
     * 将数据传回数据库
     *
     * @param student
     * @param model
     * @return
     */
    @RequestMapping("/registerUser.action")
    public String registerUser(Student student, Model model) {
        //1.将数据传递到service层
        boolean isSuccessfulRegister = loginAndRegisterService.register(student);
        //2.返回回调信息
        if (!isSuccessfulRegister) {
            model.addAttribute("regMessage", "注册失败,请稍后重试");
            return "forward:/register";
        } else {
            return "redirect:/login.action";
        }
    }

    /**
     * ajax校验用户是否存在
     *
     * @param studentNo
     * @param map
     */
    @RequestMapping("/checkStudentIsExist.action")
    public
    @ResponseBody
    boolean checkStudentIsExist(String studentNo, ModelMap map) {
        //1.调用service层方法
        return loginAndRegisterService.checkStudentIsExist(studentNo);
    }

    /**
     * ajax加载学院
     *
     * @param
     */
    @RequestMapping("/loadCollege.action")
    public @ResponseBody
    List<College> loadCollege() {
        //1.调用service层
        List<College> collegeList = loginAndRegisterService.selectCollege();
        //返回给客户端
        return collegeList;
    }

    /**
     * Ajax根据学院加载专业
     */
    @RequestMapping("/loadProfessionByCollege.action")
    public @ResponseBody
    List<Profession> loadProfession(ModelMap map, String collegeId) {
        //1.调用service层
        return loginAndRegisterService.selectProfession(collegeId);
    }

    /**
     * 根据专业id加载班级
     *
     * @param map
     * @param professionId
     */
    @PostMapping("/loadClassByCollege.action")
    public @ResponseBody
    List<Sclass> loadClass(ModelMap map, String professionId) {
        return loginAndRegisterService.selectClass(professionId);
    }

    /**
     * 退出登陆
     *
     * @return
     */
    @RequestMapping("/logOut.action")
    public String logOut(HttpSession session) {
        Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
        logger.info("开始移除session" + session.getId());
        session.removeAttribute("student");
        //判断session中是否有错误提示信息,如果有,移除
        if (session.getAttribute("loginStatue") != null) {
            session.removeAttribute("loginStatue");
        }
        logger.info("session结束");
        return "redirect:/login.action";
    }


    @RequestMapping("/index.action")
    public String index() {
        return "index";
    }
}
