package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/apmobilesecuritysdk/e/i.class */
public final class i {
    private static String a = "";
    private static String b = "";
    private static String c = "";
    private static String d = "";
    private static String e = "";
    private static Map<String, String> f = new HashMap();

    public static String a(String str) {
        synchronized (i.class) {
            try {
                String str2 = "apdidTokenCache" + str;
                if (f.containsKey(str2)) {
                    String str3 = f.get(str2);
                    if (com.alipay.security.mobile.module.a.a.b(str3)) {
                        return str3;
                    }
                }
                return "";
            } finally {
            }
        }
    }

    public static void a() {
        synchronized (i.class) {
        }
    }

    public static void a(b bVar) {
        synchronized (i.class) {
            if (bVar != null) {
                try {
                    a = bVar.a;
                    b = bVar.b;
                    c = bVar.c;
                } finally {
                }
            }
        }
    }

    public static void a(c cVar) {
        synchronized (i.class) {
            if (cVar != null) {
                try {
                    a = cVar.a;
                    b = cVar.b;
                    d = cVar.d;
                    e = cVar.e;
                    c = cVar.c;
                } finally {
                }
            }
        }
    }

    public static void a(String str, String str2) {
        synchronized (i.class) {
            try {
                String str3 = "apdidTokenCache" + str;
                if (f.containsKey(str3)) {
                    f.remove(str3);
                }
                f.put(str3, str2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean a(Context context, String str) {
        synchronized (i.class) {
            long j = 86400000;
            try {
                long a2 = h.a(context);
                if (a2 >= 0) {
                    j = a2;
                }
            } catch (Throwable th) {
            }
            try {
                if (Math.abs(System.currentTimeMillis() - h.h(context, str)) < j) {
                    return true;
                }
            } catch (Throwable th2) {
                try {
                    com.alipay.apmobilesecuritysdk.c.a.a(th2);
                } catch (Throwable th3) {
                    throw th3;
                }
            }
            return false;
        }
    }

    public static String b() {
        String str;
        synchronized (i.class) {
            try {
                str = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public static void b(String str) {
        a = str;
    }

    public static String c() {
        String str;
        synchronized (i.class) {
            try {
                str = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public static void c(String str) {
        b = str;
    }

    public static String d() {
        String str;
        synchronized (i.class) {
            try {
                str = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public static void d(String str) {
        c = str;
    }

    public static String e() {
        String str;
        synchronized (i.class) {
            try {
                str = e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public static void e(String str) {
        d = str;
    }

    public static String f() {
        String str;
        synchronized (i.class) {
            try {
                str = c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public static void f(String str) {
        e = str;
    }

    public static c g() {
        c cVar;
        synchronized (i.class) {
            try {
                cVar = new c(a, b, c, d, e);
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    public static void h() {
        f.clear();
        a = "";
        b = "";
        d = "";
        e = "";
        c = "";
    }
}
