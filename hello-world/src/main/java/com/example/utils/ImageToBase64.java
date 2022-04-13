package com.example.utils;

import org.apache.commons.codec.binary.Base64;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageToBase64 {

    public static String getBase64Image(String fileUrl){
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try
        {
            in = new FileInputStream(fileUrl);

            data = new byte[in.available()];

            in.read(data);

            in.close();

        }

        catch (IOException e)

        {

            e.printStackTrace();

        }

        return new String(Base64.encodeBase64(data));

    }
}
