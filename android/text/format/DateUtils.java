package android.text.format;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.anythink.expressad.d.a.b;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import libcore.icu.DateIntervalFormat;
import libcore.icu.LocaleData;

/* loaded from: source-9557208-dex2jar.jar:android/text/format/DateUtils.class */
public class DateUtils {
    @Deprecated
    public static final String ABBREV_MONTH_FORMAT = "%b";
    public static final String ABBREV_WEEKDAY_FORMAT = "%a";
    public static final long DAY_IN_MILLIS = 86400000;
    @Deprecated
    public static final int FORMAT_12HOUR = 64;
    @Deprecated
    public static final int FORMAT_24HOUR = 128;
    public static final int FORMAT_ABBREV_ALL = 524288;
    public static final int FORMAT_ABBREV_MONTH = 65536;
    public static final int FORMAT_ABBREV_RELATIVE = 262144;
    public static final int FORMAT_ABBREV_TIME = 16384;
    public static final int FORMAT_ABBREV_WEEKDAY = 32768;
    @Deprecated
    public static final int FORMAT_CAP_AMPM = 256;
    @Deprecated
    public static final int FORMAT_CAP_MIDNIGHT = 4096;
    @Deprecated
    public static final int FORMAT_CAP_NOON = 1024;
    @Deprecated
    public static final int FORMAT_CAP_NOON_MIDNIGHT = 5120;
    public static final int FORMAT_NO_MIDNIGHT = 2048;
    public static final int FORMAT_NO_MONTH_DAY = 32;
    public static final int FORMAT_NO_NOON = 512;
    @Deprecated
    public static final int FORMAT_NO_NOON_MIDNIGHT = 2560;
    public static final int FORMAT_NO_YEAR = 8;
    public static final int FORMAT_NUMERIC_DATE = 131072;
    public static final int FORMAT_SHOW_DATE = 16;
    public static final int FORMAT_SHOW_TIME = 1;
    public static final int FORMAT_SHOW_WEEKDAY = 2;
    public static final int FORMAT_SHOW_YEAR = 4;
    @Deprecated
    public static final int FORMAT_UTC = 8192;
    public static final long HOUR_IN_MILLIS = 3600000;
    @Deprecated
    public static final String HOUR_MINUTE_24 = "%H:%M";
    @Deprecated
    public static final int LENGTH_LONG = 10;
    @Deprecated
    public static final int LENGTH_MEDIUM = 20;
    @Deprecated
    public static final int LENGTH_SHORT = 30;
    @Deprecated
    public static final int LENGTH_SHORTER = 40;
    @Deprecated
    public static final int LENGTH_SHORTEST = 50;
    public static final long MINUTE_IN_MILLIS = 60000;
    public static final String MONTH_DAY_FORMAT = "%-d";
    public static final String MONTH_FORMAT = "%B";
    public static final String NUMERIC_MONTH_FORMAT = "%m";
    public static final long SECOND_IN_MILLIS = 1000;
    public static final String WEEKDAY_FORMAT = "%A";
    public static final long WEEK_IN_MILLIS = 604800000;
    public static final String YEAR_FORMAT = "%Y";
    public static final String YEAR_FORMAT_TWO_DIGITS = "%g";
    public static final long YEAR_IN_MILLIS = 31449600000L;
    private static String sElapsedFormatHMMSS;
    private static String sElapsedFormatMMSS;
    private static Configuration sLastConfig;
    private static Time sNowTime;
    private static Time sThenTime;
    private static final Object sLock = new Object();
    private static final String[] sAmPmCN = {"凌晨", "黎明", "早晨", "上午", "中午", "下午", "晚上", "深夜"};
    public static final int[] sameYearTable = null;
    public static final int[] sameMonthTable = null;

    public static String formatDateRange(Context context, long j, long j2, int i) {
        return formatDateRange(context, new java.util.Formatter(new StringBuilder(50), Locale.getDefault()), j, j2, i).toString();
    }

    public static java.util.Formatter formatDateRange(Context context, java.util.Formatter formatter, long j, long j2, int i) {
        return formatDateRange(context, formatter, j, j2, i, null);
    }

    public static java.util.Formatter formatDateRange(Context context, java.util.Formatter formatter, long j, long j2, int i, String str) {
        int i2 = i;
        if ((i & 193) == 1) {
            i2 = i | (DateFormat.is24HourFormat(context) ? 128 : 64);
        }
        try {
            formatter.out().append(DateIntervalFormat.formatDateRange(j, j2, i2, str));
            return formatter;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public static String formatDateTime(Context context, long j, int i) {
        return formatDateRange(context, j, j, i);
    }

    public static CharSequence formatDuration(long j) {
        Resources system = Resources.getSystem();
        if (j >= 3600000) {
            int i = (int) ((1800000 + j) / 3600000);
            return system.getQuantityString(18087956, i, Integer.valueOf(i));
        } else if (j >= 60000) {
            int i2 = (int) ((30000 + j) / 60000);
            return system.getQuantityString(18087955, i2, Integer.valueOf(i2));
        } else {
            int i3 = (int) ((500 + j) / 1000);
            return system.getQuantityString(18087954, i3, Integer.valueOf(i3));
        }
    }

    public static String formatElapsedTime(long j) {
        return formatElapsedTime(null, j);
    }

    public static String formatElapsedTime(StringBuilder sb, long j) {
        long j2 = 0;
        long j3 = 0;
        long j4 = j;
        if (j >= b.P) {
            j2 = j / b.P;
            j4 = j - (b.P * j2);
        }
        long j5 = j4;
        if (j4 >= 60) {
            j3 = j4 / 60;
            j5 = j4 - (60 * j3);
        }
        if (sb == null) {
            sb = new StringBuilder(8);
        } else {
            sb.setLength(0);
        }
        java.util.Formatter formatter = new java.util.Formatter(sb, Locale.getDefault());
        initFormatStrings();
        return j2 > 0 ? formatter.format(sElapsedFormatHMMSS, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j5)).toString() : formatter.format(sElapsedFormatMMSS, Long.valueOf(j3), Long.valueOf(j5)).toString();
    }

    public static final CharSequence formatSameDayTime(long j, long j2, int i, int i2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(j);
        Date time = gregorianCalendar.getTime();
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
        gregorianCalendar2.setTimeInMillis(j2);
        return ((gregorianCalendar.get(1) == gregorianCalendar2.get(1) && gregorianCalendar.get(2) == gregorianCalendar2.get(2) && gregorianCalendar.get(5) == gregorianCalendar2.get(5)) ? java.text.DateFormat.getTimeInstance(i2) : java.text.DateFormat.getDateInstance(i)).format(time);
    }

    public static String getAMPMCNString(int i, int i2) {
        return i2 == 0 ? i < 5 ? sAmPmCN[0] : (i < 5 || i >= 7) ? (i < 7 || i >= 9) ? (i < 9 || i >= 12) ? sAmPmCN[0] : sAmPmCN[3] : sAmPmCN[2] : sAmPmCN[1] : i == 0 ? sAmPmCN[4] : i < 6 ? sAmPmCN[5] : (i < 6 || i > 9) ? (i <= 9 || i >= 12) ? i == 12 ? sAmPmCN[4] : sAmPmCN[4] : sAmPmCN[7] : sAmPmCN[6];
    }

    @Deprecated
    public static String getAMPMString(int i) {
        return LocaleData.get(Locale.getDefault()).amPm[i + 0];
    }

    @Deprecated
    public static String getDayOfWeekString(int i, int i2) {
        String[] strArr;
        LocaleData localeData = LocaleData.get(Locale.getDefault());
        switch (i2) {
            case 10:
                strArr = localeData.longWeekdayNames;
                break;
            case 20:
                strArr = localeData.shortWeekdayNames;
                break;
            case 30:
                strArr = localeData.shortWeekdayNames;
                break;
            case 40:
                strArr = localeData.shortWeekdayNames;
                break;
            case 50:
                strArr = localeData.tinyWeekdayNames;
                break;
            default:
                strArr = localeData.shortWeekdayNames;
                break;
        }
        return strArr[i];
    }

    @Deprecated
    public static String getMonthString(int i, int i2) {
        String[] strArr;
        LocaleData localeData = LocaleData.get(Locale.getDefault());
        switch (i2) {
            case 10:
                strArr = localeData.longMonthNames;
                break;
            case 20:
                strArr = localeData.shortMonthNames;
                break;
            case 30:
                strArr = localeData.shortMonthNames;
                break;
            case 40:
                strArr = localeData.shortMonthNames;
                break;
            case 50:
                strArr = localeData.tinyMonthNames;
                break;
            default:
                strArr = localeData.shortMonthNames;
                break;
        }
        return strArr[i];
    }

    public static CharSequence getRelativeDateTimeString(Context context, long j, long j2, long j3, int i) {
        long j4;
        Resources system = Resources.getSystem();
        long currentTimeMillis = System.currentTimeMillis();
        long abs = Math.abs(currentTimeMillis - j);
        if (j3 > 604800000) {
            j4 = 604800000;
        } else {
            j4 = j3;
            if (j3 < 86400000) {
                j4 = 86400000;
            }
        }
        String formatDateRange = formatDateRange(context, j, j, 1);
        return abs < j4 ? system.getString(17040692, getRelativeTimeSpanString(j, currentTimeMillis, j2, i), formatDateRange) : system.getString(17039661, getRelativeTimeSpanString(context, j, false), formatDateRange);
    }

    private static final String getRelativeDayString(Resources resources, long j, long j2) {
        Locale locale = resources.getConfiguration().locale;
        Locale locale2 = locale;
        if (locale == null) {
            locale2 = Locale.getDefault();
        }
        Time time = new Time();
        time.set(j);
        int julianDay = Time.getJulianDay(j, time.gmtoff);
        Time time2 = new Time();
        time2.set(j2);
        int abs = Math.abs(Time.getJulianDay(j2, time2.gmtoff) - julianDay);
        boolean z = j2 > j;
        if (abs == 1) {
            return z ? LocaleData.get(locale2).yesterday : LocaleData.get(locale2).tomorrow;
        } else if (abs == 0) {
            return LocaleData.get(locale2).today;
        } else {
            return String.format(resources.getQuantityString(z ? 18087941 : 18087945, abs), Integer.valueOf(abs));
        }
    }

    public static CharSequence getRelativeTimeSpanString(long j) {
        return getRelativeTimeSpanString(j, System.currentTimeMillis(), 60000L);
    }

    public static CharSequence getRelativeTimeSpanString(long j, long j2, long j3) {
        return getRelativeTimeSpanString(j, j2, j3, 65556);
    }

    public static CharSequence getRelativeTimeSpanString(long j, long j2, long j3, int i) {
        long j4;
        int i2;
        Resources system = Resources.getSystem();
        boolean z = (786432 & i) != 0;
        boolean z2 = j2 >= j;
        long abs = Math.abs(j2 - j);
        if (abs < 60000 && j3 < 60000) {
            j4 = abs / 1000;
            i2 = z2 ? z ? 18087946 : 18087937 : z ? 18087950 : 18087942;
        } else if (abs < 3600000 && j3 < 3600000) {
            j4 = abs / 60000;
            i2 = z2 ? z ? 18087947 : 18087938 : z ? 18087951 : 18087943;
        } else if (abs >= 86400000 || j3 >= 86400000) {
            return (abs >= 604800000 || j3 >= 604800000) ? formatDateRange(null, j, j, i) : getRelativeDayString(system, j, j2);
        } else {
            j4 = abs / 3600000;
            i2 = z2 ? z ? 18087948 : 18087939 : z ? 18087952 : 18087944;
        }
        return String.format(system.getQuantityString(i2, (int) j4), Long.valueOf(j4));
    }

    public static CharSequence getRelativeTimeSpanString(Context context, long j) {
        return getRelativeTimeSpanString(context, j, false);
    }

    public static CharSequence getRelativeTimeSpanString(Context context, long j, boolean z) {
        String formatDateRange;
        int i;
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        long abs = Math.abs(currentTimeMillis - j);
        synchronized (DateUtils.class) {
            try {
                if (sNowTime == null) {
                    sNowTime = new Time();
                }
                if (sThenTime == null) {
                    sThenTime = new Time();
                }
                sNowTime.set(currentTimeMillis);
                sThenTime.set(j);
                if (abs < 86400000 && sNowTime.weekDay == sThenTime.weekDay) {
                    formatDateRange = formatDateRange(context, j, j, 1);
                    i = 17040678;
                } else if (sNowTime.year != sThenTime.year) {
                    formatDateRange = formatDateRange(context, j, j, 131092);
                    i = 17040677;
                } else {
                    formatDateRange = formatDateRange(context, j, j, com.igexin.push.c.b.b.f9718a);
                    i = 17040677;
                }
                str = formatDateRange;
                if (z) {
                    str = context.getResources().getString(i, formatDateRange);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    private static void initFormatStrings() {
        synchronized (sLock) {
            initFormatStringsLocked();
        }
    }

    private static void initFormatStringsLocked() {
        Resources system = Resources.getSystem();
        Configuration configuration = system.getConfiguration();
        if (sLastConfig == null || !sLastConfig.equals(configuration)) {
            sLastConfig = configuration;
            sElapsedFormatMMSS = system.getString(17040697);
            sElapsedFormatHMMSS = system.getString(17040698);
        }
    }

    public static boolean isToday(long j) {
        Time time = new Time();
        time.set(j);
        int i = time.year;
        int i2 = time.month;
        int i3 = time.monthDay;
        time.set(System.currentTimeMillis());
        return i == time.year && i2 == time.month && i3 == time.monthDay;
    }
}
