package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/proguard/ai.class */
public final class ai extends k implements Cloneable {

    /* renamed from: c  reason: collision with root package name */
    private static ArrayList<String> f35364c;

    /* renamed from: a  reason: collision with root package name */
    private String f35365a = "";
    private ArrayList<String> b = null;

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.f35365a = iVar.b(0, true);
        if (f35364c == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            f35364c = arrayList;
            arrayList.add("");
        }
        this.b = (ArrayList) iVar.a((i) f35364c, 1, false);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f35365a, 0);
        ArrayList<String> arrayList = this.b;
        if (arrayList != null) {
            jVar.a((Collection) arrayList, 1);
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb, int i) {
    }
}
