package com.tencent.cloud.huiyansdkface.wehttp2;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/WeLogUtils.class */
public class WeLogUtils {
    private static void a(JSONArray jSONArray, int i) throws JSONException {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= jSONArray.length()) {
                return;
            }
            Object obj = jSONArray.get(i3);
            if (obj instanceof String) {
                jSONArray.put(i3, getShortString((String) obj, i));
            } else if (obj instanceof JSONArray) {
                a((JSONArray) obj, i);
            } else if (obj instanceof JSONObject) {
                a((JSONObject) obj, i);
            }
            i2 = i3 + 1;
        }
    }

    private static void a(JSONObject jSONObject, int i) throws JSONException {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            if (opt instanceof String) {
                jSONObject.put(next, getShortString((String) opt, i));
            } else if (opt instanceof JSONArray) {
                a((JSONArray) opt, i);
            } else if (opt instanceof JSONObject) {
                a((JSONObject) opt, i);
            }
        }
    }

    public static Object getShortString(String str, int i) {
        String str2 = str;
        if (str.length() > i) {
            StringBuilder sb = new StringBuilder();
            int i2 = i / 2;
            sb.append(str.substring(0, i2));
            sb.append(".....");
            sb.append((str.length() - i2) - i2);
            sb.append("omitted.........");
            sb.append(str.substring(str.length() - i2));
            str2 = sb.toString();
        }
        return str2;
    }

    public static String toPrettyJson(String str, boolean z, int i) throws JSONException {
        String trim = str.trim();
        if (trim.startsWith("[")) {
            JSONArray jSONArray = new JSONArray(trim);
            if (z) {
                a(jSONArray, i);
            }
            return jSONArray.toString(4);
        }
        String str2 = trim;
        if (trim.startsWith("{")) {
            JSONObject jSONObject = new JSONObject(trim);
            if (z) {
                a(jSONObject, i);
            }
            str2 = jSONObject.toString(4);
        }
        return str2;
    }
}
