package com.springboot.shiro.service;

import com.springboot.shiro.Entity.UserInfo;

/**
 * @Author: Eric
 * @Date: 22/10/2019 6:56 PM
 */

public interface UserInfoService {

    UserInfo findByUsername(String username);

}
