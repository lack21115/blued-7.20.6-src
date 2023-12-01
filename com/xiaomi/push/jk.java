package com.xiaomi.push;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/jk.class */
public class jk extends jm {

    /* renamed from: a  reason: collision with root package name */
    private int f41554a;

    /* renamed from: a  reason: collision with other field name */
    private iu f893a;

    public jk(int i) {
        this.f893a = new iu(i);
    }

    @Override // com.xiaomi.push.jm
    public int a(byte[] bArr, int i, int i2) {
        byte[] m12027a = this.f893a.m12027a();
        int i3 = i2;
        if (i2 > this.f893a.a() - this.f41554a) {
            i3 = this.f893a.a() - this.f41554a;
        }
        if (i3 > 0) {
            System.arraycopy((Object) m12027a, this.f41554a, (Object) bArr, i, i3);
            this.f41554a += i3;
        }
        return i3;
    }

    @Override // com.xiaomi.push.jm
    /* renamed from: a */
    public void mo12057a(byte[] bArr, int i, int i2) {
        this.f893a.write(bArr, i, i2);
    }

    public int a_() {
        return this.f893a.size();
    }
}
