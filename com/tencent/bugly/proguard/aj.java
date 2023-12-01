package com.tencent.bugly.proguard;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/proguard/aj.class */
public final class aj extends k implements Cloneable {
    private static byte[] d;

    /* renamed from: a  reason: collision with root package name */
    private byte f35366a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f35367c;

    public aj() {
        this.f35366a = (byte) 0;
        this.b = "";
        this.f35367c = null;
    }

    public aj(byte b, String str, byte[] bArr) {
        this.f35366a = (byte) 0;
        this.b = "";
        this.f35367c = null;
        this.f35366a = b;
        this.b = str;
        this.f35367c = bArr;
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.f35366a = iVar.a(this.f35366a, 0, true);
        this.b = iVar.b(1, true);
        if (d == null) {
            d = r0;
            byte[] bArr = {0};
        }
        this.f35367c = iVar.c(2, false);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f35366a, 0);
        jVar.a(this.b, 1);
        byte[] bArr = this.f35367c;
        if (bArr != null) {
            jVar.a(bArr, 2);
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb, int i) {
    }
}
