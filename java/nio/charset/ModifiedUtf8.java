package java.nio.charset;

import java.io.UTFDataFormatException;
import java.nio.ByteOrder;
import libcore.io.Memory;

/* loaded from: source-2895416-dex2jar.jar:java/nio/charset/ModifiedUtf8.class */
public class ModifiedUtf8 {
    private ModifiedUtf8() {
    }

    public static long countBytes(String str, boolean z) throws UTFDataFormatException {
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

    public static String decode(byte[] bArr, char[] cArr, int i, int i2) throws UTFDataFormatException {
        int i3 = 0;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = i4 + 1;
            char c2 = (char) bArr[i + i4];
            cArr[i3] = c2;
            if (c2 < 128) {
                i3++;
                i4 = i5;
            } else {
                char c3 = cArr[i3];
                if ((c3 & 224) == 192) {
                    if (i5 >= i2) {
                        throw new UTFDataFormatException("bad second byte at " + i5);
                    }
                    i4 = i5 + 1;
                    byte b = bArr[i + i5];
                    if ((b & 192) != 128) {
                        throw new UTFDataFormatException("bad second byte at " + (i4 - 1));
                    }
                    cArr[i3] = (char) (((c3 & 31) << 6) | (b & 63));
                    i3++;
                } else if ((c3 & 240) != 224) {
                    throw new UTFDataFormatException("bad byte at " + (i5 - 1));
                } else {
                    if (i5 + 1 >= i2) {
                        throw new UTFDataFormatException("bad third byte at " + (i5 + 1));
                    }
                    int i6 = i5 + 1;
                    byte b2 = bArr[i + i5];
                    i4 = i6 + 1;
                    byte b3 = bArr[i + i6];
                    if ((b2 & 192) != 128 || (b3 & 192) != 128) {
                        throw new UTFDataFormatException("bad second or third byte at " + (i4 - 2));
                    }
                    cArr[i3] = (char) (((c3 & 15) << 12) | ((b2 & 63) << 6) | (b3 & 63));
                    i3++;
                }
            }
        }
        return new String(cArr, 0, i3);
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
        int countBytes = (int) countBytes(str, true);
        byte[] bArr = new byte[countBytes + 2];
        Memory.pokeShort(bArr, 0, (short) countBytes, ByteOrder.BIG_ENDIAN);
        encode(bArr, 2, str);
        return bArr;
    }
}
