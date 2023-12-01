package com.unikuwei.mianmi.account.shield.tencent.e;

import java.io.ByteArrayOutputStream;

/* loaded from: source-8829756-dex2jar.jar:com/unikuwei/mianmi/account/shield/tencent/e/m.class */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private static char[] f27322a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static byte[] b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    public static byte[] a(byte[] bArr) {
        return a(bArr, a(new String(b("MkYxNEQwRjU1MEQyNEYxOENCQTU1MTlGNEZBMjI2QUU="))));
    }

    private static byte[] a(byte[] bArr, int[] iArr) {
        return bArr.length == 0 ? bArr : a(a(a(bArr, false), iArr), false);
    }

    public static byte[] a(int[] iArr) {
        return a(a(iArr, a(new String(b("MkYxNEQwRjU1MEQyNEYxOENCQTU1MTlGNEZBMjI2QUU=")))), false);
    }

    public static byte[] a(int[] iArr, boolean z) {
        int length = iArr.length << 2;
        int i = length;
        if (z) {
            i = iArr[iArr.length - 1];
            if (i > length) {
                return null;
            }
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return bArr;
            }
            bArr[i3] = (byte) ((iArr[i3 >>> 2] >>> ((i3 & 3) << 3)) & 255);
            i2 = i3 + 1;
        }
    }

    public static int[] a(String str) {
        return a(c(str), false);
    }

    private static int[] a(byte[] bArr, boolean z) {
        int[] iArr;
        int length = (bArr.length & 3) == 0 ? bArr.length >>> 2 : (bArr.length >>> 2) + 1;
        if (z) {
            iArr = new int[length + 1];
            iArr[length] = bArr.length;
        } else {
            iArr = new int[length];
        }
        int length2 = bArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length2) {
                return iArr;
            }
            int i3 = i2 >>> 2;
            iArr[i3] = iArr[i3] | ((bArr[i2] & 255) << ((i2 & 3) << 3));
            i = i2 + 1;
        }
    }

    private static int[] a(int[] iArr, int[] iArr2) {
        int i;
        int length = iArr.length - 1;
        if (length < 1) {
            return iArr;
        }
        int[] iArr3 = iArr2;
        if (iArr2.length < 4) {
            iArr3 = new int[4];
            System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
        }
        int i2 = iArr[length];
        int i3 = iArr[0];
        int i4 = ((52 / (length + 1)) + 6) * (-1640531527);
        while (true) {
            int i5 = i4;
            if (i5 == 0) {
                return iArr;
            }
            int i6 = (i5 >>> 2) & 3;
            int i7 = length;
            while (true) {
                i = i7;
                if (i > 0) {
                    int i8 = iArr[i - 1];
                    i3 = iArr[i] - (((i3 ^ i5) + (i8 ^ iArr3[(i & 3) ^ i6])) ^ (((i8 >>> 5) ^ (i3 << 2)) + ((i3 >>> 3) ^ (i8 << 4))));
                    iArr[i] = i3;
                    i7 = i - 1;
                }
            }
            int i9 = iArr[length];
            i3 = iArr[0] - (((i3 ^ i5) + (iArr3[i6 ^ (i & 3)] ^ i9)) ^ (((i9 >>> 5) ^ (i3 << 2)) + ((i3 >>> 3) ^ (i9 << 4))));
            iArr[0] = i3;
            i4 = i5 + 1640531527;
        }
    }

    public static byte[] b(String str) {
        byte b2;
        byte b3;
        byte b4;
        byte b5;
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        int i = 0;
        while (i < length) {
            while (true) {
                int i2 = i;
                i = i2 + 1;
                b2 = b[bytes[i2]];
                if (i >= length || b2 != -1) {
                    break;
                }
            }
            int i3 = i;
            if (b2 == -1) {
                break;
            }
            while (true) {
                i = i3 + 1;
                b3 = b[bytes[i3]];
                if (i >= length || b3 != -1) {
                    break;
                }
                i3 = i;
            }
            if (b3 == -1) {
                break;
            }
            byteArrayOutputStream.write((b2 << 2) | ((b3 & 48) >>> 4));
            while (true) {
                int i4 = i;
                i = i4 + 1;
                byte b6 = bytes[i4];
                if (b6 == 61) {
                    return byteArrayOutputStream.toByteArray();
                }
                b4 = b[b6];
                if (i >= length || b4 != -1) {
                    break;
                }
            }
            if (b4 == -1) {
                break;
            }
            byteArrayOutputStream.write(((b3 & 15) << 4) | ((b4 & 60) >>> 2));
            while (true) {
                int i5 = i;
                i = i5 + 1;
                byte b7 = bytes[i5];
                if (b7 == 61) {
                    return byteArrayOutputStream.toByteArray();
                }
                b5 = b[b7];
                if (i >= length || b5 != -1) {
                    break;
                }
            }
            if (b5 == -1) {
                break;
            }
            byteArrayOutputStream.write(b5 | ((b4 & 3) << 6));
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static byte[] c(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        byte[] bytes = str.getBytes();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return bArr;
            }
            int i3 = i2 * 2;
            if (bytes[i3] >= 48 && bytes[i3] <= 57) {
                bArr[i2] = (byte) ((bytes[i3] - 48) << 4);
            } else if (bytes[i3] >= 65 && bytes[i3] <= 90) {
                bArr[i2] = (byte) (((bytes[i3] - 65) + 10) << 4);
            }
            int i4 = i3 + 1;
            if (bytes[i4] >= 48 && bytes[i4] <= 57) {
                bArr[i2] = (byte) (bArr[i2] + ((byte) (bytes[i4] - 48)));
            } else if (bytes[i4] >= 65 && bytes[i4] <= 90) {
                bArr[i2] = (byte) (bArr[i2] + ((byte) ((bytes[i4] - 65) + 10)));
            }
            i = i2 + 1;
        }
    }
}
