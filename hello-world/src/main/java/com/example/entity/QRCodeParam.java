package com.example.entity;

import lombok.Data;

@Data
public class QRCodeParam {

    /**
     * 二维码信息
     */
    private String msg;

    /**
     * logoUrl
     */
    private String logoUrl;
}
