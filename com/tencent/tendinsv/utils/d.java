package com.tencent.tendinsv.utils;

import android.content.Context;
import com.tencent.tendinsv.a.b;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/utils/d.class */
public class d {
    public static String a(int i, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(b.a.C, i);
            jSONObject.put(b.a.D, str);
            jSONObject.put("message", str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String a(int i, String str, String str2, Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(b.a.C, i);
            jSONObject.put(b.a.D, str);
            jSONObject.put("message", str2);
            jSONObject.put("number", com.tencent.tendinsv.b.v);
            jSONObject.put("telecom", com.tencent.tendinsv.b.p);
            jSONObject.put(com.tencent.tendinsv.b.q, com.tencent.tendinsv.b.r);
            jSONObject.put(com.tencent.tendinsv.b.s, com.tencent.tendinsv.b.t);
            t.a(context, "telecom", com.tencent.tendinsv.b.p);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String a(int i, String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(b.a.C, i);
            jSONObject.put(b.a.D, str);
            jSONObject.put("message", str2);
            jSONObject.put("number", "");
            jSONObject.put("telecom", str3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String a(Object obj) {
        return a(obj, null);
    }

    private static String a(Object obj, String str) {
        return obj == null ? str : String.valueOf(obj);
    }

    public static String a(String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", str);
            jSONObject.put("ticket", str2);
            jSONObject.put("appid", str3);
            jSONObject.put("bizState", str4);
            jSONObject.put("randstr", str5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                return jSONObject.has("resultDesc") ? jSONObject.optString("resultDesc") : jSONObject.has("desc") ? jSONObject.optString("desc") : jSONObject.toString();
            } catch (Exception e) {
                e.printStackTrace();
                return jSONObject.toString();
            }
        }
        return "";
    }

    public static boolean a(String str) {
        return str == null || "".equals(str) || str.trim().length() == 0;
    }

    public static String b(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                return jSONObject.has("resultDesc") ? jSONObject.optString("resultDesc") : jSONObject.toString();
            } catch (Exception e) {
                e.printStackTrace();
                return jSONObject.toString();
            }
        }
        return "";
    }

    public static boolean b(String str) {
        return (str == null || com.igexin.push.core.b.l.equals(str) || "".equals(str)) ? false : true;
    }

    public static String c(String str) {
        try {
            return b(str) ? new JSONObject(str).optString("retMsg") : "result isEmpty";
        } catch (JSONException e) {
            e.printStackTrace();
            l.d(com.tencent.tendinsv.b.F, "getResMsg--Exception_e=", e);
            return str;
        }
    }

    public static String d(String str) {
        try {
            return new JSONObject(str).optString("msg");
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String e(String str) {
        try {
            if (!com.tencent.tendinsv.b.aw.equals(str)) {
                if (com.tencent.tendinsv.b.az.equals(str)) {
                    return str;
                }
                String optString = new JSONObject(str).optString("message");
                return a(optString) ? str : optString;
            }
        } catch (Exception e) {
            l.d(com.tencent.tendinsv.b.F, "getJsonMessage--Exception_e=", e);
        }
        return str;
    }
}
