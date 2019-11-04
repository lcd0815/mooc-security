package com.imooc.security.core.validator.code;


import org.springframework.security.core.AuthenticationException;

/**
 * @Author: 李存东
 * @Date: 2019/11/1
 * @Description:
 */
public class ValidateCodeException extends AuthenticationException {

    private static final long serialVesionUID = 1L;
    public ValidateCodeException(String msg) {
        super(msg);
    }
}
