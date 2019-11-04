package com.imooc.security.core.properties;

/**
 * @Author: 李存东
 * @Date: 2019/10/31
 * @Description:
 */
public class BrowserProperties {
    private String loginPage = "/imooc-signIn.html";
    private LoginType loginType = LoginType.JSON;//默认用JSON
    private int rememberMeSeconds = 3600;

    public String getLoginPage() {
        return loginPage;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public void setLoginPage(String loginPage) {

        this.loginPage = loginPage;
    }

    public int getRememberMeSeconds() {
        return rememberMeSeconds;
    }

    public void setRememberMeSeconds(int rememberMeSeconds) {
        this.rememberMeSeconds = rememberMeSeconds;
    }
}
