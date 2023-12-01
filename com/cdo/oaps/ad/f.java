package com.cdo.oaps.ad;

import com.tencent.qcloud.core.util.IOUtils;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    static final int f21527a = 255;

    /* renamed from: c  reason: collision with root package name */
    static final int f21528c = 76;
    static final int d = 8;
    static final int e = 4;
    static final int f = 64;
    static final byte g = 61;
    static final int h = -128;
    static final int i = 16;
    static final int j = 24;
    private static byte[] k = new byte[255];
    static final byte[] b = IOUtils.LINE_SEPARATOR_WINDOWS.getBytes();
    private static byte[] l = new byte[64];

    static {
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= 255) {
                break;
            }
            k[i6] = (byte) (-1);
            i5 = i6 + 1;
        }
        int i7 = 90;
        while (true) {
            int i8 = i7;
            if (i8 < 65) {
                break;
            }
            k[i8] = (byte) (i8 - 65);
            i7 = i8 - 1;
        }
        int i9 = 122;
        while (true) {
            int i10 = i9;
            i2 = 26;
            if (i10 < 97) {
                break;
            }
            k[i10] = (byte) ((i10 - 97) + 26);
            i9 = i10 - 1;
        }
        int i11 = 57;
        while (true) {
            int i12 = i11;
            if (i12 < 48) {
                break;
            }
            k[i12] = (byte) ((i12 - 48) + 52);
            i11 = i12 - 1;
        }
        byte[] bArr = k;
        bArr[43] = (byte) 62;
        bArr[47] = (byte) 63;
        int i13 = 0;
        while (true) {
            int i14 = i13;
            if (i14 > 25) {
                break;
            }
            l[i14] = (byte) (i14 + 65);
            i13 = i14 + 1;
        }
        int i15 = 0;
        while (true) {
            int i16 = i15;
            i3 = 0;
            i4 = 52;
            if (i2 > 51) {
                break;
            }
            l[i2] = (byte) (i16 + 97);
            i2++;
            i15 = i16 + 1;
        }
        while (i4 <= 61) {
            l[i4] = (byte) (i3 + 48);
            i4++;
            i3++;
        }
        byte[] bArr2 = l;
        bArr2[62] = (byte) 43;
        bArr2[63] = (byte) 47;
    }

    private static boolean a(byte b2) {
        return b2 == 61 || k[b2] != -1;
    }

    public static byte[] a(byte[] bArr) {
        byte[] b2 = b(bArr);
        int i2 = 0;
        if (b2.length != 0) {
            int length = b2.length / 4;
            int length2 = b2.length;
            while (true) {
                int i3 = length2;
                int i4 = i3 - 1;
                if (b2[i4] != 61) {
                    byte[] bArr2 = new byte[i3 - length];
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i2 >= length) {
                            return bArr2;
                        }
                        int i7 = i2 * 4;
                        byte b3 = b2[i7 + 2];
                        byte b4 = b2[i7 + 3];
                        byte[] bArr3 = k;
                        byte b5 = bArr3[b2[i7]];
                        byte b6 = bArr3[b2[i7 + 1]];
                        if (b3 != 61 && b4 != 61) {
                            byte b7 = bArr3[b3];
                            byte b8 = bArr3[b4];
                            bArr2[i6] = (byte) ((b5 << 2) | (b6 >> 4));
                            bArr2[i6 + 1] = (byte) (((b6 & 15) << 4) | ((b7 >> 2) & 15));
                            bArr2[i6 + 2] = (byte) ((b7 << 6) | b8);
                        } else if (b3 == 61) {
                            bArr2[i6] = (byte) ((b6 >> 4) | (b5 << 2));
                        } else if (b4 == 61) {
                            byte b9 = k[b3];
                            bArr2[i6] = (byte) ((b5 << 2) | (b6 >> 4));
                            bArr2[i6 + 1] = (byte) (((b6 & 15) << 4) | ((b9 >> 2) & 15));
                        }
                        i2++;
                        i5 = i6 + 3;
                    }
                } else if (i4 == 0) {
                    break;
                } else {
                    length2 = i4;
                }
            }
        }
        return new byte[0];
    }

    public static byte[] a(byte[] bArr, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int length = bArr.length * 8;
        int i7 = length % 24;
        int i8 = length / 24;
        int i9 = i7 != 0 ? (i8 + 1) * 4 : i8 * 4;
        if (z) {
            i2 = b.length == 0 ? 0 : (int) Math.ceil(i9 / 76.0f);
            i3 = i9 + (b.length * i2);
        } else {
            i2 = 0;
            i3 = i9;
        }
        byte[] bArr2 = new byte[i3];
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 76;
        while (true) {
            int i14 = i13;
            if (i10 >= i8) {
                break;
            }
            int i15 = i10 * 3;
            byte b2 = bArr[i15];
            byte b3 = bArr[i15 + 1];
            byte b4 = bArr[i15 + 2];
            byte b5 = (byte) (b3 & 15);
            byte b6 = (byte) (b2 & 3);
            int i16 = b2 >> 2;
            if ((b2 & Byte.MIN_VALUE) != 0) {
                i16 ^= 192;
            }
            byte b7 = (byte) i16;
            int i17 = b3 >> 4;
            if ((b3 & Byte.MIN_VALUE) != 0) {
                i17 ^= 240;
            }
            byte b8 = (byte) i17;
            int i18 = b4 >> 6;
            if ((b4 & Byte.MIN_VALUE) != 0) {
                i18 ^= 252;
            }
            byte[] bArr3 = l;
            bArr2[i11] = bArr3[b7];
            bArr2[i11 + 1] = bArr3[(b6 << 4) | b8];
            bArr2[i11 + 2] = bArr3[(b5 << 2) | ((byte) i18)];
            bArr2[i11 + 3] = bArr3[b4 & 63];
            int i19 = i11 + 4;
            if (z && i19 == i14) {
                byte[] bArr4 = b;
                System.arraycopy((Object) bArr4, 0, (Object) bArr2, i19, bArr4.length);
                i5 = i12 + 1;
                byte[] bArr5 = b;
                int length2 = bArr5.length;
                i6 = i19 + bArr5.length;
                i4 = ((i5 + 1) * 76) + (length2 * i5);
            } else {
                i4 = i14;
                i5 = i12;
                i6 = i19;
            }
            i10++;
            i11 = i6;
            i12 = i5;
            i13 = i4;
        }
        int i20 = i10 * 3;
        if (i7 == 8) {
            byte b9 = bArr[i20];
            byte b10 = (byte) (b9 & 3);
            int i21 = b9 >> 2;
            if ((b9 & Byte.MIN_VALUE) != 0) {
                i21 ^= 192;
            }
            byte[] bArr6 = l;
            bArr2[i11] = bArr6[(byte) i21];
            bArr2[i11 + 1] = bArr6[b10 << 4];
            byte b11 = (byte) 61;
            bArr2[i11 + 2] = b11;
            bArr2[i11 + 3] = b11;
        } else if (i7 == 16) {
            byte b12 = bArr[i20];
            byte b13 = bArr[i20 + 1];
            byte b14 = (byte) (b13 & 15);
            byte b15 = (byte) (b12 & 3);
            int i22 = b12 >> 2;
            if ((b12 & Byte.MIN_VALUE) != 0) {
                i22 ^= 192;
            }
            byte b16 = (byte) i22;
            int i23 = b13 >> 4;
            if ((b13 & Byte.MIN_VALUE) != 0) {
                i23 ^= 240;
            }
            byte[] bArr7 = l;
            bArr2[i11] = bArr7[b16];
            bArr2[i11 + 1] = bArr7[((byte) i23) | (b15 << 4)];
            bArr2[i11 + 2] = bArr7[b14 << 2];
            bArr2[i11 + 3] = (byte) 61;
        }
        if (z && i12 < i2) {
            byte[] bArr8 = b;
            System.arraycopy((Object) bArr8, 0, (Object) bArr2, i3 - bArr8.length, bArr8.length);
        }
        return bArr2;
    }

    static byte[] b(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i2 >= bArr.length) {
                byte[] bArr3 = new byte[i4];
                System.arraycopy((Object) bArr2, 0, (Object) bArr3, 0, i4);
                return bArr3;
            }
            int i5 = i4;
            if (a(bArr[i2])) {
                bArr2[i4] = bArr[i2];
                i5 = i4 + 1;
            }
            i2++;
            i3 = i5;
        }
    }

    static byte[] c(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i2 >= bArr.length) {
                byte[] bArr3 = new byte[i4];
                System.arraycopy((Object) bArr2, 0, (Object) bArr3, 0, i4);
                return bArr3;
            }
            byte b2 = bArr[i2];
            int i5 = i4;
            if (b2 != 9) {
                i5 = i4;
                if (b2 != 10) {
                    i5 = i4;
                    if (b2 != 13) {
                        i5 = i4;
                        if (b2 != 32) {
                            bArr2[i4] = bArr[i2];
                            i5 = i4 + 1;
                        }
                    }
                }
            }
            i2++;
            i3 = i5;
        }
    }

    public static byte[] d(byte[] bArr) {
        return a(bArr, false);
    }

    public static byte[] e(byte[] bArr) {
        return a(bArr, true);
    }

    public static boolean f(byte[] bArr) {
        byte[] c2 = c(bArr);
        int length = c2.length;
        if (length == 0) {
            return true;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return true;
            }
            if (!a(c2[i3])) {
                return false;
            }
            i2 = i3 + 1;
        }
    }

    public Object a(Object obj) {
        if (obj instanceof byte[]) {
            return g((byte[]) obj);
        }
        throw new d("Parameter supplied to Base64 decode is not a byte[]");
    }

    public Object b(Object obj) {
        if (obj instanceof byte[]) {
            return h((byte[]) obj);
        }
        throw new e("Parameter supplied to Base64 encode is not a byte[]");
    }

    public byte[] g(byte[] bArr) {
        return a(bArr);
    }

    public byte[] h(byte[] bArr) {
        return a(bArr, false);
    }
}
