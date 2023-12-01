package android.text.format;

import android.content.Context;
import android.net.NetworkUtils;
import com.android.internal.R;
import com.anythink.expressad.d.a.b;

/* loaded from: source-9557208-dex2jar.jar:android/text/format/Formatter.class */
public final class Formatter {
    private static final int MILLIS_PER_MINUTE = 60000;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;

    public static String formatFileSize(Context context, long j) {
        return formatFileSize(context, j, false);
    }

    private static String formatFileSize(Context context, long j, boolean z) {
        if (context == null) {
            return "";
        }
        float f = (float) j;
        int i = 17039683;
        float f2 = f;
        if (f > 900.0f) {
            i = 17039684;
            f2 = f / 1024.0f;
        }
        float f3 = f2;
        if (f2 > 900.0f) {
            i = 17039685;
            f3 = f2 / 1024.0f;
        }
        float f4 = f3;
        if (f3 > 900.0f) {
            i = 17039686;
            f4 = f3 / 1024.0f;
        }
        float f5 = f4;
        if (f4 > 900.0f) {
            i = 17039687;
            f5 = f4 / 1024.0f;
        }
        float f6 = f5;
        if (f5 > 900.0f) {
            i = 17039688;
            f6 = f5 / 1024.0f;
        }
        return context.getResources().getString(R.string.fileSizeSuffix, f6 < 1.0f ? String.format("%.2f", Float.valueOf(f6)) : f6 < 10.0f ? z ? String.format("%.1f", Float.valueOf(f6)) : String.format("%.2f", Float.valueOf(f6)) : f6 < 100.0f ? z ? String.format("%.0f", Float.valueOf(f6)) : String.format("%.2f", Float.valueOf(f6)) : String.format("%.0f", Float.valueOf(f6)), context.getString(i));
    }

    @Deprecated
    public static String formatIpAddress(int i) {
        return NetworkUtils.intToInetAddress(i).getHostAddress();
    }

    public static String formatShortElapsedTime(Context context, long j) {
        long j2 = j / 1000;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        long j3 = j2;
        if (j2 >= 86400) {
            i = (int) (j2 / 86400);
            j3 = j2 - (86400 * i);
        }
        long j4 = j3;
        if (j3 >= b.P) {
            i2 = (int) (j3 / b.P);
            j4 = j3 - (i2 * 3600);
        }
        long j5 = j4;
        if (j4 >= 60) {
            i3 = (int) (j4 / 60);
            j5 = j4 - (i3 * 60);
        }
        int i4 = (int) j5;
        return i >= 2 ? context.getString(R.string.durationDays, Integer.valueOf(i + ((i2 + 12) / 24))) : i > 0 ? i2 == 1 ? context.getString(R.string.durationDayHour, Integer.valueOf(i), Integer.valueOf(i2)) : context.getString(R.string.durationDayHours, Integer.valueOf(i), Integer.valueOf(i2)) : i2 >= 2 ? context.getString(R.string.durationHours, Integer.valueOf(i2 + ((i3 + 30) / 60))) : i2 > 0 ? i3 == 1 ? context.getString(R.string.durationHourMinute, Integer.valueOf(i2), Integer.valueOf(i3)) : context.getString(R.string.durationHourMinutes, Integer.valueOf(i2), Integer.valueOf(i3)) : i3 >= 2 ? context.getString(R.string.durationMinutes, Integer.valueOf(i3 + ((i4 + 30) / 60))) : i3 > 0 ? i4 == 1 ? context.getString(R.string.durationMinuteSecond, Integer.valueOf(i3), Integer.valueOf(i4)) : context.getString(R.string.durationMinuteSeconds, Integer.valueOf(i3), Integer.valueOf(i4)) : i4 == 1 ? context.getString(R.string.durationSecond, Integer.valueOf(i4)) : context.getString(R.string.durationSeconds, Integer.valueOf(i4));
    }

    public static String formatShortElapsedTimeRoundingUpToMinutes(Context context, long j) {
        long j2 = ((j + 60000) - 1) / 60000;
        return j2 == 0 ? context.getString(R.string.durationMinutes, 0) : j2 == 1 ? context.getString(R.string.durationMinute, 1) : formatShortElapsedTime(context, j2 * 60000);
    }

    public static String formatShortFileSize(Context context, long j) {
        return formatFileSize(context, j, true);
    }
}
