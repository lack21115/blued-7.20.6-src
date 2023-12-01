package com.vivo.push.b;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/b/h.class */
public final class h extends com.vivo.push.o {

    /* renamed from: a  reason: collision with root package name */
    private String f27349a;

    public h() {
        super(2013);
    }

    public h(String str) {
        this();
        this.f27349a = str;
    }

    @Override // com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        aVar.a("MsgArriveCommand.MSG_TAG", this.f27349a);
    }

    @Override // com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        this.f27349a = aVar.a("MsgArriveCommand.MSG_TAG");
    }
}
