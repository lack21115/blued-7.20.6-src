package com.opos.mobad.service;

import android.content.Context;
import android.util.Log;
import com.opos.mobad.service.f.a;
import com.opos.mobad.service.j.n;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static volatile f f13660a = new f();
    private boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private com.opos.mobad.service.a.e f13661c = new com.opos.mobad.service.a.e();
    private com.opos.mobad.service.d.a d = new com.opos.mobad.service.d.a();
    private com.opos.mobad.service.a.b e = new com.opos.mobad.service.a.b();
    private com.opos.mobad.service.b.a g = new com.opos.mobad.service.b.a();
    private g f = new g("");
    private com.opos.mobad.service.tasks.c h = new com.opos.mobad.service.tasks.c();

    private f() {
    }

    public static final com.opos.mobad.service.a.b a() {
        return f13660a.e;
    }

    private static void a(final Context context) {
        if (context == null) {
            return;
        }
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.f.1
            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.func.b.b.b.a().a(Context.this);
            }
        });
    }

    private void a(Context context, String str, String str2, int i, int i2, long j) {
        com.opos.mobad.service.c.b.a().a(context);
        this.f13661c.a(context, str, str2, i2, i, j);
        this.d.a(context, str, str2, i2, i);
        com.opos.mobad.service.a.c.a().a(context, str, i, i2);
    }

    private static void a(final Context context, final boolean z, final boolean z2) {
        if (context == null) {
            return;
        }
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.f.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    new com.opos.mobad.provider.init.a(Context.this).a(z, z2);
                } catch (com.opos.process.bridge.provider.b | com.opos.process.bridge.provider.c e) {
                    com.opos.cmn.an.f.a.d("ServiceManager", "", e);
                }
            }
        });
    }

    public static final void a(Context context, boolean z, boolean z2, boolean z3, int i, a.c cVar, a.g gVar, a.InterfaceC0565a interfaceC0565a, a.f fVar, a.b bVar) {
        f13660a.b(context, z, z2, z3, i, cVar, gVar, interfaceC0565a, fVar, bVar);
    }

    public static final com.opos.mobad.service.a.e b() {
        return f13660a.f13661c;
    }

    private void b(Context context, boolean z, boolean z2, boolean z3, int i, a.c cVar, a.g gVar, a.InterfaceC0565a interfaceC0565a, a.f fVar, a.b bVar) {
        synchronized (this) {
            if (!this.b) {
                try {
                    Context applicationContext = context.getApplicationContext();
                    com.opos.cmn.c.a.a(applicationContext, z, z3);
                    a(applicationContext, z, z3);
                    this.g.a();
                    com.opos.cmn.a.a.a(z, "CN");
                    a(applicationContext);
                    com.opos.mobad.service.e.a.a().a(applicationContext, z3);
                    com.opos.mobad.service.e.a.a().a(z2);
                    a(applicationContext, interfaceC0565a.a(), interfaceC0565a.b(), fVar.a(), 0, 0L);
                    com.opos.mobad.service.i.d.a().a(applicationContext, interfaceC0565a.a(), fVar.a(), fVar.c());
                    if (!com.opos.cmn.an.f.a.b(applicationContext)) {
                        com.opos.cmn.an.e.c.a().a(applicationContext);
                    }
                    com.opos.mobad.service.f.a.a().a(applicationContext, cVar, gVar, interfaceC0565a, fVar, null, bVar);
                    com.opos.cmn.c.a.b();
                    n.a().a(applicationContext.getApplicationContext());
                    this.b = true;
                    d.a().a(applicationContext.getApplicationContext());
                    this.h.a(applicationContext.getApplicationContext(), z3, i);
                    com.opos.mobad.service.event.b.a().a(applicationContext.getApplicationContext());
                    com.opos.mobad.d.d.a().a(applicationContext);
                } catch (Exception e) {
                    Log.w("ServiceManager", "", e);
                }
            }
        }
    }

    public static final com.opos.mobad.service.d.a c() {
        return f13660a.d;
    }

    public static final boolean d() {
        return f13660a.b;
    }

    public static final void e() {
        synchronized (f.class) {
            try {
                f fVar = f13660a;
                f13660a = new f();
                fVar.f();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void f() {
        com.opos.cmn.an.e.c.a().b();
        com.opos.mobad.service.f.a.a().y();
        a.a().b();
        this.h.a();
        com.opos.cmn.c.a.a();
    }
}
