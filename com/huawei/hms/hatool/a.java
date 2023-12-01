package com.huawei.hms.hatool;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/a.class */
public abstract class a {
    public static String a(String str, String str2) {
        j c2 = c(str, str2);
        return c2 != null ? c2.a() : "";
    }

    public static boolean b(String str, String str2) {
        j c2 = c(str, str2);
        return c2 != null && c2.e();
    }

    public static j c(String str, String str2) {
        k a2;
        m a3 = i.c().a(str);
        if (a3 == null || (a2 = a3.a(str2)) == null) {
            return null;
        }
        return a2.j();
    }

    public static String d(String str, String str2) {
        j c2 = c(str, str2);
        return c2 != null ? c2.b() : "";
    }

    public static boolean e(String str, String str2) {
        j c2 = c(str, str2);
        return c2 != null && c2.f();
    }

    public static boolean f(String str, String str2) {
        k a2;
        m a3 = i.c().a(str);
        if (a3 == null || (a2 = a3.a(str2)) == null) {
            return false;
        }
        return a2.c();
    }

    public static String g(String str, String str2) {
        j c2 = c(str, str2);
        return c2 != null ? c2.d() : "";
    }

    public static boolean h(String str, String str2) {
        j c2 = c(str, str2);
        return c2 != null && c2.g();
    }

    public static boolean i(String str, String str2) {
        k a2;
        m a3 = i.c().a(str);
        if (a3 == null || (a2 = a3.a(str2)) == null) {
            return false;
        }
        return a2.e();
    }

    public static String j(String str, String str2) {
        j c2 = c(str, str2);
        return c2 != null ? c2.c() : "";
    }

    public static boolean k(String str, String str2) {
        j c2 = c(str, str2);
        return c2 != null && c2.h();
    }
}
