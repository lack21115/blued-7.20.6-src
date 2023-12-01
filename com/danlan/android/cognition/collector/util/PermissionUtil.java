package com.danlan.android.cognition.collector.util;

import android.content.Context;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/collector/util/PermissionUtil.class */
public final class PermissionUtil {
    private final Context context;

    public PermissionUtil(Context context) {
        this.context = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0026, code lost:
        if (androidx.core.content.ContextCompat.checkSelfPermission(r3.context, r4) != 0) goto L15;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0031 -> B:36:0x004a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isPermissionGranted(java.lang.String r4) {
        /*
            r3 = this;
            r0 = r3
            monitor-enter(r0)
            r0 = 1
            r6 = r0
            r0 = r3
            monitor-enter(r0)     // Catch: java.lang.Throwable -> L45
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L30 java.lang.Throwable -> L45
            r1 = 23
            if (r0 >= r1) goto L1c
            r0 = r3
            android.content.Context r0 = r0.context     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L30
            r1 = r4
            int r0 = r0.checkCallingOrSelfPermission(r1)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L30
            if (r0 == 0) goto L3b
            goto L4a
        L1c:
            r0 = r3
            android.content.Context r0 = r0.context     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L30
            r1 = r4
            int r0 = androidx.core.content.ContextCompat.checkSelfPermission(r0, r1)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L30
            r5 = r0
            r0 = r5
            if (r0 == 0) goto L3b
            goto L4a
        L2c:
            r4 = move-exception
            goto L41
        L30:
            r4 = move-exception
            r0 = r4
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L2c
            com.danlan.android.cognition.Logger.e(r0)     // Catch: java.lang.Throwable -> L2c
            goto L4a
        L3b:
            r0 = r3
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2c
            r0 = r3
            monitor-exit(r0)
            r0 = r6
            return r0
        L41:
            r0 = r3
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2c
            r0 = r4
            throw r0     // Catch: java.lang.Throwable -> L45
        L45:
            r4 = move-exception
            r0 = r3
            monitor-exit(r0)
            r0 = r4
            throw r0
        L4a:
            r0 = 0
            r6 = r0
            goto L3b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danlan.android.cognition.collector.util.PermissionUtil.isPermissionGranted(java.lang.String):boolean");
    }
}
