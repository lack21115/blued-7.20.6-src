package com.google.common.escape;

import com.google.common.base.Preconditions;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/escape/CharEscaper.class */
public abstract class CharEscaper extends Escaper {
    private static final int DEST_PAD_MULTIPLIER = 2;

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
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return str;
            }
            if (escape(str.charAt(i2)) != null) {
                return escapeSlow(str, i2);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract char[] escape(char c2);

    /* JADX INFO: Access modifiers changed from: protected */
    public final String escapeSlow(String str, int i) {
        int i2;
        int length = str.length();
        char[] charBufferFromThreadLocal = Platform.charBufferFromThreadLocal();
        int length2 = charBufferFromThreadLocal.length;
        int i3 = 0;
        int i4 = i;
        int i5 = 0;
        while (i4 < length) {
            char[] escape = escape(str.charAt(i4));
            if (escape == null) {
                i2 = length2;
            } else {
                int length3 = escape.length;
                int i6 = i4 - i3;
                int i7 = i5 + i6;
                int i8 = i7 + length3;
                char[] cArr = charBufferFromThreadLocal;
                i2 = length2;
                if (length2 < i8) {
                    i2 = ((length - i4) * 2) + i8;
                    cArr = growBuffer(charBufferFromThreadLocal, i5, i2);
                }
                int i9 = i5;
                if (i6 > 0) {
                    str.getChars(i3, i4, cArr, i5);
                    i9 = i7;
                }
                i5 = i9;
                if (length3 > 0) {
                    System.arraycopy((Object) escape, 0, (Object) cArr, i9, length3);
                    i5 = i9 + length3;
                }
                i3 = i4 + 1;
                charBufferFromThreadLocal = cArr;
            }
            i4++;
            length2 = i2;
        }
        int i10 = length - i3;
        char[] cArr2 = charBufferFromThreadLocal;
        int i11 = i5;
        if (i10 > 0) {
            i11 = i10 + i5;
            cArr2 = charBufferFromThreadLocal;
            if (length2 < i11) {
                cArr2 = growBuffer(charBufferFromThreadLocal, i5, i11);
            }
            str.getChars(i3, length, cArr2, i5);
        }
        return new String(cArr2, 0, i11);
    }
}
