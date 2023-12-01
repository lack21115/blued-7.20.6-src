package com.sobot.chat.widget.zxing.oned;

import com.sobot.chat.widget.zxing.BarcodeFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/oned/Code128Writer.class */
public final class Code128Writer extends OneDimensionalCodeWriter {
    private static final int CODE_CODE_A = 101;
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_A = 101;
    private static final int CODE_FNC_4_B = 100;
    private static final int CODE_START_A = 103;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final char ESCAPE_FNC_1 = 241;
    private static final char ESCAPE_FNC_2 = 242;
    private static final char ESCAPE_FNC_3 = 243;
    private static final char ESCAPE_FNC_4 = 244;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/oned/Code128Writer$CType.class */
    public enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    private static int chooseCode(CharSequence charSequence, int i, int i2) {
        CType findCType;
        CType findCType2;
        CType findCType3 = findCType(charSequence, i);
        if (findCType3 == CType.ONE_DIGIT) {
            return i2 == 101 ? 101 : 100;
        } else if (findCType3 == CType.UNCODABLE) {
            if (i < charSequence.length()) {
                char charAt = charSequence.charAt(i);
                if (charAt >= ' ') {
                    if (i2 == 101) {
                        if (charAt >= '`') {
                            return (charAt < 241 || charAt > 244) ? 100 : 101;
                        }
                        return 101;
                    }
                    return 100;
                }
                return 101;
            }
            return 100;
        } else if (i2 == 101 && findCType3 == CType.FNC_1) {
            return 101;
        } else {
            if (i2 == 99) {
                return 99;
            }
            if (i2 != 100) {
                CType cType = findCType3;
                if (findCType3 == CType.FNC_1) {
                    cType = findCType(charSequence, i + 1);
                }
                return cType == CType.TWO_DIGITS ? 99 : 100;
            } else if (findCType3 == CType.FNC_1 || (findCType = findCType(charSequence, i + 2)) == CType.UNCODABLE || findCType == CType.ONE_DIGIT) {
                return 100;
            } else {
                if (findCType == CType.FNC_1) {
                    return findCType(charSequence, i + 3) == CType.TWO_DIGITS ? 99 : 100;
                }
                int i3 = i;
                int i4 = 4;
                while (true) {
                    int i5 = i3 + i4;
                    findCType2 = findCType(charSequence, i5);
                    if (findCType2 != CType.TWO_DIGITS) {
                        break;
                    }
                    i3 = i5;
                    i4 = 2;
                }
                return findCType2 == CType.ONE_DIGIT ? 100 : 99;
            }
        }
    }

    private static CType findCType(CharSequence charSequence, int i) {
        int length = charSequence.length();
        if (i >= length) {
            return CType.UNCODABLE;
        }
        char charAt = charSequence.charAt(i);
        if (charAt == 241) {
            return CType.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return CType.UNCODABLE;
        }
        int i2 = i + 1;
        if (i2 >= length) {
            return CType.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i2);
        return (charAt2 < '0' || charAt2 > '9') ? CType.ONE_DIGIT : CType.TWO_DIGITS;
    }

    @Override // com.sobot.chat.widget.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int i;
        int i2;
        int i3;
        int length = str.length();
        if (length < 1 || length > 80) {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 < length) {
                char charAt = str.charAt(i5);
                switch (charAt) {
                    case 241:
                    case 242:
                    case 243:
                    case 244:
                        break;
                    default:
                        if (charAt > 127) {
                            throw new IllegalArgumentException("Bad character in input: " + charAt);
                        }
                        break;
                }
                i4 = i5 + 1;
            } else {
                ArrayList<int[]> arrayList = new ArrayList();
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                int i9 = 1;
                while (i6 < length) {
                    int chooseCode = chooseCode(str, i6, i8);
                    int i10 = 100;
                    if (chooseCode == i8) {
                        switch (str.charAt(i6)) {
                            case 241:
                                i10 = 102;
                                i3 = i6;
                                break;
                            case 242:
                                i10 = 97;
                                i3 = i6;
                                break;
                            case 243:
                                i10 = 96;
                                i3 = i6;
                                break;
                            case 244:
                                i3 = i6;
                                if (i8 == 101) {
                                    i10 = 101;
                                    i3 = i6;
                                    break;
                                }
                                break;
                            default:
                                if (i8 != 100) {
                                    if (i8 != 101) {
                                        i10 = Integer.parseInt(str.substring(i6, i6 + 2));
                                        i3 = i6 + 1;
                                        break;
                                    } else {
                                        int charAt2 = str.charAt(i6) - ' ';
                                        i3 = i6;
                                        i10 = charAt2;
                                        if (charAt2 < 0) {
                                            i10 = charAt2 + 96;
                                            i3 = i6;
                                            break;
                                        }
                                    }
                                } else {
                                    i10 = str.charAt(i6) - ' ';
                                    i3 = i6;
                                    break;
                                }
                                break;
                        }
                        i2 = i3 + 1;
                        i = i8;
                    } else {
                        if (i8 != 0) {
                            i10 = chooseCode;
                        } else if (chooseCode != 100) {
                            i10 = 103;
                            if (chooseCode != 101) {
                                i10 = 105;
                            }
                        } else {
                            i10 = 104;
                        }
                        i = chooseCode;
                        i2 = i6;
                    }
                    arrayList.add(Code128Reader.CODE_PATTERNS[i10]);
                    int i11 = i7 + (i10 * i9);
                    i6 = i2;
                    i7 = i11;
                    i8 = i;
                    if (i2 != 0) {
                        i9++;
                        i6 = i2;
                        i7 = i11;
                        i8 = i;
                    }
                }
                arrayList.add(Code128Reader.CODE_PATTERNS[i7 % 103]);
                arrayList.add(Code128Reader.CODE_PATTERNS[106]);
                int i12 = 0;
                for (int[] iArr : arrayList) {
                    int length2 = iArr.length;
                    int i13 = 0;
                    int i14 = i12;
                    while (true) {
                        i12 = i14;
                        if (i13 < length2) {
                            i14 += iArr[i13];
                            i13++;
                        }
                    }
                }
                boolean[] zArr = new boolean[i12];
                Iterator<E> it = arrayList.iterator();
                int i15 = 0;
                while (true) {
                    int i16 = i15;
                    if (!it.hasNext()) {
                        return zArr;
                    }
                    i15 = i16 + appendPattern(zArr, i16, (int[]) it.next(), true);
                }
            }
        }
    }

    @Override // com.sobot.chat.widget.zxing.oned.OneDimensionalCodeWriter
    protected Collection<BarcodeFormat> getSupportedWriteFormats() {
        return Collections.singleton(BarcodeFormat.CODE_128);
    }
}
