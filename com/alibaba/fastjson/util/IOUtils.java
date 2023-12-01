package com.alibaba.fastjson.util;

import android.os.Process;
import com.alibaba.fastjson.JSONException;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.util.Arrays;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/util/IOUtils.class */
public class IOUtils {
    public static final char[] ASCII_CHARS;
    public static final char[] CA;
    static final char[] DigitOnes;
    static final char[] DigitTens;
    public static final int[] IA;
    private static final ThreadLocal<SoftReference<char[]>> charsBufLocal;
    private static final ThreadLocal<CharsetDecoder> decoderLocal;
    static final char[] digits;
    public static final boolean[] identifierFlags;
    public static final char[] replaceChars;
    static final int[] sizeTable;
    public static final byte[] specicalFlags_doubleQuotes;
    public static final boolean[] specicalFlags_doubleQuotesFlags;
    public static final byte[] specicalFlags_singleQuotes;
    public static final boolean[] specicalFlags_singleQuotesFlags;
    public static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final boolean[] firstIdentifierFlags = new boolean[256];

    static {
        char c2 = 0;
        while (true) {
            char c3 = c2;
            boolean[] zArr = firstIdentifierFlags;
            if (c3 >= zArr.length) {
                break;
            }
            if (c3 >= 'A' && c3 <= 'Z') {
                zArr[c3] = true;
            } else if (c3 >= 'a' && c3 <= 'z') {
                firstIdentifierFlags[c3] = true;
            } else if (c3 == '_') {
                firstIdentifierFlags[c3] = true;
            }
            c2 = (char) (c3 + 1);
        }
        identifierFlags = new boolean[256];
        char c4 = 0;
        while (true) {
            char c5 = c4;
            boolean[] zArr2 = identifierFlags;
            if (c5 >= zArr2.length) {
                break;
            }
            if (c5 >= 'A' && c5 <= 'Z') {
                zArr2[c5] = true;
            } else if (c5 >= 'a' && c5 <= 'z') {
                identifierFlags[c5] = true;
            } else if (c5 == '_') {
                identifierFlags[c5] = true;
            } else if (c5 >= '0' && c5 <= '9') {
                identifierFlags[c5] = true;
            }
            c4 = (char) (c5 + 1);
        }
        byte[] bArr = new byte[161];
        specicalFlags_doubleQuotes = bArr;
        byte[] bArr2 = new byte[161];
        specicalFlags_singleQuotes = bArr2;
        specicalFlags_doubleQuotesFlags = new boolean[161];
        specicalFlags_singleQuotesFlags = new boolean[161];
        replaceChars = new char[93];
        bArr[0] = 4;
        bArr[1] = 4;
        bArr[2] = 4;
        bArr[3] = 4;
        bArr[4] = 4;
        bArr[5] = 4;
        bArr[6] = 4;
        bArr[7] = 4;
        bArr[8] = 1;
        bArr[9] = 1;
        bArr[10] = 1;
        bArr[11] = 4;
        bArr[12] = 1;
        bArr[13] = 1;
        bArr[34] = 1;
        bArr[92] = 1;
        bArr2[0] = 4;
        bArr2[1] = 4;
        bArr2[2] = 4;
        bArr2[3] = 4;
        bArr2[4] = 4;
        bArr2[5] = 4;
        bArr2[6] = 4;
        bArr2[7] = 4;
        bArr2[8] = 1;
        bArr2[9] = 1;
        bArr2[10] = 1;
        bArr2[11] = 4;
        bArr2[12] = 1;
        bArr2[13] = 1;
        bArr2[92] = 1;
        bArr2[39] = 1;
        int i = 14;
        while (true) {
            int i2 = i;
            if (i2 > 31) {
                break;
            }
            specicalFlags_doubleQuotes[i2] = 4;
            specicalFlags_singleQuotes[i2] = 4;
            i = i2 + 1;
        }
        int i3 = 127;
        while (true) {
            int i4 = i3;
            if (i4 > 160) {
                break;
            }
            specicalFlags_doubleQuotes[i4] = 4;
            specicalFlags_singleQuotes[i4] = 4;
            i3 = i4 + 1;
        }
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= 161) {
                break;
            }
            specicalFlags_doubleQuotesFlags[i6] = specicalFlags_doubleQuotes[i6] != 0;
            specicalFlags_singleQuotesFlags[i6] = specicalFlags_singleQuotes[i6] != 0;
            i5 = i6 + 1;
        }
        char[] cArr = replaceChars;
        cArr[0] = '0';
        cArr[1] = '1';
        cArr[2] = '2';
        cArr[3] = '3';
        cArr[4] = '4';
        cArr[5] = '5';
        cArr[6] = '6';
        cArr[7] = '7';
        cArr[8] = 'b';
        cArr[9] = 't';
        cArr[10] = 'n';
        cArr[11] = 'v';
        cArr[12] = 'f';
        cArr[13] = 'r';
        cArr[34] = '\"';
        cArr[39] = '\'';
        cArr[47] = '/';
        cArr[92] = '\\';
        ASCII_CHARS = new char[]{'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};
        digits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        DigitTens = new char[]{'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
        DigitOnes = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        sizeTable = new int[]{9, 99, 999, 9999, Process.LAST_ISOLATED_UID, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
        CA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        int[] iArr = new int[256];
        IA = iArr;
        Arrays.fill(iArr, -1);
        int length = CA.length;
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= length) {
                IA[61] = 0;
                charsBufLocal = new ThreadLocal<>();
                decoderLocal = new ThreadLocal<>();
                return;
            }
            IA[CA[i8]] = i8;
            i7 = i8 + 1;
        }
    }

    private static char[] allocate(int i) {
        if (i > 131072) {
            return new char[i];
        }
        char[] cArr = new char[(i >>> 10) <= 0 ? 1024 : 1 << (32 - Integer.numberOfLeadingZeros(i - 1))];
        charsBufLocal.set(new SoftReference<>(cArr));
        return cArr;
    }

    public static void clearChars() {
        charsBufLocal.set(null);
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
            }
        }
    }

    public static void decode(CharsetDecoder charsetDecoder, ByteBuffer byteBuffer, CharBuffer charBuffer) {
        try {
            CoderResult decode = charsetDecoder.decode(byteBuffer, charBuffer, true);
            if (!decode.isUnderflow()) {
                decode.throwException();
            }
            CoderResult flush = charsetDecoder.flush(charBuffer);
            if (flush.isUnderflow()) {
                return;
            }
            flush.throwException();
        } catch (CharacterCodingException e) {
            throw new JSONException("utf8 decode error, " + e.getMessage(), e);
        }
    }

    public static byte[] decodeFast(String str) {
        int i;
        int i2;
        int i3;
        int length = str.length();
        if (length == 0) {
            return new byte[0];
        }
        int i4 = length - 1;
        int i5 = 0;
        while (true) {
            i = i5;
            i2 = i4;
            if (i >= i4) {
                break;
            }
            i2 = i4;
            if (IA[str.charAt(i) & 255] >= 0) {
                break;
            }
            i5 = i + 1;
        }
        while (i2 > 0 && IA[str.charAt(i2) & 255] < 0) {
            i2--;
        }
        int i6 = str.charAt(i2) == '=' ? str.charAt(i2 - 1) == '=' ? 2 : 1 : 0;
        int i7 = (i2 - i) + 1;
        int i8 = length > 76 ? (str.charAt(76) == '\r' ? i7 / 78 : 0) << 1 : 0;
        int i9 = (((i7 - i8) * 6) >> 3) - i6;
        byte[] bArr = new byte[i9];
        int i10 = i9 / 3;
        int i11 = 0;
        int i12 = 0;
        while (i11 < i10 * 3) {
            int i13 = i + 1;
            int i14 = IA[str.charAt(i)];
            int i15 = i13 + 1;
            int i16 = IA[str.charAt(i13)];
            int i17 = i15 + 1;
            i = i17 + 1;
            int i18 = (i14 << 18) | (i16 << 12) | (IA[str.charAt(i15)] << 6) | IA[str.charAt(i17)];
            int i19 = i11 + 1;
            bArr[i11] = (byte) (i18 >> 16);
            int i20 = i19 + 1;
            bArr[i19] = (byte) (i18 >> 8);
            bArr[i20] = (byte) i18;
            int i21 = i12;
            if (i8 > 0) {
                int i22 = i12 + 1;
                i21 = i22;
                if (i22 == 19) {
                    i += 2;
                    i3 = 0;
                    i12 = i3;
                    i11 = i20 + 1;
                }
            }
            i3 = i21;
            i12 = i3;
            i11 = i20 + 1;
        }
        if (i11 < i9) {
            int i23 = 0;
            int i24 = 0;
            for (int i25 = i; i25 <= i2 - i6; i25++) {
                i24 |= IA[str.charAt(i25)] << (18 - (i23 * 6));
                i23++;
            }
            int i26 = 16;
            while (i11 < i9) {
                bArr[i11] = (byte) (i24 >> i26);
                i26 -= 8;
                i11++;
            }
        }
        return bArr;
    }

    public static byte[] decodeFast(String str, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (i2 == 0) {
            return new byte[0];
        }
        int i7 = (i + i2) - 1;
        int i8 = i;
        while (true) {
            i3 = i8;
            i4 = i7;
            if (i3 >= i7) {
                break;
            }
            i4 = i7;
            if (IA[str.charAt(i3)] >= 0) {
                break;
            }
            i8 = i3 + 1;
        }
        while (i4 > 0 && IA[str.charAt(i4)] < 0) {
            i4--;
        }
        int i9 = str.charAt(i4) == '=' ? str.charAt(i4 - 1) == '=' ? 2 : 1 : 0;
        int i10 = (i4 - i3) + 1;
        if (i2 > 76) {
            i5 = (str.charAt(76) == '\r' ? i10 / 78 : 0) << 1;
        } else {
            i5 = 0;
        }
        int i11 = (((i10 - i5) * 6) >> 3) - i9;
        byte[] bArr = new byte[i11];
        int i12 = i11 / 3;
        int i13 = 0;
        int i14 = i3;
        int i15 = 0;
        while (i13 < i12 * 3) {
            int i16 = i14 + 1;
            int i17 = IA[str.charAt(i14)];
            int i18 = i16 + 1;
            int i19 = IA[str.charAt(i16)];
            int i20 = i18 + 1;
            i14 = i20 + 1;
            int i21 = (i17 << 18) | (i19 << 12) | (IA[str.charAt(i18)] << 6) | IA[str.charAt(i20)];
            int i22 = i13 + 1;
            bArr[i13] = (byte) (i21 >> 16);
            int i23 = i22 + 1;
            bArr[i22] = (byte) (i21 >> 8);
            bArr[i23] = (byte) i21;
            int i24 = i15;
            if (i5 > 0) {
                int i25 = i15 + 1;
                i24 = i25;
                if (i25 == 19) {
                    i14 += 2;
                    i6 = 0;
                    i15 = i6;
                    i13 = i23 + 1;
                }
            }
            i6 = i24;
            i15 = i6;
            i13 = i23 + 1;
        }
        if (i13 < i11) {
            int i26 = 0;
            int i27 = 0;
            while (i14 <= i4 - i9) {
                i27 |= IA[str.charAt(i14)] << (18 - (i26 * 6));
                i26++;
                i14++;
            }
            int i28 = 16;
            while (i13 < i11) {
                bArr[i13] = (byte) (i27 >> i28);
                i28 -= 8;
                i13++;
            }
        }
        return bArr;
    }

    public static byte[] decodeFast(char[] cArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (i2 == 0) {
            return new byte[0];
        }
        int i7 = (i + i2) - 1;
        int i8 = i;
        while (true) {
            i3 = i8;
            i4 = i7;
            if (i3 >= i7) {
                break;
            }
            i4 = i7;
            if (IA[cArr[i3]] >= 0) {
                break;
            }
            i8 = i3 + 1;
        }
        while (i4 > 0 && IA[cArr[i4]] < 0) {
            i4--;
        }
        int i9 = cArr[i4] == '=' ? cArr[i4 - 1] == '=' ? 2 : 1 : 0;
        int i10 = (i4 - i3) + 1;
        if (i2 > 76) {
            i5 = (cArr[76] == '\r' ? i10 / 78 : 0) << 1;
        } else {
            i5 = 0;
        }
        int i11 = (((i10 - i5) * 6) >> 3) - i9;
        byte[] bArr = new byte[i11];
        int i12 = i11 / 3;
        int i13 = 0;
        int i14 = i3;
        int i15 = 0;
        while (i13 < i12 * 3) {
            int[] iArr = IA;
            int i16 = i14 + 1;
            int i17 = iArr[cArr[i14]];
            int i18 = i16 + 1;
            int i19 = iArr[cArr[i16]];
            int i20 = i18 + 1;
            i14 = i20 + 1;
            int i21 = (i17 << 18) | (i19 << 12) | (iArr[cArr[i18]] << 6) | iArr[cArr[i20]];
            int i22 = i13 + 1;
            bArr[i13] = (byte) (i21 >> 16);
            int i23 = i22 + 1;
            bArr[i22] = (byte) (i21 >> 8);
            bArr[i23] = (byte) i21;
            int i24 = i15;
            if (i5 > 0) {
                int i25 = i15 + 1;
                i24 = i25;
                if (i25 == 19) {
                    i14 += 2;
                    i6 = 0;
                    i15 = i6;
                    i13 = i23 + 1;
                }
            }
            i6 = i24;
            i15 = i6;
            i13 = i23 + 1;
        }
        if (i13 < i11) {
            int i26 = 0;
            int i27 = 0;
            while (i14 <= i4 - i9) {
                i27 |= IA[cArr[i14]] << (18 - (i26 * 6));
                i26++;
                i14++;
            }
            int i28 = 16;
            while (i13 < i11) {
                bArr[i13] = (byte) (i27 >> i28);
                i28 -= 8;
                i13++;
            }
        }
        return bArr;
    }

    public static boolean firstIdentifier(char c2) {
        boolean[] zArr = firstIdentifierFlags;
        return c2 < zArr.length && zArr[c2];
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    public static void getChars(byte b, int i, char[] cArr) {
        char c2;
        if (b < 0) {
            c2 = '-';
            b = -b;
        } else {
            c2 = 0;
        }
        while (true) {
            int i2 = (52429 * b) >>> 19;
            i--;
            cArr[i] = digits[b - ((i2 << 3) + (i2 << 1))];
            if (i2 == 0) {
                break;
            }
            b = i2;
        }
        if (c2 != 0) {
            cArr[i - 1] = c2;
        }
    }

    public static void getChars(int i, int i2, char[] cArr) {
        char c2;
        int i3;
        int i4;
        if (i < 0) {
            c2 = '-';
            i = -i;
        } else {
            c2 = 0;
        }
        while (true) {
            i3 = i;
            i4 = i2;
            if (i < 65536) {
                break;
            }
            int i5 = i / 100;
            int i6 = i - (((i5 << 6) + (i5 << 5)) + (i5 << 2));
            int i7 = i2 - 1;
            cArr[i7] = DigitOnes[i6];
            i2 = i7 - 1;
            cArr[i2] = DigitTens[i6];
            i = i5;
        }
        while (true) {
            int i8 = (52429 * i3) >>> 19;
            i4--;
            cArr[i4] = digits[i3 - ((i8 << 3) + (i8 << 1))];
            if (i8 == 0) {
                break;
            }
            i3 = i8;
        }
        if (c2 != 0) {
            cArr[i4 - 1] = c2;
        }
    }

    public static void getChars(long j, int i, char[] cArr) {
        char c2;
        int i2;
        int i3;
        if (j < 0) {
            c2 = '-';
            j = -j;
        } else {
            c2 = 0;
        }
        while (j > 2147483647L) {
            long j2 = j / 100;
            int i4 = (int) (j - (((j2 << 6) + (j2 << 5)) + (j2 << 2)));
            int i5 = i - 1;
            cArr[i5] = DigitOnes[i4];
            i = i5 - 1;
            cArr[i] = DigitTens[i4];
            j = j2;
        }
        int i6 = (int) j;
        while (true) {
            int i7 = i6;
            i2 = i7;
            i3 = i;
            if (i7 < 65536) {
                break;
            }
            int i8 = i7 / 100;
            int i9 = i7 - (((i8 << 6) + (i8 << 5)) + (i8 << 2));
            int i10 = i - 1;
            cArr[i10] = DigitOnes[i9];
            i = i10 - 1;
            cArr[i] = DigitTens[i9];
            i6 = i8;
        }
        while (true) {
            int i11 = (52429 * i2) >>> 19;
            i3--;
            cArr[i3] = digits[i2 - ((i11 << 3) + (i11 << 1))];
            if (i11 == 0) {
                break;
            }
            i2 = i11;
        }
        if (c2 != 0) {
            cArr[i3 - 1] = c2;
        }
    }

    public static char[] getChars(int i) {
        char[] cArr;
        SoftReference<char[]> softReference = charsBufLocal.get();
        if (softReference != null && (cArr = softReference.get()) != null) {
            char[] cArr2 = cArr;
            if (cArr.length < i) {
                cArr2 = allocate(i);
            }
            return cArr2;
        }
        return allocate(i);
    }

    public static CharsetDecoder getUTF8Decoder() {
        CharsetDecoder charsetDecoder = decoderLocal.get();
        UTF8Decoder uTF8Decoder = charsetDecoder;
        if (charsetDecoder == null) {
            uTF8Decoder = new UTF8Decoder();
            decoderLocal.set(uTF8Decoder);
        }
        return uTF8Decoder;
    }

    public static boolean isIdent(char c2) {
        boolean[] zArr = identifierFlags;
        return c2 < zArr.length && zArr[c2];
    }

    public static String readAll(Reader reader) {
        StringBuilder sb = new StringBuilder();
        try {
            char[] cArr = new char[2048];
            while (true) {
                int read = reader.read(cArr, 0, 2048);
                if (read < 0) {
                    return sb.toString();
                }
                sb.append(cArr, 0, read);
            }
        } catch (Exception e) {
            throw new JSONException("read string from reader error", e);
        }
    }

    public static int stringSize(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i <= sizeTable[i3]) {
                return i3 + 1;
            }
            i2 = i3 + 1;
        }
    }

    public static int stringSize(long j) {
        long j2 = 10;
        for (int i = 1; i < 19; i++) {
            if (j < j2) {
                return i;
            }
            j2 *= 10;
        }
        return 19;
    }

    public static String toString(InputStream inputStream) throws Exception {
        return readAll(new BufferedReader(new InputStreamReader(inputStream)));
    }
}
