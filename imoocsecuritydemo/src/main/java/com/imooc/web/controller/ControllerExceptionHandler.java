package com.imooc.web.controller;

import com.imooc.exception.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 李存东
 * @Date: 2019/10/28
 * @Description:这种做法可以把自定义的异常的特定字段展示给前端或者app
 * 重写了springboot对于rest 异常机制的处理
 * 有点意思
 *
 *
 * springboot默认的异常机制:针对app和前端有不同的处理机制(原理.看请求头的accept是否包含text/html)
 * 可以满足大部分的需求
 * 默认机制针对前端页面:默认页面通过src/main/resources/resources/error/400.html or 500.html来改变页面
 * 默认机制针对app:可以吧valid的错误信息包装到json给前端
 *
 * 怎么更改错误的json 就是参考这个做法,以及对应的自定义Exception类
 *
 *
 */
@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(UserNotExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private Map<String,Object> handleUserNotExistException(UserNotExistException e){
        Map<String, Object> map = new HashMap<>();
        map.put("id", e.getId());
        map.put("message", e.getMessage());
        return map;

    }
}
