package com.vivo.push.b;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/b/y.class */
public final class y extends com.vivo.push.o {

    /* renamed from: a  reason: collision with root package name */
    private String f41058a;

    public y() {
        super(2008);
    }

    public y(String str) {
        super(2008);
        this.f41058a = str;
    }

    @Override // com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        aVar.a("package_name", this.f41058a);
    }

    @Override // com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        this.f41058a = aVar.a("package_name");
    }

    @Override // com.vivo.push.o
    public final String toString() {
        return "StopServiceCommand";
    }
}
