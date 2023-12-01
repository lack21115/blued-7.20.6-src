package android.text;

import java.util.Locale;

/* loaded from: source-9557208-dex2jar.jar:android/text/BidiFormatter.class */
public final class BidiFormatter {
    private static final int DEFAULT_FLAGS = 2;
    private static final int DIR_LTR = -1;
    private static final int DIR_RTL = 1;
    private static final int DIR_UNKNOWN = 0;
    private static final String EMPTY_STRING = "";
    private static final int FLAG_STEREO_RESET = 2;
    private static final char LRE = 8234;
    private static final char LRM = 8206;
    private static final char PDF = 8236;
    private static final char RLE = 8235;
    private static final char RLM = 8207;
    private final TextDirectionHeuristic mDefaultTextDirectionHeuristic;
    private final int mFlags;
    private final boolean mIsRtlContext;
    private static TextDirectionHeuristic DEFAULT_TEXT_DIRECTION_HEURISTIC = TextDirectionHeuristics.FIRSTSTRONG_LTR;
    private static final String LRM_STRING = Character.toString(8206);
    private static final String RLM_STRING = Character.toString(8207);
    private static final BidiFormatter DEFAULT_LTR_INSTANCE = new BidiFormatter(false, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
    private static final BidiFormatter DEFAULT_RTL_INSTANCE = new BidiFormatter(true, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);

    /* loaded from: source-9557208-dex2jar.jar:android/text/BidiFormatter$Builder.class */
    public static final class Builder {
        private int mFlags;
        private boolean mIsRtlContext;
        private TextDirectionHeuristic mTextDirectionHeuristic;

        public Builder() {
            initialize(BidiFormatter.isRtlLocale(Locale.getDefault()));
        }

        public Builder(Locale locale) {
            initialize(BidiFormatter.isRtlLocale(locale));
        }

        public Builder(boolean z) {
            initialize(z);
        }

        private static BidiFormatter getDefaultInstanceFromContext(boolean z) {
            return z ? BidiFormatter.DEFAULT_RTL_INSTANCE : BidiFormatter.DEFAULT_LTR_INSTANCE;
        }

        private void initialize(boolean z) {
            this.mIsRtlContext = z;
            this.mTextDirectionHeuristic = BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC;
            this.mFlags = 2;
        }

        public BidiFormatter build() {
            return (this.mFlags == 2 && this.mTextDirectionHeuristic == BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC) ? getDefaultInstanceFromContext(this.mIsRtlContext) : new BidiFormatter(this.mIsRtlContext, this.mFlags, this.mTextDirectionHeuristic);
        }

        public Builder setTextDirectionHeuristic(TextDirectionHeuristic textDirectionHeuristic) {
            this.mTextDirectionHeuristic = textDirectionHeuristic;
            return this;
        }

        public Builder stereoReset(boolean z) {
            if (z) {
                this.mFlags |= 2;
                return this;
            }
            this.mFlags &= -3;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/text/BidiFormatter$DirectionalityEstimator.class */
    public static class DirectionalityEstimator {
        private static final byte[] DIR_TYPE_CACHE = new byte[1792];
        private static final int DIR_TYPE_CACHE_SIZE = 1792;
        private int charIndex;
        private final boolean isHtml;
        private char lastChar;
        private final int length;
        private final String text;

        static {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 1792) {
                    return;
                }
                DIR_TYPE_CACHE[i2] = Character.getDirectionality(i2);
                i = i2 + 1;
            }
        }

        DirectionalityEstimator(String str, boolean z) {
            this.text = str;
            this.isHtml = z;
            this.length = str.length();
        }

        private static byte getCachedDirectionality(char c2) {
            return c2 < 1792 ? DIR_TYPE_CACHE[c2] : Character.getDirectionality(c2);
        }

        private byte skipEntityBackward() {
            int i = this.charIndex;
            while (this.charIndex > 0) {
                String str = this.text;
                int i2 = this.charIndex - 1;
                this.charIndex = i2;
                this.lastChar = str.charAt(i2);
                if (this.lastChar != '&') {
                    if (this.lastChar == ';') {
                        break;
                    }
                } else {
                    return (byte) 12;
                }
            }
            this.charIndex = i;
            this.lastChar = ';';
            return (byte) 13;
        }

        private byte skipEntityForward() {
            while (this.charIndex < this.length) {
                String str = this.text;
                int i = this.charIndex;
                this.charIndex = i + 1;
                char charAt = str.charAt(i);
                this.lastChar = charAt;
                if (charAt == ';') {
                    return (byte) 12;
                }
            }
            return (byte) 12;
        }

        private byte skipTagBackward() {
            int i = this.charIndex;
            while (this.charIndex > 0) {
                String str = this.text;
                int i2 = this.charIndex - 1;
                this.charIndex = i2;
                this.lastChar = str.charAt(i2);
                if (this.lastChar == '<') {
                    return (byte) 12;
                }
                if (this.lastChar == '>') {
                    break;
                } else if (this.lastChar == '\"' || this.lastChar == '\'') {
                    char c2 = this.lastChar;
                    while (this.charIndex > 0) {
                        String str2 = this.text;
                        int i3 = this.charIndex - 1;
                        this.charIndex = i3;
                        char charAt = str2.charAt(i3);
                        this.lastChar = charAt;
                        if (charAt == c2) {
                            break;
                        }
                    }
                }
            }
            this.charIndex = i;
            this.lastChar = '>';
            return (byte) 13;
        }

        private byte skipTagForward() {
            int i = this.charIndex;
            while (this.charIndex < this.length) {
                String str = this.text;
                int i2 = this.charIndex;
                this.charIndex = i2 + 1;
                this.lastChar = str.charAt(i2);
                if (this.lastChar == '>') {
                    return (byte) 12;
                }
                if (this.lastChar == '\"' || this.lastChar == '\'') {
                    char c2 = this.lastChar;
                    while (this.charIndex < this.length) {
                        String str2 = this.text;
                        int i3 = this.charIndex;
                        this.charIndex = i3 + 1;
                        char charAt = str2.charAt(i3);
                        this.lastChar = charAt;
                        if (charAt == c2) {
                            break;
                        }
                    }
                }
            }
            this.charIndex = i;
            this.lastChar = '<';
            return (byte) 13;
        }

        byte dirTypeBackward() {
            byte b;
            this.lastChar = this.text.charAt(this.charIndex - 1);
            if (Character.isLowSurrogate(this.lastChar)) {
                int codePointBefore = Character.codePointBefore(this.text, this.charIndex);
                this.charIndex -= Character.charCount(codePointBefore);
                b = Character.getDirectionality(codePointBefore);
            } else {
                this.charIndex--;
                byte cachedDirectionality = getCachedDirectionality(this.lastChar);
                b = cachedDirectionality;
                if (this.isHtml) {
                    if (this.lastChar == '>') {
                        return skipTagBackward();
                    }
                    b = cachedDirectionality;
                    if (this.lastChar == ';') {
                        return skipEntityBackward();
                    }
                }
            }
            return b;
        }

        byte dirTypeForward() {
            byte b;
            this.lastChar = this.text.charAt(this.charIndex);
            if (Character.isHighSurrogate(this.lastChar)) {
                int codePointAt = Character.codePointAt(this.text, this.charIndex);
                this.charIndex += Character.charCount(codePointAt);
                b = Character.getDirectionality(codePointAt);
            } else {
                this.charIndex++;
                byte cachedDirectionality = getCachedDirectionality(this.lastChar);
                b = cachedDirectionality;
                if (this.isHtml) {
                    if (this.lastChar == '<') {
                        return skipTagForward();
                    }
                    b = cachedDirectionality;
                    if (this.lastChar == '&') {
                        return skipEntityForward();
                    }
                }
            }
            return b;
        }

        int getEntryDir() {
            int i;
            this.charIndex = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (this.charIndex < this.length && i4 == 0) {
                switch (dirTypeForward()) {
                    case 0:
                        if (i2 != 0) {
                            i4 = i2;
                            break;
                        } else {
                            i = -1;
                            return i;
                        }
                    case 1:
                    case 2:
                        if (i2 != 0) {
                            i4 = i2;
                            break;
                        } else {
                            return 1;
                        }
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    default:
                        i4 = i2;
                        break;
                    case 9:
                        break;
                    case 14:
                    case 15:
                        i2++;
                        i3 = -1;
                        break;
                    case 16:
                    case 17:
                        i2++;
                        i3 = 1;
                        break;
                    case 18:
                        i2--;
                        i3 = 0;
                        break;
                }
            }
            if (i4 == 0) {
                return 0;
            }
            i = i3;
            if (i3 == 0) {
                while (this.charIndex > 0) {
                    switch (dirTypeBackward()) {
                        case 14:
                        case 15:
                            if (i4 != i2) {
                                i2--;
                                break;
                            } else {
                                return -1;
                            }
                        case 16:
                        case 17:
                            if (i4 != i2) {
                                i2--;
                                break;
                            } else {
                                return 1;
                            }
                        case 18:
                            i2++;
                            break;
                    }
                }
                return 0;
            }
            return i;
        }

        int getExitDir() {
            this.charIndex = this.length;
            int i = 0;
            int i2 = 0;
            while (this.charIndex > 0) {
                switch (dirTypeBackward()) {
                    case 0:
                        if (i != 0) {
                            if (i2 != 0) {
                                break;
                            } else {
                                i2 = i;
                                break;
                            }
                        } else {
                            return -1;
                        }
                    case 1:
                    case 2:
                        if (i != 0) {
                            if (i2 != 0) {
                                break;
                            } else {
                                i2 = i;
                                break;
                            }
                        } else {
                            return 1;
                        }
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    default:
                        if (i2 != 0) {
                            break;
                        } else {
                            i2 = i;
                            break;
                        }
                    case 9:
                        break;
                    case 14:
                    case 15:
                        if (i2 != i) {
                            i--;
                            break;
                        } else {
                            return -1;
                        }
                    case 16:
                    case 17:
                        if (i2 != i) {
                            i--;
                            break;
                        } else {
                            return 1;
                        }
                    case 18:
                        i++;
                        break;
                }
            }
            return 0;
        }
    }

    private BidiFormatter(boolean z, int i, TextDirectionHeuristic textDirectionHeuristic) {
        this.mIsRtlContext = z;
        this.mFlags = i;
        this.mDefaultTextDirectionHeuristic = textDirectionHeuristic;
    }

    private static int getEntryDir(String str) {
        return new DirectionalityEstimator(str, false).getEntryDir();
    }

    private static int getExitDir(String str) {
        return new DirectionalityEstimator(str, false).getExitDir();
    }

    public static BidiFormatter getInstance() {
        return new Builder().build();
    }

    public static BidiFormatter getInstance(Locale locale) {
        return new Builder(locale).build();
    }

    public static BidiFormatter getInstance(boolean z) {
        return new Builder(z).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isRtlLocale(Locale locale) {
        return TextUtils.getLayoutDirectionFromLocale(locale) == 1;
    }

    public boolean getStereoReset() {
        return (this.mFlags & 2) != 0;
    }

    public boolean isRtl(String str) {
        return this.mDefaultTextDirectionHeuristic.isRtl(str, 0, str.length());
    }

    public boolean isRtlContext() {
        return this.mIsRtlContext;
    }

    public String markAfter(String str, TextDirectionHeuristic textDirectionHeuristic) {
        boolean isRtl = textDirectionHeuristic.isRtl(str, 0, str.length());
        return (this.mIsRtlContext || !(isRtl || getExitDir(str) == 1)) ? this.mIsRtlContext ? (!isRtl || getExitDir(str) == -1) ? RLM_STRING : "" : "" : LRM_STRING;
    }

    public String markBefore(String str, TextDirectionHeuristic textDirectionHeuristic) {
        boolean isRtl = textDirectionHeuristic.isRtl(str, 0, str.length());
        return (this.mIsRtlContext || !(isRtl || getEntryDir(str) == 1)) ? this.mIsRtlContext ? (!isRtl || getEntryDir(str) == -1) ? RLM_STRING : "" : "" : LRM_STRING;
    }

    public String unicodeWrap(String str) {
        return unicodeWrap(str, this.mDefaultTextDirectionHeuristic, true);
    }

    public String unicodeWrap(String str, TextDirectionHeuristic textDirectionHeuristic) {
        return unicodeWrap(str, textDirectionHeuristic, true);
    }

    public String unicodeWrap(String str, TextDirectionHeuristic textDirectionHeuristic, boolean z) {
        boolean isRtl = textDirectionHeuristic.isRtl(str, 0, str.length());
        StringBuilder sb = new StringBuilder();
        if (getStereoReset() && z) {
            sb.append(markBefore(str, isRtl ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR));
        }
        if (isRtl != this.mIsRtlContext) {
            sb.append(isRtl ? RLE : LRE);
            sb.append(str);
            sb.append((char) 8236);
        } else {
            sb.append(str);
        }
        if (z) {
            sb.append(markAfter(str, isRtl ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR));
        }
        return sb.toString();
    }

    public String unicodeWrap(String str, boolean z) {
        return unicodeWrap(str, this.mDefaultTextDirectionHeuristic, z);
    }
}
