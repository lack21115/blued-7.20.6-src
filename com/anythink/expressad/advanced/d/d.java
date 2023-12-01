package com.anythink.expressad.advanced.d;

import com.anythink.expressad.out.o;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Random;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/advanced/d/d.class */
public final class d implements com.anythink.expressad.advanced.b.b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4198a = "NativeAdvancedShowListenerImpl";
    private o b;

    /* renamed from: c  reason: collision with root package name */
    private com.anythink.expressad.foundation.d.c f4199c;
    private boolean d;
    private c e;

    public d(c cVar, o oVar, double d, com.anythink.expressad.foundation.d.c cVar2) {
        this.e = cVar;
        this.b = oVar;
        this.f4199c = cVar2;
        this.d = a(d, cVar2);
    }

    private static boolean a(double d, com.anythink.expressad.foundation.d.c cVar) {
        try {
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.d.a c2 = com.anythink.expressad.d.b.c();
            long l = c2.l() * 1000;
            long x = c2.x() * 1000;
            com.anythink.expressad.foundation.h.o.d(f4198a, "cbp : " + d + " plct : " + x + " plctb : " + l);
            if (cVar != null) {
                if (cVar.a(x, l)) {
                    cVar.e(1);
                    return true;
                }
                cVar.e(0);
            }
            if (cVar == null || cVar.A() || d == 1.0d) {
                return false;
            }
            double nextDouble = new Random().nextDouble();
            StringBuilder sb = new StringBuilder("hit : ");
            sb.append(nextDouble);
            sb.append(" ");
            int i = (nextDouble > d ? 1 : (nextDouble == d ? 0 : -1));
            sb.append(i > 0);
            com.anythink.expressad.foundation.h.o.d(f4198a, sb.toString());
            return i > 0;
        } catch (Exception e) {
            com.anythink.expressad.foundation.h.o.b(f4198a, "CBPERROR", e);
            return false;
        }
    }

    private void g() {
        if (this.b != null) {
            this.b = null;
        }
    }

    @Override // com.anythink.expressad.advanced.b.b
    public final void a() {
        c cVar = this.e;
        if (cVar != null) {
            cVar.d = true;
        }
        StringBuffer stringBuffer = new StringBuffer("load_to=0&allow_skip=");
        stringBuffer.append(this.e.d());
        stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
        o oVar = this.b;
        if (oVar == null || this.d) {
            return;
        }
        oVar.b();
    }

    @Override // com.anythink.expressad.advanced.b.b
    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        o oVar = this.b;
        if (oVar == null || this.d) {
            return;
        }
        oVar.a(cVar);
    }

    @Override // com.anythink.expressad.advanced.b.b
    public final void b() {
    }

    @Override // com.anythink.expressad.advanced.b.b
    public final void c() {
        o oVar = this.b;
        if (oVar != null) {
            oVar.f();
            c cVar = this.e;
            if (cVar != null) {
                cVar.d = false;
            }
        }
    }

    @Override // com.anythink.expressad.advanced.b.b
    public final void d() {
    }

    @Override // com.anythink.expressad.advanced.b.b
    public final void e() {
    }

    @Override // com.anythink.expressad.advanced.b.b
    public final void f() {
    }
}
