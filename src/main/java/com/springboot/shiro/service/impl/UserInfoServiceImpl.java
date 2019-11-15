package com.springboot.shiro.service.impl;

import com.springboot.shiro.Entity.UserInfo;
import com.springboot.shiro.mapper.UserInfoMapper;
import com.springboot.shiro.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Eric
 * @Date: 22/10/2019 6:57 PM
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {


    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo findByUsername(String username) {
        UserInfo userInfo = new UserInfo();
        userInfo.setName(username);
       return  userInfoMapper.selectOne(userInfo);
    }
}
