package external.org.apache.commons.lang3;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: source-259656-dex2jar.jar:external/org/apache/commons/lang3/StringUtils.class */
public class StringUtils {
    public static final String EMPTY = "";
    public static final int INDEX_NOT_FOUND = -1;
    private static final int PAD_LIMIT = 8192;
    private static final Pattern WHITESPACE_BLOCK = Pattern.compile("\\s+");

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-259656-dex2jar.jar:external/org/apache/commons/lang3/StringUtils$InitStripAccents.class */
    public static class InitStripAccents {
        private static final Throwable java6Exception;
        private static final Method java6NormalizeMethod;
        private static final Object java6NormalizerFormNFD;
        private static final Method sunDecomposeMethod;
        private static final Throwable sunException;
        private static final Pattern sunPattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        private static final Pattern java6Pattern = sunPattern;

        static {
            try {
                Thread.currentThread();
                throw new VerifyError("bad dex opcode");
            } catch (Exception e) {
                try {
                    Thread.currentThread();
                    throw new VerifyError("bad dex opcode");
                } catch (Exception e2) {
                    java6Exception = e;
                    java6NormalizerFormNFD = null;
                    java6NormalizeMethod = null;
                    sunException = e2;
                    sunDecomposeMethod = null;
                }
            }
        }

        private InitStripAccents() {
        }
    }

    public static String abbreviate(String str, int i) {
        return abbreviate(str, 0, i);
    }

    public static String abbreviate(String str, int i, int i2) {
        String str2;
        if (str == null) {
            str2 = null;
        } else if (i2 < 4) {
            throw new IllegalArgumentException("Minimum abbreviation width is 4");
        } else {
            str2 = str;
            if (str.length() > i2) {
                int i3 = i;
                if (i > str.length()) {
                    i3 = str.length();
                }
                int i4 = i3;
                if (str.length() - i3 < i2 - 3) {
                    i4 = str.length() - (i2 - 3);
                }
                if (i4 <= 4) {
                    return str.substring(0, i2 - 3) + "...";
                }
                if (i2 < 7) {
                    throw new IllegalArgumentException("Minimum abbreviation width with offset is 7");
                }
                return (i4 + i2) - 3 < str.length() ? "..." + abbreviate(str.substring(i4), i2 - 3) : "..." + str.substring(str.length() - (i2 - 3));
            }
        }
        return str2;
    }

    public static String abbreviateMiddle(String str, String str2, int i) {
        if (isEmpty(str) || isEmpty(str2) || i >= str.length() || i < str2.length() + 2) {
            return str;
        }
        int length = i - str2.length();
        int i2 = length / 2;
        int length2 = str.length();
        int i3 = length / 2;
        StringBuilder sb = new StringBuilder(i);
        sb.append(str.substring(0, i2 + (length % 2)));
        sb.append(str2);
        sb.append(str.substring(length2 - i3));
        return sb.toString();
    }

    public static String capitalize(String str) {
        int length;
        return (str == null || (length = str.length()) == 0) ? str : new StringBuilder(length).append(Character.toTitleCase(str.charAt(0))).append(str.substring(1)).toString();
    }

    public static String center(String str, int i) {
        return center(str, i, ' ');
    }

    public static String center(String str, int i, char c2) {
        int length;
        int length2;
        return (str == null || i <= 0 || (length2 = i - (length = str.length())) <= 0) ? str : rightPad(leftPad(str, (length2 / 2) + length, c2), i, c2);
    }

    public static String center(String str, int i, String str2) {
        if (str != null && i > 0) {
            String str3 = str2;
            if (isEmpty(str2)) {
                str3 = " ";
            }
            int length = str.length();
            int i2 = i - length;
            if (i2 > 0) {
                return rightPad(leftPad(str, (i2 / 2) + length, str3), i, str3);
            }
        }
        return str;
    }

    public static String chomp(String str) {
        int i;
        if (!isEmpty(str)) {
            if (str.length() != 1) {
                int length = str.length() - 1;
                char charAt = str.charAt(length);
                if (charAt == '\n') {
                    i = length;
                    if (str.charAt(length - 1) == '\r') {
                        i = length - 1;
                    }
                } else {
                    i = length;
                    if (charAt != '\r') {
                        i = length + 1;
                    }
                }
                return str.substring(0, i);
            }
            char charAt2 = str.charAt(0);
            if (charAt2 == '\r' || charAt2 == '\n') {
                return "";
            }
        }
        return str;
    }

    @Deprecated
    public static String chomp(String str, String str2) {
        return removeEnd(str, str2);
    }

    public static String chop(String str) {
        String str2;
        if (str == null) {
            str2 = null;
        } else {
            int length = str.length();
            if (length < 2) {
                return "";
            }
            int i = length - 1;
            String substring = str.substring(0, i);
            str2 = substring;
            if (str.charAt(i) == '\n') {
                str2 = substring;
                if (substring.charAt(i - 1) == '\r') {
                    return substring.substring(0, i - 1);
                }
            }
        }
        return str2;
    }

    public static boolean contains(CharSequence charSequence, int i) {
        return !isEmpty(charSequence) && CharSequenceUtils.indexOf(charSequence, i, 0) >= 0;
    }

    public static boolean contains(CharSequence charSequence, CharSequence charSequence2) {
        return (charSequence == null || charSequence2 == null || CharSequenceUtils.indexOf(charSequence, charSequence2, 0) < 0) ? false : true;
    }

    public static boolean containsAny(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2 == null) {
            return false;
        }
        return containsAny(charSequence, CharSequenceUtils.toCharArray(charSequence2));
    }

    public static boolean containsAny(CharSequence charSequence, char... cArr) {
        boolean z;
        if (isEmpty(charSequence) || ArrayUtils.isEmpty(cArr)) {
            z = false;
        } else {
            int length = charSequence.length();
            int length2 = cArr.length;
            int i = 0;
            loop0: while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return false;
                }
                char charAt = charSequence.charAt(i2);
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < length2) {
                        if (cArr[i4] == charAt) {
                            z = true;
                            if (!Character.isHighSurrogate(charAt)) {
                                break loop0;
                            }
                            z = true;
                            if (i4 == length2 - 1) {
                                break loop0;
                            } else if (i2 < length - 1) {
                                z = true;
                                if (cArr[i4 + 1] == charSequence.charAt(i2 + 1)) {
                                    break loop0;
                                }
                            } else {
                                continue;
                            }
                        }
                        i3 = i4 + 1;
                    }
                }
                i = i2 + 1;
            }
        }
        return z;
    }

    public static boolean containsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return false;
        }
        int length = charSequence2.length();
        int length2 = charSequence.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 > length2 - length) {
                return false;
            }
            if (CharSequenceUtils.regionMatches(charSequence, true, i2, charSequence2, 0, length)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static boolean containsNone(CharSequence charSequence, String str) {
        if (charSequence == null || str == null) {
            return true;
        }
        return containsNone(charSequence, str.toCharArray());
    }

    public static boolean containsNone(CharSequence charSequence, char... cArr) {
        boolean z;
        if (charSequence == null || cArr == null) {
            z = true;
        } else {
            int length = charSequence.length();
            int length2 = cArr.length;
            int i = 0;
            loop0: while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return true;
                }
                char charAt = charSequence.charAt(i2);
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < length2) {
                        if (cArr[i4] == charAt) {
                            z = false;
                            if (!Character.isHighSurrogate(charAt)) {
                                break loop0;
                            }
                            z = false;
                            if (i4 == length2 - 1) {
                                break loop0;
                            } else if (i2 < length - 1) {
                                z = false;
                                if (cArr[i4 + 1] == charSequence.charAt(i2 + 1)) {
                                    break loop0;
                                }
                            } else {
                                continue;
                            }
                        }
                        i3 = i4 + 1;
                    }
                }
                i = i2 + 1;
            }
        }
        return z;
    }

    public static boolean containsOnly(CharSequence charSequence, String str) {
        if (charSequence == null || str == null) {
            return false;
        }
        return containsOnly(charSequence, str.toCharArray());
    }

    public static boolean containsOnly(CharSequence charSequence, char... cArr) {
        boolean z;
        if (cArr == null || charSequence == null) {
            z = false;
        } else {
            z = true;
            if (charSequence.length() != 0) {
                if (cArr.length == 0) {
                    return false;
                }
                z = true;
                if (indexOfAnyBut(charSequence, cArr) != -1) {
                    return false;
                }
            }
        }
        return z;
    }

    public static boolean containsWhitespace(CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (Character.isWhitespace(charSequence.charAt(i2))) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static int countMatches(CharSequence charSequence, CharSequence charSequence2) {
        int i;
        if (!isEmpty(charSequence) && !isEmpty(charSequence2)) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int indexOf = CharSequenceUtils.indexOf(charSequence, charSequence2, i3);
                i = i2;
                if (indexOf == -1) {
                    break;
                }
                i2++;
                i3 = indexOf + charSequence2.length();
            }
        } else {
            i = 0;
        }
        return i;
    }

    public static <T extends CharSequence> T defaultIfBlank(T t, T t2) {
        return isBlank(t) ? t2 : t;
    }

    public static <T extends CharSequence> T defaultIfEmpty(T t, T t2) {
        return isEmpty(t) ? t2 : t;
    }

    public static String defaultString(String str) {
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    public static String defaultString(String str, String str2) {
        return str == null ? str2 : str;
    }

    public static String deleteWhitespace(String str) {
        if (!isEmpty(str)) {
            int length = str.length();
            char[] cArr = new char[length];
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                if (!Character.isWhitespace(str.charAt(i2))) {
                    cArr[i] = str.charAt(i2);
                    i++;
                }
            }
            if (i != length) {
                return new String(cArr, 0, i);
            }
        }
        return str;
    }

    public static String difference(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        int indexOfDifference = indexOfDifference(str, str2);
        return indexOfDifference == -1 ? "" : str2.substring(indexOfDifference);
    }

    public static boolean endsWith(CharSequence charSequence, CharSequence charSequence2) {
        return endsWith(charSequence, charSequence2, false);
    }

    private static boolean endsWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        boolean z2;
        if (charSequence == null || charSequence2 == null) {
            z2 = false;
            if (charSequence == null) {
                z2 = false;
                if (charSequence2 == null) {
                    z2 = true;
                }
            }
        } else {
            z2 = false;
            if (charSequence2.length() <= charSequence.length()) {
                return CharSequenceUtils.regionMatches(charSequence, z, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length());
            }
        }
        return z2;
    }

    public static boolean endsWithAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (isEmpty(charSequence) || ArrayUtils.isEmpty(charSequenceArr)) {
            return false;
        }
        int length = charSequenceArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (endsWith(charSequence, charSequenceArr[i2])) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static boolean endsWithIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return endsWith(charSequence, charSequence2, true);
    }

    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence == null ? charSequence2 == null : charSequence.equals(charSequence2);
    }

    public static boolean equalsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return (charSequence == null || charSequence2 == null) ? charSequence == charSequence2 : CharSequenceUtils.regionMatches(charSequence, true, 0, charSequence2, 0, Math.max(charSequence.length(), charSequence2.length()));
    }

    public static String getCommonPrefix(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        int indexOfDifference = indexOfDifference(strArr);
        return indexOfDifference == -1 ? strArr[0] == null ? "" : strArr[0] : indexOfDifference == 0 ? "" : strArr[0].substring(0, indexOfDifference);
    }

    public static int getLevenshteinDistance(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }
        int length = charSequence.length();
        int length2 = charSequence2.length();
        if (length == 0) {
            return length2;
        }
        if (length2 == 0) {
            return length;
        }
        int i = length2;
        int i2 = length;
        CharSequence charSequence3 = charSequence;
        CharSequence charSequence4 = charSequence2;
        if (length > length2) {
            i2 = length2;
            i = charSequence.length();
            charSequence4 = charSequence;
            charSequence3 = charSequence2;
        }
        int[] iArr = new int[i2 + 1];
        int[] iArr2 = new int[i2 + 1];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 > i2) {
                break;
            }
            iArr[i4] = i4;
            i3 = i4 + 1;
        }
        int i5 = 1;
        while (true) {
            int i6 = i5;
            int[] iArr3 = iArr;
            if (i6 > i) {
                return iArr3[i2];
            }
            char charAt = charSequence4.charAt(i6 - 1);
            iArr2[0] = i6;
            int i7 = 1;
            while (true) {
                int i8 = i7;
                if (i8 <= i2) {
                    iArr2[i8] = Math.min(Math.min(iArr2[i8 - 1] + 1, iArr3[i8] + 1), iArr3[i8 - 1] + (charSequence3.charAt(i8 - 1) == charAt ? 0 : 1));
                    i7 = i8 + 1;
                }
            }
            iArr = iArr2;
            iArr2 = iArr3;
            i5 = i6 + 1;
        }
    }

    public static int getLevenshteinDistance(CharSequence charSequence, CharSequence charSequence2, int i) {
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("Threshold must not be negative");
        }
        int length = charSequence.length();
        int length2 = charSequence2.length();
        if (length == 0) {
            if (length2 <= i) {
                return length2;
            }
            return -1;
        } else if (length2 == 0) {
            if (length <= i) {
                return length;
            }
            return -1;
        } else {
            int i2 = length2;
            int i3 = length;
            CharSequence charSequence3 = charSequence;
            CharSequence charSequence4 = charSequence2;
            if (length > length2) {
                i3 = length2;
                i2 = charSequence.length();
                charSequence4 = charSequence;
                charSequence3 = charSequence2;
            }
            int[] iArr = new int[i3 + 1];
            int[] iArr2 = new int[i3 + 1];
            int min = Math.min(i3, i) + 1;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= min) {
                    break;
                }
                iArr[i5] = i5;
                i4 = i5 + 1;
            }
            Arrays.fill(iArr, min, iArr.length, Integer.MAX_VALUE);
            Arrays.fill(iArr2, Integer.MAX_VALUE);
            int i6 = 1;
            while (true) {
                int i7 = i6;
                int[] iArr3 = iArr;
                if (i7 > i2) {
                    if (iArr3[i3] <= i) {
                        return iArr3[i3];
                    }
                    return -1;
                }
                char charAt = charSequence4.charAt(i7 - 1);
                iArr2[0] = i7;
                int max = Math.max(1, i7 - i);
                int min2 = Math.min(i3, i7 + i);
                if (max > min2) {
                    return -1;
                }
                if (max > 1) {
                    iArr2[max - 1] = Integer.MAX_VALUE;
                }
                while (max <= min2) {
                    if (charSequence3.charAt(max - 1) == charAt) {
                        iArr2[max] = iArr3[max - 1];
                    } else {
                        iArr2[max] = Math.min(Math.min(iArr2[max - 1], iArr3[max]), iArr3[max - 1]) + 1;
                    }
                    max++;
                }
                iArr = iArr2;
                iArr2 = iArr3;
                i6 = i7 + 1;
            }
        }
    }

    public static int indexOf(CharSequence charSequence, int i) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.indexOf(charSequence, i, 0);
    }

    public static int indexOf(CharSequence charSequence, int i, int i2) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.indexOf(charSequence, i, i2);
    }

    public static int indexOf(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return CharSequenceUtils.indexOf(charSequence, charSequence2, 0);
    }

    public static int indexOf(CharSequence charSequence, CharSequence charSequence2, int i) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return CharSequenceUtils.indexOf(charSequence, charSequence2, i);
    }

    public static int indexOfAny(CharSequence charSequence, String str) {
        if (isEmpty(charSequence) || isEmpty(str)) {
            return -1;
        }
        return indexOfAny(charSequence, str.toCharArray());
    }

    public static int indexOfAny(CharSequence charSequence, char... cArr) {
        int i;
        if (isEmpty(charSequence) || ArrayUtils.isEmpty(cArr)) {
            i = -1;
        } else {
            int length = charSequence.length();
            int length2 = cArr.length;
            int i2 = 0;
            loop0: while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return -1;
                }
                char charAt = charSequence.charAt(i3);
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 < length2) {
                        if (cArr[i5] == charAt) {
                            i = i3;
                            if (i3 >= length - 1) {
                                break loop0;
                            }
                            i = i3;
                            if (i5 >= length2 - 1) {
                                break loop0;
                            }
                            i = i3;
                            if (!Character.isHighSurrogate(charAt)) {
                                break loop0;
                            }
                            i = i3;
                            if (cArr[i5 + 1] == charSequence.charAt(i3 + 1)) {
                                break loop0;
                            }
                        }
                        i4 = i5 + 1;
                    }
                }
                i2 = i3 + 1;
            }
        }
        return i;
    }

    public static int indexOfAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        int i;
        int i2;
        if (charSequence == null || charSequenceArr == null) {
            i = -1;
        } else {
            int length = charSequenceArr.length;
            int i3 = Integer.MAX_VALUE;
            int i4 = 0;
            while (i4 < length) {
                CharSequence charSequence2 = charSequenceArr[i4];
                if (charSequence2 == null) {
                    i2 = i3;
                } else {
                    int indexOf = CharSequenceUtils.indexOf(charSequence, charSequence2, 0);
                    i2 = i3;
                    if (indexOf != -1) {
                        i2 = i3;
                        if (indexOf < i3) {
                            i2 = indexOf;
                        }
                    }
                }
                i4++;
                i3 = i2;
            }
            i = i3;
            if (i3 == Integer.MAX_VALUE) {
                return -1;
            }
        }
        return i;
    }

    public static int indexOfAnyBut(CharSequence charSequence, CharSequence charSequence2) {
        int i;
        if (isEmpty(charSequence) || isEmpty(charSequence2)) {
            i = -1;
        } else {
            int length = charSequence.length();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return -1;
                }
                char charAt = charSequence.charAt(i3);
                boolean z = CharSequenceUtils.indexOf(charSequence2, charAt, 0) >= 0;
                if (i3 + 1 < length && Character.isHighSurrogate(charAt)) {
                    char charAt2 = charSequence.charAt(i3 + 1);
                    if (z) {
                        i = i3;
                        if (CharSequenceUtils.indexOf(charSequence2, charAt2, 0) < 0) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else if (!z) {
                    return i3;
                }
                i2 = i3 + 1;
            }
        }
        return i;
    }

    public static int indexOfAnyBut(CharSequence charSequence, char... cArr) {
        int i;
        int i2;
        if (isEmpty(charSequence) || ArrayUtils.isEmpty(cArr)) {
            i = -1;
        } else {
            int length = charSequence.length();
            int length2 = cArr.length;
            int i3 = 0;
            loop0: while (true) {
                int i4 = i3;
                if (i4 >= length) {
                    return -1;
                }
                char charAt = charSequence.charAt(i4);
                while (true) {
                    int i5 = i2;
                    i = i4;
                    if (i5 >= length2) {
                        break loop0;
                    }
                    i2 = (cArr[i5] != charAt || (i4 < length - 1 && i5 < length2 - 1 && Character.isHighSurrogate(charAt) && cArr[i5 + 1] != charSequence.charAt(i4 + 1))) ? i5 + 1 : 0;
                }
                i3 = i4 + 1;
            }
        }
        return i;
    }

    public static int indexOfDifference(CharSequence charSequence, CharSequence charSequence2) {
        int i;
        int i2;
        if (charSequence == charSequence2) {
            i2 = -1;
        } else if (charSequence == null || charSequence2 == null) {
            return 0;
        } else {
            int i3 = 0;
            while (true) {
                i = i3;
                if (i >= charSequence.length() || i >= charSequence2.length() || charSequence.charAt(i) != charSequence2.charAt(i)) {
                    break;
                }
                i3 = i + 1;
            }
            i2 = i;
            if (i >= charSequence2.length()) {
                i2 = i;
                if (i >= charSequence.length()) {
                    return -1;
                }
            }
        }
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b5, code lost:
        if (r4 == r8) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int indexOfDifference(java.lang.CharSequence... r3) {
        /*
            Method dump skipped, instructions count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.org.apache.commons.lang3.StringUtils.indexOfDifference(java.lang.CharSequence[]):int");
    }

    public static int indexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return indexOfIgnoreCase(charSequence, charSequence2, 0);
    }

    public static int indexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2, int i) {
        int i2;
        if (charSequence == null || charSequence2 == null) {
            i2 = -1;
        } else {
            int i3 = i;
            if (i < 0) {
                i3 = 0;
            }
            int length = (charSequence.length() - charSequence2.length()) + 1;
            if (i3 > length) {
                return -1;
            }
            if (charSequence2.length() == 0) {
                return i3;
            }
            int i4 = i3;
            while (true) {
                int i5 = i4;
                if (i5 >= length) {
                    return -1;
                }
                i2 = i5;
                if (CharSequenceUtils.regionMatches(charSequence, true, i5, charSequence2, 0, charSequence2.length())) {
                    break;
                }
                i4 = i5 + 1;
            }
        }
        return i2;
    }

    public static boolean isAllLowerCase(CharSequence charSequence) {
        if (charSequence == null || isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (!Character.isLowerCase(charSequence.charAt(i2))) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static boolean isAllUpperCase(CharSequence charSequence) {
        if (charSequence == null || isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (!Character.isUpperCase(charSequence.charAt(i2))) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static boolean isAlpha(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return false;
        }
        int length = charSequence.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (!Character.isLetter(charSequence.charAt(i2))) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static boolean isAlphaSpace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (!Character.isLetter(charSequence.charAt(i2)) && charSequence.charAt(i2) != ' ') {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static boolean isAlphanumeric(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return false;
        }
        int length = charSequence.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (!Character.isLetterOrDigit(charSequence.charAt(i2))) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static boolean isAlphanumericSpace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (!Character.isLetterOrDigit(charSequence.charAt(i2)) && charSequence.charAt(i2) != ' ') {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static boolean isAsciiPrintable(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (!CharUtils.isAsciiPrintable(charSequence.charAt(i2))) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static boolean isBlank(CharSequence charSequence) {
        int length;
        if (charSequence == null || (length = charSequence.length()) == 0) {
            return true;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (!Character.isWhitespace(charSequence.charAt(i2))) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean isNotBlank(CharSequence charSequence) {
        return !isBlank(charSequence);
    }

    public static boolean isNotEmpty(CharSequence charSequence) {
        return !isEmpty(charSequence);
    }

    public static boolean isNumeric(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return false;
        }
        int length = charSequence.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (!Character.isDigit(charSequence.charAt(i2))) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static boolean isNumericSpace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (!Character.isDigit(charSequence.charAt(i2)) && charSequence.charAt(i2) != ' ') {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static boolean isWhitespace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (!Character.isWhitespace(charSequence.charAt(i2))) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static String join(Iterable<?> iterable, char c2) {
        if (iterable == null) {
            return null;
        }
        return join(iterable.iterator(), c2);
    }

    public static String join(Iterable<?> iterable, String str) {
        if (iterable == null) {
            return null;
        }
        return join(iterable.iterator(), str);
    }

    public static String join(Iterator<?> it, char c2) {
        if (it == null) {
            return null;
        }
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                StringBuilder sb = new StringBuilder(256);
                if (next != null) {
                    sb.append(next);
                }
                while (it.hasNext()) {
                    sb.append(c2);
                    Object next2 = it.next();
                    if (next2 != null) {
                        sb.append(next2);
                    }
                }
                return sb.toString();
            }
            return ObjectUtils.toString(next);
        }
        return "";
    }

    public static String join(Iterator<?> it, String str) {
        if (it == null) {
            return null;
        }
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                StringBuilder sb = new StringBuilder(256);
                if (next != null) {
                    sb.append(next);
                }
                while (it.hasNext()) {
                    if (str != null) {
                        sb.append(str);
                    }
                    Object next2 = it.next();
                    if (next2 != null) {
                        sb.append(next2);
                    }
                }
                return sb.toString();
            }
            return ObjectUtils.toString(next);
        }
        return "";
    }

    public static <T> String join(T... tArr) {
        return join(tArr, (String) null);
    }

    public static String join(Object[] objArr, char c2) {
        if (objArr == null) {
            return null;
        }
        return join(objArr, c2, 0, objArr.length);
    }

    public static String join(Object[] objArr, char c2, int i, int i2) {
        if (objArr == null) {
            return null;
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i3 * 16);
        int i4 = i;
        while (true) {
            int i5 = i4;
            if (i5 >= i2) {
                return sb.toString();
            }
            if (i5 > i) {
                sb.append(c2);
            }
            if (objArr[i5] != null) {
                sb.append(objArr[i5]);
            }
            i4 = i5 + 1;
        }
    }

    public static String join(Object[] objArr, String str) {
        if (objArr == null) {
            return null;
        }
        return join(objArr, str, 0, objArr.length);
    }

    public static String join(Object[] objArr, String str, int i, int i2) {
        if (objArr == null) {
            return null;
        }
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i3 * 16);
        int i4 = i;
        while (true) {
            int i5 = i4;
            if (i5 >= i2) {
                return sb.toString();
            }
            if (i5 > i) {
                sb.append(str2);
            }
            if (objArr[i5] != null) {
                sb.append(objArr[i5]);
            }
            i4 = i5 + 1;
        }
    }

    public static int lastIndexOf(CharSequence charSequence, int i) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.lastIndexOf(charSequence, i, charSequence.length());
    }

    public static int lastIndexOf(CharSequence charSequence, int i, int i2) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.lastIndexOf(charSequence, i, i2);
    }

    public static int lastIndexOf(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return CharSequenceUtils.lastIndexOf(charSequence, charSequence2, charSequence.length());
    }

    public static int lastIndexOf(CharSequence charSequence, CharSequence charSequence2, int i) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return CharSequenceUtils.lastIndexOf(charSequence, charSequence2, i);
    }

    public static int lastIndexOfAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        int i;
        int i2;
        if (charSequence != null && charSequenceArr != null) {
            int length = charSequenceArr.length;
            int i3 = -1;
            int i4 = 0;
            while (true) {
                i = i3;
                if (i4 >= length) {
                    break;
                }
                CharSequence charSequence2 = charSequenceArr[i4];
                if (charSequence2 == null) {
                    i2 = i3;
                } else {
                    int lastIndexOf = CharSequenceUtils.lastIndexOf(charSequence, charSequence2, charSequence.length());
                    i2 = i3;
                    if (lastIndexOf > i3) {
                        i2 = lastIndexOf;
                    }
                }
                i4++;
                i3 = i2;
            }
        } else {
            i = -1;
        }
        return i;
    }

    public static int lastIndexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return lastIndexOfIgnoreCase(charSequence, charSequence2, charSequence.length());
    }

    public static int lastIndexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2, int i) {
        int i2;
        if (charSequence == null || charSequence2 == null) {
            i2 = -1;
        } else {
            int i3 = i;
            if (i > charSequence.length() - charSequence2.length()) {
                i3 = charSequence.length() - charSequence2.length();
            }
            if (i3 < 0) {
                return -1;
            }
            if (charSequence2.length() == 0) {
                return i3;
            }
            int i4 = i3;
            while (true) {
                int i5 = i4;
                if (i5 < 0) {
                    return -1;
                }
                i2 = i5;
                if (CharSequenceUtils.regionMatches(charSequence, true, i5, charSequence2, 0, charSequence2.length())) {
                    break;
                }
                i4 = i5 - 1;
            }
        }
        return i2;
    }

    public static int lastOrdinalIndexOf(CharSequence charSequence, CharSequence charSequence2, int i) {
        return ordinalIndexOf(charSequence, charSequence2, i, true);
    }

    public static String left(String str, int i) {
        String str2;
        if (str == null) {
            str2 = null;
        } else if (i < 0) {
            return "";
        } else {
            str2 = str;
            if (str.length() > i) {
                return str.substring(0, i);
            }
        }
        return str2;
    }

    public static String leftPad(String str, int i) {
        return leftPad(str, i, ' ');
    }

    public static String leftPad(String str, int i, char c2) {
        String str2;
        if (str == null) {
            str2 = null;
        } else {
            int length = i - str.length();
            str2 = str;
            if (length > 0) {
                return length > 8192 ? leftPad(str, i, String.valueOf(c2)) : repeat(c2, length).concat(str);
            }
        }
        return str2;
    }

    public static String leftPad(String str, int i, String str2) {
        String str3;
        if (str == null) {
            str3 = null;
        } else {
            String str4 = str2;
            if (isEmpty(str2)) {
                str4 = " ";
            }
            int length = str4.length();
            int length2 = i - str.length();
            str3 = str;
            if (length2 > 0) {
                if (length == 1 && length2 <= 8192) {
                    return leftPad(str, i, str4.charAt(0));
                }
                if (length2 == length) {
                    return str4.concat(str);
                }
                if (length2 < length) {
                    return str4.substring(0, length2).concat(str);
                }
                char[] cArr = new char[length2];
                char[] charArray = str4.toCharArray();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= length2) {
                        return new String(cArr).concat(str);
                    }
                    cArr[i3] = charArray[i3 % length];
                    i2 = i3 + 1;
                }
            }
        }
        return str3;
    }

    public static int length(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        return charSequence.length();
    }

    public static String lowerCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase();
    }

    public static String lowerCase(String str, Locale locale) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase(locale);
    }

    public static String mid(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        if (i2 < 0 || i > str.length()) {
            return "";
        }
        int i3 = i;
        if (i < 0) {
            i3 = 0;
        }
        return str.length() <= i3 + i2 ? str.substring(i3) : str.substring(i3, i3 + i2);
    }

    public static String normalizeSpace(String str) {
        if (str == null) {
            return null;
        }
        return WHITESPACE_BLOCK.matcher(trim(str)).replaceAll(" ");
    }

    public static int ordinalIndexOf(CharSequence charSequence, CharSequence charSequence2, int i) {
        return ordinalIndexOf(charSequence, charSequence2, i, false);
    }

    private static int ordinalIndexOf(CharSequence charSequence, CharSequence charSequence2, int i, boolean z) {
        int lastIndexOf;
        int i2;
        int i3 = -1;
        int i4 = -1;
        if (charSequence != null) {
            i4 = -1;
            if (charSequence2 != null) {
                if (i > 0) {
                    if (charSequence2.length() == 0) {
                        return z ? charSequence.length() : 0;
                    }
                    int i5 = 0;
                    if (z) {
                        i3 = charSequence.length();
                        i5 = 0;
                    }
                    do {
                        lastIndexOf = z ? CharSequenceUtils.lastIndexOf(charSequence, charSequence2, i3 - 1) : CharSequenceUtils.indexOf(charSequence, charSequence2, i3 + 1);
                        i4 = lastIndexOf;
                        if (lastIndexOf >= 0) {
                            i2 = i5 + 1;
                            i5 = i2;
                            i3 = lastIndexOf;
                        }
                    } while (i2 < i);
                    return lastIndexOf;
                }
                i4 = -1;
            }
        }
        return i4;
    }

    public static String overlay(String str, String str2, int i, int i2) {
        if (str == null) {
            return null;
        }
        String str3 = str2;
        if (str2 == null) {
            str3 = "";
        }
        int length = str.length();
        int i3 = i;
        if (i < 0) {
            i3 = 0;
        }
        int i4 = i3;
        if (i3 > length) {
            i4 = length;
        }
        int i5 = i2;
        if (i2 < 0) {
            i5 = 0;
        }
        int i6 = i5;
        if (i5 > length) {
            i6 = length;
        }
        int i7 = i4;
        int i8 = i6;
        if (i4 > i6) {
            i8 = i4;
            i7 = i6;
        }
        return new StringBuilder(((length + i7) - i8) + str3.length() + 1).append(str.substring(0, i7)).append(str3).append(str.substring(i8)).toString();
    }

    public static String remove(String str, char c2) {
        if (isEmpty(str) || str.indexOf(c2) == -1) {
            return str;
        }
        char[] charArray = str.toCharArray();
        int i = 0;
        int i2 = 0;
        while (i2 < charArray.length) {
            int i3 = i;
            if (charArray[i2] != c2) {
                charArray[i] = charArray[i2];
                i3 = i + 1;
            }
            i2++;
            i = i3;
        }
        return new String(charArray, 0, i);
    }

    public static String remove(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2)) ? str : replace(str, str2, "", -1);
    }

    private static String removeAccentsJava6(CharSequence charSequence) throws IllegalAccessException, InvocationTargetException {
        if (InitStripAccents.java6NormalizeMethod == null || InitStripAccents.java6NormalizerFormNFD == null) {
            throw new IllegalStateException("java.text.Normalizer is not available", InitStripAccents.java6Exception);
        }
        return InitStripAccents.java6Pattern.matcher((String) InitStripAccents.java6NormalizeMethod.invoke(null, charSequence, InitStripAccents.java6NormalizerFormNFD)).replaceAll("");
    }

    private static String removeAccentsSUN(CharSequence charSequence) throws IllegalAccessException, InvocationTargetException {
        if (InitStripAccents.sunDecomposeMethod == null) {
            throw new IllegalStateException("sun.text.Normalizer is not available", InitStripAccents.sunException);
        }
        return InitStripAccents.sunPattern.matcher((String) InitStripAccents.sunDecomposeMethod.invoke(null, charSequence, Boolean.FALSE, 0)).replaceAll("");
    }

    public static String removeEnd(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2) || !str.endsWith(str2)) ? str : str.substring(0, str.length() - str2.length());
    }

    public static String removeEndIgnoreCase(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2) || !endsWithIgnoreCase(str, str2)) ? str : str.substring(0, str.length() - str2.length());
    }

    public static String removeStart(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2) || !str.startsWith(str2)) ? str : str.substring(str2.length());
    }

    public static String removeStartIgnoreCase(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2) || !startsWithIgnoreCase(str, str2)) ? str : str.substring(str2.length());
    }

    public static String repeat(char c2, int i) {
        char[] cArr = new char[i];
        while (true) {
            i--;
            if (i < 0) {
                return new String(cArr);
            }
            cArr[i] = c2;
        }
    }

    public static String repeat(String str, int i) {
        String str2;
        if (str == null) {
            str2 = null;
        } else if (i <= 0) {
            return "";
        } else {
            int length = str.length();
            str2 = str;
            if (i != 1) {
                str2 = str;
                if (length != 0) {
                    if (length == 1 && i <= 8192) {
                        return repeat(str.charAt(0), i);
                    }
                    int i2 = length * i;
                    switch (length) {
                        case 1:
                            return repeat(str.charAt(0), i);
                        case 2:
                            char charAt = str.charAt(0);
                            char charAt2 = str.charAt(1);
                            char[] cArr = new char[i2];
                            int i3 = i * 2;
                            int i4 = 2;
                            while (true) {
                                int i5 = i3 - i4;
                                if (i5 < 0) {
                                    return new String(cArr);
                                }
                                cArr[i5] = charAt;
                                cArr[i5 + 1] = charAt2;
                                i3 = i5 - 1;
                                i4 = 1;
                            }
                        default:
                            StringBuilder sb = new StringBuilder(i2);
                            int i6 = 0;
                            while (true) {
                                int i7 = i6;
                                if (i7 >= i) {
                                    return sb.toString();
                                }
                                sb.append(str);
                                i6 = i7 + 1;
                            }
                    }
                }
            }
        }
        return str2;
    }

    public static String repeat(String str, String str2, int i) {
        return (str == null || str2 == null) ? repeat(str, i) : removeEnd(repeat(str + str2, i), str2);
    }

    public static String replace(String str, String str2, String str3) {
        return replace(str, str2, str3, -1);
    }

    public static String replace(String str, String str2, String str3, int i) {
        int i2;
        int i3 = 64;
        if (!isEmpty(str) && !isEmpty(str2) && str3 != null && i != 0) {
            int indexOf = str.indexOf(str2, 0);
            if (indexOf != -1) {
                int length = str2.length();
                int length2 = str3.length() - length;
                int i4 = length2;
                if (length2 < 0) {
                    i4 = 0;
                }
                if (i < 0) {
                    i3 = 16;
                } else if (i <= 64) {
                    i3 = i;
                }
                StringBuilder sb = new StringBuilder(str.length() + (i4 * i3));
                int i5 = i;
                int i6 = 0;
                int i7 = indexOf;
                while (true) {
                    int i8 = i7;
                    i2 = i6;
                    if (i8 == -1) {
                        break;
                    }
                    sb.append(str.substring(i6, i8)).append(str3);
                    i6 = i8 + length;
                    i5--;
                    if (i5 == 0) {
                        i2 = i6;
                        break;
                    }
                    i7 = str.indexOf(str2, i6);
                }
                sb.append(str.substring(i2));
                return sb.toString();
            }
        }
        return str;
    }

    public static String replaceChars(String str, char c2, char c3) {
        if (str == null) {
            return null;
        }
        return str.replace(c2, c3);
    }

    public static String replaceChars(String str, String str2, String str3) {
        if (!isEmpty(str) && !isEmpty(str2)) {
            String str4 = str3;
            if (str3 == null) {
                str4 = "";
            }
            boolean z = false;
            int length = str4.length();
            int length2 = str.length();
            StringBuilder sb = new StringBuilder(length2);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length2) {
                    break;
                }
                char charAt = str.charAt(i2);
                int indexOf = str2.indexOf(charAt);
                if (indexOf >= 0) {
                    z = true;
                    if (indexOf < length) {
                        sb.append(str4.charAt(indexOf));
                        z = true;
                    }
                } else {
                    sb.append(charAt);
                }
                i = i2 + 1;
            }
            if (z) {
                return sb.toString();
            }
        }
        return str;
    }

    public static String replaceEach(String str, String[] strArr, String[] strArr2) {
        return replaceEach(str, strArr, strArr2, false, 0);
    }

    private static String replaceEach(String str, String[] strArr, String[] strArr2, boolean z, int i) {
        if (str != null && str.length() != 0 && strArr != null && strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
            if (i < 0) {
                throw new IllegalStateException("Aborting to protect against StackOverflowError - output of one loop is the input of another");
            }
            int length = strArr.length;
            int length2 = strArr2.length;
            if (length != length2) {
                throw new IllegalArgumentException("Search and Replace array lengths don't match: " + length + " vs " + length2);
            }
            boolean[] zArr = new boolean[length];
            int i2 = -1;
            int i3 = -1;
            int i4 = 0;
            while (i4 < length) {
                int i5 = i3;
                int i6 = i2;
                if (!zArr[i4]) {
                    i5 = i3;
                    i6 = i2;
                    if (strArr[i4] != null) {
                        i5 = i3;
                        i6 = i2;
                        if (strArr[i4].length() != 0) {
                            if (strArr2[i4] == null) {
                                i6 = i2;
                                i5 = i3;
                            } else {
                                int indexOf = str.indexOf(strArr[i4]);
                                if (indexOf == -1) {
                                    zArr[i4] = true;
                                    i5 = i3;
                                    i6 = i2;
                                } else {
                                    if (i2 != -1) {
                                        i5 = i3;
                                        i6 = i2;
                                        if (indexOf >= i2) {
                                        }
                                    }
                                    i6 = indexOf;
                                    i5 = i4;
                                }
                            }
                        }
                    }
                }
                i4++;
                i3 = i5;
                i2 = i6;
            }
            if (i2 != -1) {
                int i7 = 0;
                int i8 = 0;
                while (i8 < strArr.length) {
                    int i9 = i7;
                    if (strArr[i8] != null) {
                        if (strArr2[i8] == null) {
                            i9 = i7;
                        } else {
                            int length3 = strArr2[i8].length() - strArr[i8].length();
                            i9 = i7;
                            if (length3 > 0) {
                                i9 = i7 + (length3 * 3);
                            }
                        }
                    }
                    i8++;
                    i7 = i9;
                }
                StringBuilder sb = new StringBuilder(str.length() + Math.min(i7, str.length() / 5));
                int i10 = i2;
                int i11 = 0;
                int i12 = i3;
                while (i10 != -1) {
                    while (i11 < i10) {
                        sb.append(str.charAt(i11));
                        i11++;
                    }
                    sb.append(strArr2[i12]);
                    int length4 = i10 + strArr[i12].length();
                    int i13 = -1;
                    int i14 = -1;
                    int i15 = 0;
                    while (true) {
                        i12 = i14;
                        i11 = length4;
                        i10 = i13;
                        if (i15 < length) {
                            int i16 = i14;
                            int i17 = i13;
                            if (!zArr[i15]) {
                                i16 = i14;
                                i17 = i13;
                                if (strArr[i15] != null) {
                                    i16 = i14;
                                    i17 = i13;
                                    if (strArr[i15].length() != 0) {
                                        if (strArr2[i15] == null) {
                                            i17 = i13;
                                            i16 = i14;
                                        } else {
                                            int indexOf2 = str.indexOf(strArr[i15], length4);
                                            if (indexOf2 == -1) {
                                                zArr[i15] = true;
                                                i16 = i14;
                                                i17 = i13;
                                            } else {
                                                if (i13 != -1) {
                                                    i16 = i14;
                                                    i17 = i13;
                                                    if (indexOf2 >= i13) {
                                                    }
                                                }
                                                i17 = indexOf2;
                                                i16 = i15;
                                            }
                                        }
                                    }
                                }
                            }
                            i15++;
                            i14 = i16;
                            i13 = i17;
                        }
                    }
                }
                int length5 = str.length();
                while (i11 < length5) {
                    sb.append(str.charAt(i11));
                    i11++;
                }
                String sb2 = sb.toString();
                return !z ? sb2 : replaceEach(sb2, strArr, strArr2, z, i - 1);
            }
        }
        return str;
    }

    public static String replaceEachRepeatedly(String str, String[] strArr, String[] strArr2) {
        return replaceEach(str, strArr, strArr2, true, strArr == null ? 0 : strArr.length);
    }

    public static String replaceOnce(String str, String str2, String str3) {
        return replace(str, str2, str3, 1);
    }

    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }

    public static String reverseDelimited(String str, char c2) {
        if (str == null) {
            return null;
        }
        String[] split = split(str, c2);
        ArrayUtils.reverse(split);
        return join(split, c2);
    }

    public static String right(String str, int i) {
        String str2;
        if (str == null) {
            str2 = null;
        } else if (i < 0) {
            return "";
        } else {
            str2 = str;
            if (str.length() > i) {
                return str.substring(str.length() - i);
            }
        }
        return str2;
    }

    public static String rightPad(String str, int i) {
        return rightPad(str, i, ' ');
    }

    public static String rightPad(String str, int i, char c2) {
        String str2;
        if (str == null) {
            str2 = null;
        } else {
            int length = i - str.length();
            str2 = str;
            if (length > 0) {
                return length > 8192 ? rightPad(str, i, String.valueOf(c2)) : str.concat(repeat(c2, length));
            }
        }
        return str2;
    }

    public static String rightPad(String str, int i, String str2) {
        String str3;
        if (str == null) {
            str3 = null;
        } else {
            String str4 = str2;
            if (isEmpty(str2)) {
                str4 = " ";
            }
            int length = str4.length();
            int length2 = i - str.length();
            str3 = str;
            if (length2 > 0) {
                if (length == 1 && length2 <= 8192) {
                    return rightPad(str, i, str4.charAt(0));
                }
                if (length2 == length) {
                    return str.concat(str4);
                }
                if (length2 < length) {
                    return str.concat(str4.substring(0, length2));
                }
                char[] cArr = new char[length2];
                char[] charArray = str4.toCharArray();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= length2) {
                        return str.concat(new String(cArr));
                    }
                    cArr[i3] = charArray[i3 % length];
                    i2 = i3 + 1;
                }
            }
        }
        return str3;
    }

    public static String[] split(String str) {
        return split(str, null, -1);
    }

    public static String[] split(String str, char c2) {
        return splitWorker(str, c2, false);
    }

    public static String[] split(String str, String str2) {
        return splitWorker(str, str2, -1, false);
    }

    public static String[] split(String str, String str2, int i) {
        return splitWorker(str, str2, i, false);
    }

    public static String[] splitByCharacterType(String str) {
        return splitByCharacterType(str, false);
    }

    private static String[] splitByCharacterType(String str, boolean z) {
        int i;
        int i2;
        int i3;
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        int type = Character.getType(charArray[0]);
        int i5 = 0 + 1;
        while (i5 < charArray.length) {
            int type2 = Character.getType(charArray[i5]);
            if (type2 == type) {
                i3 = i4;
                i2 = type;
            } else {
                if (z && type2 == 2 && type == 1) {
                    int i6 = i5 - 1;
                    i = i4;
                    if (i6 != i4) {
                        arrayList.add(new String(charArray, i4, i6 - i4));
                        i = i6;
                    }
                } else {
                    arrayList.add(new String(charArray, i4, i5 - i4));
                    i = i5;
                }
                i2 = type2;
                i3 = i;
            }
            i5++;
            type = i2;
            i4 = i3;
        }
        arrayList.add(new String(charArray, i4, charArray.length - i4));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] splitByCharacterTypeCamelCase(String str) {
        return splitByCharacterType(str, true);
    }

    public static String[] splitByWholeSeparator(String str, String str2) {
        return splitByWholeSeparatorWorker(str, str2, -1, false);
    }

    public static String[] splitByWholeSeparator(String str, String str2, int i) {
        return splitByWholeSeparatorWorker(str, str2, i, false);
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String str2) {
        return splitByWholeSeparatorWorker(str, str2, -1, true);
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String str2, int i) {
        return splitByWholeSeparatorWorker(str, str2, i, true);
    }

    private static String[] splitByWholeSeparatorWorker(String str, String str2, int i, boolean z) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        if (str2 == null || "".equals(str2)) {
            return splitWorker(str, null, i, z);
        }
        int length2 = str2.length();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i4 < length) {
            int indexOf = str.indexOf(str2, i3);
            if (indexOf <= -1) {
                arrayList.add(str.substring(i3));
                i4 = length;
            } else if (indexOf > i3) {
                i2++;
                if (i2 == i) {
                    i4 = length;
                    arrayList.add(str.substring(i3));
                } else {
                    arrayList.add(str.substring(i3, indexOf));
                    i3 = indexOf + length2;
                    i4 = indexOf;
                }
            } else {
                i4 = indexOf;
                int i5 = i2;
                if (z) {
                    i5 = i2 + 1;
                    if (i5 == i) {
                        i4 = length;
                        arrayList.add(str.substring(i3));
                    } else {
                        arrayList.add("");
                        i4 = indexOf;
                    }
                }
                i3 = i4 + length2;
                i2 = i5;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] splitPreserveAllTokens(String str) {
        return splitWorker(str, null, -1, true);
    }

    public static String[] splitPreserveAllTokens(String str, char c2) {
        return splitWorker(str, c2, true);
    }

    public static String[] splitPreserveAllTokens(String str, String str2) {
        return splitWorker(str, str2, -1, true);
    }

    public static String[] splitPreserveAllTokens(String str, String str2, int i) {
        return splitWorker(str, str2, i, true);
    }

    private static String[] splitWorker(String str, char c2, boolean z) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (i < length) {
            if (str.charAt(i) == c2) {
                if (z2 || z) {
                    arrayList.add(str.substring(i2, i));
                    z2 = false;
                    z3 = true;
                }
                i++;
                i2 = i;
            } else {
                z3 = false;
                z2 = true;
                i++;
            }
        }
        if (z2 || (z && z3)) {
            arrayList.add(str.substring(i2, i));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static String[] splitWorker(String str, String str2, int i, boolean z) {
        int i2;
        boolean z2;
        boolean z3;
        int i3;
        int i4;
        boolean z4;
        int i5;
        boolean z5;
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        int i7 = 0;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        if (str2 != null) {
            if (str2.length() != 1) {
                int i8 = 1;
                int i9 = 0;
                boolean z9 = false;
                boolean z10 = false;
                while (true) {
                    i2 = i9;
                    z2 = z9;
                    z3 = z10;
                    i3 = i7;
                    if (i9 >= length) {
                        break;
                    } else if (str2.indexOf(str.charAt(i9)) >= 0) {
                        if (z10 || z) {
                            z9 = true;
                            int i10 = i8 + 1;
                            if (i8 == i) {
                                i9 = length;
                                z9 = false;
                            }
                            arrayList.add(str.substring(i7, i9));
                            i8 = i10;
                            z10 = false;
                        }
                        i9++;
                        i7 = i9;
                    } else {
                        z9 = false;
                        z10 = true;
                        i9++;
                    }
                }
            } else {
                char charAt = str2.charAt(0);
                int i11 = 1;
                i4 = 0;
                z4 = false;
                while (i6 < length) {
                    if (str.charAt(i6) == charAt) {
                        if (z4 || z) {
                            z7 = true;
                            i5 = i11 + 1;
                            if (i11 == i) {
                                i6 = length;
                                z7 = false;
                            }
                            arrayList.add(str.substring(i4, i6));
                            z5 = false;
                        } else {
                            z5 = z4;
                            i5 = i11;
                        }
                        i6++;
                        i11 = i5;
                        z4 = z5;
                        i4 = i6;
                    } else {
                        z7 = false;
                        z4 = true;
                        i6++;
                    }
                }
                if (!z4 || (z && z7)) {
                    arrayList.add(str.substring(i4, i6));
                }
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
        } else {
            int i12 = 1;
            int i13 = 0;
            int i14 = 0;
            while (true) {
                i2 = i14;
                z2 = z8;
                z3 = z6;
                i3 = i13;
                if (i14 >= length) {
                    break;
                } else if (Character.isWhitespace(str.charAt(i14))) {
                    if (z6 || z) {
                        z8 = true;
                        int i15 = i12 + 1;
                        if (i12 == i) {
                            i14 = length;
                            z8 = false;
                        }
                        arrayList.add(str.substring(i13, i14));
                        i12 = i15;
                        z6 = false;
                    }
                    i14++;
                    i13 = i14;
                } else {
                    z8 = false;
                    z6 = true;
                    i14++;
                }
            }
        }
        i6 = i2;
        z7 = z2;
        z4 = z3;
        i4 = i3;
        if (!z4) {
        }
        arrayList.add(str.substring(i4, i6));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean startsWith(CharSequence charSequence, CharSequence charSequence2) {
        return startsWith(charSequence, charSequence2, false);
    }

    private static boolean startsWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        boolean z2;
        if (charSequence == null || charSequence2 == null) {
            z2 = false;
            if (charSequence == null) {
                z2 = false;
                if (charSequence2 == null) {
                    z2 = true;
                }
            }
        } else {
            z2 = false;
            if (charSequence2.length() <= charSequence.length()) {
                return CharSequenceUtils.regionMatches(charSequence, z, 0, charSequence2, 0, charSequence2.length());
            }
        }
        return z2;
    }

    public static boolean startsWithAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (isEmpty(charSequence) || ArrayUtils.isEmpty(charSequenceArr)) {
            return false;
        }
        int length = charSequenceArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (startsWith(charSequence, charSequenceArr[i2])) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static boolean startsWithIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return startsWith(charSequence, charSequence2, true);
    }

    public static String strip(String str) {
        return strip(str, null);
    }

    public static String strip(String str, String str2) {
        return isEmpty(str) ? str : stripEnd(stripStart(str, str2), str2);
    }

    public static String stripAccents(String str) {
        if (str == null) {
            return null;
        }
        try {
            if (InitStripAccents.java6NormalizeMethod != null) {
                return removeAccentsJava6(str);
            }
            if (InitStripAccents.sunDecomposeMethod != null) {
                return removeAccentsSUN(str);
            }
            throw new UnsupportedOperationException("The stripAccents(CharSequence) method requires at least Java6, but got: " + InitStripAccents.java6Exception + "; or a Sun JVM: " + InitStripAccents.sunException);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("IllegalAccessException occurred", e);
        } catch (IllegalArgumentException e2) {
            throw new RuntimeException("IllegalArgumentException occurred", e2);
        } catch (SecurityException e3) {
            throw new RuntimeException("SecurityException occurred", e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException("InvocationTargetException occurred", e4);
        }
    }

    public static String[] stripAll(String... strArr) {
        return stripAll(strArr, null);
    }

    public static String[] stripAll(String[] strArr, String str) {
        String[] strArr2;
        int length;
        if (strArr != null && (length = strArr.length) != 0) {
            String[] strArr3 = new String[length];
            int i = 0;
            while (true) {
                int i2 = i;
                strArr2 = strArr3;
                if (i2 >= length) {
                    break;
                }
                strArr3[i2] = strip(strArr[i2], str);
                i = i2 + 1;
            }
        } else {
            strArr2 = strArr;
        }
        return strArr2;
    }

    public static String stripEnd(String str, String str2) {
        int i;
        if (str != null) {
            int length = str.length();
            if (length != 0) {
                if (str2 != null) {
                    if (str2.length() != 0) {
                        while (true) {
                            i = length;
                            if (length == 0) {
                                break;
                            }
                            i = length;
                            if (str2.indexOf(str.charAt(length - 1)) == -1) {
                                break;
                            }
                            length--;
                        }
                    }
                } else {
                    while (true) {
                        i = length;
                        if (length == 0) {
                            break;
                        }
                        i = length;
                        if (!Character.isWhitespace(str.charAt(length - 1))) {
                            break;
                        }
                        length--;
                    }
                }
                return str.substring(0, i);
            }
        }
        return str;
    }

    public static String stripStart(String str, String str2) {
        int length;
        int i;
        if (str != null && (length = str.length()) != 0) {
            int i2 = 0;
            if (str2 != null) {
                if (str2.length() != 0) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        i = i4;
                        if (i4 == length) {
                            break;
                        }
                        i = i4;
                        if (str2.indexOf(str.charAt(i4)) == -1) {
                            break;
                        }
                        i3 = i4 + 1;
                    }
                }
            } else {
                while (true) {
                    i = i2;
                    if (i2 == length) {
                        break;
                    }
                    i = i2;
                    if (!Character.isWhitespace(str.charAt(i2))) {
                        break;
                    }
                    i2++;
                }
            }
            return str.substring(i);
        }
        return str;
    }

    public static String stripToEmpty(String str) {
        return str == null ? "" : strip(str, null);
    }

    public static String stripToNull(String str) {
        if (str == null) {
            return null;
        }
        String strip = strip(str, null);
        String str2 = strip;
        if (strip.length() == 0) {
            str2 = null;
        }
        return str2;
    }

    public static String substring(String str, int i) {
        if (str == null) {
            return null;
        }
        int i2 = i;
        if (i < 0) {
            i2 = i + str.length();
        }
        int i3 = i2;
        if (i2 < 0) {
            i3 = 0;
        }
        return i3 > str.length() ? "" : str.substring(i3);
    }

    public static String substring(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        int i3 = i2;
        if (i2 < 0) {
            i3 = i2 + str.length();
        }
        int i4 = i;
        if (i < 0) {
            i4 = i + str.length();
        }
        int i5 = i3;
        if (i3 > str.length()) {
            i5 = str.length();
        }
        if (i4 > i5) {
            return "";
        }
        int i6 = i4;
        if (i4 < 0) {
            i6 = 0;
        }
        int i7 = i5;
        if (i5 < 0) {
            i7 = 0;
        }
        return str.substring(i6, i7);
    }

    public static String substringAfter(String str, String str2) {
        int indexOf;
        return isEmpty(str) ? str : (str2 == null || (indexOf = str.indexOf(str2)) == -1) ? "" : str.substring(str2.length() + indexOf);
    }

    public static String substringAfterLast(String str, String str2) {
        int lastIndexOf;
        return isEmpty(str) ? str : (isEmpty(str2) || (lastIndexOf = str.lastIndexOf(str2)) == -1 || lastIndexOf == str.length() - str2.length()) ? "" : str.substring(str2.length() + lastIndexOf);
    }

    public static String substringBefore(String str, String str2) {
        if (!isEmpty(str) && str2 != null) {
            if (str2.length() == 0) {
                return "";
            }
            int indexOf = str.indexOf(str2);
            if (indexOf != -1) {
                return str.substring(0, indexOf);
            }
        }
        return str;
    }

    public static String substringBeforeLast(String str, String str2) {
        int lastIndexOf;
        return (isEmpty(str) || isEmpty(str2) || (lastIndexOf = str.lastIndexOf(str2)) == -1) ? str : str.substring(0, lastIndexOf);
    }

    public static String substringBetween(String str, String str2) {
        return substringBetween(str, str2, str2);
    }

    public static String substringBetween(String str, String str2, String str3) {
        int indexOf;
        int indexOf2;
        if (str == null || str2 == null || str3 == null || (indexOf = str.indexOf(str2)) == -1 || (indexOf2 = str.indexOf(str3, str2.length() + indexOf)) == -1) {
            return null;
        }
        return str.substring(str2.length() + indexOf, indexOf2);
    }

    public static String[] substringsBetween(String str, String str2, String str3) {
        int indexOf;
        int i;
        int indexOf2;
        if (str == null || isEmpty(str2) || isEmpty(str3)) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        int length2 = str3.length();
        int length3 = str2.length();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length - length2 || (indexOf = str.indexOf(str2, i3)) < 0 || (indexOf2 = str.indexOf(str3, (i = indexOf + length3))) < 0) {
                break;
            }
            arrayList.add(str.substring(i, indexOf2));
            i2 = indexOf2 + length2;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String swapCase(String str) {
        if (isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= charArray.length) {
                return new String(charArray);
            }
            char c2 = charArray[i2];
            if (Character.isUpperCase(c2)) {
                charArray[i2] = Character.toLowerCase(c2);
            } else if (Character.isTitleCase(c2)) {
                charArray[i2] = Character.toLowerCase(c2);
            } else if (Character.isLowerCase(c2)) {
                charArray[i2] = Character.toUpperCase(c2);
            }
            i = i2 + 1;
        }
    }

    public static String toString(byte[] bArr, String str) throws UnsupportedEncodingException {
        return str == null ? new String(bArr) : new String(bArr, str);
    }

    public static String trim(String str) {
        if (str == null) {
            return null;
        }
        return str.trim();
    }

    public static String trimToEmpty(String str) {
        return str == null ? "" : str.trim();
    }

    public static String trimToNull(String str) {
        String trim = trim(str);
        String str2 = trim;
        if (isEmpty(trim)) {
            str2 = null;
        }
        return str2;
    }

    public static String uncapitalize(String str) {
        int length;
        return (str == null || (length = str.length()) == 0) ? str : new StringBuilder(length).append(Character.toLowerCase(str.charAt(0))).append(str.substring(1)).toString();
    }

    public static String upperCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase();
    }

    public static String upperCase(String str, Locale locale) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase(locale);
    }
}
