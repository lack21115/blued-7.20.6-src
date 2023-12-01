package com.tencent.txcopyrightedmedia.impl.utils;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/ag.class */
public final class ag {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f26355a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f26356c;
    private boolean d;

    public ag(int i) {
        this.f26355a = new byte[i <= 0 ? 1 : i];
        this.b = 0;
        this.f26356c = 0;
        this.d = true;
    }

    public final int a() {
        if (this.d || this.f26356c != this.b) {
            int i = this.f26356c;
            byte[] bArr = this.f26355a;
            return ((i + bArr.length) - this.b) % bArr.length;
        }
        return this.f26355a.length;
    }

    public final int a(byte[] bArr, int i) {
        int i2;
        if (this.d) {
            return 0;
        }
        int i3 = 0;
        while (true) {
            i2 = i3;
            if (i2 >= i + 0) {
                break;
            }
            byte[] bArr2 = this.f26355a;
            int i4 = this.b;
            int i5 = i4 + 1;
            this.b = i5;
            bArr[i2] = bArr2[i4];
            if (i5 == bArr2.length) {
                this.b = 0;
            }
            if (this.b == this.f26356c) {
                this.d = true;
                break;
            }
            i3 = i2 + 1;
        }
        return i2 - 0;
    }

    public final boolean a(byte b) {
        if (this.f26356c == this.b) {
            if (!this.d) {
                return false;
            }
            this.d = false;
        }
        byte[] bArr = this.f26355a;
        int i = this.f26356c;
        int i2 = i + 1;
        this.f26356c = i2;
        bArr[i] = b;
        if (i2 == bArr.length) {
            this.f26356c = 0;
            return true;
        }
        return true;
    }

    public final boolean a(int i) {
        byte[] bArr = this.f26355a;
        if (i <= bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        this.f26356c = (this.b + a()) % i;
        this.f26355a = bArr2;
        return true;
    }
}
