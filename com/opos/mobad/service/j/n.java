package com.opos.mobad.service.j;

import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;
import com.opos.cmn.i.a;
import com.opos.mobad.service.j.m;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/j/n.class */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private static volatile n f13713a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private m f13714c;
    private m d;
    private LruCache<String, m> e;
    private LruCache<String, m> f;
    private com.opos.cmn.i.a g;
    private com.opos.cmn.i.a h;
    private com.opos.cmn.i.a i;
    private String j;
    private String k;
    private String l;
    private o m;

    private n() {
    }

    public static final n a() {
        if (f13713a == null) {
            synchronized (n.class) {
                try {
                    if (f13713a == null) {
                        f13713a = new n();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f13713a;
    }

    public void a(Context context) {
        this.b = context;
        this.m = new o(context);
        this.d = new m(180000, 10, new m.a() { // from class: com.opos.mobad.service.j.n.1
            @Override // com.opos.mobad.service.j.m.a
            public void a(m mVar) {
                n.this.m.b(mVar.c(), mVar.d());
            }
        });
        this.f13714c = new m(180000, 10, new m.a() { // from class: com.opos.mobad.service.j.n.2
            @Override // com.opos.mobad.service.j.m.a
            public void a(m mVar) {
                n.this.m.a(mVar.c(), mVar.d());
            }
        });
        this.e = new LruCache<>(10);
        this.f = new LruCache<>(10);
        this.g = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.service.j.n.3
            @Override // com.opos.cmn.i.a.b
            public void a(a.InterfaceC0475a interfaceC0475a) {
                String str = n.this.j;
                if (TextUtils.isEmpty(str)) {
                    interfaceC0475a.b();
                    return;
                }
                n.this.m.a(str);
                interfaceC0475a.a();
            }
        }, 0, 180000);
        this.h = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.service.j.n.4
            @Override // com.opos.cmn.i.a.b
            public void a(a.InterfaceC0475a interfaceC0475a) {
                String str = n.this.k;
                if (TextUtils.isEmpty(str)) {
                    interfaceC0475a.b();
                    return;
                }
                n.this.m.b(str);
                interfaceC0475a.a();
            }
        }, 0, 180000);
        this.i = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.service.j.n.5
            @Override // com.opos.cmn.i.a.b
            public void a(a.InterfaceC0475a interfaceC0475a) {
                String str = n.this.l;
                if (TextUtils.isEmpty(str)) {
                    interfaceC0475a.b();
                    return;
                }
                n.this.m.c(str);
                interfaceC0475a.a();
            }
        }, 0, 180000);
    }

    public void a(String str) {
    }

    public void a(Throwable th) {
        o oVar = this.m;
        if (oVar != null) {
            oVar.a(th);
        }
    }

    public void a(boolean z) {
        if (this.b == null) {
            return;
        }
        if (z) {
            this.f13714c.a();
        }
        this.f13714c.b();
    }

    public void b(String str) {
    }

    public void b(boolean z) {
        if (this.b == null) {
            return;
        }
        if (z) {
            this.d.a();
        }
        this.d.b();
    }
}
