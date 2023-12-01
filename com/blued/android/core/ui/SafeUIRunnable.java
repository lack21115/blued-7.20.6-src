package com.blued.android.core.ui;

import com.blued.android.core.net.IRequestHost;

@Deprecated
/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/ui/SafeUIRunnable.class */
public class SafeUIRunnable implements Runnable {
    private final IRequestHost a;
    private final Runnable b;

    @Override // java.lang.Runnable
    public void run() {
        IRequestHost iRequestHost = this.a;
        if (iRequestHost == null || !iRequestHost.isActive()) {
            return;
        }
        this.b.run();
    }
}
