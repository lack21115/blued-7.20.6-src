package com.opos.mobad.l;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/l/d.class */
public abstract class d extends k implements com.opos.mobad.ad.b.c {

    /* renamed from: a  reason: collision with root package name */
    private com.opos.mobad.ad.b.d f26296a;

    public d(com.opos.mobad.ad.b.d dVar) {
        super(dVar);
        this.f26296a = dVar;
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        this.f26296a = null;
        super.b();
    }

    public final void h() {
        com.opos.mobad.ad.b.d dVar;
        if (d() == 5 || (dVar = this.f26296a) == null) {
            return;
        }
        dVar.c();
    }
}
