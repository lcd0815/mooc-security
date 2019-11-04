package com.imooc.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.dto.User;
import com.imooc.dto.UserQueryCondition;
import com.imooc.exception.UserNotExistException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:学习注解Restful 1@RestController
 * 2@RequestMapping映射http请求url到java方法
 * 3@RequestParam映射请求参数到java方法的参数
 * 4直接写对象,自动装配请求到对象
 * 5@PageableDefault 指定分页参数默认值
 * 6jsonpath表达式详见github上面的文档
 * 7@PathVariable映射url片段到java方法的参数
 * 8@JsonView控制json输出内容:三个步骤
 * 1)接口
 * 2)属性注解
 * 3)controller打接口的注解
 * 9@RequestBody:把前端传过来的json字符串组装成java对象给controller
 * 10 时间格式怎么处理:用时间戳
 * 11 校验字段:
 * 1)先在对象的属性上加上@NotBlank注解
 * 2)然后在controller的方法参数前面加上@Valid
 * * 3) 再加一个参数BindingResult errors,作用是能让前端的请求进到后端的方法里面去.可以操作或者记录日志等
 * @create: 2019-10-04
 * 总结Filter Interceptor Aspect
 * 1 Filter:能拿到http请求和相应的信息,拿不到对应控制器的类和方法的信息
 * 2 Interceptor:能拿到http请求和相应的信息,对应控制器的类和方法的信息 但是拿不到方法被调用的参数的值
 * 3 Aspect :能拿到参数,拿不到原始http请求和相应
 * 三者的顺序 Filter->Interceptor->Aspect->Controller->Aspect->ControllerAdvice->Interceptor->Filter
 **/

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping
    @JsonView(User.UserSimpleView.class)
    @ApiOperation("用户查询")
    public List<User> query(UserQueryCondition condition, @PageableDefault(page = 5, size = 10, sort = "username,asc") Pageable pageable) {
        System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    //冒号后面可以写正则表达式,这里代表 只能是数字,实际开发具体去写
    @GetMapping(value = "/{id:\\d+}")
    @JsonView(User.UserDetailView.class)//返回相同对象时候.在不同视图的情况下返回不同的字段
    public User getInfo(@ApiParam("用户id") @PathVariable(name = "id") String id) {
//        throw new RuntimeException("sddsad");
        System.out.println("进入getInfo服务");
        System.out.println(id);
        User user = new User();
        user.setUsername("tom");
        return user;
    }

    /**
     * @Description BindingResult有这个参数,如果校验不通过才会走下面的
     *              BindingResult如果没有这个参数 ,就不进去!!!
     **/
    @PostMapping
    public User create(@Valid @RequestBody User user/*, BindingResult errors*/) {
     /*   if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }*/

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());
        user.setId(1);
        return user;
    }

    //在javabean上加注解的时候,可以改变默认的消息,注解的message注解
    //错误转成FieldError后,可以获得消息和字段名
    //可以自定义注解,判断逻辑,加在字段上
    @PutMapping
    public User update(@Valid @RequestBody User user, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error ->
                    {
                        FieldError fieldError = (FieldError) error;
                        System.out.println(fieldError.getField()+fieldError.getDefaultMessage());
                    }
            );
        }

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());
        user.setId(1);
        return user;
    }

    @DeleteMapping(value = "/{id:\\d+}")
    public void delete(@PathVariable int id) {

        System.out.println(id);
    }
}
