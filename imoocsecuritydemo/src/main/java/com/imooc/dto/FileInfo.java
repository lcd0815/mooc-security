package com.imooc.dto;

/**
 * @Author: 李存东
 * @Date: 2019/10/29
 * @Description:
 */
public class FileInfo {
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public FileInfo(String path) {
        this.path = path;
    }
}
