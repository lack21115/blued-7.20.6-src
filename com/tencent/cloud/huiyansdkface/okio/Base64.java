package com.tencent.cloud.huiyansdkface.okio;

import com.anythink.expressad.exoplayer.b;
import java.io.UnsupportedEncodingException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okio/Base64.class */
final class Base64 {
    private static final byte[] MAP = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] URL_MAP = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    private Base64() {
    }

    public static byte[] decode(String str) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        char charAt;
        int length = str.length();
        while (true) {
            i = length;
            if (i <= 0 || !((charAt = str.charAt(i - 1)) == '=' || charAt == '\n' || charAt == '\r' || charAt == ' ' || charAt == '\t')) {
                break;
            }
            length = i - 1;
        }
        int i7 = (int) ((i * 6) / 8);
        byte[] bArr = new byte[i7];
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int i12 = i11;
            if (i8 >= i) {
                int i13 = i9 % 4;
                if (i13 == 1) {
                    return null;
                }
                if (i13 == 2) {
                    bArr[i12] = (byte) ((i10 << 12) >> 16);
                    i2 = i12 + 1;
                } else {
                    i2 = i12;
                    if (i13 == 3) {
                        int i14 = i10 << 6;
                        int i15 = i12 + 1;
                        bArr[i12] = (byte) (i14 >> 16);
                        i2 = i15 + 1;
                        bArr[i15] = (byte) (i14 >> 8);
                    }
                }
                if (i2 == i7) {
                    return bArr;
                }
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, 0, bArr2, 0, i2);
                return bArr2;
            }
            char charAt2 = str.charAt(i8);
            if (charAt2 >= 'A' && charAt2 <= 'Z') {
                i3 = charAt2 - 'A';
            } else if (charAt2 >= 'a' && charAt2 <= 'z') {
                i3 = charAt2 - 'G';
            } else if (charAt2 >= '0' && charAt2 <= '9') {
                i3 = charAt2 + 4;
            } else if (charAt2 == '+' || charAt2 == '-') {
                i3 = 62;
            } else if (charAt2 == '/' || charAt2 == '_') {
                i3 = 63;
            } else {
                i4 = i9;
                i5 = i10;
                i6 = i12;
                if (charAt2 != '\n') {
                    i4 = i9;
                    i5 = i10;
                    i6 = i12;
                    if (charAt2 != '\r') {
                        i4 = i9;
                        i5 = i10;
                        i6 = i12;
                        if (charAt2 == ' ') {
                            continue;
                        } else if (charAt2 != '\t') {
                            return null;
                        } else {
                            i4 = i9;
                            i5 = i10;
                            i6 = i12;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
                i8++;
                i9 = i4;
                i10 = i5;
                i11 = i6;
            }
            int i16 = (i10 << 6) | ((byte) i3);
            int i17 = i9 + 1;
            i4 = i17;
            i5 = i16;
            i6 = i12;
            if (i17 % 4 == 0) {
                int i18 = i12 + 1;
                bArr[i12] = (byte) (i16 >> 16);
                int i19 = i18 + 1;
                bArr[i18] = (byte) (i16 >> 8);
                bArr[i19] = (byte) i16;
                i6 = i19 + 1;
                i5 = i16;
                i4 = i17;
            }
            i8++;
            i9 = i4;
            i10 = i5;
            i11 = i6;
        }
    }

    public static String encode(byte[] bArr) {
        return encode(bArr, MAP);
    }

    private static String encode(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int i3 = i + 1;
            bArr3[i] = bArr2[(bArr[i2] & 255) >> 2];
            int i4 = i3 + 1;
            int i5 = i2 + 1;
            bArr3[i3] = bArr2[((bArr[i2] & 3) << 4) | ((bArr[i5] & 255) >> 4)];
            int i6 = i4 + 1;
            byte b = bArr[i5];
            int i7 = i2 + 2;
            bArr3[i4] = bArr2[((b & 15) << 2) | ((bArr[i7] & 255) >> 6)];
            i = i6 + 1;
            bArr3[i6] = bArr2[bArr[i7] & 63];
        }
        int length2 = bArr.length % 3;
        if (length2 == 1) {
            int i8 = i + 1;
            bArr3[i] = bArr2[(bArr[length] & 255) >> 2];
            int i9 = i8 + 1;
            bArr3[i8] = bArr2[(bArr[length] & 3) << 4];
            bArr3[i9] = 61;
            bArr3[i9 + 1] = 61;
        } else if (length2 == 2) {
            int i10 = i + 1;
            bArr3[i] = bArr2[(bArr[length] & 255) >> 2];
            int i11 = i10 + 1;
            byte b2 = bArr[length];
            int i12 = length + 1;
            bArr3[i10] = bArr2[((bArr[i12] & 255) >> 4) | ((b2 & 3) << 4)];
            bArr3[i11] = bArr2[(bArr[i12] & 15) << 2];
            bArr3[i11 + 1] = 61;
        }
        try {
            return new String(bArr3, b.i);
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static String encodeUrl(byte[] bArr) {
        return encode(bArr, URL_MAP);
    }
}
