package com.sobot.chat.widget.zxing.datamatrix.decoder;

import com.sobot.chat.widget.zxing.FormatException;
import com.sobot.chat.widget.zxing.common.BitSource;
import com.sobot.chat.widget.zxing.common.DecoderResult;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/datamatrix/decoder/DecodedBitStreamParser.class */
final class DecodedBitStreamParser {
    private static final char[] C40_SHIFT2_SET_CHARS;
    private static final char[] TEXT_SHIFT2_SET_CHARS;
    private static final char[] C40_BASIC_SET_CHARS = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static final char[] TEXT_BASIC_SET_CHARS = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static final char[] TEXT_SHIFT3_SET_CHARS = {'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};

    /* renamed from: com.sobot.chat.widget.zxing.datamatrix.decoder.DecodedBitStreamParser$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/datamatrix/decoder/DecodedBitStreamParser$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$sobot$chat$widget$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0041 -> B:27:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0045 -> B:25:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0049 -> B:23:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004d -> B:29:0x0035). Please submit an issue!!! */
        static {
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$com$sobot$chat$widget$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode = iArr;
            try {
                iArr[Mode.C40_ENCODE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$sobot$chat$widget$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode[Mode.TEXT_ENCODE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$sobot$chat$widget$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode[Mode.ANSIX12_ENCODE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$sobot$chat$widget$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode[Mode.EDIFACT_ENCODE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$sobot$chat$widget$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode[Mode.BASE256_ENCODE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/datamatrix/decoder/DecodedBitStreamParser$Mode.class */
    public enum Mode {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    static {
        char[] cArr = {'!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};
        C40_SHIFT2_SET_CHARS = cArr;
        TEXT_SHIFT2_SET_CHARS = cArr;
    }

    private DecodedBitStreamParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DecoderResult decode(byte[] bArr) throws FormatException {
        BitSource bitSource = new BitSource(bArr);
        StringBuilder sb = new StringBuilder(100);
        StringBuilder sb2 = new StringBuilder(0);
        ArrayList arrayList = new ArrayList(1);
        Mode mode = Mode.ASCII_ENCODE;
        do {
            if (mode == Mode.ASCII_ENCODE) {
                mode = decodeAsciiSegment(bitSource, sb, sb2);
            } else {
                int i = AnonymousClass1.$SwitchMap$com$sobot$chat$widget$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode[mode.ordinal()];
                if (i == 1) {
                    decodeC40Segment(bitSource, sb);
                } else if (i == 2) {
                    decodeTextSegment(bitSource, sb);
                } else if (i == 3) {
                    decodeAnsiX12Segment(bitSource, sb);
                } else if (i == 4) {
                    decodeEdifactSegment(bitSource, sb);
                } else if (i != 5) {
                    throw FormatException.getFormatInstance();
                } else {
                    decodeBase256Segment(bitSource, sb, arrayList);
                }
                mode = Mode.ASCII_ENCODE;
            }
            if (mode == Mode.PAD_ENCODE) {
                break;
            }
        } while (bitSource.available() > 0);
        if (sb2.length() > 0) {
            sb.append((CharSequence) sb2);
        }
        String sb3 = sb.toString();
        ArrayList arrayList2 = arrayList;
        if (arrayList.isEmpty()) {
            arrayList2 = null;
        }
        return new DecoderResult(bArr, sb3, arrayList2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a3, code lost:
        if (r4.available() > 0) goto L2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a6, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void decodeAnsiX12Segment(com.sobot.chat.widget.zxing.common.BitSource r4, java.lang.StringBuilder r5) throws com.sobot.chat.widget.zxing.FormatException {
        /*
            r0 = 3
            int[] r0 = new int[r0]
            r8 = r0
        L5:
            r0 = r4
            int r0 = r0.available()
            r1 = 8
            if (r0 != r1) goto Lf
            return
        Lf:
            r0 = r4
            r1 = 8
            int r0 = r0.readBits(r1)
            r6 = r0
            r0 = r6
            r1 = 254(0xfe, float:3.56E-43)
            if (r0 != r1) goto L1e
            return
        L1e:
            r0 = r6
            r1 = r4
            r2 = 8
            int r1 = r1.readBits(r2)
            r2 = r8
            parseTwoBytes(r0, r1, r2)
            r0 = 0
            r6 = r0
        L2c:
            r0 = r6
            r1 = 3
            if (r0 >= r1) goto L9f
            r0 = r8
            r1 = r6
            r0 = r0[r1]
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L91
            r0 = r7
            r1 = 1
            if (r0 == r1) goto L87
            r0 = r7
            r1 = 2
            if (r0 == r1) goto L7d
            r0 = r7
            r1 = 3
            if (r0 == r1) goto L73
            r0 = r7
            r1 = 14
            if (r0 >= r1) goto L5c
            r0 = r5
            r1 = r7
            r2 = 44
            int r1 = r1 + r2
            char r1 = (char) r1
            java.lang.StringBuilder r0 = r0.append(r1)
            goto L98
        L5c:
            r0 = r7
            r1 = 40
            if (r0 >= r1) goto L6f
            r0 = r5
            r1 = r7
            r2 = 51
            int r1 = r1 + r2
            char r1 = (char) r1
            java.lang.StringBuilder r0 = r0.append(r1)
            goto L98
        L6f:
            com.sobot.chat.widget.zxing.FormatException r0 = com.sobot.chat.widget.zxing.FormatException.getFormatInstance()
            throw r0
        L73:
            r0 = r5
            r1 = 32
            java.lang.StringBuilder r0 = r0.append(r1)
            goto L98
        L7d:
            r0 = r5
            r1 = 62
            java.lang.StringBuilder r0 = r0.append(r1)
            goto L98
        L87:
            r0 = r5
            r1 = 42
            java.lang.StringBuilder r0 = r0.append(r1)
            goto L98
        L91:
            r0 = r5
            r1 = 13
            java.lang.StringBuilder r0 = r0.append(r1)
        L98:
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L2c
        L9f:
            r0 = r4
            int r0 = r0.available()
            if (r0 > 0) goto L5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.widget.zxing.datamatrix.decoder.DecodedBitStreamParser.decodeAnsiX12Segment(com.sobot.chat.widget.zxing.common.BitSource, java.lang.StringBuilder):void");
    }

    private static Mode decodeAsciiSegment(BitSource bitSource, StringBuilder sb, StringBuilder sb2) throws FormatException {
        boolean z;
        boolean z2 = false;
        do {
            int readBits = bitSource.readBits(8);
            if (readBits == 0) {
                throw FormatException.getFormatInstance();
            }
            if (readBits <= 128) {
                int i = readBits;
                if (z2) {
                    i = readBits + 128;
                }
                sb.append((char) (i - 1));
                return Mode.ASCII_ENCODE;
            } else if (readBits == 129) {
                return Mode.PAD_ENCODE;
            } else {
                if (readBits > 229) {
                    z = z2;
                    switch (readBits) {
                        case 230:
                            return Mode.C40_ENCODE;
                        case 231:
                            return Mode.BASE256_ENCODE;
                        case 232:
                            sb.append((char) 29);
                            z = z2;
                            break;
                        case 233:
                        case 234:
                        case 241:
                            break;
                        case 235:
                            z = true;
                            break;
                        case 236:
                            sb.append("[)>\u001e05\u001d");
                            sb2.insert(0, "\u001e\u0004");
                            z = z2;
                            break;
                        case 237:
                            sb.append("[)>\u001e06\u001d");
                            sb2.insert(0, "\u001e\u0004");
                            z = z2;
                            break;
                        case 238:
                            return Mode.ANSIX12_ENCODE;
                        case 239:
                            return Mode.TEXT_ENCODE;
                        case 240:
                            return Mode.EDIFACT_ENCODE;
                        default:
                            if (readBits == 254 && bitSource.available() == 0) {
                                z = z2;
                                break;
                            } else {
                                throw FormatException.getFormatInstance();
                            }
                            break;
                    }
                } else {
                    int i2 = readBits - 130;
                    if (i2 < 10) {
                        sb.append('0');
                    }
                    sb.append(i2);
                    z = z2;
                }
                z2 = z;
            }
        } while (bitSource.available() > 0);
        return Mode.ASCII_ENCODE;
    }

    private static void decodeBase256Segment(BitSource bitSource, StringBuilder sb, Collection<byte[]> collection) throws FormatException {
        int byteOffset = bitSource.getByteOffset() + 1;
        int i = byteOffset + 1;
        int unrandomize255State = unrandomize255State(bitSource.readBits(8), byteOffset);
        if (unrandomize255State == 0) {
            unrandomize255State = bitSource.available() / 8;
        } else if (unrandomize255State >= 250) {
            unrandomize255State = ((unrandomize255State - 249) * 250) + unrandomize255State(bitSource.readBits(8), i);
            i++;
        }
        if (unrandomize255State < 0) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[unrandomize255State];
        int i2 = 0;
        while (i2 < unrandomize255State) {
            if (bitSource.available() < 8) {
                throw FormatException.getFormatInstance();
            }
            bArr[i2] = (byte) unrandomize255State(bitSource.readBits(8), i);
            i2++;
            i++;
        }
        collection.add(bArr);
        try {
            sb.append(new String(bArr, "ISO8859_1"));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Platform does not support required encoding: " + e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x013d, code lost:
        if (r4.available() > 0) goto L2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0140, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void decodeC40Segment(com.sobot.chat.widget.zxing.common.BitSource r4, java.lang.StringBuilder r5) throws com.sobot.chat.widget.zxing.FormatException {
        /*
            Method dump skipped, instructions count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.widget.zxing.datamatrix.decoder.DecodedBitStreamParser.decodeC40Segment(com.sobot.chat.widget.zxing.common.BitSource, java.lang.StringBuilder):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0058, code lost:
        if (r3.available() > 0) goto L1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005b, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void decodeEdifactSegment(com.sobot.chat.widget.zxing.common.BitSource r3, java.lang.StringBuilder r4) {
        /*
        L0:
            r0 = r3
            int r0 = r0.available()
            r1 = 16
            if (r0 > r1) goto La
            return
        La:
            r0 = 0
            r5 = r0
        Lc:
            r0 = r5
            r1 = 4
            if (r0 >= r1) goto L54
            r0 = r3
            r1 = 6
            int r0 = r0.readBits(r1)
            r7 = r0
            r0 = r7
            r1 = 31
            if (r0 != r1) goto L35
            r0 = 8
            r1 = r3
            int r1 = r1.getBitOffset()
            int r0 = r0 - r1
            r5 = r0
            r0 = r5
            r1 = 8
            if (r0 == r1) goto L34
            r0 = r3
            r1 = r5
            int r0 = r0.readBits(r1)
        L34:
            return
        L35:
            r0 = r7
            r6 = r0
            r0 = r7
            r1 = 32
            r0 = r0 & r1
            if (r0 != 0) goto L46
            r0 = r7
            r1 = 64
            r0 = r0 | r1
            r6 = r0
        L46:
            r0 = r4
            r1 = r6
            char r1 = (char) r1
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
            goto Lc
        L54:
            r0 = r3
            int r0 = r0.available()
            if (r0 > 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.widget.zxing.datamatrix.decoder.DecodedBitStreamParser.decodeEdifactSegment(com.sobot.chat.widget.zxing.common.BitSource, java.lang.StringBuilder):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x014e, code lost:
        if (r4.available() > 0) goto L2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0151, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void decodeTextSegment(com.sobot.chat.widget.zxing.common.BitSource r4, java.lang.StringBuilder r5) throws com.sobot.chat.widget.zxing.FormatException {
        /*
            Method dump skipped, instructions count: 338
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.widget.zxing.datamatrix.decoder.DecodedBitStreamParser.decodeTextSegment(com.sobot.chat.widget.zxing.common.BitSource, java.lang.StringBuilder):void");
    }

    private static void parseTwoBytes(int i, int i2, int[] iArr) {
        int i3 = ((i << 8) + i2) - 1;
        int i4 = i3 / 1600;
        iArr[0] = i4;
        int i5 = i3 - (i4 * 1600);
        int i6 = i5 / 40;
        iArr[1] = i6;
        iArr[2] = i5 - (i6 * 40);
    }

    private static int unrandomize255State(int i, int i2) {
        int i3 = i - (((i2 * 149) % 255) + 1);
        return i3 >= 0 ? i3 : i3 + 256;
    }
}
