package com.google.common.escape;

import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/escape/CharEscaperBuilder.class */
public final class CharEscaperBuilder {
    private int max = -1;
    private final Map<Character, String> map = new HashMap();

    /* loaded from: source-8110460-dex2jar.jar:com/google/common/escape/CharEscaperBuilder$CharArrayDecorator.class */
    static class CharArrayDecorator extends CharEscaper {
        private final int replaceLength;
        private final char[][] replacements;

        CharArrayDecorator(char[][] cArr) {
            this.replacements = cArr;
            this.replaceLength = cArr.length;
        }

        @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
        public String escape(String str) {
            int length = str.length();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return str;
                }
                char charAt = str.charAt(i2);
                char[][] cArr = this.replacements;
                if (charAt < cArr.length && cArr[charAt] != null) {
                    return escapeSlow(str, i2);
                }
                i = i2 + 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.escape.CharEscaper
        public char[] escape(char c2) {
            if (c2 < this.replaceLength) {
                return this.replacements[c2];
            }
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CharEscaperBuilder addEscape(char c2, String str) {
        this.map.put(Character.valueOf(c2), Preconditions.checkNotNull(str));
        if (c2 > this.max) {
            this.max = c2;
        }
        return this;
    }

    public CharEscaperBuilder addEscapes(char[] cArr, String str) {
        Preconditions.checkNotNull(str);
        int length = cArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return this;
            }
            addEscape(cArr[i2], str);
            i = i2 + 1;
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [char[], char[][]] */
    public char[][] toArray() {
        ?? r0 = new char[this.max + 1];
        for (Map.Entry<Character, String> entry : this.map.entrySet()) {
            r0[entry.getKey().charValue()] = entry.getValue().toCharArray();
        }
        return r0;
    }

    public Escaper toEscaper() {
        return new CharArrayDecorator(toArray());
    }
}
