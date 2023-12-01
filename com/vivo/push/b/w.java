package com.vivo.push.b;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/b/w.class */
public final class w extends com.vivo.push.o {

    /* renamed from: a  reason: collision with root package name */
    private int f27365a;

    public w() {
        super(2011);
        this.f27365a = 0;
    }

    @Override // com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        aVar.a("com.bbk.push.ikey.MODE_TYPE", this.f27365a);
    }

    @Override // com.vivo.push.o
    public final boolean c() {
        return true;
    }

    public final int d() {
        return this.f27365a;
    }

    @Override // com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        this.f27365a = aVar.b("com.bbk.push.ikey.MODE_TYPE", 0);
    }

    @Override // com.vivo.push.o
    public final String toString() {
        return "PushModeCommand";
    }
}
