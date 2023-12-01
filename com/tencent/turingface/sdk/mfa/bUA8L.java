package com.tencent.turingface.sdk.mfa;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/bUA8L.class */
public final class bUA8L {

    /* renamed from: a  reason: collision with root package name */
    public int f39939a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f39940c;
    public String d;
    public int e;

    public bUA8L(int i, int i2, String str, int i3, int i4) {
        this.f39939a = i;
        this.b = i2;
        this.d = str;
        this.f39940c = i3;
        this.e = i4;
    }

    public final String toString() {
        String format = String.format("% 6d", Integer.valueOf(this.f39939a));
        String format2 = String.format("% 6d", Integer.valueOf(this.b));
        String format3 = String.format("% 6d", Integer.valueOf(this.f39940c));
        return "" + format + "    " + format2 + "    " + format3 + "    " + this.d;
    }
}
