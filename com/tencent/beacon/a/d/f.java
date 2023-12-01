package com.tencent.beacon.a.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/a/d/f.class */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Runnable f21265a;
    final /* synthetic */ g b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(g gVar, Runnable runnable) {
        this.b = gVar;
        this.f21265a = runnable;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x007e, code lost:
        if (r7 == null) goto L14;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r6 = this;
            r0 = r6
            com.tencent.beacon.a.d.g r0 = r0.b
            r10 = r0
            r0 = r10
            monitor-enter(r0)
            r0 = 0
            r8 = r0
            r0 = 0
            r7 = r0
            r0 = r6
            com.tencent.beacon.a.d.g r0 = r0.b     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L32
            java.nio.channels.FileChannel r0 = com.tencent.beacon.a.d.g.e(r0)     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L32
            java.nio.channels.FileLock r0 = r0.lock()     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L32
            r9 = r0
            r0 = r9
            r7 = r0
            r0 = r9
            r8 = r0
            r0 = r6
            java.lang.Runnable r0 = r0.f21265a     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L32
            r0.run()     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L32
            r0 = r9
            if (r0 == 0) goto L85
            r0 = r9
            r7 = r0
            goto L81
        L2e:
            r9 = move-exception
            goto L36
        L32:
            r7 = move-exception
            goto L89
        L36:
            r0 = r7
            r8 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L32
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> L32
            r11 = r0
            r0 = r7
            r8 = r0
            r0 = r11
            java.lang.String r1 = "file get lock error:"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L32
            r0 = r7
            r8 = r0
            r0 = r11
            r1 = r9
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L32
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L32
            r0 = r7
            r8 = r0
            java.lang.String r0 = "[properties]"
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L32
            r2 = r1
            r3 = 0
            r4 = r11
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L32
            r2[r3] = r4     // Catch: java.lang.Throwable -> L32
            com.tencent.beacon.base.util.c.b(r0, r1)     // Catch: java.lang.Throwable -> L32
            r0 = r7
            r8 = r0
            com.tencent.beacon.a.b.g r0 = com.tencent.beacon.a.b.g.e()     // Catch: java.lang.Throwable -> L32
            r11 = r0
            r0 = r7
            r8 = r0
            r0 = r11
            java.lang.String r1 = "504"
            java.lang.String r2 = "[properties] File get lock error!"
            r3 = r9
            r0.a(r1, r2, r3)     // Catch: java.lang.Throwable -> L32
            r0 = r7
            if (r0 == 0) goto L85
        L81:
            r0 = r7
            r0.release()     // Catch: java.lang.Throwable -> L93 java.io.IOException -> L99
        L85:
            r0 = r10
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L93
            return
        L89:
            r0 = r8
            if (r0 == 0) goto L91
            r0 = r8
            r0.release()     // Catch: java.lang.Throwable -> L93 java.io.IOException -> L9d
        L91:
            r0 = r7
            throw r0     // Catch: java.lang.Throwable -> L93
        L93:
            r7 = move-exception
            r0 = r10
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L93
            r0 = r7
            throw r0
        L99:
            r7 = move-exception
            goto L85
        L9d:
            r8 = move-exception
            goto L91
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.beacon.a.d.f.run():void");
    }
}
