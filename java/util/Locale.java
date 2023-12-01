package java.util;

import android.provider.Contacts;
import android.speech.tts.TextToSpeech;
import android.text.style.SuggestionSpan;
import com.anythink.expressad.video.dynview.a.a;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import libcore.icu.ICU;

/* loaded from: source-2895416-dex2jar.jar:java/util/Locale.class */
public final class Locale implements Cloneable, Serializable {
    public static final char PRIVATE_USE_EXTENSION = 'x';
    private static final String UNDETERMINED_LANGUAGE = "und";
    public static final char UNICODE_LOCALE_EXTENSION = 'u';
    private static Locale defaultLocale;
    private static final long serialVersionUID = 9149081749638150636L;
    private transient String cachedIcuLocaleId;
    private transient String cachedLanguageTag;
    private transient String cachedToStringResult;
    private transient String countryCode;
    private transient Map<Character, String> extensions;
    private final transient boolean hasValidatedFields;
    private transient String languageCode;
    private transient String scriptCode;
    private transient Set<String> unicodeAttributes;
    private transient Map<String, String> unicodeKeywords;
    private transient String variantCode;
    public static final Locale CANADA = new Locale(true, "en", "CA");
    public static final Locale CANADA_FRENCH = new Locale(true, a.Z, "CA");
    public static final Locale CHINA = new Locale(true, a.V, "CN");
    public static final Locale CHINESE = new Locale(true, a.V, "");
    public static final Locale ENGLISH = new Locale(true, "en", "");
    public static final Locale FRANCE = new Locale(true, a.Z, "FR");
    public static final Locale FRENCH = new Locale(true, a.Z, "");
    public static final Locale GERMAN = new Locale(true, a.X, "");
    public static final Locale GERMANY = new Locale(true, a.X, "DE");
    public static final Locale ITALIAN = new Locale(true, "it", "");
    public static final Locale ITALY = new Locale(true, "it", "IT");
    public static final Locale JAPAN = new Locale(true, a.W, "JP");
    public static final Locale JAPANESE = new Locale(true, a.W, "");
    public static final Locale KOREA = new Locale(true, a.Y, "KR");
    public static final Locale KOREAN = new Locale(true, a.Y, "");
    public static final Locale PRC = new Locale(true, a.V, "CN");
    public static final Locale ROOT = new Locale(true, "", "");
    public static final Locale SIMPLIFIED_CHINESE = new Locale(true, a.V, "CN");
    public static final Locale TAIWAN = new Locale(true, a.V, "TW");
    public static final Locale TRADITIONAL_CHINESE = new Locale(true, a.V, "TW");
    public static final Locale UK = new Locale(true, "en", "GB");
    public static final Locale US = new Locale(true, "en", "US");
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("country", String.class), new ObjectStreamField(SuggestionSpan.SUGGESTION_SPAN_PICKED_HASHCODE, Integer.TYPE), new ObjectStreamField("language", String.class), new ObjectStreamField(TextToSpeech.Engine.KEY_PARAM_VARIANT, String.class), new ObjectStreamField("script", String.class), new ObjectStreamField(Contacts.People.Extensions.CONTENT_DIRECTORY, String.class)};
    private static final TreeMap<String, String> GRANDFATHERED_LOCALES = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    /* loaded from: source-2895416-dex2jar.jar:java/util/Locale$Builder.class */
    public static final class Builder {
        private String script = "";
        private String variant = "";
        private String region = "";
        private String language = "";
        private final Set<String> attributes = new TreeSet();
        private final Map<String, String> keywords = new TreeMap();
        private final Map<Character, String> extensions = new TreeMap();

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isValidVariantSubtag(String str) {
            char charAt;
            return (str.length() < 5 || str.length() > 8) ? str.length() == 4 && (charAt = str.charAt(0)) >= '0' && charAt <= '9' && Locale.isAsciiAlphaNum(str) : Locale.isAsciiAlphaNum(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String normalizeAndValidateLanguage(String str, boolean z) {
            String str2;
            if (str == null || str.isEmpty()) {
                str2 = "";
            } else {
                String lowerCase = str.toLowerCase(Locale.ROOT);
                str2 = lowerCase;
                if (!Locale.isValidBcp47Alpha(lowerCase, 2, 3)) {
                    if (z) {
                        throw new IllformedLocaleException("Invalid language: " + str);
                    }
                    return "und";
                }
            }
            return str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String normalizeAndValidateRegion(String str, boolean z) {
            String str2;
            if (str == null || str.isEmpty()) {
                str2 = "";
            } else {
                String upperCase = str.toUpperCase(Locale.ROOT);
                str2 = upperCase;
                if (!Locale.isValidBcp47Alpha(upperCase, 2, 2)) {
                    str2 = upperCase;
                    if (!Locale.isUnM49AreaCode(upperCase)) {
                        if (z) {
                            throw new IllformedLocaleException("Invalid region: " + str);
                        }
                        return "";
                    }
                }
            }
            return str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String normalizeAndValidateScript(String str, boolean z) {
            if (str == null || str.isEmpty()) {
                return "";
            }
            if (Locale.isValidBcp47Alpha(str, 4, 4)) {
                return Locale.titleCaseAsciiWord(str);
            }
            if (z) {
                throw new IllformedLocaleException("Invalid script: " + str);
            }
            return "";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String normalizeAndValidateVariant(String str) {
            String str2;
            if (str != null && !str.isEmpty()) {
                String replace = str.replace('-', '_');
                String[] split = replace.split(BridgeUtil.UNDERLINE_STR);
                int length = split.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    str2 = replace;
                    if (i2 >= length) {
                        break;
                    } else if (!isValidVariantSubtag(split[i2])) {
                        throw new IllformedLocaleException("Invalid variant: " + str);
                    } else {
                        i = i2 + 1;
                    }
                }
            } else {
                str2 = "";
            }
            return str2;
        }

        public Builder addUnicodeLocaleAttribute(String str) {
            if (str == null) {
                throw new NullPointerException("attribute == null");
            }
            String lowerCase = str.toLowerCase(Locale.ROOT);
            if (Locale.isValidBcp47Alphanum(lowerCase, 3, 8)) {
                this.attributes.add(lowerCase);
                return this;
            }
            throw new IllformedLocaleException("Invalid locale attribute: " + str);
        }

        public Locale build() {
            return new Locale(this.language, this.region, this.variant, this.script, this.attributes, this.keywords, this.extensions, true);
        }

        public Builder clear() {
            clearExtensions();
            this.script = "";
            this.variant = "";
            this.region = "";
            this.language = "";
            return this;
        }

        public Builder clearExtensions() {
            this.extensions.clear();
            this.attributes.clear();
            this.keywords.clear();
            return this;
        }

        public Builder removeUnicodeLocaleAttribute(String str) {
            if (str == null) {
                throw new NullPointerException("attribute == null");
            }
            if (Locale.isValidBcp47Alphanum(str.toLowerCase(Locale.ROOT), 3, 8)) {
                this.attributes.remove(str);
                return this;
            }
            throw new IllformedLocaleException("Invalid locale attribute: " + str);
        }

        public Builder setExtension(char c2, String str) {
            if (str == null || str.isEmpty()) {
                this.extensions.remove(Character.valueOf(c2));
                return this;
            }
            String replace = str.toLowerCase(Locale.ROOT).replace('_', '-');
            String[] split = replace.split("-");
            int i = c2 == 'x' ? 1 : 2;
            int length = split.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    if (c2 != 'u') {
                        this.extensions.put(Character.valueOf(c2), replace);
                        return this;
                    }
                    this.extensions.clear();
                    this.attributes.clear();
                    Locale.parseUnicodeExtension(split, this.keywords, this.attributes);
                    return this;
                } else if (!Locale.isValidBcp47Alphanum(split[i3], i, 8)) {
                    throw new IllformedLocaleException("Invalid private use extension : " + str);
                } else {
                    i2 = i3 + 1;
                }
            }
        }

        public Builder setLanguage(String str) {
            this.language = normalizeAndValidateLanguage(str, true);
            return this;
        }

        public Builder setLanguageTag(String str) {
            if (str == null || str.isEmpty()) {
                clear();
                return this;
            }
            Locale forLanguageTag = Locale.forLanguageTag(str, true);
            if (forLanguageTag == null) {
                throw new IllformedLocaleException("Invalid languageTag: " + str);
            }
            setLocale(forLanguageTag);
            return this;
        }

        public Builder setLocale(Locale locale) {
            if (locale == null) {
                throw new NullPointerException("locale == null");
            }
            String str = this.language;
            String str2 = this.region;
            String str3 = this.variant;
            try {
                setLanguage(locale.getLanguage());
                setRegion(locale.getCountry());
                setVariant(locale.getVariant());
                this.script = locale.getScript();
                this.extensions.clear();
                this.extensions.putAll(locale.extensions);
                this.keywords.clear();
                this.keywords.putAll(locale.unicodeKeywords);
                this.attributes.clear();
                this.attributes.addAll(locale.unicodeAttributes);
                return this;
            } catch (IllformedLocaleException e) {
                this.language = str;
                this.region = str2;
                this.variant = str3;
                throw e;
            }
        }

        public Builder setRegion(String str) {
            this.region = normalizeAndValidateRegion(str, true);
            return this;
        }

        public Builder setScript(String str) {
            this.script = normalizeAndValidateScript(str, true);
            return this;
        }

        public Builder setUnicodeLocaleKeyword(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("key == null");
            }
            if (str2 == null && this.keywords != null) {
                this.keywords.remove(str);
                return this;
            }
            String lowerCase = str.toLowerCase(Locale.ROOT);
            if (lowerCase.length() == 2 && Locale.isAsciiAlphaNum(lowerCase)) {
                String replace = str2.toLowerCase(Locale.ROOT).replace(BridgeUtil.UNDERLINE_STR, "-");
                if (Locale.isValidTypeList(replace)) {
                    this.keywords.put(lowerCase, replace);
                    return this;
                }
                throw new IllformedLocaleException("Invalid unicode locale type: " + str2);
            }
            throw new IllformedLocaleException("Invalid unicode locale keyword: " + str);
        }

        public Builder setVariant(String str) {
            this.variant = normalizeAndValidateVariant(str);
            return this;
        }
    }

    static {
        defaultLocale = US;
        defaultLocale = new Locale(System.getProperty("user.language", "en"), System.getProperty("user.region", "US"), System.getProperty("user.variant", ""));
        TreeMap<String, String> treeMap = GRANDFATHERED_LOCALES;
        throw new VerifyError("bad dex opcode");
    }

    public Locale(String str) {
        this(str, "", "", "", Collections.EMPTY_SET, Collections.EMPTY_MAP, Collections.EMPTY_MAP, false);
    }

    public Locale(String str, String str2) {
        this(str, str2, "", "", Collections.EMPTY_SET, Collections.EMPTY_MAP, Collections.EMPTY_MAP, false);
    }

    public Locale(String str, String str2, String str3) {
        this(str, str2, str3, "", Collections.EMPTY_SET, Collections.EMPTY_MAP, Collections.EMPTY_MAP, false);
    }

    public Locale(String str, String str2, String str3, String str4, Set<String> set, Map<String, String> map, Map<Character, String> map2, boolean z) {
        if (str == null || str2 == null || str3 == null) {
            throw new NullPointerException("language=" + str + ",country=" + str2 + ",variant=" + str3);
        }
        if (z) {
            this.languageCode = adjustLanguageCode(str);
            this.countryCode = str2;
            this.variantCode = str3;
        } else if (str.isEmpty() && str2.isEmpty()) {
            this.languageCode = "";
            this.countryCode = "";
            this.variantCode = str3;
        } else {
            this.languageCode = adjustLanguageCode(str);
            this.countryCode = str2.toUpperCase(US);
            this.variantCode = str3;
        }
        this.scriptCode = str4;
        if (z) {
            TreeSet treeSet = new TreeSet(set);
            TreeMap treeMap = new TreeMap(map);
            TreeMap treeMap2 = new TreeMap(map2);
            addUnicodeExtensionToExtensionsMap(treeSet, treeMap, treeMap2);
            this.unicodeAttributes = Collections.unmodifiableSet(treeSet);
            this.unicodeKeywords = Collections.unmodifiableMap(treeMap);
            this.extensions = Collections.unmodifiableMap(treeMap2);
        } else {
            this.unicodeAttributes = set;
            this.unicodeKeywords = map;
            this.extensions = map2;
        }
        this.hasValidatedFields = z;
    }

    private Locale(boolean z, String str, String str2) {
        this.languageCode = str;
        this.countryCode = str2;
        this.variantCode = "";
        this.scriptCode = "";
        this.unicodeAttributes = Collections.EMPTY_SET;
        this.unicodeKeywords = Collections.EMPTY_MAP;
        this.extensions = Collections.EMPTY_MAP;
        this.hasValidatedFields = z;
    }

    private static void addUnicodeExtensionToExtensionsMap(Set<String> set, Map<String, String> map, Map<Character, String> map2) {
        if (set.isEmpty() && map.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder(32);
        if (!set.isEmpty()) {
            Iterator<String> it = set.iterator();
            while (true) {
                sb.append(it.next());
                if (!it.hasNext()) {
                    break;
                }
                sb.append('-');
            }
        }
        if (!map.isEmpty()) {
            if (!set.isEmpty()) {
                sb.append('-');
            }
            Iterator<Map.Entry<String, String>> it2 = map.entrySet().iterator();
            while (true) {
                Map.Entry<String, String> next = it2.next();
                sb.append(next.getKey());
                if (!next.getValue().isEmpty()) {
                    sb.append('-');
                    sb.append(next.getValue());
                }
                if (!it2.hasNext()) {
                    break;
                }
                sb.append('-');
            }
        }
        map2.put('u', sb.toString());
    }

    public static String adjustLanguageCode(String str) {
        String lowerCase = str.toLowerCase(US);
        if (str.equals("he")) {
            lowerCase = "iw";
        } else if (str.equals("id")) {
            return "in";
        } else {
            if (str.equals("yi")) {
                return "ji";
            }
        }
        return lowerCase;
    }

    private static String concatenateRange(String[] strArr, int i, int i2) {
        StringBuilder sb = new StringBuilder(32);
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return sb.toString();
            }
            if (i4 != i) {
                sb.append('-');
            }
            sb.append(strArr[i4]);
            i3 = i4 + 1;
        }
    }

    private static String convertGrandfatheredTag(String str) {
        String str2 = GRANDFATHERED_LOCALES.get(str);
        return str2 != null ? str2 : str;
    }

    private static int extractExtensions(String[] strArr, int i, int i2, Map<Character, String> map) {
        int i3;
        int i4;
        int i5 = -1;
        int i6 = -1;
        while (true) {
            if (i < i2) {
                String str = strArr[i];
                boolean z = i5 != -1 && i6 == i5;
                if (str.length() != 1 || z) {
                    i3 = i;
                    if (i6 == -1) {
                        break;
                    }
                    int i7 = z ? 1 : 2;
                    i4 = i5;
                    if (!isValidBcp47Alphanum(str, i7, 8)) {
                        return i;
                    }
                    i++;
                    i5 = i4;
                } else {
                    if (i6 != -1) {
                        if (i - 1 == i6) {
                            i3 = i6;
                            break;
                        }
                        String str2 = strArr[i6];
                        if (map.containsKey(Character.valueOf(str2.charAt(0)))) {
                            return i6;
                        }
                        map.put(Character.valueOf(str2.charAt(0)), concatenateRange(strArr, i6 + 1, i).toLowerCase(ROOT));
                    }
                    i6 = i;
                    if ("x".equals(str)) {
                        i4 = i;
                    } else {
                        i4 = i5;
                        if (i5 != -1) {
                            return i5;
                        }
                    }
                    i++;
                    i5 = i4;
                }
            } else {
                i3 = i;
                if (i6 != -1) {
                    if (i - 1 == i6) {
                        return i6;
                    }
                    String str3 = strArr[i6];
                    if (map.containsKey(Character.valueOf(str3.charAt(0)))) {
                        return i6;
                    }
                    map.put(Character.valueOf(str3.charAt(0)), concatenateRange(strArr, i6 + 1, i).toLowerCase(ROOT));
                    return i;
                }
            }
        }
        return i3;
    }

    private static void extractVariantSubtags(String[] strArr, int i, int i2, List<String> list) {
        while (i < i2) {
            String str = strArr[i];
            if (!Builder.isValidVariantSubtag(str)) {
                return;
            }
            list.add(str);
            i++;
        }
    }

    public static Locale forLanguageTag(String str) {
        if (str == null) {
            throw new NullPointerException("languageTag == null");
        }
        return forLanguageTag(str, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0035, code lost:
        if (r12 == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x005d, code lost:
        throw new java.util.IllformedLocaleException("Invalid subtag at index: " + r13 + " in tag: " + r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x005e, code lost:
        r15 = r13 - 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Locale forLanguageTag(java.lang.String r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 522
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.Locale.forLanguageTag(java.lang.String, boolean):java.util.Locale");
    }

    public static Locale[] getAvailableLocales() {
        return ICU.getAvailableLocales();
    }

    public static Locale getDefault() {
        return defaultLocale;
    }

    public static String[] getISOCountries() {
        return ICU.getISOCountries();
    }

    public static String[] getISOLanguages() {
        return ICU.getISOLanguages();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isAsciiAlphaNum(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                return true;
            }
            char charAt = str.charAt(i2);
            if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && (charAt < '0' || charAt > '9'))) {
                return false;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isUnM49AreaCode(String str) {
        if (str.length() != 3) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3) {
                return true;
            }
            char charAt = str.charAt(i2);
            if (charAt < '0' || charAt > '9') {
                return false;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isValidBcp47Alpha(String str, int i, int i2) {
        int length = str.length();
        if (length < i || length > i2) {
            return false;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                return true;
            }
            char charAt = str.charAt(i4);
            if ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')) {
                return false;
            }
            i3 = i4 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isValidBcp47Alphanum(String str, int i, int i2) {
        if (str.length() < i || str.length() > i2) {
            return false;
        }
        return isAsciiAlphaNum(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isValidTypeList(String str) {
        String[] split = str.split("-");
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (!isValidBcp47Alphanum(split[i2], 3, 8)) {
                return false;
            }
            i = i2 + 1;
        }
    }

    private static String joinBcp47Subtags(List<String> list) {
        int size = list.size();
        StringBuilder sb = new StringBuilder(list.get(0).length());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return sb.toString();
            }
            sb.append(list.get(i2));
            if (i2 != size - 1) {
                sb.append('-');
            }
            i = i2 + 1;
        }
    }

    private String makeLanguageTag() {
        String normalizeAndValidateLanguage;
        String normalizeAndValidateRegion;
        String str;
        String str2 = "";
        if (this.hasValidatedFields) {
            normalizeAndValidateLanguage = this.languageCode;
            normalizeAndValidateRegion = this.countryCode;
            str = this.variantCode.replace('_', '-');
        } else {
            normalizeAndValidateLanguage = Builder.normalizeAndValidateLanguage(this.languageCode, false);
            normalizeAndValidateRegion = Builder.normalizeAndValidateRegion(this.countryCode, false);
            try {
                str = Builder.normalizeAndValidateVariant(this.variantCode);
            } catch (IllformedLocaleException e) {
                String[] splitIllformedVariant = splitIllformedVariant(this.variantCode);
                str = splitIllformedVariant[0];
                str2 = splitIllformedVariant[1];
            }
        }
        String str3 = normalizeAndValidateLanguage;
        if (normalizeAndValidateLanguage.isEmpty()) {
            str3 = "und";
        }
        String str4 = str3;
        String str5 = normalizeAndValidateRegion;
        String str6 = str;
        if ("no".equals(str3)) {
            str4 = str3;
            str5 = normalizeAndValidateRegion;
            str6 = str;
            if ("NO".equals(normalizeAndValidateRegion)) {
                str4 = str3;
                str5 = normalizeAndValidateRegion;
                str6 = str;
                if ("NY".equals(str)) {
                    str4 = "nn";
                    str5 = "NO";
                    str6 = "";
                }
            }
        }
        StringBuilder sb = new StringBuilder(16);
        sb.append(str4);
        if (!this.scriptCode.isEmpty()) {
            sb.append('-');
            sb.append(this.scriptCode);
        }
        if (!str5.isEmpty()) {
            sb.append('-');
            sb.append(str5);
        }
        if (!str6.isEmpty()) {
            sb.append('-');
            sb.append(str6);
        }
        for (Map.Entry<Character, String> entry : this.extensions.entrySet()) {
            if (!entry.getKey().equals('x')) {
                sb.append('-').append(entry.getKey());
                sb.append('-').append(entry.getValue());
            }
        }
        String str7 = this.extensions.get('x');
        if (str7 != null) {
            sb.append("-x-");
            sb.append(str7);
        }
        if (!str2.isEmpty()) {
            if (str7 == null) {
                sb.append("-x-lvariant-");
            } else {
                sb.append('-');
            }
            sb.append(str2);
        }
        return sb.toString();
    }

    public static void parseSerializedExtensions(String str, Map<Character, String> map) {
        String[] split = str.split("-");
        int[] iArr = new int[split.length / 2];
        int i = 0;
        int length = split.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            String str2 = split[i2];
            int i4 = i;
            if (str2.length() > 0) {
                i4 = i + str2.length() + 1;
            }
            if (str2.length() == 1) {
                iArr[i3] = i4;
                i3++;
            }
            i2++;
            i = i4;
        }
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= i3) {
                return;
            }
            map.put(Character.valueOf(str.charAt(iArr[i6] - 2)), str.substring(iArr[i6], i6 == i3 - 1 ? str.length() : iArr[i6 + 1] - 3));
            i5 = i6 + 1;
        }
    }

    public static void parseUnicodeExtension(String[] strArr, Map<String, String> map, Set<String> set) {
        String str;
        String str2 = null;
        ArrayList arrayList = new ArrayList();
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str3 = strArr[i];
            if (str3.length() == 2) {
                if (arrayList.size() > 0) {
                    map.put(str2, joinBcp47Subtags(arrayList));
                    arrayList.clear();
                }
                str = str3;
            } else {
                str = str2;
                if (str3.length() > 2) {
                    if (str2 == null) {
                        set.add(str3);
                        str = str2;
                    } else {
                        arrayList.add(str3);
                        str = str2;
                    }
                }
            }
            i++;
            str2 = str;
        }
        if (arrayList.size() > 0) {
            map.put(str2, joinBcp47Subtags(arrayList));
        } else if (str2 != null) {
            map.put(str2, "");
        }
    }

    private void readExtensions(String str) {
        TreeMap treeMap = new TreeMap();
        parseSerializedExtensions(str, treeMap);
        this.extensions = Collections.unmodifiableMap(treeMap);
        if (treeMap.containsKey('u')) {
            String[] split = ((String) treeMap.get('u')).split("-");
            TreeMap treeMap2 = new TreeMap();
            TreeSet treeSet = new TreeSet();
            parseUnicodeExtension(split, treeMap2, treeSet);
            this.unicodeKeywords = Collections.unmodifiableMap(treeMap2);
            this.unicodeAttributes = Collections.unmodifiableSet(treeSet);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField readFields = objectInputStream.readFields();
        this.countryCode = (String) readFields.get("country", "");
        this.languageCode = (String) readFields.get("language", "");
        this.variantCode = (String) readFields.get(TextToSpeech.Engine.KEY_PARAM_VARIANT, "");
        this.scriptCode = (String) readFields.get("script", "");
        this.unicodeKeywords = Collections.EMPTY_MAP;
        this.unicodeAttributes = Collections.EMPTY_SET;
        this.extensions = Collections.EMPTY_MAP;
        String str = (String) readFields.get(Contacts.People.Extensions.CONTENT_DIRECTORY, (Object) null);
        if (str != null) {
            readExtensions(str);
        }
    }

    public static String serializeExtensions(Map<Character, String> map) {
        Iterator<Map.Entry<Character, String>> it = map.entrySet().iterator();
        StringBuilder sb = new StringBuilder(64);
        while (true) {
            Map.Entry<Character, String> next = it.next();
            sb.append(next.getKey());
            sb.append('-');
            sb.append(next.getValue());
            if (!it.hasNext()) {
                return sb.toString();
            }
            sb.append('-');
        }
    }

    public static void setDefault(Locale locale) {
        synchronized (Locale.class) {
            try {
                if (locale == null) {
                    throw new NullPointerException("locale == null");
                }
                String languageTag = locale.toLanguageTag();
                defaultLocale = locale;
                ICU.setDefaultLocale(languageTag);
            } finally {
            }
        }
    }

    private static String[] splitIllformedVariant(String str) {
        int i;
        String[] split = str.replace('_', '-').split("-");
        String[] strArr = {"", ""};
        int length = split.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            i = length;
            if (i3 >= split.length) {
                break;
            } else if (!isValidBcp47Alphanum(split[i3], 1, 8)) {
                i = i3;
                break;
            } else {
                i2 = i3 + 1;
            }
        }
        if (i == 0) {
            return strArr;
        }
        int i4 = i;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= i) {
                strArr[0] = concatenateRange(split, 0, i4);
                strArr[1] = concatenateRange(split, i4, i);
                return strArr;
            }
            String str2 = split[i6];
            if (str2.length() < 5 || str2.length() > 8) {
                if (str2.length() == 4) {
                    char charAt = str2.charAt(0);
                    if (charAt < '0' || charAt > '9' || !isAsciiAlphaNum(str2)) {
                        i4 = i6;
                    }
                } else {
                    i4 = i6;
                }
            } else if (!isAsciiAlphaNum(str2)) {
                i4 = i6;
            }
            i5 = i6 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String titleCaseAsciiWord(String str) {
        try {
            byte[] bytes = str.toLowerCase(ROOT).getBytes(StandardCharsets.US_ASCII);
            bytes[0] = (byte) ((bytes[0] + 65) - 97);
            return new String(bytes, StandardCharsets.US_ASCII);
        } catch (UnsupportedOperationException e) {
            throw new AssertionError(e);
        }
    }

    private static String toNewString(String str, String str2, String str3, String str4, Map<Character, String> map) {
        if (str.length() == 0 && str2.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(11);
        sb.append(str);
        boolean z = (str4.isEmpty() && map.isEmpty()) ? false : true;
        if (!str2.isEmpty() || !str3.isEmpty() || z) {
            sb.append('_');
        }
        sb.append(str2);
        if (!str3.isEmpty() || z) {
            sb.append('_');
        }
        sb.append(str3);
        if (z) {
            if (!str3.isEmpty()) {
                sb.append('_');
            }
            sb.append("#");
            if (!str4.isEmpty()) {
                sb.append(str4);
            }
            if (!map.isEmpty()) {
                if (!str4.isEmpty()) {
                    sb.append('-');
                }
                sb.append(serializeExtensions(map));
            }
        }
        return sb.toString();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
        putFields.put("country", this.countryCode);
        putFields.put(SuggestionSpan.SUGGESTION_SPAN_PICKED_HASHCODE, -1);
        putFields.put("language", this.languageCode);
        putFields.put(TextToSpeech.Engine.KEY_PARAM_VARIANT, this.variantCode);
        putFields.put("script", this.scriptCode);
        if (!this.extensions.isEmpty()) {
            putFields.put(Contacts.People.Extensions.CONTENT_DIRECTORY, serializeExtensions(this.extensions));
        }
        objectOutputStream.writeFields();
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Locale) {
            Locale locale = (Locale) obj;
            return this.languageCode.equals(locale.languageCode) && this.countryCode.equals(locale.countryCode) && this.variantCode.equals(locale.variantCode) && this.scriptCode.equals(locale.scriptCode) && this.extensions.equals(locale.extensions);
        }
        return false;
    }

    public String getCountry() {
        return this.countryCode;
    }

    public final String getDisplayCountry() {
        return getDisplayCountry(getDefault());
    }

    public String getDisplayCountry(Locale locale) {
        String str;
        if (this.countryCode.isEmpty()) {
            str = "";
        } else if (Builder.normalizeAndValidateRegion(this.countryCode, false).isEmpty()) {
            return this.countryCode;
        } else {
            String displayCountry = ICU.getDisplayCountry(this, locale);
            str = displayCountry;
            if (displayCountry == null) {
                return ICU.getDisplayCountry(this, getDefault());
            }
        }
        return str;
    }

    public final String getDisplayLanguage() {
        return getDisplayLanguage(getDefault());
    }

    public String getDisplayLanguage(Locale locale) {
        String str;
        if (this.languageCode.isEmpty()) {
            str = "";
        } else if ("und".equals(Builder.normalizeAndValidateLanguage(this.languageCode, false))) {
            return this.languageCode;
        } else {
            String displayLanguage = ICU.getDisplayLanguage(this, locale);
            str = displayLanguage;
            if (displayLanguage == null) {
                return ICU.getDisplayLanguage(this, getDefault());
            }
        }
        return str;
    }

    public final String getDisplayName() {
        return getDisplayName(getDefault());
    }

    public String getDisplayName(Locale locale) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        if (!this.languageCode.isEmpty()) {
            String displayLanguage = getDisplayLanguage(locale);
            String str = displayLanguage;
            if (displayLanguage.isEmpty()) {
                str = this.languageCode;
            }
            sb.append(str);
            i = 0 + 1;
        }
        int i2 = i;
        if (!this.scriptCode.isEmpty()) {
            if (i == 1) {
                sb.append(" (");
            }
            String displayScript = getDisplayScript(locale);
            String str2 = displayScript;
            if (displayScript.isEmpty()) {
                str2 = this.scriptCode;
            }
            sb.append(str2);
            i2 = i + 1;
        }
        int i3 = i2;
        if (!this.countryCode.isEmpty()) {
            if (i2 == 1) {
                sb.append(" (");
            } else if (i2 == 2) {
                sb.append(",");
            }
            String displayCountry = getDisplayCountry(locale);
            String str3 = displayCountry;
            if (displayCountry.isEmpty()) {
                str3 = this.countryCode;
            }
            sb.append(str3);
            i3 = i2 + 1;
        }
        int i4 = i3;
        if (!this.variantCode.isEmpty()) {
            if (i3 == 1) {
                sb.append(" (");
            } else if (i3 == 2 || i3 == 3) {
                sb.append(",");
            }
            String displayVariant = getDisplayVariant(locale);
            String str4 = displayVariant;
            if (displayVariant.isEmpty()) {
                str4 = this.variantCode;
            }
            sb.append(str4);
            i4 = i3 + 1;
        }
        if (i4 > 1) {
            sb.append(")");
        }
        return sb.toString();
    }

    public String getDisplayScript() {
        return getDisplayScript(getDefault());
    }

    public String getDisplayScript(Locale locale) {
        String str;
        if (this.scriptCode.isEmpty()) {
            str = "";
        } else {
            String displayScript = ICU.getDisplayScript(this, locale);
            str = displayScript;
            if (displayScript == null) {
                return ICU.getDisplayScript(this, getDefault());
            }
        }
        return str;
    }

    public final String getDisplayVariant() {
        return getDisplayVariant(getDefault());
    }

    public String getDisplayVariant(Locale locale) {
        String str;
        if (this.variantCode.isEmpty()) {
            str = "";
        } else {
            try {
                Builder.normalizeAndValidateVariant(this.variantCode);
                String displayVariant = ICU.getDisplayVariant(this, locale);
                String str2 = displayVariant;
                if (displayVariant == null) {
                    str2 = ICU.getDisplayVariant(this, getDefault());
                }
                str = str2;
                if (str2.isEmpty()) {
                    return this.variantCode;
                }
            } catch (IllformedLocaleException e) {
                return this.variantCode;
            }
        }
        return str;
    }

    public String getExtension(char c2) {
        return this.extensions.get(Character.valueOf(c2));
    }

    public Set<Character> getExtensionKeys() {
        return this.extensions.keySet();
    }

    public String getISO3Country() {
        String iSO3Country = ICU.getISO3Country("en-" + this.countryCode);
        if (this.countryCode.isEmpty() || !iSO3Country.isEmpty()) {
            return iSO3Country;
        }
        throw new MissingResourceException("No 3-letter country code for locale: " + this, "FormatData_" + this, "ShortCountry");
    }

    public String getISO3Language() {
        String str;
        if (this.languageCode.isEmpty()) {
            str = "";
        } else {
            String iSO3Language = ICU.getISO3Language(this.languageCode);
            str = iSO3Language;
            if (!this.languageCode.isEmpty()) {
                str = iSO3Language;
                if (iSO3Language.isEmpty()) {
                    throw new MissingResourceException("No 3-letter language code for locale: " + this, "FormatData_" + this, "ShortLanguage");
                }
            }
        }
        return str;
    }

    public String getLanguage() {
        return this.languageCode;
    }

    public String getScript() {
        return this.scriptCode;
    }

    public Set<String> getUnicodeLocaleAttributes() {
        return this.unicodeAttributes;
    }

    public Set<String> getUnicodeLocaleKeys() {
        return this.unicodeKeywords.keySet();
    }

    public String getUnicodeLocaleType(String str) {
        return this.unicodeKeywords.get(str);
    }

    public String getVariant() {
        return this.variantCode;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        synchronized (this) {
            hashCode = this.countryCode.hashCode();
            hashCode2 = this.languageCode.hashCode();
            hashCode3 = this.variantCode.hashCode();
            hashCode4 = this.scriptCode.hashCode();
            hashCode5 = this.extensions.hashCode();
        }
        return hashCode + hashCode2 + hashCode3 + hashCode4 + hashCode5;
    }

    public String toLanguageTag() {
        if (this.cachedLanguageTag == null) {
            this.cachedLanguageTag = makeLanguageTag();
        }
        return this.cachedLanguageTag;
    }

    public final String toString() {
        String str = this.cachedToStringResult;
        String str2 = str;
        if (str == null) {
            str2 = toNewString(this.languageCode, this.countryCode, this.variantCode, this.scriptCode, this.extensions);
            this.cachedToStringResult = str2;
        }
        return str2;
    }
}
