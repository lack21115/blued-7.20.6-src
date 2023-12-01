package com.anythink.expressad.foundation.g.c;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/c/f.class */
public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    protected e f5007a;

    public f(String str) {
        e eVar = new e();
        eVar.a(str);
        eVar.a(a.AD_ROOT);
        List<e> a2 = a();
        if (a2.size() > 0) {
            eVar.a(a2);
        }
        this.f5007a = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static e a(ArrayList<e> arrayList, a aVar, String str) {
        e eVar = new e();
        eVar.a(aVar);
        eVar.a(str);
        arrayList.add(eVar);
        return eVar;
    }

    protected abstract List<e> a();

    public final e b() {
        return this.f5007a;
    }
}
