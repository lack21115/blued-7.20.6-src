package com.tencent.turingface.sdk.mfa;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/y8N3A.class */
public final class y8N3A extends ucT3w {

    /* renamed from: a  reason: collision with root package name */
    public String f40013a = "";
    public String b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f40014c = "";
    public int d = 0;
    public String e = "";
    public String f = "";
    public String g = "";
    public String h = "";

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(d5HOq d5hoq) {
        d5hoq.a(this.f40013a, 0);
        String str = this.b;
        if (str != null) {
            d5hoq.a(str, 1);
        }
        d5hoq.a(this.f40014c, 2);
        d5hoq.a(this.d, 3);
        d5hoq.a(this.e, 4);
        d5hoq.a(this.f, 5);
        String str2 = this.g;
        if (str2 != null) {
            d5hoq.a(str2, 6);
        }
        String str3 = this.h;
        if (str3 != null) {
            d5hoq.a(str3, 7);
        }
    }

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(nyvKz nyvkz) {
        this.f40013a = nyvkz.b(0, true);
        this.b = nyvkz.b(1, false);
        this.f40014c = nyvkz.b(2, true);
        this.d = nyvkz.a(this.d, 3, true);
        this.e = nyvkz.b(4, true);
        this.f = nyvkz.b(5, true);
        this.g = nyvkz.b(6, false);
        this.h = nyvkz.b(7, false);
    }
}
