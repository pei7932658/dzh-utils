package com.megvii.dzh.utils;

public class RandomUtils {
    /**
     * 生成随机数 小于 length
     * @param length
     * @return
     */
    public static int randomInt(int length) {
        return (int) (Math.random() * length);
    }
}
