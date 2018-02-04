package com.example.yukai.mydefinedview.Utils;

/**
 * Created by yukai on 2018/2/4.
 */

public class StringUtils {

    public static boolean emptyOrNull(String string){
        return string == null || string.equals("");
    }

    public static int toInt(String string){
        int result = 0;
        try {
            result = Integer.parseInt(string);
        }catch (Exception e){
            result = -1;
        }
        return result;
    }

    public static double toDouble(String string){
        Double result = 0d;
        try {
            result = Double.parseDouble(string);
        }catch (Exception e){
            result = -1d;
        }
        return result;
    }

}
