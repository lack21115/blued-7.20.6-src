package libcore.icu;

import java.text.DateFormat;
import java.util.HashMap;
import java.util.Locale;
import libcore.util.Objects;

/* loaded from: source-2895416-dex2jar.jar:libcore/icu/LocaleData.class */
public final class LocaleData {
    private static final HashMap<String, LocaleData> localeDataCache = new HashMap<>();
    public String NaN;
    public String[] amPm;
    public String currencyPattern;
    public String currencySymbol;
    public char decimalSeparator;
    public String[] eras;
    public String exponentSeparator;
    public Integer firstDayOfWeek;
    public String fullDateFormat;
    public String fullTimeFormat;
    public char groupingSeparator;
    public String infinity;
    public String integerPattern;
    public String internationalCurrencySymbol;
    public String longDateFormat;
    public String[] longMonthNames;
    public String[] longStandAloneMonthNames;
    public String[] longStandAloneWeekdayNames;
    public String longTimeFormat;
    public String[] longWeekdayNames;
    public String mediumDateFormat;
    public String mediumTimeFormat;
    public Integer minimalDaysInFirstWeek;
    public String minusSign;
    public char monetarySeparator;
    public String narrowAm;
    public String narrowPm;
    public String numberPattern;
    public char patternSeparator;
    public char perMill;
    public String percent;
    public String percentPattern;
    public String shortDateFormat;
    public String shortDateFormat4;
    public String[] shortMonthNames;
    public String[] shortStandAloneMonthNames;
    public String[] shortStandAloneWeekdayNames;
    public String shortTimeFormat;
    public String[] shortWeekdayNames;
    public String timeFormat12;
    public String timeFormat24;
    public String timeFormat_Hm;
    public String timeFormat_Hms;
    public String timeFormat_hm;
    public String timeFormat_hms;
    public String[] tinyMonthNames;
    public String[] tinyStandAloneMonthNames;
    public String[] tinyStandAloneWeekdayNames;
    public String[] tinyWeekdayNames;
    public String today;
    public String tomorrow;
    public String yesterday;
    public char zeroDigit;

    static {
        get(Locale.ROOT);
        get(Locale.US);
        get(Locale.getDefault());
    }

    private LocaleData() {
    }

    public static LocaleData get(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("locale == null");
        }
        String languageTag = locale.toLanguageTag();
        synchronized (localeDataCache) {
            LocaleData localeData = localeDataCache.get(languageTag);
            if (localeData != null) {
                return localeData;
            }
            LocaleData initLocaleData = initLocaleData(locale);
            synchronized (localeDataCache) {
                LocaleData localeData2 = localeDataCache.get(languageTag);
                if (localeData2 != null) {
                    return localeData2;
                }
                localeDataCache.put(languageTag, initLocaleData);
                return initLocaleData;
            }
        }
    }

    private static LocaleData initLocaleData(Locale locale) {
        LocaleData localeData = new LocaleData();
        if (ICU.initLocaleDataNative(locale.toLanguageTag(), localeData)) {
            localeData.timeFormat_hm = ICU.getBestDateTimePattern("hm", locale);
            localeData.timeFormat_Hm = ICU.getBestDateTimePattern("Hm", locale);
            localeData.timeFormat_hms = ICU.getBestDateTimePattern("hms", locale);
            localeData.timeFormat_Hms = ICU.getBestDateTimePattern("Hms", locale);
            localeData.timeFormat12 = localeData.timeFormat_hm;
            localeData.timeFormat24 = localeData.timeFormat_Hm;
            if (localeData.fullTimeFormat != null) {
                localeData.fullTimeFormat = localeData.fullTimeFormat.replace('v', 'z');
            }
            if (localeData.numberPattern != null) {
                localeData.integerPattern = localeData.numberPattern.replaceAll("\\.[#,]*", "");
            }
            localeData.shortDateFormat4 = localeData.shortDateFormat.replaceAll("\\byy\\b", "y");
            return localeData;
        }
        throw new AssertionError("couldn't initialize LocaleData for locale " + locale);
    }

    public static Locale mapInvalidAndNullLocales(Locale locale) {
        Locale locale2;
        if (locale == null) {
            locale2 = Locale.getDefault();
        } else {
            locale2 = locale;
            if ("und".equals(locale.toLanguageTag())) {
                return Locale.ROOT;
            }
        }
        return locale2;
    }

    public String getDateFormat(int i) {
        switch (i) {
            case 0:
                return this.fullDateFormat;
            case 1:
                return this.longDateFormat;
            case 2:
                return this.mediumDateFormat;
            case 3:
                return this.shortDateFormat;
            default:
                throw new AssertionError();
        }
    }

    public String getTimeFormat(int i) {
        switch (i) {
            case 0:
                return this.fullTimeFormat;
            case 1:
                return this.longTimeFormat;
            case 2:
                return DateFormat.is24Hour == null ? this.mediumTimeFormat : DateFormat.is24Hour.booleanValue() ? this.timeFormat_Hms : this.timeFormat_hms;
            case 3:
                return DateFormat.is24Hour == null ? this.shortTimeFormat : DateFormat.is24Hour.booleanValue() ? this.timeFormat_Hm : this.timeFormat_hm;
            default:
                throw new AssertionError();
        }
    }

    public String toString() {
        return Objects.toString(this);
    }
}
