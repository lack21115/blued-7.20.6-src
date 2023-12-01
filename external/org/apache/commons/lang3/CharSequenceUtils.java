package external.org.apache.commons.lang3;

/* loaded from: source-259656-dex2jar.jar:external/org/apache/commons/lang3/CharSequenceUtils.class */
public class CharSequenceUtils {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int indexOf(CharSequence charSequence, int i, int i2) {
        int i3;
        if (charSequence instanceof String) {
            i3 = ((String) charSequence).indexOf(i, i2);
        } else {
            int length = charSequence.length();
            int i4 = i2;
            if (i2 < 0) {
                i4 = 0;
            }
            int i5 = i4;
            while (true) {
                int i6 = i5;
                if (i6 >= length) {
                    return -1;
                }
                i3 = i6;
                if (charSequence.charAt(i6) == i) {
                    break;
                }
                i5 = i6 + 1;
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int indexOf(CharSequence charSequence, CharSequence charSequence2, int i) {
        return charSequence.toString().indexOf(charSequence2.toString(), i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int lastIndexOf(CharSequence charSequence, int i, int i2) {
        int i3;
        if (charSequence instanceof String) {
            i3 = ((String) charSequence).lastIndexOf(i, i2);
        } else {
            int length = charSequence.length();
            if (i2 < 0) {
                return -1;
            }
            int i4 = i2;
            if (i2 >= length) {
                i4 = length - 1;
            }
            int i5 = i4;
            while (true) {
                int i6 = i5;
                if (i6 < 0) {
                    return -1;
                }
                i3 = i6;
                if (charSequence.charAt(i6) == i) {
                    break;
                }
                i5 = i6 - 1;
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int lastIndexOf(CharSequence charSequence, CharSequence charSequence2, int i) {
        return charSequence.toString().lastIndexOf(charSequence2.toString(), i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean regionMatches(CharSequence charSequence, boolean z, int i, CharSequence charSequence2, int i2, int i3) {
        return ((charSequence instanceof String) && (charSequence2 instanceof String)) ? ((String) charSequence).regionMatches(z, i, (String) charSequence2, i2, i3) : charSequence.toString().regionMatches(z, i, charSequence2.toString(), i2, i3);
    }

    public static CharSequence subSequence(CharSequence charSequence, int i) {
        if (charSequence == null) {
            return null;
        }
        return charSequence.subSequence(i, charSequence.length());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static char[] toCharArray(CharSequence charSequence) {
        char[] cArr;
        if (!(charSequence instanceof String)) {
            int length = charSequence.length();
            char[] cArr2 = new char[charSequence.length()];
            int i = 0;
            while (true) {
                int i2 = i;
                cArr = cArr2;
                if (i2 >= length) {
                    break;
                }
                cArr2[i2] = charSequence.charAt(i2);
                i = i2 + 1;
            }
        } else {
            cArr = ((String) charSequence).toCharArray();
        }
        return cArr;
    }
}
