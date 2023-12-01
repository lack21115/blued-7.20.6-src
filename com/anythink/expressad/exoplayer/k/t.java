package com.anythink.expressad.exoplayer.k;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k/t.class */
public final class t {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f7676a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f7677c;
    private int d = 0;

    public t(byte[] bArr, int i, int i2) {
        this.f7676a = bArr;
        this.f7677c = i;
        this.b = i2;
        g();
    }

    private void a(byte[] bArr, int i, int i2) {
        this.f7676a = bArr;
        this.f7677c = i;
        this.b = i2;
        this.d = 0;
        g();
    }

    private boolean c(int i) {
        int i2 = this.f7677c;
        int i3 = i / 8;
        int i4 = i2 + i3;
        int i5 = (this.d + i) - (i3 * 8);
        int i6 = i4;
        int i7 = i5;
        if (i5 > 7) {
            i6 = i4 + 1;
            i7 = i5 - 8;
        }
        boolean z = true;
        int i8 = i6;
        int i9 = i2;
        while (true) {
            int i10 = i9 + 1;
            if (i10 > i8 || i8 >= this.b) {
                break;
            }
            i9 = i10;
            if (d(i10)) {
                i8++;
                i9 = i10 + 2;
            }
        }
        int i11 = this.b;
        if (i8 >= i11) {
            if (i8 == i11 && i7 == 0) {
                return true;
            }
            z = false;
        }
        return z;
    }

    private boolean d(int i) {
        if (2 > i || i >= this.b) {
            return false;
        }
        byte[] bArr = this.f7676a;
        return bArr[i] == 3 && bArr[i - 2] == 0 && bArr[i - 1] == 0;
    }

    private boolean e() {
        int i;
        int i2 = this.f7677c;
        int i3 = this.d;
        int i4 = 0;
        while (true) {
            i = i4;
            if (this.f7677c >= this.b || b()) {
                break;
            }
            i4 = i + 1;
        }
        boolean z = this.f7677c == this.b;
        this.f7677c = i2;
        this.d = i3;
        if (z) {
            return false;
        }
        int i5 = (i * 2) + 1;
        int i6 = i5 / 8;
        int i7 = i2 + i6;
        int i8 = (i3 + i5) - (i6 * 8);
        int i9 = i2;
        int i10 = i8;
        int i11 = i7;
        if (i8 > 7) {
            i11 = i7 + 1;
            i10 = i8 - 8;
            i9 = i2;
        }
        while (true) {
            int i12 = i9 + 1;
            if (i12 > i11 || i11 >= this.b) {
                break;
            }
            i9 = i12;
            if (d(i12)) {
                i11++;
                i9 = i12 + 2;
            }
        }
        int i13 = this.b;
        return i11 < i13 || (i11 == i13 && i10 == 0);
    }

    private int f() {
        int i;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = i3;
            if (b()) {
                break;
            }
            i3 = i + 1;
        }
        if (i > 0) {
            i2 = b(i);
        }
        return ((1 << i) - 1) + i2;
    }

    private void g() {
        int i;
        int i2 = this.f7677c;
        a.b(i2 >= 0 && (i2 < (i = this.b) || (i2 == i && this.d == 0)));
    }

    public final void a() {
        int i = 1;
        int i2 = this.d + 1;
        this.d = i2;
        if (i2 == 8) {
            this.d = 0;
            int i3 = this.f7677c;
            if (d(i3 + 1)) {
                i = 2;
            }
            this.f7677c = i3 + i;
        }
        g();
    }

    public final void a(int i) {
        int i2 = this.f7677c;
        int i3 = i / 8;
        int i4 = i2 + i3;
        this.f7677c = i4;
        int i5 = this.d + (i - (i3 * 8));
        this.d = i5;
        int i6 = i2;
        if (i5 > 7) {
            this.f7677c = i4 + 1;
            this.d = i5 - 8;
            i6 = i2;
        }
        while (true) {
            int i7 = i6 + 1;
            if (i7 > this.f7677c) {
                g();
                return;
            }
            i6 = i7;
            if (d(i7)) {
                this.f7677c++;
                i6 = i7 + 2;
            }
        }
    }

    public final int b(int i) {
        int i2;
        int i3;
        this.d += i;
        int i4 = 0;
        while (true) {
            i2 = this.d;
            i3 = 2;
            if (i2 <= 8) {
                break;
            }
            int i5 = i2 - 8;
            this.d = i5;
            byte[] bArr = this.f7676a;
            int i6 = this.f7677c;
            i4 |= (bArr[i6] & 255) << i5;
            if (!d(i6 + 1)) {
                i3 = 1;
            }
            this.f7677c = i6 + i3;
        }
        byte[] bArr2 = this.f7676a;
        int i7 = this.f7677c;
        byte b = bArr2[i7];
        if (i2 == 8) {
            this.d = 0;
            if (!d(i7 + 1)) {
                i3 = 1;
            }
            this.f7677c = i7 + i3;
        }
        g();
        return ((-1) >>> (32 - i)) & (i4 | ((b & 255) >> (8 - i2)));
    }

    public final boolean b() {
        boolean z = (this.f7676a[this.f7677c] & (128 >> this.d)) != 0;
        a();
        return z;
    }

    public final int c() {
        return f();
    }

    public final int d() {
        int f = f();
        return (f % 2 == 0 ? -1 : 1) * ((f + 1) / 2);
    }
}
