package com.google.common.base;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/base/CaseFormat.class */
public enum CaseFormat {
    LOWER_HYPHEN(CharMatcher.is('-'), Constants.ACCEPT_TIME_SEPARATOR_SERVER) { // from class: com.google.common.base.CaseFormat.1
        @Override // com.google.common.base.CaseFormat
        String convert(CaseFormat caseFormat, String str) {
            return caseFormat == LOWER_UNDERSCORE ? str.replace('-', '_') : caseFormat == UPPER_UNDERSCORE ? Ascii.toUpperCase(str.replace('-', '_')) : super.convert(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        String normalizeWord(String str) {
            return Ascii.toLowerCase(str);
        }
    },
    LOWER_UNDERSCORE(CharMatcher.is('_'), "_") { // from class: com.google.common.base.CaseFormat.2
        @Override // com.google.common.base.CaseFormat
        String convert(CaseFormat caseFormat, String str) {
            return caseFormat == LOWER_HYPHEN ? str.replace('_', '-') : caseFormat == UPPER_UNDERSCORE ? Ascii.toUpperCase(str) : super.convert(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        String normalizeWord(String str) {
            return Ascii.toLowerCase(str);
        }
    },
    LOWER_CAMEL(CharMatcher.inRange('A', 'Z'), "") { // from class: com.google.common.base.CaseFormat.3
        @Override // com.google.common.base.CaseFormat
        String normalizeFirstWord(String str) {
            return Ascii.toLowerCase(str);
        }

        @Override // com.google.common.base.CaseFormat
        String normalizeWord(String str) {
            return CaseFormat.firstCharOnlyToUpper(str);
        }
    },
    UPPER_CAMEL(CharMatcher.inRange('A', 'Z'), "") { // from class: com.google.common.base.CaseFormat.4
        @Override // com.google.common.base.CaseFormat
        String normalizeWord(String str) {
            return CaseFormat.firstCharOnlyToUpper(str);
        }
    },
    UPPER_UNDERSCORE(CharMatcher.is('_'), "_") { // from class: com.google.common.base.CaseFormat.5
        @Override // com.google.common.base.CaseFormat
        String convert(CaseFormat caseFormat, String str) {
            return caseFormat == LOWER_HYPHEN ? Ascii.toLowerCase(str.replace('_', '-')) : caseFormat == LOWER_UNDERSCORE ? Ascii.toLowerCase(str) : super.convert(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        String normalizeWord(String str) {
            return Ascii.toUpperCase(str);
        }
    };
    
    private final CharMatcher wordBoundary;
    private final String wordSeparator;

    /* loaded from: source-8110460-dex2jar.jar:com/google/common/base/CaseFormat$StringConverter.class */
    static final class StringConverter extends Converter<String, String> implements Serializable {
        private static final long serialVersionUID = 0;
        private final CaseFormat sourceFormat;
        private final CaseFormat targetFormat;

        StringConverter(CaseFormat caseFormat, CaseFormat caseFormat2) {
            this.sourceFormat = (CaseFormat) Preconditions.checkNotNull(caseFormat);
            this.targetFormat = (CaseFormat) Preconditions.checkNotNull(caseFormat2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public String doBackward(String str) {
            return this.targetFormat.to(this.sourceFormat, str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public String doForward(String str) {
            return this.sourceFormat.to(this.targetFormat, str);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@NullableDecl Object obj) {
            boolean z = false;
            if (obj instanceof StringConverter) {
                StringConverter stringConverter = (StringConverter) obj;
                z = false;
                if (this.sourceFormat.equals(stringConverter.sourceFormat)) {
                    z = false;
                    if (this.targetFormat.equals(stringConverter.targetFormat)) {
                        z = true;
                    }
                }
            }
            return z;
        }

        public int hashCode() {
            return this.sourceFormat.hashCode() ^ this.targetFormat.hashCode();
        }

        public String toString() {
            return this.sourceFormat + ".converterTo(" + this.targetFormat + ")";
        }
    }

    CaseFormat(CharMatcher charMatcher, String str) {
        this.wordBoundary = charMatcher;
        this.wordSeparator = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String firstCharOnlyToUpper(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return Ascii.toUpperCase(str.charAt(0)) + Ascii.toLowerCase(str.substring(1));
    }

    String convert(CaseFormat caseFormat, String str) {
        StringBuilder sb = null;
        int i = 0;
        int i2 = -1;
        while (true) {
            i2 = this.wordBoundary.indexIn(str, i2 + 1);
            if (i2 == -1) {
                break;
            }
            if (i == 0) {
                sb = new StringBuilder(str.length() + (caseFormat.wordSeparator.length() * 4));
                sb.append(caseFormat.normalizeFirstWord(str.substring(i, i2)));
            } else {
                sb.append(caseFormat.normalizeWord(str.substring(i, i2)));
            }
            sb.append(caseFormat.wordSeparator);
            i = this.wordSeparator.length() + i2;
        }
        if (i == 0) {
            return caseFormat.normalizeFirstWord(str);
        }
        sb.append(caseFormat.normalizeWord(str.substring(i)));
        return sb.toString();
    }

    public Converter<String, String> converterTo(CaseFormat caseFormat) {
        return new StringConverter(this, caseFormat);
    }

    String normalizeFirstWord(String str) {
        return normalizeWord(str);
    }

    abstract String normalizeWord(String str);

    public final String to(CaseFormat caseFormat, String str) {
        Preconditions.checkNotNull(caseFormat);
        Preconditions.checkNotNull(str);
        return caseFormat == this ? str : convert(caseFormat, str);
    }
}
