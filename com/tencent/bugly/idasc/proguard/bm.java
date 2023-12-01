package com.tencent.bugly.idasc.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/bm.class */
public final class bm extends m implements Cloneable {

    /* renamed from: c  reason: collision with root package name */
    static ArrayList<String> f21608c;

    /* renamed from: a  reason: collision with root package name */
    public String f21609a = "";
    public ArrayList<String> b = null;

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(k kVar) {
        this.f21609a = kVar.b(0, true);
        if (f21608c == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            f21608c = arrayList;
            arrayList.add("");
        }
        this.b = (ArrayList) kVar.a((k) f21608c, 1, false);
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f21609a, 0);
        ArrayList<String> arrayList = this.b;
        if (arrayList != null) {
            lVar.a((Collection) arrayList, 1);
        }
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(StringBuilder sb, int i) {
    }
}
