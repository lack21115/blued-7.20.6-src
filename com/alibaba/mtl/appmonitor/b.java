package com.alibaba.mtl.appmonitor;

import com.alibaba.mtl.appmonitor.a.e;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.r;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/b.class */
public class b implements Runnable {
    private static long a = 300000;

    /* renamed from: a  reason: collision with other field name */
    private static b f21a;
    private static boolean j = false;

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void destroy() {
        r.a().f(5);
        j = false;
        f21a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void init() {
        if (j) {
            return;
        }
        i.a("CleanTask", "init TimeoutEventManager");
        f21a = new b();
        r.a().a(5, f21a, a);
        j = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        i.a("CleanTask", "clean TimeoutEvent");
        e.a().h();
        r.a().a(5, f21a, a);
    }
}
