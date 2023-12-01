package com.tencent.bugly.idasc.proguard;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/bs.class */
public final class bs extends m implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public String f35310a = "";
    public String b = "";

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(k kVar) {
        this.f35310a = kVar.b(0, true);
        this.b = kVar.b(1, true);
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f35310a, 0);
        lVar.a(this.b, 1);
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(StringBuilder sb, int i) {
    }
}
