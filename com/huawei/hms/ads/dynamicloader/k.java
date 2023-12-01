package com.huawei.hms.ads.dynamicloader;

import com.huawei.hms.ads.uiengineloader.aa;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dynamicloader/k.class */
public final class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8868a = "SafeRunnable";
    private Runnable b;

    public k(Runnable runnable) {
        this.b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable = this.b;
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable th) {
                aa.d(f8868a, "exception in task run: " + th.getClass().getSimpleName());
            }
        }
    }
}
