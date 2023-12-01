package com.huawei.hms.hatool;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/q0.class */
public class q0 {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f22789a;
    public int b = 0;

    public q0(int i) {
        this.f22789a = null;
        this.f22789a = new byte[i];
    }

    public void a(byte[] bArr, int i) {
        if (i <= 0) {
            return;
        }
        byte[] bArr2 = this.f22789a;
        int length = bArr2.length;
        int i2 = this.b;
        if (length - i2 >= i) {
            System.arraycopy((Object) bArr, 0, (Object) bArr2, i2, i);
        } else {
            byte[] bArr3 = new byte[(bArr2.length + i) << 1];
            System.arraycopy((Object) bArr2, 0, (Object) bArr3, 0, i2);
            System.arraycopy((Object) bArr, 0, (Object) bArr3, this.b, i);
            this.f22789a = bArr3;
        }
        this.b += i;
    }

    public byte[] a() {
        int i = this.b;
        if (i <= 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i];
        System.arraycopy((Object) this.f22789a, 0, (Object) bArr, 0, i);
        return bArr;
    }

    public int b() {
        return this.b;
    }
}
