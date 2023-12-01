package com.opos.cmn.a;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static AtomicBoolean f10794a = new AtomicBoolean(false);
    private static volatile boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private static AtomicReference<String> f10795c = new AtomicReference<>(null);
    private static AtomicBoolean d = new AtomicBoolean(false);

    public static void a(boolean z, String str) {
        if (f10794a.compareAndSet(false, true)) {
            b = z;
        }
        f10795c.compareAndSet(null, str);
    }

    public static boolean a() {
        a(false, "CN");
        return b;
    }

    public static String b() {
        String str = f10795c.get();
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = "CN";
        }
        return str2;
    }

    public static boolean c() {
        return d.get();
    }
}
