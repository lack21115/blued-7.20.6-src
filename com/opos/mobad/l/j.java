package com.opos.mobad.l;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.opos.mobad.ad.b;
import com.opos.mobad.ad.g;
import java.util.concurrent.Callable;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/l/j.class */
public abstract class j extends g.a implements com.opos.mobad.ad.b {

    /* renamed from: a  reason: collision with root package name */
    private b.a f12619a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private long f12620c;
    private p d;
    public Handler e;
    o f;

    public j(int i, b.a aVar) {
        n();
        Handler handler = new Handler(Looper.getMainLooper());
        this.e = handler;
        this.d = new p(handler, new Runnable() { // from class: com.opos.mobad.l.j.1
            @Override // java.lang.Runnable
            public void run() {
                j.this.l();
            }
        });
        this.f12619a = aVar;
        this.b = i;
    }

    public j(b.a aVar) {
        this(-1, aVar);
    }

    public void a() {
        a(m.a());
    }

    @Override // com.opos.mobad.ad.b
    public void a(int i) {
        a(m.a(), i);
    }

    public final void a(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.e.post(runnable);
        }
    }

    public void a(String str) {
        com.opos.cmn.an.f.a.b("", "loadAd:" + str);
        a(str, 30000);
    }

    public void a(final String str, final int i) {
        com.opos.cmn.an.f.a.b("", "loadAd :" + str + ", " + i);
        b(new Callable<Boolean>() { // from class: com.opos.mobad.l.j.2
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                return Boolean.valueOf(j.this.b(str, i));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Callable<Boolean> callable) {
        b.a aVar;
        this.d.a();
        int a2 = this.f.a(6, callable);
        com.opos.cmn.an.f.a.b("SyncStateController", "onTimeout state=" + a2 + ",Ad = " + this);
        if (6 != a2 || (aVar = this.f12619a) == null) {
            return;
        }
        aVar.a(-1, "load ad timeout");
    }

    public void b() {
        this.d.b();
        this.f.a(5);
    }

    public final void b(final int i, final String str) {
        this.d.a();
        this.e.post(new Runnable() { // from class: com.opos.mobad.l.j.3
            @Override // java.lang.Runnable
            public void run() {
                if (6 == j.this.f.a()) {
                    com.opos.cmn.an.f.a.b("SyncStateController", "onAdFailed but timeout");
                    return;
                }
                int a2 = j.this.f.a(1, 0);
                com.opos.cmn.an.f.a.b("SyncStateController", "onLoadFailed state=" + a2 + ",Ad = " + this);
                if (5 == a2 || j.this.f12619a == null) {
                    return;
                }
                j.this.f12619a.a(i, str);
            }
        });
    }

    final void b(Callable<Boolean> callable) {
        int a2 = this.f.a(1, callable);
        com.opos.cmn.an.f.a.b("SyncStateController", "loadAd state=" + a2 + ",Ad =" + this);
        if (1 == a2) {
            return;
        }
        if (5 == a2) {
            b.a aVar = this.f12619a;
            if (aVar != null) {
                aVar.a(11001, "ad has destroyed.");
                return;
            }
            return;
        }
        b.a aVar2 = this.f12619a;
        if (aVar2 != null) {
            aVar2.a(-1, "load with illegal state:" + a2);
        }
    }

    protected abstract boolean b(String str);

    protected boolean b(String str, int i) {
        if (i > 0) {
            this.d.a(i);
        } else {
            this.d.a();
        }
        return b(str);
    }

    public final void c(final int i, final String str) {
        this.d.a();
        this.e.post(new Runnable() { // from class: com.opos.mobad.l.j.4
            @Override // java.lang.Runnable
            public void run() {
                int a2 = j.this.f.a(0);
                com.opos.cmn.an.f.a.b("SyncStateController", "onAdFailed state=" + a2 + ",Ad = " + this);
                if (5 == a2 || j.this.f12619a == null) {
                    return;
                }
                j.this.f12619a.a(i, str);
            }
        });
    }

    public final void c(Callable<Boolean> callable) {
        this.d.a();
        if (2 == this.f.a(2, callable)) {
            this.f12620c = SystemClock.elapsedRealtime();
            a(new Runnable() { // from class: com.opos.mobad.l.j.6
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.f12619a != null) {
                        j.this.f12619a.a();
                    }
                }
            });
        }
    }

    @Override // com.opos.mobad.ad.b
    public int d() {
        return this.f.a();
    }

    public boolean e() {
        if (2 == d()) {
            int i = this.b;
            return i <= 0 || this.f12620c + ((long) i) >= SystemClock.elapsedRealtime();
        }
        return false;
    }

    public void i_() {
        b.a aVar = this.f12619a;
        if (aVar != null) {
            aVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        b.a aVar;
        this.d.a();
        int a2 = this.f.a(6);
        com.opos.cmn.an.f.a.b("SyncStateController", "onTimeout state=" + a2 + ",Ad = " + this);
        if (6 != a2 || (aVar = this.f12619a) == null) {
            return;
        }
        aVar.a(-1, "load ad timeout");
    }

    void n() {
        this.f = l.a();
    }

    public final void o() {
        this.d.a();
        if (2 == this.f.a(2)) {
            this.f12620c = SystemClock.elapsedRealtime();
            a(new Runnable() { // from class: com.opos.mobad.l.j.5
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.f12619a != null) {
                        j.this.f12619a.a();
                    }
                }
            });
        }
    }
}
