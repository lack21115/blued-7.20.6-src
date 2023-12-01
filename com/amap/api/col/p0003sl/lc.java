package com.amap.api.col.p0003sl;

/* renamed from: com.amap.api.col.3sl.lc  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/lc.class */
public abstract class lc implements Runnable {
    a f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.lc$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/lc$a.class */
    public interface a {
        void a(lc lcVar);

        void b(lc lcVar);
    }

    public final void cancelTask() {
        try {
            if (this.f != null) {
                this.f.b(this);
            }
        } catch (Throwable th) {
            iw.c(th, "ThreadTask", "cancelTask");
            th.printStackTrace();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (Thread.interrupted()) {
                return;
            }
            runTask();
            if (Thread.interrupted() || this.f == null) {
                return;
            }
            this.f.a(this);
        } catch (Throwable th) {
            iw.c(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }

    public abstract void runTask();
}
