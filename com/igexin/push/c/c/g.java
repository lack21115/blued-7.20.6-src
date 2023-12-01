package com.igexin.push.c.c;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/c/c/g.class */
public final class g extends c {

    /* renamed from: a  reason: collision with root package name */
    public static final int f23341a = 96;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f23342c;
    private byte d;
    private String e;

    public g() {
        this.m = 96;
        this.n = (byte) 4;
        this.o = (byte) (this.o | 16);
    }

    private static String a(byte[] bArr, int i, int i2) {
        try {
            return new String(bArr, i, i2, "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }

    @Override // com.igexin.push.c.c.c
    public final void a(byte[] bArr) {
        try {
            this.d = bArr[0];
            int i = bArr[1] & 255;
            this.b = a(bArr, 2, i);
            int i2 = i + 2;
            int i3 = i2 + 1;
            int i4 = bArr[i2] & 255;
            byte[] bArr2 = new byte[i4];
            this.f23342c = bArr2;
            System.arraycopy((Object) bArr, i3, (Object) bArr2, 0, i4);
            int i5 = i3 + i4;
            this.e = a(bArr, i5 + 1, bArr[i5] & 255);
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    @Override // com.igexin.push.c.c.c
    public final byte[] b() {
        byte[] bytes = this.b.getBytes();
        byte[] b = com.igexin.push.f.g.b(com.igexin.c.a.b.g.b((int) (System.currentTimeMillis() / 1000)));
        byte[] b2 = com.igexin.push.f.g.b();
        byte[] bArr = new byte[bytes.length + 2 + 2 + b2.length + 1 + b.length];
        bArr[0] = 0;
        bArr[1] = (byte) bytes.length;
        int a2 = com.igexin.c.a.b.g.a(bytes, bArr, 2, bytes.length) + 2;
        int b3 = a2 + com.igexin.c.a.b.g.b((short) b2.length, bArr, a2);
        int a3 = b3 + com.igexin.c.a.b.g.a(b2, bArr, b3, b2.length);
        bArr[a3] = (byte) b.length;
        com.igexin.c.a.b.g.a(b, bArr, a3 + 1, b.length);
        return bArr;
    }
}
