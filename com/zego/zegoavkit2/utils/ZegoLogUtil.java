package com.zego.zegoavkit2.utils;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/utils/ZegoLogUtil.class */
public final class ZegoLogUtil {
    /* JADX WARN: Removed duplicated region for block: B:19:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getLogPath(android.content.Context r4) {
        /*
            r0 = r4
            if (r0 != 0) goto L6
            r0 = 0
            return r0
        L6:
            java.lang.String r0 = android.os.Environment.getExternalStorageState()     // Catch: java.lang.Exception -> Ld
            r5 = r0
            goto L14
        Ld:
            r5 = move-exception
            r0 = r5
            r0.printStackTrace()
            r0 = 0
            r5 = r0
        L14:
            java.lang.String r0 = "mounted"
            r1 = r5
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L3f
            r0 = r4
            r1 = 0
            java.io.File r0 = r0.getExternalFilesDir(r1)
            r5 = r0
            r0 = r5
            if (r0 == 0) goto L3f
            r0 = r5
            java.lang.String r0 = r0.getAbsolutePath()
            r5 = r0
            r0 = r5
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L3f
            java.io.File r0 = new java.io.File
            r1 = r0
            r2 = r5
            r1.<init>(r2)
            r5 = r0
            goto L41
        L3f:
            r0 = 0
            r5 = r0
        L41:
            r0 = r5
            r6 = r0
            r0 = r5
            if (r0 != 0) goto L69
            r0 = r4
            java.io.File r0 = r0.getFilesDir()
            r4 = r0
            r0 = r5
            r6 = r0
            r0 = r4
            if (r0 == 0) goto L69
            r0 = r4
            java.lang.String r0 = r0.getAbsolutePath()
            r4 = r0
            r0 = r5
            r6 = r0
            r0 = r4
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L69
            java.io.File r0 = new java.io.File
            r1 = r0
            r2 = r4
            r1.<init>(r2)
            r6 = r0
        L69:
            r0 = r6
            if (r0 != 0) goto L6f
            r0 = 0
            return r0
        L6f:
            r0 = r6
            boolean r0 = r0.exists()
            if (r0 != 0) goto L84
            r0 = r6
            boolean r0 = r0.mkdirs()
            r0 = r6
            boolean r0 = r0.exists()
            if (r0 != 0) goto L84
            r0 = 0
            return r0
        L84:
            r0 = r6
            java.lang.String r0 = r0.getAbsolutePath()
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zego.zegoavkit2.utils.ZegoLogUtil.getLogPath(android.content.Context):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0060 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getTemporaryFolder(android.content.Context r4) {
        /*
            r0 = r4
            if (r0 != 0) goto L6
            r0 = 0
            return r0
        L6:
            java.lang.String r0 = android.os.Environment.getExternalStorageState()
            java.lang.String r1 = "mounted"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L32
            r0 = r4
            java.io.File r0 = r0.getExternalCacheDir()
            r5 = r0
            r0 = r5
            if (r0 == 0) goto L32
            r0 = r5
            java.lang.String r0 = r0.getAbsolutePath()
            r5 = r0
            r0 = r5
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L32
            java.io.File r0 = new java.io.File
            r1 = r0
            r2 = r5
            r1.<init>(r2)
            r5 = r0
            goto L34
        L32:
            r0 = 0
            r5 = r0
        L34:
            r0 = r5
            r6 = r0
            r0 = r5
            if (r0 != 0) goto L5c
            r0 = r4
            java.io.File r0 = r0.getCacheDir()
            r4 = r0
            r0 = r5
            r6 = r0
            r0 = r4
            if (r0 == 0) goto L5c
            r0 = r4
            java.lang.String r0 = r0.getAbsolutePath()
            r4 = r0
            r0 = r5
            r6 = r0
            r0 = r4
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L5c
            java.io.File r0 = new java.io.File
            r1 = r0
            r2 = r4
            r1.<init>(r2)
            r6 = r0
        L5c:
            r0 = r6
            if (r0 != 0) goto L62
            r0 = 0
            return r0
        L62:
            r0 = r6
            boolean r0 = r0.exists()
            if (r0 != 0) goto L77
            r0 = r6
            boolean r0 = r0.mkdirs()
            r0 = r6
            boolean r0 = r0.exists()
            if (r0 != 0) goto L77
            r0 = 0
            return r0
        L77:
            r0 = r6
            java.lang.String r0 = r0.getAbsolutePath()
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zego.zegoavkit2.utils.ZegoLogUtil.getTemporaryFolder(android.content.Context):java.lang.String");
    }
}
