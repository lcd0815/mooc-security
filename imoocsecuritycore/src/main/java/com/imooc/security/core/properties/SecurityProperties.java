package com.imooc.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: 李存东
 * @Date: 2019/10/31
 * @Description:这个类会读取配置文件中以imooc.security为开头的配置项
 */
@ConfigurationProperties(prefix = "imooc.security")
public class SecurityProperties {
    //这里之前弄错了.没有new 就会报空指针
    private BrowserProperties browser=new BrowserProperties();
    private ValidateCodeProperties code = new ValidateCodeProperties();

    public ValidateCodeProperties getCode() {
        return code;
    }

    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}
