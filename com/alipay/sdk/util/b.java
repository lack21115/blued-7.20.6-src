package com.alipay.sdk.util;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/util/b.class */
public class b {
    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 2) {
                break;
            }
            JSONObject jSONObject4 = new JSONObject[]{jSONObject, jSONObject2}[i2];
            if (jSONObject4 != null) {
                try {
                    Iterator<String> keys = jSONObject4.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject3.put(next, jSONObject4.get(next));
                    }
                } catch (JSONException e) {
                    c.a(e);
                }
            }
            i = i2 + 1;
        }
        return jSONObject3;
    }
}
