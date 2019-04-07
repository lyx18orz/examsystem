package com.lyx.base.utils;



import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class Put {
    public static String sendPost(String url, String param,HttpServletResponse response) throws IOException {
//        PrintWriter out = null;
        //乱码改为OutputStreamWriter
        OutputStreamWriter out = null;

        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);
//			System.out.println(conn.getConnectTimeout());

            //1.获取URLConnection对象对应的输出流
//            out = new PrintWriter(conn.getOutputStream());
//
            //2.中文有乱码的需要将PrintWriter改为如下
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            // 发送请求参数

            out.write(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            Map<String, String> map_app = new HashMap<>();
            map_app.put("status", "0");
            map_app.put("cause", "服务器 POST 请求出现异常,请联系管理员!");
            System.out.println("服务器 POST请求出现异常");
            e.getMessage();
        }
        //使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
//	        System.out.println("post推送结果："+result);
        return result;
    }

}
