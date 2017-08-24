package com.example.demo.demoone;

import java.security.MessageDigest;

/**
 * Created by thomasliao on 2017/6/21.
 */
public class ParameterUtil {
    public static String getSha1(String str) {
        if (str == null || str.length() == 0) {
            return null ;
        }
        char hexDigits [] = { '0' , '1' , '2' , '3' , '4', '5' , '6' , '7' , '8' , '9' ,
                'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update( str.getBytes( "UTF-8"));

            byte[] md = mdTemp .digest();
            int j = md .length ;
            char buf [] = new char[ j * 2];
            int k = 0;
            for (int i = 0; i < j ; i ++) {
                byte byte0 = md [i ];
                buf[ k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[ k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf );
        } catch (Exception e ) {
            return null ;
        }
    }

    public static String getUpperCaseSha1(String str) {
        return getSha1(str).toUpperCase();
    }

    public static String getCurrentTime() {
        long now = System.currentTimeMillis();//已经是13位
        return now + "";
    }

    public static String getSecretKey() {
        return "GQ8iHtcbkV";
    }

    public static String getUserId() {
        return "e4e92c8c43";
    }
}
