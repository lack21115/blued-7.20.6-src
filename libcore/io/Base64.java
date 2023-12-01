package libcore.io;

import java.nio.charset.StandardCharsets;
import libcore.util.EmptyArray;

/* loaded from: source-2895416-dex2jar.jar:libcore/io/Base64.class */
public final class Base64 {
    private static final byte[] map = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    private Base64() {
    }

    public static byte[] decode(byte[] bArr) {
        return decode(bArr, bArr.length);
    }

    public static byte[] decode(byte[] bArr, int i) {
        int i2;
        int i3;
        int i4 = (i / 4) * 3;
        if (i4 == 0) {
            return EmptyArray.BYTE;
        }
        byte[] bArr2 = new byte[i4];
        int i5 = 0;
        int i6 = i;
        while (true) {
            byte b = bArr[i6 - 1];
            int i7 = i5;
            if (b != 10) {
                i7 = i5;
                if (b != 13) {
                    i7 = i5;
                    if (b == 32) {
                        continue;
                    } else if (b != 9) {
                        if (b != 61) {
                            break;
                        }
                        i7 = i5 + 1;
                    } else {
                        i7 = i5;
                    }
                } else {
                    continue;
                }
            }
            i6--;
            i5 = i7;
        }
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < i6; i11++) {
            byte b2 = bArr[i11];
            if (b2 != 10 && b2 != 13 && b2 != 32 && b2 != 9) {
                if (b2 >= 65 && b2 <= 90) {
                    i3 = b2 - 65;
                } else if (b2 >= 97 && b2 <= 122) {
                    i3 = b2 - 71;
                } else if (b2 >= 48 && b2 <= 57) {
                    i3 = b2 + 4;
                } else if (b2 == 43) {
                    i3 = 62;
                } else if (b2 != 47) {
                    return null;
                } else {
                    i3 = 63;
                }
                i9 = (i9 << 6) | ((byte) i3);
                if (i8 % 4 == 3) {
                    int i12 = i10 + 1;
                    bArr2[i10] = (byte) (i9 >> 16);
                    int i13 = i12 + 1;
                    bArr2[i12] = (byte) (i9 >> 8);
                    i10 = i13 + 1;
                    bArr2[i13] = (byte) i9;
                }
                i8++;
            }
        }
        int i14 = i10;
        if (i5 > 0) {
            int i15 = i9 << (i5 * 6);
            int i16 = i10 + 1;
            bArr2[i10] = (byte) (i15 >> 16);
            i2 = i16;
            if (i5 == 1) {
                bArr2[i16] = (byte) (i15 >> 8);
                i14 = i16 + 1;
            }
            byte[] bArr3 = new byte[i2];
            System.arraycopy(bArr2, 0, bArr3, 0, i2);
            return bArr3;
        }
        i2 = i14;
        byte[] bArr32 = new byte[i2];
        System.arraycopy(bArr2, 0, bArr32, 0, i2);
        return bArr32;
    }

    public static String encode(byte[] bArr) {
        byte[] bArr2 = new byte[((bArr.length + 2) * 4) / 3];
        int length = bArr.length - (bArr.length % 3);
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int i3 = i + 1;
            bArr2[i] = map[(bArr[i2] & 255) >> 2];
            int i4 = i3 + 1;
            bArr2[i3] = map[((bArr[i2] & 3) << 4) | ((bArr[i2 + 1] & 255) >> 4)];
            int i5 = i4 + 1;
            bArr2[i4] = map[((bArr[i2 + 1] & 15) << 2) | ((bArr[i2 + 2] & 255) >> 6)];
            i = i5 + 1;
            bArr2[i5] = map[bArr[i2 + 2] & 63];
        }
        switch (bArr.length % 3) {
            case 1:
                int i6 = i + 1;
                bArr2[i] = map[(bArr[length] & 255) >> 2];
                int i7 = i6 + 1;
                bArr2[i6] = map[(bArr[length] & 3) << 4];
                int i8 = i7 + 1;
                bArr2[i7] = 61;
                bArr2[i8] = 61;
                i = i8 + 1;
                break;
            case 2:
                int i9 = i + 1;
                bArr2[i] = map[(bArr[length] & 255) >> 2];
                int i10 = i9 + 1;
                bArr2[i9] = map[((bArr[length] & 3) << 4) | ((bArr[length + 1] & 255) >> 4)];
                int i11 = i10 + 1;
                bArr2[i10] = map[(bArr[length + 1] & 15) << 2];
                i = i11 + 1;
                bArr2[i11] = 61;
                break;
        }
        return new String(bArr2, 0, i, StandardCharsets.US_ASCII);
    }
}
