package com.opos.cmn.an.f;

import android.content.Context;
import com.opos.cmn.an.f.a.b;
import com.opos.cmn.an.f.a.c;
import com.opos.cmn.an.f.a.e;
import com.opos.cmn.an.f.a.f;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/f/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f24505a;
    private static final byte[] b = new byte[0];

    public static void a() {
        c.a();
    }

    public static void a(Context context, boolean z) {
        f.a(context, z);
    }

    public static void a(com.opos.cmn.an.f.b.b bVar) {
        if (bVar == null) {
            throw new NullPointerException("initParams is null.");
        }
        if (f24505a == null) {
            synchronized (b) {
                if (f24505a == null) {
                    f24505a = new e();
                    f24505a.a(bVar);
                }
            }
        }
    }

    public static void a(com.opos.cmn.an.f.b.c cVar, com.opos.cmn.an.f.b.a aVar) {
        if (f24505a != null) {
            f24505a.a(cVar, aVar);
        }
    }

    public static void a(String str, Object obj) {
        if (f24505a != null) {
            f24505a.a(str, obj);
        }
    }

    public static void a(String str, Object obj, Throwable th) {
        if (f24505a != null) {
            f24505a.a(str, obj, th);
        }
    }

    public static void a(String str, String str2) {
        if (f24505a != null) {
            f24505a.a(str, str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (f24505a != null) {
            f24505a.a(str, str2, th);
        }
    }

    public static void a(String str, Object... objArr) {
        if (f24505a != null) {
            f24505a.a(str, objArr);
        }
    }

    public static void a(boolean z) {
        com.opos.cmn.an.f.a.a.a(z);
    }

    public static boolean a(Context context) {
        return com.opos.cmn.an.f.a.a.a(context);
    }

    public static void b() {
        if (f24505a != null) {
            f24505a.a();
        }
    }

    public static void b(String str, String str2) {
        if (f24505a != null) {
            f24505a.b(str, str2);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (f24505a != null) {
            f24505a.b(str, str2, th);
        }
    }

    public static void b(String str, Object... objArr) {
        if (f24505a != null) {
            f24505a.b(str, objArr);
        }
    }

    public static boolean b(Context context) {
        boolean a2;
        synchronized (a.class) {
            try {
                a2 = f.a(context);
            } catch (Throwable th) {
                throw th;
            }
        }
        return a2;
    }

    public static void c(String str, String str2) {
        if (f24505a != null) {
            f24505a.c(str, str2);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        if (f24505a != null) {
            f24505a.c(str, str2, th);
        }
    }

    public static void c(String str, Object... objArr) {
        if (f24505a != null) {
            f24505a.c(str, objArr);
        }
    }

    public static void d(String str, String str2) {
        if (f24505a != null) {
            f24505a.d(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (f24505a != null) {
            f24505a.d(str, str2, th);
        }
    }
}
