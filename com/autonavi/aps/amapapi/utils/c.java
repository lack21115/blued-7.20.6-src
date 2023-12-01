package com.autonavi.aps.amapapi.utils;

import java.util.Calendar;
import java.util.Date;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/utils/c.class */
public final class c {
    private static long a(long j) {
        return j - b(j);
    }

    private static long a(long j, long j2) {
        long b = b(j2) + a(j);
        long abs = Math.abs(b - j2);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(b));
        int i = calendar.get(11);
        long j3 = b;
        if (i == 23) {
            j3 = b;
            if (abs >= 82800000) {
                j3 = b - 86400000;
            }
        }
        long j4 = j3;
        if (i == 0) {
            j4 = j3;
            if (abs >= 82800000) {
                j4 = j3 + 86400000;
            }
        }
        return j4;
    }

    public static long a(long j, long j2, int i) {
        long j3 = j;
        if (i > 0) {
            j3 = j;
            try {
                if (Math.abs(j - j2) > i * 31536000000L) {
                    j3 = a(j, j2);
                }
            } catch (Throwable th) {
                return j;
            }
        }
        return j3;
    }

    private static long b(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j));
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }
}
