package com.sobot.chat.widget.zxing.pdf417.encoder;

import com.sobot.chat.widget.zxing.WriterException;
import com.sobot.chat.widget.zxing.common.CharacterSetECI;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/pdf417/encoder/PDF417HighLevelEncoder.class */
final class PDF417HighLevelEncoder {
    private static final int BYTE_COMPACTION = 1;
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final int LATCH_TO_BYTE = 924;
    private static final int LATCH_TO_BYTE_PADDED = 901;
    private static final int LATCH_TO_NUMERIC = 902;
    private static final int LATCH_TO_TEXT = 900;
    private static final int NUMERIC_COMPACTION = 2;
    private static final int SHIFT_TO_BYTE = 913;
    private static final int SUBMODE_ALPHA = 0;
    private static final int SUBMODE_LOWER = 1;
    private static final int SUBMODE_MIXED = 2;
    private static final int SUBMODE_PUNCTUATION = 3;
    private static final int TEXT_COMPACTION = 0;
    private static final byte[] TEXT_MIXED_RAW = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0};
    private static final byte[] TEXT_PUNCTUATION_RAW = {59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39, 0};
    private static final byte[] MIXED = new byte[128];
    private static final byte[] PUNCTUATION = new byte[128];
    private static final Charset DEFAULT_ENCODING = StandardCharsets.ISO_8859_1;

    /* renamed from: com.sobot.chat.widget.zxing.pdf417.encoder.PDF417HighLevelEncoder$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/pdf417/encoder/PDF417HighLevelEncoder$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$sobot$chat$widget$zxing$pdf417$encoder$Compaction;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[Compaction.values().length];
            $SwitchMap$com$sobot$chat$widget$zxing$pdf417$encoder$Compaction = iArr;
            try {
                iArr[Compaction.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$sobot$chat$widget$zxing$pdf417$encoder$Compaction[Compaction.BYTE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$sobot$chat$widget$zxing$pdf417$encoder$Compaction[Compaction.NUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    static {
        Arrays.fill(MIXED, (byte) -1);
        int i = 0;
        while (true) {
            int i2 = i;
            byte[] bArr = TEXT_MIXED_RAW;
            if (i2 >= bArr.length) {
                break;
            }
            byte b = bArr[i2];
            if (b > 0) {
                MIXED[b] = (byte) i2;
            }
            i = i2 + 1;
        }
        Arrays.fill(PUNCTUATION, (byte) -1);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            byte[] bArr2 = TEXT_PUNCTUATION_RAW;
            if (i4 >= bArr2.length) {
                return;
            }
            byte b2 = bArr2[i4];
            if (b2 > 0) {
                PUNCTUATION[b2] = (byte) i4;
            }
            i3 = i4 + 1;
        }
    }

    private PDF417HighLevelEncoder() {
    }

    private static int determineConsecutiveBinaryCount(String str, int i, Charset charset) throws WriterException {
        int i2;
        CharsetEncoder newEncoder = charset.newEncoder();
        int length = str.length();
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                return i4 - i;
            }
            char charAt = str.charAt(i4);
            int i5 = 0;
            while (true) {
                i2 = i5;
                if (i5 >= 13) {
                    break;
                }
                i2 = i5;
                if (!isDigit(charAt)) {
                    break;
                }
                i5++;
                int i6 = i4 + i5;
                if (i6 >= length) {
                    i2 = i5;
                    break;
                }
                charAt = str.charAt(i6);
            }
            if (i2 >= 13) {
                return i4 - i;
            }
            char charAt2 = str.charAt(i4);
            if (!newEncoder.canEncode(charAt2)) {
                throw new WriterException("Non-encodable character detected: " + charAt2 + " (Unicode: " + ((int) charAt2) + ')');
            }
            i3 = i4 + 1;
        }
    }

    private static int determineConsecutiveDigitCount(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        if (i < length) {
            char charAt = charSequence.charAt(i);
            int i3 = i;
            int i4 = 0;
            while (true) {
                i2 = i4;
                if (!isDigit(charAt)) {
                    break;
                }
                i2 = i4;
                if (i3 >= length) {
                    break;
                }
                int i5 = i4 + 1;
                int i6 = i3 + 1;
                i4 = i5;
                i3 = i6;
                if (i6 < length) {
                    charAt = charSequence.charAt(i6);
                    i4 = i5;
                    i3 = i6;
                }
            }
        }
        return i2;
    }

    private static int determineConsecutiveTextCount(CharSequence charSequence, int i) {
        int i2;
        int length = charSequence.length();
        int i3 = i;
        while (true) {
            i2 = i3;
            if (i3 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i3);
            int i4 = 0;
            while (i4 < 13 && isDigit(charAt) && i3 < length) {
                int i5 = i4 + 1;
                int i6 = i3 + 1;
                i3 = i6;
                i4 = i5;
                if (i6 < length) {
                    charAt = charSequence.charAt(i6);
                    i3 = i6;
                    i4 = i5;
                }
            }
            if (i4 >= 13) {
                return (i3 - i) - i4;
            }
            if (i4 <= 0) {
                if (!isText(charSequence.charAt(i3))) {
                    i2 = i3;
                    break;
                }
                i3++;
            }
        }
        return i2 - i;
    }

    private static void encodeBinary(byte[] bArr, int i, int i2, int i3, StringBuilder sb) {
        int i4;
        long j;
        int i5;
        if (i2 == 1 && i3 == 0) {
            sb.append((char) 913);
        } else if (i2 % 6 == 0) {
            sb.append((char) 924);
        } else {
            sb.append((char) 901);
        }
        if (i2 >= 6) {
            char[] cArr = new char[5];
            int i6 = i;
            while (true) {
                int i7 = i6;
                i4 = i7;
                if ((i + i2) - i7 < 6) {
                    break;
                }
                long j2 = 0;
                int i8 = 0;
                while (true) {
                    int i9 = i8;
                    j = j2;
                    if (i9 >= 6) {
                        break;
                    }
                    j2 = (j2 << 8) + (bArr[i7 + i9] & 255);
                    i8 = i9 + 1;
                }
                for (i5 = 0; i5 < 5; i5++) {
                    cArr[i5] = (char) (j % 900);
                    j /= 900;
                }
                int i10 = 4;
                while (true) {
                    int i11 = i10;
                    if (i11 >= 0) {
                        sb.append(cArr[i11]);
                        i10 = i11 - 1;
                    }
                }
                i6 = i7 + 6;
            }
        } else {
            i4 = i;
        }
        while (i4 < i + i2) {
            sb.append((char) (bArr[i4] & 255));
            i4++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String encodeHighLevel(String str, Compaction compaction, Charset charset) throws WriterException {
        Charset charset2;
        StringBuilder sb = new StringBuilder(str.length());
        if (charset == null) {
            charset2 = DEFAULT_ENCODING;
        } else {
            charset2 = charset;
            if (!DEFAULT_ENCODING.equals(charset)) {
                CharacterSetECI characterSetECIByName = CharacterSetECI.getCharacterSetECIByName(charset.name());
                charset2 = charset;
                if (characterSetECIByName != null) {
                    encodingECI(characterSetECIByName.getValue(), sb);
                    charset2 = charset;
                }
            }
        }
        int length = str.length();
        int i = AnonymousClass1.$SwitchMap$com$sobot$chat$widget$zxing$pdf417$encoder$Compaction[compaction.ordinal()];
        if (i == 1) {
            encodeText(str, 0, length, sb, 0);
        } else if (i == 2) {
            byte[] bytes = str.getBytes(charset2);
            encodeBinary(bytes, 0, bytes.length, 1, sb);
        } else if (i != 3) {
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (i2 < length) {
                int determineConsecutiveDigitCount = determineConsecutiveDigitCount(str, i2);
                if (determineConsecutiveDigitCount >= 13) {
                    sb.append((char) 902);
                    encodeNumeric(str, i2, determineConsecutiveDigitCount, sb);
                    i2 += determineConsecutiveDigitCount;
                    i3 = 0;
                    i4 = 2;
                } else {
                    int determineConsecutiveTextCount = determineConsecutiveTextCount(str, i2);
                    if (determineConsecutiveTextCount >= 5 || determineConsecutiveDigitCount == length) {
                        int i5 = i4;
                        if (i4 != 0) {
                            sb.append((char) 900);
                            i3 = 0;
                            i5 = 0;
                        }
                        i3 = encodeText(str, i2, determineConsecutiveTextCount, sb, i3);
                        i2 += determineConsecutiveTextCount;
                        i4 = i5;
                    } else {
                        int determineConsecutiveBinaryCount = determineConsecutiveBinaryCount(str, i2, charset2);
                        int i6 = determineConsecutiveBinaryCount;
                        if (determineConsecutiveBinaryCount == 0) {
                            i6 = 1;
                        }
                        int i7 = i6 + i2;
                        byte[] bytes2 = str.substring(i2, i7).getBytes(charset2);
                        if (bytes2.length == 1 && i4 == 0) {
                            encodeBinary(bytes2, 0, 1, 0, sb);
                        } else {
                            encodeBinary(bytes2, 0, bytes2.length, i4, sb);
                            i3 = 0;
                            i4 = 1;
                        }
                        i2 = i7;
                    }
                }
            }
        } else {
            sb.append((char) 902);
            encodeNumeric(str, 0, length, sb);
        }
        return sb.toString();
    }

    private static void encodeNumeric(String str, int i, int i2, StringBuilder sb) {
        BigInteger divide;
        StringBuilder sb2 = new StringBuilder((i2 / 3) + 1);
        BigInteger valueOf = BigInteger.valueOf(900L);
        BigInteger valueOf2 = BigInteger.valueOf(0L);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return;
            }
            sb2.setLength(0);
            int min = Math.min(44, i2 - i4);
            StringBuilder sb3 = new StringBuilder();
            sb3.append('1');
            int i5 = i + i4;
            sb3.append(str.substring(i5, i5 + min));
            BigInteger bigInteger = new BigInteger(sb3.toString());
            do {
                sb2.append((char) bigInteger.mod(valueOf).intValue());
                divide = bigInteger.divide(valueOf);
                bigInteger = divide;
            } while (!divide.equals(valueOf2));
            int length = sb2.length();
            while (true) {
                int i6 = length - 1;
                if (i6 >= 0) {
                    sb.append(sb2.charAt(i6));
                    length = i6;
                }
            }
            i3 = i4 + min;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x000d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01bf A[EDGE_INSN: B:83:0x01bf->B:59:0x01bf ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int encodeText(java.lang.CharSequence r4, int r5, int r6, java.lang.StringBuilder r7, int r8) {
        /*
            Method dump skipped, instructions count: 548
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.widget.zxing.pdf417.encoder.PDF417HighLevelEncoder.encodeText(java.lang.CharSequence, int, int, java.lang.StringBuilder, int):int");
    }

    private static void encodingECI(int i, StringBuilder sb) throws WriterException {
        if (i >= 0 && i < 900) {
            sb.append((char) 927);
            sb.append((char) i);
        } else if (i < 810900) {
            sb.append((char) 926);
            sb.append((char) ((i / 900) - 1));
            sb.append((char) (i % 900));
        } else if (i < 811800) {
            sb.append((char) 925);
            sb.append((char) (810900 - i));
        } else {
            throw new WriterException("ECI number not in valid range from 0..811799, but was " + i);
        }
    }

    private static boolean isAlphaLower(char c2) {
        if (c2 != ' ') {
            return c2 >= 'a' && c2 <= 'z';
        }
        return true;
    }

    private static boolean isAlphaUpper(char c2) {
        if (c2 != ' ') {
            return c2 >= 'A' && c2 <= 'Z';
        }
        return true;
    }

    private static boolean isDigit(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    private static boolean isMixed(char c2) {
        return MIXED[c2] != -1;
    }

    private static boolean isPunctuation(char c2) {
        return PUNCTUATION[c2] != -1;
    }

    private static boolean isText(char c2) {
        if (c2 == '\t' || c2 == '\n' || c2 == '\r') {
            return true;
        }
        return c2 >= ' ' && c2 <= '~';
    }
}
