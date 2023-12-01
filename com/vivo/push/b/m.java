package com.vivo.push.b;

import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/b/m.class */
public final class m extends s {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<String> f27354a;

    public m() {
        super(8);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("tags_list", this.f27354a);
    }

    public final ArrayList<String> d() {
        return this.f27354a;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f27354a = aVar.c("tags_list");
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final String toString() {
        return "OnListTagCommand";
    }
}
