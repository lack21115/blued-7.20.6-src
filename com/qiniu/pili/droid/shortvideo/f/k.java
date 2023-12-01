package com.qiniu.pili.droid.shortvideo.f;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/f/k.class */
public abstract class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f27684a = false;
    private volatile boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private Thread f27685c;

    public boolean a() {
        e.f27672a.c(j(), "start +");
        if (this.f27684a) {
            e.f27672a.d(j(), "already started !");
            return false;
        }
        this.f27684a = true;
        c(false);
        Thread thread = new Thread(this, j());
        this.f27685c = thread;
        thread.start();
        e.f27672a.c(j(), "start -");
        return true;
    }

    protected void c(boolean z) {
        this.b = z;
    }

    public boolean c() {
        e.f27672a.c(j(), "stop +");
        if (!this.f27684a) {
            e.f27672a.d(j(), "already stopped !");
            return false;
        }
        c(true);
        this.f27684a = false;
        e.f27672a.c(j(), "stop -");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String j();

    public boolean l() {
        return this.f27684a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean m() {
        return this.b;
    }
}
