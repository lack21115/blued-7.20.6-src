package com.bytedance.pangle.util;

import android.os.Build;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/util/i.class */
public final class i {
    public static boolean a() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT < 21;
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT <= 23;
    }

    public static boolean d() {
        return Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT <= 25;
    }

    public static boolean e() {
        return Build.VERSION.SDK_INT >= 26 && Build.VERSION.SDK_INT <= 28;
    }

    public static boolean f() {
        return Build.VERSION.SDK_INT >= 29 && Build.VERSION.SDK_INT <= 30;
    }

    public static boolean g() {
        return Build.VERSION.SDK_INT > 23;
    }

    public static boolean h() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean i() {
        if (Build.VERSION.SDK_INT < 28) {
            return Build.VERSION.SDK_INT == 27 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String i1672829046107dc(java.lang.String r5) {
        /*
        L0:
            r0 = 74
            r6 = r0
            r0 = 55
            r7 = r0
        L6:
            r0 = r6
            switch(r0) {
                case 72: goto L0;
                case 73: goto L23;
                case 74: goto L40;
                default: goto L20;
            }
        L20:
            goto L8e
        L23:
            r0 = r7
            switch(r0) {
                case 94: goto L85;
                case 95: goto L5f;
                case 96: goto L5f;
                default: goto L40;
            }
        L40:
            r0 = r7
            switch(r0) {
                case 55: goto L85;
                case 56: goto L85;
                case 57: goto L5f;
                default: goto L5c;
            }
        L5c:
            goto L85
        L5f:
            r0 = r5
            char[] r0 = r0.toCharArray()
            r5 = r0
            r0 = 0
            r6 = r0
        L66:
            r0 = r6
            r1 = r5
            int r1 = r1.length
            if (r0 >= r1) goto L7c
            r0 = r5
            r1 = r6
            r2 = r5
            r3 = r6
            char r2 = r2[r3]
            r3 = r6
            r2 = r2 ^ r3
            char r2 = (char) r2
            r0[r1] = r2
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L66
        L7c:
            java.lang.String r0 = new java.lang.String
            r1 = r0
            r2 = r5
            r1.<init>(r2)
            return r0
        L85:
            r0 = 73
            r6 = r0
            r0 = 96
            r7 = r0
            goto L6
        L8e:
            r0 = 72
            r6 = r0
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.util.i.i1672829046107dc(java.lang.String):java.lang.String");
    }

    public static boolean j() {
        if (Build.VERSION.SDK_INT < 31) {
            return Build.VERSION.SDK_INT == 30 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }
}
