package com.anythink.expressad.splash.d;

import java.util.ArrayList;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/d/b.class */
public final class b implements com.anythink.expressad.splash.b.c {

    /* renamed from: a  reason: collision with root package name */
    private com.anythink.expressad.out.d f5386a;
    private c b;

    /* renamed from: c  reason: collision with root package name */
    private String f5387c;
    private String d;

    public b(c cVar) {
        this.b = cVar;
    }

    private void a() {
        if (this.f5386a != null) {
            this.f5386a = null;
        }
    }

    @Override // com.anythink.expressad.splash.b.c
    public final void a(com.anythink.expressad.foundation.d.c cVar, int i) {
        c cVar2;
        c cVar3 = this.b;
        if (cVar3 == null || !cVar3.a() || cVar == null) {
            return;
        }
        com.anythink.expressad.out.d dVar = this.f5386a;
        if (dVar != null) {
            dVar.a();
            cVar.t();
        }
        this.b.b();
        new ArrayList().add(cVar);
        if (i != 2 || (cVar2 = this.b) == null) {
            return;
        }
        cVar2.a(cVar, true);
    }

    public final void a(com.anythink.expressad.out.d dVar) {
        this.f5386a = dVar;
    }

    @Override // com.anythink.expressad.splash.b.c
    public final void a(String str) {
        c cVar = this.b;
        if (cVar == null || !cVar.a()) {
            return;
        }
        com.anythink.expressad.out.d dVar = this.f5386a;
        if (dVar != null) {
            dVar.a(str);
        }
        this.b.b();
    }

    public final void b(String str) {
        this.d = str;
    }
}
