package com.xiaomi.push;

import com.xiaomi.push.al;
import com.xiaomi.push.dd;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/df.class */
public class df extends al.b {

    /* renamed from: a  reason: collision with root package name */
    al.b f27642a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ dd f250a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(dd ddVar) {
        this.f250a = ddVar;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        dd.b bVar = (dd.b) this.f250a.f238a.peek();
        if (bVar == null || !bVar.a()) {
            return;
        }
        if (this.f250a.f238a.remove(bVar)) {
            this.f27642a = bVar;
        }
        al.b bVar2 = this.f27642a;
        if (bVar2 != null) {
            bVar2.b();
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo8568c() {
        al.b bVar = this.f27642a;
        if (bVar != null) {
            bVar.mo8568c();
        }
    }
}
