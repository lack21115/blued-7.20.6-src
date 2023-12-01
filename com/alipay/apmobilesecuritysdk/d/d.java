package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/apmobilesecuritysdk/d/d.class */
public final class d {
    public static Map<String, String> a() {
        HashMap hashMap;
        synchronized (d.class) {
            try {
                hashMap = new HashMap();
                try {
                    new com.alipay.apmobilesecuritysdk.c.b();
                    hashMap.put("AE16", "");
                } catch (Throwable th) {
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return hashMap;
    }

    public static Map<String, String> a(Context context) {
        HashMap hashMap;
        synchronized (d.class) {
            try {
                com.alipay.security.mobile.module.b.d.a();
                com.alipay.security.mobile.module.b.b.a();
                hashMap = new HashMap();
                hashMap.put("AE1", com.alipay.security.mobile.module.b.d.b());
                StringBuilder sb = new StringBuilder();
                sb.append(com.alipay.security.mobile.module.b.d.c() ? "1" : "0");
                hashMap.put("AE2", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(com.alipay.security.mobile.module.b.d.a(context) ? "1" : "0");
                hashMap.put("AE3", sb2.toString());
                hashMap.put("AE4", com.alipay.security.mobile.module.b.d.d());
                hashMap.put("AE5", com.alipay.security.mobile.module.b.d.e());
                hashMap.put("AE6", com.alipay.security.mobile.module.b.d.f());
                hashMap.put("AE7", com.alipay.security.mobile.module.b.d.g());
                hashMap.put("AE8", com.alipay.security.mobile.module.b.d.h());
                hashMap.put("AE9", com.alipay.security.mobile.module.b.d.i());
                hashMap.put("AE10", com.alipay.security.mobile.module.b.d.j());
                hashMap.put("AE11", com.alipay.security.mobile.module.b.d.k());
                hashMap.put("AE12", com.alipay.security.mobile.module.b.d.l());
                hashMap.put("AE13", com.alipay.security.mobile.module.b.d.m());
                hashMap.put("AE14", com.alipay.security.mobile.module.b.d.n());
                hashMap.put("AE15", com.alipay.security.mobile.module.b.d.o());
                hashMap.put("AE21", com.alipay.security.mobile.module.b.b.g());
            } catch (Throwable th) {
                throw th;
            }
        }
        return hashMap;
    }
}
