package com.umeng.analytics.pro;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/dc.class */
public final class dc extends dd {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f27028a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f27029c;

    public dc() {
    }

    public dc(byte[] bArr) {
        a(bArr);
    }

    public dc(byte[] bArr, int i, int i2) {
        c(bArr, i, i2);
    }

    @Override // com.umeng.analytics.pro.dd
    public int a(byte[] bArr, int i, int i2) throws de {
        int h = h();
        int i3 = i2;
        if (i2 > h) {
            i3 = h;
        }
        if (i3 > 0) {
            System.arraycopy(this.f27028a, this.b, bArr, i, i3);
            a(i3);
        }
        return i3;
    }

    @Override // com.umeng.analytics.pro.dd
    public void a(int i) {
        this.b += i;
    }

    public void a(byte[] bArr) {
        c(bArr, 0, bArr.length);
    }

    @Override // com.umeng.analytics.pro.dd
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.dd
    public void b() throws de {
    }

    @Override // com.umeng.analytics.pro.dd
    public void b(byte[] bArr, int i, int i2) throws de {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.umeng.analytics.pro.dd
    public void c() {
    }

    public void c(byte[] bArr, int i, int i2) {
        this.f27028a = bArr;
        this.b = i;
        this.f27029c = i + i2;
    }

    public void e() {
        this.f27028a = null;
    }

    @Override // com.umeng.analytics.pro.dd
    public byte[] f() {
        return this.f27028a;
    }

    @Override // com.umeng.analytics.pro.dd
    public int g() {
        return this.b;
    }

    @Override // com.umeng.analytics.pro.dd
    public int h() {
        return this.f27029c - this.b;
    }
}
