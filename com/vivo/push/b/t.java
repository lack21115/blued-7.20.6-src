package com.vivo.push.b;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/b/t.class */
public final class t extends s {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<String> f27362a;
    private ArrayList<String> b;

    public t(int i) {
        super(i);
        this.f27362a = null;
        this.b = null;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("content", this.f27362a);
        aVar.a("error_msg", this.b);
    }

    public final ArrayList<String> d() {
        return this.f27362a;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f27362a = aVar.c("content");
        this.b = aVar.c("error_msg");
    }

    public final List<String> e() {
        return this.b;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final String toString() {
        return "OnSetTagsCommand";
    }
}
