package com.tencent.tendinsv.d;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/d/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static volatile g f39037a;

    private g() {
    }

    public static g a() {
        if (f39037a == null) {
            synchronized (g.class) {
                try {
                    if (f39037a == null) {
                        f39037a = new g();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f39037a;
    }

    public Map<String, String> a(String str, String str2, String str3, String str4, String str5) {
        HashMap hashMap = new HashMap();
        hashMap.put("packageSign", str);
        hashMap.put("appId", str2);
        hashMap.put("client", com.tencent.tendinsv.b.as);
        hashMap.put("bundleld", "");
        hashMap.put("packageName", str4);
        hashMap.put("randoms", str3);
        hashMap.put("version", com.tencent.tendinsv.b.ao);
        hashMap.put("device", str5);
        return hashMap;
    }

    public Map<String, String> a(String str, String str2, String str3, String str4, String str5, String str6) {
        HashMap hashMap = new HashMap();
        hashMap.put("packageSign", str);
        hashMap.put("appId", str2);
        hashMap.put("client", com.tencent.tendinsv.b.as);
        hashMap.put("bundleld", "");
        hashMap.put("packageName", str4);
        hashMap.put("randoms", str3);
        hashMap.put("version", com.tencent.tendinsv.b.ao);
        hashMap.put("sign", str5);
        hashMap.put("device", str6);
        return hashMap;
    }

    public Map<String, String> b(String str, String str2, String str3, String str4, String str5) {
        HashMap hashMap = new HashMap();
        hashMap.put("appId", str);
        hashMap.put("randoms", str2);
        hashMap.put("content", str3);
        hashMap.put("packageName", str4);
        hashMap.put("packageSign", str5);
        return hashMap;
    }
}
