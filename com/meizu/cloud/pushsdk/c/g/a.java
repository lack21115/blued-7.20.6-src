package com.meizu.cloud.pushsdk.c.g;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/g/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f24058a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    public static byte[] a(String str) {
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
                System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, i2);
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
}
