package com.opos.cmn.a;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static AtomicBoolean f24481a = new AtomicBoolean(false);
    private static volatile boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private static AtomicReference<String> f24482c = new AtomicReference<>(null);
    private static AtomicBoolean d = new AtomicBoolean(false);

    public static void a(boolean z, String str) {
        if (f24481a.compareAndSet(false, true)) {
            b = z;
        }
        f24482c.compareAndSet(null, str);
    }

    public static boolean a() {
        a(false, "CN");
        return b;
    }

    public static String b() {
        String str = f24482c.get();
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
