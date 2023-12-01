package com.zego.ve;

/* loaded from: source-8829756-dex2jar.jar:com/zego/ve/PermissionChecker.class */
public class PermissionChecker {
    /* JADX WARN: Code restructure failed: missing block: B:10:0x003b, code lost:
        if (((java.lang.Integer) java.lang.Class.forName("android.content.Context").getMethod("checkSelfPermission", java.lang.String.class).invoke(r7, r8)).intValue() == 0) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0062, code lost:
        if (r7.checkCallingPermission(r8) == 0) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0065, code lost:
        r10 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean checkSelfPermission(android.content.Context r7, java.lang.String r8) {
        /*
            r0 = 0
            r11 = r0
            r0 = r7
            if (r0 != 0) goto L9
            r0 = 0
            return r0
        L9:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 23
            if (r0 < r1) goto L48
            java.lang.String r0 = "android.content.Context"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Throwable -> L41
            java.lang.String r1 = "checkSelfPermission"
            r2 = 1
            java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L41
            r3 = r2
            r4 = 0
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r3[r4] = r5     // Catch: java.lang.Throwable -> L41
            java.lang.reflect.Method r0 = r0.getMethod(r1, r2)     // Catch: java.lang.Throwable -> L41
            r1 = r7
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L41
            r3 = r2
            r4 = 0
            r5 = r8
            r3[r4] = r5     // Catch: java.lang.Throwable -> L41
            java.lang.Object r0 = r0.invoke(r1, r2)     // Catch: java.lang.Throwable -> L41
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.Throwable -> L41
            int r0 = r0.intValue()     // Catch: java.lang.Throwable -> L41
            r9 = r0
            r0 = r11
            r10 = r0
            r0 = r9
            if (r0 != 0) goto L67
            goto L65
        L41:
            r7 = move-exception
            r0 = r7
            r0.printStackTrace()
            r0 = 0
            return r0
        L48:
            r0 = r11
            r10 = r0
            r0 = r7
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            r1 = r8
            r2 = r7
            java.lang.String r2 = r2.getPackageName()
            int r0 = r0.checkPermission(r1, r2)
            if (r0 != 0) goto L67
            r0 = r11
            r10 = r0
            r0 = r7
            r1 = r8
            int r0 = r0.checkCallingPermission(r1)
            if (r0 != 0) goto L67
        L65:
            r0 = 1
            r10 = r0
        L67:
            r0 = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zego.ve.PermissionChecker.checkSelfPermission(android.content.Context, java.lang.String):boolean");
    }
}
