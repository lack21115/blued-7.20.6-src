package com.tencent.turingface.sdk.mfa;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/bUA8L.class */
public final class bUA8L {

    /* renamed from: a  reason: collision with root package name */
    public int f26248a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f26249c;
    public String d;
    public int e;

    public bUA8L(int i, int i2, String str, int i3, int i4) {
        this.f26248a = i;
        this.b = i2;
        this.d = str;
        this.f26249c = i3;
        this.e = i4;
    }

    public final String toString() {
        String format = String.format("% 6d", Integer.valueOf(this.f26248a));
        String format2 = String.format("% 6d", Integer.valueOf(this.b));
        String format3 = String.format("% 6d", Integer.valueOf(this.f26249c));
        return "" + format + "    " + format2 + "    " + format3 + "    " + this.d;
    }
}
