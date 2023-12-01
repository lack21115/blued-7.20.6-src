package com.igexin.push.c.c;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/c/c/i.class */
public final class i extends c {

    /* renamed from: a  reason: collision with root package name */
    public static final int f23345a = 4;
    public long b;

    /* renamed from: c  reason: collision with root package name */
    public byte f23346c;
    public int d;
    public String e;
    public List<j> f;

    public i() {
        this.m = 4;
        this.n = (byte) 20;
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
        this.f23346c = bArr[8];
        this.d = com.igexin.c.a.b.g.c(bArr, 9) & (-1);
        int i2 = 14;
        if (bArr.length > 13) {
            int i3 = bArr[13] & 255;
            i = 14;
            if (i3 > 0) {
                this.f = new ArrayList();
                while (true) {
                    i = i2;
                    if (i2 >= i3 + 14) {
                        break;
                    }
                    j jVar = new j();
                    this.f.add(jVar);
                    int i4 = i2 + 1;
                    int i5 = bArr[i2] & 255 & 255;
                    int i6 = i4 + 1;
                    int i7 = bArr[i4] & 255 & 255;
                    jVar.f23347a = (byte) i5;
                    if ((i5 == 1 || i5 == 4) && i7 > 0) {
                        try {
                            jVar.b = new String(bArr, i6, i7, "UTF-8");
                        } catch (Exception e) {
                            com.igexin.c.a.c.a.a(e);
                        }
                    }
                    i2 = i6 + i7;
                }
            }
        } else {
            i = 13;
        }
        if (bArr.length > i) {
            this.e = a(bArr, i + 1, bArr[i] & 255);
        }
    }

    @Override // com.igexin.push.c.c.c
    public final byte[] b() {
        int i;
        int i2;
        List<j> list = this.f;
        byte[] bArr = null;
        if (list != null) {
            bArr = null;
            if (list.size() > 0) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bArr = null;
                for (j jVar : this.f) {
                    try {
                        byteArrayOutputStream.write(jVar.b());
                        bArr = byteArrayOutputStream.toByteArray();
                    } catch (IOException e) {
                        com.igexin.c.a.c.a.a(e);
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    com.igexin.c.a.c.a.a(e2);
                }
            }
        }
        if (bArr != null) {
            i = bArr.length;
            i2 = i + 1;
        } else {
            i = 0;
            i2 = 1;
        }
        byte[] bArr2 = new byte[i2 + 12 + this.e.getBytes().length + 1];
        com.igexin.c.a.b.g.a(this.b, bArr2, 0);
        com.igexin.c.a.b.g.a(((this.f23346c & 255) << 24) | this.d, bArr2, 8);
        bArr2[12] = (byte) i;
        int a2 = i > 0 ? 13 + com.igexin.c.a.b.g.a(bArr, bArr2, 13, i) : 13;
        byte[] bytes = this.e.getBytes();
        bArr2[a2] = (byte) bytes.length;
        System.arraycopy((Object) bytes, 0, (Object) bArr2, a2 + 1, bytes.length);
        return bArr2;
    }
}
