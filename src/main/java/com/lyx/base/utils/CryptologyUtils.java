package com.lyx.base.utils;

import java.util.Base64;

public class CryptologyUtils {

    public static byte[] base64Encode(byte[] data){
        return base64Encode(data,0);
    }

    public static byte[] base64Encode(byte[] data,int offset){
        if (offset != 0){
            for (int i = 0; i < data.length; i++){
                data[i] = (byte) (data[i] << offset | data[i] >> (8-offset));
                Integer a = new Integer(data[i] & 0x0ff);
                byte bya = a.byteValue();
                System.out.println(a);
            }
        }
        return Base64.getEncoder().encode(data);
    }

    public static byte[] base64Decode(byte[] data){
        return base64Decode(data,0);
    }

    public static byte[] base64Decode(byte[] data,int offset){
        if (offset != 0){
            for (int i = 0; i < data.length; i++){
                data[i] = (byte) (data[i] >> offset | data[i] >> (8-offset));
            }
        }
        return Base64.getDecoder().decode(data);
    }
}
