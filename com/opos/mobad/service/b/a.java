package com.opos.mobad.service.b;

import java.lang.Thread;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/b/a.class */
public class a implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private static final ArrayList<String> f13621a = new ArrayList<>();
    private Thread.UncaughtExceptionHandler b;

    /* renamed from: c  reason: collision with root package name */
    private AtomicBoolean f13622c = new AtomicBoolean(false);

    public a() {
        f13621a.add("com.opos");
        f13621a.add("com.heytap");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005c, code lost:
        r4 = r4.getCause();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.Throwable r4) {
        /*
            r3 = this;
        L0:
            r0 = r4
            if (r0 == 0) goto L64
            r0 = r4
            java.lang.StackTraceElement[] r0 = r0.getStackTrace()
            r7 = r0
            r0 = r7
            int r0 = r0.length
            r6 = r0
            r0 = 0
            r5 = r0
        L10:
            r0 = r5
            r1 = r6
            if (r0 >= r1) goto L5c
            r0 = r7
            r1 = r5
            r0 = r0[r1]
            java.lang.String r0 = r0.getClassName()
            r8 = r0
            r0 = r8
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L29
            goto L55
        L29:
            java.util.ArrayList<java.lang.String> r0 = com.opos.mobad.service.b.a.f13621a
            java.util.Iterator r0 = r0.iterator()
            r9 = r0
        L31:
            r0 = r9
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L55
            r0 = r8
            r1 = r9
            java.lang.Object r1 = r1.next()
            java.lang.String r1 = (java.lang.String) r1
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L31
            com.opos.mobad.service.j.n r0 = com.opos.mobad.service.j.n.a()
            r1 = r4
            r0.a(r1)
            return
        L55:
            r0 = r5
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
            goto L10
        L5c:
            r0 = r4
            java.lang.Throwable r0 = r0.getCause()
            r4 = r0
            goto L0
        L64:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.service.b.a.a(java.lang.Throwable):void");
    }

    public void a() {
        try {
            if (this.f13622c.compareAndSet(false, true)) {
                this.b = Thread.getDefaultUncaughtExceptionHandler();
                Thread.setDefaultUncaughtExceptionHandler(this);
            }
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.b("mob_crash", "init fail", th);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
        if (uncaughtExceptionHandler != null) {
            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
        try {
            a(th);
        } catch (Throwable th2) {
            com.opos.cmn.an.f.a.b("mob_crash", "handle crash fail", th2);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.b;
        if (uncaughtExceptionHandler2 != null) {
            uncaughtExceptionHandler2.uncaughtException(thread, th);
        }
    }
}
