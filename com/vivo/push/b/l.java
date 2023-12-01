package com.vivo.push.b;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/b/l.class */
public final class l extends s {

    /* renamed from: a  reason: collision with root package name */
    private int f41044a;
    private int b;

    public l() {
        super(2016);
        this.f41044a = -1;
        this.b = -1;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("key_dispatch_environment", this.f41044a);
        aVar.a("key_dispatch_area", this.b);
    }

    public final int d() {
        return this.f41044a;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f41044a = aVar.b("key_dispatch_environment", 1);
        this.b = aVar.b("key_dispatch_area", 1);
    }

    public final int e() {
        return this.b;
    }
}
