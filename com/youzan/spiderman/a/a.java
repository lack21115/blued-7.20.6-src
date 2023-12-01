package com.youzan.spiderman.a;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/a/a.class */
public abstract class a implements Runnable {
    public abstract void a() throws Throwable;

    public abstract void a(Throwable th);

    @Override // java.lang.Runnable
    public void run() {
        try {
            a();
        } catch (Throwable th) {
            a(th);
        }
    }
}
