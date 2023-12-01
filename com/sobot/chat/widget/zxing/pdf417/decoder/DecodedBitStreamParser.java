package com.sobot.chat.widget.zxing.pdf417.decoder;

import com.sobot.chat.widget.zxing.FormatException;
import com.sobot.chat.widget.zxing.pdf417.PDF417ResultMetadata;
import java.math.BigInteger;
import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/pdf417/decoder/DecodedBitStreamParser.class */
final class DecodedBitStreamParser {
    private static final int AL = 28;
    private static final int AS = 27;
    private static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    private static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    private static final int BYTE_COMPACTION_MODE_LATCH = 901;
    private static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final BigInteger[] EXP900;
    private static final int LL = 27;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_ADDRESSEE = 4;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_CHECKSUM = 6;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_FILE_NAME = 0;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_FILE_SIZE = 5;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_SEGMENT_COUNT = 1;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_SENDER = 3;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_TIME_STAMP = 2;
    private static final int MACRO_PDF417_TERMINATOR = 922;
    private static final int MAX_NUMERIC_CODEWORDS = 15;
    private static final int ML = 28;
    private static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    private static final int NUMBER_OF_SEQUENCE_CODEWORDS = 2;
    private static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    private static final int PAL = 29;
    private static final int PL = 25;
    private static final int PS = 29;
    private static final int TEXT_COMPACTION_MODE_LATCH = 900;
    private static final char[] PUNCT_CHARS = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    private static final char[] MIXED_CHARS = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.sobot.chat.widget.zxing.pdf417.decoder.DecodedBitStreamParser$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/pdf417/decoder/DecodedBitStreamParser$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$sobot$chat$widget$zxing$pdf417$decoder$DecodedBitStreamParser$Mode;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x004d -> B:37:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0051 -> B:33:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0055 -> B:31:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0059 -> B:27:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005d -> B:35:0x0040). Please submit an issue!!! */
        static {
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$com$sobot$chat$widget$zxing$pdf417$decoder$DecodedBitStreamParser$Mode = iArr;
            try {
                iArr[Mode.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$sobot$chat$widget$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$sobot$chat$widget$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$sobot$chat$widget$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$sobot$chat$widget$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$sobot$chat$widget$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/pdf417/decoder/DecodedBitStreamParser$Mode.class */
    public enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        EXP900 = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900L);
        EXP900[1] = valueOf;
        int i = 2;
        while (true) {
            int i2 = i;
            BigInteger[] bigIntegerArr2 = EXP900;
            if (i2 >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i2] = bigIntegerArr2[i2 - 1].multiply(valueOf);
            i = i2 + 1;
        }
    }

    private DecodedBitStreamParser() {
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x00d9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x002e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int byteCompaction(int r6, int[] r7, java.nio.charset.Charset r8, int r9, java.lang.StringBuilder r10) {
        /*
            Method dump skipped, instructions count: 598
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.widget.zxing.pdf417.decoder.DecodedBitStreamParser.byteCompaction(int, int[], java.nio.charset.Charset, int, java.lang.StringBuilder):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.sobot.chat.widget.zxing.common.DecoderResult decode(int[] r7, java.lang.String r8) throws com.sobot.chat.widget.zxing.FormatException {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.widget.zxing.pdf417.decoder.DecodedBitStreamParser.decode(int[], java.lang.String):com.sobot.chat.widget.zxing.common.DecoderResult");
    }

    private static String decodeBase900toBase10(int[] iArr, int i) throws FormatException {
        BigInteger bigInteger = BigInteger.ZERO;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                break;
            }
            bigInteger = bigInteger.add(EXP900[(i - i3) - 1].multiply(BigInteger.valueOf(iArr[i3])));
            i2 = i3 + 1;
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw FormatException.getFormatInstance();
    }

    static int decodeMacroBlock(int[] iArr, int i, PDF417ResultMetadata pDF417ResultMetadata) throws FormatException {
        if (i + 2 <= iArr[0]) {
            int[] iArr2 = new int[2];
            int i2 = 0;
            while (i2 < 2) {
                iArr2[i2] = iArr[i];
                i2++;
                i++;
            }
            pDF417ResultMetadata.setSegmentIndex(Integer.parseInt(decodeBase900toBase10(iArr2, 2)));
            StringBuilder sb = new StringBuilder();
            int textCompaction = textCompaction(iArr, i, sb);
            pDF417ResultMetadata.setFileId(sb.toString());
            int i3 = iArr[textCompaction] == BEGIN_MACRO_PDF417_OPTIONAL_FIELD ? textCompaction + 1 : -1;
            while (textCompaction < iArr[0]) {
                int i4 = iArr[textCompaction];
                if (i4 == MACRO_PDF417_TERMINATOR) {
                    textCompaction++;
                    pDF417ResultMetadata.setLastSegment(true);
                } else if (i4 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD) {
                    int i5 = textCompaction + 1;
                    switch (iArr[i5]) {
                        case 0:
                            StringBuilder sb2 = new StringBuilder();
                            textCompaction = textCompaction(iArr, i5 + 1, sb2);
                            pDF417ResultMetadata.setFileName(sb2.toString());
                            continue;
                        case 1:
                            StringBuilder sb3 = new StringBuilder();
                            textCompaction = numericCompaction(iArr, i5 + 1, sb3);
                            pDF417ResultMetadata.setSegmentCount(Integer.parseInt(sb3.toString()));
                            continue;
                        case 2:
                            StringBuilder sb4 = new StringBuilder();
                            textCompaction = numericCompaction(iArr, i5 + 1, sb4);
                            pDF417ResultMetadata.setTimestamp(Long.parseLong(sb4.toString()));
                            continue;
                        case 3:
                            StringBuilder sb5 = new StringBuilder();
                            textCompaction = textCompaction(iArr, i5 + 1, sb5);
                            pDF417ResultMetadata.setSender(sb5.toString());
                            continue;
                        case 4:
                            StringBuilder sb6 = new StringBuilder();
                            textCompaction = textCompaction(iArr, i5 + 1, sb6);
                            pDF417ResultMetadata.setAddressee(sb6.toString());
                            continue;
                        case 5:
                            StringBuilder sb7 = new StringBuilder();
                            textCompaction = numericCompaction(iArr, i5 + 1, sb7);
                            pDF417ResultMetadata.setFileSize(Long.parseLong(sb7.toString()));
                            continue;
                        case 6:
                            StringBuilder sb8 = new StringBuilder();
                            textCompaction = numericCompaction(iArr, i5 + 1, sb8);
                            pDF417ResultMetadata.setChecksum(Integer.parseInt(sb8.toString()));
                            continue;
                        default:
                            throw FormatException.getFormatInstance();
                    }
                } else {
                    throw FormatException.getFormatInstance();
                }
            }
            if (i3 != -1) {
                int i6 = textCompaction - i3;
                int i7 = i6;
                if (pDF417ResultMetadata.isLastSegment()) {
                    i7 = i6 - 1;
                }
                pDF417ResultMetadata.setOptionalData(Arrays.copyOfRange(iArr, i3, i7 + i3));
            }
            return textCompaction;
        }
        throw FormatException.getFormatInstance();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void decodeTextCompaction(int[] iArr, int[] iArr2, int i, StringBuilder sb) {
        Mode mode;
        Mode mode2;
        Mode mode3;
        int i2;
        Mode mode4;
        Mode mode5 = Mode.ALPHA;
        Mode mode6 = Mode.ALPHA;
        int i3 = 0;
        while (i3 < i) {
            int i4 = iArr[i3];
            char c2 = ' ';
            switch (AnonymousClass1.$SwitchMap$com$sobot$chat$widget$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[mode5.ordinal()]) {
                case 1:
                    if (i4 < 26) {
                        i2 = i4 + 65;
                        c2 = (char) i2;
                        Mode mode7 = mode6;
                        mode6 = mode5;
                        mode4 = mode7;
                        break;
                    } else {
                        if (i4 == 900) {
                            mode5 = Mode.ALPHA;
                        } else if (i4 != 913) {
                            mode = mode5;
                            mode2 = mode6;
                            switch (i4) {
                                case 27:
                                    mode5 = Mode.LOWER;
                                    break;
                                case 28:
                                    mode5 = Mode.MIXED;
                                    break;
                                case 29:
                                    mode3 = Mode.PUNCT_SHIFT;
                                    c2 = 0;
                                    mode = mode3;
                                    mode2 = mode5;
                                    break;
                            }
                            mode4 = mode2;
                            mode6 = mode;
                            break;
                        } else {
                            sb.append((char) iArr2[i3]);
                        }
                        c2 = 0;
                        mode = mode5;
                        mode2 = mode6;
                        mode4 = mode2;
                        mode6 = mode;
                    }
                case 2:
                    if (i4 < 26) {
                        i2 = i4 + 97;
                        c2 = (char) i2;
                        Mode mode72 = mode6;
                        mode6 = mode5;
                        mode4 = mode72;
                        break;
                    } else {
                        if (i4 == 900) {
                            mode5 = Mode.ALPHA;
                        } else if (i4 != 913) {
                            mode = mode5;
                            mode2 = mode6;
                            switch (i4) {
                                case 27:
                                    mode3 = Mode.ALPHA_SHIFT;
                                    c2 = 0;
                                    mode = mode3;
                                    mode2 = mode5;
                                    break;
                                case 28:
                                    mode5 = Mode.MIXED;
                                    break;
                                case 29:
                                    mode3 = Mode.PUNCT_SHIFT;
                                    c2 = 0;
                                    mode = mode3;
                                    mode2 = mode5;
                                    break;
                            }
                            mode4 = mode2;
                            mode6 = mode;
                            break;
                        } else {
                            sb.append((char) iArr2[i3]);
                        }
                        c2 = 0;
                        mode = mode5;
                        mode2 = mode6;
                        mode4 = mode2;
                        mode6 = mode;
                    }
                case 3:
                    if (i4 < 25) {
                        c2 = MIXED_CHARS[i4];
                        Mode mode722 = mode6;
                        mode6 = mode5;
                        mode4 = mode722;
                        break;
                    } else {
                        if (i4 != 900) {
                            if (i4 != 913) {
                                mode = mode5;
                                mode2 = mode6;
                                switch (i4) {
                                    case 25:
                                        mode5 = Mode.PUNCT;
                                        break;
                                    case 27:
                                        mode5 = Mode.LOWER;
                                        break;
                                    case 29:
                                        mode3 = Mode.PUNCT_SHIFT;
                                        c2 = 0;
                                        mode = mode3;
                                        mode2 = mode5;
                                        break;
                                }
                                mode4 = mode2;
                                mode6 = mode;
                                break;
                            } else {
                                sb.append((char) iArr2[i3]);
                            }
                            c2 = 0;
                            mode = mode5;
                            mode2 = mode6;
                            mode4 = mode2;
                            mode6 = mode;
                        }
                        mode5 = Mode.ALPHA;
                        c2 = 0;
                        mode = mode5;
                        mode2 = mode6;
                        mode4 = mode2;
                        mode6 = mode;
                    }
                case 4:
                    if (i4 >= 29) {
                        if (i4 == 29 || i4 == 900) {
                            mode5 = Mode.ALPHA;
                        } else if (i4 == 913) {
                            sb.append((char) iArr2[i3]);
                        }
                        Mode mode8 = mode6;
                        c2 = 0;
                        mode6 = mode5;
                        mode4 = mode8;
                        break;
                    } else {
                        c2 = PUNCT_CHARS[i4];
                        Mode mode7222 = mode6;
                        mode6 = mode5;
                        mode4 = mode7222;
                        break;
                    }
                    break;
                case 5:
                    if (i4 < 26) {
                        c2 = (char) (i4 + 65);
                        mode4 = mode6;
                        break;
                    } else if (i4 != 26) {
                        mode5 = i4 != 900 ? mode6 : Mode.ALPHA;
                        c2 = 0;
                        mode = mode5;
                        mode2 = mode6;
                        mode4 = mode2;
                        mode6 = mode;
                        break;
                    } else {
                        mode = mode6;
                        mode2 = mode6;
                        mode4 = mode2;
                        mode6 = mode;
                    }
                case 6:
                    if (i4 >= 29) {
                        if (i4 == 29 || i4 == 900) {
                            mode5 = Mode.ALPHA;
                        } else {
                            if (i4 == 913) {
                                sb.append((char) iArr2[i3]);
                            }
                            mode5 = mode6;
                        }
                        Mode mode82 = mode6;
                        c2 = 0;
                        mode6 = mode5;
                        mode4 = mode82;
                        break;
                    } else {
                        c2 = PUNCT_CHARS[i4];
                        mode4 = mode6;
                        break;
                    }
                default:
                    Mode mode822 = mode6;
                    c2 = 0;
                    mode6 = mode5;
                    mode4 = mode822;
                    break;
            }
            if (c2 != 0) {
                sb.append(c2);
            }
            i3++;
            Mode mode9 = mode4;
            mode5 = mode6;
            mode6 = mode9;
        }
    }

    private static int numericCompaction(int[] iArr, int i, StringBuilder sb) throws FormatException {
        int[] iArr2 = new int[15];
        boolean z = false;
        int i2 = 0;
        int i3 = i;
        while (true) {
            int i4 = i2;
            if (i3 < iArr[0] && !z) {
                int i5 = i3 + 1;
                int i6 = iArr[i3];
                if (i5 == iArr[0]) {
                    z = true;
                }
                if (i6 < 900) {
                    iArr2[i4] = i6;
                    i4++;
                    i3 = i5;
                } else {
                    if (i6 != 900 && i6 != 901 && i6 != 928) {
                        switch (i6) {
                            case MACRO_PDF417_TERMINATOR /* 922 */:
                            case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /* 923 */:
                            case BYTE_COMPACTION_MODE_LATCH_6 /* 924 */:
                                break;
                            default:
                                i3 = i5;
                                break;
                        }
                    }
                    i3 = i5 - 1;
                    z = true;
                }
                if (i4 % 15 != 0 && i6 != 902) {
                    i2 = i4;
                    if (!z) {
                    }
                }
                i2 = i4;
                if (i4 > 0) {
                    sb.append(decodeBase900toBase10(iArr2, i4));
                    i2 = 0;
                }
            }
        }
        return i3;
    }

    private static int textCompaction(int[] iArr, int i, StringBuilder sb) {
        int[] iArr2 = new int[(iArr[0] - i) * 2];
        int[] iArr3 = new int[(iArr[0] - i) * 2];
        boolean z = false;
        int i2 = i;
        int i3 = 0;
        while (i2 < iArr[0] && !z) {
            int i4 = i2 + 1;
            int i5 = iArr[i2];
            if (i5 < 900) {
                iArr2[i3] = i5 / 30;
                iArr2[i3 + 1] = i5 % 30;
                i3 += 2;
                i2 = i4;
            } else if (i5 != 913) {
                if (i5 != 928) {
                    switch (i5) {
                        case 900:
                            iArr2[i3] = 900;
                            i3++;
                            i2 = i4;
                            break;
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i5) {
                                case MACRO_PDF417_TERMINATOR /* 922 */:
                                case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /* 923 */:
                                case BYTE_COMPACTION_MODE_LATCH_6 /* 924 */:
                                    break;
                                default:
                                    i2 = i4;
                                    break;
                            }
                    }
                }
                i2 = i4 - 1;
                z = true;
            } else {
                iArr2[i3] = 913;
                i2 = i4 + 1;
                iArr3[i3] = iArr[i4];
                i3++;
            }
        }
        decodeTextCompaction(iArr2, iArr3, i3, sb);
        return i2;
    }
}
