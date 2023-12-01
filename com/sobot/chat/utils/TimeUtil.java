package com.sobot.chat.utils;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/TimeUtil.class */
public class TimeUtil {
    public static final SimpleDateFormat DATE_FORMAT0 = new SimpleDateFormat("HH:mm", Locale.getDefault());
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    public static final SimpleDateFormat DATE_FORMAT2 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    public static final SimpleDateFormat DATE_FORMAT3 = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
    public static final SimpleDateFormat DATE_FORMAT4 = new SimpleDateFormat("mm:ss", Locale.getDefault());
    public static final SimpleDateFormat DATE_FORMAT5 = new SimpleDateFormat("M月d日", Locale.getDefault());

    public static String formatDateTime(String str) {
        return formatDateTime(str, false, "");
    }

    public static String formatDateTime(String str, boolean z, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (str == null || "".equals(str) || str.length() < 19) {
            return "";
        }
        Date date = null;
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(1, calendar.get(1));
        calendar2.set(2, calendar.get(2));
        calendar2.set(5, calendar.get(5));
        calendar2.set(11, 0);
        calendar2.set(12, 0);
        calendar2.set(13, 0);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(1, calendar.get(1));
        calendar3.set(2, calendar.get(2));
        calendar3.set(5, calendar.get(5) - 1);
        calendar3.set(11, 0);
        calendar3.set(12, 0);
        calendar3.set(13, 0);
        if (date != null) {
            calendar.setTime(date);
        }
        if (!calendar.after(calendar2)) {
            int indexOf = str.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER) + 1;
            return z ? str.substring(indexOf, str.length()).substring(0, 11) : str.substring(indexOf, str.length()).substring(0, 5);
        }
        return str2 + " " + str.split(" ")[1].substring(0, 5);
    }

    public static String getCurrentTime() {
        return toDate(System.currentTimeMillis(), DATE_FORMAT);
    }

    public static String getStandardDate(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        long currentTimeMillis = System.currentTimeMillis() - (Long.parseLong(str) * 1000);
        long ceil = (long) Math.ceil(currentTimeMillis / 1000);
        long j = currentTimeMillis / 60;
        long ceil2 = (long) Math.ceil(((float) j) / 1000.0f);
        long ceil3 = (long) Math.ceil(((float) (j / 60)) / 1000.0f);
        long ceil4 = (long) Math.ceil(((float) (((currentTimeMillis / 24) / 60) / 60)) / 1000.0f);
        int i = (ceil4 > 7L ? 1 : (ceil4 == 7L ? 0 : -1));
        if (i > 0) {
            stringBuffer.append(timeStamp2Date(str, "yyyy-MM-dd"));
            return stringBuffer.toString();
        }
        if (ceil4 > 1 && i <= 0) {
            stringBuffer.append(ceil4 + "天");
        } else if (ceil3 - 1 > 0) {
            if (ceil3 >= 24) {
                stringBuffer.append("1天");
            } else {
                stringBuffer.append(ceil3 + "小时");
            }
        } else if (ceil2 - 1 > 0) {
            if (ceil2 == 60) {
                stringBuffer.append("1小时");
            } else {
                stringBuffer.append(ceil2 + "分钟");
            }
        } else if (ceil - 1 <= 0) {
            stringBuffer.append("刚刚");
        } else if (ceil == 60) {
            stringBuffer.append("1分钟");
        } else {
            stringBuffer.append(ceil + "秒");
        }
        if (!stringBuffer.toString().equals("刚刚")) {
            stringBuffer.append("前");
        }
        return stringBuffer.toString();
    }

    public static void main(String[] strArr) {
        String formatDateTime = formatDateTime("2016-01-07 15:41:00", true, "今天");
        PrintStream printStream = System.out;
        printStream.println("time:" + formatDateTime);
        String formatDateTime2 = formatDateTime("2016-01-03 11:41:00");
        PrintStream printStream2 = System.out;
        printStream2.println("time:" + formatDateTime2);
        String formatDateTime3 = formatDateTime("2016-01-01 15:43:00");
        PrintStream printStream3 = System.out;
        printStream3.println("time:" + formatDateTime3);
    }

    public static Date parse(String str, SimpleDateFormat simpleDateFormat) {
        try {
            return simpleDateFormat.parse(str);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static long stringToLong(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            return DATE_FORMAT.parse(str).getTime() / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static long stringToLongMs(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(DATE_FORMAT4.parse(str));
            return calendar.get(13);
        } catch (ParseException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
        if (android.text.TextUtils.isEmpty(r7) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String timeStamp2Date(java.lang.String r6, java.lang.String r7) {
        /*
            r0 = r6
            if (r0 == 0) goto L5b
            r0 = r6
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L5b
            r0 = r6
            java.lang.String r1 = "null"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L17
            goto L5b
        L17:
            r0 = r7
            if (r0 == 0) goto L24
            r0 = r7
            r8 = r0
            r0 = r7
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L27
        L24:
            java.lang.String r0 = "yyyy-MM-dd HH:mm:ss"
            r8 = r0
        L27:
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            r1 = r0
            r2 = r8
            r1.<init>(r2)
            r7 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r8 = r0
            r0 = r8
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r8
            java.lang.String r1 = "000"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            java.util.Date r1 = new java.util.Date
            r2 = r1
            r3 = r8
            java.lang.String r3 = r3.toString()
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            long r3 = r3.longValue()
            r2.<init>(r3)
            java.lang.String r0 = r0.format(r1)
            return r0
        L5b:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.utils.TimeUtil.timeStamp2Date(java.lang.String, java.lang.String):java.lang.String");
    }

    public static String toDate(long j, SimpleDateFormat simpleDateFormat) {
        try {
            return simpleDateFormat.format(new Date(j));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
