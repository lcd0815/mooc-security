package com.imooc.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.validator.MyValidate;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @description:
 * @create: 2019-10-27
 **/
public class User {
    //1声明视图接口
    public interface UserSimpleView {
    }

    public interface UserDetailView extends UserSimpleView {
    }

    private int id;
    @MyValidate(message = "测试错误的校验方法")//使用自定义注解进行校验
    private String username;
    @NotBlank(message = "密码不能为空")//message属性可以改变提示的默认消息
    private String password;
    @Past(message = "生日日期必须为过去的日期")
    private Date birthday;

    //2注解
    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //2注解,由于继承了Simple的,因此Simple有的他也有
    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    @JsonView(UserSimpleView.class)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonView(UserSimpleView.class)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
