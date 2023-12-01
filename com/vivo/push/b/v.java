package com.vivo.push.b;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/b/v.class */
public abstract class v extends s {

    /* renamed from: a  reason: collision with root package name */
    private String f41055a;
    private long b;

    public v(int i) {
        super(i);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT", this.f41055a);
        aVar.a("notify_id", this.b);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f41055a = aVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT");
        this.b = aVar.b("notify_id", -1L);
    }

    public final long f() {
        return this.b;
    }

    public final String i() {
        return this.f41055a;
    }
}
