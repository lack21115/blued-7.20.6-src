package com.tencent.bugly.proguard;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/proguard/aj.class */
public final class aj extends k implements Cloneable {
    private static byte[] d;

    /* renamed from: a  reason: collision with root package name */
    private byte f21675a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f21676c;

    public aj() {
        this.f21675a = (byte) 0;
        this.b = "";
        this.f21676c = null;
    }

    public aj(byte b, String str, byte[] bArr) {
        this.f21675a = (byte) 0;
        this.b = "";
        this.f21676c = null;
        this.f21675a = b;
        this.b = str;
        this.f21676c = bArr;
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.f21675a = iVar.a(this.f21675a, 0, true);
        this.b = iVar.b(1, true);
        if (d == null) {
            d = r0;
            byte[] bArr = {0};
        }
        this.f21676c = iVar.c(2, false);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f21675a, 0);
        jVar.a(this.b, 1);
        byte[] bArr = this.f21676c;
        if (bArr != null) {
            jVar.a(bArr, 2);
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb, int i) {
    }
}
