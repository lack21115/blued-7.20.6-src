package com.opos.mobad.l;

import android.os.Handler;
import android.os.Looper;
import com.opos.mobad.ad.g;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/l/f.class */
public abstract class f<T> extends g.a implements com.opos.mobad.ad.b {

    /* renamed from: a  reason: collision with root package name */
    protected Handler f12609a;
    private com.opos.mobad.ad.c.a<T> b;

    /* renamed from: c  reason: collision with root package name */
    private o f12610c = l.a();
    private p d;

    public f(com.opos.mobad.ad.c.a<T> aVar) {
        Handler handler = new Handler(Looper.getMainLooper());
        this.f12609a = handler;
        this.d = new p(handler, new Runnable() { // from class: com.opos.mobad.l.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.h();
            }
        });
        this.b = aVar;
    }

    private final void a(Callable<Boolean> callable) {
        int a2 = this.f12610c.a(1, callable);
        com.opos.cmn.an.f.a.b("", "loadAd state=" + a2 + ",Ad =" + this);
        if (1 == a2) {
            return;
        }
        if (5 == a2) {
            com.opos.mobad.ad.c.a<T> aVar = this.b;
            if (aVar != null) {
                aVar.a(11001, "ad has destroyed.");
                return;
            }
            return;
        }
        com.opos.mobad.ad.c.a<T> aVar2 = this.b;
        if (aVar2 != null) {
            aVar2.a(-1, "load with illegal state:" + a2);
        }
    }

    public void a() {
        a(m.a());
    }

    @Override // com.opos.mobad.ad.b
    public void a(int i) {
        a(m.a(), i);
    }

    public final void a(final int i, final String str) {
        this.d.a();
        this.f12609a.post(new Runnable() { // from class: com.opos.mobad.l.f.3
            @Override // java.lang.Runnable
            public void run() {
                int a2 = f.this.f12610c.a(1, 0);
                com.opos.cmn.an.f.a.b("SyncStateController", "state=" + a2 + ",Ad = " + this);
                if (5 == a2 || f.this.b == null) {
                    return;
                }
                f.this.b.a(i, str);
            }
        });
    }

    @Override // com.opos.mobad.ad.b
    public void a(String str) {
        com.opos.cmn.an.f.a.b("", "loadAd:" + str);
        a(str, 30000);
    }

    @Override // com.opos.mobad.ad.b
    public void a(final String str, final int i) {
        com.opos.cmn.an.f.a.b("", "loadAd :" + str + ", " + i);
        a(new Callable<Boolean>() { // from class: com.opos.mobad.l.f.2
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                return Boolean.valueOf(f.this.b(str, i));
            }
        });
    }

    public final void a(List<T> list) {
        com.opos.mobad.ad.c.a<T> aVar;
        this.d.a();
        if (2 != this.f12610c.a(2) || (aVar = this.b) == null) {
            return;
        }
        aVar.a(list);
    }

    public void b() {
        this.d.b();
        this.f12610c.a(5);
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

    @Override // com.opos.mobad.ad.b
    public int d() {
        return this.f12610c.a();
    }

    public boolean e() {
        return false;
    }

    protected void h() {
        com.opos.mobad.ad.c.a<T> aVar;
        this.d.a();
        int a2 = this.f12610c.a(6);
        com.opos.cmn.an.f.a.b("SyncStateController", "onTimeout state=" + a2 + ",Ad = " + this);
        if (6 != a2 || (aVar = this.b) == null) {
            return;
        }
        aVar.a(-1, "load ad timeout");
    }
}
