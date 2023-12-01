package com.xiaomi.push;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/aa.class */
public class aa {

    /* renamed from: a  reason: collision with root package name */
    private static int f41242a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f169a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f170a;
    public static final boolean b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f41243c;
    public static final boolean d;
    public static boolean e;
    public static final boolean f;
    public static final boolean g;

    static {
        int i;
        String str = ae.f171a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f169a = str;
        boolean contains = str.contains("2A2FE0D7");
        f170a = contains;
        b = contains || "DEBUG".equalsIgnoreCase(f169a);
        f41243c = "LOGABLE".equalsIgnoreCase(f169a);
        d = f169a.contains("YY");
        e = f169a.equalsIgnoreCase("TEST");
        f = "BETA".equalsIgnoreCase(f169a);
        String str2 = f169a;
        boolean z = false;
        if (str2 != null) {
            z = false;
            if (str2.startsWith("RC")) {
                z = true;
            }
        }
        g = z;
        f41242a = 1;
        if (f169a.equalsIgnoreCase("SANDBOX")) {
            i = 2;
        } else if (!f169a.equalsIgnoreCase("ONEBOX")) {
            f41242a = 1;
            return;
        } else {
            i = 3;
        }
        f41242a = i;
    }

    public static int a() {
        return f41242a;
    }

    public static void a(int i) {
        f41242a = i;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m11495a() {
        return f41242a == 2;
    }

    public static boolean b() {
        return f41242a == 3;
    }
}
