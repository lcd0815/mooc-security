package com.imooc.security.core.validator.code;

import com.imooc.security.core.properties.SecurityProperties;
import com.imooc.security.core.validator.code.sms.DefaultSmsCodeSender;
import com.imooc.security.core.validator.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 李存东
 * @Date: 2019/11/2
 * @Description:
 */
@Configuration
public class ValidateCodeBeanConfig {
    @Autowired
    private SecurityProperties securityProperties;

    //这种@Bean配置相当于在ImageCodeGenerator这个类上加上@Component注解,但是可以搭配下面的注解达到spring的功能
    @Bean
    //demo项目 如果注册了这个bean,就不用这个了.达到可以配置的效果
    @ConditionalOnMissingBean(name = "imageCodeGenerator")
    public ValidateCodeGenerator imageCodeGenerator() {
        ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
        codeGenerator.setSecurityProperties(securityProperties);
        return codeGenerator;
    }

    @Bean
//    @ConditionalOnMissingBean(name = "smsCodeGenerator")
    //spring如果找到了这个接口的实现类了,那么就不会调用这个方法
    @ConditionalOnMissingBean(SmsCodeSender.class)
    public SmsCodeSender smsCodeGenerator() {
        return new DefaultSmsCodeSender();
    }
}
