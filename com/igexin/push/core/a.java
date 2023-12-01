package com.igexin.push.core;

import android.os.Looper;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/a.class */
public abstract class a extends Thread {
    protected abstract void a();

    protected abstract String b();

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Thread.currentThread().setName(b());
        if (Looper.myLooper() == null) {
            Looper.prepare();
            Looper.loop();
        }
    }
}
