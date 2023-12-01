package com.google.common.net;

import com.google.common.base.Preconditions;
import com.google.common.escape.UnicodeEscaper;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/net/PercentEscaper.class */
public final class PercentEscaper extends UnicodeEscaper {
    private static final char[] PLUS_SIGN = {'+'};
    private static final char[] UPPER_HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    private final boolean plusForSpace;
    private final boolean[] safeOctets;

    public PercentEscaper(String str, boolean z) {
        Preconditions.checkNotNull(str);
        if (str.matches(".*[0-9A-Za-z].*")) {
            throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
        }
        String str2 = str + "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        if (z && str2.contains(" ")) {
            throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
        }
        this.plusForSpace = z;
        this.safeOctets = createSafeOctets(str2);
    }

    private static boolean[] createSafeOctets(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i = -1;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                break;
            }
            i = Math.max((int) charArray[i3], i);
            i2 = i3 + 1;
        }
        boolean[] zArr = new boolean[i + 1];
        int length2 = charArray.length;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= length2) {
                return zArr;
            }
            zArr[charArray[i5]] = true;
            i4 = i5 + 1;
        }
    }

    @Override // com.google.common.escape.UnicodeEscaper, com.google.common.escape.Escaper
    public String escape(String str) {
        int i;
        String str2;
        Preconditions.checkNotNull(str);
        int length = str.length();
        int i2 = 0;
        while (true) {
            i = i2;
            str2 = str;
            if (i >= length) {
                break;
            }
            char charAt = str.charAt(i);
            boolean[] zArr = this.safeOctets;
            if (charAt >= zArr.length || !zArr[charAt]) {
                break;
            }
            i2 = i + 1;
        }
        str2 = escapeSlow(str, i);
        return str2;
    }

    @Override // com.google.common.escape.UnicodeEscaper
    public char[] escape(int i) {
        boolean[] zArr = this.safeOctets;
        if (i >= zArr.length || !zArr[i]) {
            if (i == 32 && this.plusForSpace) {
                return PLUS_SIGN;
            }
            if (i <= 127) {
                char[] cArr = UPPER_HEX_DIGITS;
                return new char[]{'%', cArr[i >>> 4], cArr[i & 15]};
            } else if (i <= 2047) {
                char[] cArr2 = UPPER_HEX_DIGITS;
                char c2 = cArr2[i & 15];
                int i2 = i >>> 4;
                char c3 = cArr2[(i2 & 3) | 8];
                int i3 = i2 >>> 2;
                return new char[]{'%', cArr2[(i3 >>> 4) | 12], cArr2[i3 & 15], '%', c3, c2};
            } else if (i <= 65535) {
                char[] cArr3 = UPPER_HEX_DIGITS;
                char c4 = cArr3[i & 15];
                int i4 = i >>> 4;
                char c5 = cArr3[(i4 & 3) | 8];
                int i5 = i4 >>> 2;
                char c6 = cArr3[i5 & 15];
                int i6 = i5 >>> 4;
                return new char[]{'%', 'E', cArr3[i6 >>> 2], '%', cArr3[(i6 & 3) | 8], c6, '%', c5, c4};
            } else if (i > 1114111) {
                throw new IllegalArgumentException("Invalid unicode character value " + i);
            } else {
                char[] cArr4 = UPPER_HEX_DIGITS;
                char c7 = cArr4[i & 15];
                int i7 = i >>> 4;
                char c8 = cArr4[(i7 & 3) | 8];
                int i8 = i7 >>> 2;
                char c9 = cArr4[i8 & 15];
                int i9 = i8 >>> 4;
                char c10 = cArr4[(i9 & 3) | 8];
                int i10 = i9 >>> 2;
                char c11 = cArr4[i10 & 15];
                int i11 = i10 >>> 4;
                return new char[]{'%', 'F', cArr4[(i11 >>> 2) & 7], '%', cArr4[(i11 & 3) | 8], c11, '%', c10, c9, '%', c8, c7};
            }
        }
        return null;
    }

    @Override // com.google.common.escape.UnicodeEscaper
    public int nextEscapeIndex(CharSequence charSequence, int i, int i2) {
        Preconditions.checkNotNull(charSequence);
        while (i < i2) {
            char charAt = charSequence.charAt(i);
            boolean[] zArr = this.safeOctets;
            if (charAt >= zArr.length) {
                break;
            } else if (!zArr[charAt]) {
                return i;
            } else {
                i++;
            }
        }
        return i;
    }
}
