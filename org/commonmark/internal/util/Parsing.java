package org.commonmark.internal.util;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/util/Parsing.class */
public class Parsing {
    public static int a = 4;

    public static int a(char c, CharSequence charSequence, int i) {
        int length = charSequence.length();
        while (i < length) {
            if (charSequence.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int a(char c, CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            if (charSequence.charAt(i) != c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int a(int i) {
        return 4 - (i % 4);
    }

    public static int a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt == '\n' || charAt == '\r') {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int a(CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            char charAt = charSequence.charAt(i);
            if (charAt != '\t' && charAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static boolean a(CharSequence charSequence) {
        boolean z = false;
        if (e(charSequence, 0) == -1) {
            z = true;
        }
        return z;
    }

    public static int b(char c, CharSequence charSequence, int i, int i2) {
        while (i >= i2) {
            if (charSequence.charAt(i) != c) {
                return i;
            }
            i--;
        }
        return i2 - 1;
    }

    public static int b(CharSequence charSequence, int i, int i2) {
        while (i >= i2) {
            char charAt = charSequence.charAt(i);
            if (charAt != '\t' && charAt != ' ') {
                return i;
            }
            i--;
        }
        return i2 - 1;
    }

    public static boolean b(CharSequence charSequence) {
        int length = charSequence.length();
        boolean z = false;
        if (a(' ', charSequence, 0, length) != length) {
            z = true;
        }
        return z;
    }

    public static boolean b(CharSequence charSequence, int i) {
        return Character.isLetter(Character.codePointAt(charSequence, i));
    }

    public static CharSequence c(CharSequence charSequence) {
        StringBuilder sb;
        int length = charSequence.length();
        StringBuilder sb2 = null;
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt != 0) {
                sb = sb2;
                if (sb2 != null) {
                    sb2.append(charAt);
                    sb = sb2;
                }
            } else {
                sb = sb2;
                if (sb2 == null) {
                    sb = new StringBuilder(length);
                    sb.append(charSequence, 0, i);
                }
                sb.append((char) 65533);
            }
            i++;
            sb2 = sb;
        }
        if (sb2 != null) {
            charSequence = sb2.toString();
        }
        return charSequence;
    }

    public static boolean c(CharSequence charSequence, int i) {
        if (i < charSequence.length()) {
            char charAt = charSequence.charAt(i);
            return charAt == '\t' || charAt == ' ';
        }
        return false;
    }

    public static boolean d(CharSequence charSequence, int i) {
        if (i < charSequence.length()) {
            char charAt = charSequence.charAt(i);
            switch (charAt) {
                case '!':
                case '\"':
                case '#':
                case '$':
                case '%':
                case '&':
                case '\'':
                case '(':
                case ')':
                case '*':
                case '+':
                case ',':
                case '-':
                case '.':
                case '/':
                    return true;
                default:
                    switch (charAt) {
                        case ':':
                        case ';':
                        case '<':
                        case '=':
                        case '>':
                        case '?':
                        case '@':
                            return true;
                        default:
                            switch (charAt) {
                                case '[':
                                case '\\':
                                case ']':
                                case '^':
                                case '_':
                                case '`':
                                    return true;
                                default:
                                    switch (charAt) {
                                        case '{':
                                        case '|':
                                        case '}':
                                        case '~':
                                            return true;
                                        default:
                                            return false;
                                    }
                            }
                    }
            }
        }
        return false;
    }

    private static int e(CharSequence charSequence, int i) {
        int length = charSequence.length();
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt != ' ') {
                switch (charAt) {
                    case '\t':
                    case '\n':
                    case 11:
                    case '\f':
                    case '\r':
                        break;
                    default:
                        return i;
                }
            }
            i++;
        }
        return -1;
    }
}
