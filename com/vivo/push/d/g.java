package com.vivo.push.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/d/g.class */
public final class g extends z {
    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.vivo.push.o oVar) {
        super(oVar);
    }

    @Override // com.vivo.push.l
    public final void a(com.vivo.push.o oVar) {
        com.vivo.push.util.p.d("OnClearCacheTask", "delete push info " + this.f27414a.getPackageName());
        com.vivo.push.util.y.b(this.f27414a).a();
    }
}
