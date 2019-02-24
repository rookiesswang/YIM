package top.learn.web;

import top.learn.service.utils.MD5Utils;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        System.out.println(MD5Utils.getEncryptedPwd("123"));
    }
}
