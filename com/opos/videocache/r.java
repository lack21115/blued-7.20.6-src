package com.opos.videocache;

import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/opos/videocache/r.class */
public class r {

    /* renamed from: a  reason: collision with root package name */
    private final i f27460a;
    private final com.opos.videocache.a b;
    private volatile Thread f;
    private volatile boolean g;

    /* renamed from: c  reason: collision with root package name */
    private final Object f27461c = new Object();
    private final Object d = new Object();
    private volatile int h = -1;
    private final AtomicInteger e = new AtomicInteger();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/videocache/r$a.class */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            r.this.e();
        }
    }

    public r(i iVar, com.opos.videocache.a aVar) {
        this.f27460a = (i) f.a(iVar);
        this.b = (com.opos.videocache.a) f.a(aVar);
    }

    private void b() {
        int i = this.e.get();
        if (i < 1) {
            return;
        }
        this.e.set(0);
        throw new g("Error reading source " + i + " times");
    }

    private void b(long j, long j2) {
        a(j, j2);
        synchronized (this.f27461c) {
            this.f27461c.notifyAll();
        }
    }

    private void c() {
        synchronized (this) {
            boolean z = (this.f == null || this.f.getState() == Thread.State.TERMINATED) ? false : true;
            if (!this.g && !this.b.d() && !z) {
                a aVar = new a();
                this.f = new Thread(aVar, "Source reader for " + this.f27460a);
                this.f.start();
            }
        }
    }

    private void d() {
        synchronized (this.f27461c) {
            try {
                this.f27461c.wait(1000L);
            } catch (InterruptedException e) {
                throw new g("Waiting source data is interrupted!", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009c, code lost:
        r10 = r10 + r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e() {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.videocache.r.e():void");
    }

    private void f() {
        this.h = 100;
        a(this.h);
    }

    private void g() {
        synchronized (this.d) {
            if (!h() && this.b.a() == this.f27460a.a()) {
                this.b.c();
            }
        }
    }

    private boolean h() {
        return Thread.currentThread().isInterrupted() || this.g;
    }

    private void i() {
        try {
            this.f27460a.b();
        } catch (g e) {
            a(new g("Error closing source " + this.f27460a, e));
        }
    }

    public int a(byte[] bArr, long j, int i) {
        h.a(bArr, j, i);
        while (!this.b.d() && this.b.a() < i + j && !this.g) {
            c();
            d();
            b();
        }
        int a2 = this.b.a(bArr, j, i);
        if (this.b.d() && this.h != 100) {
            this.h = 100;
            a(100);
        }
        return a2;
    }

    public void a() {
        synchronized (this.d) {
            com.opos.cmn.an.f.a.b("ProxyCache", "Shutdown proxy for " + this.f27460a);
            try {
                this.g = true;
                if (this.f != null) {
                    this.f.interrupt();
                }
                this.b.b();
            } catch (g e) {
                a(e);
            }
        }
    }

    protected void a(int i) {
    }

    protected void a(long j, long j2) {
        boolean z = false;
        int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        int i2 = i == 0 ? 100 : (int) ((((float) j) / ((float) j2)) * 100.0f);
        boolean z2 = i2 != this.h;
        if (i >= 0) {
            z = true;
        }
        if (z && z2) {
            a(i2);
        }
        this.h = i2;
    }

    protected final void a(Throwable th) {
        if (th instanceof e) {
            com.opos.cmn.an.f.a.b("ProxyCache", "ProxyCache is interrupted");
        } else {
            com.opos.cmn.an.f.a.b("ProxyCache", "ProxyCache error", th);
        }
    }
}
