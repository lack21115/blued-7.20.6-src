package com.qiniu.pili.droid.shortvideo.f;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/f/k.class */
public abstract class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f13996a = false;
    private volatile boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private Thread f13997c;

    public boolean a() {
        e.f13984a.c(j(), "start +");
        if (this.f13996a) {
            e.f13984a.d(j(), "already started !");
            return false;
        }
        this.f13996a = true;
        c(false);
        Thread thread = new Thread(this, j());
        this.f13997c = thread;
        thread.start();
        e.f13984a.c(j(), "start -");
        return true;
    }

    protected void c(boolean z) {
        this.b = z;
    }

    public boolean c() {
        e.f13984a.c(j(), "stop +");
        if (!this.f13996a) {
            e.f13984a.d(j(), "already stopped !");
            return false;
        }
        c(true);
        this.f13996a = false;
        e.f13984a.c(j(), "stop -");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String j();

    public boolean l() {
        return this.f13996a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean m() {
        return this.b;
    }
}
