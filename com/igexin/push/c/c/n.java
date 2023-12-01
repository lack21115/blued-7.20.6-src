package com.igexin.push.c.c;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/c/c/n.class */
public class n extends c {

    /* renamed from: a  reason: collision with root package name */
    public static final int f9745a = 26;
    private static final String j = n.class.getName();
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f9746c;
    public long d;
    public String e;
    public Object f;
    public Object g;
    public String h;
    public String i = "UTF-8";

    public n() {
        this.m = 26;
    }

    private boolean e() {
        return this.f9746c == 64;
    }

    private boolean f() {
        return this.f9746c == 192;
    }

    private void g() {
        this.f9746c = 128;
    }

    private void h() {
        this.f9746c = 64;
    }

    private void k() {
        this.f9746c = 192;
    }

    @Override // com.igexin.push.c.c.c, com.igexin.c.a.d.a.a
    public final void a() {
        this.e = null;
        this.g = null;
        this.f = null;
        this.i = null;
    }

    @Override // com.igexin.push.c.c.c
    public final void a(byte[] bArr) {
        int i;
        int i2;
        this.b = com.igexin.c.a.b.g.b(bArr, 0);
        this.f9746c = bArr[2] & 192;
        this.i = a(bArr[2]);
        this.d = com.igexin.c.a.b.g.d(bArr, 3);
        int i3 = bArr[11] & 255;
        try {
            this.e = new String(bArr, 12, i3, this.i);
        } catch (Exception e) {
            this.e = "";
            com.igexin.c.a.c.a.a(e);
        }
        int i4 = i3 + 12;
        int i5 = 0;
        while (true) {
            i = i5 | (bArr[i4] & 127);
            if ((bArr[i4] & 128) == 0) {
                break;
            }
            i5 = i << 7;
            i4++;
        }
        int i6 = i4 + 1;
        if (i > 0) {
            if (this.f9746c == 192) {
                byte[] bArr2 = new byte[i];
                this.f = bArr2;
                System.arraycopy(bArr, i6, bArr2, 0, i);
            } else {
                try {
                    this.f = new String(bArr, i6, i, this.i);
                } catch (Exception e2) {
                    com.igexin.c.a.c.a.a(e2);
                }
            }
        }
        int i7 = i6 + i;
        int i8 = 0;
        while (true) {
            i2 = i8 | (bArr[i7] & 127);
            if ((bArr[i7] & 128) == 0) {
                break;
            }
            i8 = i2 << 7;
            i7++;
        }
        int i9 = i7 + 1;
        if (i2 > 0) {
            byte[] bArr3 = new byte[i2];
            this.g = bArr3;
            System.arraycopy(bArr, i9, bArr3, 0, i2);
        }
        int i10 = i9 + i2;
        if (bArr.length > i10) {
            try {
                this.h = new String(bArr, i10 + 1, bArr[i10] & 255, this.i);
            } catch (Exception e3) {
                com.igexin.c.a.c.a.a(e3);
            }
        }
    }

    @Override // com.igexin.push.c.c.c
    public final byte[] b() {
        byte[] bArr = null;
        try {
            byte[] bytes = this.e.getBytes(this.i);
            byte[] bytes2 = this.h.getBytes(this.i);
            byte[] bytes3 = !"".equals(this.f) ? this.f9746c == 192 ? (byte[]) this.f : ((String) this.f).getBytes(this.i) : null;
            byte[] bArr2 = this.g != null ? (byte[]) this.g : null;
            int length = bytes3 == null ? 0 : bytes3.length;
            int length2 = bArr2 == null ? 0 : bArr2.length;
            byte[] a2 = com.igexin.c.a.b.g.a(length);
            byte[] a3 = com.igexin.c.a.b.g.a(length2);
            byte[] bArr3 = new byte[bytes.length + 13 + a2.length + length + a3.length + length2 + bytes2.length];
            com.igexin.c.a.b.g.b(this.b, bArr3, 0);
            bArr3[2] = (byte) (this.f9746c | a(this.i));
            com.igexin.c.a.b.g.a(this.d, bArr3, 3);
            bArr3[11] = (byte) bytes.length;
            int a4 = com.igexin.c.a.b.g.a(bytes, bArr3, 12, bytes.length) + 12;
            int a5 = a4 + com.igexin.c.a.b.g.a(a2, bArr3, a4, a2.length);
            int i = a5;
            if (length > 0) {
                i = a5 + com.igexin.c.a.b.g.a(bytes3, bArr3, a5, length);
            }
            int a6 = i + com.igexin.c.a.b.g.a(a3, bArr3, i, a3.length);
            int i2 = a6;
            if (length2 > 0) {
                i2 = a6 + com.igexin.c.a.b.g.a(bArr2, bArr3, a6, length2);
            }
            bArr3[i2] = (byte) bytes2.length;
            bArr = bArr3;
            com.igexin.c.a.b.g.a(bytes2, bArr3, i2 + 1, bytes2.length);
            return bArr3;
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return bArr;
        }
    }

    public final boolean d() {
        return this.f9746c == 128;
    }

    public String toString() {
        return "{\"msgID\":" + this.b + ", \"msgType\":" + this.f9746c + ", \"msgDate\":" + this.d + ", \"msgAddress\":\"" + this.e + "\", \"msgContent\":" + this.f + ", \"msgExtra\":" + this.g + ", \"msgCID\":\"" + this.h + "\", \"charset\":\"" + this.i + "\", \"command\":" + this.m + ", \"property\":" + ((int) this.n) + ", \"expandProperty\":" + ((int) this.o) + ", \"tag\":\"" + this.y + "\"}";
    }
}
