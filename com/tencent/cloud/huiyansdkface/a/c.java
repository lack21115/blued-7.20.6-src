package com.tencent.cloud.huiyansdkface.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/c.class */
public class c {
    private static ExecutorService d = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.tencent.cloud.huiyansdkface.a.c.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "WeCameraThread");
        }
    });

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f21751a;

    /* renamed from: c  reason: collision with root package name */
    private boolean f21752c;
    private e e;
    private Context f;
    private com.tencent.cloud.huiyansdkface.a.c.a g;
    private com.tencent.cloud.huiyansdkface.a.g.b h;
    private com.tencent.cloud.huiyansdkface.a.a.a.a i;
    private com.tencent.cloud.huiyansdkface.a.a.c j;
    private com.tencent.cloud.huiyansdkface.a.a.a.c k;
    private com.tencent.cloud.huiyansdkface.a.a.d m;
    private com.tencent.cloud.huiyansdkface.a.e.c n;
    private List<com.tencent.cloud.huiyansdkface.a.e.d> o;
    private com.tencent.cloud.huiyansdkface.a.e.b p;
    private com.tencent.cloud.huiyansdkface.a.a.a q;
    private com.tencent.cloud.huiyansdkface.a.c.d r;
    private long s;
    private boolean b = false;
    private CountDownLatch l = new CountDownLatch(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, com.tencent.cloud.huiyansdkface.a.c.b bVar, com.tencent.cloud.huiyansdkface.a.g.b bVar2, com.tencent.cloud.huiyansdkface.a.a.a.a aVar, com.tencent.cloud.huiyansdkface.a.a.c cVar, com.tencent.cloud.huiyansdkface.a.a.a.c cVar2, b bVar3, com.tencent.cloud.huiyansdkface.a.e.d dVar, boolean z) {
        this.f = context;
        this.f21752c = z;
        this.g = bVar.a();
        this.h = bVar2;
        this.i = aVar;
        this.j = cVar;
        this.k = cVar2;
        e eVar = new e();
        this.e = eVar;
        eVar.a(bVar3);
        ArrayList arrayList = new ArrayList();
        this.o = arrayList;
        if (dVar != null) {
            arrayList.add(dVar);
        }
        a((b) new a() { // from class: com.tencent.cloud.huiyansdkface.a.c.3
            @Override // com.tencent.cloud.huiyansdkface.a.a, com.tencent.cloud.huiyansdkface.a.b
            public void a(com.tencent.cloud.huiyansdkface.a.c.a aVar2, com.tencent.cloud.huiyansdkface.a.c.d dVar2, com.tencent.cloud.huiyansdkface.a.a.a aVar3) {
                c.this.m = dVar2.b();
                c.this.l.countDown();
            }
        });
        this.h.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f21751a) {
            com.tencent.cloud.huiyansdkface.a.d.a.a("WeCamera", "weCamera has started", new Object[0]);
            return;
        }
        com.tencent.cloud.huiyansdkface.a.d.a.a("WeCamera", "execute start camera task.", new Object[0]);
        this.s = System.currentTimeMillis();
        com.tencent.cloud.huiyansdkface.a.c.d a2 = this.g.a(this.i);
        if (a2 == null) {
            return;
        }
        this.r = a2;
        this.f21751a = true;
        this.q = this.g.a(this.j);
        this.g.a(this.j.b(), com.tencent.cloud.huiyansdkface.a.f.a.a(this.f));
        com.tencent.cloud.huiyansdkface.a.e.b d2 = this.g.d();
        this.p = d2;
        this.q.a(d2);
        this.e.a(this.g, a2, this.q);
        com.tencent.cloud.huiyansdkface.a.g.b bVar = this.h;
        if (bVar != null) {
            bVar.a(this.k, g());
        }
        this.n = this.g.e();
        if (this.o.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.o.size()) {
                    break;
                }
                this.n.a(this.o.get(i2));
                i = i2 + 1;
            }
            this.n.b();
            this.b = true;
        }
        if (this.f21752c) {
            com.tencent.cloud.huiyansdkface.a.g.b bVar2 = this.h;
            if (bVar2 != null) {
                bVar2.a(this, (com.tencent.cloud.huiyansdkface.a.c.a.a) a2, true);
                return;
            }
            return;
        }
        com.tencent.cloud.huiyansdkface.a.g.b bVar3 = this.h;
        if (bVar3 == null || bVar3.a(this, (com.tencent.cloud.huiyansdkface.a.c.a.a) a2, false)) {
            return;
        }
        com.tencent.cloud.huiyansdkface.a.d.a.b("WeCamera", "attachCameraView result=false", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        com.tencent.cloud.huiyansdkface.a.d.a.a("WeCamera", "execute stop preview callback task.", new Object[0]);
        if (a() && this.b && this.n != null) {
            com.tencent.cloud.huiyansdkface.a.d.a.b("WeCamera", "stop Preview Callback", new Object[0]);
            this.b = false;
            this.n.c();
        }
    }

    public c a(b bVar) {
        this.e.a(bVar);
        return this;
    }

    public c a(Runnable runnable) {
        if (runnable != null) {
            d.submit(runnable);
        }
        return this;
    }

    public void a(Object obj) {
        this.g.a(obj);
        c();
        this.h.a();
        com.tencent.cloud.huiyansdkface.a.d.a.a("WeCamera", "start useTime:" + (System.currentTimeMillis() - this.s), new Object[0]);
    }

    public boolean a() {
        return this.f21751a;
    }

    public c b(b bVar) {
        this.e.b(bVar);
        return this;
    }

    public void b() {
        if (this.f21752c) {
            h();
        } else {
            d.submit(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.a.c.4
                @Override // java.lang.Runnable
                public void run() {
                    c.this.h();
                }
            });
        }
    }

    public void c() {
        this.e.a(this.h, this.q, this.p, this.r);
        this.g.b();
        this.e.a(this.g);
    }

    public void d() {
        f();
        if (this.f21752c) {
            e();
        } else {
            d.submit(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.a.c.5
                @Override // java.lang.Runnable
                public void run() {
                    c.this.e();
                }
            });
        }
    }

    public void e() {
        if (!this.f21751a) {
            com.tencent.cloud.huiyansdkface.a.d.a.a("WeCamera", "weCamera has stopped", new Object[0]);
            return;
        }
        com.tencent.cloud.huiyansdkface.a.d.a.a("WeCamera", "execute stop camera task.", new Object[0]);
        this.e.b(this.g);
        this.g.c();
        this.f21751a = false;
        this.g.a();
        this.e.a();
    }

    public void f() {
        if (this.f21752c) {
            i();
        } else {
            d.submit(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.a.c.2
                @Override // java.lang.Runnable
                public void run() {
                    c.this.i();
                }
            });
        }
    }

    public com.tencent.cloud.huiyansdkface.a.e.b g() {
        return this.g.d();
    }
}
