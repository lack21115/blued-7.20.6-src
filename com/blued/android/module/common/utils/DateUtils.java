package com.blued.android.module.common.utils;

import java.util.Calendar;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/DateUtils.class */
public class DateUtils {
    public static long a(Calendar calendar) {
        return a(Calendar.getInstance(), calendar);
    }

    public static long a(Calendar calendar, Calendar calendar2) {
        return (int) ((calendar2.getTimeInMillis() - calendar.getTimeInMillis()) / 86400000);
    }
}
