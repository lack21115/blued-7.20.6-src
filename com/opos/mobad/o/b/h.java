package com.opos.mobad.o.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.anythink.expressad.video.module.a.a.m;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/b/h.class */
public abstract class h extends a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f27052a;

    public h(Context context, d dVar, FrameLayout frameLayout, boolean z) {
        super(context, dVar, frameLayout, z);
        this.f27052a = false;
    }

    private void a(Context context, final String str) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.o.b.h.3
            @Override // java.lang.Runnable
            public void run() {
                String a2 = com.opos.cmn.d.d.a(h.this.b, str);
                boolean isEmpty = TextUtils.isEmpty(a2);
                if (isEmpty) {
                    a2 = str;
                }
                final Bitmap a3 = com.opos.mobad.r.a.c.a(a2, isEmpty);
                if (a3 == null) {
                    return;
                }
                com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.o.b.h.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.l.setImageBitmap(a3);
                    }
                });
            }
        });
    }

    @Override // com.opos.mobad.o.b.a
    protected void O() {
        com.opos.cmn.an.f.a.b("MediaCreative", "resetDisappearTime");
        this.G.removeMessages(1);
        if ((this.x || this.v) && !this.w) {
            this.G.sendMessageDelayed(this.G.obtainMessage(1), m.ag);
        }
    }

    @Override // com.opos.mobad.o.b.a
    protected void P() {
        com.opos.cmn.an.f.a.b("MediaCreative", "ChangeUIOnTouch");
        int c2 = k.a().c(this.A);
        if (c2 == 2) {
            com.opos.cmn.an.f.a.b("MediaCreative", "ChangeUIOnTouch isShowPauseCover" + this.x);
            if (this.x) {
                G();
                A();
                return;
            }
            F();
            z();
        } else if (c2 != 3) {
        } else {
            com.opos.cmn.an.f.a.b("MediaCreative", "ChangeUIOnTouch isShowContinueCover" + this.w);
            if (this.w) {
                C();
                A();
                return;
            }
            B();
            z();
        }
    }

    public void Q() {
        com.opos.cmn.an.f.a.b("MediaCreative", "pauseVideo");
        k.a().b(this.A);
    }

    protected long R() {
        if (k.a() != null) {
            return k.a().d(this.A);
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void S() {
        k.a().c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void T() {
        this.G.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U() {
        if (this.u != null) {
            this.u.a(k.a().e(this.A));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V() {
        if (this.u != null) {
            this.u.a();
        }
    }

    public void W() {
        this.f27052a = true;
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.o.b.h.2
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.l != null) {
                    h.this.d.removeView(h.this.l);
                }
                if (h.this.m == null || h.this.m.isRecycled()) {
                    return;
                }
                h.this.m.recycle();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void X() {
        com.opos.cmn.an.f.a.b("MediaCreative", "ShowInitCoverStatus");
        r();
        D();
        y();
        u();
        K();
        I();
        w();
        u();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Y() {
        com.opos.cmn.an.f.a.b("MediaCreative", "ShowInitBufferCoverStatus");
        r();
        L();
        C();
        G();
        K();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Z() {
        com.opos.cmn.an.f.a.b("MediaCreative", "ShowInitWifiCoverStatus");
        r();
        v();
        C();
        G();
        K();
        u();
    }

    @Override // com.opos.mobad.c.c.b
    public void a(final int i, final String str) {
        com.opos.cmn.an.f.a.b("MediaCreative", "onError,url:" + this.A);
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.o.b.h.6
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f27052a) {
                    return;
                }
                h.this.ah();
                if (h.this.u != null) {
                    h.this.u.a(i, str);
                }
            }
        });
    }

    protected void a(long j, long j2) {
        if (this.e == null || k.a().c(this.A) != 2) {
            return;
        }
        com.opos.cmn.an.f.a.b("MediaCreative", "currentPosition=" + j + ",totalPosition=" + j2);
        if (j < 0 || j2 <= 0) {
            this.f.setProgress(0);
            return;
        }
        this.g.setText(com.opos.mobad.cmn.a.b.e.a(500 + j));
        int i = (int) ((j * 100) / j2);
        com.opos.cmn.an.f.a.b("MediaCreative", "currentProgress=" + i + ",mLastProgress=" + this.B);
        if (i - this.B >= 1) {
            this.f.setProgress(i);
        }
        this.B = i;
    }

    protected abstract void a(String str);

    @Override // com.opos.mobad.o.b.f
    public void a(final String str, final long j) {
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.o.b.h.9
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f27052a) {
                    return;
                }
                if (!TextUtils.isEmpty(h.this.A) && h.this.A.equals(str)) {
                    com.opos.cmn.an.f.a.b("MediaCreative", "mCountDown:" + k.a().e(h.this.A));
                    if (h.this.C && h.this.e != null) {
                        h.this.a(j, h.this.R());
                    }
                    if (h.this.u != null) {
                        h.this.u.c(h.this.n, h.this.f27042c, j);
                    }
                }
                h.this.s();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(AdItemData adItemData) {
        MaterialData materialData;
        if (this.l != null) {
            if (this.l.getDrawable() != null) {
                com.opos.cmn.an.f.a.b("MediaCreative", "createAndLoadCoverImg cover is not null ");
                return true;
            } else if (adItemData == null || (materialData = adItemData.i().get(0)) == null) {
                return false;
            } else {
                List<MaterialFileData> f = materialData.f();
                if (f != null && f.size() > 0 && f.get(0) != null) {
                    String a2 = f.get(0).a();
                    if (!TextUtils.isEmpty(a2)) {
                        if (com.opos.cmn.an.d.b.a.a(a2)) {
                            a(a2);
                            return true;
                        }
                        com.opos.cmn.an.f.a.b("MediaCreative", "file not exit" + a2);
                    }
                }
                List<MaterialFileData> F = materialData.F();
                if (F == null || F.size() <= 0) {
                    return false;
                }
                String a3 = F.get(0).a();
                if (TextUtils.isEmpty(a3)) {
                    com.opos.cmn.an.f.a.b("MediaCreative", "videoUrl is empty");
                    return false;
                }
                a(this.b, a3);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aa() {
        com.opos.cmn.an.f.a.b("MediaCreative", "ShowInitClickBufferStatus");
        L();
        w();
        u();
        G();
        C();
    }

    protected void ab() {
        L();
        w();
        C();
        G();
        u();
    }

    protected void ac() {
        M();
    }

    protected void ad() {
        p();
        M();
        s();
        E();
        w();
        K();
        u();
        G();
    }

    protected void ae() {
        I();
        M();
        K();
        u();
        B();
    }

    protected void af() {
        p();
        M();
        s();
        K();
        E();
        w();
        u();
        F();
        O();
    }

    protected void ag() {
        M();
        G();
        C();
        q();
        r();
        J();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ah() {
        M();
        G();
        C();
        w();
        t();
    }

    @Override // com.opos.mobad.c.c.b
    public void c() {
        com.opos.cmn.an.f.a.b("MediaCreative", "onPrepare,url:" + this.A);
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.o.b.h.1
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f27052a || h.this.e == null) {
                    return;
                }
                h.this.B = 0;
                h.this.f.setProgress(0);
            }
        });
    }

    @Override // com.opos.mobad.c.c.b
    public void d() {
        com.opos.cmn.an.f.a.b("MediaCreative", "onStart,url:" + this.A);
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.o.b.h.4
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f27052a) {
                    return;
                }
                h hVar = h.this;
                hVar.a(hVar.f27042c);
                if (h.this.e != null && h.this.h != null) {
                    h.this.h.setText(com.opos.mobad.cmn.a.b.e.a(k.a().d(h.this.A)));
                }
                h.this.ad();
                if (h.this.u != null) {
                    h.this.u.a(h.this.n, h.this.f27042c);
                }
            }
        });
    }

    @Override // com.opos.mobad.c.c.b
    public void e() {
        com.opos.cmn.an.f.a.b("MediaCreative", "onComplete,url:" + this.A);
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.o.b.h.5
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f27052a) {
                    return;
                }
                if (h.this.e != null) {
                    h.this.f.setProgress(100);
                }
                h.this.ag();
                if (h.this.u != null) {
                    h.this.u.b(h.this.n, h.this.f27042c);
                }
            }
        });
    }

    @Override // com.opos.mobad.c.c.b
    public void f() {
        com.opos.cmn.an.f.a.b("MediaCreative", "onResume,url:" + this.A);
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.o.b.h.7
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f27052a) {
                    return;
                }
                if (h.this.e != null && h.this.h != null && h.this.g != null) {
                    com.opos.cmn.an.f.a.b("MediaCreative", "onResume:" + com.opos.mobad.cmn.a.b.e.a(k.a().d(h.this.A)));
                    long d = k.a().d(h.this.A);
                    h.this.h.setText(com.opos.mobad.cmn.a.b.e.a(d));
                    long e = k.a().e(h.this.A);
                    h.this.g.setText(com.opos.mobad.cmn.a.b.e.a(e));
                    if (d != 0) {
                        int i = (int) ((e * 100) / d);
                        h.this.f.setProgress(i);
                        h.this.B = i;
                    }
                }
                h.this.af();
                if (h.this.u != null) {
                    h.this.u.b(h.this.n, h.this.f27042c, k.a().e(h.this.A));
                }
            }
        });
    }

    @Override // com.opos.mobad.c.c.b
    public void g() {
        com.opos.cmn.an.f.a.b("MediaCreative", "onPause,url:" + this.A);
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.o.b.h.8
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f27052a) {
                    return;
                }
                h.this.ae();
                if (h.this.u != null) {
                    h.this.u.a(h.this.n, h.this.f27042c, k.a().e(h.this.A));
                }
            }
        });
    }

    @Override // com.opos.mobad.c.c.b
    public void h() {
        com.opos.cmn.an.f.a.b("MediaCreative", "onBufferingStart");
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.o.b.h.10
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f27052a) {
                    return;
                }
                h.this.ab();
            }
        });
    }

    @Override // com.opos.mobad.c.c.b
    public void i() {
        com.opos.cmn.an.f.a.b("MediaCreative", "onBufferingEnd");
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.o.b.h.11
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f27052a) {
                    return;
                }
                h.this.ac();
            }
        });
    }

    @Override // com.opos.mobad.c.c.b
    public void j() {
    }

    @Override // com.opos.mobad.o.b.a
    protected void r() {
        if (this.f27042c == null || this.l == null || this.l.getDrawable() != null || a(this.f27042c)) {
            super.r();
        } else {
            s();
        }
    }
}
