package com.opos.exoplayer.core.i;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/i/l.class */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f25494a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f25495c;
    private int d;

    public l() {
    }

    public l(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public l(byte[] bArr, int i) {
        this.f25494a = bArr;
        this.d = i;
    }

    private void g() {
        int i;
        int i2 = this.b;
        a.b(i2 >= 0 && (i2 < (i = this.d) || (i2 == i && this.f25495c == 0)));
    }

    public int a() {
        return ((this.d - this.b) * 8) - this.f25495c;
    }

    public void a(int i) {
        int i2 = i / 8;
        this.b = i2;
        this.f25495c = i - (i2 * 8);
        g();
    }

    public void a(int i, int i2) {
        int i3 = i;
        if (i2 < 32) {
            i3 = i & ((1 << i2) - 1);
        }
        int min = Math.min(8 - this.f25495c, i2);
        int i4 = this.f25495c;
        int i5 = (8 - i4) - min;
        byte[] bArr = this.f25494a;
        int i6 = this.b;
        bArr[i6] = (byte) (((65280 >> i4) | ((1 << i5) - 1)) & bArr[i6]);
        int i7 = i2 - min;
        bArr[i6] = (byte) (((i3 >>> i7) << i5) | bArr[i6]);
        int i8 = i6;
        while (true) {
            int i9 = i8 + 1;
            if (i7 <= 8) {
                int i10 = 8 - i7;
                byte[] bArr2 = this.f25494a;
                bArr2[i9] = (byte) (bArr2[i9] & ((1 << i10) - 1));
                bArr2[i9] = (byte) (((i3 & ((1 << i7) - 1)) << i10) | bArr2[i9]);
                b(i2);
                g();
                return;
            }
            this.f25494a[i9] = (byte) (i3 >>> (i7 - 8));
            i7 -= 8;
            i8 = i9;
        }
    }

    public void a(byte[] bArr) {
        a(bArr, bArr.length);
    }

    public void a(byte[] bArr, int i) {
        this.f25494a = bArr;
        this.b = 0;
        this.f25495c = 0;
        this.d = i;
    }

    public void a(byte[] bArr, int i, int i2) {
        int i3 = (i2 >> 3) + i;
        while (i < i3) {
            byte[] bArr2 = this.f25494a;
            int i4 = this.b;
            int i5 = i4 + 1;
            this.b = i5;
            byte b = bArr2[i4];
            int i6 = this.f25495c;
            bArr[i] = (byte) (b << i6);
            bArr[i] = (byte) (((255 & bArr2[i5]) >> (8 - i6)) | bArr[i]);
            i++;
        }
        int i7 = i2 & 7;
        if (i7 == 0) {
            return;
        }
        bArr[i3] = (byte) (bArr[i3] & (255 >> i7));
        int i8 = this.f25495c;
        if (i8 + i7 > 8) {
            byte b2 = bArr[i3];
            byte[] bArr3 = this.f25494a;
            int i9 = this.b;
            this.b = i9 + 1;
            bArr[i3] = (byte) (b2 | ((byte) ((bArr3[i9] & 255) << i8)));
            this.f25495c = i8 - 8;
        }
        int i10 = this.f25495c + i7;
        this.f25495c = i10;
        byte[] bArr4 = this.f25494a;
        int i11 = this.b;
        bArr[i3] = (byte) (((byte) (((255 & bArr4[i11]) >> (8 - i10)) << (8 - i7))) | bArr[i3]);
        if (i10 == 8) {
            this.f25495c = 0;
            this.b = i11 + 1;
        }
        g();
    }

    public int b() {
        return (this.b * 8) + this.f25495c;
    }

    public void b(int i) {
        int i2 = i / 8;
        int i3 = this.b + i2;
        this.b = i3;
        int i4 = (i - (i2 * 8)) + this.f25495c;
        this.f25495c = i4;
        if (i4 > 7) {
            this.b = i3 + 1;
            this.f25495c = i4 - 8;
        }
        g();
    }

    public void b(byte[] bArr, int i, int i2) {
        a.b(this.f25495c == 0);
        System.arraycopy((Object) this.f25494a, this.b, (Object) bArr, i, i2);
        this.b += i2;
        g();
    }

    public int c() {
        a.b(this.f25495c == 0);
        return this.b;
    }

    public int c(int i) {
        int i2;
        int i3;
        if (i == 0) {
            return 0;
        }
        this.f25495c += i;
        int i4 = 0;
        while (true) {
            i2 = i4;
            i3 = this.f25495c;
            if (i3 <= 8) {
                break;
            }
            int i5 = i3 - 8;
            this.f25495c = i5;
            byte[] bArr = this.f25494a;
            int i6 = this.b;
            this.b = i6 + 1;
            i4 = i2 | ((bArr[i6] & 255) << i5);
        }
        byte[] bArr2 = this.f25494a;
        int i7 = this.b;
        byte b = bArr2[i7];
        if (i3 == 8) {
            this.f25495c = 0;
            this.b = i7 + 1;
        }
        g();
        return (((b & 255) >> (8 - i3)) | i2) & ((-1) >>> (32 - i));
    }

    public void d() {
        int i = this.f25495c + 1;
        this.f25495c = i;
        if (i == 8) {
            this.f25495c = 0;
            this.b++;
        }
        g();
    }

    public void d(int i) {
        a.b(this.f25495c == 0);
        this.b += i;
        g();
    }

    public boolean e() {
        boolean z = (this.f25494a[this.b] & (128 >> this.f25495c)) != 0;
        d();
        return z;
    }

    public void f() {
        if (this.f25495c == 0) {
            return;
        }
        this.f25495c = 0;
        this.b++;
        g();
    }
}
