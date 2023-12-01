package com.anythink.expressad.mbbanner.a.c;

import com.anythink.expressad.foundation.h.o;
import java.util.List;
import java.util.Random;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/mbbanner/a/c/e.class */
public class e implements c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5175a = e.class.getSimpleName();
    private c b;

    /* renamed from: c  reason: collision with root package name */
    private com.anythink.expressad.d.c f5176c;
    private boolean d = false;

    public e(c cVar, com.anythink.expressad.d.c cVar2) {
        this.f5176c = cVar2;
        this.b = cVar;
    }

    private static boolean a(com.anythink.expressad.d.c cVar, boolean z) {
        if (z || cVar == null || cVar.a() == 1.0d) {
            return false;
        }
        return new Random().nextDouble() > cVar.a();
    }

    @Override // com.anythink.expressad.mbbanner.a.c.c
    public final void a() {
        c cVar = this.b;
        if (cVar != null) {
            cVar.a();
        }
    }

    @Override // com.anythink.expressad.mbbanner.a.c.c
    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        c cVar2 = this.b;
        if (cVar2 == null || this.d) {
            return;
        }
        cVar2.a(cVar);
    }

    @Override // com.anythink.expressad.mbbanner.a.c.c
    public final void a(com.anythink.expressad.foundation.d.c cVar, boolean z) {
        c cVar2 = this.b;
        if (cVar2 != null) {
            cVar2.a(cVar, this.d);
        }
    }

    @Override // com.anythink.expressad.mbbanner.a.c.c
    public final void a(String str) {
        c cVar = this.b;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    @Override // com.anythink.expressad.mbbanner.a.c.c
    public final void a(List<com.anythink.expressad.foundation.d.c> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    com.anythink.expressad.d.c cVar = this.f5176c;
                    boolean z = false;
                    if (!list.get(0).A()) {
                        z = false;
                        if (cVar != null) {
                            z = false;
                            if (cVar.a() != 1.0d) {
                                z = false;
                                if (new Random().nextDouble() > cVar.a()) {
                                    z = true;
                                }
                            }
                        }
                    }
                    this.d = z;
                    String str = f5175a;
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.d);
                    o.d(str, sb.toString());
                }
            } catch (Exception e) {
                o.b(f5175a, "Exception", e);
            }
        }
        c cVar2 = this.b;
        if (cVar2 != null) {
            cVar2.a(list);
        }
    }

    @Override // com.anythink.expressad.mbbanner.a.c.c
    public final void a(boolean z) {
        c cVar = this.b;
        if (cVar != null) {
            cVar.a(z);
        }
    }

    @Override // com.anythink.expressad.mbbanner.a.c.c
    public final void b() {
        c cVar = this.b;
        if (cVar != null) {
            cVar.b();
        }
    }

    @Override // com.anythink.expressad.mbbanner.a.c.c
    public final void c() {
        c cVar = this.b;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // com.anythink.expressad.mbbanner.a.c.c
    public final void d() {
        c cVar = this.b;
        if (cVar != null) {
            cVar.d();
        }
    }
}
