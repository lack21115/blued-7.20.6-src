package com.igexin.push.c.c;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/c/c/d.class */
public final class d extends c {

    /* renamed from: a  reason: collision with root package name */
    public static final int f9728a = 6;
    String b;

    /* renamed from: c  reason: collision with root package name */
    String f9729c;
    String d;
    String e;

    public d() {
        this.m = 6;
        this.n = (byte) 20;
        this.b = "";
        this.f9729c = "";
        this.d = "";
        this.e = "";
    }

    public d(String str, String str2, String str3, String str4) {
        this.m = 6;
        this.n = (byte) 20;
        this.b = str == null ? "" : str;
        this.f9729c = str2 == null ? "" : str2;
        this.d = str3 == null ? "" : str3;
        this.e = str4 == null ? "" : str4;
    }

    private String d() {
        return this.d;
    }

    @Override // com.igexin.push.c.c.c, com.igexin.c.a.d.a.a
    public final void a() {
        this.b = null;
        this.f9729c = null;
        this.d = null;
        this.e = null;
    }

    @Override // com.igexin.push.c.c.c
    public final void a(byte[] bArr) {
        int i = bArr[0] & 255;
        try {
            this.b = new String(bArr, 1, i, "utf-8");
            int i2 = i + 1;
            int i3 = bArr[i2] & 255;
            int i4 = i2 + 1;
            this.f9729c = new String(bArr, i4, i3, "utf-8");
            int i5 = i4 + i3;
            int i6 = bArr[i5] & 255;
            int i7 = i5 + 1;
            this.d = new String(bArr, i7, i6, "utf-8");
            int i8 = i7 + i6;
            this.e = new String(bArr, i8 + 1, bArr[i8] & 255, "utf-8");
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    @Override // com.igexin.push.c.c.c
    public final byte[] b() {
        byte[] bytes = this.f9729c.getBytes();
        byte[] bytes2 = this.b.getBytes();
        byte[] bytes3 = this.d.getBytes();
        byte[] bytes4 = this.e.getBytes();
        byte[] bArr = new byte[bytes.length + bytes2.length + bytes3.length + bytes4.length + 4];
        bArr[0] = (byte) bytes.length;
        System.arraycopy(bytes, 0, bArr, 1, bytes.length);
        int length = bytes.length + 1;
        int length2 = bytes2.length;
        int i = length + 1;
        bArr[length] = (byte) length2;
        System.arraycopy(bytes2, 0, bArr, i, bytes2.length);
        int length3 = i + bytes2.length;
        int length4 = bytes3.length;
        int i2 = length3 + 1;
        bArr[length3] = (byte) length4;
        System.arraycopy(bytes3, 0, bArr, i2, bytes3.length);
        int length5 = i2 + bytes3.length;
        bArr[length5] = (byte) bytes4.length;
        System.arraycopy(bytes4, 0, bArr, length5 + 1, bytes4.length);
        return bArr;
    }
}
