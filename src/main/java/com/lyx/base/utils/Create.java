package com.lyx.base.utils;


import java.util.*;

public class Create {
    /**
     * UUID当做token
     */
    public static String getUUID(String content) {
        String code = "";
        String token = UUID.randomUUID().toString().replaceAll("-", "");//随机生成token
        return token;
    }

    //6位随机字符
    public static String getRandomString() {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 有效期
     */
    public static Date expires_in() {
        Date now = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(now);
        c.add(Calendar.HOUR_OF_DAY, 2);
        return c.getTime();
    }

    /**
     * 解析json
     * params
     */
    public static String queryString(Map<String, String[]> params) {
        StringBuilder queryString = new StringBuilder();
        for (String key : params.keySet()) {
            String[] values = params.get(key);
            for (String ignored : values) {
                queryString.append(key);
            }
        }
        return queryString.toString();
    }

    //6位随机数
    public static int randomNumber() {
        int x;//定义变量
        Random ne = new Random();//实例化一个random的对象ne
        x = ne.nextInt(999999 - 100000 + 1) + 100000;//为变量赋随机值10000-99999
        return x;
    }


}
