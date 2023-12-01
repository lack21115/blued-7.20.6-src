package com.tencent.turingface.sdk.mfa;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/ShGzN.class */
public final class ShGzN extends ucT3w {

    /* renamed from: a  reason: collision with root package name */
    public int f39921a = 0;
    public String b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f39922c = "";
    public String d = "";
    public int e = 0;

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(d5HOq d5hoq) {
        d5hoq.a(this.f39921a, 0);
        d5hoq.a(this.b, 1);
        d5hoq.a(this.f39922c, 2);
        d5hoq.a(this.d, 3);
        d5hoq.a(this.e, 4);
    }

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(nyvKz nyvkz) {
        this.f39921a = nyvkz.a(this.f39921a, 0, true);
        this.b = nyvkz.b(1, true);
        this.f39922c = nyvkz.b(2, true);
        this.d = nyvkz.b(3, true);
        this.e = nyvkz.a(this.e, 4, true);
    }
}
