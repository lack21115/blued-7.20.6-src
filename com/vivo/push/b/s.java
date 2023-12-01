package com.vivo.push.b;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/b/s.class */
public class s extends com.vivo.push.o {

    /* renamed from: a  reason: collision with root package name */
    private String f41052a;
    private int b;

    public s(int i) {
        super(i);
        this.f41052a = null;
        this.b = 0;
    }

    @Override // com.vivo.push.o
    public void c(com.vivo.push.a aVar) {
        aVar.a("req_id", this.f41052a);
        aVar.a("status_msg_code", this.b);
    }

    @Override // com.vivo.push.o
    public void d(com.vivo.push.a aVar) {
        this.f41052a = aVar.a("req_id");
        this.b = aVar.b("status_msg_code", this.b);
    }

    public final String g() {
        return this.f41052a;
    }

    public final int h() {
        return this.b;
    }

    @Override // com.vivo.push.o
    public String toString() {
        return "OnReceiveCommand";
    }
}
