package com.imooc.service.impl;

import com.imooc.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @Author: 李存东
 * @Date: 2019/10/28
 * @Description:
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String greeting(String msg) {
        System.out.println("HelloService");
        return msg+"hello";
    }
}
