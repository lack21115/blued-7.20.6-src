package android.net;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.StringTokenizer;

/* loaded from: source-9557208-dex2jar.jar:android/net/UrlQuerySanitizer.class */
public class UrlQuerySanitizer {
    private boolean mAllowUnregisteredParamaters;
    private boolean mPreferFirstRepeatedParameter;
    private static final ValueSanitizer sAllIllegal = new IllegalCharacterValueSanitizer(0);
    private static final ValueSanitizer sAllButNulLegal = new IllegalCharacterValueSanitizer(1535);
    private static final ValueSanitizer sAllButWhitespaceLegal = new IllegalCharacterValueSanitizer(IllegalCharacterValueSanitizer.ALL_BUT_WHITESPACE_LEGAL);
    private static final ValueSanitizer sURLLegal = new IllegalCharacterValueSanitizer(404);
    private static final ValueSanitizer sUrlAndSpaceLegal = new IllegalCharacterValueSanitizer(405);
    private static final ValueSanitizer sAmpLegal = new IllegalCharacterValueSanitizer(128);
    private static final ValueSanitizer sAmpAndSpaceLegal = new IllegalCharacterValueSanitizer(129);
    private static final ValueSanitizer sSpaceLegal = new IllegalCharacterValueSanitizer(1);
    private static final ValueSanitizer sAllButNulAndAngleBracketsLegal = new IllegalCharacterValueSanitizer(IllegalCharacterValueSanitizer.ALL_BUT_NUL_AND_ANGLE_BRACKETS_LEGAL);
    private final HashMap<String, ValueSanitizer> mSanitizers = new HashMap<>();
    private final HashMap<String, String> mEntries = new HashMap<>();
    private final ArrayList<ParameterValuePair> mEntriesList = new ArrayList<>();
    private ValueSanitizer mUnregisteredParameterValueSanitizer = getAllIllegal();

    /* loaded from: source-9557208-dex2jar.jar:android/net/UrlQuerySanitizer$IllegalCharacterValueSanitizer.class */
    public static class IllegalCharacterValueSanitizer implements ValueSanitizer {
        public static final int ALL_BUT_NUL_AND_ANGLE_BRACKETS_LEGAL = 1439;
        public static final int ALL_BUT_NUL_LEGAL = 1535;
        public static final int ALL_BUT_WHITESPACE_LEGAL = 1532;
        public static final int ALL_ILLEGAL = 0;
        public static final int ALL_OK = 2047;
        public static final int ALL_WHITESPACE_OK = 3;
        public static final int AMP_AND_SPACE_LEGAL = 129;
        public static final int AMP_LEGAL = 128;
        public static final int AMP_OK = 128;
        public static final int DQUOTE_OK = 8;
        public static final int GT_OK = 64;
        private static final String JAVASCRIPT_PREFIX = "javascript:";
        public static final int LT_OK = 32;
        public static final int NON_7_BIT_ASCII_OK = 4;
        public static final int NUL_OK = 512;
        public static final int OTHER_WHITESPACE_OK = 2;
        public static final int PCT_OK = 256;
        public static final int SCRIPT_URL_OK = 1024;
        public static final int SPACE_LEGAL = 1;
        public static final int SPACE_OK = 1;
        public static final int SQUOTE_OK = 16;
        public static final int URL_AND_SPACE_LEGAL = 405;
        public static final int URL_LEGAL = 404;
        private int mFlags;
        private static final String VBSCRIPT_PREFIX = "vbscript:";
        private static final int MIN_SCRIPT_PREFIX_LENGTH = Math.min("javascript:".length(), VBSCRIPT_PREFIX.length());

        public IllegalCharacterValueSanitizer(int i) {
            this.mFlags = i;
        }

        private boolean characterIsLegal(char c2) {
            switch (c2) {
                case 0:
                    return (this.mFlags & 512) != 0;
                case '\t':
                case '\n':
                case 11:
                case '\f':
                case '\r':
                    return (this.mFlags & 2) != 0;
                case ' ':
                    return (this.mFlags & 1) != 0;
                case '\"':
                    return (this.mFlags & 8) != 0;
                case '%':
                    return (this.mFlags & 256) != 0;
                case '&':
                    return (this.mFlags & 128) != 0;
                case '\'':
                    return (this.mFlags & 16) != 0;
                case '<':
                    return (this.mFlags & 32) != 0;
                case '>':
                    return (this.mFlags & 64) != 0;
                default:
                    if (c2 < ' ' || c2 >= 127) {
                        return c2 >= 128 && (this.mFlags & 4) != 0;
                    }
                    return true;
            }
        }

        private boolean isWhitespace(char c2) {
            switch (c2) {
                case '\t':
                case '\n':
                case 11:
                case '\f':
                case '\r':
                case ' ':
                    return true;
                default:
                    return false;
            }
        }

        private String trimWhitespace(String str) {
            int i;
            int i2 = 0;
            int length = str.length() - 1;
            while (true) {
                i = length;
                if (i2 > length) {
                    break;
                }
                i = length;
                if (!isWhitespace(str.charAt(i2))) {
                    break;
                }
                i2++;
            }
            while (i >= i2 && isWhitespace(str.charAt(i))) {
                i--;
            }
            return (i2 == 0 && i == length) ? str : str.substring(i2, i + 1);
        }

        @Override // android.net.UrlQuerySanitizer.ValueSanitizer
        public String sanitize(String str) {
            if (str == null) {
                return null;
            }
            int length = str.length();
            if ((this.mFlags & 1024) != 0 && length >= MIN_SCRIPT_PREFIX_LENGTH) {
                String lowerCase = str.toLowerCase(Locale.ROOT);
                if (lowerCase.startsWith("javascript:") || lowerCase.startsWith(VBSCRIPT_PREFIX)) {
                    return "";
                }
            }
            String str2 = str;
            if ((this.mFlags & 3) == 0) {
                str2 = trimWhitespace(str);
                length = str2.length();
            }
            StringBuilder sb = new StringBuilder(length);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return sb.toString();
                }
                char charAt = str2.charAt(i2);
                char c2 = charAt;
                if (!characterIsLegal(charAt)) {
                    c2 = (this.mFlags & 1) != 0 ? ' ' : '_';
                }
                sb.append(c2);
                i = i2 + 1;
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/UrlQuerySanitizer$ParameterValuePair.class */
    public class ParameterValuePair {
        public String mParameter;
        public String mValue;

        public ParameterValuePair(String str, String str2) {
            this.mParameter = str;
            this.mValue = str2;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/UrlQuerySanitizer$ValueSanitizer.class */
    public interface ValueSanitizer {
        String sanitize(String str);
    }

    public UrlQuerySanitizer() {
    }

    public UrlQuerySanitizer(String str) {
        setAllowUnregisteredParamaters(true);
        parseUrl(str);
    }

    public static final ValueSanitizer getAllButNulAndAngleBracketsLegal() {
        return sAllButNulAndAngleBracketsLegal;
    }

    public static final ValueSanitizer getAllButNulLegal() {
        return sAllButNulLegal;
    }

    public static final ValueSanitizer getAllButWhitespaceLegal() {
        return sAllButWhitespaceLegal;
    }

    public static final ValueSanitizer getAllIllegal() {
        return sAllIllegal;
    }

    public static final ValueSanitizer getAmpAndSpaceLegal() {
        return sAmpAndSpaceLegal;
    }

    public static final ValueSanitizer getAmpLegal() {
        return sAmpLegal;
    }

    public static final ValueSanitizer getSpaceLegal() {
        return sSpaceLegal;
    }

    public static final ValueSanitizer getUrlAndSpaceLegal() {
        return sUrlAndSpaceLegal;
    }

    public static final ValueSanitizer getUrlLegal() {
        return sURLLegal;
    }

    protected void addSanitizedEntry(String str, String str2) {
        this.mEntriesList.add(new ParameterValuePair(str, str2));
        if (this.mPreferFirstRepeatedParameter && this.mEntries.containsKey(str)) {
            return;
        }
        this.mEntries.put(str, str2);
    }

    protected void clear() {
        this.mEntries.clear();
        this.mEntriesList.clear();
    }

    protected int decodeHexDigit(char c2) {
        if (c2 < '0' || c2 > '9') {
            if (c2 < 'A' || c2 > 'F') {
                if (c2 < 'a' || c2 > 'f') {
                    return -1;
                }
                return (c2 - 'a') + 10;
            }
            return (c2 - 'A') + 10;
        }
        return c2 - '0';
    }

    public boolean getAllowUnregisteredParamaters() {
        return this.mAllowUnregisteredParamaters;
    }

    public ValueSanitizer getEffectiveValueSanitizer(String str) {
        ValueSanitizer valueSanitizer = getValueSanitizer(str);
        ValueSanitizer valueSanitizer2 = valueSanitizer;
        if (valueSanitizer == null) {
            valueSanitizer2 = valueSanitizer;
            if (this.mAllowUnregisteredParamaters) {
                valueSanitizer2 = getUnregisteredParameterValueSanitizer();
            }
        }
        return valueSanitizer2;
    }

    public List<ParameterValuePair> getParameterList() {
        return this.mEntriesList;
    }

    public Set<String> getParameterSet() {
        return this.mEntries.keySet();
    }

    public boolean getPreferFirstRepeatedParameter() {
        return this.mPreferFirstRepeatedParameter;
    }

    public ValueSanitizer getUnregisteredParameterValueSanitizer() {
        return this.mUnregisteredParameterValueSanitizer;
    }

    public String getValue(String str) {
        return this.mEntries.get(str);
    }

    public ValueSanitizer getValueSanitizer(String str) {
        return this.mSanitizers.get(str);
    }

    public boolean hasParameter(String str) {
        return this.mEntries.containsKey(str);
    }

    protected boolean isHexDigit(char c2) {
        return decodeHexDigit(c2) >= 0;
    }

    protected void parseEntry(String str, String str2) {
        String unescape = unescape(str);
        ValueSanitizer effectiveValueSanitizer = getEffectiveValueSanitizer(unescape);
        if (effectiveValueSanitizer == null) {
            return;
        }
        addSanitizedEntry(unescape, effectiveValueSanitizer.sanitize(unescape(str2)));
    }

    public void parseQuery(String str) {
        clear();
        StringTokenizer stringTokenizer = new StringTokenizer(str, "&");
        while (stringTokenizer.hasMoreElements()) {
            String nextToken = stringTokenizer.nextToken();
            if (nextToken.length() > 0) {
                int indexOf = nextToken.indexOf(61);
                if (indexOf < 0) {
                    parseEntry(nextToken, "");
                } else {
                    parseEntry(nextToken.substring(0, indexOf), nextToken.substring(indexOf + 1));
                }
            }
        }
    }

    public void parseUrl(String str) {
        int indexOf = str.indexOf(63);
        parseQuery(indexOf >= 0 ? str.substring(indexOf + 1) : "");
    }

    public void registerParameter(String str, ValueSanitizer valueSanitizer) {
        if (valueSanitizer == null) {
            this.mSanitizers.remove(str);
        }
        this.mSanitizers.put(str, valueSanitizer);
    }

    public void registerParameters(String[] strArr, ValueSanitizer valueSanitizer) {
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            this.mSanitizers.put(strArr[i2], valueSanitizer);
            i = i2 + 1;
        }
    }

    public void setAllowUnregisteredParamaters(boolean z) {
        this.mAllowUnregisteredParamaters = z;
    }

    public void setPreferFirstRepeatedParameter(boolean z) {
        this.mPreferFirstRepeatedParameter = z;
    }

    public void setUnregisteredParameterValueSanitizer(ValueSanitizer valueSanitizer) {
        this.mUnregisteredParameterValueSanitizer = valueSanitizer;
    }

    public String unescape(String str) {
        char c2;
        int i;
        int indexOf = str.indexOf(37);
        int i2 = indexOf;
        if (indexOf < 0) {
            int indexOf2 = str.indexOf(43);
            i2 = indexOf2;
            if (indexOf2 < 0) {
                return str;
            }
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        sb.append(str.substring(0, i2));
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt == '+') {
                c2 = ' ';
                i = i2;
            } else {
                c2 = charAt;
                i = i2;
                if (charAt == '%') {
                    c2 = charAt;
                    i = i2;
                    if (i2 + 2 < length) {
                        char charAt2 = str.charAt(i2 + 1);
                        char charAt3 = str.charAt(i2 + 2);
                        c2 = charAt;
                        i = i2;
                        if (isHexDigit(charAt2)) {
                            c2 = charAt;
                            i = i2;
                            if (isHexDigit(charAt3)) {
                                c2 = (char) ((decodeHexDigit(charAt2) * 16) + decodeHexDigit(charAt3));
                                i = i2 + 2;
                            }
                        }
                    }
                }
            }
            sb.append(c2);
            i2 = i + 1;
        }
        return sb.toString();
    }
}
