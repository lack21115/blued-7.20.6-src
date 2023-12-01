package com.tencent.bugly.proguard;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/proguard/ao.class */
public final class ao extends k implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public String f21684a = "";
    private String b = "";

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.f21684a = iVar.b(0, true);
        this.b = iVar.b(1, true);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f21684a, 0);
        jVar.a(this.b, 1);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb, int i) {
    }
}
