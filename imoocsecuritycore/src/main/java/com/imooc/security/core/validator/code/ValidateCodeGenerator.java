package com.imooc.security.core.validator.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Author: 李存东
 * @Date: 2019/11/2
 * @Description:
 */
public interface ValidateCodeGenerator {
    ValidateCode generate(ServletWebRequest request);

}
