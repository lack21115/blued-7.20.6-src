package com.tencent.tendinsv.utils;

import android.os.Build;
import android.text.TextUtils;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/utils/r.class */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public static final String f25421a = "MIUI";
    public static final String b = "EMUI";

    /* renamed from: c  reason: collision with root package name */
    public static final String f25422c = "FLYME";
    public static final String d = "OPPO";
    public static final String e = "SMARTISAN";
    public static final String f = "VIVO";
    public static final String g = "QIKU";
    private static final String h = "Rom";
    private static final String i = "ro.miui.ui.version.name";
    private static final String j = "ro.build.version.emui";
    private static final String k = "ro.build.version.opporom";
    private static final String l = "ro.smartisan.version";
    private static final String m = "ro.vivo.os.version";
    private static String n;
    private static String o;

    public static boolean a() {
        return a(b);
    }

    public static boolean a(String str) {
        String upperCase;
        String str2 = n;
        if (str2 != null) {
            return str2.equals(str);
        }
        String b2 = b("ro.miui.ui.version.name");
        o = b2;
        if (TextUtils.isEmpty(b2)) {
            String b3 = b(j);
            o = b3;
            if (TextUtils.isEmpty(b3)) {
                String b4 = b(k);
                o = b4;
                if (TextUtils.isEmpty(b4)) {
                    String b5 = b(m);
                    o = b5;
                    if (TextUtils.isEmpty(b5)) {
                        String b6 = b(l);
                        o = b6;
                        if (TextUtils.isEmpty(b6)) {
                            String str3 = Build.DISPLAY;
                            o = str3;
                            if (str3.toUpperCase().contains(f25422c)) {
                                n = f25422c;
                                return n.equals(str);
                            }
                            o = "unknown";
                            upperCase = Build.MANUFACTURER.toUpperCase();
                        } else {
                            upperCase = e;
                        }
                    } else {
                        upperCase = f;
                    }
                } else {
                    upperCase = d;
                }
            } else {
                upperCase = b;
            }
        } else {
            upperCase = f25421a;
        }
        n = upperCase;
        return n.equals(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 189
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tendinsv.utils.r.b(java.lang.String):java.lang.String");
    }

    public static boolean b() {
        return a(f25421a);
    }

    public static boolean c() {
        return a(f);
    }

    public static boolean d() {
        return a(d);
    }

    public static boolean e() {
        return a(f25422c);
    }

    public static boolean f() {
        return a(g) || a("360");
    }

    public static boolean g() {
        return a(e);
    }

    public static String h() {
        if (n == null) {
            a("");
        }
        return n;
    }

    public static String i() {
        if (o == null) {
            a("");
        }
        return o;
    }
}
