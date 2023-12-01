package com.tencent.mapsdk.internal;

import java.io.UnsupportedEncodingException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/fc.class */
public class fc implements hc {
    private int g;
    private byte[] h;

    public fc(byte[] bArr) {
        a(bArr);
    }

    private long b(int i) {
        long j = 0;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            j |= (b() & 255) << (i2 * 8);
        }
        return j;
    }

    public void a(int i) {
        this.g -= i;
    }

    public void a(byte[] bArr) {
        this.h = bArr;
        this.g = 0;
    }

    public boolean a() {
        return b() != 0;
    }

    public byte b() {
        int i;
        byte[] bArr = this.h;
        if (bArr == null || (i = this.g) >= bArr.length) {
            return (byte) 0;
        }
        this.g = i + 1;
        return bArr[i];
    }

    public char c() {
        long j = 0;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 2) {
                return (char) j;
            }
            j |= (b() & 255) << (i2 * 8);
            i = i2 + 1;
        }
    }

    public byte[] c(int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return bArr;
            }
            bArr[i3] = b();
            i2 = i3 + 1;
        }
    }

    public int d() {
        return (int) b(4);
    }

    public String d(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= (i >> 1)) {
                return stringBuffer.toString();
            }
            stringBuffer.append(c());
            i2 = i3 + 1;
        }
    }

    public void e(int i) {
        this.g += i;
    }

    public byte[] e() {
        byte[] bArr = this.h;
        int length = bArr.length;
        int i = this.g;
        int i2 = length - i;
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public long f() {
        return b(8);
    }

    public int g() {
        return this.g;
    }

    public int h() {
        return (int) b(2);
    }

    public String i() {
        int h = h();
        if (h == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= h) {
                return stringBuffer.toString();
            }
            stringBuffer.append(c());
            i = i2 + 1;
        }
    }

    public String j() {
        int h = h();
        if (h == 0) {
            return "";
        }
        try {
            return new String(c(h), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public boolean k() {
        return this.g == this.h.length - 1;
    }
}
