package com.amap.api.col.p0003sl;

import com.amap.api.col.p0003sl.la;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.amap.api.col.3sl.lb  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/lb.class */
public final class lb extends ld {

    /* renamed from: c  reason: collision with root package name */
    private static lb f5356c = new lb(new la.a().a("amap-global-threadPool").b());

    private lb(la laVar) {
        try {
            this.f5357a = new ThreadPoolExecutor(laVar.a(), laVar.b(), laVar.d(), TimeUnit.SECONDS, laVar.c(), laVar);
            this.f5357a.allowCoreThreadTimeOut(true);
        } catch (Throwable th) {
            iw.c(th, "TPool", "ThreadPool");
            th.printStackTrace();
        }
    }

    public static lb a() {
        return f5356c;
    }

    public static lb a(la laVar) {
        return new lb(laVar);
    }

    @Deprecated
    public static lb b() {
        lb lbVar;
        synchronized (lb.class) {
            try {
                if (f5356c == null) {
                    f5356c = new lb(new la.a().b());
                }
                lbVar = f5356c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return lbVar;
    }

    @Deprecated
    public static lb c() {
        return new lb(new la.a().b());
    }
}
