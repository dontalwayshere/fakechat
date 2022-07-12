package com.fakechat.practice.utils;

import org.springframework.util.DigestUtils;

public class ApiUtils {


    public static String stringToMD5(String plainText) {
        return DigestUtils.md5DigestAsHex(plainText.getBytes());
    }
}
