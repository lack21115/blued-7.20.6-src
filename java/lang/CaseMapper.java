package java.lang;

import java.util.Locale;
import libcore.icu.ICU;
import libcore.icu.Transliterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/lang/CaseMapper.class */
public class CaseMapper {
    private static final char GREEK_CAPITAL_SIGMA = 931;
    private static final char GREEK_SMALL_FINAL_SIGMA = 962;
    private static final char LATIN_CAPITAL_I_WITH_DOT = 304;
    private static final char[] upperValues = "SS��ʼN��J̌��Ϊ́Ϋ́ԵՒ��H̱��T̈��W̊��Y̊��Aʾ��Υ̓��Υ̓̀Υ̓́Υ̓͂ἈΙ��ἉΙ��ἊΙ��ἋΙ��ἌΙ��ἍΙ��ἎΙ��ἏΙ��ἈΙ��ἉΙ��ἊΙ��ἋΙ��ἌΙ��ἍΙ��ἎΙ��ἏΙ��ἨΙ��ἩΙ��ἪΙ��ἫΙ��ἬΙ��ἭΙ��ἮΙ��ἯΙ��ἨΙ��ἩΙ��ἪΙ��ἫΙ��ἬΙ��ἭΙ��ἮΙ��ἯΙ��ὨΙ��ὩΙ��ὪΙ��ὫΙ��ὬΙ��ὭΙ��ὮΙ��ὯΙ��ὨΙ��ὩΙ��ὪΙ��ὫΙ��ὬΙ��ὭΙ��ὮΙ��ὯΙ��ᾺΙ��ΑΙ��ΆΙ��Α͂��Α͂ΙΑΙ��ῊΙ��ΗΙ��ΉΙ��Η͂��Η͂ΙΗΙ��Ϊ̀Ϊ́Ι͂��Ϊ͂Ϋ̀Ϋ́Ρ̓��Υ͂��Ϋ͂ῺΙ��ΩΙ��ΏΙ��Ω͂��Ω͂ΙΩΙ��FF��FI��FL��FFIFFLST��ST��ՄՆ��ՄԵ��ՄԻ��ՎՆ��ՄԽ��".toCharArray();
    private static final char[] upperValues2 = "\u000b��\f��\r��\u000e����������������������������������������������������������������������������������\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>����?@A��BC��������D����������EFG��HI��������J����������KL����MN��������������������OPQ��RS��������������������TUV��WX��������Y".toCharArray();
    private static final ThreadLocal<Transliterator> EL_UPPER = new ThreadLocal<Transliterator>() { // from class: java.lang.CaseMapper.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Transliterator initialValue() {
            return new Transliterator("el-Upper");
        }
    };

    private CaseMapper() {
    }

    private static boolean isFinalSigma(char[] cArr, int i, int i2, int i3) {
        if (i3 <= i) {
            return false;
        }
        char c = cArr[i3 - 1];
        if (Character.isLowerCase(c) || Character.isUpperCase(c) || Character.isTitleCase(c)) {
            if (i3 + 1 >= i + i2) {
                return true;
            }
            char c2 = cArr[i3 + 1];
            return (Character.isLowerCase(c2) || Character.isUpperCase(c2) || Character.isTitleCase(c2)) ? false : true;
        }
        return false;
    }

    public static String toLowerCase(Locale locale, String str, char[] cArr, int i, int i2) {
        String language = locale.getLanguage();
        if (language.equals("tr") || language.equals("az") || language.equals("lt")) {
            str = ICU.toLowerCase(str, locale);
        } else {
            char[] cArr2 = null;
            int i3 = 0;
            int i4 = i;
            while (i4 < i + i2) {
                char c = cArr[i4];
                if (c == 304 || Character.isHighSurrogate(c)) {
                    return ICU.toLowerCase(str, locale);
                }
                char lowerCase = (c == GREEK_CAPITAL_SIGMA && isFinalSigma(cArr, i, i2, i4)) ? GREEK_SMALL_FINAL_SIGMA : Character.toLowerCase(c);
                int i5 = i3;
                char[] cArr3 = cArr2;
                if (cArr2 == null) {
                    i5 = i3;
                    cArr3 = cArr2;
                    if (c != lowerCase) {
                        cArr3 = new char[i2];
                        i5 = i4 - i;
                        System.arraycopy(cArr, i, cArr3, 0, i5);
                    }
                }
                if (cArr3 != null) {
                    i3 = i5 + 1;
                    cArr3[i5] = lowerCase;
                } else {
                    i3 = i5;
                }
                i4++;
                cArr2 = cArr3;
            }
            if (cArr2 != null) {
                return new String(0, i3, cArr2);
            }
        }
        return str;
    }

    public static String toUpperCase(Locale locale, String str, char[] cArr, int i, int i2) {
        char[] cArr2;
        int i3;
        String language = locale.getLanguage();
        if (language.equals("tr") || language.equals("az") || language.equals("lt")) {
            str = ICU.toUpperCase(str, locale);
        } else if (language.equals("el")) {
            return EL_UPPER.get().transliterate(str);
        } else {
            char[] cArr3 = null;
            int i4 = i;
            int i5 = 0;
            while (i4 < i + i2) {
                char c = cArr[i4];
                if (Character.isHighSurrogate(c)) {
                    return ICU.toUpperCase(str, locale);
                }
                int upperIndex = upperIndex(c);
                if (upperIndex == -1) {
                    cArr2 = cArr3;
                    if (cArr3 != null) {
                        cArr2 = cArr3;
                        if (i5 >= cArr3.length) {
                            cArr2 = new char[cArr3.length + (i2 / 6) + 2];
                            System.arraycopy(cArr3, 0, cArr2, 0, cArr3.length);
                        }
                    }
                    char upperCase = Character.toUpperCase(c);
                    if (c != upperCase) {
                        if (cArr2 == null) {
                            cArr2 = new char[i2];
                            i5 = i4 - i;
                            System.arraycopy(cArr, i, cArr2, 0, i5);
                        }
                        cArr2[i5] = upperCase;
                        i5++;
                    } else {
                        i3 = i5;
                        cArr3 = cArr2;
                        if (cArr2 != null) {
                            cArr2[i5] = c;
                            i5++;
                        }
                        i5 = i3;
                        cArr2 = cArr3;
                    }
                } else {
                    int i6 = upperIndex * 3;
                    char c2 = upperValues[i6 + 2];
                    if (cArr3 == null) {
                        cArr3 = new char[(i2 / 6) + i2 + 2];
                        i5 = i4 - i;
                        System.arraycopy(cArr, i, cArr3, 0, i5);
                    } else {
                        if ((c2 == 0 ? 1 : 2) + i5 >= cArr3.length) {
                            char[] cArr4 = new char[cArr3.length + (i2 / 6) + 3];
                            System.arraycopy(cArr3, 0, cArr4, 0, cArr3.length);
                            cArr3 = cArr4;
                        }
                    }
                    char c3 = upperValues[i6];
                    int i7 = i5 + 1;
                    cArr3[i5] = c3;
                    char c4 = upperValues[i6 + 1];
                    int i8 = i7 + 1;
                    cArr3[i7] = c4;
                    i5 = i8;
                    cArr2 = cArr3;
                    if (c2 != 0) {
                        cArr3[i8] = c2;
                        i3 = i8 + 1;
                        i5 = i3;
                        cArr2 = cArr3;
                    }
                }
                i4++;
                cArr3 = cArr2;
            }
            if (cArr3 != null) {
                return (cArr3.length == i5 || cArr3.length - i5 < 8) ? new String(0, i5, cArr3) : new String(cArr3, 0, i5);
            }
        }
        return str;
    }

    private static int upperIndex(int i) {
        char c = 65535;
        if (i >= 223) {
            if (i <= 1415) {
                switch (i) {
                    case 223:
                        return 0;
                    case 329:
                        return 1;
                    case 496:
                        return 2;
                    case 912:
                        return 3;
                    case 944:
                        return 4;
                    case 1415:
                        return 5;
                    default:
                        c = -1;
                        break;
                }
            } else {
                c = 65535;
                if (i >= 7830) {
                    if (i <= 7834) {
                        c = (i + 6) - 7830;
                    } else if (i < 8016 || i > 8188) {
                        c = 65535;
                        if (i >= 64256) {
                            if (i <= 64262) {
                                c = (i + 90) - 64256;
                            } else {
                                c = 65535;
                                if (i >= 64275) {
                                    c = 65535;
                                    if (i <= 64279) {
                                        c = (i + 97) - 64275;
                                    }
                                }
                            }
                        }
                    } else {
                        char c2 = upperValues2[i - 8016];
                        c = c2;
                        if (c2 == 0) {
                            c = -1;
                        }
                    }
                }
            }
        }
        return c;
    }
}
