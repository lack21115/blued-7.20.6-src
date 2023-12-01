package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dt.class */
public class dt {
    private static final byte[] B = new byte[0];
    private static final String Code = "DeviceManager";
    private static final String I = "02";
    private static final String V = "ro.build.2b2c.partner.ext_channel";
    private static volatile ee Z;

    public static boolean B(Context context) {
        return V(context) || Code();
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean C(android.content.Context r3) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.dt.C(android.content.Context):boolean");
    }

    public static ee Code(Context context) {
        if (Z == null) {
            synchronized (B) {
                if (Z == null) {
                    Z = I(context) ? eb.V(context) : Z(context) ? dz.V(context) : Code() ? dy.V(context) : ed.V(context);
                }
            }
        }
        return Z;
    }

    private static boolean Code() {
        String Code2 = com.huawei.openalliance.ad.utils.ay.Code("ro.build.2b2c.partner.ext_channel");
        return !TextUtils.isEmpty(Code2) && Code2.startsWith("02");
    }

    public static boolean I(Context context) {
        com.huawei.openalliance.ad.utils.am Code2 = com.huawei.openalliance.ad.utils.am.Code(context);
        String L = Code2.L();
        boolean z = true;
        if (TextUtils.isEmpty(L)) {
            if (!V(context) || Z(context)) {
                z = false;
            }
            Code2.Z(z);
            return z;
        }
        return TextUtils.equals(String.valueOf(true), L);
    }

    public static boolean V(Context context) {
        return C(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
        if (com.hihonor.android.os.Build.VERSION.MAGIC_SDK_INT >= 33) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean Z(android.content.Context r3) {
        /*
            r0 = r3
            com.huawei.openalliance.ad.utils.am r0 = com.huawei.openalliance.ad.utils.am.Code(r0)
            r3 = r0
            r0 = r3
            java.lang.String r0 = r0.a()
            r7 = r0
            r0 = r7
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r6 = r0
            r0 = 1
            r5 = r0
            r0 = r6
            if (r0 != 0) goto L21
            r0 = 1
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r1 = r7
            boolean r0 = android.text.TextUtils.equals(r0, r1)
            return r0
        L21:
            r0 = 0
            r6 = r0
            java.lang.String r0 = android.os.Build.MANUFACTURER     // Catch: java.lang.Throwable -> L48
            java.lang.String r1 = "HONOR"
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch: java.lang.Throwable -> L48
            if (r0 == 0) goto L43
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L48
            r1 = 31
            if (r0 < r1) goto L43
            int r0 = com.hihonor.android.os.Build.VERSION.MAGIC_SDK_INT     // Catch: java.lang.Throwable -> L48
            r4 = r0
            r0 = r4
            r1 = 33
            if (r0 < r1) goto L43
            goto L45
        L43:
            r0 = 0
            r5 = r0
        L45:
            goto L75
        L48:
            r7 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r8 = r0
            r0 = r8
            java.lang.String r1 = "isHonor6UpPhone Error:"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r8
            r1 = r7
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getSimpleName()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "DeviceManager"
            r1 = r8
            java.lang.String r1 = r1.toString()
            com.huawei.hms.ads.ge.Z(r0, r1)
            r0 = r6
            r5 = r0
        L75:
            r0 = r3
            r1 = r5
            r0.B(r1)
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.dt.Z(android.content.Context):boolean");
    }
}
