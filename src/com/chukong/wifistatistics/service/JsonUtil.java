package com.chukong.wifistatistics.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtil {

    public String toJsonString(AccessPoint point) {
        try {
            JSONObject obj = new JSONObject();
            obj.put("SSID", point.SSID);
            obj.put("BSSID", point.BSSID);
            obj.put("capabilities", point.capabilities);
            obj.put("level", point.level);
            obj.put("frequency", point.frequency);
            obj.put("timestamp", point.timestamp);
            obj.put("connecting", point.connecting);
            return obj.toString();
        } catch (JSONException e) {
            Log.d(Log.TAG, "error  : " + e);
        }
        return null;
    }

    public String toJsonArray(List<AccessPoint> list) {
        try {
            JSONObject jsonObject = new JSONObject();
            JSONArray array = new JSONArray();
            JSONObject obj = null;
            for (AccessPoint point : list) {
                obj = new JSONObject(toJsonString(point));
                array.put(obj);
            }
            jsonObject.put("accesspoint", array);
            return jsonObject.toString();
        } catch (JSONException e) {
            Log.d(Log.TAG, "error  : " + e);
        }
        return null;
    }

    public AccessPoint toAccessPoint(String jsonString) {
        try {
            JSONObject obj = new JSONObject(jsonString);
            JSONArray array = obj.getJSONArray("accesspoint");
        } catch (JSONException e) {
            Log.d(Log.TAG, "error  : " + e);
        }
        return null;
    }

    public AccessPoint toAccessPoint(JSONObject jsonObj) {
        try {
            if (jsonObj == null) {
                return null;
            }
            AccessPoint point = new AccessPoint();
            point.SSID = jsonObj.getString("SSID");
            point.BSSID = jsonObj.getString("BSSID");
            point.capabilities = jsonObj.getString("capabilities");
            point.level = jsonObj.getInt("level");
            point.frequency = jsonObj.getInt("frequency");
            point.timestamp = jsonObj.getLong("timestamp");
            point.connecting = jsonObj.getBoolean("connecting");
            return point;
        } catch (JSONException e) {
            Log.d(Log.TAG, "error  : " + e);
        }
        return null;
    }

    public List<AccessPoint> toAccessList(String jsonString) {
        try {
            JSONObject obj = new JSONObject(jsonString);
            JSONArray array = obj.getJSONArray("accesspoint");
            int len = array.length();
            int index = 0;
            ArrayList<AccessPoint> list = new ArrayList<AccessPoint>();
            AccessPoint point = null;
            JSONObject aobj = null;
            while (index < len) {
                aobj = array.getJSONObject(index);
                point = toAccessPoint(aobj);
                list.add(point);
                index++;
            }
            return list;
        } catch (JSONException e) {
            Log.d(Log.TAG, "error  : " + e);
        }
        return null;
    }

    public AccessPoint[] toAccessArray(String jsonString) {
        return null;
    }
}
