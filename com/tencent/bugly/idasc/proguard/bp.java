package com.tencent.bugly.idasc.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/bp.class */
public final class bp extends m implements Cloneable {
    static ArrayList<bo> b;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<bo> f35305a = null;

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(k kVar) {
        if (b == null) {
            b = new ArrayList<>();
            b.add(new bo());
        }
        this.f35305a = (ArrayList) kVar.a((k) b, 0, true);
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(l lVar) {
        lVar.a((Collection) this.f35305a, 0);
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(StringBuilder sb, int i) {
    }
}
