package com.opos.exoplayer.core.i;

import java.nio.charset.Charset;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/i/m.class */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f11808a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f11809c;

    public m() {
    }

    public m(int i) {
        this.f11808a = new byte[i];
        this.f11809c = i;
    }

    public m(byte[] bArr) {
        this.f11808a = bArr;
        this.f11809c = bArr.length;
    }

    public m(byte[] bArr, int i) {
        this.f11808a = bArr;
        this.f11809c = i;
    }

    public long A() {
        int i;
        int i2;
        byte b;
        int i3;
        long j = this.f11808a[this.b];
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
        if (i2 == 0) {
            throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j);
        }
        for (i = 1; i < i2; i++) {
            if ((this.f11808a[this.b + i] & 192) != 128) {
                throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j);
            }
            j = (j << 6) | (b & 63);
        }
        this.b += i2;
        return j;
    }

    public String a(int i, Charset charset) {
        String str = new String(this.f11808a, this.b, i, charset);
        this.b += i;
        return str;
    }

    public void a() {
        this.b = 0;
        this.f11809c = 0;
    }

    public void a(int i) {
        a(e() < i ? new byte[i] : this.f11808a, i);
    }

    public void a(l lVar, int i) {
        a(lVar.f11806a, 0, i);
        lVar.a(0);
    }

    public void a(byte[] bArr, int i) {
        this.f11808a = bArr;
        this.f11809c = i;
        this.b = 0;
    }

    public void a(byte[] bArr, int i, int i2) {
        System.arraycopy(this.f11808a, this.b, bArr, i, i2);
        this.b += i2;
    }

    public int b() {
        return this.f11809c - this.b;
    }

    public void b(int i) {
        a.a(i >= 0 && i <= this.f11808a.length);
        this.f11809c = i;
    }

    public int c() {
        return this.f11809c;
    }

    public void c(int i) {
        a.a(i >= 0 && i <= this.f11809c);
        this.b = i;
    }

    public int d() {
        return this.b;
    }

    public void d(int i) {
        c(this.b + i);
    }

    public int e() {
        byte[] bArr = this.f11808a;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public String e(int i) {
        return a(i, Charset.forName("UTF-8"));
    }

    public char f() {
        byte[] bArr = this.f11808a;
        int i = this.b;
        return (char) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    public String f(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = (this.b + i) - 1;
        String str = new String(this.f11808a, this.b, (i2 >= this.f11809c || this.f11808a[i2] != 0) ? i : i - 1);
        this.b += i;
        return str;
    }

    public int g() {
        byte[] bArr = this.f11808a;
        int i = this.b;
        this.b = i + 1;
        return bArr[i] & 255;
    }

    public int h() {
        byte[] bArr = this.f11808a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        byte b = bArr[i];
        this.b = i2 + 1;
        return (bArr[i2] & 255) | ((b & 255) << 8);
    }

    public int i() {
        byte[] bArr = this.f11808a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        byte b = bArr[i];
        this.b = i2 + 1;
        return ((bArr[i2] & 255) << 8) | (b & 255);
    }

    public short j() {
        byte[] bArr = this.f11808a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        byte b = bArr[i];
        this.b = i2 + 1;
        return (short) ((bArr[i2] & 255) | ((b & 255) << 8));
    }

    public int k() {
        byte[] bArr = this.f11808a;
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

    public int l() {
        byte[] bArr = this.f11808a;
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

    public long m() {
        byte[] bArr = this.f11808a;
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
        return (bArr[i4] & 255) | ((j & 255) << 24) | ((j2 & 255) << 16) | ((j3 & 255) << 8);
    }

    public long n() {
        byte[] bArr = this.f11808a;
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
        return ((bArr[i4] & 255) << 24) | (j & 255) | ((j2 & 255) << 8) | ((j3 & 255) << 16);
    }

    public int o() {
        byte[] bArr = this.f11808a;
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

    public int p() {
        byte[] bArr = this.f11808a;
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

    public long q() {
        byte[] bArr = this.f11808a;
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
        return (255 & bArr[i8]) | ((j & 255) << 56) | ((j2 & 255) << 48) | ((j3 & 255) << 40) | ((j4 & 255) << 32) | ((j5 & 255) << 24) | ((j6 & 255) << 16) | ((j7 & 255) << 8);
    }

    public long r() {
        byte[] bArr = this.f11808a;
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
        return ((255 & bArr[i8]) << 56) | (j & 255) | ((j2 & 255) << 8) | ((j3 & 255) << 16) | ((j4 & 255) << 24) | ((j5 & 255) << 32) | ((j6 & 255) << 40) | ((j7 & 255) << 48);
    }

    public int s() {
        byte[] bArr = this.f11808a;
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

    public int t() {
        return (g() << 21) | (g() << 14) | (g() << 7) | g();
    }

    public int u() {
        int o = o();
        if (o >= 0) {
            return o;
        }
        throw new IllegalStateException("Top bit not zero: " + o);
    }

    public int v() {
        int p = p();
        if (p >= 0) {
            return p;
        }
        throw new IllegalStateException("Top bit not zero: " + p);
    }

    public long w() {
        long q = q();
        if (q >= 0) {
            return q;
        }
        throw new IllegalStateException("Top bit not zero: " + q);
    }

    public double x() {
        return Double.longBitsToDouble(q());
    }

    public String y() {
        int i;
        if (b() == 0) {
            return null;
        }
        int i2 = this.b;
        while (true) {
            i = i2;
            if (i >= this.f11809c || this.f11808a[i] == 0) {
                break;
            }
            i2 = i + 1;
        }
        byte[] bArr = this.f11808a;
        int i3 = this.b;
        String str = new String(bArr, i3, i - i3);
        this.b = i;
        if (i < this.f11809c) {
            this.b = i + 1;
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x009c, code lost:
        if (r0 == r0) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String z() {
        /*
            Method dump skipped, instructions count: 191
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.i.m.z():java.lang.String");
    }
}
