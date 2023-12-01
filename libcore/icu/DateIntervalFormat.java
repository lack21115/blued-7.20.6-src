package libcore.icu;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import libcore.util.BasicLruCache;

/* loaded from: source-2895416-dex2jar.jar:libcore/icu/DateIntervalFormat.class */
public final class DateIntervalFormat {
    private static final FormatterCache CACHED_FORMATTERS = new FormatterCache();
    private static final int DAY_IN_MS = 86400000;
    private static final int EPOCH_JULIAN_DAY = 2440588;
    public static final int FORMAT_12HOUR = 64;
    public static final int FORMAT_24HOUR = 128;
    public static final int FORMAT_ABBREV_ALL = 524288;
    public static final int FORMAT_ABBREV_MONTH = 65536;
    public static final int FORMAT_ABBREV_TIME = 16384;
    public static final int FORMAT_ABBREV_WEEKDAY = 32768;
    public static final int FORMAT_NO_MONTH_DAY = 32;
    public static final int FORMAT_NO_YEAR = 8;
    public static final int FORMAT_NUMERIC_DATE = 131072;
    public static final int FORMAT_SHOW_DATE = 16;
    public static final int FORMAT_SHOW_TIME = 1;
    public static final int FORMAT_SHOW_WEEKDAY = 2;
    public static final int FORMAT_SHOW_YEAR = 4;
    public static final int FORMAT_UTC = 8192;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:libcore/icu/DateIntervalFormat$FormatterCache.class */
    public static class FormatterCache extends BasicLruCache<String, Long> {
        FormatterCache() {
            super(8);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // libcore.util.BasicLruCache
        public void entryEvicted(String str, Long l) {
            DateIntervalFormat.destroyDateIntervalFormat(l.longValue());
        }
    }

    private DateIntervalFormat() {
    }

    private static native long createDateIntervalFormat(String str, String str2, String str3);

    private static int dayDistance(Calendar calendar, Calendar calendar2) {
        return julianDay(calendar2) - julianDay(calendar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void destroyDateIntervalFormat(long j);

    private static boolean fallInSameMonth(Calendar calendar, Calendar calendar2) {
        return calendar.get(2) == calendar2.get(2);
    }

    private static boolean fallInSameYear(Calendar calendar, Calendar calendar2) {
        return calendar.get(1) == calendar2.get(1);
    }

    private static boolean fallOnDifferentDates(Calendar calendar, Calendar calendar2) {
        return (calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5)) ? false : true;
    }

    private static native String formatDateInterval(long j, long j2, long j3);

    public static String formatDateRange(long j, long j2, int i, String str) {
        if ((i & 8192) != 0) {
            str = "UTC";
        }
        return formatDateRange(Locale.getDefault(), str != null ? TimeZone.getTimeZone(str) : TimeZone.getDefault(), j, j2, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0045, code lost:
        if (dayDistance(r0, r17) <= 1) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String formatDateRange(java.util.Locale r7, java.util.TimeZone r8, long r9, long r11, int r13) {
        /*
            r0 = r8
            java.util.Calendar r0 = java.util.Calendar.getInstance(r0)
            r18 = r0
            r0 = r18
            r1 = r9
            r0.setTimeInMillis(r1)
            r0 = r9
            r1 = r11
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L83
            r0 = r18
            r17 = r0
        L17:
            r0 = r17
            boolean r0 = isMidnight(r0)
            r16 = r0
            r0 = r11
            r14 = r0
            r0 = r9
            r1 = r11
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L57
            r0 = r11
            r14 = r0
            r0 = r16
            if (r0 == 0) goto L57
            r0 = r13
            r1 = 1
            r0 = r0 & r1
            if (r0 == 0) goto L48
            r0 = r11
            r14 = r0
            r0 = r18
            r1 = r17
            int r0 = dayDistance(r0, r1)
            r1 = 1
            if (r0 > r1) goto L57
        L48:
            r0 = r17
            r1 = 5
            r2 = 0
            r0.roll(r1, r2)
            r0 = r11
            r1 = 86400000(0x5265c00, double:4.2687272E-316)
            long r0 = r0 - r1
            r14 = r0
        L57:
            r0 = r18
            r1 = r17
            r2 = r13
            java.lang.String r0 = toSkeleton(r0, r1, r2)
            r18 = r0
            libcore.icu.DateIntervalFormat$FormatterCache r0 = libcore.icu.DateIntervalFormat.CACHED_FORMATTERS
            r17 = r0
            r0 = r17
            monitor-enter(r0)
            r0 = r18
            r1 = r7
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L93
            r2 = r8
            java.lang.String r2 = r2.getID()     // Catch: java.lang.Throwable -> L93
            long r0 = getFormatter(r0, r1, r2)     // Catch: java.lang.Throwable -> L93
            r1 = r9
            r2 = r14
            java.lang.String r0 = formatDateInterval(r0, r1, r2)     // Catch: java.lang.Throwable -> L93
            r7 = r0
            r0 = r17
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L93
            r0 = r7
            return r0
        L83:
            r0 = r8
            java.util.Calendar r0 = java.util.Calendar.getInstance(r0)
            r17 = r0
            r0 = r17
            r1 = r11
            r0.setTimeInMillis(r1)
            goto L17
        L93:
            r7 = move-exception
            r0 = r17
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L93
            r0 = r7
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: libcore.icu.DateIntervalFormat.formatDateRange(java.util.Locale, java.util.TimeZone, long, long, int):java.lang.String");
    }

    private static long getFormatter(String str, String str2, String str3) {
        String str4 = str + "\t" + str2 + "\t" + str3;
        Long l = CACHED_FORMATTERS.get(str4);
        if (l != null) {
            return l.longValue();
        }
        long createDateIntervalFormat = createDateIntervalFormat(str, str2, str3);
        CACHED_FORMATTERS.put(str4, Long.valueOf(createDateIntervalFormat));
        return createDateIntervalFormat;
    }

    private static boolean isMidnight(Calendar calendar) {
        return calendar.get(11) == 0 && calendar.get(12) == 0 && calendar.get(13) == 0 && calendar.get(14) == 0;
    }

    private static boolean isThisYear(Calendar calendar) {
        return calendar.get(1) == Calendar.getInstance(calendar.getTimeZone()).get(1);
    }

    private static int julianDay(Calendar calendar) {
        return ((int) (((calendar.getTimeInMillis() + calendar.get(15)) + calendar.get(16)) / 86400000)) + EPOCH_JULIAN_DAY;
    }

    private static boolean onTheHour(Calendar calendar) {
        return calendar.get(12) == 0 && calendar.get(13) == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x0126, code lost:
        if (onTheHour(r4) == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0159, code lost:
        if (isThisYear(r3) == false) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String toSkeleton(java.util.Calendar r3, java.util.Calendar r4, int r5) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: libcore.icu.DateIntervalFormat.toSkeleton(java.util.Calendar, java.util.Calendar, int):java.lang.String");
    }
}
