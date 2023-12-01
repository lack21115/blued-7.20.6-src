package com.tencent.turingface.sdk.mfa;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/sWkeo.class */
public final class sWkeo extends ucT3w implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public int f39990a = 0;
    public String b = "";

    /* renamed from: c  reason: collision with root package name */
    public int f39991c = 0;
    public int d = 0;

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(d5HOq d5hoq) {
        d5hoq.a(this.f39990a, 0);
        d5hoq.a(this.b, 1);
        int i = this.f39991c;
        if (i != 0) {
            d5hoq.a(i, 3);
        }
        int i2 = this.d;
        if (i2 != 0) {
            d5hoq.a(i2, 4);
        }
    }

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(nyvKz nyvkz) {
        this.f39990a = nyvkz.a(this.f39990a, 0, true);
        this.b = nyvkz.b(1, true);
        this.f39991c = nyvkz.a(this.f39991c, 3, false);
        this.d = nyvkz.a(this.d, 4, false);
    }
}
