package com.opos.mobad.service.j;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.i.a;
import com.opos.mobad.provider.record.CacheEntity;
import com.opos.mobad.service.j.m;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/j/o.class */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private Context f27408a;
    private m b = new m(1, 1, 80, 0.0d, new m.a() { // from class: com.opos.mobad.service.j.o.1
        @Override // com.opos.mobad.service.j.m.a
        public void a(m mVar) {
            o.this.d.a();
        }
    });

    /* renamed from: c  reason: collision with root package name */
    private m f27409c = new m(1, 1, 30, 0.0d, new m.a() { // from class: com.opos.mobad.service.j.o.2
        @Override // com.opos.mobad.service.j.m.a
        public void a(m mVar) {
            o.this.d.a();
        }
    });
    private com.opos.cmn.i.a d = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.service.j.o.3
        @Override // com.opos.cmn.i.a.b
        public void a(a.InterfaceC0645a interfaceC0645a) {
            o.this.c();
            interfaceC0645a.a();
        }
    }, 0, 180000);
    private com.opos.cmn.i.a e = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.service.j.o.4
        @Override // com.opos.cmn.i.a.b
        public void a(a.InterfaceC0645a interfaceC0645a) {
            o.this.d();
            interfaceC0645a.a();
        }
    });
    private com.opos.mobad.provider.record.a f;
    private l g;
    private k h;
    private j i;
    private j j;
    private j k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Context context) {
        this.f27408a = context.getApplicationContext();
        this.f = new com.opos.mobad.provider.record.a(context);
        com.opos.cmn.an.j.b.b(new Runnable() { // from class: com.opos.mobad.service.j.o.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    CacheEntity a2 = o.this.f.a();
                    o.this.b.a(a2.f27123a, a2.b);
                    CacheEntity b = o.this.f.b();
                    o.this.f27409c.a(b.f27123a, b.b);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("", "", e);
                }
            }
        });
        a();
    }

    private void a() {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.j.o.6
            @Override // java.lang.Runnable
            public void run() {
                o oVar;
                try {
                    int f = o.this.f.f();
                    com.opos.cmn.an.f.a.b("watch", "check cr amount:" + f);
                    if (f >= 5) {
                        oVar = o.this;
                    } else {
                        long g = o.this.f.g();
                        com.opos.cmn.an.f.a.b("watch", "check cr time:" + g);
                        if (g <= 0 || System.currentTimeMillis() - g <= 86400000) {
                            return;
                        }
                        oVar = o.this;
                    }
                    oVar.a(f);
                } catch (Throwable th) {
                    com.opos.cmn.an.f.a.b("watch", "report cr fail", th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) throws Exception {
        String h = this.f.h();
        String i2 = this.f.i();
        com.opos.mobad.service.i.d.a().c().a(i, h, !TextUtils.isEmpty(i2) ? new JSONObject(i2) : null);
        this.f.a((String) null);
    }

    private void b() {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.j.o.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    o.this.f.c();
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("", "", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.opos.mobad.service.i.d.a().c().a(this.b.c(), this.b.d(), this.f27409c.c(), this.f27409c.d());
        b();
    }

    private void c(final int i, final int i2) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.j.o.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    o.this.f.a(new CacheEntity(i, i2));
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("", "", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.h != null) {
            com.opos.mobad.service.i.d.a().c().b(this.h.f27397a, this.h.b);
            this.h = null;
        } else if (this.g != null) {
            com.opos.mobad.service.i.d.a().c().a(this.g.f27398a, this.g.b);
            this.g = null;
        } else {
            j jVar = this.i;
            if (jVar != null) {
                com.opos.mobad.service.i.d.a().c().a(jVar.f27396a);
                this.i = null;
            }
            j jVar2 = this.j;
            if (jVar2 != null) {
                com.opos.mobad.service.i.d.a().c().b(jVar2.f27396a);
                this.j = null;
            }
            j jVar3 = this.k;
            if (jVar3 != null) {
                com.opos.mobad.service.i.d.a().c().c(jVar3.f27396a);
                this.k = null;
            }
        }
    }

    private void d(final int i, final int i2) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.j.o.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    o.this.f.b(new CacheEntity(i, i2));
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("", "", e);
                }
            }
        });
    }

    public void a(int i, int i2) {
        this.b.a(i, i2);
        c(this.b.c() + i, this.b.d() + i2);
    }

    public void a(String str) {
        this.i = new j(str);
        this.e.a();
    }

    public void a(Throwable th) {
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            this.f.a(stringWriter.toString(), com.opos.mobad.p.a.a(this.f27408a));
        } catch (Throwable th2) {
            com.opos.cmn.an.f.a.b("watch", "add cr fail", th2);
        }
    }

    public void b(int i, int i2) {
        d(this.f27409c.c() + i, this.f27409c.d() + i2);
        this.f27409c.a(i, i2);
    }

    public void b(String str) {
        this.j = new j(str);
        this.e.a();
    }

    public void c(String str) {
        this.k = new j(str);
        this.e.a();
    }
}
