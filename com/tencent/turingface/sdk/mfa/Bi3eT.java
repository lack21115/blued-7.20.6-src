package com.tencent.turingface.sdk.mfa;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/Bi3eT.class */
public final class Bi3eT {

    /* renamed from: a  reason: collision with root package name */
    public int f39859a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public long f39860c;
    public String d;
    public int e;
    public int f;

    public Bi3eT(int i, int i2, long j, String str, int i3, int i4) {
        this.f39859a = i;
        this.b = i2;
        this.f39860c = j;
        this.d = str;
        this.e = i3;
        this.f = i4;
    }

    public static Bi3eT a(int i) {
        return new Bi3eT(i, 100, -1L, "", -1, -2);
    }

    public static Bi3eT a(int i, int i2) {
        return new Bi3eT(i, 200, -1L, "", -1, i2);
    }

    public final String toString() {
        return this.f39859a + BridgeUtil.UNDERLINE_STR + this.b + BridgeUtil.UNDERLINE_STR + this.f39860c + BridgeUtil.UNDERLINE_STR + this.e + BridgeUtil.UNDERLINE_STR + this.d + BridgeUtil.UNDERLINE_STR + this.f;
    }
}
