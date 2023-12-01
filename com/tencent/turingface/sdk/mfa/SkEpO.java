package com.tencent.turingface.sdk.mfa;

import android.os.Build;
import com.tencent.turingface.sdk.mfa.ORjG3;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/SkEpO.class */
public final class SkEpO {

    /* renamed from: a  reason: collision with root package name */
    public static volatile ORjG3 f39923a;

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0049, code lost:
        if ((r9 instanceof java.lang.InterruptedException) != false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.tencent.turingface.sdk.mfa.ORjG3.SkEpO a(java.lang.String r7) {
        /*
            com.tencent.turingface.sdk.mfa.ORjG3$ShGzN r0 = new com.tencent.turingface.sdk.mfa.ORjG3$ShGzN
            r1 = r0
            r2 = r7
            r3 = r7
            r4 = 5000(0x1388, double:2.4703E-320)
            r1.<init>(r2, r3, r4)
            r7 = r0
            r0 = 0
            r8 = r0
            com.tencent.turingface.sdk.mfa.ORjG3 r0 = com.tencent.turingface.sdk.mfa.SkEpO.f39923a     // Catch: java.lang.Exception -> L3b
            if (r0 != 0) goto L30
            java.lang.Class<com.tencent.turingface.sdk.mfa.SkEpO> r0 = com.tencent.turingface.sdk.mfa.SkEpO.class
            monitor-enter(r0)     // Catch: java.lang.Exception -> L3b
            com.tencent.turingface.sdk.mfa.ORjG3 r0 = com.tencent.turingface.sdk.mfa.SkEpO.f39923a     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L3b
            if (r0 != 0) goto L24
            com.tencent.turingface.sdk.mfa.ORjG3 r0 = a()     // Catch: java.lang.Throwable -> L2a
            com.tencent.turingface.sdk.mfa.SkEpO.f39923a = r0     // Catch: java.lang.Throwable -> L2a
        L24:
            java.lang.Class<com.tencent.turingface.sdk.mfa.SkEpO> r0 = com.tencent.turingface.sdk.mfa.SkEpO.class
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2a
            goto L30
        L2a:
            r7 = move-exception
            java.lang.Class<com.tencent.turingface.sdk.mfa.SkEpO> r0 = com.tencent.turingface.sdk.mfa.SkEpO.class
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2a
            r0 = r7
            throw r0     // Catch: java.lang.Exception -> L3b
        L30:
            com.tencent.turingface.sdk.mfa.ORjG3 r0 = com.tencent.turingface.sdk.mfa.SkEpO.f39923a     // Catch: java.lang.Exception -> L3b java.lang.Exception -> L3b
            r1 = r7
            com.tencent.turingface.sdk.mfa.ORjG3$SkEpO r0 = r0.a(r1)     // Catch: java.lang.Exception -> L3b
            r7 = r0
            goto L7c
        L3b:
            r9 = move-exception
            r0 = r9
            boolean r0 = r0 instanceof java.io.IOException
            if (r0 != 0) goto L4c
            r0 = r8
            r7 = r0
            r0 = r9
            boolean r0 = r0 instanceof java.lang.InterruptedException
            if (r0 == 0) goto L7c
        L4c:
            r0 = r8
            r7 = r0
            com.tencent.turingface.sdk.mfa.ORjG3 r0 = com.tencent.turingface.sdk.mfa.SkEpO.f39923a
            if (r0 == 0) goto L7c
            java.lang.Class<com.tencent.turingface.sdk.mfa.SkEpO> r0 = com.tencent.turingface.sdk.mfa.SkEpO.class
            monitor-enter(r0)
            com.tencent.turingface.sdk.mfa.ORjG3 r0 = com.tencent.turingface.sdk.mfa.SkEpO.f39923a     // Catch: java.lang.Throwable -> L76
            if (r0 == 0) goto L6e
            com.tencent.turingface.sdk.mfa.ORjG3 r0 = com.tencent.turingface.sdk.mfa.SkEpO.f39923a     // Catch: java.lang.Throwable -> L76
            r7 = r0
            r0 = r7
            java.lang.Class r0 = r0.getClass()     // Catch: java.lang.Throwable -> L76
            r0 = r7
            r0.a()     // Catch: java.lang.Throwable -> L90
        L6a:
            r0 = 0
            com.tencent.turingface.sdk.mfa.SkEpO.f39923a = r0     // Catch: java.lang.Throwable -> L76
        L6e:
            java.lang.Class<com.tencent.turingface.sdk.mfa.SkEpO> r0 = com.tencent.turingface.sdk.mfa.SkEpO.class
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L76
            r0 = r8
            r7 = r0
            goto L7c
        L76:
            r7 = move-exception
            java.lang.Class<com.tencent.turingface.sdk.mfa.SkEpO> r0 = com.tencent.turingface.sdk.mfa.SkEpO.class
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L76
            r0 = r7
            throw r0
        L7c:
            r0 = r7
            r8 = r0
            r0 = r7
            if (r0 != 0) goto L8e
            com.tencent.turingface.sdk.mfa.ORjG3$SkEpO r0 = new com.tencent.turingface.sdk.mfa.ORjG3$SkEpO
            r1 = r0
            java.lang.String r2 = ""
            java.lang.String r3 = "e"
            r1.<init>(r2, r3)
            r8 = r0
        L8e:
            r0 = r8
            return r0
        L90:
            r7 = move-exception
            goto L6a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingface.sdk.mfa.SkEpO.a(java.lang.String):com.tencent.turingface.sdk.mfa.ORjG3$SkEpO");
    }

    public static ORjG3 a() {
        ORjG3 oRjG3;
        ORjG3 oRjG32;
        try {
            oRjG3 = new ORjG3();
            try {
                int i = Build.VERSION.SDK_INT;
                oRjG32 = oRjG3;
                if (i >= 14) {
                    oRjG32 = oRjG3;
                    if (i < 20) {
                        synchronized (oRjG3) {
                            synchronized (oRjG3) {
                                oRjG3.a(new ORjG3.ShGzN("export LD_LIBRARY_PATH=/vendor/lib:/system/lib", "export LD_LIBRARY_PATH=/vendor/lib:/system/lib", 5000L));
                            }
                            oRjG32 = oRjG3;
                        }
                        oRjG32 = oRjG3;
                    }
                }
            } catch (Exception e) {
                oRjG32 = oRjG3;
                if (oRjG3 != null) {
                    try {
                        oRjG3.a();
                        return null;
                    } catch (Throwable th) {
                        return null;
                    }
                }
                return oRjG32;
            }
        } catch (Exception e2) {
            oRjG3 = null;
        }
        return oRjG32;
    }
}
