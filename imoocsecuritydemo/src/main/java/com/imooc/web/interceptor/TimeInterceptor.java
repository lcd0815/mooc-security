package com.imooc.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @Author: 李存东
 * @Date: 2019/10/28
 * @Description:拦截器
 * 单加@Component不行
 * preHandler 返回true了 才有后续
 * 缺点,拿不到传的参数值!!
 */
//@Component
public class TimeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        System.out.println("TimeInterceptor preHandle");
        HandlerMethod handler1 = (HandlerMethod) handler;
        String name = handler1.getBean().getClass().getName();
        System.out.println(name);
        String name1 = handler1.getMethod().getName();
        System.out.println(name1);
        httpServletRequest.setAttribute("startTime",new Date().getTime());
        return true;
    }

    //只有没有异常 成功了才调用
    //如果异常被吃掉了.这里也没了
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("TimeInterceptor postHandle");
        Long startTime = (Long) httpServletRequest.getAttribute("startTime");
        System.out.println("TimeInterceptor postHandle time-interceptor 耗时"+(new Date().getTime()-startTime));
    }

    //无论是否异常都调用
    //有可能被其他的异常吃掉了.就导致这里没有异常 e为空
    //以这里为例,就被我们自定义的 ControllerExceptionHandler 吃掉了

    //spring提供的BasicErrorController 也被拦截了
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("TimeInterceptor afterCompletion");
        Long startTime = (Long) httpServletRequest.getAttribute("startTime");
        System.out.println(" TimeInterceptor afterCompletion time-interceptor 耗时"+(new Date().getTime()-startTime));
        System.out.println("TimeInterceptor ex Is "+e);
    }
}
