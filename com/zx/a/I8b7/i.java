package com.zx.a.I8b7;

import android.text.TextUtils;
import android.util.Base64;
import com.zx.a.I8b7.b1;
import com.zx.a.I8b7.u1;
import com.zx.module.annotation.Java2C;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/i.class */
public class i extends e {
    @Java2C.Method2C
    private static native String b() throws Exception;

    public static void c() throws Exception {
        b1.a aVar = new b1.a();
        HashMap<String, String> b = a0.b(e.a());
        aVar.f42107c.clear();
        aVar.f42107c.putAll(b);
        b1.a a2 = aVar.a("https://zxid-m.mobileservice.cn/sdk/config/init");
        a2.b = "POST";
        a2.d = d1.a(n0.b("application/json; charset=utf-8"), b());
        a2.e = "request config api";
        w1 w1Var = a0.f42098a;
        b1 b1Var = new b1(aVar);
        w1Var.getClass();
        e1 a3 = new u0(w1Var, b1Var).a();
        if (a3.b != 200) {
            String a4 = a3.a("Udid-Error-Code");
            String a5 = a3.a("Udid-Error-Message");
            throw new RuntimeException("response errCode: " + a4 + ", errMsg: " + a5);
        }
        JSONObject jSONObject = new JSONObject(k.a(Base64.decode(new JSONObject(a3.e.b()).getString("data"), 2), e.f42118a, "UDID_ENC_AUTHTAG"));
        String string = jSONObject.getString("configVersion");
        u1 u1Var = u1.a.f42208a;
        u1Var.f42207a.getClass();
        if (!TextUtils.equals(string, t2.l)) {
            t2.l = string;
            u1Var.f42207a.a(4, string, false);
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("fieldConfig");
        b3 b3Var = u1Var.f42207a;
        String jSONObject3 = jSONObject2.toString();
        b3Var.getClass();
        if (!TextUtils.equals(jSONObject3, t2.u)) {
            t2.u = jSONObject3;
            u1Var.f42207a.a(11, jSONObject3, true);
        }
        JSONObject jSONObject4 = jSONObject.getJSONObject("reportConfig");
        b3 b3Var2 = u1Var.f42207a;
        String jSONObject5 = jSONObject4.toString();
        b3Var2.getClass();
        if (!TextUtils.equals(jSONObject5, t2.v)) {
            t2.v = jSONObject5;
            u1Var.f42207a.a(12, jSONObject5, true);
        }
        JSONObject jSONObject6 = jSONObject.getJSONObject("cryptoConfig");
        b3 b3Var3 = u1Var.f42207a;
        String jSONObject7 = jSONObject6.toString();
        b3Var3.getClass();
        if (!TextUtils.equals(jSONObject7, t2.w)) {
            t2.w = jSONObject7;
            u1Var.f42207a.a(15, jSONObject7, true);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("appConfig");
        if (optJSONObject != null) {
            z1.a("处理 appConfig ");
            try {
                JSONArray jSONArray = optJSONObject.getJSONArray("list");
                if (jSONArray == null || jSONArray.length() <= 0) {
                    z1.b("appConfig list is empty");
                } else {
                    int length = jSONArray.length();
                    int i = optJSONObject.getInt("type");
                    if (i == 1) {
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= length) {
                                break;
                            }
                            jSONArray.put(i3, k.a(Base64.decode(jSONArray.getString(i3), 2), e.f42118a, "UDID_ENC_AUTHTAG"));
                            i2 = i3 + 1;
                        }
                    } else if (i == 3) {
                        SecretKey a6 = k.a(e.b, t2.a(t2.h));
                        int i4 = 0;
                        while (true) {
                            int i5 = i4;
                            if (i5 >= length) {
                                break;
                            }
                            jSONArray.put(i5, new String(k.a("AES/CBC/PKCS7Padding", a6, new IvParameterSpec("UDID_ENC_AUTHTAG".getBytes(StandardCharsets.UTF_8)), Base64.decode(jSONArray.getString(i5), 2)), StandardCharsets.UTF_8));
                            i4 = i5 + 1;
                        }
                    }
                    u1 u1Var2 = u1.a.f42208a;
                    b3 b3Var4 = u1Var2.f42207a;
                    String jSONObject8 = optJSONObject.toString();
                    b3Var4.getClass();
                    if (!TextUtils.equals(jSONObject8, t2.x)) {
                        t2.x = jSONObject8;
                        u1Var2.f42207a.a(21, jSONObject8, true);
                    }
                }
            } catch (Exception e) {
                z1.a(e);
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("commonConfig");
        if (optJSONObject2 != null) {
            u1 u1Var3 = u1.a.f42208a;
            b3 b3Var5 = u1Var3.f42207a;
            String jSONObject9 = optJSONObject2.toString();
            b3Var5.getClass();
            if (!TextUtils.equals(jSONObject9, t2.y)) {
                t2.y = jSONObject9;
                u1Var3.f42207a.a(22, jSONObject9, true);
            }
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("invokeConfig");
        if (optJSONObject3 != null) {
            u1 u1Var4 = u1.a.f42208a;
            b3 b3Var6 = u1Var4.f42207a;
            String jSONObject10 = optJSONObject3.toString();
            synchronized (b3Var6) {
                if (!TextUtils.equals(jSONObject10, t2.z)) {
                    t2.z = jSONObject10;
                    t2.c();
                    u1Var4.f42207a.a(19, t2.z, true);
                }
            }
        }
        if (t2.m) {
            return;
        }
        u1 u1Var5 = u1.a.f42208a;
        u1Var5.f42207a.getClass();
        if (true != t2.m) {
            t2.m = true;
            b3 b3Var7 = u1Var5.f42207a;
            b3Var7.a(6, t2.m + "", false);
        }
    }
}
