package com.igexin.base.a;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7994992-dex2jar.jar:com/igexin/base/a/b.class */
public final class b implements Runnable {
    private static b b;

    /* renamed from: a  reason: collision with root package name */
    final List<c> f9597a = new ArrayList();

    private b() {
        Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(this, 5L, 5L, TimeUnit.SECONDS);
    }

    public static b a() {
        b bVar;
        synchronized (b.class) {
            try {
                if (b == null) {
                    b = new b();
                }
                bVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0318 A[Catch: all -> 0x0340, TRY_ENTER, TryCatch #0 {all -> 0x0340, blocks: (B:3:0x0004, B:5:0x001d, B:7:0x002c, B:11:0x0036, B:15:0x0040, B:19:0x004a, B:21:0x005b, B:23:0x0063, B:24:0x007f, B:26:0x0087, B:126:0x032d, B:128:0x0335, B:130:0x033b, B:121:0x0318, B:123:0x0320), top: B:150:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:173:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(com.igexin.base.a.c r7) {
        /*
            Method dump skipped, instructions count: 870
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.base.a.b.a(com.igexin.base.a.c):boolean");
    }

    @Override // java.lang.Runnable
    public final void run() {
        for (c cVar : this.f9597a) {
            if (cVar.isEnabled()) {
                if (cVar.f9598a.size() >= cVar.b || SystemClock.elapsedRealtime() - cVar.d >= cVar.f9599c) {
                    a(cVar);
                    cVar.d = SystemClock.elapsedRealtime();
                }
            }
        }
    }
}
