package com.springboot.shiro.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.hibernate.cache.spi.access.UnknownAccessTypeException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author: Eric
 * @Date: 22/10/2019 6:47 PM
 */
@Controller
@Slf4j
public class HomeController {


    @RequestMapping({"/", "/index"})
    public String index() {
        return "index";
    }



    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String,Object> map) {
        log.info("验证登录请求!");

        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        Object exception = request.getAttribute("shiroLoginFailure");
        String msg = "";
        if (exception != null) {
            if (UnknownAccessTypeException.class.isInstance(exception)){
                log.info("账户不存在");
                msg = "账户不存在或密码不正确";
            }else if (IncorrectCredentialsException.class.isInstance(exception)){
                log.info("密码不正确");
                msg = "密码不正确";
            }else{
                log.info("其他异常");
                msg = "其他异常";
            }
        }
        request.setAttribute("msg", msg);
        map.put("msg",msg);
        return "login";
    }


    }
