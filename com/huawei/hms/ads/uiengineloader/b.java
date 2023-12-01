package com.huawei.hms.ads.uiengineloader;

import android.os.Build;
import android.text.TextUtils;
import com.hihonor.android.os.Build;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengineloader/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final int f8939a = 27;
    private static final String b = "DeviceUtil";

    public static String a(String str) {
        Class<?> cls;
        try {
            if (Build.VERSION.SDK_INT >= 27) {
                try {
                    cls = Class.forName(d() ? "com.hihonor.android.os.SystemPropertiesEx" : "com.huawei.android.os.SystemPropertiesEx");
                } catch (ClassNotFoundException e) {
                }
                return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, str);
            }
            cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, str);
        } catch (Throwable th) {
            aa.c(b, "getSystemProperties Exception:" + th.getClass().getSimpleName());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0042 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a() {
        /*
            r0 = 0
            r7 = r0
            r0 = 0
            r5 = r0
            java.lang.String r0 = android.os.Build.BRAND     // Catch: java.lang.Throwable -> L67
            java.lang.String r1 = "HUAWEI"
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch: java.lang.Throwable -> L67
            if (r0 != 0) goto L3a
            java.lang.String r0 = android.os.Build.MANUFACTURER     // Catch: java.lang.Throwable -> L67
            java.lang.String r1 = "HUAWEI"
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch: java.lang.Throwable -> L67
            if (r0 != 0) goto L3a
            java.lang.String r0 = android.os.Build.BRAND     // Catch: java.lang.Throwable -> L67
            java.lang.String r1 = "HONOR"
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch: java.lang.Throwable -> L67
            if (r0 != 0) goto L3a
            java.lang.String r0 = android.os.Build.MANUFACTURER     // Catch: java.lang.Throwable -> L67
            java.lang.String r1 = "HONOR"
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch: java.lang.Throwable -> L67
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L35
            goto L3a
        L35:
            r0 = 0
            r5 = r0
            goto L3c
        L3a:
            r0 = 1
            r5 = r0
        L3c:
            r0 = r5
            r6 = r0
            r0 = r5
            if (r0 != 0) goto L8e
            java.lang.String r0 = "com.huawei.android.os.BuildEx$VERSION"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Throwable -> L62
            java.lang.String r1 = "EMUI_SDK_INT"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r1)     // Catch: java.lang.Throwable -> L62
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L62
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.Throwable -> L62
            int r0 = r0.intValue()     // Catch: java.lang.Throwable -> L62
            r4 = r0
            r0 = r7
            r5 = r0
            r0 = r4
            if (r0 <= 0) goto L8c
            r0 = 1
            r5 = r0
            goto L8c
        L62:
            r8 = move-exception
            goto L69
        L67:
            r8 = move-exception
        L69:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            java.lang.String r2 = "isHuaweiPhone Error:"
            r1.<init>(r2)
            r9 = r0
            r0 = r9
            r1 = r8
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getSimpleName()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "DeviceUtil"
            r1 = r9
            java.lang.String r1 = r1.toString()
            com.huawei.hms.ads.uiengineloader.aa.d(r0, r1)
        L8c:
            r0 = r5
            r6 = r0
        L8e:
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.uiengineloader.b.a():boolean");
    }

    private static boolean b() {
        if (a()) {
            return true;
        }
        String a2 = a(com.huawei.hms.ads.dynamic.a.r);
        return !TextUtils.isEmpty(a2) && a2.startsWith(com.huawei.hms.ads.dynamic.a.s);
    }

    private static boolean c() {
        String a2 = a(com.huawei.hms.ads.dynamic.a.r);
        return !TextUtils.isEmpty(a2) && a2.startsWith(com.huawei.hms.ads.dynamic.a.s);
    }

    private static boolean d() {
        try {
            if (!Build.MANUFACTURER.equalsIgnoreCase("HONOR") || Build.VERSION.SDK_INT < 31) {
                return false;
            }
            return Build.VERSION.MAGIC_SDK_INT >= 33;
        } catch (Throwable th) {
            aa.d(b, "isHonor6UpPhone Error:" + th.getClass().getSimpleName());
            return false;
        }
    }
}
