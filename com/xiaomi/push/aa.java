package com.xiaomi.push;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/aa.class */
public class aa {

    /* renamed from: a  reason: collision with root package name */
    private static int f27551a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f122a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f123a;
    public static final boolean b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f27552c;
    public static final boolean d;
    public static boolean e;
    public static final boolean f;
    public static final boolean g;

    static {
        int i;
        String str = ae.f124a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f122a = str;
        boolean contains = str.contains("2A2FE0D7");
        f123a = contains;
        b = contains || "DEBUG".equalsIgnoreCase(f122a);
        f27552c = "LOGABLE".equalsIgnoreCase(f122a);
        d = f122a.contains("YY");
        e = f122a.equalsIgnoreCase("TEST");
        f = "BETA".equalsIgnoreCase(f122a);
        String str2 = f122a;
        boolean z = false;
        if (str2 != null) {
            z = false;
            if (str2.startsWith("RC")) {
                z = true;
            }
        }
        g = z;
        f27551a = 1;
        if (f122a.equalsIgnoreCase("SANDBOX")) {
            i = 2;
        } else if (!f122a.equalsIgnoreCase("ONEBOX")) {
            f27551a = 1;
            return;
        } else {
            i = 3;
        }
        f27551a = i;
    }

    public static int a() {
        return f27551a;
    }

    public static void a(int i) {
        f27551a = i;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m8445a() {
        return f27551a == 2;
    }

    public static boolean b() {
        return f27551a == 3;
    }
}
