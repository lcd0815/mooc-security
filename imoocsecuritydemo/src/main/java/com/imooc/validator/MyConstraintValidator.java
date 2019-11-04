package com.imooc.validator;

import com.imooc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author: 李存东
 * @Date: 2019/10/28
 * @Description:实现校验类的接口ConstraintValidator,有两个泛型,第一个是注解,第二个是要校验的字段的类型
 */
public class MyConstraintValidator implements ConstraintValidator<MyValidate, Object> {

    /**
     * 本类会自动添加到spring容器里面,同时也可以从spring容器中取组件出来用!
     **/
    @Autowired
    private HelloService helloService;

    /**
     * @Description //初始化的时候调用
     **/
    @Override
    public void initialize(MyValidate myValidate) {
        System.out.println("我的注解校验开始初始化了");
    }

    /**
     * @Description 这个返回通过返回值以及判断条件,来决定:
     * 是否校验通过,true为校验通过,false为校验不通过
     * @param o:校验的那个值
     * @param constraintValidatorContext:注解上的一些信息
     **/
    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        String greeting = helloService.greeting((String) o);
        System.out.println(greeting);
        System.out.println(o);
        String defaultConstraintMessageTemplate = constraintValidatorContext.getDefaultConstraintMessageTemplate();
        System.out.println(defaultConstraintMessageTemplate);
        return false;
    }
}
