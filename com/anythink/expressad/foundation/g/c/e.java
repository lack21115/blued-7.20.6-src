package com.anythink.expressad.foundation.g.c;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/c/e.class */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private a f5005a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private e f5006c;
    private List<e> d;

    private void a(e eVar) {
        this.f5006c = eVar;
    }

    private void b(e eVar) {
        if (this.d == null) {
            this.d = new ArrayList();
        }
        eVar.f5006c = this;
        this.d.add(eVar);
    }

    public final a a() {
        return this.f5005a;
    }

    public final void a(a aVar) {
        this.f5005a = aVar;
    }

    public final void a(a aVar, String str) {
        e eVar = new e();
        eVar.f5005a = aVar;
        eVar.b = str;
        b(eVar);
    }

    public final void a(String str) {
        this.b = str;
    }

    public final void a(List<e> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (e eVar : list) {
            b(eVar);
        }
    }

    public final String b() {
        return this.b;
    }

    public final e c() {
        return this.f5006c;
    }

    public final List<e> d() {
        return this.d;
    }
}
