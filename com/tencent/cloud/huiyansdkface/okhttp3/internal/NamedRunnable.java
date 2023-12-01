package com.tencent.cloud.huiyansdkface.okhttp3.internal;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/NamedRunnable.class */
public abstract class NamedRunnable implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    protected final String f35903c;

    public NamedRunnable(String str, Object... objArr) {
        this.f35903c = Util.format(str, objArr);
    }

    protected abstract void execute();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f35903c);
        try {
            execute();
            Thread.currentThread().setName(name);
        } catch (Throwable th) {
            Thread.currentThread().setName(name);
            throw th;
        }
    }
}
