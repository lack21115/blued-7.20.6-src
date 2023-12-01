package com.opos.mobad.l;

import android.app.Activity;
import java.util.concurrent.Callable;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/l/h.class */
public abstract class h extends k implements com.opos.mobad.ad.d.a {

    /* renamed from: a  reason: collision with root package name */
    private com.opos.mobad.ad.d.b f12616a;

    public h(com.opos.mobad.ad.d.b bVar) {
        super(bVar);
        this.f12616a = bVar;
    }

    public final void a(long j) {
        com.opos.mobad.ad.d.b bVar;
        if (d() == 5 || (bVar = this.f12616a) == null) {
            return;
        }
        bVar.a(j);
    }

    @Override // com.opos.mobad.ad.d.a
    public void a(final boolean z) {
        d(new Callable<Boolean>() { // from class: com.opos.mobad.l.h.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                return Boolean.valueOf(h.this.b(z));
            }
        });
    }

    public final void a(Object... objArr) {
        com.opos.mobad.ad.d.b bVar;
        if (d() == 5 || (bVar = this.f12616a) == null) {
            return;
        }
        bVar.a(objArr);
    }

    public final void b(long j) {
        com.opos.mobad.ad.d.b bVar;
        if (d() == 5 || (bVar = this.f12616a) == null) {
            return;
        }
        bVar.b(j);
    }

    @Override // com.opos.mobad.l.k
    protected boolean b(Activity activity) {
        return b(false);
    }

    protected abstract boolean b(boolean z);

    public final void d(String str) {
        com.opos.mobad.ad.d.b bVar;
        if (d() == 5 || (bVar = this.f12616a) == null) {
            return;
        }
        bVar.b(str);
    }

    public final void h_() {
        com.opos.mobad.ad.d.b bVar;
        if (d() == 5 || (bVar = this.f12616a) == null) {
            return;
        }
        bVar.d();
    }

    public final void i() {
        com.opos.mobad.ad.d.b bVar;
        if (d() == 5 || (bVar = this.f12616a) == null) {
            return;
        }
        bVar.c();
    }

    public final void k() {
        com.opos.mobad.ad.d.b bVar;
        if (d() == 5 || (bVar = this.f12616a) == null) {
            return;
        }
        bVar.e();
    }

    public final void m() {
        com.opos.mobad.ad.d.b bVar;
        if (d() == 5 || (bVar = this.f12616a) == null) {
            return;
        }
        bVar.f();
    }
}
