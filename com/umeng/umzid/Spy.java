package com.umeng.umzid;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/umzid/Spy.class */
public class Spy {
    public static boolean initSuccess = false;

    static {
        try {
            System.loadLibrary("umeng-spy");
            initSuccess = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String getID() {
        if (initSuccess) {
            return getNativeID();
        }
        return null;
    }

    public static native String getNativeID();

    public static native String getNativeLibraryVersion();

    public static native String getNativeTag(boolean z, boolean z2);

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005c, code lost:
        if (r4 != (-1)) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getTag(android.content.Context r3) {
        /*
            java.lang.Class<com.umeng.umzid.Spy> r0 = com.umeng.umzid.Spy.class
            monitor-enter(r0)
            r0 = 1
            r5 = r0
            r0 = 0
            r6 = r0
            r0 = r3
            if (r0 == 0) goto L8b
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L62
            r1 = 14
            if (r0 < r1) goto L86
            r0 = 1
            r4 = r0
            goto L18
        L18:
            r0 = r4
            if (r0 == 0) goto L43
            java.lang.String r0 = "http.proxyHost"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch: java.lang.Throwable -> L62
            r9 = r0
            java.lang.String r0 = "http.proxyPort"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch: java.lang.Throwable -> L62
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L32
            goto L36
        L32:
            java.lang.String r0 = "-1"
            r8 = r0
        L36:
            r0 = r8
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L62
            r4 = r0
            r0 = r9
            r8 = r0
            goto L4e
        L43:
            r0 = r3
            java.lang.String r0 = android.net.Proxy.getHost(r0)     // Catch: java.lang.Throwable -> L62
            r8 = r0
            r0 = r3
            int r0 = android.net.Proxy.getPort(r0)     // Catch: java.lang.Throwable -> L62
            r4 = r0
        L4e:
            r0 = r8
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L62
            r7 = r0
            r0 = r7
            if (r0 != 0) goto L8b
            r0 = r4
            r1 = -1
            if (r0 == r1) goto L8b
            goto L6c
        L62:
            r8 = move-exception
            r0 = r8
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L80
            goto L8b
        L6c:
            r0 = r3
            if (r0 == 0) goto L75
            r0 = r3
            boolean r0 = com.umeng.umzid.d.e(r0)     // Catch: java.lang.Throwable -> L80
            r6 = r0
        L75:
            r0 = r5
            r1 = r6
            java.lang.String r0 = getNativeTag(r0, r1)     // Catch: java.lang.Throwable -> L80
            r3 = r0
            java.lang.Class<com.umeng.umzid.Spy> r0 = com.umeng.umzid.Spy.class
            monitor-exit(r0)
            r0 = r3
            return r0
        L80:
            r3 = move-exception
            java.lang.Class<com.umeng.umzid.Spy> r0 = com.umeng.umzid.Spy.class
            monitor-exit(r0)
            r0 = r3
            throw r0
        L86:
            r0 = 0
            r4 = r0
            goto L18
        L8b:
            r0 = 0
            r5 = r0
            goto L6c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.Spy.getTag(android.content.Context):java.lang.String");
    }

    public static String getVersion() {
        if (initSuccess) {
            return getNativeLibraryVersion();
        }
        return null;
    }
}
