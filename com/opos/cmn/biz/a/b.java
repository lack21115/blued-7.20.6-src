package com.opos.cmn.biz.a;

import android.content.Context;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/a/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile String f10915a = "";

    public static String a(Context context) {
        String str;
        if (!a(f10915a)) {
            if (context != null) {
                f10915a = f.a(context);
            }
            if (!a(f10915a)) {
                f10915a = com.opos.cmn.an.b.c.d();
                com.opos.cmn.an.f.a.b("BrandTool", "get brand by os:" + f10915a);
                if (!a(f10915a)) {
                    f10915a = a.f10914c;
                    str = "set default brand";
                }
            }
            return f10915a;
        }
        str = "get Brand result= " + f10915a;
        com.opos.cmn.an.f.a.b("BrandTool", str);
        return f10915a;
    }

    public static void a(Context context, String str) {
        synchronized (b.class) {
            try {
                if (com.opos.cmn.an.c.a.a(str)) {
                    com.opos.cmn.an.f.a.b("BrandTool", "init, set Brand = null");
                } else {
                    try {
                        String upperCase = str.toUpperCase();
                        if (a(upperCase) && !upperCase.contentEquals(f10915a)) {
                            f10915a = upperCase;
                            if (context != null) {
                                final Context applicationContext = context.getApplicationContext();
                                new Thread(new Runnable() { // from class: com.opos.cmn.biz.a.b.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        f.a(Context.this, b.f10915a);
                                    }
                                }).start();
                            }
                        }
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.b("BrandTool", "setBrand", e);
                    }
                    com.opos.cmn.an.f.a.b("BrandTool", "init, set Brand = " + str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x002d, code lost:
        if (com.opos.cmn.biz.a.a.b.equalsIgnoreCase(r3) == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.lang.String r3) {
        /*
            r0 = 1
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r5 = r0
            r0 = r3
            boolean r0 = com.opos.cmn.an.c.a.a(r0)
            if (r0 != 0) goto L30
            r0 = r5
            r4 = r0
            java.lang.String r0 = com.opos.cmn.biz.a.a.f10914c
            r1 = r3
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 != 0) goto L35
            r0 = r5
            r4 = r0
            java.lang.String r0 = com.opos.cmn.biz.a.a.f10913a
            r1 = r3
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 != 0) goto L35
            r0 = r5
            r4 = r0
            java.lang.String r0 = com.opos.cmn.biz.a.a.b
            r1 = r3
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 != 0) goto L35
        L30:
            r0 = 0
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r4 = r0
        L35:
            r0 = r4
            boolean r0 = r0.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.biz.a.b.a(java.lang.String):boolean");
    }
}
