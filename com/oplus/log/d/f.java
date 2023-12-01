package com.oplus.log.d;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Method;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/log/d/f.class */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static String f10671a = "";
    private static String b;

    /* renamed from: c  reason: collision with root package name */
    private static int f10672c = -1;

    public static String a() {
        return (d() || f()) ? g() : e() ? d.b() : GrsBaseInfo.CountryCodeSource.UNKNOWN;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0028, code lost:
        if (com.oplus.log.d.g.d.equalsIgnoreCase(r4) != false) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b() {
        /*
            java.lang.String r0 = com.oplus.log.d.f.b
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto Ld
            java.lang.String r0 = com.oplus.log.d.f.b
            return r0
        Ld:
            r0 = 0
            r6 = r0
            java.lang.String r0 = android.os.Build.BRAND
            r5 = r0
            java.lang.String r0 = com.oplus.log.d.g.f10673a
            r1 = r5
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L2e
            java.lang.String r0 = h()
            r4 = r0
            java.lang.String r0 = com.oplus.log.d.g.d
            r1 = r4
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L99
            goto L9b
        L2e:
            java.lang.String r0 = com.oplus.log.d.g.d
            r1 = r5
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 != 0) goto L99
            java.lang.String r0 = com.oplus.log.d.g.f
            r1 = r5
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L45
            goto L99
        L45:
            r0 = r6
            r4 = r0
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L87
            r1 = 24
            if (r0 < r1) goto L9b
            android.content.Context r0 = com.oplus.log.d.b.a()     // Catch: java.lang.Throwable -> L87
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: java.lang.Throwable -> L87
            r7 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L87
            r1 = r0
            java.lang.String r2 = "com."
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L87
            r8 = r0
            r0 = r8
            java.lang.String r1 = com.oplus.log.d.g.g     // Catch: java.lang.Throwable -> L87
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L87
            r0 = r8
            java.lang.String r1 = ".mobilephone"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L87
            r0 = r6
            r4 = r0
            r0 = r7
            r1 = r8
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L87
            boolean r0 = r0.hasSystemFeature(r1)     // Catch: java.lang.Throwable -> L87
            if (r0 == 0) goto L9b
            java.lang.String r0 = com.oplus.log.d.g.f     // Catch: java.lang.Throwable -> L87
            r4 = r0
            goto L9b
        L87:
            r7 = move-exception
            r0 = r6
            r4 = r0
            boolean r0 = com.oplus.log.b.a()
            if (r0 == 0) goto L9b
            r0 = r7
            r0.printStackTrace()
            r0 = r6
            r4 = r0
            goto L9b
        L99:
            r0 = r5
            r4 = r0
        L9b:
            r0 = r4
            r6 = r0
            r0 = r4
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto La6
            r0 = r5
            r6 = r0
        La6:
            r0 = r6
            com.oplus.log.d.f.b = r0
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.log.d.f.b():java.lang.String");
    }

    public static String c() {
        return String.valueOf((d() || f()) ? i() : e() ? d.a() : -1);
    }

    private static boolean d() {
        return g.f10673a.equalsIgnoreCase(TextUtils.isEmpty(b) ? b() : b);
    }

    private static boolean e() {
        return g.f.equalsIgnoreCase(TextUtils.isEmpty(b) ? b() : b);
    }

    private static boolean f() {
        return g.d.equalsIgnoreCase(TextUtils.isEmpty(b) ? b() : b);
    }

    private static String g() {
        if (TextUtils.isEmpty(f10671a)) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                Method method = cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class);
                f10671a = (String) method.invoke(cls, "ro.build.version." + g.b + "rom", "0");
            } catch (Exception e) {
                if (com.oplus.log.b.a()) {
                    e.printStackTrace();
                }
            }
        }
        return f10671a;
    }

    private static String h() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, "ro.product.brand.sub", "");
        } catch (Exception e) {
            if (com.oplus.log.b.a()) {
                e.printStackTrace();
                return "";
            }
            return "";
        }
    }

    private static int i() {
        int i;
        String str;
        String str2;
        int i2 = f10672c;
        if (i2 >= 0) {
            return i2;
        }
        try {
            if (Build.VERSION.SDK_INT > 29) {
                str2 = MonitorConstants.CONNECT_TYPE_GET + g.n + "VERSION";
                str = "com.oplus.os.OplusBuild";
            } else {
                str = "com." + g.l + ".os." + g.m;
                str2 = MonitorConstants.CONNECT_TYPE_GET + g.h + "VERSION";
            }
            i = ((Integer) j.a(j.a(str), str2, null, null)).intValue();
        } catch (Exception e) {
            if (com.oplus.log.b.a()) {
                e.printStackTrace();
            }
            i = 0;
        }
        if (i == 0) {
            try {
                String a2 = a();
                if (a2.startsWith("V1.4")) {
                    return 3;
                }
                if (a2.startsWith("V2.0")) {
                    return 4;
                }
                if (a2.startsWith("V2.1")) {
                    return 5;
                }
            } catch (Exception e2) {
                if (com.oplus.log.b.a()) {
                    e2.printStackTrace();
                }
            }
        }
        f10672c = i;
        return i;
    }
}
