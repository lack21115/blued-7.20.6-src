package com.opos.mobad.model.d;

import android.content.Context;
import com.opos.mobad.model.d.m;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.AdItemData;
import java.util.concurrent.CountDownLatch;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/d/s.class */
public class s extends b {

    /* renamed from: a  reason: collision with root package name */
    private e f26446a;
    private t b;

    /* renamed from: c  reason: collision with root package name */
    private m f26447c;
    private com.opos.mobad.model.b.c d;
    private int e;
    private int f;
    private AdData g;
    private AdData h;
    private CountDownLatch i;
    private CountDownLatch j;
    private com.opos.cmn.i.m k;
    private boolean l;
    private k m;
    private Context n;

    public s(Context context, String str, String str2, com.opos.mobad.model.b.c cVar, boolean z, com.opos.mobad.model.a.b bVar, int i, int i2, m.a aVar) {
        super(aVar);
        this.i = new CountDownLatch(1);
        this.j = new CountDownLatch(2);
        this.l = false;
        this.n = context;
        this.d = cVar;
        this.m = new k(str, str2);
        this.e = i;
        this.f = i2;
        this.k = new com.opos.cmn.i.m(com.opos.mobad.service.c.a(), new Runnable() { // from class: com.opos.mobad.model.d.s.1
            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.an.f.a.b("mLoader", "total timeout");
                s.this.l = true;
                s.this.l();
            }
        });
        this.f26446a = new e(context, str, str2, cVar, z, new m.a() { // from class: com.opos.mobad.model.d.s.2
            @Override // com.opos.mobad.model.d.m.a
            public void a() {
                com.opos.cmn.an.f.a.b("mLoader", "cache loaded");
                s.this.j.countDown();
                s.this.j.countDown();
            }

            @Override // com.opos.mobad.model.d.m.a
            public void a(AdData adData) {
                com.opos.cmn.an.f.a.b("mLoader", "cache load fail");
                s.this.h = adData;
                s.this.j.countDown();
            }

            @Override // com.opos.mobad.model.d.m.a
            public void b(AdData adData) {
                if (s.this.f26447c == s.this.f26446a) {
                    s.this.k.a();
                    s.this.c(adData);
                }
            }

            @Override // com.opos.mobad.model.d.m.a
            public void c(AdData adData) {
                if (s.this.f26447c == s.this.f26446a) {
                    s.this.k.a();
                    s.this.b(adData);
                }
            }
        });
        this.b = new t(context, str, str2, cVar, z, new m.a() { // from class: com.opos.mobad.model.d.s.3
            @Override // com.opos.mobad.model.d.m.a
            public void a() {
                com.opos.cmn.an.f.a.b("mLoader", "sync loaded");
                s.this.i.countDown();
                s.this.j.countDown();
                s.this.j.countDown();
            }

            @Override // com.opos.mobad.model.d.m.a
            public void a(AdData adData) {
                com.opos.cmn.an.f.a.b("mLoader", "sync load fail");
                s.this.g = adData;
                s.this.i.countDown();
                s.this.j.countDown();
            }

            @Override // com.opos.mobad.model.d.m.a
            public void b(AdData adData) {
                if (s.this.f26447c == s.this.b) {
                    s.this.k.a();
                    s.this.c(adData);
                }
            }

            @Override // com.opos.mobad.model.d.m.a
            public void c(AdData adData) {
                k kVar;
                int i3;
                if (s.this.f26447c == s.this.b) {
                    s.this.k.a();
                    if (s.this.l || !s.this.m()) {
                        if (s.this.l) {
                            kVar = s.this.m;
                            i3 = 4;
                        } else {
                            kVar = s.this.m;
                            i3 = 3;
                        }
                        kVar.d(i3);
                        s.this.b(adData);
                    }
                }
            }
        }, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.opos.cmn.an.f.a.b("mLoader", "select sync");
        if (!h()) {
            com.opos.cmn.an.f.a.c("mLoader", "select fail");
            return;
        }
        this.f26447c = this.b;
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        com.opos.cmn.an.f.a.b("mLoader", "select cache");
        if (!h()) {
            com.opos.cmn.an.f.a.c("mLoader", "select fail");
            return;
        }
        this.f26447c = this.f26446a;
        g();
    }

    private void k() {
        e eVar = this.f26446a;
        this.f26447c = eVar;
        eVar.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        k kVar;
        int i;
        if (j() == 5) {
            i = 3;
            if (this.f26446a.j() == 3 && this.f26446a.d()) {
                com.opos.cmn.an.f.a.b("mLoader", "timeout to use cache");
                k();
                kVar = this.m;
                i = 2;
            } else {
                kVar = this.m;
            }
        } else {
            kVar = this.m;
            i = 4;
        }
        kVar.c(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m() {
        if (j() == 5 && this.f26446a.j() == 3) {
            com.opos.cmn.an.f.a.b("mLoader", "change to cache");
            this.m.d(2);
            k();
            return true;
        }
        return false;
    }

    @Override // com.opos.mobad.model.d.b
    protected void a() {
        m mVar = this.f26447c;
        if (mVar != null) {
            mVar.g();
        } else {
            com.opos.cmn.an.f.a.b("mLoader", "load with target null");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.mobad.model.d.b
    public void a(AdData adData) {
        com.opos.cmn.an.f.a.b("mLoader", "onLoadFail");
        AdData adData2 = adData;
        if (adData == null) {
            adData2 = new AdData(-1, "unknown error.");
        }
        this.m.a(this.n, adData2.d(), adData2.e(), this.f26447c == this.f26446a, this.d.i());
        super.a(adData2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b3, code lost:
        if (r3.f26446a.d() != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00bf, code lost:
        if (r3.f26446a.j() == 6) goto L32;
     */
    @Override // com.opos.mobad.model.d.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void b() {
        /*
            Method dump skipped, instructions count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.model.d.s.b():void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.mobad.model.d.b
    public void b(AdData adData) {
        com.opos.cmn.an.f.a.b("mLoader", "onLoadResourceFail");
        this.m.a(this.n, adData.d(), adData.e(), this.f26447c == this.f26446a, this.d.i());
        super.b(adData);
        i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.mobad.model.d.b
    public void c(AdData adData) {
        String str;
        int i;
        com.opos.cmn.an.f.a.b("mLoader", "onLoadResourceSucc");
        if (adData == null || adData.f().size() <= 0 || adData.f().get(0) == null) {
            str = "";
            i = 0;
        } else {
            AdItemData adItemData = adData.f().get(0);
            str = adItemData.c();
            i = adItemData.X();
        }
        this.m.a(this.n, str, this.f26447c == this.f26446a, this.d.i(), i);
        super.c(adData);
        i();
    }

    @Override // com.opos.mobad.model.d.b
    protected void e() {
        int i = this.e;
        if (i >= 30) {
            this.k.a(i - 30);
        }
        com.opos.cmn.an.f.a.b("mLoader", "request:" + this.f + ",total:" + this.e);
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.d.s.4
            /* JADX WARN: Can't wrap try/catch for region: R(16:1|(1:3)(1:46)|4|5|6|7|(2:9|(3:11|12|13)(1:15))(1:42)|16|17|18|(2:20|(3:22|12|13)(2:23|(2:25|26)(1:27)))(1:38)|28|(1:30)(2:34|(1:36)(1:37))|31|32|33) */
            /* JADX WARN: Code restructure failed: missing block: B:20:0x00ce, code lost:
                r9 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:21:0x00d0, code lost:
                com.opos.cmn.an.f.a.b("mLoader", "total await", r9);
                r7 = false;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 424
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.model.d.s.AnonymousClass4.run():void");
            }
        });
    }
}
