package com.imooc.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: 李存东
 * @Date: 2019/10/28
 * @Description:
 */
//@Aspect
//@Component
public class TimeAspect {
    /**
     * ProceedingJoinPoint包含拦截方法的信息 ,其中就包括参数
     **/
    @Around("execution (* com.imooc.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("timeAspect start");
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            System.out.println("arg is " + arg);
        }
        long start = new Date().getTime();
        Object proceed = pjp.proceed();//调用被拦截的方法
        System.out.println("time aspect 耗时" + (new Date().getTime() - start));
        System.out.println("timeAspect end");
        return proceed;

    }


}
