package com.springboot.shiro.config;

import org.apache.shiro.authc.UsernamePasswordToken;

/** 验证码 captcha
 * @Author: Eric
 * @Date: 23/10/2019 10:37 AM
 */
public class CaptchaUsernamePasswordToken extends UsernamePasswordToken {
    private static final long serivalVersionUID = 1L;

    private String captcha;
    public CaptchaUsernamePasswordToken(String username, char[] password, boolean remeberMe, String host,String captcha){
        super(username, password, remeberMe, host);
        this.captcha = captcha;
    }

    public static long getSerivalVersionUID() {
        return serivalVersionUID;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }


}
