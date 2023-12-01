package com.xiaomi.push;

import com.xiaomi.push.al;
import com.xiaomi.push.dd;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/df.class */
public class df extends al.b {

    /* renamed from: a  reason: collision with root package name */
    al.b f41333a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ dd f297a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(dd ddVar) {
        this.f297a = ddVar;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        dd.b bVar = (dd.b) this.f297a.f285a.peek();
        if (bVar == null || !bVar.a()) {
            return;
        }
        if (this.f297a.f285a.remove(bVar)) {
            this.f41333a = bVar;
        }
        al.b bVar2 = this.f41333a;
        if (bVar2 != null) {
            bVar2.b();
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo11618c() {
        al.b bVar = this.f41333a;
        if (bVar != null) {
            bVar.mo11618c();
        }
    }
}
