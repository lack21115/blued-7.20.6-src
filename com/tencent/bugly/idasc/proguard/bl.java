package com.tencent.bugly.idasc.proguard;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/bl.class */
public final class bl extends m implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public String f35297a = "";
    public String b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f35298c = "";
    public String d = "";
    public String e = "";

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(k kVar) {
        this.f35297a = kVar.b(0, true);
        this.b = kVar.b(1, false);
        this.f35298c = kVar.b(2, false);
        this.d = kVar.b(3, false);
        this.e = kVar.b(4, false);
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f35297a, 0);
        String str = this.b;
        if (str != null) {
            lVar.a(str, 1);
        }
        String str2 = this.f35298c;
        if (str2 != null) {
            lVar.a(str2, 2);
        }
        String str3 = this.d;
        if (str3 != null) {
            lVar.a(str3, 3);
        }
        String str4 = this.e;
        if (str4 != null) {
            lVar.a(str4, 4);
        }
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(StringBuilder sb, int i) {
    }
}
