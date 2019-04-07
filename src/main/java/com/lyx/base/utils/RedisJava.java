package com.lyx.base.utils;


public class RedisJava {
    public static RedisJava redisJava1 = new RedisJava();
    public static RedisJava redisJava2 = new RedisJava();

    {
        System.out.println("构造代码块!");
    }

    static {
        System.out.println("静态代码块!");
    }

    public static void main(String[] args) throws Exception {
//        String ServerPath="d:/Photo/WollarTicket/TicketLogo/";
//        String content="https://open.weixin.qq.com/sns/getexpappinfo?appid=wxde28506ea89d7ca2&path=pages/get/index.html?TID=JneSvg520181204115230#wechat-redirect";
//        Create.Code(content,"JneSvg520181204115230",ServerPath);
        new RedisJava();
    }
}
