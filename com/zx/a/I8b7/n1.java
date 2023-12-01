package com.zx.a.I8b7;

import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/n1.class */
public class n1 {
    public static String a(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i);
            jSONObject.put("message", str);
        } catch (Exception e) {
        }
        return jSONObject.toString();
    }
}
