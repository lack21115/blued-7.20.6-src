package com.android.internal.util;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/CharSequences.class */
public class CharSequences {
    public static int compareToIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        int length = charSequence.length();
        int length2 = charSequence2.length();
        int i = length < length2 ? length : length2;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i) {
                return length - length2;
            }
            int lowerCase = Character.toLowerCase(charSequence.charAt(i4)) - Character.toLowerCase(charSequence2.charAt(i2));
            if (lowerCase != 0) {
                return lowerCase;
            }
            i2++;
            i3 = i4 + 1;
        }
    }

    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (charSequence.charAt(i2) != charSequence2.charAt(i2)) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static CharSequence forAsciiBytes(final byte[] bArr) {
        return new CharSequence() { // from class: com.android.internal.util.CharSequences.1
            @Override // java.lang.CharSequence
            public char charAt(int i) {
                return (char) bArr[i];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return bArr.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i, int i2) {
                return CharSequences.forAsciiBytes(bArr, i, i2);
            }

            @Override // java.lang.CharSequence
            public String toString() {
                return new String(bArr);
            }
        };
    }

    public static CharSequence forAsciiBytes(final byte[] bArr, final int i, final int i2) {
        validate(i, i2, bArr.length);
        return new CharSequence() { // from class: com.android.internal.util.CharSequences.2
            @Override // java.lang.CharSequence
            public char charAt(int i3) {
                return (char) bArr[i + i3];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return i2 - i;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i3, int i4) {
                int i5 = i3 - i;
                int i6 = i4 - i;
                CharSequences.validate(i5, i6, length());
                return CharSequences.forAsciiBytes(bArr, i5, i6);
            }

            @Override // java.lang.CharSequence
            public String toString() {
                return new String(bArr, i, length());
            }
        };
    }

    static void validate(int i, int i2, int i3) {
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 > i3) {
            throw new IndexOutOfBoundsException();
        }
        if (i > i2) {
            throw new IndexOutOfBoundsException();
        }
    }
}
