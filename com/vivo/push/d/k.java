package com.vivo.push.d;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/d/k.class */
public final class k extends z {
    /* JADX INFO: Access modifiers changed from: package-private */
    public k(com.vivo.push.o oVar) {
        super(oVar);
    }

    @Override // com.vivo.push.l
    public final void a(com.vivo.push.o oVar) {
        com.vivo.push.b.l lVar = (com.vivo.push.b.l) oVar;
        int d = lVar.d();
        int e = lVar.e();
        com.vivo.push.util.w.b().a("key_dispatch_environment", d);
        com.vivo.push.util.w.b().a("key_dispatch_area", e);
    }
}
