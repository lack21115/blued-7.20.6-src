package com.opos.mobad.activity.webview.a.a;

import android.content.Context;
import java.util.concurrent.ExecutorService;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/activity/webview/a/a/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f11949a = new byte[0];
    private static volatile ExecutorService b;

    public static int a() {
        return 107;
    }

    public static boolean a(Context context, String str) {
        if (context != null) {
            try {
                if (com.opos.cmn.an.c.a.a(str)) {
                    return false;
                }
                return com.opos.cmn.biz.b.a.a(context, str);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("JSUtils", "", (Throwable) e);
                return false;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(android.content.Context r5, java.lang.String r6) {
        /*
            r0 = r5
            if (r0 == 0) goto L48
            r0 = r6
            boolean r0 = com.opos.cmn.an.c.a.a(r0)
            if (r0 != 0) goto L48
            android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Exception -> L3f
            r1 = r0
            java.lang.String r2 = "android.intent.action.VIEW"
            r3 = r6
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch: java.lang.Exception -> L3f
            r1.<init>(r2, r3)     // Catch: java.lang.Exception -> L3f
            r8 = r0
            r0 = r8
            java.lang.String r1 = "android.intent.category.BROWSABLE"
            android.content.Intent r0 = r0.addCategory(r1)     // Catch: java.lang.Exception -> L3f
            r0 = r8
            r1 = 0
            android.content.Intent r0 = r0.setComponent(r1)     // Catch: java.lang.Exception -> L3f
            r0 = r8
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            android.content.Intent r0 = r0.addFlags(r1)     // Catch: java.lang.Exception -> L3f
            r0 = r5
            r1 = r8
            boolean r0 = com.opos.cmn.an.h.d.a.a(r0, r1)     // Catch: java.lang.Exception -> L3f
            if (r0 == 0) goto L48
            r0 = r5
            r1 = r8
            r0.startActivity(r1)     // Catch: java.lang.Exception -> L3f
            r0 = 1
            r7 = r0
            goto L4a
        L3f:
            r5 = move-exception
            java.lang.String r0 = "JSUtils"
            java.lang.String r1 = ""
            r2 = r5
            com.opos.cmn.an.f.a.a(r0, r1, r2)
        L48:
            r0 = 0
            r7 = r0
        L4a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r5 = r0
            r0 = r5
            java.lang.String r1 = "launchAppPage url="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            if (r0 == 0) goto L60
            goto L63
        L60:
            java.lang.String r0 = "null"
            r6 = r0
        L63:
            r0 = r5
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            java.lang.String r1 = "result="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            r1 = r7
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "JSUtils"
            r1 = r5
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.activity.webview.a.a.a.b(android.content.Context, java.lang.String):boolean");
    }
}
