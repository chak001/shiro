package com.springboot.shiro.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.hibernate.cache.spi.access.UnknownAccessTypeException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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



    @GetMapping({"/toLogin","/logout"})
    public String login(){
        return "login";
    }


    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }


    @GetMapping("/aix")
    public String aix(){
        return "aix";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, String username, String password, boolean rememberMe, String kaptcha, Map map) {
        log.info("验证登录请求!");

        UsernamePasswordToken token = new UsernamePasswordToken(username, password,rememberMe);
        //获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();

        try {
            currentUser.login(token);

           map.put("msg", "登录成功");
            return "index";
        } catch(UnknownAccountException e){
            token.clear();
            map.put("msg", "用户名不存在,登录失败");
            return "toLogin";
        } catch (AuthenticationException e) {
            token.clear();
            map.put("msg", "密码错误,登录失败");
            return "toLogin";
        }
    }


    }
