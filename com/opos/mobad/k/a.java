package com.opos.mobad.k;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.opos.mobad.k.f;
import com.opos.mobad.model.b;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.e.a;
import java.util.concurrent.Callable;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/k/a.class */
public class a extends com.opos.mobad.l.b implements com.opos.mobad.ad.e.a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f12583a;
    private final b b;

    /* renamed from: c  reason: collision with root package name */
    private final String f12584c;
    private final com.opos.mobad.ad.e.f d;
    private int g;
    private a.C0537a h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.mobad.k.a$2  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/k/a$2.class */
    public class AnonymousClass2 implements b.a {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.model.b.a
        public void a(final int i, final a.C0537a c0537a) {
            if (c0537a == null || c0537a.f12794a.a() != 1) {
                a.this.c(new Callable<Boolean>() { // from class: com.opos.mobad.k.a.2.1
                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public Boolean call() throws Exception {
                        a.this.g = i;
                        if (c0537a != null) {
                            a.this.h = c0537a;
                            com.opos.cmn.an.f.a.b("InterHotSplash$StateAd", "fetchAd success");
                            final f.a a2 = f.a(a.this.d, c0537a);
                            if (a2 != null) {
                                a.this.a(new Runnable() { // from class: com.opos.mobad.k.a.2.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        a.this.a(a2);
                                    }
                                });
                            } else {
                                com.opos.cmn.an.f.a.c("InterHotSplash$StateAd", "splashVo data is null!");
                            }
                        }
                        return true;
                    }
                });
                return;
            }
            com.opos.mobad.service.a.a().a(a.this.f12584c, 6, c0537a.b.f(), c0537a.b.b(), c0537a.f12795c.aa(), c0537a.b.a(), c0537a.b.J());
            a.this.g = c0537a.f12794a.c();
            a.this.c(-1, com.opos.cmn.a.a(-1));
        }

        @Override // com.opos.mobad.model.b.a
        public void a(int i, String str, AdData adData) {
            com.opos.cmn.an.f.a.b("InterHotSplash$StateAd", "fetchAd failed,[code, msg] = " + i + "," + str);
            if (adData != null) {
                a.this.g = adData.c();
            }
            a.this.b(i, str);
        }
    }

    public a(Context context, String str, com.opos.mobad.cmn.a.d dVar, com.opos.mobad.ad.e.c cVar, com.opos.mobad.ad.e.f fVar) {
        super(cVar);
        Context a2 = com.opos.mobad.service.b.a(context.getApplicationContext());
        this.f12583a = a2;
        this.f12584c = str;
        this.d = fVar;
        this.b = new b(this.f12583a, str, new com.opos.mobad.cmn.a.a(a2, str, dVar), new d() { // from class: com.opos.mobad.k.a.1
            @Override // com.opos.mobad.cmn.a.a.a.b
            public void a(int i, String str2) {
                a.this.c(i, str2);
            }

            @Override // com.opos.mobad.ad.i.b
            public void a(long j) {
                a.this.i();
            }

            @Override // com.opos.mobad.ad.i.b
            public void a(String str2) {
                a.this.d(str2);
            }

            @Override // com.opos.mobad.cmn.a.a.a.b
            public void d() {
                a.this.i_();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f.a aVar) {
        if (this.b != null) {
            this.b.a(aVar, g.a(this.f12583a, aVar.b, null), e.a(aVar, this.f12583a, aVar.f12605a), b(aVar));
        }
    }

    private static com.opos.mobad.n.c b(f.a aVar) {
        final com.opos.mobad.ad.e.d b = aVar.b();
        if (b != null) {
            return new com.opos.mobad.n.c() { // from class: com.opos.mobad.k.a.3
                @Override // com.opos.mobad.n.c
                public View a() {
                    return com.opos.mobad.ad.e.d.this.a();
                }
            };
        }
        return null;
    }

    @Override // com.opos.mobad.ad.e.a
    public void a(Activity activity) {
        this.b.a(activity);
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void a(String str) {
        super.a(str, 3000);
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        com.opos.cmn.an.f.a.b("InterHotSplash$StateAd", "destroyAd");
        super.b();
        b bVar = this.b;
        if (bVar != null) {
            bVar.c();
        }
    }

    @Override // com.opos.mobad.l.j
    public boolean b(String str) {
        return false;
    }

    @Override // com.opos.mobad.l.j
    public boolean b(String str, int i) {
        this.g = 0;
        com.opos.mobad.model.b.a(this.f12583a.getApplicationContext()).a(this.f12583a, this.f12584c, 6, str, i, new AnonymousClass2());
        return true;
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return this.g;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void c(int i) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.d(i);
        }
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int f() {
        a.C0537a c0537a;
        return (!e() || (c0537a = this.h) == null) ? super.f() : c0537a.b.X();
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int g() {
        a.C0537a c0537a;
        return (!e() || (c0537a = this.h) == null) ? super.g() : c0537a.b.Y();
    }

    @Override // com.opos.mobad.ad.e.b
    public View h() {
        b bVar;
        if (!com.opos.mobad.cmn.a.b.f.e() || 5 == d() || (bVar = this.b) == null) {
            return null;
        }
        return bVar.a();
    }
}
