package com.vivo.push.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/d/a.class */
public final class a extends com.vivo.push.l {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.vivo.push.o oVar) {
        super(oVar);
    }

    @Override // com.vivo.push.l
    public final void a(com.vivo.push.o oVar) {
        com.vivo.push.b.c cVar = (com.vivo.push.b.c) oVar;
        com.vivo.push.model.b a2 = com.vivo.push.util.t.a(this.f41105a);
        if (a2 == null) {
            com.vivo.push.e.a().a(cVar.h(), 1005, new Object[0]);
            return;
        }
        String a3 = a2.a();
        if (a2.c()) {
            com.vivo.push.e.a().a(cVar.h(), 1004, new Object[0]);
            oVar = new com.vivo.push.b.e();
        } else {
            int a4 = com.vivo.push.util.s.a(cVar);
            if (a4 != 0) {
                com.vivo.push.e.a().a(cVar.h(), a4, new Object[0]);
                return;
            }
        }
        com.vivo.push.a.a.a(this.f41105a, a3, oVar);
    }
}
