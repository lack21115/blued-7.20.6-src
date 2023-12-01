package com.umeng.ccg;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/ccg/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f40814a = true;
    private static volatile boolean b = true;

    /* renamed from: c  reason: collision with root package name */
    private static volatile boolean f40815c = true;
    private static volatile boolean d = true;
    private static Object e;
    private static Map<String, Boolean> f;

    static {
        if (0 == 0) {
            f = new HashMap();
            e = new Object();
        }
    }

    public static void a(boolean z) {
        synchronized (e) {
            d = z;
            f.put(a.e, Boolean.valueOf(z));
        }
    }

    public static boolean a() {
        boolean z;
        synchronized (e) {
            z = f40814a;
        }
        return z;
    }

    public static boolean a(String str) {
        boolean booleanValue;
        synchronized (e) {
            booleanValue = f.containsKey(str) ? f.get(str).booleanValue() : true;
        }
        return booleanValue;
    }

    public static boolean b() {
        boolean z;
        synchronized (e) {
            z = b;
        }
        return z;
    }

    public static boolean c() {
        boolean z;
        synchronized (e) {
            z = f40815c;
        }
        return z;
    }

    public static boolean d() {
        boolean z;
        synchronized (e) {
            z = d;
        }
        return z;
    }
}
