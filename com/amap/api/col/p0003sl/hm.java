package com.amap.api.col.p0003sl;

/* renamed from: com.amap.api.col.3sl.hm  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hm.class */
public final class hm {
    private static int a = 6;

    private static byte[] a() {
        try {
            return a("16,99,86,77,511,98,86,97,511,99,86,77,511,18,48,97,511,99,86,77,511,58,601,77,511,58,48,77,511,58,86,87,511,18,48,97,511,58,86,87,511,18,48,97,511,98,48,87,511,98,48,97,511,99,86,77,511,58,221,77,511,98,601,87");
        } catch (Throwable th) {
            iw.c(th, "AMU", "grk");
            return null;
        }
    }

    private static byte[] a(String str) {
        try {
            String[] split = new StringBuffer(str).reverse().toString().split(",");
            int length = split.length;
            byte[] bArr = new byte[length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                bArr[i2] = Byte.parseByte(split[i2]);
                i = i2 + 1;
            }
            String[] split2 = new StringBuffer(new String(ie.a(new String(bArr)), "UTF-8")).reverse().toString().split(",");
            byte[] bArr2 = new byte[split2.length];
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= split2.length) {
                    return bArr2;
                }
                bArr2[i4] = Byte.parseByte(split2[i4]);
                i3 = i4 + 1;
            }
        } catch (Throwable th) {
            iw.c(th, "AMU", "rcs");
            return null;
        }
    }

    public static byte[] a(byte[] bArr) {
        try {
            return ht.b(a(), bArr, b());
        } catch (Throwable th) {
            return new byte[0];
        }
    }

    private static byte[] b() {
        try {
            return a("16,18,86,97,511,18,48,97,511,18,86,97,511,58,86,77,511,18,86,97,511,58,48,77,511,18,86,97,511,58,601,77,511,18,86,97,511,58,221,77,511,18,86,97,511,58,86,87,511,18,86,97,511,58,48,87,511,18,86,97,511,58,601,87");
        } catch (Throwable th) {
            iw.c(th, "AMU", "giv");
            return null;
        }
    }

    public static byte[] b(byte[] bArr) {
        try {
            return ht.a(a(), bArr, b());
        } catch (Exception e) {
            return new byte[0];
        }
    }
}
