package com.xiaomi.push;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/jk.class */
public class jk extends jm {

    /* renamed from: a  reason: collision with root package name */
    private int f27863a;

    /* renamed from: a  reason: collision with other field name */
    private iu f846a;

    public jk(int i) {
        this.f846a = new iu(i);
    }

    @Override // com.xiaomi.push.jm
    public int a(byte[] bArr, int i, int i2) {
        byte[] m8977a = this.f846a.m8977a();
        int i3 = i2;
        if (i2 > this.f846a.a() - this.f27863a) {
            i3 = this.f846a.a() - this.f27863a;
        }
        if (i3 > 0) {
            System.arraycopy(m8977a, this.f27863a, bArr, i, i3);
            this.f27863a += i3;
        }
        return i3;
    }

    @Override // com.xiaomi.push.jm
    /* renamed from: a */
    public void mo9007a(byte[] bArr, int i, int i2) {
        this.f846a.write(bArr, i, i2);
    }

    public int a_() {
        return this.f846a.size();
    }
}
