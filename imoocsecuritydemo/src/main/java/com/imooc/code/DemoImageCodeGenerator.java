package com.imooc.code;

import com.imooc.security.core.validator.code.ImageCode;
import com.imooc.security.core.validator.code.ValidateCodeGenerator;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Author: 李存东
 * @Date: 2019/11/2
 * @Description:以增量的方式适应变化,代码是可以扩展的
 */
//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {
    @Override
    public ImageCode generate(ServletWebRequest request) {
        System.out.println("子模块自定义的图形验证码生成器");
        return null;
    }
}
