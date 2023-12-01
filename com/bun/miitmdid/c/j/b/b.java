package com.bun.miitmdid.c.j.b;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* loaded from: source-7206380-dex2jar.jar:com/bun/miitmdid/c/j/b/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static Context f21153a;
    private static boolean b;

    /* renamed from: c  reason: collision with root package name */
    private static b f21154c;
    private static com.bun.miitmdid.c.j.b.a d;
    private static c e;
    private static c f;
    private static c g;
    private static Object h = new Object();
    private static HandlerThread i;
    private static Handler j;
    private static String k;
    private static String l;
    private static String m;
    private static String n;

    /* loaded from: source-7206380-dex2jar.jar:com/bun/miitmdid/c/j/b/b$a.class */
    static final class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public native void handleMessage(Message message);
    }

    private b() {
    }

    public static native b a(Context context);

    public static native String a(String str, String str2);

    private static native void a(Context context, int i2, String str);

    private native void b(int i2, String str);

    static native /* synthetic */ com.bun.miitmdid.c.j.b.a c();

    static native /* synthetic */ String c(String str);

    static native /* synthetic */ Object d();

    public static native void e();

    private static native void f();

    public native String a();

    public native String a(String str);

    public native void a(int i2, String str);

    public native String b(String str);

    public native boolean b();
}
