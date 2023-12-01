package com.vivo.push.b;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/b/n.class */
public final class n extends s {

    /* renamed from: a  reason: collision with root package name */
    private String f27355a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f27356c;

    public n() {
        super(7);
        this.b = 0;
        this.f27356c = false;
    }

    public final void a(int i) {
        this.b = i;
    }

    public final void a(boolean z) {
        this.f27356c = z;
    }

    public final void b(String str) {
        this.f27355a = str;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("content", this.f27355a);
        aVar.a("log_level", this.b);
        aVar.a("is_server_log", this.f27356c);
    }

    public final String d() {
        return this.f27355a;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f27355a = aVar.a("content");
        this.b = aVar.b("log_level", 0);
        this.f27356c = aVar.e("is_server_log");
    }

    public final int e() {
        return this.b;
    }

    public final boolean f() {
        return this.f27356c;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final String toString() {
        return "OnLogCommand";
    }
}
