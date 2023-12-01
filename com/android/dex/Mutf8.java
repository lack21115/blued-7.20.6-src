package com.android.dex;

import java.io.UTFDataFormatException;

/* loaded from: source-2895416-dex2jar.jar:com/android/dex/Mutf8.class */
public final class Mutf8 {
    private Mutf8() {
    }

    private static long countBytes(String str, boolean z) throws UTFDataFormatException {
        long j = 0;
        int length = str.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return j;
            }
            char charAt = str.charAt(i2);
            j = (charAt == 0 || charAt > 127) ? charAt <= 2047 ? j + 2 : j + 3 : j + 1;
            if (z && j > 65535) {
                throw new UTFDataFormatException("String more than 65535 UTF bytes long");
            }
            i = i2 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b8, code lost:
        throw new java.io.UTFDataFormatException("bad second or third byte");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String decode(com.android.dex.util.ByteInput r6, char[] r7) throws java.io.UTFDataFormatException {
        /*
            Method dump skipped, instructions count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.dex.Mutf8.decode(com.android.dex.util.ByteInput, char[]):java.lang.String");
    }

    public static void encode(byte[] bArr, int i, String str) {
        int length = str.length();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            char charAt = str.charAt(i3);
            if (charAt != 0 && charAt <= 127) {
                bArr[i] = (byte) charAt;
                i++;
            } else if (charAt <= 2047) {
                int i4 = i + 1;
                bArr[i] = (byte) (((charAt >> 6) & 31) | 192);
                bArr[i4] = (byte) ((charAt & '?') | 128);
                i = i4 + 1;
            } else {
                int i5 = i + 1;
                bArr[i] = (byte) (((charAt >> '\f') & 15) | 224);
                int i6 = i5 + 1;
                bArr[i5] = (byte) (((charAt >> 6) & 63) | 128);
                i = i6 + 1;
                bArr[i6] = (byte) ((charAt & '?') | 128);
            }
            i2 = i3 + 1;
        }
    }

    public static byte[] encode(String str) throws UTFDataFormatException {
        byte[] bArr = new byte[(int) countBytes(str, true)];
        encode(bArr, 0, str);
        return bArr;
    }
}
