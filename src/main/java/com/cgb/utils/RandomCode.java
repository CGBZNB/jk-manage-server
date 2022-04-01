package com.cgb.utils;

/**
 * @Author CGB
 * @Date 2022/3/22 22:52
 * 生成一个6位随机数
 */
public class RandomCode {

    public static String randomCode(){
        return ((int)((Math.random()*9+1)*100000))+"";
    }
}
