package com.opos.mobad.l;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/l/i.class */
public abstract class i extends j implements com.opos.mobad.ad.e.b {

    /* renamed from: a  reason: collision with root package name */
    private com.opos.mobad.ad.e.c f12618a;

    public i(com.opos.mobad.ad.e.c cVar) {
        super(cVar);
        this.f12618a = cVar;
    }

    public void d(String str) {
        com.opos.mobad.ad.e.c cVar;
        if (5 == d() || (cVar = this.f12618a) == null) {
            return;
        }
        cVar.a(str);
    }

    public final void i() {
        com.opos.mobad.ad.e.c cVar;
        if (5 == d() || (cVar = this.f12618a) == null) {
            return;
        }
        cVar.a(0L);
    }

    @Override // com.opos.mobad.l.j
    public void i_() {
        com.opos.mobad.ad.e.c cVar;
        if (5 == d() || (cVar = this.f12618a) == null) {
            return;
        }
        cVar.b();
    }
}
