package org.commonmark.internal.util;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/util/LinkScanner.class */
public class LinkScanner {
    public static int a(CharSequence charSequence, int i) {
        while (i < charSequence.length()) {
            switch (charSequence.charAt(i)) {
                case '[':
                    return -1;
                case '\\':
                    int i2 = i + 1;
                    if (!Parsing.d(charSequence, i2)) {
                        break;
                    } else {
                        i = i2;
                        break;
                    }
                case ']':
                    return i;
            }
            i++;
        }
        return charSequence.length();
    }

    public static int a(CharSequence charSequence, int i, char c2) {
        int i2;
        while (i < charSequence.length()) {
            char charAt = charSequence.charAt(i);
            if (charAt == '\\') {
                i2 = i + 1;
                if (Parsing.d(charSequence, i2)) {
                    continue;
                    i = i2 + 1;
                }
            }
            if (charAt == c2) {
                return i;
            }
            i2 = i;
            if (c2 == ')') {
                i2 = i;
                if (charAt == '(') {
                    return -1;
                }
            } else {
                continue;
            }
            i = i2 + 1;
        }
        return charSequence.length();
    }

    public static int b(CharSequence charSequence, int i) {
        char charAt;
        if (i >= charSequence.length()) {
            return -1;
        }
        if (charSequence.charAt(i) != '<') {
            return d(charSequence, i);
        }
        while (true) {
            i++;
            if (i >= charSequence.length() || (charAt = charSequence.charAt(i)) == '\n' || charAt == '<') {
                return -1;
            }
            if (charAt == '>') {
                return i + 1;
            }
            if (charAt == '\\') {
                int i2 = i + 1;
                if (Parsing.d(charSequence, i2)) {
                    i = i2;
                }
            }
        }
    }

    public static int c(CharSequence charSequence, int i) {
        if (i >= charSequence.length()) {
            return -1;
        }
        char charAt = charSequence.charAt(i);
        char c2 = '\'';
        if (charAt == '\"') {
            c2 = '\"';
        } else if (charAt != '\'') {
            if (charAt != '(') {
                return -1;
            }
            c2 = ')';
        }
        int a2 = a(charSequence, i + 1, c2);
        if (a2 != -1 && a2 < charSequence.length() && charSequence.charAt(a2) == c2) {
            return a2 + 1;
        }
        return -1;
    }

    private static int d(CharSequence charSequence, int i) {
        int i2;
        int i3;
        int i4 = 0;
        int i5 = i;
        while (i5 < charSequence.length()) {
            char charAt = charSequence.charAt(i5);
            if (charAt == 0 || charAt == ' ') {
                if (i5 != i) {
                    return i5;
                }
                return -1;
            }
            if (charAt == '\\') {
                int i6 = i5 + 1;
                i2 = i4;
                i3 = i5;
                if (Parsing.d(charSequence, i6)) {
                    i3 = i6;
                    i2 = i4;
                }
            } else if (charAt == '(') {
                int i7 = i4 + 1;
                i2 = i7;
                i3 = i5;
                if (i7 > 32) {
                    return -1;
                }
            } else if (charAt != ')') {
                i2 = i4;
                i3 = i5;
                if (Character.isISOControl(charAt)) {
                    if (i5 != i) {
                        return i5;
                    }
                    return -1;
                }
            } else if (i4 == 0) {
                return i5;
            } else {
                i2 = i4 - 1;
                i3 = i5;
            }
            i5 = i3 + 1;
            i4 = i2;
        }
        return charSequence.length();
    }
}
