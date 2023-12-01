package com.alipay.apmobilesecuritysdk.f;

import java.util.LinkedList;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/apmobilesecuritysdk/f/b.class */
public final class b {
    private static b a = new b();
    private Thread b = null;
    private LinkedList<Runnable> c = new LinkedList<>();

    public static b a() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Thread b(b bVar) {
        bVar.b = null;
        return null;
    }

    public final void a(Runnable runnable) {
        synchronized (this) {
            this.c.add(runnable);
            if (this.b == null) {
                Thread thread = new Thread(new c(this));
                this.b = thread;
                thread.start();
            }
        }
    }
}
