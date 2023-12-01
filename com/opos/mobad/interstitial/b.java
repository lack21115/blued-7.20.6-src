package com.opos.mobad.interstitial;

import android.app.Activity;
import android.content.Context;
import com.opos.mobad.cmn.a.a;
import com.opos.mobad.cmn.a.b.f;
import com.opos.mobad.model.b;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.e.a;
import com.opos.mobad.q.a.h;
import java.util.concurrent.Callable;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/interstitial/b.class */
public class b extends com.opos.mobad.l.c implements com.opos.mobad.ad.b.a {

    /* renamed from: a  reason: collision with root package name */
    com.opos.mobad.q.a.b.c f12558a;
    private a b;

    /* renamed from: c  reason: collision with root package name */
    private Context f12559c;
    private String d;
    private a.C0537a g;
    private int h;
    private int i;
    private a.b j;
    private com.opos.mobad.cmn.a.d k;
    private com.opos.mobad.cmn.a.a l;
    private h m;
    private com.opos.mobad.q.a.b.d n;

    public b(Activity activity, String str, com.opos.mobad.cmn.a.d dVar, com.opos.mobad.ad.b.b bVar, h hVar) {
        super(bVar);
        this.f12558a = new com.opos.mobad.q.a.b.c() { // from class: com.opos.mobad.interstitial.b.2
            @Override // com.opos.mobad.cmn.a.a.a.b
            public void a(int i, String str2) {
                a aVar = b.this.b;
                if (aVar != null) {
                    aVar.a();
                }
                b.this.c(i, str2);
                b.this.i_();
            }

            @Override // com.opos.mobad.ad.i.b
            public void a(long j) {
                b.this.p();
            }

            @Override // com.opos.mobad.ad.i.b
            public void a(String str2) {
                b.this.q();
            }

            @Override // com.opos.mobad.cmn.a.a.a.b
            public void d() {
                a aVar = b.this.b;
                if (aVar != null) {
                    aVar.a();
                }
                b.this.i_();
            }
        };
        this.f12559c = activity.getApplicationContext();
        this.d = str;
        this.k = dVar;
        this.l = new com.opos.mobad.cmn.a.a(activity, str, dVar);
        a.b b = f.b(activity);
        this.j = b;
        this.l.a(b);
        this.m = hVar;
        this.n = new InterstitialCreator();
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        synchronized (this) {
            com.opos.cmn.an.f.a.b("InterInterstitialAd", "destroyAd");
            if (f.e()) {
                this.j.a();
                if (this.b != null) {
                    this.b.a();
                }
                super.b();
            }
        }
    }

    @Override // com.opos.mobad.l.k
    public boolean b(Activity activity) {
        if (activity == null) {
            return false;
        }
        a.C0537a c0537a = this.g;
        if (c0537a == null) {
            com.opos.cmn.an.f.a.b("InterInterstitialAd", "show but data null");
        } else if (c0537a == null || c0537a.f12794a.a() != 1) {
            a a2 = c.a(activity, this.d, this.f12558a, this.m, this.l, this.n, this.g, this.i);
            this.b = a2;
            return a2.a(activity);
        } else {
            com.opos.mobad.service.a.a().a(this.d, 2, this.g.b.f(), this.g.b.b(), this.g.f12795c.aa(), this.g.b.a(), this.g.b.J());
        }
        c(-1, com.opos.cmn.a.a(-1));
        return false;
    }

    @Override // com.opos.mobad.l.j
    public boolean b(String str) {
        return false;
    }

    @Override // com.opos.mobad.l.j
    public boolean b(String str, int i) {
        com.opos.cmn.an.f.a.b("InterInterstitialAd", "doLoad");
        this.h = 0;
        this.i = 0;
        com.opos.mobad.model.b.a(this.f12559c.getApplicationContext()).a(this.f12559c, this.d, 2, str, i, new b.a() { // from class: com.opos.mobad.interstitial.b.1
            @Override // com.opos.mobad.model.b.a
            public void a(final int i2, final a.C0537a c0537a) {
                b.this.c(new Callable<Boolean>() { // from class: com.opos.mobad.interstitial.b.1.1
                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public Boolean call() throws Exception {
                        com.opos.cmn.an.f.a.b("InterInterstitialAd", " call load succ");
                        b.this.h = i2;
                        b.this.g = c0537a;
                        return true;
                    }
                });
            }

            @Override // com.opos.mobad.model.b.a
            public void a(int i2, String str2, AdData adData) {
                b.this.b(i2, str2);
                if (adData != null) {
                    b.this.h = adData.c();
                }
            }
        });
        return true;
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return this.h;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void c(int i) {
        this.i = i;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int f() {
        a.C0537a c0537a;
        return (!e() || (c0537a = this.g) == null) ? super.f() : c0537a.b.X();
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int g() {
        a.C0537a c0537a;
        return (!e() || (c0537a = this.g) == null) ? super.g() : c0537a.b.Y();
    }
}
