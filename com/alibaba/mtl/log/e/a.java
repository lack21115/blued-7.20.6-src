package com.alibaba.mtl.log.e;

import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bw;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/e/a.class */
public class a {

    /* renamed from: com.alibaba.mtl.log.e.a$a  reason: collision with other inner class name */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/e/a$a.class */
    public static class C0043a {

        /* renamed from: a  reason: collision with root package name */
        public static C0043a f4490a = new C0043a();
        public boolean G = false;
        public String ad = null;

        public boolean i() {
            return "E0102".equalsIgnoreCase(this.ad);
        }

        public boolean j() {
            return "E0111".equalsIgnoreCase(this.ad) || "E0112".equalsIgnoreCase(this.ad);
        }
    }

    public static C0043a a(String str) {
        C0043a c0043a = new C0043a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(bw.o)) {
                String string = jSONObject.getString(bw.o);
                if (!TextUtils.isEmpty(string) && string.equals(bw.o)) {
                    c0043a.G = true;
                }
            }
            if (jSONObject.has("ret")) {
                c0043a.ad = jSONObject.getString("ret");
                return c0043a;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return c0043a;
    }
}
