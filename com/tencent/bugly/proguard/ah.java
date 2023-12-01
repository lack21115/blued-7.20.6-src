package com.tencent.bugly.proguard;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/proguard/ah.class */
public final class ah extends k implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public String f21671a = "";
    private String d = "";
    public String b = "";
    private String e = "";

    /* renamed from: c  reason: collision with root package name */
    public String f21672c = "";

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.f21671a = iVar.b(0, true);
        this.d = iVar.b(1, false);
        this.b = iVar.b(2, false);
        this.e = iVar.b(3, false);
        this.f21672c = iVar.b(4, false);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f21671a, 0);
        String str = this.d;
        if (str != null) {
            jVar.a(str, 1);
        }
        String str2 = this.b;
        if (str2 != null) {
            jVar.a(str2, 2);
        }
        String str3 = this.e;
        if (str3 != null) {
            jVar.a(str3, 3);
        }
        String str4 = this.f21672c;
        if (str4 != null) {
            jVar.a(str4, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb, int i) {
    }
}
