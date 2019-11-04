package com.imooc.security.core.validator.code.sms;

import org.springframework.stereotype.Component;

/**
 * @Author: 李存东
 * @Date: 2019/11/4
 * @Description:
 */
public class DefaultSmsCodeSender implements SmsCodeSender {
    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机号为"+mobile+"发送验证码:"+code);
    }
}
