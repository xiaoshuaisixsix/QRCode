package com.example.controller;

import com.example.entity.QRCodeParam;
import com.example.utils.ImageToBase64;
import com.example.utils.QRcode;
import com.google.zxing.WriterException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TestController {

    /**
     * 生成普通的二维码
     * @return
     * @throws IOException
     * @throws WriterException
     */
    @GetMapping("/getQRCode")
    public String getQRCode() throws IOException, WriterException {

        QRcode qRcode = new QRcode();
        boolean result = qRcode.getQRCode("xiaoshuai","E:\\小帅.png");

        return String.valueOf(result);
    }

    /**
     * 生成带有logo的二维码
     * @return
     * @throws IOException
     * @throws WriterException
     */
    @PostMapping("/getQRCodeAndLogo")
    public String getQRCodeAndLogo(@RequestBody QRCodeParam qrCodeParam) throws IOException, WriterException {

        QRcode qRcode = new QRcode();
        // 解析前端选择的logo路径
        String url = "E:\\" + qrCodeParam.getLogoUrl().substring(qrCodeParam.getLogoUrl().lastIndexOf("\\"));
        boolean result = qRcode.getQRCodeAndLogo(qrCodeParam.getMsg(),url,"E:\\result.png");
        // 向前端返回base64编码，直接显示
        if(result){
            return ImageToBase64.getBase64Image("E:\\result.png");
        }else{
            return "失败";
        }
    }

}
