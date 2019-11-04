package com.imooc.web.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * @Author: 李存东
 * @Date: 2019/10/28
 * @Description:自己写的Filter可以加上@Component
 * 第三方的要写一个配置类来配置
 * 优点
 * 缺点:不知道 哪个控制器的哪个方法处理的.拦截器就知道
 */
//@Component
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("TimeFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("TimeFilter start");

        long start = new Date().getTime();
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("time filter 耗时"+(new Date().getTime()-start));
        System.out.println("TimeFilter finish");
    }

    @Override
    public void destroy() {
        System.out.println("TimeFilter destroy");
    }
}
