package com.imooc.security.browser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @Author: 李存东
 * @Date: 2019/10/31
 * @Description:
 * 1处理用户信息获取逻辑 :UserDetailsService接口
 * 2用户(密码)校验逻辑 :UserDetails接口
 *      isAccountNonLocked 用户是否被冻结/锁定
 *      isEnabled 用户是否被删了
 *      返回的UserDetails的实现类,可以由我们自己来实现类!!!
 * 3处理密码加密解密 passwordEncoder接口
 */
@Component
public class MyUserDetailsService implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;
    //可以注入进来Dao,查找那些用户的信息
//    @Autowired
//    private AccountDao accountDao
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("登陆用户名:" + username);
        //这个加密的过程 要在添加用户的时候就加密的!
        String encode = passwordEncoder.encode("123456");
        logger.info("数据库密码为:"+encode);
        //去数据库查出该账号的信息,然后组装对象!
        //可以查找到的用户信息,判断用户是否被冻结
        return new User(username, encode,
                true,true,true,true,

                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
