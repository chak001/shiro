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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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



    @GetMapping("/toLogin")
    public String login(){
        return "login";
    }



    @PostMapping("/login")
    public ResponseEntity login(HttpServletRequest request, String username,String password,boolean rememberMe,String kaptcha) {
        log.info("验证登录请求!");

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();

        try {
            currentUser.login(token);
            return ResponseEntity.ok("登录成功");
        } catch(UnknownAccountException e){
            token.clear();
            return ResponseEntity.ok("用户名不存在,登录失败");
        }
        catch (AuthenticationException e) {
            token.clear();
            return ResponseEntity.ok("密码错误,登录失败");
        }
    }


    }
