package com.umeng.analytics.pro;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/dd.class */
public abstract class dd {
    public abstract int a(byte[] bArr, int i, int i2) throws de;

    public void a(int i) {
    }

    public abstract boolean a();

    public abstract void b() throws de;

    public void b(byte[] bArr) throws de {
        b(bArr, 0, bArr.length);
    }

    public abstract void b(byte[] bArr, int i, int i2) throws de;

    public abstract void c();

    public int d(byte[] bArr, int i, int i2) throws de {
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return i4;
            }
            int a2 = a(bArr, i + i4, i2 - i4);
            if (a2 <= 0) {
                throw new de("Cannot read. Remote side has closed. Tried to read " + i2 + " bytes, but only got " + i4 + " bytes. (This is often indicative of an internal error on the server side. Please check your server logs.)");
            }
            i3 = i4 + a2;
        }
    }

    public void d() throws de {
    }

    public byte[] f() {
        return null;
    }

    public int g() {
        return 0;
    }

    public int h() {
        return -1;
    }

    public boolean i() {
        return a();
    }
}
