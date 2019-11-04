package com.imooc.exception;

import jdk.internal.org.objectweb.asm.commons.SerialVersionUIDAdder;

/**
 * @Author: 李存东
 * @Date: 2019/10/28
 * @Description:
 */
public class UserNotExistException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserNotExistException(int id) {
        super("user not found");
        this.id = id;
    }
}
