package com.vivo.push.b;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/b/u.class */
public final class u extends v {

    /* renamed from: a  reason: collision with root package name */
    private long f41054a;
    private int b;

    public u() {
        super(20);
        this.f41054a = -1L;
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("undo_msg_v1", this.f41054a);
        aVar.a("undo_msg_type_v1", this.b);
    }

    public final long d() {
        return this.f41054a;
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f41054a = aVar.b("undo_msg_v1", this.f41054a);
        this.b = aVar.b("undo_msg_type_v1", 0);
    }

    public final String e() {
        long j = this.f41054a;
        if (j != -1) {
            return String.valueOf(j);
        }
        return null;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final String toString() {
        return "OnUndoMsgCommand";
    }
}
