package com.imooc.security.browser.support;

/**
 * @Author: 李存东
 * @Date: 2019/10/31
 * @Description:
 */
public class SimpleResponse {

    public SimpleResponse(Object content) {
        this.content = content;
    }

    private Object content;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
