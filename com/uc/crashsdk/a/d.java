package com.uc.crashsdk.a;

import com.huawei.openalliance.ad.constant.ao;
import com.umeng.analytics.pro.bh;
import com.umeng.commonsdk.framework.UMModuleRegister;
import com.umeng.umcrash.UMCrashContent;

/* loaded from: source-8829756-dex2jar.jar:com/uc/crashsdk/a/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f40562a = !d.class.desiredAssertionStatus();
    private static boolean b = true;

    /* renamed from: c  reason: collision with root package name */
    private static final Object f40563c = new Object();
    private static boolean d = false;
    private static String e = "hsdk";
    private static String f = "alid ";
    private static String g = null;
    private static final Object h = new Object();
    private static String i = null;

    private static StringBuilder a(StringBuilder sb, String str, String str2) {
        if (sb.length() > 0) {
            sb.append("`");
        }
        sb.append(str);
        sb.append("=");
        sb.append(str2);
        return sb;
    }

    public static void a() {
        f.a(0, new e(500), com.uc.crashsdk.b.H() ? 900000L : 90000L);
    }

    public static void a(int i2) {
        if (i2 != 500) {
            if (!f40562a) {
                throw new AssertionError();
            }
            return;
        }
        synchronized (f40563c) {
            g = null;
            a(!com.uc.crashsdk.b.F());
            if (g.b(g)) {
                h.a(g);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x024b A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(boolean r9) {
        /*
            Method dump skipped, instructions count: 589
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.d.a(boolean):boolean");
    }

    public static String b() {
        try {
            return "inv" + f + "cras" + e;
        } catch (Throwable th) {
            g.b(th);
            return "";
        }
    }

    public static void c() {
        synchronized (h) {
            i = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] d() {
        return new byte[]{6, 0, 23, 8};
    }

    public static boolean e() {
        if (com.uc.crashsdk.e.F() || com.uc.crashsdk.b.L()) {
            return true;
        }
        a(true);
        return b;
    }

    private static String f() {
        String a2;
        String str = i;
        if (g.a(str)) {
            synchronized (h) {
                String str2 = UMCrashContent.UM_DOMAIN_APM_URL;
                if (com.uc.crashsdk.g.R()) {
                    str2 = "https://errlogos.umeng.com";
                }
                a2 = g.a(com.uc.crashsdk.b.j(), str2 + "/api/crashsdk/validate", true);
                i = a2;
            }
            return a2;
        }
        return str;
    }

    private static String g() {
        byte[] bArr;
        String f2;
        byte[] a2;
        byte[] bArr2;
        StringBuilder sb = new StringBuilder();
        a(sb, "platform", com.uc.crashsdk.g.e());
        a(sb, ao.y, com.uc.crashsdk.a.f40557a);
        a(sb, UMModuleRegister.PROCESS, com.uc.crashsdk.e.h());
        a(sb, "version", com.uc.crashsdk.a.a());
        a(sb, "cver", "3.3.2.2");
        a(sb, "ctag", "release");
        a(sb, "inter", com.uc.crashsdk.g.R() ? "true" : "false");
        a(sb, bh.x, "android");
        String sb2 = sb.toString();
        byte[] bArr3 = new byte[16];
        c.a(bArr3, 0, h.j());
        c.a(bArr3, 4, c.a());
        c.a(bArr3, 8, d());
        c.a(bArr3, 12, com.uc.crashsdk.a.f());
        try {
            bArr = c.a(sb2.getBytes(), bArr3, true);
        } catch (Throwable th) {
            g.a(th);
            bArr = null;
        }
        if (bArr == null || (f2 = f()) == null || (a2 = c.a(f2, bArr)) == null) {
            return null;
        }
        try {
            bArr2 = c.a(a2, bArr3, false);
        } catch (Throwable th2) {
            g.a(th2);
            bArr2 = null;
        }
        if (bArr2 != null) {
            return new String(bArr2);
        }
        return null;
    }
}
