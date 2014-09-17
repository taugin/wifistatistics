package com.chukong.wifistatistics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.chukong.wifistatistics.service.AccessPoint;
import com.chukong.wifistatistics.service.JsonUtil;
import com.chukong.wifistatistics.service.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        AccessPoint point = null;
        int index = 0;
        ArrayList<AccessPoint> list = new ArrayList<AccessPoint>();
        while (index < 10) {
            point = new AccessPoint();
            point.SSID = getRandomString(10);
            point.BSSID = getRandomMacAddress();// "FF-FF-FF-FF-FF-FF";
            point.capabilities = "test";
            point.frequency = 14;
            point.level = new Random(System.currentTimeMillis()).nextInt();
            point.connecting = false;
            point.timestamp = System.currentTimeMillis();
            list.add(point);
            index++;
        }

        JsonUtil util = new JsonUtil();
        String jsonString1 = util.toJsonString(point);
        String jsonString2 = util.toJsonArray(list);
        Log.d(Log.TAG, "s = " + jsonString1);
        Log.d(Log.TAG, "s = " + jsonString2);

        List<AccessPoint> l2 = util.toAccessList(jsonString2);
        for (AccessPoint a : l2) {
            Log.d(Log.TAG, "\n" + a.toString());
        }
    }

    public static String getRandomString(int length) { // length表示生成字符串的长度
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public static String getRandomMacAddress() { // length表示生成字符串的长度
        String base = "0123456789ABCDEF";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 12; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
            if (i % 2 == 1 && i != 11) {
                sb.append("-");
            }
        }
        return sb.toString();
    }
}
