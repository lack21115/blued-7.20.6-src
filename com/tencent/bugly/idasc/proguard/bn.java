package com.tencent.bugly.idasc.proguard;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/bn.class */
public final class bn extends m implements Cloneable {
    static byte[] d;

    /* renamed from: a  reason: collision with root package name */
    public byte f21610a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f21611c;

    public bn() {
        this.f21610a = (byte) 0;
        this.b = "";
        this.f21611c = null;
    }

    public bn(byte b, String str, byte[] bArr) {
        this.f21610a = (byte) 0;
        this.b = "";
        this.f21611c = null;
        this.f21610a = b;
        this.b = str;
        this.f21611c = bArr;
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(k kVar) {
        this.f21610a = kVar.a(this.f21610a, 0, true);
        this.b = kVar.b(1, true);
        if (d == null) {
            d = r0;
            byte[] bArr = {0};
        }
        this.f21611c = kVar.c(2, false);
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f21610a, 0);
        lVar.a(this.b, 1);
        byte[] bArr = this.f21611c;
        if (bArr != null) {
            lVar.a(bArr, 2);
        }
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(StringBuilder sb, int i) {
    }
}
