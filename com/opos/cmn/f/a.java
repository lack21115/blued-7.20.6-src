package com.opos.cmn.f;

import android.content.Context;
import com.opos.acs.st.STManager;
import com.opos.cmn.an.a.b;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/f/a.class */
public final class a {
    private static volatile STManager b;

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f11106a = new byte[0];

    /* renamed from: c  reason: collision with root package name */
    private static final String f11107c = b.a("Y29tLm9wcG8udW5pb24=");

    public static int a() {
        return c().getSdkVerCode();
    }

    public static String a(Context context) {
        return "";
    }

    public static String a(Context context, String str, Map<String, String> map) {
        if (context == null || map == null || map.size() <= 0) {
            return "";
        }
        try {
            return c().onEvent(context, str, map);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.a("STool", "", th);
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
        if (com.opos.acs.st.STManager.BRAND_OF_R.equalsIgnoreCase(r7) == false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r6, java.lang.String r7, java.lang.String r8) {
        /*
            r0 = r6
            if (r0 == 0) goto L7a
            r0 = r7
            boolean r0 = com.opos.cmn.an.c.a.a(r0)     // Catch: java.lang.Throwable -> L71
            if (r0 != 0) goto L2f
            r0 = r7
            r9 = r0
            java.lang.String r0 = com.opos.acs.st.STManager.BRAND_OF_O     // Catch: java.lang.Throwable -> L71
            r1 = r7
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch: java.lang.Throwable -> L71
            if (r0 != 0) goto L33
            r0 = r7
            r9 = r0
            java.lang.String r0 = com.opos.acs.st.STManager.BRAND_OF_P     // Catch: java.lang.Throwable -> L71
            r1 = r7
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch: java.lang.Throwable -> L71
            if (r0 != 0) goto L33
            r0 = r7
            r9 = r0
            java.lang.String r0 = com.opos.acs.st.STManager.BRAND_OF_R     // Catch: java.lang.Throwable -> L71
            r1 = r7
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch: java.lang.Throwable -> L71
            if (r0 != 0) goto L33
        L2f:
            java.lang.String r0 = com.opos.acs.st.STManager.BRAND_OF_O     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L71
            r9 = r0
        L33:
            com.opos.acs.st.InitParams$Builder r0 = new com.opos.acs.st.InitParams$Builder     // Catch: java.lang.Throwable -> L71 java.lang.Throwable -> L71
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = com.opos.cmn.f.a.f11107c     // Catch: java.lang.Throwable -> L71
            com.opos.acs.st.InitParams$Builder r0 = r0.setPkgName(r1)     // Catch: java.lang.Throwable -> L71
            r1 = 0
            com.opos.acs.st.InitParams$Builder r0 = r0.setIsLoganInit(r1)     // Catch: java.lang.Throwable -> L71
            com.opos.acs.st.InitParams r0 = r0.build()     // Catch: java.lang.Throwable -> L71
            r7 = r0
            com.opos.acs.st.STManager r0 = c()     // Catch: java.lang.Throwable -> L71
            r1 = r6
            r2 = r9
            r3 = r8
            r4 = r7
            r0.init(r1, r2, r3, r4)     // Catch: java.lang.Throwable -> L71
            com.opos.acs.st.InitParams$Builder r0 = new com.opos.acs.st.InitParams$Builder     // Catch: java.lang.Throwable -> L71
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = "com.opos.dy.mat"
            com.opos.acs.st.InitParams$Builder r0 = r0.setPkgName(r1)     // Catch: java.lang.Throwable -> L71
            r1 = 0
            com.opos.acs.st.InitParams$Builder r0 = r0.setIsLoganInit(r1)     // Catch: java.lang.Throwable -> L71
            com.opos.acs.st.InitParams r0 = r0.build()     // Catch: java.lang.Throwable -> L71
            r7 = r0
            com.opos.acs.st.STManager r0 = c()     // Catch: java.lang.Throwable -> L71
            r1 = r6
            r2 = r9
            r3 = r8
            r4 = r7
            r0.init(r1, r2, r3, r4)     // Catch: java.lang.Throwable -> L71
            return
        L71:
            r6 = move-exception
            java.lang.String r0 = "STool"
            java.lang.String r1 = ""
            r2 = r6
            com.opos.cmn.an.f.a.a(r0, r1, r2)
        L7a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.f.a.a(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public static void b() {
        try {
            c().enableDebugLog();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("STool", "", (Throwable) e);
        }
    }

    private static STManager c() {
        STManager sTManager;
        STManager sTManager2 = b;
        if (sTManager2 == null) {
            synchronized (f11106a) {
                STManager sTManager3 = b;
                sTManager = sTManager3;
                if (sTManager3 == null) {
                    sTManager = STManager.getInstance();
                    b = sTManager;
                }
            }
            return sTManager;
        }
        return sTManager2;
    }
}
