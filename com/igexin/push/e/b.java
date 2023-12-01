package com.igexin.push.e;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/e/b.class */
public abstract class b {

    /* renamed from: c  reason: collision with root package name */
    private static final String f9996c = "ExtensionTask";

    /* renamed from: a  reason: collision with root package name */
    protected long f9997a = 0;
    protected long b = 0;

    private void a(long j) {
        this.f9997a = j;
    }

    private boolean b() {
        getClass().getName();
        System.currentTimeMillis();
        return System.currentTimeMillis() - this.f9997a > this.b;
    }

    public abstract void a();
}
