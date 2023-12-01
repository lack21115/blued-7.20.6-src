package com.vivo.push.b;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/b/i.class */
public final class i extends s {

    /* renamed from: a  reason: collision with root package name */
    private String f27350a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f27351c;

    public i(int i) {
        super(i);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("app_id", this.f27350a);
        aVar.a("client_id", this.b);
        aVar.a("client_token", this.f27351c);
    }

    public final String d() {
        return this.f27350a;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f27350a = aVar.a("app_id");
        this.b = aVar.a("client_id");
        this.f27351c = aVar.a("client_token");
    }

    public final String e() {
        return this.f27351c;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final String toString() {
        return "OnBindCommand";
    }
}
