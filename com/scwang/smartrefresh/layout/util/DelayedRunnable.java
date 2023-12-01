package com.scwang.smartrefresh.layout.util;

/* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/util/DelayedRunnable.class */
public class DelayedRunnable implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public long f27997a;
    private Runnable b;

    public DelayedRunnable(Runnable runnable, long j) {
        this.b = runnable;
        this.f27997a = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.b != null) {
                this.b.run();
                this.b = null;
            }
        } catch (Throwable th) {
            if (th instanceof NoClassDefFoundError) {
                return;
            }
            th.printStackTrace();
        }
    }
}
