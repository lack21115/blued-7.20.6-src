package libcore.icu;

import com.alipay.sdk.util.i;
import com.android.internal.content.NativeLibraryHelper;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Locale;
import libcore.util.BasicLruCache;

/* loaded from: source-2895416-dex2jar.jar:libcore/icu/ICU.class */
public final class ICU {
    private static final BasicLruCache<String, String> CACHED_PATTERNS = new BasicLruCache<>(8);
    private static final int IDX_LANGUAGE = 0;
    private static final int IDX_REGION = 2;
    private static final int IDX_SCRIPT = 1;
    private static final int IDX_VARIANT = 3;
    public static final int U_BUFFER_OVERFLOW_ERROR = 15;
    public static final int U_ILLEGAL_CHAR_FOUND = 12;
    public static final int U_INVALID_CHAR_FOUND = 10;
    public static final int U_TRUNCATED_CHAR_FOUND = 11;
    public static final int U_ZERO_ERROR = 0;
    private static Locale[] availableLocalesCache;
    private static String[] isoCountries;
    private static String[] isoLanguages;

    public static boolean U_FAILURE(int i) {
        return i > 0;
    }

    @Deprecated
    public static native String addLikelySubtags(String str);

    public static Locale addLikelySubtags(Locale locale) {
        return Locale.forLanguageTag(addLikelySubtags(locale.toLanguageTag()).replace('_', '-'));
    }

    public static Locale[] getAvailableBreakIteratorLocales() {
        return localesFromStrings(getAvailableBreakIteratorLocalesNative());
    }

    private static native String[] getAvailableBreakIteratorLocalesNative();

    public static Locale[] getAvailableCalendarLocales() {
        return localesFromStrings(getAvailableCalendarLocalesNative());
    }

    private static native String[] getAvailableCalendarLocalesNative();

    public static Locale[] getAvailableCollatorLocales() {
        return localesFromStrings(getAvailableCollatorLocalesNative());
    }

    private static native String[] getAvailableCollatorLocalesNative();

    public static native String[] getAvailableCurrencyCodes();

    public static Locale[] getAvailableDateFormatLocales() {
        return localesFromStrings(getAvailableDateFormatLocalesNative());
    }

    private static native String[] getAvailableDateFormatLocalesNative();

    public static Locale[] getAvailableDateFormatSymbolsLocales() {
        return getAvailableDateFormatLocales();
    }

    public static Locale[] getAvailableDecimalFormatSymbolsLocales() {
        return getAvailableNumberFormatLocales();
    }

    public static Locale[] getAvailableLocales() {
        if (availableLocalesCache == null) {
            availableLocalesCache = localesFromStrings(getAvailableLocalesNative());
        }
        return (Locale[]) availableLocalesCache.clone();
    }

    private static native String[] getAvailableLocalesNative();

    public static Locale[] getAvailableNumberFormatLocales() {
        return localesFromStrings(getAvailableNumberFormatLocalesNative());
    }

    private static native String[] getAvailableNumberFormatLocalesNative();

    public static String getBestDateTimePattern(String str, Locale locale) {
        String str2;
        String languageTag = locale.toLanguageTag();
        String str3 = str + "\t" + languageTag;
        synchronized (CACHED_PATTERNS) {
            String str4 = CACHED_PATTERNS.get(str3);
            str2 = str4;
            if (str4 == null) {
                str2 = getBestDateTimePatternNative(str, languageTag);
                CACHED_PATTERNS.put(str3, str2);
            }
        }
        return str2;
    }

    private static native String getBestDateTimePatternNative(String str, String str2);

    public static native String getCldrVersion();

    public static native String getCurrencyCode(String str);

    private static native String getCurrencyDisplayName(String str, String str2);

    public static String getCurrencyDisplayName(Locale locale, String str) {
        return getCurrencyDisplayName(locale.toLanguageTag(), str);
    }

    public static native int getCurrencyFractionDigits(String str);

    public static native int getCurrencyNumericCode(String str);

    private static native String getCurrencySymbol(String str, String str2);

    public static String getCurrencySymbol(Locale locale, String str) {
        return getCurrencySymbol(locale.toLanguageTag(), str);
    }

    public static char[] getDateFormatOrder(String str) {
        boolean z;
        int i;
        int i2;
        boolean z2;
        boolean z3;
        char[] cArr = new char[3];
        int i3 = 0;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int i4 = 0;
        while (i4 < str.length()) {
            char charAt = str.charAt(i4);
            if (charAt != 'd' && charAt != 'L' && charAt != 'M' && charAt != 'y') {
                i2 = i4;
                i = i3;
                z2 = z4;
                z = z5;
                z3 = z6;
                if (charAt == 'G') {
                    continue;
                } else if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                    throw new IllegalArgumentException("Bad pattern character '" + charAt + "' in " + str);
                } else {
                    i2 = i4;
                    i = i3;
                    z2 = z4;
                    z = z5;
                    z3 = z6;
                    if (charAt != '\'') {
                        continue;
                    } else if (i4 >= str.length() - 1 || str.charAt(i4 + 1) != '\'') {
                        int indexOf = str.indexOf(39, i4 + 1);
                        if (indexOf == -1) {
                            throw new IllegalArgumentException("Bad quoting in " + str);
                        }
                        i2 = indexOf + 1;
                        i = i3;
                        z2 = z4;
                        z = z5;
                        z3 = z6;
                    } else {
                        i2 = i4 + 1;
                        i = i3;
                        z2 = z4;
                        z = z5;
                        z3 = z6;
                    }
                }
            } else if (charAt == 'd' && !z4) {
                cArr[i3] = 'd';
                z2 = true;
                i = i3 + 1;
                z3 = z6;
                z = z5;
                i2 = i4;
            } else if ((charAt == 'L' || charAt == 'M') && !z5) {
                cArr[i3] = 'M';
                z = true;
                i = i3 + 1;
                i2 = i4;
                z2 = z4;
                z3 = z6;
            } else {
                i2 = i4;
                i = i3;
                z2 = z4;
                z = z5;
                z3 = z6;
                if (charAt == 'y') {
                    i2 = i4;
                    i = i3;
                    z2 = z4;
                    z = z5;
                    z3 = z6;
                    if (!z6) {
                        cArr[i3] = 'y';
                        z3 = true;
                        i = i3 + 1;
                        i2 = i4;
                        z2 = z4;
                        z = z5;
                    }
                }
            }
            i4 = i2 + 1;
            i3 = i;
            z4 = z2;
            z5 = z;
            z6 = z3;
        }
        return cArr;
    }

    public static native String getDefaultLocale();

    public static String getDisplayCountry(Locale locale, Locale locale2) {
        return getDisplayCountryNative(locale.toLanguageTag(), locale2.toLanguageTag());
    }

    private static native String getDisplayCountryNative(String str, String str2);

    public static String getDisplayLanguage(Locale locale, Locale locale2) {
        return getDisplayLanguageNative(locale.toLanguageTag(), locale2.toLanguageTag());
    }

    private static native String getDisplayLanguageNative(String str, String str2);

    public static String getDisplayScript(Locale locale, Locale locale2) {
        return getDisplayScriptNative(locale.toLanguageTag(), locale2.toLanguageTag());
    }

    private static native String getDisplayScriptNative(String str, String str2);

    public static String getDisplayVariant(Locale locale, Locale locale2) {
        return getDisplayVariantNative(locale.toLanguageTag(), locale2.toLanguageTag());
    }

    private static native String getDisplayVariantNative(String str, String str2);

    public static native String getISO3Country(String str);

    public static native String getISO3Language(String str);

    public static String[] getISOCountries() {
        if (isoCountries == null) {
            isoCountries = getISOCountriesNative();
        }
        return (String[]) isoCountries.clone();
    }

    private static native String[] getISOCountriesNative();

    public static String[] getISOLanguages() {
        if (isoLanguages == null) {
            isoLanguages = getISOLanguagesNative();
        }
        return (String[]) isoLanguages.clone();
    }

    private static native String[] getISOLanguagesNative();

    public static native String getIcuVersion();

    @Deprecated
    public static native String getScript(String str);

    public static native String getUnicodeVersion();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean initLocaleDataNative(String str, LocaleData localeData);

    public static Locale localeFromIcuLocaleId(String str) {
        int indexOf = str.indexOf(64);
        HashMap hashMap = Collections.EMPTY_MAP;
        HashMap hashMap2 = Collections.EMPTY_MAP;
        HashSet hashSet = Collections.EMPTY_SET;
        if (indexOf != -1) {
            HashMap hashMap3 = new HashMap();
            HashMap hashMap4 = new HashMap();
            HashSet hashSet2 = new HashSet();
            String[] split = str.substring(indexOf + 1).split(i.b);
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                hashSet = hashSet2;
                hashMap2 = hashMap4;
                hashMap = hashMap3;
                if (i2 >= length) {
                    break;
                }
                String str2 = split[i2];
                if (str2.startsWith("attribute=")) {
                    String[] split2 = str2.substring("attribute=".length()).split(NativeLibraryHelper.CLEAR_ABI_OVERRIDE);
                    int length2 = split2.length;
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 < length2) {
                            hashSet2.add(split2[i4]);
                            i3 = i4 + 1;
                        }
                    }
                } else {
                    int indexOf2 = str2.indexOf(61);
                    if (indexOf2 == 1) {
                        hashMap3.put(Character.valueOf(str2.charAt(0)), str2.substring(2));
                    } else {
                        hashMap4.put(str2.substring(0, indexOf2), str2.substring(indexOf2 + 1));
                    }
                }
                i = i2 + 1;
            }
        }
        String[] strArr = {"", "", "", ""};
        if (indexOf == -1) {
            parseLangScriptRegionAndVariants(str, strArr);
        } else {
            parseLangScriptRegionAndVariants(str.substring(0, indexOf), strArr);
        }
        return new Locale(strArr[0], strArr[2], strArr[3], strArr[1], hashSet, hashMap2, hashMap, true);
    }

    public static Locale[] localesFromStrings(String[] strArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return (Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]);
            }
            linkedHashSet.add(localeFromIcuLocaleId(strArr[i2]));
            i = i2 + 1;
        }
    }

    private static void parseLangScriptRegionAndVariants(String str, String[] strArr) {
        int indexOf = str.indexOf(95);
        int indexOf2 = str.indexOf(95, indexOf + 1);
        int indexOf3 = str.indexOf(95, indexOf2 + 1);
        if (indexOf == -1) {
            strArr[0] = str;
        } else if (indexOf2 == -1) {
            strArr[0] = str.substring(0, indexOf);
            String substring = str.substring(indexOf + 1);
            if (substring.length() == 4) {
                strArr[1] = substring;
            } else if (substring.length() == 2 || substring.length() == 3) {
                strArr[2] = substring;
            } else {
                strArr[3] = substring;
            }
        } else if (indexOf3 != -1) {
            strArr[0] = str.substring(0, indexOf);
            String substring2 = str.substring(indexOf + 1, indexOf2);
            if (substring2.length() != 4) {
                strArr[2] = substring2;
                strArr[3] = str.substring(indexOf2 + 1);
                return;
            }
            strArr[1] = substring2;
            strArr[2] = str.substring(indexOf2 + 1, indexOf3);
            strArr[3] = str.substring(indexOf3 + 1);
        } else {
            strArr[0] = str.substring(0, indexOf);
            String substring3 = str.substring(indexOf + 1, indexOf2);
            String substring4 = str.substring(indexOf2 + 1);
            if (substring3.length() == 4) {
                strArr[1] = substring3;
                if (substring4.length() == 2 || substring4.length() == 3 || substring4.isEmpty()) {
                    strArr[2] = substring4;
                } else {
                    strArr[3] = substring4;
                }
            } else if (!substring3.isEmpty() && substring3.length() != 2 && substring3.length() != 3) {
                strArr[3] = str.substring(indexOf + 1);
            } else {
                strArr[2] = substring3;
                strArr[3] = substring4;
            }
        }
    }

    public static native void setDefaultLocale(String str);

    private static native String toLowerCase(String str, String str2);

    public static String toLowerCase(String str, Locale locale) {
        return toLowerCase(str, locale.toLanguageTag());
    }

    private static native String toUpperCase(String str, String str2);

    public static String toUpperCase(String str, Locale locale) {
        return toUpperCase(str, locale.toLanguageTag());
    }
}
