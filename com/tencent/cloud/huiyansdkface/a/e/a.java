package com.tencent.cloud.huiyansdkface.a.e;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/e/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.a.a.d f21786a;
    private byte[] b;

    /* renamed from: c  reason: collision with root package name */
    private int f21787c;
    private int d;
    private com.tencent.cloud.huiyansdkface.a.a.a.a e;

    public a(com.tencent.cloud.huiyansdkface.a.a.a.d dVar, byte[] bArr, int i, int i2, com.tencent.cloud.huiyansdkface.a.a.a.a aVar) {
        this.f21786a = dVar;
        this.b = bArr;
        this.f21787c = i2;
        this.d = i;
        this.e = aVar;
    }

    public void a() {
        this.b = (byte[]) this.b.clone();
    }

    public com.tencent.cloud.huiyansdkface.a.a.a.d b() {
        return this.f21786a;
    }

    public byte[] c() {
        return this.b;
    }
}
