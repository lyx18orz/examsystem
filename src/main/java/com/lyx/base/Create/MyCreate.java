package com.lyx.base.Create;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;

public class MyCreate {
        /**
         * UUID当做token
         */
        public String UUID(String busid) {
            String token = UUID.randomUUID().toString().replaceAll("-", "");//随机生成token
            Date now_date = new Date();
            SimpleDateFormat iddate = new SimpleDateFormat("yyyyMMddHHmmss");
            return token;
        }

        //6位随机字符
        public String RandomString() {
            String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                int number = random.nextInt(62);
                sb.append(str.charAt(number));
            }
            return sb.toString();
        }

        /**
         * 有效期
         */
        public Date expires_in() {
            Date now = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(now);
            c.add(Calendar.HOUR_OF_DAY, 2);//2天
            return c.getTime();
        }
        /**
         * 解析json
         * params
         */
        public String  ParsingJSON(Map<String, String[]> params) {
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
        public int RandomNumber() {
            int x;//定义变量
            Random ne = new Random();//实例化一个random的对象ne
            x = ne.nextInt(999999 - 100000 + 1) + 100000;//为变量赋随机值10000-99999
            return x;
        }

        public boolean QRCode(String content, String FileName, String ServerPath) {
            boolean flag;
            final int width = 300;
            final int height = 300;
            final String format = "png";

            //定义二维码的参数
            Map hints = new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
            hints.put(EncodeHintType.MARGIN, 2);

            //生成二维码
            try {
                //OutputStream stream = new OutputStreamWriter();
                BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
                File file = new File(ServerPath);
                if (!file.exists()) {
                    file.mkdirs();
                }
                Path filePath = new File(ServerPath + FileName + ".png").toPath();
                MatrixToImageWriter.writeToPath(bitMatrix, format, filePath);
                //MatrixToImageWriter.writeToStream(bitMatrix, format, stream);
                flag = true;
            } catch (Exception e) {
                flag = false;
                e.printStackTrace();
            }
            return flag;
        }
}
