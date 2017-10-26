package com.live.demo.util;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;

import java.util.Map;
import java.util.UUID;

/**
 * Created by TingYu Zhu on 2017/10/23.
 */

public class UuidManager {

    Context context;

    TelephonyManager telephonyManager;


    public UuidManager(Context context){
        this.context = context;
        telephonyManager = (TelephonyManager) context.getSystemService(context.TELEPHONY_SERVICE);
    }

    public String getMeid(){

        String value = "";

        if (Build.VERSION.SDK_INT < 21) {
            //如果获取系统的IMEI/MEID，14位代表meid 15位是imei
            if (GetSystemInfoUtil.getNumber(context) == 14) {
                value =  GetSystemInfoUtil.getImeiOrMeid(context);//meid
            } else if (GetSystemInfoUtil.getNumber(context) == 15) {
                value = GetSystemInfoUtil.getImeiOrMeid(context);//imei1
            }

            // 21版本是5.0，判断是否是5.0以上的系统  5.0系统直接获取IMEI1,IMEI2,MEID
        } else if (Build.VERSION.SDK_INT >= 21) {
            Map<String, String> map = GetSystemInfoUtil.getImeiAndMeid(context);
            value =  map.get("meid")+ " imei1：  "
                    + map.get("imei1")
                    + " imei2：  " + map.get("imei2")
                    + " id1：  " + map.get("id1")
                    + " id2：  " + map.get("id2");
        }
        return value;
    }

    public static String getUniquePsuedoID() {
        String serial = null;

        String m_szDevIDShort = "35" +
                Build.BOARD.length() % 10 + Build.BRAND.length() % 10 +

                Build.CPU_ABI.length() % 10 + Build.DEVICE.length() % 10 +

                Build.DISPLAY.length() % 10 + Build.HOST.length() % 10 +

                Build.ID.length() % 10 + Build.MANUFACTURER.length() % 10 +

                Build.MODEL.length() % 10 + Build.PRODUCT.length() % 10 +

                Build.TAGS.length() % 10 + Build.TYPE.length() % 10 +

                Build.USER.length() % 10; //13 位

        try {
            serial = android.os.Build.class.getField("SERIAL").get(null).toString();
            //API>=9 使用serial号
            return new UUID(m_szDevIDShort.hashCode(), serial.hashCode()).toString();
        } catch (Exception exception) {
            //serial需要一个初始化
            serial = "serial"; // 随便一个初始化
        }
        //使用硬件信息拼凑出来的15位号码
        return new UUID(m_szDevIDShort.hashCode(), serial.hashCode()).toString();
    }

}
