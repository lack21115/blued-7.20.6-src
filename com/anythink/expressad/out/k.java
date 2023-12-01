package com.anythink.expressad.out;

import android.net.Uri;
import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/out/k.class */
public class k implements com.anythink.expressad.e.b {

    /* renamed from: a  reason: collision with root package name */
    public static final int f5235a = 6;
    public static final int b = 7;

    /* renamed from: c  reason: collision with root package name */
    public static final int f5236c = 8;
    private static String d = "CustomInfoManager";
    private static volatile k e;
    private ConcurrentHashMap<String, String> f = new ConcurrentHashMap<>();

    private k() {
    }

    public static k a() {
        if (e == null) {
            synchronized (k.class) {
                try {
                    if (e == null) {
                        e = new k();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return e;
    }

    private String a(String str, int i) {
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            if (i != 6) {
                if (i != 7) {
                    return i != 8 ? "" : this.f.get(str);
                }
                ConcurrentHashMap<String, String> concurrentHashMap = this.f;
                return concurrentHashMap.get(str + "_bidload");
            }
            ConcurrentHashMap<String, String> concurrentHashMap2 = this.f;
            str2 = concurrentHashMap2.get(str + "_bid");
        }
        return str2;
    }

    private void a(String str, int i, String str2) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        String a2 = com.anythink.expressad.foundation.h.j.a(str2);
        if (i == 6) {
            ConcurrentHashMap<String, String> concurrentHashMap = this.f;
            concurrentHashMap.put(str + "_bid", a2);
        } else if (i != 7) {
            if (i != 8) {
                return;
            }
            this.f.put(str, a2);
        } else {
            ConcurrentHashMap<String, String> concurrentHashMap2 = this.f;
            concurrentHashMap2.put(str + "_bidload", a2);
        }
    }

    public final String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            Uri parse = Uri.parse(str2);
            if (parse != null) {
                String host = parse.getHost();
                String path = parse.getPath();
                return (TextUtils.isEmpty(host) || !host.contains("hb") || TextUtils.isEmpty(path) || !path.contains("bid")) ? (TextUtils.isEmpty(host) || !host.contains("hb") || TextUtils.isEmpty(path) || !path.contains("load")) ? (TextUtils.isEmpty(path) || !path.contains(com.anythink.expressad.foundation.g.a.j)) ? "" : a(str, 8) : a(str, 7) : a(str, 6);
            }
            return "";
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.b(d, "Exception", th);
            return "";
        }
    }
}
