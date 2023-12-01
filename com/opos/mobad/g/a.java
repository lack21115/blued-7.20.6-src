package com.opos.mobad.g;

import android.app.Activity;
import android.content.Context;
import com.igexin.sdk.PushConsts;
import com.opos.mobad.cmn.a.a.a;
import com.opos.mobad.cmn.a.b.f;
import com.opos.mobad.g.b;
import com.opos.mobad.l.d;
import com.opos.mobad.model.b;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.e.a;
import com.opos.mobad.q.a.h;
import java.util.concurrent.Callable;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/g/a.class */
public class a extends d {

    /* renamed from: a  reason: collision with root package name */
    private Context f12458a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private a.C0537a f12459c;
    private int d;
    private int g;
    private b h;

    public a(Activity activity, String str, com.opos.mobad.cmn.a.d dVar, h hVar, com.opos.mobad.ad.b.d dVar2) {
        super(dVar2);
        this.d = 0;
        this.g = 0;
        Context applicationContext = activity.getApplicationContext();
        this.f12458a = applicationContext;
        this.b = str;
        this.h = new b(applicationContext, str, dVar, hVar, new b.a() { // from class: com.opos.mobad.g.a.1
            @Override // com.opos.mobad.g.b.a
            public void a() {
                a.this.p();
            }

            @Override // com.opos.mobad.g.b.a
            public void b() {
                a.this.q();
            }

            @Override // com.opos.mobad.g.b.a
            public void c() {
                a.this.h();
            }
        });
    }

    @Override // com.opos.mobad.l.d, com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        com.opos.cmn.an.f.a.b("InterInterstitialVideoAd", "destroyAd");
        if (f.e()) {
            b bVar = this.h;
            if (bVar != null) {
                bVar.a();
            }
            super.b();
        }
    }

    @Override // com.opos.mobad.l.k
    public boolean b(Activity activity) {
        a.C0537a c0537a = this.f12459c;
        if (c0537a == null) {
            com.opos.cmn.an.f.a.b("InterInterstitialVideoAd", "show but data null");
        } else if (c0537a == null || c0537a.f12794a.a() != 1) {
            return this.h.a(this.f12459c, this.g, new a.b() { // from class: com.opos.mobad.g.a.2
                @Override // com.opos.mobad.cmn.a.a.a.b
                public void a(int i, String str) {
                    a.this.c(i, str);
                }

                @Override // com.opos.mobad.cmn.a.a.a.b
                public void d() {
                    a.this.i_();
                }
            });
        } else {
            com.opos.mobad.service.a.a().a(this.b, 2, this.f12459c.b.f(), this.f12459c.b.b(), this.f12459c.f12795c.aa(), this.f12459c.b.a(), this.f12459c.b.J());
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
        this.d = 0;
        this.g = 0;
        com.opos.mobad.model.b.a(this.f12458a.getApplicationContext()).a(this.f12458a, this.b, 2, str, i, new b.a() { // from class: com.opos.mobad.g.a.3
            @Override // com.opos.mobad.model.b.a
            public void a(final int i2, final a.C0537a c0537a) {
                if (c0537a.f12795c.d() == 12 || c0537a.f12795c.d() == 14) {
                    a.this.c(new Callable<Boolean>() { // from class: com.opos.mobad.g.a.3.1
                        @Override // java.util.concurrent.Callable
                        /* renamed from: a */
                        public Boolean call() throws Exception {
                            com.opos.cmn.an.f.a.b("InterInterstitialVideoAd", " call load succ");
                            a.this.f12459c = c0537a;
                            a.this.d = i2;
                            return true;
                        }
                    });
                } else {
                    a.this.b((int) PushConsts.SET_TAG_RESULT, "posId or posType error");
                }
            }

            @Override // com.opos.mobad.model.b.a
            public void a(int i2, String str2, AdData adData) {
                if (adData != null) {
                    a.this.d = adData.c();
                }
                a.this.b(i2, str2);
            }
        });
        return true;
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return this.d;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void c(int i) {
        this.g = i;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int f() {
        a.C0537a c0537a;
        return (!e() || (c0537a = this.f12459c) == null) ? super.f() : c0537a.b.X();
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int g() {
        a.C0537a c0537a;
        return (!e() || (c0537a = this.f12459c) == null) ? super.g() : c0537a.b.Y();
    }
}
