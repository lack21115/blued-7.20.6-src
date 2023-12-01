package android.graphics;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/TemporaryBuffer.class */
public class TemporaryBuffer {
    private static char[] sTemp = null;

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        if (r0.length < r3) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static char[] obtain(int r3) {
        /*
            java.lang.Class<android.graphics.TemporaryBuffer> r0 = android.graphics.TemporaryBuffer.class
            monitor-enter(r0)
            char[] r0 = android.graphics.TemporaryBuffer.sTemp     // Catch: java.lang.Throwable -> L21
            r5 = r0
            r0 = 0
            android.graphics.TemporaryBuffer.sTemp = r0     // Catch: java.lang.Throwable -> L21
            java.lang.Class<android.graphics.TemporaryBuffer> r0 = android.graphics.TemporaryBuffer.class
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L21
            r0 = r5
            if (r0 == 0) goto L1a
            r0 = r5
            r4 = r0
            r0 = r5
            int r0 = r0.length
            r1 = r3
            if (r0 >= r1) goto L1f
        L1a:
            r0 = r3
            char[] r0 = com.android.internal.util.ArrayUtils.newUnpaddedCharArray(r0)
            r4 = r0
        L1f:
            r0 = r4
            return r0
        L21:
            r4 = move-exception
            java.lang.Class<android.graphics.TemporaryBuffer> r0 = android.graphics.TemporaryBuffer.class
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L21
            r0 = r4
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.graphics.TemporaryBuffer.obtain(int):char[]");
    }

    public static void recycle(char[] cArr) {
        if (cArr.length > 1000) {
            return;
        }
        synchronized (TemporaryBuffer.class) {
            try {
                sTemp = cArr;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
