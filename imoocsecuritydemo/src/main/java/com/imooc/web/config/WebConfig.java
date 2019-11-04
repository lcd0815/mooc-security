package com.imooc.web.config;

import com.imooc.web.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 李存东
 * @Date: 2019/10/28
 * @Description:这种方法主要针对一些第三方的Filter组件,加入到容器中起作用
 * addInterceptors 才能让拦截器在springboot中起作用
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
//    @Autowired
//    private TimeInterceptor timeInterceptor;
//    @Bean
//    public FilterRegistrationBean timeFilter(){
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        TimeFilter timeFilter = new TimeFilter();
//        filterRegistrationBean.setFilter(timeFilter);
//        List<String> urls = new ArrayList<>();
//        urls.add("/*");//多了这个路径设置,满足这个条件才进入过滤器
//        filterRegistrationBean.setUrlPatterns(urls);
//        return filterRegistrationBean;
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(timeInterceptor);
    }

    //配置异步的拦截器,同步的拦截不了,不如楼上的
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
//        configurer.registerCallableInterceptors()添加异步的拦截器
//        configurer.registerDeferredResultInterceptors()同上
//        configurer.setDefaultTimeout()超时时间设置
//        configurer.setTaskExecutor()线程池
        super.configureAsyncSupport(configurer);
    }
}
