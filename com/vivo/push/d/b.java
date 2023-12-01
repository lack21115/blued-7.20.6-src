package com.vivo.push.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/d/b.class */
public final class b extends com.vivo.push.l {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(com.vivo.push.o oVar) {
        super(oVar);
    }

    @Override // com.vivo.push.l
    public final void a(com.vivo.push.o oVar) {
        com.vivo.push.model.b a2 = com.vivo.push.util.t.a(this.f27414a);
        try {
            if (((com.vivo.push.b.d) oVar).d() ? f.a(this.f27414a) : f.b(this.f27414a)) {
                com.vivo.push.model.b a3 = com.vivo.push.util.t.a(this.f27414a);
                if (a2 == null || a3 == null || a3.a() == null || !a3.a().equals(a2.a())) {
                    if (a2 != null && a2.a() != null) {
                        com.vivo.push.a.a.a(this.f27414a, a2.a(), new com.vivo.push.b.y(a2.a()));
                    }
                    if (a3 == null || a3.a() == null) {
                        return;
                    }
                    com.vivo.push.a.a.a(this.f27414a, a3.a(), new com.vivo.push.b.f());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
