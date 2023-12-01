package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/proguard/al.class */
public final class al extends k implements Cloneable {
    private static ArrayList<ak> b;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<ak> f35370a = null;

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        if (b == null) {
            b = new ArrayList<>();
            b.add(new ak());
        }
        this.f35370a = (ArrayList) iVar.a((i) b, 0, true);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a((Collection) this.f35370a, 0);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb, int i) {
    }
}
