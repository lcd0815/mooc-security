package com.imooc.security.core.validator.code.sms;

/**
 * @Author: 李存东
 * @Date: 2019/11/4
 * @Description:
 */
public interface SmsCodeSender {
    void send(String mobile, String code);
}
