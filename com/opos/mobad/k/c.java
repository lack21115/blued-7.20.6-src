package com.opos.mobad.k;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.opos.mobad.k.f;
import com.opos.mobad.l.i;
import com.opos.mobad.model.b;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.e.a;
import java.util.concurrent.Callable;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/k/c.class */
public class c extends i implements com.opos.mobad.ad.e.b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f26284a;
    private final b b;

    /* renamed from: c  reason: collision with root package name */
    private final String f26285c;
    private com.opos.mobad.ad.e.f d;
    private int g;
    private a.C0707a h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.mobad.k.c$2  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/k/c$2.class */
    public class AnonymousClass2 implements b.a {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.model.b.a
        public void a(final int i, final a.C0707a c0707a) {
            if (c0707a == null || c0707a.f26482a.a() != 1) {
                c.this.c(new Callable<Boolean>() { // from class: com.opos.mobad.k.c.2.1
                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public Boolean call() throws Exception {
                        c.this.g = i;
                        if (c0707a != null) {
                            c.this.h = c0707a;
                            com.opos.cmn.an.f.a.b("InterSplash$StateAd", "fetchAd success");
                            final f.a a2 = f.a(c.this.d, c0707a);
                            if (a2 != null) {
                                c.this.a(new Runnable() { // from class: com.opos.mobad.k.c.2.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        c.this.a(a2);
                                    }
                                });
                            } else {
                                com.opos.cmn.an.f.a.c("InterSplash$StateAd", "splashVo data is null!");
                            }
                        }
                        return true;
                    }
                });
                return;
            }
            com.opos.mobad.service.a.a().a(c.this.f26285c, 3, c0707a.b.f(), c0707a.b.b(), c0707a.f26483c.aa(), c0707a.b.a(), c0707a.b.J());
            c.this.g = c0707a.f26482a.c();
            c.this.c(-1, com.opos.cmn.a.a(-1));
        }

        @Override // com.opos.mobad.model.b.a
        public void a(int i, String str, AdData adData) {
            com.opos.cmn.an.f.a.b("InterSplash$StateAd", "fetchAd failed,[code, msg] = " + i + "," + str);
            if (adData != null) {
                c.this.g = adData.c();
            }
            c.this.b(i, str);
        }
    }

    public c(Activity activity, String str, com.opos.mobad.cmn.a.d dVar, com.opos.mobad.ad.e.c cVar, com.opos.mobad.ad.e.f fVar) {
        super(cVar);
        Context a2 = com.opos.mobad.service.b.a(activity.getApplicationContext());
        this.f26284a = a2;
        this.f26285c = str;
        this.d = fVar;
        b bVar = new b(this.f26284a, str, new com.opos.mobad.cmn.a.a(a2, str, dVar), new d() { // from class: com.opos.mobad.k.c.1
            @Override // com.opos.mobad.cmn.a.a.a.b
            public void a(int i, String str2) {
                c.this.c(i, str2);
            }

            @Override // com.opos.mobad.ad.i.b
            public void a(long j) {
                c.this.i();
            }

            @Override // com.opos.mobad.ad.i.b
            public void a(String str2) {
                c.this.d(str2);
            }

            @Override // com.opos.mobad.cmn.a.a.a.b
            public void d() {
                c.this.i_();
            }
        });
        this.b = bVar;
        bVar.a(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f.a aVar) {
        if (this.b != null) {
            this.b.a(aVar, g.a(this.f26284a, aVar.b, null), e.a(aVar, this.f26284a, aVar.f26293a), b(aVar));
        }
    }

    private static com.opos.mobad.n.c b(f.a aVar) {
        final com.opos.mobad.ad.e.d b = aVar.b();
        if (b != null) {
            return new com.opos.mobad.n.c() { // from class: com.opos.mobad.k.c.3
                @Override // com.opos.mobad.n.c
                public View a() {
                    return com.opos.mobad.ad.e.d.this.a();
                }
            };
        }
        return null;
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void a(String str) {
        super.a(str, 3000);
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        com.opos.cmn.an.f.a.b("InterSplash$StateAd", "destroyAd");
        super.b();
        if (com.opos.mobad.cmn.a.b.f.e()) {
            this.b.c();
        }
        this.d = null;
    }

    @Override // com.opos.mobad.l.j
    public boolean b(String str) {
        return false;
    }

    @Override // com.opos.mobad.l.j
    public boolean b(String str, int i) {
        this.g = 0;
        com.opos.mobad.model.b.a(this.f26284a.getApplicationContext()).a(this.f26284a, this.f26285c, 3, str, i, new AnonymousClass2());
        return true;
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return this.g;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int f() {
        a.C0707a c0707a;
        return (!e() || (c0707a = this.h) == null) ? super.f() : c0707a.b.X();
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int g() {
        a.C0707a c0707a;
        return (!e() || (c0707a = this.h) == null) ? super.g() : c0707a.b.Y();
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
