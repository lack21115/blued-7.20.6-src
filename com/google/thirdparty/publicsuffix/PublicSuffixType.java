package com.google.thirdparty.publicsuffix;

/* loaded from: source-8110460-dex2jar.jar:com/google/thirdparty/publicsuffix/PublicSuffixType.class */
public enum PublicSuffixType {
    PRIVATE(':', ','),
    REGISTRY('!', '?');
    
    private final char innerNodeCode;
    private final char leafNodeCode;

    PublicSuffixType(char c2, char c3) {
        this.innerNodeCode = c2;
        this.leafNodeCode = c3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PublicSuffixType fromCode(char c2) {
        int i;
        PublicSuffixType[] values = values();
        int length = values.length;
        while (true) {
            int i2 = i;
            if (i2 < length) {
                PublicSuffixType publicSuffixType = values[i2];
                i = (publicSuffixType.getInnerNodeCode() == c2 || publicSuffixType.getLeafNodeCode() == c2) ? 0 : i2 + 1;
                return publicSuffixType;
            }
            throw new IllegalArgumentException("No enum corresponding to given code: " + c2);
        }
    }

    static PublicSuffixType fromIsPrivate(boolean z) {
        return z ? PRIVATE : REGISTRY;
    }

    char getInnerNodeCode() {
        return this.innerNodeCode;
    }

    char getLeafNodeCode() {
        return this.leafNodeCode;
    }
}
