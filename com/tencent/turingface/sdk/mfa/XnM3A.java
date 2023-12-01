package com.tencent.turingface.sdk.mfa;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/XnM3A.class */
public final class XnM3A extends ucT3w {

    /* renamed from: a  reason: collision with root package name */
    public int f39928a = 0;
    public float b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    public float f39929c = 0.0f;
    public float d = 0.0f;
    public float e = 0.0f;

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(d5HOq d5hoq) {
        d5hoq.a(this.f39928a, 0);
        d5hoq.a(this.b, 1);
        d5hoq.a(this.f39929c, 2);
        float f = this.d;
        if (f != 0.0f) {
            d5hoq.a(f, 3);
        }
        float f2 = this.e;
        if (f2 != 0.0f) {
            d5hoq.a(f2, 4);
        }
    }

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(nyvKz nyvkz) {
        this.f39928a = nyvkz.a(this.f39928a, 0, true);
        this.b = nyvkz.a(this.b, 1, true);
        this.f39929c = nyvkz.a(this.f39929c, 2, true);
        this.d = nyvkz.a(this.d, 3, false);
        this.e = nyvkz.a(this.e, 4, false);
    }
}
