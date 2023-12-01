package com.danlan.android.cognition.sensor;

import android.os.Build;
import com.danlan.android.cognition.StringFog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/sensor/DateTime.class */
final class DateTime {
    public static String buildISODate(long j) {
        return buildISODate(new Date(j));
    }

    public static String buildISODate(Date date) {
        return getISODateFormat().format(date);
    }

    public static String buildISODateFromCurrentTime() {
        return buildISODate(new Date(System.currentTimeMillis()));
    }

    private static String getDateFormat() {
        return StringFog.decrypt("WFpdWgxuaQxFRwRraRlJTBtQVw1ycHc=");
    }

    private static String getDateFormatLegacy() {
        return StringFog.decrypt("WFpdWgxuaQxFRwRraRlJTBtQVw1ycHc=");
    }

    public static SimpleDateFormat getISODateFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Build.VERSION.SDK_INT <= 23 ? getDateFormatLegacy() : getDateFormat(), Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        return simpleDateFormat;
    }

    public static long utcSecondsSinceEpoch() {
        return new Date().getTime() / 1000;
    }
}
