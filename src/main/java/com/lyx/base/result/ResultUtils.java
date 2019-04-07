package com.lyx.base.result;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResultUtils {
    /**
     * 服务器返回的值
     *
     * @throws IOException
     */
    public static void out(Object obj,HttpServletResponse response){

        response.setContentType("application/json;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache");
        String jsonstring = JSON.toJSONString(obj);
//        System.out.println(jsonstring);
        try (PrintWriter out = response.getWriter()) {
            out.print(jsonstring);
            System.out.println("WollarTicketAdmin 里传输数据为" + jsonstring);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
