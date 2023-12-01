package com.igexin.push.c.c;

import android.text.TextUtils;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/c/c/p.class */
public final class p extends c {

    /* renamed from: a  reason: collision with root package name */
    public static final int f9747a = 9;
    public long b;

    /* renamed from: c  reason: collision with root package name */
    public String f9748c = "";
    public String d = "";
    public String e = "";

    public p() {
        this.m = 9;
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
        int i;
        this.b = com.igexin.c.a.b.g.d(bArr, 0);
        int i2 = 9;
        if (bArr.length > 8) {
            int i3 = bArr[8] & 255;
            if (i3 > 0) {
                this.f9748c = a(bArr, 9, i3);
                i2 = 9 + i3;
            }
        } else {
            i2 = 8;
        }
        int i4 = i2;
        if (bArr.length > i2) {
            i4 = i2 + 1;
            int i5 = bArr[i2] & 255;
            if (i5 > 0) {
                this.d = a(bArr, i4, i5);
                i4 = i5 + i4;
            }
        }
        if (bArr.length <= i4 || (i = bArr[i4] & 255) <= 0) {
            return;
        }
        this.e = a(bArr, i4 + 1, i);
    }

    @Override // com.igexin.push.c.c.c
    public final byte[] b() {
        if (TextUtils.isEmpty(this.d) || TextUtils.isEmpty(this.e)) {
            byte[] bytes = this.f9748c.getBytes();
            byte[] bArr = new byte[bytes.length + 8 + 1];
            com.igexin.c.a.b.g.a(this.b, bArr, 0);
            bArr[8] = (byte) bytes.length;
            System.arraycopy(bytes, 0, bArr, 9, bytes.length);
            return bArr;
        }
        byte[] bytes2 = this.f9748c.getBytes();
        byte[] bytes3 = this.d.getBytes();
        byte[] bytes4 = this.e.getBytes();
        byte[] bArr2 = new byte[bytes2.length + 8 + bytes3.length + bytes4.length + 3];
        com.igexin.c.a.b.g.a(this.b, bArr2, 0);
        bArr2[8] = (byte) bytes2.length;
        System.arraycopy(bytes2, 0, bArr2, 9, bytes2.length);
        int length = bytes2.length + 9;
        int length2 = bytes3.length;
        int i = length + 1;
        bArr2[length] = (byte) length2;
        System.arraycopy(bytes3, 0, bArr2, i, bytes3.length);
        int length3 = i + bytes3.length;
        bArr2[length3] = (byte) bytes4.length;
        System.arraycopy(bytes4, 0, bArr2, length3 + 1, bytes4.length);
        return bArr2;
    }
}
