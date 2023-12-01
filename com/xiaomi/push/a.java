package com.xiaomi.push;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f27550a = new a(new byte[0]);

    /* renamed from: a  reason: collision with other field name */
    private volatile int f120a = 0;

    /* renamed from: a  reason: collision with other field name */
    private final byte[] f121a;

    private a(byte[] bArr) {
        this.f121a = bArr;
    }

    public static a a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static a a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new a(bArr2);
    }

    public final int a() {
        return this.f121a.length;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final byte[] m8443a() {
        byte[] bArr = this.f121a;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        byte[] bArr = this.f121a;
        int length = bArr.length;
        byte[] bArr2 = ((a) obj).f121a;
        if (length != bArr2.length) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public final int hashCode() {
        int i = this.f120a;
        int i2 = i;
        if (i == 0) {
            byte[] bArr = this.f121a;
            i2 = bArr.length;
            for (byte b : bArr) {
                i2 = (i2 * 31) + b;
            }
            if (i2 == 0) {
                i2 = 1;
            }
            this.f120a = i2;
        }
        return i2;
    }
}
