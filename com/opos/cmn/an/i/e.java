package com.opos.cmn.an.i;

import com.opos.cmn.an.i.d;
import java.util.concurrent.ExecutorService;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/i/e.class */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f10885a = new byte[0];
    private static d b;

    private static void a() {
        if (b == null) {
            synchronized (f10885a) {
                if (b == null) {
                    b = new d.a().a(a.a()).b(a.b()).c(a.d()).d(a.c()).e(a.e()).a(a.f()).a();
                    com.opos.cmn.an.f.a.b("ThreadPoolTool", "initIfNeed ThreadPoolParams=" + b.toString());
                }
            }
        }
    }

    public static void a(Runnable runnable) {
        a();
        ExecutorService executorService = b.b;
        if (executorService != null) {
            try {
                executorService.execute(runnable);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ThreadPoolTool", "executeIOTask", e);
            }
        }
    }
}
