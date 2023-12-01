package com.xiaomi.push;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/bk.class */
public class bk {

    /* renamed from: a  reason: collision with other field name */
    private static byte[] f176a;

    /* renamed from: a  reason: collision with root package name */
    private static final String f27595a = System.getProperty("line.separator");

    /* renamed from: a  reason: collision with other field name */
    private static char[] f177a = new char[64];

    static {
        int i;
        int i2;
        char c2 = 'A';
        int i3 = 0;
        while (true) {
            i = i3;
            if (c2 > 'Z') {
                break;
            }
            f177a[i] = c2;
            c2 = (char) (c2 + 1);
            i3 = i + 1;
        }
        char c3 = 'a';
        while (c3 <= 'z') {
            f177a[i] = c3;
            c3 = (char) (c3 + 1);
            i++;
        }
        char c4 = '0';
        while (c4 <= '9') {
            f177a[i] = c4;
            c4 = (char) (c4 + 1);
            i++;
        }
        char[] cArr = f177a;
        cArr[i] = '+';
        cArr[i + 1] = '/';
        f176a = new byte[128];
        int i4 = 0;
        while (true) {
            int i5 = i4;
            byte[] bArr = f176a;
            if (i5 >= bArr.length) {
                break;
            }
            bArr[i5] = -1;
            i4 = i5 + 1;
        }
        for (i2 = 0; i2 < 64; i2++) {
            f176a[f177a[i2]] = (byte) i2;
        }
    }

    public static String a(String str) {
        return new String(a(str.getBytes()));
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m8496a(String str) {
        return a(str.toCharArray());
    }

    public static byte[] a(char[] cArr) {
        return a(cArr, 0, cArr.length);
    }

    public static byte[] a(char[] cArr, int i, int i2) {
        char c2;
        char c3;
        if (i2 % 4 == 0) {
            while (i2 > 0 && cArr[(i + i2) - 1] == '=') {
                i2--;
            }
            int i3 = (i2 * 3) / 4;
            byte[] bArr = new byte[i3];
            int i4 = i2 + i;
            int i5 = 0;
            while (i < i4) {
                int i6 = i + 1;
                char c4 = cArr[i];
                int i7 = i6 + 1;
                char c5 = cArr[i6];
                if (i7 < i4) {
                    i = i7 + 1;
                    c2 = cArr[i7];
                } else {
                    i = i7;
                    c2 = 'A';
                }
                if (i < i4) {
                    i++;
                    c3 = cArr[i];
                } else {
                    c3 = 'A';
                }
                if (c4 > 127 || c5 > 127 || c2 > 127 || c3 > 127) {
                    throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                }
                byte[] bArr2 = f176a;
                byte b = bArr2[c4];
                byte b2 = bArr2[c5];
                byte b3 = bArr2[c2];
                byte b4 = bArr2[c3];
                if (b < 0 || b2 < 0 || b3 < 0 || b4 < 0) {
                    throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                }
                int i8 = i5 + 1;
                bArr[i5] = (byte) ((b << 2) | (b2 >>> 4));
                i5 = i8;
                if (i8 < i3) {
                    bArr[i8] = (byte) (((b2 & 15) << 4) | (b3 >>> 2));
                    i5 = i8 + 1;
                }
                if (i5 < i3) {
                    bArr[i5] = (byte) (((b3 & 3) << 6) | b4);
                    i5++;
                }
            }
            return bArr;
        }
        throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
    }

    public static char[] a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static char[] a(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5 = ((i2 * 4) + 2) / 3;
        char[] cArr = new char[((i2 + 2) / 3) * 4];
        int i6 = i2 + i;
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i >= i6) {
                return cArr;
            }
            int i9 = i + 1;
            int i10 = bArr[i] & 255;
            if (i9 < i6) {
                i = i9 + 1;
                i3 = bArr[i9] & 255;
            } else {
                i = i9;
                i3 = 0;
            }
            if (i < i6) {
                i4 = bArr[i] & 255;
                i++;
            } else {
                i4 = 0;
            }
            int i11 = i8 + 1;
            char[] cArr2 = f177a;
            cArr[i8] = cArr2[i10 >>> 2];
            int i12 = i11 + 1;
            cArr[i11] = cArr2[((i10 & 3) << 4) | (i3 >>> 4)];
            cArr[i12] = i12 < i5 ? cArr2[((i3 & 15) << 2) | (i4 >>> 6)] : '=';
            int i13 = i12 + 1;
            char c2 = '=';
            if (i13 < i5) {
                c2 = f177a[i4 & 63];
            }
            cArr[i13] = c2;
            i7 = i13 + 1;
        }
    }

    public static String b(String str) {
        return new String(m8496a(str));
    }
}
