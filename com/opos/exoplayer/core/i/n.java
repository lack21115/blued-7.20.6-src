package com.opos.exoplayer.core.i;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/i/n.class */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f11810a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f11811c;
    private int d;

    public n(byte[] bArr, int i, int i2) {
        a(bArr, i, i2);
    }

    private boolean d(int i) {
        if (2 > i || i >= this.b) {
            return false;
        }
        byte[] bArr = this.f11810a;
        return bArr[i] == 3 && bArr[i - 2] == 0 && bArr[i - 1] == 0;
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
            i2 = c(i);
        }
        return ((1 << i) - 1) + i2;
    }

    private void g() {
        int i;
        int i2 = this.f11811c;
        a.b(i2 >= 0 && (i2 < (i = this.b) || (i2 == i && this.d == 0)));
    }

    public void a() {
        int i = 1;
        int i2 = this.d + 1;
        this.d = i2;
        if (i2 == 8) {
            this.d = 0;
            int i3 = this.f11811c;
            if (d(i3 + 1)) {
                i = 2;
            }
            this.f11811c = i + i3;
        }
        g();
    }

    public void a(int i) {
        int i2 = this.f11811c;
        int i3 = i / 8;
        int i4 = i2 + i3;
        this.f11811c = i4;
        int i5 = (i - (i3 * 8)) + this.d;
        this.d = i5;
        int i6 = i2;
        if (i5 > 7) {
            this.f11811c = i4 + 1;
            this.d = i5 - 8;
            i6 = i2;
        }
        while (true) {
            int i7 = i6 + 1;
            if (i7 > this.f11811c) {
                g();
                return;
            }
            i6 = i7;
            if (d(i7)) {
                this.f11811c++;
                i6 = i7 + 2;
            }
        }
    }

    public void a(byte[] bArr, int i, int i2) {
        this.f11810a = bArr;
        this.f11811c = i;
        this.b = i2;
        this.d = 0;
        g();
    }

    public boolean b() {
        boolean z = (this.f11810a[this.f11811c] & (128 >> this.d)) != 0;
        a();
        return z;
    }

    public boolean b(int i) {
        int i2 = this.f11811c;
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

    public int c(int i) {
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
            byte[] bArr = this.f11810a;
            int i6 = this.f11811c;
            i4 |= (bArr[i6] & 255) << i5;
            if (!d(i6 + 1)) {
                i3 = 1;
            }
            this.f11811c = i3 + i6;
        }
        byte[] bArr2 = this.f11810a;
        int i7 = this.f11811c;
        byte b = bArr2[i7];
        if (i2 == 8) {
            this.d = 0;
            if (!d(i7 + 1)) {
                i3 = 1;
            }
            this.f11811c = i7 + i3;
        }
        g();
        return ((-1) >>> (32 - i)) & (((b & 255) >> (8 - i2)) | i4);
    }

    public boolean c() {
        int i;
        int i2 = this.f11811c;
        int i3 = this.d;
        int i4 = 0;
        while (true) {
            i = i4;
            if (this.f11811c >= this.b || b()) {
                break;
            }
            i4 = i + 1;
        }
        boolean z = this.f11811c == this.b;
        this.f11811c = i2;
        this.d = i3;
        boolean z2 = false;
        if (!z) {
            z2 = false;
            if (b((i * 2) + 1)) {
                z2 = true;
            }
        }
        return z2;
    }

    public int d() {
        return f();
    }

    public int e() {
        int f = f();
        return (f % 2 == 0 ? -1 : 1) * ((f + 1) / 2);
    }
}
