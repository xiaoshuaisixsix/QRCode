package com.example.utils;

import com.github.hui.quick.plugin.qrcode.wrapper.QrCodeGenWrapper;
import com.github.hui.quick.plugin.qrcode.wrapper.QrCodeOptions;
import com.google.zxing.WriterException;

import java.io.IOException;

public class QRcode {

    // 通过内容生成二维码

    /**
     * 通过内容生成二维码
     * @param context
     * @param fileUrl
     * @return
     * @throws IOException
     * @throws WriterException
     */
    public boolean getQRCode(String context,String fileUrl) throws IOException, WriterException {
        // 生成二维码，并输出为qr.png图片
        return QrCodeGenWrapper.of(context).asFile(fileUrl);
    }

    /**
     * 带logo二维码生成
     * @param logoUrl
     * @param fileUrl
     * @return
     */
    public boolean getQRCodeAndLogo(String msg,String logoUrl,String fileUrl) throws IOException, WriterException {
        return QrCodeGenWrapper.of(msg)
                .setLogo(logoUrl)
                .setLogoStyle(QrCodeOptions.LogoStyle.ROUND)
                .setLogoBgColor(0xfffefefe)
                .setLogoBorderBgColor(0xffc7c7c7)
                .setLogoBorder(true)
                .asFile(fileUrl);
    }



}
