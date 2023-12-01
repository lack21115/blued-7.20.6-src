package com.opos.cmn.func.dl.base;

import android.content.Context;
import com.opos.cmn.func.dl.base.c.c;
import com.opos.cmn.func.dl.base.c.d;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/d.class */
public class d implements c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f11217a = d.class.getSimpleName();
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private int f11218c;
    private int d;
    private int e;
    private boolean f;
    private float g;
    private int h;
    private int i;
    private Context j;
    private com.opos.cmn.func.dl.base.b.c k;
    private com.opos.cmn.func.dl.base.g.b l;
    private com.opos.cmn.func.dl.base.f.a m;
    private d.a n;

    public d(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context should not be null");
        }
        this.j = context.getApplicationContext();
    }

    private void i() {
        if (this.b) {
            return;
        }
        a((DownloadConfig) null);
    }

    public int a() {
        return this.f11218c;
    }

    @Override // com.opos.cmn.func.dl.base.c
    public void a(DownloadConfig downloadConfig) {
        com.opos.cmn.an.f.a.b(f11217a, "---init!");
        if (this.b) {
            return;
        }
        this.b = true;
        DownloadConfig downloadConfig2 = downloadConfig;
        if (downloadConfig == null) {
            downloadConfig2 = new DownloadConfig();
        }
        this.f11218c = downloadConfig2.a();
        this.d = downloadConfig2.b();
        this.e = downloadConfig2.c();
        this.f = downloadConfig2.d();
        this.g = downloadConfig2.e();
        this.h = downloadConfig2.f();
        this.i = downloadConfig2.g();
        this.e = Math.min(Math.max(1, this.e), 5);
        this.d = Math.min(Math.max(1, this.d), 3);
        this.f11218c = Math.min(Math.max(1, this.f11218c), 5);
        if (this.n == null) {
            this.n = new c.a();
        }
        this.k = new com.opos.cmn.func.dl.base.b.b(new com.opos.cmn.func.dl.base.b.a(this.e));
        com.opos.cmn.func.dl.base.g.b bVar = new com.opos.cmn.func.dl.base.g.b(this.f, this.k);
        this.l = bVar;
        this.m = new com.opos.cmn.func.dl.base.f.a(this, bVar);
    }

    @Override // com.opos.cmn.func.dl.base.c
    public void a(DownloadRequest downloadRequest) {
        com.opos.cmn.an.f.a.b(f11217a, "---start!");
        i();
        this.m.a(downloadRequest, false);
    }

    @Override // com.opos.cmn.func.dl.base.c
    public void a(b bVar) {
        i();
        this.l.f11245a.add(bVar);
    }

    public int b() {
        return this.d;
    }

    @Override // com.opos.cmn.func.dl.base.c
    public void b(DownloadRequest downloadRequest) {
        com.opos.cmn.an.f.a.b(f11217a, "---forceContinue!");
        i();
        this.m.a(downloadRequest, true);
    }

    @Override // com.opos.cmn.func.dl.base.c
    public void b(b bVar) {
        i();
        this.l.f11245a.remove(bVar);
    }

    public float c() {
        return this.g;
    }

    @Override // com.opos.cmn.func.dl.base.c
    public void c(final DownloadRequest downloadRequest) {
        com.opos.cmn.an.f.a.b(f11217a, "---pause!");
        i();
        final com.opos.cmn.func.dl.base.f.a aVar = this.m;
        if (downloadRequest == null) {
            com.opos.cmn.an.f.a.d(com.opos.cmn.func.dl.base.f.a.f11235a, "Request is null,do nothing");
        } else {
            com.opos.cmn.an.j.b.a(new Runnable() { // from class: com.opos.cmn.func.dl.base.f.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    com.opos.cmn.func.dl.base.a.c cVar = (com.opos.cmn.func.dl.base.a.c) a.this.b.get(Integer.valueOf(downloadRequest.f));
                    if (cVar != null) {
                        cVar.a();
                    }
                }
            });
        }
    }

    public int d() {
        return this.h;
    }

    @Override // com.opos.cmn.func.dl.base.c
    public void d(final DownloadRequest downloadRequest) {
        com.opos.cmn.an.f.a.b(f11217a, "---cancel!");
        i();
        final com.opos.cmn.func.dl.base.f.a aVar = this.m;
        if (downloadRequest == null) {
            com.opos.cmn.an.f.a.d(com.opos.cmn.func.dl.base.f.a.f11235a, "Request is null,do nothing");
        } else {
            com.opos.cmn.an.j.b.a(new Runnable() { // from class: com.opos.cmn.func.dl.base.f.a.3
                @Override // java.lang.Runnable
                public final void run() {
                    com.opos.cmn.func.dl.base.a.c cVar = (com.opos.cmn.func.dl.base.a.c) a.this.b.get(Integer.valueOf(downloadRequest.f));
                    if (cVar != null) {
                        cVar.b();
                    }
                }
            });
        }
    }

    public int e() {
        return this.i;
    }

    public Context f() {
        return this.j;
    }

    public com.opos.cmn.func.dl.base.b.c g() {
        return this.k;
    }

    public d.a h() {
        return this.n;
    }
}
