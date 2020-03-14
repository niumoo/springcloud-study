package com.wdbyte.order.utils;

import java.util.Random;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/12 21:29
 */
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 简单应用
     * 格式：时间戳+随机数
     */

    public static synchronized String getUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
