package com.igexin.push.c.c;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/c/c/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public int f23329a;
    public byte b;

    /* renamed from: c  reason: collision with root package name */
    public byte f23330c;
    public byte d;
    public byte[] e;
    public int f;
    public byte g;

    private byte[] a() {
        if (this.e == null) {
            return null;
        }
        byte[] bArr = new byte[this.f23329a + 11];
        com.igexin.c.a.b.g.a(com.igexin.push.f.g.e(), bArr, 0);
        com.igexin.c.a.b.g.a((int) (System.currentTimeMillis() / 1000), bArr, 4);
        com.igexin.c.a.b.g.b(this.f23329a, bArr, 8);
        bArr[10] = this.b;
        byte[] bArr2 = this.e;
        com.igexin.c.a.b.g.a(bArr2, bArr, 11, bArr2.length);
        return bArr;
    }

    public final void a(byte[] bArr) {
        int length;
        if (bArr == null) {
            length = 0;
        } else {
            this.e = bArr;
            length = bArr.length;
        }
        this.f23329a = length;
    }
}
