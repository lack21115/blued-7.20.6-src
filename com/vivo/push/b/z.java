package com.vivo.push.b;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/b/z.class */
public final class z extends c {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<String> f27368a;

    public z(boolean z, String str, ArrayList<String> arrayList) {
        super(z ? 2004 : 2005, str);
        this.f27368a = arrayList;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("tags", (Serializable) this.f27368a);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f27368a = aVar.c("tags");
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final String toString() {
        return "TagCommand";
    }
}
