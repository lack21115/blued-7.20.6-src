package android.text.format;

import android.content.Context;
import android.mokee.utils.MoKeeUtils;
import android.os.UserHandle;
import android.provider.Settings;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import com.google.android.material.timepicker.TimeModel;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import libcore.icu.ICU;
import libcore.icu.LocaleData;

/* loaded from: source-9557208-dex2jar.jar:android/text/format/DateFormat.class */
public class DateFormat {
    @Deprecated
    public static final char AM_PM = 'a';
    @Deprecated
    public static final char CAPITAL_AM_PM = 'A';
    @Deprecated
    public static final char DATE = 'd';
    @Deprecated
    public static final char DAY = 'E';
    @Deprecated
    public static final char HOUR = 'h';
    @Deprecated
    public static final char HOUR_OF_DAY = 'k';
    @Deprecated
    public static final char MINUTE = 'm';
    @Deprecated
    public static final char MONTH = 'M';
    @Deprecated
    public static final char QUOTE = '\'';
    @Deprecated
    public static final char SECONDS = 's';
    @Deprecated
    public static final char STANDALONE_MONTH = 'L';
    @Deprecated
    public static final char TIME_ZONE = 'z';
    @Deprecated
    public static final char YEAR = 'y';
    private static boolean sIs24Hour;
    private static Locale sIs24HourLocale;
    private static final Object sLocaleLock = new Object();

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0074, code lost:
        r5.delete(r7, r7 + 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007e, code lost:
        return r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int appendQuotedText(android.text.SpannableStringBuilder r5, int r6, int r7) {
        /*
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r1 = r7
            if (r0 >= r1) goto L22
            r0 = r5
            r1 = r6
            r2 = 1
            int r1 = r1 + r2
            char r0 = r0.charAt(r1)
            r1 = 39
            if (r0 != r1) goto L22
            r0 = r5
            r1 = r6
            r2 = r6
            r3 = 1
            int r2 = r2 + r3
            android.text.SpannableStringBuilder r0 = r0.delete(r1, r2)
            r0 = 1
            r9 = r0
        L1f:
            r0 = r9
            return r0
        L22:
            r0 = 0
            r9 = r0
            r0 = r5
            r1 = r6
            r2 = r6
            r3 = 1
            int r2 = r2 + r3
            android.text.SpannableStringBuilder r0 = r0.delete(r1, r2)
            r0 = r7
            r1 = 1
            int r0 = r0 - r1
            r8 = r0
            r0 = r6
            r7 = r0
            r0 = r9
            r6 = r0
        L37:
            r0 = r6
            r9 = r0
            r0 = r7
            r1 = r8
            if (r0 >= r1) goto L1f
            r0 = r5
            r1 = r7
            char r0 = r0.charAt(r1)
            r1 = 39
            if (r0 != r1) goto L7f
            r0 = r7
            r1 = 1
            int r0 = r0 + r1
            r1 = r8
            if (r0 >= r1) goto L74
            r0 = r5
            r1 = r7
            r2 = 1
            int r1 = r1 + r2
            char r0 = r0.charAt(r1)
            r1 = 39
            if (r0 != r1) goto L74
            r0 = r5
            r1 = r7
            r2 = r7
            r3 = 1
            int r2 = r2 + r3
            android.text.SpannableStringBuilder r0 = r0.delete(r1, r2)
            r0 = r8
            r1 = 1
            int r0 = r0 - r1
            r8 = r0
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            r0 = r7
            r1 = 1
            int r0 = r0 + r1
            r7 = r0
            goto L37
        L74:
            r0 = r5
            r1 = r7
            r2 = r7
            r3 = 1
            int r2 = r2 + r3
            android.text.SpannableStringBuilder r0 = r0.delete(r1, r2)
            r0 = r6
            return r0
        L7f:
            r0 = r7
            r1 = 1
            int r0 = r0 + r1
            r7 = r0
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L37
        */
        throw new UnsupportedOperationException("Method not decompiled: android.text.format.DateFormat.appendQuotedText(android.text.SpannableStringBuilder, int, int):int");
    }

    public static CharSequence format(CharSequence charSequence, long j) {
        return format(charSequence, new Date(j));
    }

    public static CharSequence format(CharSequence charSequence, Calendar calendar) {
        String timeZoneString;
        int i;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        LocaleData localeData = LocaleData.get(Locale.getDefault());
        int length = charSequence.length();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return charSequence instanceof Spanned ? new SpannedString(spannableStringBuilder) : spannableStringBuilder.toString();
            }
            int i4 = 1;
            char charAt = spannableStringBuilder.charAt(i3);
            if (charAt == '\'') {
                i = appendQuotedText(spannableStringBuilder, i3, length);
                length = spannableStringBuilder.length();
            } else {
                while (i3 + i4 < length && spannableStringBuilder.charAt(i3 + i4) == charAt) {
                    i4++;
                }
                switch (charAt) {
                    case 'A':
                    case 'a':
                        if (!MoKeeUtils.isSupportLanguage(false)) {
                            timeZoneString = localeData.amPm[calendar.get(9) + 0];
                            break;
                        } else {
                            timeZoneString = DateUtils.getAMPMCNString(calendar.get(10), calendar.get(9));
                            break;
                        }
                    case 'E':
                    case 'c':
                        timeZoneString = getDayOfWeekString(localeData, calendar.get(7), i4, charAt);
                        break;
                    case 'H':
                    case 'k':
                        timeZoneString = zeroPad(calendar.get(11), i4);
                        break;
                    case 'K':
                    case 'h':
                        int i5 = calendar.get(10);
                        int i6 = i5;
                        if (charAt == 'h') {
                            i6 = i5;
                            if (i5 == 0) {
                                i6 = 12;
                            }
                        }
                        timeZoneString = zeroPad(i6, i4);
                        break;
                    case 'L':
                    case 'M':
                        timeZoneString = getMonthString(localeData, calendar.get(2), i4, charAt);
                        break;
                    case 'd':
                        timeZoneString = zeroPad(calendar.get(5), i4);
                        break;
                    case 'm':
                        timeZoneString = zeroPad(calendar.get(12), i4);
                        break;
                    case 's':
                        timeZoneString = zeroPad(calendar.get(13), i4);
                        break;
                    case 'y':
                        timeZoneString = getYearString(calendar.get(1), i4);
                        break;
                    case 'z':
                        timeZoneString = getTimeZoneString(calendar, i4);
                        break;
                    default:
                        timeZoneString = null;
                        break;
                }
                i = i4;
                if (timeZoneString != null) {
                    spannableStringBuilder.replace(i3, i3 + i4, (CharSequence) timeZoneString);
                    i = timeZoneString.length();
                    length = spannableStringBuilder.length();
                }
            }
            i2 = i3 + i;
        }
    }

    public static CharSequence format(CharSequence charSequence, Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        return format(charSequence, gregorianCalendar);
    }

    private static String formatZoneOffset(int i, int i2) {
        int i3 = i / 1000;
        StringBuilder sb = new StringBuilder();
        if (i3 < 0) {
            sb.insert(0, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            i3 = -i3;
        } else {
            sb.insert(0, "+");
        }
        sb.append(zeroPad(i3 / 3600, 2));
        sb.append(zeroPad((i3 % 3600) / 60, 2));
        return sb.toString();
    }

    public static String getBestDateTimePattern(Locale locale, String str) {
        return ICU.getBestDateTimePattern(str, locale);
    }

    public static java.text.DateFormat getDateFormat(Context context) {
        return getDateFormatForSetting(context, Settings.System.getString(context.getContentResolver(), Settings.System.DATE_FORMAT));
    }

    public static java.text.DateFormat getDateFormatForSetting(Context context, String str) {
        return new SimpleDateFormat(getDateFormatStringForSetting(context, str));
    }

    public static char[] getDateFormatOrder(Context context) {
        return ICU.getDateFormatOrder(getDateFormatString(context));
    }

    private static String getDateFormatString(Context context) {
        return getDateFormatStringForSetting(context, Settings.System.getString(context.getContentResolver(), Settings.System.DATE_FORMAT));
    }

    private static String getDateFormatStringForSetting(Context context, String str) {
        if (str != null) {
            int indexOf = str.indexOf(77);
            int indexOf2 = str.indexOf(100);
            int indexOf3 = str.indexOf(121);
            if (indexOf >= 0 && indexOf2 >= 0 && indexOf3 >= 0) {
                String string = context.getString(17039657);
                return (indexOf3 >= indexOf || indexOf3 >= indexOf2) ? indexOf < indexOf2 ? indexOf2 < indexOf3 ? String.format(string, "MM", "dd", "yyyy") : String.format(string, "MM", "yyyy", "dd") : indexOf < indexOf3 ? String.format(string, "dd", "MM", "yyyy") : String.format(string, "dd", "yyyy", "MM") : indexOf < indexOf2 ? String.format(string, "yyyy", "MM", "dd") : String.format(string, "yyyy", "dd", "MM");
            }
        }
        return LocaleData.get(context.getResources().getConfiguration().locale).shortDateFormat4;
    }

    private static String getDayOfWeekString(LocaleData localeData, int i, int i2, int i3) {
        boolean z = i3 == 99;
        return i2 == 5 ? z ? localeData.tinyStandAloneWeekdayNames[i] : localeData.tinyWeekdayNames[i] : i2 == 4 ? z ? localeData.longStandAloneWeekdayNames[i] : localeData.longWeekdayNames[i] : z ? localeData.shortStandAloneWeekdayNames[i] : localeData.shortWeekdayNames[i];
    }

    public static java.text.DateFormat getLongDateFormat(Context context) {
        return java.text.DateFormat.getDateInstance(1);
    }

    public static java.text.DateFormat getMediumDateFormat(Context context) {
        return java.text.DateFormat.getDateInstance(2);
    }

    private static String getMonthString(LocaleData localeData, int i, int i2, int i3) {
        boolean z = i3 == 76;
        return i2 == 5 ? z ? localeData.tinyStandAloneMonthNames[i] : localeData.tinyMonthNames[i] : i2 == 4 ? z ? localeData.longStandAloneMonthNames[i] : localeData.longMonthNames[i] : i2 == 3 ? z ? localeData.shortStandAloneMonthNames[i] : localeData.shortMonthNames[i] : zeroPad(i + 1, i2);
    }

    public static java.text.DateFormat getTimeFormat(Context context) {
        return new SimpleDateFormat(getTimeFormatString(context));
    }

    public static String getTimeFormatString(Context context) {
        return getTimeFormatString(context, UserHandle.myUserId());
    }

    public static String getTimeFormatString(Context context, int i) {
        LocaleData localeData = LocaleData.get(context.getResources().getConfiguration().locale);
        return is24HourFormat(context, i) ? localeData.timeFormat24 : localeData.timeFormat12;
    }

    private static String getTimeZoneString(Calendar calendar, int i) {
        TimeZone timeZone = calendar.getTimeZone();
        if (i < 2) {
            return formatZoneOffset(calendar.get(16) + calendar.get(15), i);
        }
        return timeZone.getDisplayName(calendar.get(16) != 0, 0);
    }

    private static String getYearString(int i, int i2) {
        return i2 <= 2 ? zeroPad(i % 100, 2) : String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i));
    }

    public static boolean hasDesignator(CharSequence charSequence, char c2) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            int i3 = 1;
            char charAt = charSequence.charAt(i2);
            if (charAt == '\'') {
                i3 = skipQuotedText(charSequence, i2, length);
            } else if (charAt == c2) {
                return true;
            }
            i = i2 + i3;
        }
    }

    public static boolean hasSeconds(CharSequence charSequence) {
        return hasDesignator(charSequence, 's');
    }

    public static boolean is24HourFormat(Context context) {
        return is24HourFormat(context, UserHandle.myUserId());
    }

    public static boolean is24HourFormat(Context context, int i) {
        return is24HourFormat(Settings.System.getStringForUser(context.getContentResolver(), Settings.System.TIME_12_24, i), context.getResources().getConfiguration().locale);
    }

    public static boolean is24HourFormat(String str, Locale locale) {
        if (str == null) {
            synchronized (sLocaleLock) {
                if (sIs24HourLocale != null && sIs24HourLocale.equals(locale)) {
                    return sIs24Hour;
                }
                java.text.DateFormat timeInstance = java.text.DateFormat.getTimeInstance(1, locale);
                String str2 = timeInstance instanceof SimpleDateFormat ? ((SimpleDateFormat) timeInstance).toPattern().indexOf(72) >= 0 ? "24" : "12" : "12";
                synchronized (sLocaleLock) {
                    sIs24HourLocale = locale;
                    sIs24Hour = str2.equals("24");
                }
                return sIs24Hour;
            }
        }
        return str.equals("24");
    }

    private static int skipQuotedText(CharSequence charSequence, int i, int i2) {
        int i3;
        if (i + 1 >= i2 || charSequence.charAt(i + 1) != '\'') {
            int i4 = i + 1;
            int i5 = 1;
            while (true) {
                i3 = i5;
                if (i4 >= i2) {
                    break;
                } else if (charSequence.charAt(i4) == '\'') {
                    i5++;
                    i3 = i5;
                    if (i4 + 1 >= i2) {
                        break;
                    }
                    i3 = i5;
                    if (charSequence.charAt(i4 + 1) != '\'') {
                        break;
                    }
                    i4++;
                } else {
                    i4++;
                    i5++;
                }
            }
        } else {
            i3 = 2;
        }
        return i3;
    }

    private static String zeroPad(int i, int i2) {
        return String.format(Locale.getDefault(), "%0" + i2 + "d", Integer.valueOf(i));
    }
}
