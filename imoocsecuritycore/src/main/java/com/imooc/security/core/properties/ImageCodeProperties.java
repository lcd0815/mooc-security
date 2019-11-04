package com.imooc.security.core.properties;

/**
 * @Author: 李存东
 * @Date: 2019/11/2
 * @Description:
 */
public class ImageCodeProperties extends SmsCodeProperties {
    private int width=67;
    private int height=23;

    //父类的短信验证码的长度是6,通过这个方法,把这个默认值改为4
    public ImageCodeProperties() {
        setLength(4);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
