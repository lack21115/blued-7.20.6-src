package com.opos.cmn.func.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/a/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static d f11123a;
    private static final byte[] b = new byte[0];

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.opos.cmn.func.a.b a(android.content.Context r4, com.opos.cmn.func.a.a r5) {
        /*
            r0 = r4
            if (r0 == 0) goto L25
            r0 = r5
            if (r0 == 0) goto L25
            a()
            com.opos.cmn.func.a.d r0 = com.opos.cmn.func.a.c.f11123a     // Catch: java.lang.Exception -> L1c
            r1 = r4
            android.content.Context r1 = r1.getApplicationContext()     // Catch: java.lang.Exception -> L1c
            r2 = r5
            com.opos.cmn.func.a.b r0 = r0.a(r1, r2)     // Catch: java.lang.Exception -> L1c
            r4 = r0
            goto L27
        L1c:
            r4 = move-exception
            java.lang.String r0 = "DownloadTool"
            java.lang.String r1 = "download"
            r2 = r4
            com.opos.cmn.an.f.a.c(r0, r1, r2)
        L25:
            r0 = 0
            r4 = r0
        L27:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r7 = r0
            r0 = r7
            java.lang.String r1 = "download request="
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "null"
            r6 = r0
            r0 = r5
            if (r0 == 0) goto L45
            r0 = r5
            java.lang.String r0 = r0.toString()
            r5 = r0
            goto L48
        L45:
            java.lang.String r0 = "null"
            r5 = r0
        L48:
            r0 = r7
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            java.lang.String r1 = ",response="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            r5 = r0
            r0 = r4
            if (r0 == 0) goto L60
            r0 = r4
            java.lang.String r0 = r0.toString()
            r5 = r0
        L60:
            r0 = r7
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "DownloadTool"
            r1 = r7
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.func.a.c.a(android.content.Context, com.opos.cmn.func.a.a):com.opos.cmn.func.a.b");
    }

    private static void a() {
        if (f11123a == null) {
            synchronized (b) {
                if (f11123a == null) {
                    f11123a = new com.opos.cmn.func.a.a.a();
                }
            }
        }
    }
}
