package com.google.common.escape;

import com.google.common.base.Preconditions;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/escape/ArrayBasedUnicodeEscaper.class */
public abstract class ArrayBasedUnicodeEscaper extends UnicodeEscaper {
    private final char[][] replacements;
    private final int replacementsLength;
    private final int safeMax;
    private final char safeMaxChar;
    private final int safeMin;
    private final char safeMinChar;

    protected ArrayBasedUnicodeEscaper(ArrayBasedEscaperMap arrayBasedEscaperMap, int i, int i2, @NullableDecl String str) {
        Preconditions.checkNotNull(arrayBasedEscaperMap);
        char[][] replacementArray = arrayBasedEscaperMap.getReplacementArray();
        this.replacements = replacementArray;
        this.replacementsLength = replacementArray.length;
        int i3 = i;
        int i4 = i2;
        if (i2 < i) {
            i4 = -1;
            i3 = Integer.MAX_VALUE;
        }
        this.safeMin = i3;
        this.safeMax = i4;
        if (i3 >= 55296) {
            this.safeMinChar = (char) 65535;
            this.safeMaxChar = (char) 0;
            return;
        }
        this.safeMinChar = (char) i3;
        this.safeMaxChar = (char) Math.min(i4, 55295);
    }

    protected ArrayBasedUnicodeEscaper(Map<Character, String> map, int i, int i2, @NullableDecl String str) {
        this(ArrayBasedEscaperMap.create(map), i, i2, str);
    }

    @Override // com.google.common.escape.UnicodeEscaper, com.google.common.escape.Escaper
    public final String escape(String str) {
        int i;
        String str2;
        Preconditions.checkNotNull(str);
        while (true) {
            int i2 = i;
            str2 = str;
            if (i2 >= str.length()) {
                break;
            }
            char charAt = str.charAt(i2);
            i = ((charAt >= this.replacementsLength || this.replacements[charAt] == null) && charAt <= this.safeMaxChar && charAt >= this.safeMinChar) ? i2 + 1 : 0;
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.escape.UnicodeEscaper
    public final char[] escape(int i) {
        char[] cArr;
        if (i >= this.replacementsLength || (cArr = this.replacements[i]) == null) {
            if (i < this.safeMin || i > this.safeMax) {
                return escapeUnsafe(i);
            }
            return null;
        }
        return cArr;
    }

    protected abstract char[] escapeUnsafe(int i);

    @Override // com.google.common.escape.UnicodeEscaper
    protected final int nextEscapeIndex(CharSequence charSequence, int i, int i2) {
        char charAt;
        while (i < i2 && (((charAt = charSequence.charAt(i)) >= this.replacementsLength || this.replacements[charAt] == null) && charAt <= this.safeMaxChar)) {
            if (charAt < this.safeMinChar) {
                return i;
            }
            i++;
        }
        return i;
    }
}
