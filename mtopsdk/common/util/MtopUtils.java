package mtopsdk.common.util;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/common/util/MtopUtils.class */
public final class MtopUtils {

    /* renamed from: a  reason: collision with root package name */
    private static AtomicInteger f43683a = new AtomicInteger();

    private MtopUtils() {
    }

    public static int a() {
        return f43683a.incrementAndGet() & Integer.MAX_VALUE;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.Serializable a(java.io.File r7, java.lang.String r8) {
        /*
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L4a
            r1 = r0
            r2 = r7
            r3 = r8
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L4a
            r9 = r0
            r0 = r9
            boolean r0 = r0.exists()     // Catch: java.lang.Throwable -> L4a
            if (r0 != 0) goto L13
            r0 = 0
            return r0
        L13:
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L4a
            r1 = r0
            r2 = r9
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L4a
            r9 = r0
            java.io.ObjectInputStream r0 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L46 java.lang.Throwable -> L4a
            r1 = r0
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L46
            r3 = r2
            r4 = r9
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L46
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L46
            r11 = r0
            r0 = r11
            java.lang.Object r0 = r0.readObject()     // Catch: java.lang.Throwable -> L46
            java.io.Serializable r0 = (java.io.Serializable) r0     // Catch: java.lang.Throwable -> L46
            r10 = r0
            r0 = r11
            r0.close()     // Catch: java.lang.Throwable -> L41
        L3b:
            r0 = r9
            r0.close()     // Catch: java.io.IOException -> L82
            r0 = r10
            return r0
        L41:
            r11 = move-exception
            goto L56
        L46:
            r10 = move-exception
            goto L4d
        L4a:
            r10 = move-exception
            r0 = 0
            r9 = r0
        L4d:
            r0 = 0
            r12 = r0
            r0 = r10
            r11 = r0
            r0 = r12
            r10 = r0
        L56:
            java.lang.String r0 = "mtopsdk.MtopUtils"
            java.lang.String r1 = "readObject error.fileDir={%s},fileName={%s}"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L77
            r3 = r2
            r4 = 0
            r5 = r7
            r3[r4] = r5     // Catch: java.lang.Throwable -> L77
            r3 = r2
            r4 = 1
            r5 = r8
            r3[r4] = r5     // Catch: java.lang.Throwable -> L77
            java.lang.String r1 = java.lang.String.format(r1, r2)     // Catch: java.lang.Throwable -> L77
            r2 = r11
            mtopsdk.common.util.TBSdkLog.a(r0, r1, r2)     // Catch: java.lang.Throwable -> L77
            r0 = r9
            if (r0 == 0) goto L75
            goto L3b
        L75:
            r0 = r10
            return r0
        L77:
            r7 = move-exception
            r0 = r9
            if (r0 == 0) goto L80
            r0 = r9
            r0.close()     // Catch: java.io.IOException -> L85
        L80:
            r0 = r7
            throw r0
        L82:
            r7 = move-exception
            r0 = r10
            return r0
        L85:
            r8 = move-exception
            goto L80
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.common.util.MtopUtils.a(java.io.File, java.lang.String):java.io.Serializable");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.io.Serializable r7, java.io.File r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.common.util.MtopUtils.a(java.io.Serializable, java.io.File, java.lang.String):boolean");
    }

    public static boolean b() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }
}
