package com.bytedance.bdtracker;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/y2.class */
public class y2 {

    /* renamed from: a  reason: collision with root package name */
    public static final x2 f21338a = new x2();
    public static final Map<String, String> b = new ConcurrentHashMap();

    public static String a(String str) {
        String str2 = b.get(str);
        if (str2 != null) {
            return str2;
        }
        String a2 = f21338a.a(str);
        if (a2 != null) {
            b.put(str, a2);
        }
        return a2;
    }
}
