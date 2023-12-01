package com.google.thirdparty.publicsuffix;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/google/thirdparty/publicsuffix/TrieParser.class */
final class TrieParser {
    private static final Joiner PREFIX_JOINER = Joiner.on("");

    TrieParser() {
    }

    private static int doParseTrieToBuilder(List<CharSequence> list, CharSequence charSequence, int i, ImmutableMap.Builder<String, PublicSuffixType> builder) {
        char c2;
        int doParseTrieToBuilder;
        int length = charSequence.length();
        int i2 = i;
        char c3 = 0;
        while (true) {
            c2 = c3;
            if (i2 >= length) {
                break;
            }
            c3 = charSequence.charAt(i2);
            c2 = c3;
            if (c3 == '&') {
                break;
            }
            c2 = c3;
            if (c3 == '?') {
                break;
            }
            c2 = c3;
            if (c3 == '!') {
                break;
            }
            c2 = c3;
            if (c3 == ':') {
                break;
            } else if (c3 == ',') {
                c2 = c3;
                break;
            } else {
                i2++;
            }
        }
        list.add(0, reverse(charSequence.subSequence(i, i2)));
        if (c2 == '!' || c2 == '?' || c2 == ':' || c2 == ',') {
            String join = PREFIX_JOINER.join(list);
            if (join.length() > 0) {
                builder.put(join, PublicSuffixType.fromCode(c2));
            }
        }
        int i3 = i2 + 1;
        int i4 = i3;
        if (c2 != '?') {
            i4 = i3;
            if (c2 != ',') {
                do {
                    i4 = i3;
                    if (i3 >= length) {
                        break;
                    }
                    doParseTrieToBuilder = i3 + doParseTrieToBuilder(list, charSequence, i3, builder);
                    if (charSequence.charAt(doParseTrieToBuilder) == '?') {
                        break;
                    }
                    i3 = doParseTrieToBuilder;
                } while (charSequence.charAt(doParseTrieToBuilder) != ',');
                i4 = doParseTrieToBuilder + 1;
            }
        }
        list.remove(0);
        return i4 - i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ImmutableMap<String, PublicSuffixType> parseTrie(CharSequence charSequence) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        int length = charSequence.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return builder.build();
            }
            i = i2 + doParseTrieToBuilder(Lists.newLinkedList(), charSequence, i2, builder);
        }
    }

    private static CharSequence reverse(CharSequence charSequence) {
        return new StringBuilder(charSequence).reverse();
    }
}
