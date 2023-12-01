package com.anythink.expressad.exoplayer.k;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k/r.class */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f4833a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f4834c;
    private int d;

    public r() {
    }

    public r(byte[] bArr) {
        this(bArr, bArr.length);
    }

    private r(byte[] bArr, int i) {
        this.f4833a = bArr;
        this.d = i;
    }

    private void a(s sVar) {
        a(sVar.f4835a, sVar.b());
        a(sVar.c() * 8);
    }

    private void a(byte[] bArr) {
        a(bArr, bArr.length);
    }

    private void a(byte[] bArr, int i, int i2) {
        int i3 = (i2 >> 3) + i;
        while (i < i3) {
            byte[] bArr2 = this.f4833a;
            int i4 = this.b;
            int i5 = i4 + 1;
            this.b = i5;
            byte b = bArr2[i4];
            int i6 = this.f4834c;
            bArr[i] = (byte) (b << i6);
            bArr[i] = (byte) (((255 & bArr2[i5]) >> (8 - i6)) | bArr[i]);
            i++;
        }
        int i7 = i2 & 7;
        if (i7 == 0) {
            return;
        }
        bArr[i3] = (byte) (bArr[i3] & (255 >> i7));
        int i8 = this.f4834c;
        if (i8 + i7 > 8) {
            byte b2 = bArr[i3];
            byte[] bArr3 = this.f4833a;
            int i9 = this.b;
            this.b = i9 + 1;
            bArr[i3] = (byte) (b2 | ((bArr3[i9] & 255) << i8));
            this.f4834c = i8 - 8;
        }
        int i10 = this.f4834c + i7;
        this.f4834c = i10;
        byte[] bArr4 = this.f4833a;
        int i11 = this.b;
        bArr[i3] = (byte) (((byte) (((255 & bArr4[i11]) >> (8 - i10)) << (8 - i7))) | bArr[i3]);
        if (i10 == 8) {
            this.f4834c = 0;
            this.b = i11 + 1;
        }
        g();
    }

    private void b(byte[] bArr, int i, int i2) {
        a.b(this.f4834c == 0);
        System.arraycopy(this.f4833a, this.b, bArr, i, i2);
        this.b += i2;
        g();
    }

    private void e(int i) {
        a.b(this.f4834c == 0);
        this.b += i;
        g();
    }

    private int f() {
        a.b(this.f4834c == 0);
        return this.b;
    }

    private void g() {
        int i;
        int i2 = this.b;
        a.b(i2 >= 0 && (i2 < (i = this.d) || (i2 == i && this.f4834c == 0)));
    }

    public final int a() {
        return ((this.d - this.b) * 8) - this.f4834c;
    }

    public final void a(int i) {
        int i2 = i / 8;
        this.b = i2;
        this.f4834c = i - (i2 * 8);
        g();
    }

    public final void a(byte[] bArr, int i) {
        this.f4833a = bArr;
        this.b = 0;
        this.f4834c = 0;
        this.d = i;
    }

    public final int b() {
        return (this.b * 8) + this.f4834c;
    }

    public final void b(int i) {
        int i2 = i / 8;
        int i3 = this.b + i2;
        this.b = i3;
        int i4 = this.f4834c + (i - (i2 * 8));
        this.f4834c = i4;
        if (i4 > 7) {
            this.b = i3 + 1;
            this.f4834c = i4 - 8;
        }
        g();
    }

    public final int c(int i) {
        int i2;
        int i3;
        if (i == 0) {
            return 0;
        }
        this.f4834c += i;
        int i4 = 0;
        while (true) {
            i2 = i4;
            i3 = this.f4834c;
            if (i3 <= 8) {
                break;
            }
            int i5 = i3 - 8;
            this.f4834c = i5;
            byte[] bArr = this.f4833a;
            int i6 = this.b;
            this.b = i6 + 1;
            i4 = i2 | ((bArr[i6] & 255) << i5);
        }
        byte[] bArr2 = this.f4833a;
        int i7 = this.b;
        byte b = bArr2[i7];
        if (i3 == 8) {
            this.f4834c = 0;
            this.b = i7 + 1;
        }
        g();
        return ((-1) >>> (32 - i)) & (i2 | ((b & 255) >> (8 - i3)));
    }

    public final void c() {
        int i = this.f4834c + 1;
        this.f4834c = i;
        if (i == 8) {
            this.f4834c = 0;
            this.b++;
        }
        g();
    }

    public final void d(int i) {
        int i2 = i & 16383;
        int min = Math.min(8 - this.f4834c, 14);
        int i3 = this.f4834c;
        int i4 = (8 - i3) - min;
        byte[] bArr = this.f4833a;
        int i5 = this.b;
        bArr[i5] = (byte) (((65280 >> i3) | ((1 << i4) - 1)) & bArr[i5]);
        int i6 = 14 - min;
        bArr[i5] = (byte) (((i2 >>> i6) << i4) | bArr[i5]);
        int i7 = i5;
        while (true) {
            int i8 = i7 + 1;
            if (i6 <= 8) {
                int i9 = 8 - i6;
                byte[] bArr2 = this.f4833a;
                bArr2[i8] = (byte) (bArr2[i8] & ((1 << i9) - 1));
                bArr2[i8] = (byte) (((i2 & ((1 << i6) - 1)) << i9) | bArr2[i8]);
                b(14);
                g();
                return;
            }
            this.f4833a[i8] = (byte) (i2 >>> (i6 - 8));
            i6 -= 8;
            i7 = i8;
        }
    }

    public final boolean d() {
        boolean z = (this.f4833a[this.b] & (128 >> this.f4834c)) != 0;
        c();
        return z;
    }

    public final void e() {
        if (this.f4834c == 0) {
            return;
        }
        this.f4834c = 0;
        this.b++;
        g();
    }
}
