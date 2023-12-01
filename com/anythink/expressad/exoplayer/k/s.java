package com.anythink.expressad.exoplayer.k;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k/s.class */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f7674a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f7675c;

    public s() {
    }

    public s(int i) {
        this.f7674a = new byte[i];
        this.f7675c = i;
    }

    public s(byte[] bArr) {
        this.f7674a = bArr;
        this.f7675c = bArr.length;
    }

    public s(byte[] bArr, int i) {
        this.f7674a = bArr;
        this.f7675c = i;
    }

    private int A() {
        byte[] bArr = this.f7674a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.b = i3;
        byte b2 = bArr[i2];
        int i4 = i3 + 1;
        this.b = i4;
        byte b3 = bArr[i3];
        this.b = i4 + 1;
        return ((bArr[i4] & 255) << 24) | (b & 255) | ((b2 & 255) << 8) | ((b3 & 255) << 16);
    }

    private long B() {
        byte[] bArr = this.f7674a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        long j = bArr[i];
        int i3 = i2 + 1;
        this.b = i3;
        long j2 = bArr[i2];
        int i4 = i3 + 1;
        this.b = i4;
        long j3 = bArr[i3];
        int i5 = i4 + 1;
        this.b = i5;
        long j4 = bArr[i4];
        int i6 = i5 + 1;
        this.b = i6;
        long j5 = bArr[i5];
        int i7 = i6 + 1;
        this.b = i7;
        long j6 = bArr[i6];
        int i8 = i7 + 1;
        this.b = i8;
        long j7 = bArr[i7];
        this.b = i8 + 1;
        return (j & 255) | ((j2 & 255) << 8) | ((j3 & 255) << 16) | ((j4 & 255) << 24) | ((j5 & 255) << 32) | ((j6 & 255) << 40) | ((j7 & 255) << 48) | ((bArr[i8] & 255) << 56);
    }

    private int C() {
        byte[] bArr = this.f7674a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.b = i3;
        byte b2 = bArr[i2];
        int i4 = i3 + 1;
        this.b = i4;
        byte b3 = bArr[i3];
        this.b = i4 + 1;
        int i5 = ((bArr[i4] & 255) << 24) | (b & 255) | ((b2 & 255) << 8) | ((b3 & 255) << 16);
        if (i5 >= 0) {
            return i5;
        }
        throw new IllegalStateException("Top bit not zero: ".concat(String.valueOf(i5)));
    }

    private float D() {
        return Float.intBitsToFloat(i());
    }

    private double E() {
        return Double.longBitsToDouble(j());
    }

    private String F() {
        int i;
        if (a() == 0) {
            return null;
        }
        int i2 = this.b;
        while (true) {
            i = i2;
            if (i >= this.f7675c || af.a((int) this.f7674a[i])) {
                break;
            }
            i2 = i + 1;
        }
        int i3 = this.b;
        if (i - i3 >= 3) {
            byte[] bArr = this.f7674a;
            if (bArr[i3] == -17 && bArr[i3 + 1] == -69 && bArr[i3 + 2] == -65) {
                this.b = i3 + 3;
            }
        }
        byte[] bArr2 = this.f7674a;
        int i4 = this.b;
        String a2 = af.a(bArr2, i4, i - i4);
        this.b = i;
        int i5 = this.f7675c;
        if (i == i5) {
            return a2;
        }
        if (this.f7674a[i] == 13) {
            int i6 = i + 1;
            this.b = i6;
            if (i6 == i5) {
                return a2;
            }
        }
        byte[] bArr3 = this.f7674a;
        int i7 = this.b;
        if (bArr3[i7] == 10) {
            this.b = i7 + 1;
        }
        return a2;
    }

    private long G() {
        int i;
        int i2;
        byte b;
        int i3;
        long j = this.f7674a[this.b];
        int i4 = 7;
        while (true) {
            int i5 = i4;
            if (i5 < 0) {
                break;
            }
            if (((1 << i5) & j) != 0) {
                i4 = i5 - 1;
            } else if (i5 < 6) {
                j &= i3 - 1;
                i2 = 7 - i5;
            } else if (i5 == 7) {
                i2 = 1;
            }
        }
        i2 = 0;
        if (i2 != 0) {
            for (i = 1; i < i2; i++) {
                if ((this.f7674a[this.b + i] & 192) != 128) {
                    throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: ".concat(String.valueOf(j)));
                }
                j = (j << 6) | (b & 63);
            }
            this.b += i2;
            return j;
        }
        throw new NumberFormatException("Invalid UTF-8 sequence first byte: ".concat(String.valueOf(j)));
    }

    private String a(Charset charset) {
        String str = new String(this.f7674a, this.b, 4, charset);
        this.b += 4;
        return str;
    }

    private void a(r rVar, int i) {
        a(rVar.f7672a, 0, i);
        rVar.a(0);
    }

    private void a(ByteBuffer byteBuffer, int i) {
        byteBuffer.put(this.f7674a, this.b, i);
        this.b += i;
    }

    private void q() {
        this.b = 0;
        this.f7675c = 0;
    }

    private int r() {
        byte[] bArr = this.f7674a;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    private int s() {
        return this.f7674a[this.b] & 255;
    }

    private char t() {
        byte[] bArr = this.f7674a;
        int i = this.b;
        return (char) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    private int u() {
        byte[] bArr = this.f7674a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        byte b = bArr[i];
        this.b = i2 + 1;
        return ((bArr[i2] & 255) << 8) | (b & 255);
    }

    private short v() {
        byte[] bArr = this.f7674a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        byte b = bArr[i];
        this.b = i2 + 1;
        return (short) (((bArr[i2] & 255) << 8) | (b & 255));
    }

    private int w() {
        byte[] bArr = this.f7674a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.b = i3;
        byte b2 = bArr[i2];
        this.b = i3 + 1;
        return (bArr[i3] & 255) | (((b & 255) << 24) >> 8) | ((b2 & 255) << 8);
    }

    private int x() {
        byte[] bArr = this.f7674a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.b = i3;
        byte b2 = bArr[i2];
        this.b = i3 + 1;
        return ((bArr[i3] & 255) << 16) | (b & 255) | ((b2 & 255) << 8);
    }

    private int y() {
        byte[] bArr = this.f7674a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.b = i3;
        byte b2 = bArr[i2];
        this.b = i3 + 1;
        return ((bArr[i3] & 255) << 16) | (b & 255) | ((b2 & 255) << 8);
    }

    private long z() {
        byte[] bArr = this.f7674a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        long j = bArr[i];
        int i3 = i2 + 1;
        this.b = i3;
        long j2 = bArr[i2];
        int i4 = i3 + 1;
        this.b = i4;
        long j3 = bArr[i3];
        this.b = i4 + 1;
        return (j & 255) | ((j2 & 255) << 8) | ((j3 & 255) << 16) | ((bArr[i4] & 255) << 24);
    }

    public final int a() {
        return this.f7675c - this.b;
    }

    public final void a(int i) {
        byte[] bArr = this.f7674a;
        a((bArr == null ? 0 : bArr.length) < i ? new byte[i] : this.f7674a, i);
    }

    public final void a(byte[] bArr, int i) {
        this.f7674a = bArr;
        this.f7675c = i;
        this.b = 0;
    }

    public final void a(byte[] bArr, int i, int i2) {
        System.arraycopy((Object) this.f7674a, this.b, (Object) bArr, i, i2);
        this.b += i2;
    }

    public final int b() {
        return this.f7675c;
    }

    public final void b(int i) {
        a.a(i >= 0 && i <= this.f7674a.length);
        this.f7675c = i;
    }

    public final int c() {
        return this.b;
    }

    public final void c(int i) {
        a.a(i >= 0 && i <= this.f7675c);
        this.b = i;
    }

    public final int d() {
        byte[] bArr = this.f7674a;
        int i = this.b;
        this.b = i + 1;
        return bArr[i] & 255;
    }

    public final void d(int i) {
        c(this.b + i);
    }

    public final int e() {
        byte[] bArr = this.f7674a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        byte b = bArr[i];
        this.b = i2 + 1;
        return (bArr[i2] & 255) | ((b & 255) << 8);
    }

    public final String e(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = (this.b + i) - 1;
        String a2 = af.a(this.f7674a, this.b, (i2 >= this.f7675c || this.f7674a[i2] != 0) ? i : i - 1);
        this.b += i;
        return a2;
    }

    public final short f() {
        byte[] bArr = this.f7674a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        byte b = bArr[i];
        this.b = i2 + 1;
        return (short) ((bArr[i2] & 255) | ((b & 255) << 8));
    }

    public final int g() {
        byte[] bArr = this.f7674a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.b = i3;
        byte b2 = bArr[i2];
        this.b = i3 + 1;
        return (bArr[i3] & 255) | ((b & 255) << 16) | ((b2 & 255) << 8);
    }

    public final long h() {
        byte[] bArr = this.f7674a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        long j = bArr[i];
        int i3 = i2 + 1;
        this.b = i3;
        long j2 = bArr[i2];
        int i4 = i3 + 1;
        this.b = i4;
        long j3 = bArr[i3];
        this.b = i4 + 1;
        return ((j & 255) << 24) | ((j2 & 255) << 16) | ((j3 & 255) << 8) | (bArr[i4] & 255);
    }

    public final int i() {
        byte[] bArr = this.f7674a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.b = i3;
        byte b2 = bArr[i2];
        int i4 = i3 + 1;
        this.b = i4;
        byte b3 = bArr[i3];
        this.b = i4 + 1;
        return (bArr[i4] & 255) | ((b & 255) << 24) | ((b2 & 255) << 16) | ((b3 & 255) << 8);
    }

    public final long j() {
        byte[] bArr = this.f7674a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        long j = bArr[i];
        int i3 = i2 + 1;
        this.b = i3;
        long j2 = bArr[i2];
        int i4 = i3 + 1;
        this.b = i4;
        long j3 = bArr[i3];
        int i5 = i4 + 1;
        this.b = i5;
        long j4 = bArr[i4];
        int i6 = i5 + 1;
        this.b = i6;
        long j5 = bArr[i5];
        int i7 = i6 + 1;
        this.b = i7;
        long j6 = bArr[i6];
        int i8 = i7 + 1;
        this.b = i8;
        long j7 = bArr[i7];
        this.b = i8 + 1;
        return ((j & 255) << 56) | ((j2 & 255) << 48) | ((j3 & 255) << 40) | ((j4 & 255) << 32) | ((j5 & 255) << 24) | ((j6 & 255) << 16) | ((j7 & 255) << 8) | (bArr[i8] & 255);
    }

    public final int k() {
        byte[] bArr = this.f7674a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.b = i3;
        byte b2 = bArr[i2];
        this.b = i3 + 2;
        return (b2 & 255) | ((b & 255) << 8);
    }

    public final int l() {
        return (d() << 21) | (d() << 14) | (d() << 7) | d();
    }

    public final int m() {
        int i = i();
        if (i >= 0) {
            return i;
        }
        throw new IllegalStateException("Top bit not zero: ".concat(String.valueOf(i)));
    }

    public final long n() {
        long j = j();
        if (j >= 0) {
            return j;
        }
        throw new IllegalStateException("Top bit not zero: ".concat(String.valueOf(j)));
    }

    public final String o() {
        String str = new String(this.f7674a, this.b, 4, Charset.forName("UTF-8"));
        this.b += 4;
        return str;
    }

    public final String p() {
        int i;
        if (a() == 0) {
            return null;
        }
        int i2 = this.b;
        while (true) {
            i = i2;
            if (i >= this.f7675c || this.f7674a[i] == 0) {
                break;
            }
            i2 = i + 1;
        }
        byte[] bArr = this.f7674a;
        int i3 = this.b;
        String a2 = af.a(bArr, i3, i - i3);
        this.b = i;
        if (i < this.f7675c) {
            this.b = i + 1;
        }
        return a2;
    }
}
