package com.opos.exoplayer.core.c.f;

import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/v.class */
final class v {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f11549a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f11550c;
    private boolean d;
    private boolean e;

    public v(int i, int i2) {
        this.f11550c = i;
        byte[] bArr = new byte[i2 + 3];
        this.f11549a = bArr;
        bArr[2] = (byte) 1;
    }

    public void a() {
        this.d = false;
        this.e = false;
    }

    public void a(int i) {
        boolean z = true;
        com.opos.exoplayer.core.i.a.b(!this.d);
        if (i != this.f11550c) {
            z = false;
        }
        this.d = z;
        if (z) {
            this.b = 3;
            this.e = false;
        }
    }

    public void a(byte[] bArr, int i, int i2) {
        if (this.d) {
            int i3 = i2 - i;
            byte[] bArr2 = this.f11549a;
            int length = bArr2.length;
            int i4 = this.b;
            if (length < i4 + i3) {
                this.f11549a = Arrays.copyOf(bArr2, (i4 + i3) * 2);
            }
            System.arraycopy(bArr, i, this.f11549a, this.b, i3);
            this.b = i3 + this.b;
        }
    }

    public boolean b() {
        return this.e;
    }

    public boolean b(int i) {
        if (this.d) {
            this.b -= i;
            this.d = false;
            this.e = true;
            return true;
        }
        return false;
    }
}
