package com.google.common.escape;

import com.google.common.base.Preconditions;
import java.util.Map;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/escape/ArrayBasedCharEscaper.class */
public abstract class ArrayBasedCharEscaper extends CharEscaper {
    private final char[][] replacements;
    private final int replacementsLength;
    private final char safeMax;
    private final char safeMin;

    protected ArrayBasedCharEscaper(ArrayBasedEscaperMap arrayBasedEscaperMap, char c2, char c3) {
        Preconditions.checkNotNull(arrayBasedEscaperMap);
        char[][] replacementArray = arrayBasedEscaperMap.getReplacementArray();
        this.replacements = replacementArray;
        this.replacementsLength = replacementArray.length;
        char c4 = c2;
        char c5 = c3;
        if (c3 < c2) {
            c5 = 0;
            c4 = 65535;
        }
        this.safeMin = c4;
        this.safeMax = c5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ArrayBasedCharEscaper(Map<Character, String> map, char c2, char c3) {
        this(ArrayBasedEscaperMap.create(map), c2, c3);
    }

    @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
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
            i = ((charAt >= this.replacementsLength || this.replacements[charAt] == null) && charAt <= this.safeMax && charAt >= this.safeMin) ? i2 + 1 : 0;
        }
        return str2;
    }

    @Override // com.google.common.escape.CharEscaper
    protected final char[] escape(char c2) {
        char[] cArr;
        if (c2 >= this.replacementsLength || (cArr = this.replacements[c2]) == null) {
            if (c2 < this.safeMin || c2 > this.safeMax) {
                return escapeUnsafe(c2);
            }
            return null;
        }
        return cArr;
    }

    protected abstract char[] escapeUnsafe(char c2);
}
