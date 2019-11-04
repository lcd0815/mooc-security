package com.imooc.web.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: 李存东
 * @Date: 2019/10/29
 * @Description:
 */
@Component
public class MockQueue {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private String placeOrder;//有个下单的消息
    private String completeOrder;//完成业务

    public String getPlaceOrder() {
        return placeOrder;
    }

    public void setPlaceOrder(String placeOrder) throws InterruptedException {
        //模拟一个线程来处理真正的逻辑(应用2的线程)
        new Thread(()->{
            logger.info("接到下单请求"+placeOrder);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.completeOrder = placeOrder;
            logger.info("下单请求处理完毕: "+placeOrder);
        }).start();

    }

    public String getCompleteOrder() {
        return completeOrder;
    }

    public void setCompleteOrder(String completeOrder) {
        this.completeOrder = completeOrder;
    }
}
