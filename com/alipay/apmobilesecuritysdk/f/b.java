package com.alipay.apmobilesecuritysdk.f;

import java.util.LinkedList;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/apmobilesecuritysdk/f/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f4558a = new b();
    private Thread b = null;

    /* renamed from: c  reason: collision with root package name */
    private LinkedList<Runnable> f4559c = new LinkedList<>();

    public static b a() {
        return f4558a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Thread b(b bVar) {
        bVar.b = null;
        return null;
    }

    public final void a(Runnable runnable) {
        synchronized (this) {
            this.f4559c.add(runnable);
            if (this.b == null) {
                Thread thread = new Thread(new c(this));
                this.b = thread;
                thread.start();
            }
        }
    }
}
