package com.bytedance.bdtracker;

import android.text.TextUtils;
import com.bytedance.applog.network.RangersHttpException;
import com.bytedance.applog.picker.DomSender;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/k1.class */
public class k1 extends q1 {
    public k1(c cVar) {
        super(cVar);
    }

    public JSONObject a(String str, String str2, String str3, List<DomSender.a> list) {
        String str4;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                JSONObject jSONObject2 = new JSONObject();
                Object jSONObject3 = new JSONObject();
                if (i2 == 0) {
                    jSONObject3 = q1.a(str, str2);
                    jSONObject.put("header", jSONObject3);
                    jSONObject.put("img", list.get(i2).f21178a);
                    jSONObject.put(com.umeng.analytics.pro.d.t, list.get(i2).b);
                } else {
                    jSONObject2.put("header", jSONObject3);
                    jSONObject2.put("img", list.get(i2).f21178a);
                    jSONObject2.put(com.umeng.analytics.pro.d.t, list.get(i2).b);
                    jSONArray.put(jSONObject2);
                }
                jSONObject3.put("width", list.get(i2).f21179c);
                jSONObject3.put("height", list.get(i2).d);
                i = i2 + 1;
            }
            jSONObject.put("extra", jSONArray);
        } catch (JSONException e) {
            z2.a(e);
        }
        HashMap<String, String> hashMap = new HashMap<>(2);
        hashMap.put("Content-Type", this.b.A ? "application/octet-stream;tt-data=a" : "application/json; charset=utf-8");
        hashMap.put("Cookie", str3);
        try {
            str4 = a(1, this.b.j.f21290a + "/simulator/mobile/layout", hashMap, this.b.j.f21291c.b(jSONObject.toString()));
        } catch (RangersHttpException e2) {
            str4 = null;
        }
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        try {
            return new JSONObject(str4);
        } catch (JSONException e3) {
            z2.c("U SHALL NOT PASS!", e3);
            return null;
        }
    }
}
