package com.bun.miitmdid.c.k;

import android.content.Context;
import java.lang.reflect.Method;

/* loaded from: source-7206380-dex2jar.jar:com/bun/miitmdid/c/k/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Object f7551a;
    private static Class<?> b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f7552c;
    private static Method d;
    private static Method e;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            b = cls;
            f7551a = cls.newInstance();
        } catch (Exception e2) {
            com.bun.lib.a.a("IdentifierManager", "reflect exception!", e2);
        }
        try {
            if (b != null) {
                f7552c = b.getMethod("getOAID", Context.class);
            }
        } catch (Exception e3) {
            com.bun.lib.a.a("IdentifierManager", "reflect exception!", e3);
        }
        try {
            if (b != null) {
                d = b.getMethod("getVAID", Context.class);
            }
        } catch (Exception e4) {
            com.bun.lib.a.a("IdentifierManager", "reflect exception!", e4);
        }
        try {
            if (b != null) {
                e = b.getMethod("getAAID", Context.class);
            }
        } catch (Exception e5) {
            com.bun.lib.a.a("IdentifierManager", "reflect exception!", e5);
        }
    }

    public static native String a(Context context);

    private static native String a(Context context, Method method);

    public static native boolean a();

    public static native String b(Context context);

    public static native String c(Context context);
}
