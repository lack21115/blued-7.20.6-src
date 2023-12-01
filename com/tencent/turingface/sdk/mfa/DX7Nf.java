package com.tencent.turingface.sdk.mfa;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/DX7Nf.class */
public final class DX7Nf extends ucT3w {

    /* renamed from: a  reason: collision with root package name */
    public String f26178a = "";
    public String b = "";

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(d5HOq d5hoq) {
        d5hoq.a(this.f26178a, 0);
        d5hoq.a(this.b, 1);
    }

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(nyvKz nyvkz) {
        this.f26178a = nyvkz.b(0, true);
        this.b = nyvkz.b(1, true);
    }
}
