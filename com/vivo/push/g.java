package com.vivo.push;

import com.vivo.push.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/g.class */
public final class g implements IPushActionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e.a f27407a;
    final /* synthetic */ e b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, e.a aVar) {
        this.b = eVar;
        this.f27407a = aVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        com.vivo.push.util.b bVar;
        if (i != 0) {
            this.b.k = null;
            bVar = this.b.j;
            bVar.b("APP_TOKEN");
            return;
        }
        Object[] b = this.f27407a.b();
        if (b == null || b.length == 0) {
            com.vivo.push.util.p.a("PushClientManager", "bind app result is null");
        } else {
            this.b.a((String) this.f27407a.b()[0]);
        }
    }
}
