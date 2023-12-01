package com.tencent.qimei.a;

import android.util.Base64;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/a/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, String> f38310a;

    static {
        ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
        f38310a = concurrentHashMap;
        concurrentHashMap.put(0, a("aWVtaXE="));
        f38310a.put(1, a("NjNpZW1pcQ=="));
        f38310a.put(2, a("QVRHTkVEX0lFTUlR"));
        f38310a.put(3, a("MV9JRU1JUV9OT0NBRUI="));
        f38310a.put(4, a("MnZfaWVtaXE="));
        f38310a.put(5, a("ZGlhbw=="));
        f38310a.put(6, a("aWVtaQ=="));
        f38310a.put(7, a("aXNtaQ=="));
        f38310a.put(8, a("Y2Ft"));
        f38310a.put(9, a("ZGlj"));
        f38310a.put(10, a("aWVtaVFldGFkcHU="));
        f38310a.put(11, a("ZElkaW9yZG5h"));
        f38310a.put(12, a("ZHJhb2IudGN1ZG9ycC5vcg=="));
        f38310a.put(13, a("ZG5hcmIudGN1ZG9ycC5vcg=="));
        f38310a.put(14, a("ZWNpdmVkLnRjdWRvcnAub3I="));
        f38310a.put(15, a("bGV2ZWxfaXBhX3RzcmlmLnRjdWRvcnAub3I="));
        f38310a.put(16, a("cmVydXRjYWZ1bmFtLnRjdWRvcnAub3I="));
        f38310a.put(17, a("ZW1hbi50Y3Vkb3JwLm9y"));
        f38310a.put(18, a("dHNvaC5kbGl1Yi5vcg=="));
    }

    public static String a(int i) {
        String str = f38310a.get(Integer.valueOf(i));
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    public static String a(String str) {
        try {
            return new StringBuilder(new String(Base64.decode(str, 2))).reverse().toString();
        } catch (Exception e) {
            com.tencent.qimei.k.a.a(e);
            return "";
        }
    }
}
