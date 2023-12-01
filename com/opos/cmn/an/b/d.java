package com.opos.cmn.an.b;

import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/b/d.class */
public final class d {
    private static String e;
    private static String f;
    private static final String g = "ro.build.version." + com.opos.cmn.an.a.a.f10797c + "rom";
    private static final String h = "persist.sys." + com.opos.cmn.an.a.a.f10797c + ".region";

    /* renamed from: a  reason: collision with root package name */
    public static final String f10801a = com.opos.cmn.an.a.b.a("Z2V0Q29sb3JPU1ZFUlNJT04=");
    public static final String b = com.opos.cmn.an.a.b.a("Y29tLmNvbG9yLm9zLkNvbG9yQnVpbGQ=");

    /* renamed from: c  reason: collision with root package name */
    public static final String f10802c = com.opos.cmn.an.a.b.a("Z2V0Q29sb3JPU1Zlck5hbWU=");
    public static final String d = com.opos.cmn.an.a.b.a("Z2V0Q29sb3JPU1ZlckNvZGU=");

    public static String a() {
        if (e == null) {
            try {
                e = SystemProperties.get("ro.build.display.id");
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("OSPropertyTool", "getOSVerName", e2);
            }
        }
        String str = e;
        return str != null ? str : "";
    }

    public static String b() {
        if (f == null) {
            if (Build.VERSION.SDK_INT > 29) {
                try {
                    f = SystemProperties.get("ro.build.version.oplusrom");
                } catch (Exception e2) {
                }
            }
            if (TextUtils.isEmpty(f)) {
                try {
                    f = SystemProperties.get(g);
                } catch (Exception e3) {
                    com.opos.cmn.an.f.a.c("OSPropertyTool", f10802c, e3);
                }
            }
        }
        String str = f;
        return str != null ? str : "";
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0024 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c() {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = r0
            java.lang.String r0 = ""
            r7 = r0
            r0 = r4
            r1 = 29
            if (r0 <= r1) goto L18
            java.lang.String r0 = "persist.sys.oplus.region"
            java.lang.String r1 = "cn"
            java.lang.String r0 = android.os.SystemProperties.get(r0, r1)     // Catch: java.lang.Exception -> L65
            r5 = r0
            goto L1b
        L18:
            java.lang.String r0 = ""
            r5 = r0
        L1b:
            r0 = r5
            r6 = r0
            r0 = r5
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L5b
            java.lang.String r0 = com.opos.cmn.an.b.c.d()     // Catch: java.lang.Exception -> L50
            r6 = r0
            r0 = r6
            boolean r0 = com.opos.cmn.an.c.a.a(r0)     // Catch: java.lang.Exception -> L50
            if (r0 != 0) goto L49
            r0 = r6
            java.lang.String r0 = r0.trim()     // Catch: java.lang.Exception -> L50
            java.lang.String r1 = com.opos.cmn.an.a.a.f10796a     // Catch: java.lang.Exception -> L50
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch: java.lang.Exception -> L50
            if (r0 == 0) goto L49
            java.lang.String r0 = "persist.sys.oem.region"
            r6 = r0
        L3f:
            r0 = r6
            java.lang.String r1 = "cn"
            java.lang.String r0 = android.os.SystemProperties.get(r0, r1)     // Catch: java.lang.Exception -> L50
            r6 = r0
            goto L5b
        L49:
            java.lang.String r0 = com.opos.cmn.an.b.d.h     // Catch: java.lang.Exception -> L50
            r6 = r0
            goto L3f
        L50:
            r6 = move-exception
            java.lang.String r0 = "OSPropertyTool"
            java.lang.String r1 = "getRegion"
            r2 = r6
            com.opos.cmn.an.f.a.c(r0, r1, r2)
            r0 = r5
            r6 = r0
        L5b:
            r0 = r7
            r5 = r0
            r0 = r6
            if (r0 == 0) goto L63
            r0 = r6
            r5 = r0
        L63:
            r0 = r5
            return r0
        L65:
            r5 = move-exception
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.b.d.c():java.lang.String");
    }
}
