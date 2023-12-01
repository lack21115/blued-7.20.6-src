package com.igexin.push.config;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/config/f.class */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23378a = "IDCConfigParse";

    public static void a(String str, boolean z) {
        JSONObject jSONObject;
        String[] a2;
        String[] a3;
        String[] a4;
        String[] a5;
        String[] a6;
        com.igexin.c.a.c.a.b(f23378a, " parse idc config data : ".concat(String.valueOf(str)));
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            jSONObject = null;
        }
        if (jSONObject == null) {
            return;
        }
        if (jSONObject.has("N")) {
            try {
                SDKUrlConfig.setLocation(jSONObject.getString("N"));
            } catch (JSONException e2) {
                com.igexin.c.a.c.a.a(e2);
            }
        }
        if (jSONObject.has("X1") && (a6 = a(jSONObject, "X1")) != null && a6.length > 0) {
            SDKUrlConfig.setXfrAddressIps(a6);
            if (z) {
                com.igexin.c.a.c.a.b("Detect_IDCConfigParse", "parse idc success, set new xfr address, reset and redetect +++++++++++++++++");
                com.igexin.push.b.c.a().e();
            }
        }
        if (jSONObject.has("X2") && (a5 = a(jSONObject, "X2")) != null && a5.length > 0) {
            SDKUrlConfig.XFR_ADDRESS_BAK = a5;
        }
        if (jSONObject.has("B") && (a4 = a(jSONObject, "B")) != null && a4.length > 0) {
            SDKUrlConfig.BI_ADDRESS_IPS = a4;
        }
        if (jSONObject.has("C") && (a3 = a(jSONObject, "C")) != null && a3.length > 0) {
            SDKUrlConfig.CONFIG_ADDRESS_IPS = a3;
        }
        if (!jSONObject.has("LO") || (a2 = a(jSONObject, "LO")) == null || a2.length <= 0) {
            return;
        }
        SDKUrlConfig.LOG_ADDRESS_IPS = a2;
    }

    private static String[] a(JSONObject jSONObject, String str) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(str);
            int length = jSONArray.length();
            String[] strArr = new String[length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return strArr;
                }
                if (!"X1".equals(str) && !"X2".equals(str)) {
                    strArr[i2] = "https://" + jSONArray.getString(i2);
                    i = i2 + 1;
                }
                strArr[i2] = "socket://" + jSONArray.getString(i2);
                i = i2 + 1;
            }
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }
}
