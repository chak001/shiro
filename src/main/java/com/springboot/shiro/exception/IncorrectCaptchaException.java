package com.springboot.shiro.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * @Author: Eric
 * @Date: 23/10/2019 5:14 PM
 * Description  : 验证码错误异常
 */
public class IncorrectCaptchaException extends AuthenticationException {

    private static final long serialVersionUID = 1L;

    public IncorrectCaptchaException() {
        super();
    }

    public IncorrectCaptchaException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectCaptchaException(String message) {
        super(message);
    }

    public IncorrectCaptchaException(Throwable cause) {
        super(cause);
    }

}
