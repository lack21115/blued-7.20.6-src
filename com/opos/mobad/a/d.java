package com.opos.mobad.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.opos.cmn.i.j;
import com.opos.mobad.cmn.a.a;
import com.opos.mobad.cmn.a.b.f;
import com.opos.mobad.cmn.service.pkginstall.b;
import com.opos.mobad.model.b;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.e.a;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/a/d.class */
public class d extends com.opos.mobad.l.a implements com.opos.mobad.ad.a.a {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, Boolean> f11924a = new ConcurrentHashMap();
    private Activity b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f11925c;
    private com.opos.mobad.a.a.b d;
    private c g;
    private boolean h;
    private String i;
    private int j;
    private a.C0537a k;
    private boolean l;
    private Context m;
    private a.b n;
    private b.InterfaceC0517b o;
    private a p;

    public d(Activity activity, String str, boolean z, com.opos.mobad.cmn.a.d dVar, com.opos.mobad.ad.a.b bVar, com.opos.mobad.cmn.b.c cVar) {
        super(bVar);
        this.f11925c = new Handler() { // from class: com.opos.mobad.a.d.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 0) {
                    return;
                }
                com.opos.cmn.an.f.a.b("InterBannerAd", "adHandler WHAT_REFRESH_AD:");
                d dVar2 = d.this;
                if (dVar2.a(dVar2.b) || !com.opos.cmn.an.h.a.a.d(d.this.b) || !f.a(d.this.b) || (2 == d.this.d() && !d.this.m())) {
                    d dVar3 = d.this;
                    if (dVar3.a(dVar3.b)) {
                        return;
                    }
                    d.this.a(-1, (AdData) null);
                } else if (!d.this.r() && !j.a(d.this.b, d.this.h())) {
                    d.this.a(com.opos.cmn.i.f.a());
                } else {
                    com.opos.cmn.an.f.a.b("InterBannerAd", "isBannerCovered() || isBannerCoveredOnShapedScreen()=true");
                    d.this.q();
                    d.this.c(11004, "you should't play ad on the top in the shaped screen mobile");
                }
            }
        };
        this.j = 0;
        this.l = false;
        this.o = new b.InterfaceC0517b() { // from class: com.opos.mobad.a.d.4
            @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0517b
            public void a(AdItemData adItemData, String str2) {
                com.opos.cmn.an.f.a.b("InterBannerAd", "notifyInstallCompletedEvent:" + str2);
                if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(d.this.k.f12795c.k()) || !d.this.k.f12795c.k().equals(str2)) {
                    return;
                }
                d.this.g.d();
            }

            @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0517b
            public void b(AdItemData adItemData, String str2) {
            }

            @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0517b
            public void c(AdItemData adItemData, String str2) {
            }
        };
        this.p = new a() { // from class: com.opos.mobad.a.d.5
            @Override // com.opos.mobad.cmn.a.a.a.b
            public void a(int i, String str2) {
                d.this.c(i, str2);
            }

            @Override // com.opos.mobad.ad.i.b
            public void a(long j) {
                d.this.i();
            }

            @Override // com.opos.mobad.ad.i.b
            public void a(String str2) {
                d.this.g_();
            }

            @Override // com.opos.mobad.a.a
            public void a(boolean z2) {
                com.opos.cmn.an.f.a.b("IRewardListener", "onVisibilityChange = " + z2);
                d.this.l = z2;
                d.this.k();
            }

            @Override // com.opos.mobad.cmn.a.a.a.b
            public void d() {
                d.this.d.d();
                d.this.i_();
                d.this.p();
            }
        };
        this.i = str;
        this.b = activity;
        this.m = activity.getApplicationContext();
        this.h = z;
        com.opos.mobad.cmn.a.a aVar = new com.opos.mobad.cmn.a.a(activity, this.i, dVar);
        this.d = new com.opos.mobad.a.a.b(this.m);
        this.g = new c(this.b, str, aVar, new com.opos.mobad.o.a.a(this.m, null), new com.opos.mobad.cmn.b.e(cVar), this.o, this.p, this.d);
        a.b b = f.b(activity);
        this.n = b;
        aVar.a(b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AdData adData) {
        synchronized (this) {
            com.opos.cmn.an.f.a.b("InterBannerAd", "setNextRefreshAdEvent code=", Integer.valueOf(i), "adData=", adData);
            int i2 = 30;
            if (10000 == i) {
                i2 = 30;
                if (adData != null) {
                    i2 = b(adData);
                }
            }
            com.opos.cmn.an.f.a.b("InterBannerAd", "refreshAdTime=" + i2);
            if (!this.f11925c.hasMessages(0)) {
                this.f11925c.sendEmptyMessageDelayed(0, i2 * 1000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdData adData) {
        if (!this.h) {
            com.opos.cmn.an.f.a.b("InterBannerAd", "do not carousel");
            return;
        }
        int i = 30;
        if (adData != null) {
            i = b(adData);
        }
        com.opos.cmn.an.f.a.b("InterBannerAd", "refreshAdTime=" + i);
        if (this.f11925c.hasMessages(0)) {
            return;
        }
        this.f11925c.sendEmptyMessageDelayed(0, i * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a.C0537a c0537a, final com.opos.mobad.n.a aVar) {
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.a.d.2
            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.an.f.a.b("InterBannerAd", "show ad view:", d.this.k);
                if (c0537a != null) {
                    d.this.g.a(c0537a, aVar);
                }
                d.this.k();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(AdData adData) {
        if (adData == null || adData.f() == null || adData.f().size() <= 0 || adData.f().get(0) == null) {
            return 30;
        }
        return adData.f().get(0).m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.l) {
            a.C0537a c0537a = this.k;
            a(c0537a != null ? c0537a.f12794a : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m() {
        View h = h();
        return h != null && h.isShown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (5 == d() || !this.f11925c.hasMessages(0)) {
            return;
        }
        this.f11925c.removeMessages(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        try {
            com.opos.cmn.an.f.a.b("InterBannerAd", "setBannerCovered posId=" + this.i);
            f11924a.put(this.i, true);
            if (this.f11925c.hasMessages(0)) {
                this.f11925c.removeMessages(0);
            }
            this.g.c();
            com.opos.cmn.an.f.a.b("InterBannerAd", "mIBannerPresenter.destroyAd()");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("InterBannerAd", "", (Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r() {
        boolean z;
        try {
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("InterBannerAd", "", (Throwable) e);
        }
        if (f11924a.containsKey(this.i)) {
            z = f11924a.get(this.i).booleanValue();
            com.opos.cmn.an.f.a.b("InterBannerAd", "isBannerCovered=" + z);
            return z;
        }
        z = false;
        com.opos.cmn.an.f.a.b("InterBannerAd", "isBannerCovered=" + z);
        return z;
    }

    @Override // com.opos.mobad.ad.a.a
    public void a(int i, int i2) {
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void a(String str) {
        a(str, 30000);
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void a(String str, int i) {
        int i2;
        if (!f.e()) {
            i2 = 11005;
        } else if (!r() && !j.a(this.m, h())) {
            super.a(str, i);
            return;
        } else {
            com.opos.cmn.an.f.a.b("InterBannerAd", "isBannerCovered() || isBannerCoveredOnShapedScreen()=true");
            q();
            i2 = 11004;
        }
        c(i2, com.opos.mobad.ad.a.a(i2));
    }

    protected boolean a(Activity activity) {
        boolean z = activity == null || activity.isFinishing();
        com.opos.cmn.an.f.a.b("InterBannerAd", "isActivityFinished=" + z);
        return z;
    }

    @Override // com.opos.mobad.l.a, com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        synchronized (this) {
            com.opos.cmn.an.f.a.b("InterBannerAd", "destroyAd");
            if (this.f11925c.hasMessages(0)) {
                this.f11925c.removeMessages(0);
            }
            this.g.c();
            this.b = null;
            this.n.a();
            super.b();
        }
    }

    @Override // com.opos.mobad.l.j
    public boolean b(String str) {
        return false;
    }

    @Override // com.opos.mobad.l.j
    public boolean b(String str, int i) {
        this.j = 0;
        com.opos.mobad.model.b.a(this.m.getApplicationContext()).a(this.m, this.i, 1, str, i, new b.a() { // from class: com.opos.mobad.a.d.3
            @Override // com.opos.mobad.model.b.a
            public void a(final int i2, final a.C0537a c0537a) {
                if (c0537a != null && c0537a.f12794a.a() == 1) {
                    com.opos.mobad.service.a.a().a(d.this.i, 1, c0537a.b.f(), c0537a.b.b(), c0537a.f12795c.aa(), c0537a.b.a(), c0537a.b.J());
                    d.this.j = c0537a.f12794a.c();
                    d.this.c(-1, com.opos.cmn.a.a(-1));
                    return;
                }
                d.this.c(new Callable<Boolean>() { // from class: com.opos.mobad.a.d.3.1
                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public Boolean call() throws Exception {
                        d.this.j = i2;
                        d.this.k = c0537a;
                        com.opos.mobad.service.f.a().a(d.this.i, d.this.b(d.this.k.f12794a));
                        return true;
                    }
                });
                d dVar = d.this;
                if (dVar.a(dVar.b)) {
                    return;
                }
                d dVar2 = d.this;
                dVar2.a(dVar2.k, e.a(d.this.m, c0537a));
            }

            @Override // com.opos.mobad.model.b.a
            public void a(int i2, String str2, AdData adData) {
                d.this.b(i2, str2);
                if (adData != null) {
                    d.this.j = adData.c();
                }
                d.this.a(adData);
            }
        });
        return true;
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return this.j;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void c(int i) {
        this.g.d(i);
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int f() {
        a.C0537a c0537a;
        return (!e() || (c0537a = this.k) == null) ? super.f() : c0537a.b.X();
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int g() {
        a.C0537a c0537a;
        return (!e() || (c0537a = this.k) == null) ? super.g() : c0537a.b.Y();
    }

    @Override // com.opos.mobad.ad.a.a
    public View h() {
        com.opos.cmn.an.f.a.b("InterBannerAd", "getAdView");
        if (!f.e() || 5 == d()) {
            return null;
        }
        return this.g.a();
    }
}
