package com.opos.cmn.an.j.b;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/j/b/c.class */
public final class c implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private Handler f10900a = new Handler(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.f10900a.post(new Runnable() { // from class: com.opos.cmn.an.j.b.c.1
                @Override // java.lang.Runnable
                public void run() {
                    runnable.run();
                }
            });
        }
    }
}
