package com.xiaomi.push;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/jm.class */
public abstract class jm {
    public int a() {
        return 0;
    }

    public abstract int a(byte[] bArr, int i, int i2);

    public void a(int i) {
    }

    /* renamed from: a */
    public abstract void mo12057a(byte[] bArr, int i, int i2);

    /* renamed from: a */
    public byte[] mo12058a() {
        return null;
    }

    public int b() {
        return -1;
    }

    public int b(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return i4;
            }
            int a2 = a(bArr, i + i4, i2 - i4);
            if (a2 <= 0) {
                throw new jn("Cannot read. Remote side has closed. Tried to read " + i2 + " bytes, but only got " + i4 + " bytes.");
            }
            i3 = i4 + a2;
        }
    }
}
