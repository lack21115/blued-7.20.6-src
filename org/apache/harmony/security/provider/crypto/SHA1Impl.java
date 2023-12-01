package org.apache.harmony.security.provider.crypto;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/provider/crypto/SHA1Impl.class */
public class SHA1Impl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void computeHash(int[] iArr) {
        int i;
        int i2 = iArr[82];
        int i3 = iArr[83];
        int i4 = iArr[84];
        int i5 = iArr[85];
        int i6 = iArr[86];
        int i7 = 16;
        while (true) {
            int i8 = i7;
            if (i8 >= 80) {
                break;
            }
            int i9 = ((iArr[i8 - 3] ^ iArr[i8 - 8]) ^ iArr[i8 - 14]) ^ iArr[i8 - 16];
            iArr[i8] = (i9 << 1) | (i9 >>> 31);
            i7 = i8 + 1;
        }
        int i10 = 0;
        int i11 = i2;
        while (i10 < 20) {
            int i12 = i5;
            int i13 = i4;
            int i14 = (i3 << 30) | (i3 >>> 2);
            int i15 = i11;
            i11 = ((i11 << 5) | (i11 >>> 27)) + ((i3 & i4) | ((i3 ^ (-1)) & i5)) + iArr[i10] + i6 + 1518500249;
            i10++;
            i3 = i15;
            i4 = i14;
            i5 = i13;
            i6 = i12;
        }
        int i16 = 20;
        while (i16 < 40) {
            int i17 = i5;
            int i18 = i4;
            int i19 = (i3 << 30) | (i3 >>> 2);
            int i20 = i11;
            i11 = ((i11 << 5) | (i11 >>> 27)) + ((i3 ^ i4) ^ i5) + iArr[i16] + i6 + 1859775393;
            i16++;
            i3 = i20;
            i4 = i19;
            i5 = i18;
            i6 = i17;
        }
        int i21 = 40;
        while (true) {
            i = i3;
            if (i21 >= 60) {
                break;
            }
            int i22 = i5;
            int i23 = i4;
            i3 = i11;
            i11 = ((i11 << 5) | (i11 >>> 27)) + ((i & i4) | (i & i5) | (i4 & i5)) + ((iArr[i21] + i6) - 1894007588);
            i21++;
            i4 = (i << 30) | (i >>> 2);
            i5 = i23;
            i6 = i22;
        }
        int i24 = 60;
        int i25 = i5;
        int i26 = i4;
        int i27 = i;
        while (true) {
            int i28 = i6;
            int i29 = i25;
            int i30 = i27;
            if (i24 >= 80) {
                iArr[82] = iArr[82] + i11;
                iArr[83] = iArr[83] + i30;
                iArr[84] = iArr[84] + i26;
                iArr[85] = iArr[85] + i29;
                iArr[86] = iArr[86] + i28;
                return;
            }
            i6 = i29;
            i25 = i26;
            i27 = i11;
            i11 = ((i11 << 5) | (i11 >>> 27)) + ((i30 ^ i26) ^ i29) + ((iArr[i24] + i28) - 899497514);
            i24++;
            i26 = (i30 << 30) | (i30 >>> 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void updateHash(int[] iArr, byte[] bArr, int i, int i2) {
        int i3 = iArr[81];
        int i4 = i;
        int i5 = i3 >> 2;
        int i6 = i3 & 3;
        iArr[81] = (((i3 + i2) - i) + 1) & 63;
        int i7 = i4;
        int i8 = i5;
        if (i6 != 0) {
            int i9 = i6;
            while (i4 <= i2 && i9 < 4) {
                iArr[i5] = iArr[i5] | ((bArr[i4] & 255) << ((3 - i9) << 3));
                i9++;
                i4++;
            }
            i8 = i5;
            if (i9 == 4) {
                int i10 = i5 + 1;
                i8 = i10;
                if (i10 == 16) {
                    computeHash(iArr);
                    i8 = 0;
                }
            }
            i7 = i4;
            if (i4 > i2) {
                return;
            }
        }
        int i11 = 0;
        int i12 = i8;
        int i13 = i7;
        while (i11 < (((i2 - i7) + 1) >> 2)) {
            iArr[i12] = ((bArr[i13] & 255) << 24) | ((bArr[i13 + 1] & 255) << 16) | ((bArr[i13 + 2] & 255) << 8) | (bArr[i13 + 3] & 255);
            i13 += 4;
            int i14 = i12 + 1;
            if (i14 >= 16) {
                computeHash(iArr);
                i14 = 0;
            }
            i11++;
            i12 = i14;
        }
        int i15 = (i2 - i13) + 1;
        if (i15 != 0) {
            int i16 = (bArr[i13] & 255) << 24;
            int i17 = i16;
            if (i15 != 1) {
                int i18 = i16 | ((bArr[i13 + 1] & 255) << 16);
                i17 = i18;
                if (i15 != 2) {
                    i17 = i18 | ((bArr[i13 + 2] & 255) << 8);
                }
            }
            iArr[i12] = i17;
        }
    }
}
