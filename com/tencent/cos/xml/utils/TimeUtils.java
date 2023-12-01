package com.tencent.cos.xml.utils;

import java.util.concurrent.TimeUnit;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/utils/TimeUtils.class */
public class TimeUtils {
    private static final String TAG = "TimeUtil";

    public static long getTookTime(long j) {
        return TimeUnit.MILLISECONDS.convert(System.nanoTime() - j, TimeUnit.NANOSECONDS);
    }
}
