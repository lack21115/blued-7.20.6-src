package com.zx.a.I8b7;

import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.bh;
import com.zx.a.I8b7.b1;
import com.zx.a.I8b7.c3;
import com.zx.a.I8b7.r;
import com.zx.a.I8b7.u1;
import com.zx.module.annotation.Java2C;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/a1.class */
public class a1 extends e {
    public static LinkedList<String> d = new LinkedList<>();

    @Java2C.Method2C
    private static native String a(String str, String str2, JSONObject jSONObject);

    @Java2C.Method2C
    private static native String a(String str, JSONObject jSONObject);

    @Java2C.Method2C
    private static native HashMap<String, String> a(String str);

    @Java2C.Method2C
    private static native HashMap<String, String> a(JSONArray jSONArray) throws JSONException;

    @Java2C.Method2C
    private static native HashMap<String, String> a(JSONArray jSONArray, JSONObject jSONObject) throws JSONException;

    @Java2C.Method2C
    private static native JSONObject a(JSONArray jSONArray, HashMap<String, String> hashMap, JSONObject jSONObject);

    @Java2C.Method2C
    private static native void a(HashMap<String, String> hashMap, String str, JSONObject jSONObject, HashMap<String, String> hashMap2, boolean z) throws JSONException;

    @Java2C.Method2C
    private static native void a(JSONObject jSONObject, HashMap<String, String> hashMap, String str, String str2) throws JSONException;

    @Java2C.Method2C
    private static native HashMap<String, String> b() throws JSONException;

    @Java2C.Method2C
    private static native JSONObject b(JSONArray jSONArray, HashMap<String, String> hashMap, JSONObject jSONObject);

    @Java2C.Method2C
    private static native JSONObject c();

    @Java2C.Method2C
    private static native JSONObject c(JSONArray jSONArray, HashMap<String, String> hashMap, JSONObject jSONObject);

    @Java2C.Method2C
    private static native String d() throws Exception;

    @Java2C.Method2C
    private static native JSONObject e();

    @Java2C.Method2C
    private static native JSONObject f();

    public static void g() throws Throwable {
        if (t.a()) {
            return;
        }
        b1.a aVar = new b1.a();
        HashMap<String, String> b = a0.b(e.a());
        aVar.f42107c.clear();
        aVar.f42107c.putAll(b);
        b1.a a2 = aVar.a("https://zxid-m.mobileservice.cn/sdk/channel/report");
        a2.b = "POST";
        a2.d = d1.a(n0.b("application/json; charset=utf-8"), d());
        a2.e = "request zxid api";
        w1 w1Var = a0.f42098a;
        b1 b1Var = new b1(aVar);
        w1Var.getClass();
        e1 a3 = new u0(w1Var, b1Var).a();
        if (a3.b != 200) {
            String a4 = a3.a("Udid-Error-Code");
            String a5 = a3.a("Udid-Error-Message");
            throw new RuntimeException("response errCode: " + a4 + ", errMsg: " + a5);
        }
        u1 u1Var = u1.a.f42208a;
        b3 b3Var = u1Var.f42207a;
        long currentTimeMillis = System.currentTimeMillis();
        b3Var.getClass();
        if (currentTimeMillis != t2.r) {
            t2.r = currentTimeMillis;
            b3 b3Var2 = u1Var.f42207a;
            b3Var2.a(8, t2.r + "", false);
            z1.a("lastRequestTime had changed refresh:" + t2.r);
        }
        r rVar = r.b.f42190a;
        rVar.getClass();
        s sVar = new s(rVar);
        try {
            AtomicInteger atomicInteger = c3.f42112c;
            c3.c.f42114a.b.execute(sVar);
        } catch (Throwable th) {
            z1.a(th);
        }
        JSONObject jSONObject = new JSONObject(a3.e.b());
        int i = jSONObject.getInt("syncId");
        u1 u1Var2 = u1.a.f42208a;
        u1Var2.f42207a.d(i);
        JSONObject jSONObject2 = new JSONObject(k.a(Base64.decode(jSONObject.getString("data"), 2), e.f42118a, "UDID_ENC_AUTHTAG"));
        String string = jSONObject2.getString(bh.al);
        u1Var2.f42207a.getClass();
        if (!TextUtils.equals(string, t2.i)) {
            t2.i = string;
            u1Var2.f42207a.a(1, string, true);
            z1.a("zid had changed refresh:" + string);
        }
        JSONObject optJSONObject = jSONObject2.optJSONObject("aids");
        JSONObject optJSONObject2 = jSONObject2.optJSONObject("aidsExt");
        JSONObject jSONObject3 = optJSONObject2;
        if (optJSONObject2 == null) {
            jSONObject3 = new JSONObject();
        }
        if (!TextUtils.isEmpty(t2.f) && optJSONObject != null) {
            jSONObject3.put(t2.f, optJSONObject);
        }
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("tags", jSONObject2.optJSONArray("tags"));
        jSONObject4.put("aids", jSONObject3);
        if (jSONObject2.has("openid")) {
            jSONObject4.put("openid", d3.f42117c.get("ed6e6f5009a2"));
        }
        u1Var2.f42207a.getClass();
        String jSONObject5 = jSONObject4.toString();
        if (!TextUtils.isEmpty(jSONObject5)) {
            t2.j = jSONObject5;
            u1Var2.f42207a.a(16, jSONObject5, true);
            z1.a("ext had changed refresh:" + jSONObject4);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("cmds");
        b3 b3Var3 = u1Var2.f42207a;
        String str = t2.B;
        b3Var3.getClass();
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, t2.A)) {
            t2.A = str;
            u1Var2.f42207a.a(13, str, true);
        }
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("iaps");
        try {
            JSONArray jSONArray = new JSONArray();
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= optJSONArray2.length()) {
                        break;
                    }
                    jSONArray.put(k.a(Base64.decode(optJSONArray2.getString(i3), 2), e.f42118a, "UDID_ENC_AUTHTAG"));
                    i2 = i3 + 1;
                }
            }
            u1 u1Var3 = u1.a.f42208a;
            u1Var3.f42207a.getClass();
            u1Var3.f42207a.a(25, jSONArray.toString(), true);
        } catch (Throwable th2) {
        }
        if (optJSONArray == null) {
            return;
        }
        try {
            if (optJSONArray.length() == 0) {
                return;
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= optJSONArray.length()) {
                    return;
                }
                int i6 = optJSONArray.getInt(i5);
                if (i6 == 1) {
                    z1.a("cmd 1 REQUEST_CONFIG ");
                    AtomicInteger atomicInteger2 = c3.f42112c;
                    c3.c.f42114a.f42113a.execute(new w0());
                } else if (i6 == 2) {
                    u1.a.f42208a.f42207a.d(0);
                } else if (i6 == 3) {
                    AtomicInteger atomicInteger3 = c3.f42112c;
                    c3.c.f42114a.f42113a.execute(new x0());
                } else if (i6 == 4) {
                    AtomicInteger atomicInteger4 = c3.f42112c;
                    c3.c.f42114a.f42113a.execute(new y0());
                } else if (i6 == 5) {
                    AtomicInteger atomicInteger5 = c3.f42112c;
                    c3.c.f42114a.f42113a.execute(new z0());
                }
                i4 = i5 + 1;
            }
        } catch (Throwable th3) {
            z1.a(th3);
        }
    }
}
