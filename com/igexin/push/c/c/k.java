package com.igexin.push.c.c;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/c/c/k.class */
public final class k extends c {

    /* renamed from: a  reason: collision with root package name */
    public static final int f23348a = 5;
    public boolean b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f23349c;
    public String d;
    public String e;
    public long f;

    public k() {
        this.m = 5;
    }

    @Override // com.igexin.push.c.c.c, com.igexin.c.a.d.a.a
    public final void a() {
        this.e = null;
        this.d = null;
    }

    @Override // com.igexin.push.c.c.c
    public final void a(byte[] bArr) {
        byte b = bArr[0];
        int i = 1;
        this.b = (b & 64) != 0;
        boolean z = (b & 128) != 0;
        this.f23349c = z;
        if (z) {
            this.d = a(b);
            int b2 = com.igexin.c.a.b.g.b(bArr, 1);
            i = 1 + b2 + 2;
            try {
                this.e = new String(bArr, 3, b2, this.d);
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
        if (bArr.length > i) {
            this.f = com.igexin.c.a.b.g.d(bArr, i);
            com.igexin.c.a.c.a.a("LoginResult|session = " + this.f, new Object[0]);
        }
    }

    @Override // com.igexin.push.c.c.c
    public final byte[] b() {
        int i;
        int i2;
        byte b;
        int i3;
        byte b2 = this.b ? (byte) 64 : (byte) 0;
        byte[] bArr = null;
        if (this.f23349c) {
            byte b3 = (byte) (b2 | 128);
            try {
                byte[] bytes = this.e.getBytes(this.d);
                bArr = bytes;
                i = bytes.length;
                i3 = i + 3;
                bArr = bytes;
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
                i3 = 3;
                i = 0;
            }
            b = (byte) (b3 | a(this.d));
            i2 = i3;
        } else {
            i = 0;
            i2 = 1;
            bArr = null;
            b = b2;
        }
        byte[] bArr2 = new byte[i2 + 8];
        bArr2[0] = b;
        int i4 = 1;
        if (this.f23349c) {
            i4 = com.igexin.c.a.b.g.b(i, bArr2, 1);
            if (bArr != null) {
                i4 = com.igexin.c.a.b.g.a(bArr, bArr2, 2, i) + 2;
            }
        }
        com.igexin.c.a.b.g.a(this.f, bArr2, i4);
        return bArr2;
    }
}
