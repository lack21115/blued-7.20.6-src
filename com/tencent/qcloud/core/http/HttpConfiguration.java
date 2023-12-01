package com.tencent.qcloud.core.http;

import com.tencent.qcloud.core.logger.QCloudLogger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/HttpConfiguration.class */
public class HttpConfiguration {
    private static final String RFC822_DATE_PATTERN = "EEE, dd MMM yyyy HH:mm:ss z";
    private static final AtomicLong GLOBAL_TIME_OFFSET = new AtomicLong(0);
    private static final TimeZone GMT_TIMEZONE = TimeZone.getTimeZone("GMT");
    private static ThreadLocal<SimpleDateFormat> gmtFormatters = new ThreadLocal<>();

    public static long calculateGlobalTimeOffset(String str, Date date) {
        long j = GLOBAL_TIME_OFFSET.get();
        calculateGlobalTimeOffset(str, date, 0);
        return Math.abs(j - GLOBAL_TIME_OFFSET.get());
    }

    public static void calculateGlobalTimeOffset(String str, Date date, int i) {
        try {
            long time = (getFormatter().parse(str).getTime() - date.getTime()) / 1000;
            if (Math.abs(time) >= i) {
                GLOBAL_TIME_OFFSET.set(time);
                QCloudLogger.i(QCloudHttpClient.HTTP_LOG_TAG, "NEW TIME OFFSET is " + time + "s", new Object[0]);
            }
        } catch (ParseException e) {
        }
    }

    public static long getDeviceTimeWithOffset() {
        return (System.currentTimeMillis() / 1000) + GLOBAL_TIME_OFFSET.get();
    }

    private static SimpleDateFormat getFormatter() {
        SimpleDateFormat simpleDateFormat = gmtFormatters.get();
        SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
        if (simpleDateFormat == null) {
            simpleDateFormat2 = new SimpleDateFormat(RFC822_DATE_PATTERN, Locale.US);
            simpleDateFormat2.setTimeZone(GMT_TIMEZONE);
            simpleDateFormat2.setLenient(false);
            gmtFormatters.set(simpleDateFormat2);
        }
        return simpleDateFormat2;
    }

    public static String getGMTDate(Date date) {
        return getFormatter().format(date);
    }

    public static Date getGMTDate(String str) {
        try {
            return getFormatter().parse(str);
        } catch (ParseException e) {
            return null;
        }
    }
}
