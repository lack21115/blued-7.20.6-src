package com.alibaba.mtl.log.e;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/e/a.class */
public class a {

    /* renamed from: com.alibaba.mtl.log.e.a$a  reason: collision with other inner class name */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/e/a$a.class */
    public static class C0003a {
        public static C0003a a = new C0003a();
        public boolean G = false;
        public String ad = null;

        public boolean i() {
            return "E0102".equalsIgnoreCase(this.ad);
        }

        public boolean j() {
            return "E0111".equalsIgnoreCase(this.ad) || "E0112".equalsIgnoreCase(this.ad);
        }
    }

    public static C0003a a(String str) {
        C0003a c0003a = new C0003a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("success")) {
                String string = jSONObject.getString("success");
                if (!TextUtils.isEmpty(string) && string.equals("success")) {
                    c0003a.G = true;
                }
            }
            if (jSONObject.has("ret")) {
                c0003a.ad = jSONObject.getString("ret");
                return c0003a;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return c0003a;
    }
}
