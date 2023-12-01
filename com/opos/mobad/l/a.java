package com.opos.mobad.l;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/l/a.class */
public abstract class a extends j implements com.opos.mobad.ad.a.a {

    /* renamed from: a  reason: collision with root package name */
    private com.opos.mobad.ad.a.b f26295a;

    public a(com.opos.mobad.ad.a.b bVar) {
        super(bVar);
        this.f26295a = bVar;
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        if (this.f26295a != null) {
            this.f26295a = null;
        }
        super.b();
    }

    public final void g_() {
        com.opos.mobad.ad.a.b bVar;
        if (d() == 5 || (bVar = this.f26295a) == null) {
            return;
        }
        bVar.a("");
    }

    public final void i() {
        com.opos.mobad.ad.a.b bVar;
        if (5 == d() || (bVar = this.f26295a) == null) {
            return;
        }
        bVar.a(0L);
    }
}
