package com.anythink.expressad.advanced.d;

import com.anythink.expressad.out.o;
import java.util.ArrayList;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/advanced/d/b.class */
public final class b implements com.anythink.expressad.advanced.b.a {

    /* renamed from: a  reason: collision with root package name */
    private o f4192a;
    private c b;

    public b(c cVar) {
        this.b = cVar;
    }

    private static void a() {
    }

    private void b() {
        if (this.f4192a != null) {
            this.f4192a = null;
        }
        if (this.b != null) {
            this.b = null;
        }
    }

    @Override // com.anythink.expressad.advanced.b.a
    public final void a(com.anythink.expressad.foundation.d.c cVar, int i) {
        c cVar2;
        com.anythink.expressad.foundation.h.o.d("NativeAdvancedLoadManager", "onLoadSuccessed: ".concat(String.valueOf(i)));
        c cVar3 = this.b;
        if (cVar3 == null || !cVar3.a() || cVar == null) {
            return;
        }
        o oVar = this.f4192a;
        if (oVar != null && this.b != null) {
            oVar.a();
        }
        this.b.b();
        new ArrayList().add(cVar);
        if (i != 2 || (cVar2 = this.b) == null) {
            return;
        }
        cVar2.a(cVar, true);
    }

    public final void a(o oVar) {
        this.f4192a = oVar;
    }

    @Override // com.anythink.expressad.advanced.b.a
    public final void a(String str, int i) {
        com.anythink.expressad.foundation.h.o.d("NativeAdvancedLoadManager", "onLoadFailed: " + i + str);
        c cVar = this.b;
        if (cVar == null || !cVar.a()) {
            return;
        }
        o oVar = this.f4192a;
        if (oVar != null) {
            oVar.a(str);
        }
        this.b.b();
    }
}
