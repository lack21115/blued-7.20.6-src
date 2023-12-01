package com.mokee.cloud.calendar;

import android.content.SharedPreferences;
import com.mokee.cloud.misc.CloudUtils;
import java.util.Calendar;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/cloud/calendar/ChineseCalendarUtils.class */
public class ChineseCalendarUtils {
    private static boolean a(Calendar calendar) {
        return calendar.get(7) == 1 || calendar.get(7) == 7;
    }

    private static boolean a(Calendar calendar, SharedPreferences sharedPreferences) {
        return isChineseHolidayOrWorkday(sharedPreferences, calendar.get(1), calendar.get(2) + 1, calendar.get(5));
    }

    private static boolean b(Calendar calendar, SharedPreferences sharedPreferences) {
        return isChineseHolidayOrWorkday(sharedPreferences, calendar.get(1), calendar.get(2) + 1, calendar.get(5));
    }

    public static Calendar calculateDaysToNextAlarmWithoutHoliday(Calendar calendar, SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2) {
        if (CloudUtils.hasAccessPermission()) {
            while (true) {
                if (!b(calendar, sharedPreferences2)) {
                    if (!a(calendar)) {
                        break;
                    } else if (a(calendar, sharedPreferences)) {
                        return calendar;
                    }
                }
                calendar.add(6, 1);
            }
        }
        return calendar;
    }

    public static boolean isChineseHolidayOrWorkday(SharedPreferences sharedPreferences, int i, int i2, int i3) {
        if (CloudUtils.hasAccessPermission()) {
            return sharedPreferences.getBoolean(String.valueOf(i) + "-" + i2 + "-" + i3, false);
        }
        return false;
    }
}
