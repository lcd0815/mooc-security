package com.imooc.security.core.validator.code;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @Author: 李存东
 * @Date: 2019/11/1
 * @Description:
 */
public class ImageCode extends ValidateCode {
    private BufferedImage image;



    public ImageCode(BufferedImage image, String code, int expireIn) {
        super(code, expireIn);
        this.image = image;
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        super(code, expireTime);
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

}
