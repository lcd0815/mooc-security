package com.imooc.web.async;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * @Author: 李存东
 * @Date: 2019/10/29
 * @Description:
 */
@RestController
public class AsyncController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private MockQueue mockQueue;
    @Autowired
    private DeferredResultHolder deferredResultHolder;

    @RequestMapping("/order")
    public String order() throws InterruptedException {
        logger.info("主线程开始");
        Thread.sleep(1000);
        logger.info("主线程返回");
        return "success";
    }
    //不同的线程去执行
    //主线程tomcat的不等待,可以处理其他的http请求
    //副线程去执行业务逻辑
    //服务器吞吐量提升比较大,异步处理的优势 callable
    @RequestMapping("/order/a")
    public Callable<String> orderA() throws InterruptedException {
        logger.info("主线程开始");
        Callable<String> result = new Callable<String>() {
            @Override
            public String call() throws Exception {
                logger.info("副线程开始");
                Thread.sleep(1000);
                logger.info("副线程返回");
                return "success";
            }
        };
        logger.info("主线程返回");
        return result;
    }



    //主线程代码,看不到另一个线程
    //挺难的 暂时不理解
    @RequestMapping("/order/c")
    public DeferredResult<String> orderC() throws InterruptedException {
        logger.info("主线程开始");
        String orderNumber= RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(orderNumber);
        DeferredResult<String> result = new DeferredResult<>();
        deferredResultHolder.getMap().put(orderNumber, result);
        logger.info("主线程返回");
        return result;
    }
    //
}
