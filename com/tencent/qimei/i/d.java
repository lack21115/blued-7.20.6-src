package com.tencent.qimei.i;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/i/d.class */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f38335a;
    public final /* synthetic */ e b;

    public d(e eVar, Runnable runnable) {
        this.b = eVar;
        this.f38335a = runnable;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
        if (r3 == null) goto L14;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r2 = this;
            r0 = r2
            com.tencent.qimei.i.e r0 = r0.b
            r6 = r0
            r0 = r6
            monitor-enter(r0)
            r0 = 0
            r4 = r0
            r0 = 0
            r3 = r0
            r0 = r2
            com.tencent.qimei.i.e r0 = r0.b     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L32
            java.nio.channels.FileChannel r0 = r0.b     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L32
            java.nio.channels.FileLock r0 = r0.lock()     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L32
            r5 = r0
            r0 = r5
            r3 = r0
            r0 = r5
            r4 = r0
            r0 = r2
            java.lang.Runnable r0 = r0.f38335a     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L32
            r0.run()     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L32
            r0 = r5
            if (r0 == 0) goto L45
            r0 = r5
            r3 = r0
            goto L41
        L2e:
            r5 = move-exception
            goto L36
        L32:
            r3 = move-exception
            goto L49
        L36:
            r0 = r3
            r4 = r0
            r0 = r5
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L32
            r0 = r3
            if (r0 == 0) goto L45
        L41:
            r0 = r3
            r0.release()     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L59
        L45:
            r0 = r6
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L53
            return
        L49:
            r0 = r4
            if (r0 == 0) goto L51
            r0 = r4
            r0.release()     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L5d
        L51:
            r0 = r3
            throw r0     // Catch: java.lang.Throwable -> L53
        L53:
            r3 = move-exception
            r0 = r6
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L53
            r0 = r3
            throw r0
        L59:
            r3 = move-exception
            goto L45
        L5d:
            r4 = move-exception
            goto L51
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qimei.i.d.run():void");
    }
}
