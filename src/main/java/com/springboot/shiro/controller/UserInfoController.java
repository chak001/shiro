package com.springboot.shiro.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Eric
 * @Date: 23/10/2019 10:00 AM
 */
@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

    /**
     * 用户查询
     */
    @RequestMapping("/userList")
    @RequiresPermissions("userInfo:view")
    public String userInfo(){
        return "userInfo";
    }

    /**
     * 用户添加
     */
    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")
    public String userInfoAdd(){
        return "userAdd";
    }

    /**
     * 删除用户
     */
    @RequestMapping("/userDel")
    @RequiresPermissions("userInfo:del")
    public String userInfoDel(){
        return "userInfoDel";
    }

}
