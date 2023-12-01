package com.xiaomi.push;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/jl.class */
public final class jl extends jm {

    /* renamed from: a  reason: collision with root package name */
    private int f27864a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f847a;
    private int b;

    @Override // com.xiaomi.push.jm
    public final int a() {
        return this.f27864a;
    }

    @Override // com.xiaomi.push.jm
    public final int a(byte[] bArr, int i, int i2) {
        int b = b();
        int i3 = i2;
        if (i2 > b) {
            i3 = b;
        }
        if (i3 > 0) {
            System.arraycopy(this.f847a, this.f27864a, bArr, i, i3);
            a(i3);
        }
        return i3;
    }

    @Override // com.xiaomi.push.jm
    public final void a(int i) {
        this.f27864a += i;
    }

    public final void a(byte[] bArr) {
        b(bArr, 0, bArr.length);
    }

    @Override // com.xiaomi.push.jm
    /* renamed from: a */
    public final void mo9007a(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.xiaomi.push.jm
    /* renamed from: a  reason: collision with other method in class */
    public final byte[] mo9008a() {
        return this.f847a;
    }

    @Override // com.xiaomi.push.jm
    public final int b() {
        return this.b - this.f27864a;
    }

    public final void b(byte[] bArr, int i, int i2) {
        this.f847a = bArr;
        this.f27864a = i;
        this.b = i + i2;
    }
}
