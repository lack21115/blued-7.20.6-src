package com.oplus.log.d;

import android.text.TextUtils;
import android.util.Base64;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/log/d/g.class */
public final class g {
    private static Map<String, String> q = new ConcurrentHashMap(16);

    /* renamed from: a  reason: collision with root package name */
    public static final String f24360a = a("T1BQTw==");
    public static final String b = a(com.cdo.oaps.ad.a.f21514c);

    /* renamed from: c  reason: collision with root package name */
    public static final String f24361c = a("T3Bwbw==");
    public static final String d = a("UmVhbG1l");
    public static final String e = a("cmVhbG1l");
    public static final String f = a("T25lUGx1cw==");
    public static final String g = a("b25lcGx1cw==");
    public static final String h = a("Q29sb3JPUw==");
    public static final String i = a("Q09MT1JPUw==");
    public static final String j = a("Y29sb3Jvcw==");
    public static final String k = a("Y29sb3JPUw==");
    public static final String l = a("Y29sb3I=");
    public static final String m = a("Q29sb3JCdWlsZA==");
    public static final String n = a("T3BsdXNPUw==");
    public static final String o = a("SHlkcm9nZW4gT1Mg");
    public static final String p = a("T3h5Z2VuIE9TIA==");

    private static String a(String str) {
        String str2 = q.get(str);
        String str3 = str2;
        if (TextUtils.isEmpty(str2)) {
            str3 = new String(Base64.decode(str.getBytes(), 0));
            q.put(str, str3);
        }
        return str3;
    }
}
