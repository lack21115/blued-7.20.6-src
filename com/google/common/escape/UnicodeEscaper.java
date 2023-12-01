package com.google.common.escape;

import com.google.common.base.Preconditions;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/escape/UnicodeEscaper.class */
public abstract class UnicodeEscaper extends Escaper {
    private static final int DEST_PAD = 32;

    protected static int codePointAt(CharSequence charSequence, int i, int i2) {
        Preconditions.checkNotNull(charSequence);
        if (i < i2) {
            int i3 = i + 1;
            char charAt = charSequence.charAt(i);
            if (charAt >= 55296 && charAt <= 57343) {
                if (charAt > 56319) {
                    throw new IllegalArgumentException("Unexpected low surrogate character '" + charAt + "' with value " + ((int) charAt) + " at index " + (i3 - 1) + " in '" + ((Object) charSequence) + "'");
                } else if (i3 == i2) {
                    return -charAt;
                } else {
                    char charAt2 = charSequence.charAt(i3);
                    if (Character.isLowSurrogate(charAt2)) {
                        return Character.toCodePoint(charAt, charAt2);
                    }
                    throw new IllegalArgumentException("Expected low surrogate but got char '" + charAt2 + "' with value " + ((int) charAt2) + " at index " + i3 + " in '" + ((Object) charSequence) + "'");
                }
            }
            return charAt;
        }
        throw new IndexOutOfBoundsException("Index exceeds specified range");
    }

    private static char[] growBuffer(char[] cArr, int i, int i2) {
        if (i2 >= 0) {
            char[] cArr2 = new char[i2];
            if (i > 0) {
                System.arraycopy((Object) cArr, 0, (Object) cArr2, 0, i);
            }
            return cArr2;
        }
        throw new AssertionError("Cannot increase internal buffer any further");
    }

    @Override // com.google.common.escape.Escaper
    public String escape(String str) {
        Preconditions.checkNotNull(str);
        int length = str.length();
        int nextEscapeIndex = nextEscapeIndex(str, 0, length);
        return nextEscapeIndex == length ? str : escapeSlow(str, nextEscapeIndex);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract char[] escape(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public final String escapeSlow(String str, int i) {
        int length = str.length();
        char[] charBufferFromThreadLocal = Platform.charBufferFromThreadLocal();
        int i2 = 0;
        int i3 = 0;
        int i4 = i;
        while (true) {
            int i5 = i3;
            if (i4 >= length) {
                int i6 = length - i2;
                char[] cArr = charBufferFromThreadLocal;
                int i7 = i5;
                if (i6 > 0) {
                    i7 = i6 + i5;
                    cArr = charBufferFromThreadLocal;
                    if (charBufferFromThreadLocal.length < i7) {
                        cArr = growBuffer(charBufferFromThreadLocal, i5, i7);
                    }
                    str.getChars(i2, length, cArr, i5);
                }
                return new String(cArr, 0, i7);
            }
            int codePointAt = codePointAt(str, i4, length);
            if (codePointAt < 0) {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
            char[] escape = escape(codePointAt);
            int i8 = (Character.isSupplementaryCodePoint(codePointAt) ? 2 : 1) + i4;
            char[] cArr2 = charBufferFromThreadLocal;
            int i9 = i2;
            i3 = i5;
            if (escape != null) {
                int i10 = i4 - i2;
                int i11 = i5 + i10;
                int length2 = escape.length + i11;
                cArr2 = charBufferFromThreadLocal;
                if (charBufferFromThreadLocal.length < length2) {
                    cArr2 = growBuffer(charBufferFromThreadLocal, i5, length2 + (length - i4) + 32);
                }
                int i12 = i5;
                if (i10 > 0) {
                    str.getChars(i2, i4, cArr2, i5);
                    i12 = i11;
                }
                int i13 = i12;
                if (escape.length > 0) {
                    System.arraycopy((Object) escape, 0, (Object) cArr2, i12, escape.length);
                    i13 = i12 + escape.length;
                }
                i9 = i8;
                i3 = i13;
            }
            i4 = nextEscapeIndex(str, i8, length);
            charBufferFromThreadLocal = cArr2;
            i2 = i9;
        }
    }

    protected int nextEscapeIndex(CharSequence charSequence, int i, int i2) {
        int codePointAt;
        while (i < i2 && (codePointAt = codePointAt(charSequence, i, i2)) >= 0) {
            if (escape(codePointAt) != null) {
                return i;
            }
            i += Character.isSupplementaryCodePoint(codePointAt) ? 2 : 1;
        }
        return i;
    }
}
