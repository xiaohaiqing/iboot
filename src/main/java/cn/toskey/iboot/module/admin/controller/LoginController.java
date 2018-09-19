package cn.toskey.iboot.module.admin.controller;

import cn.toskey.iboot.module.admin.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
public class LoginController {

    @RequestMapping("/index")
    public String index() {
        return "/main";
    }

    @RequestMapping("/login")
    public String login() {
        return "/login";
    }

    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }

        return "login";
    }

    @RequestMapping("/admin")
    @ResponseBody
    public String admin() {
        return "success admin";
    }

    @RequestMapping("/unauthorize")
    public String unauthorize() {
        return "unauthorize";
    }

    @RequestMapping("/loginUser")
    public String loginUser(@RequestParam("userName") String userName,
                            @RequestParam("password") String password,
                            HttpSession session) {
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(token);
            User user = (User) subject.getPrincipal();
            session.setAttribute("user", user);

            return "main";
        } catch (Exception e) {
            return "login";
        }
    }
}
