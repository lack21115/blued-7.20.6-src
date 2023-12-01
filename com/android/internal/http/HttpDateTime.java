package com.android.internal.http;

import android.text.format.Time;
import com.amap.api.services.core.AMapException;
import com.android.internal.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/http/HttpDateTime.class */
public final class HttpDateTime {
    private static final String HTTP_DATE_RFC_REGEXP = "([0-9]{1,2})[- ]([A-Za-z]{3,9})[- ]([0-9]{2,4})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])";
    private static final Pattern HTTP_DATE_RFC_PATTERN = Pattern.compile(HTTP_DATE_RFC_REGEXP);
    private static final String HTTP_DATE_ANSIC_REGEXP = "[ ]([A-Za-z]{3,9})[ ]+([0-9]{1,2})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])[ ]([0-9]{2,4})";
    private static final Pattern HTTP_DATE_ANSIC_PATTERN = Pattern.compile(HTTP_DATE_ANSIC_REGEXP);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/http/HttpDateTime$TimeOfDay.class */
    public static class TimeOfDay {
        int hour;
        int minute;
        int second;

        TimeOfDay(int i, int i2, int i3) {
            this.hour = i;
            this.minute = i2;
            this.second = i3;
        }
    }

    private static int getDate(String str) {
        return str.length() == 2 ? ((str.charAt(0) - '0') * 10) + (str.charAt(1) - '0') : str.charAt(0) - '0';
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int getMonth(String str) {
        int i = 0;
        switch (((Character.toLowerCase(str.charAt(0)) + Character.toLowerCase(str.charAt(1))) + Character.toLowerCase(str.charAt(2))) - R.styleable.Theme_preferencePanelStyle) {
            case 9:
                return 11;
            case 10:
                i = 1;
                break;
            case 22:
                break;
            case 26:
                return 7;
            case 29:
                return 2;
            case 32:
                return 3;
            case 35:
                return 9;
            case 36:
                return 4;
            case 37:
                return 8;
            case 40:
                return 6;
            case 42:
                return 5;
            case 48:
                return 10;
            default:
                throw new IllegalArgumentException();
        }
        return i;
    }

    private static TimeOfDay getTime(String str) {
        int i;
        int i2 = 0 + 1;
        int charAt = str.charAt(0) - '0';
        if (str.charAt(i2) != ':') {
            i = i2 + 1;
            charAt = (charAt * 10) + (str.charAt(i2) - '0');
        } else {
            i = i2;
        }
        int i3 = i + 1;
        int i4 = i3 + 1;
        char charAt2 = str.charAt(i3);
        char charAt3 = str.charAt(i4);
        int i5 = i4 + 1 + 1;
        return new TimeOfDay(charAt, ((charAt2 - '0') * 10) + (charAt3 - '0'), ((str.charAt(i5) - '0') * 10) + (str.charAt(i5 + 1) - '0'));
    }

    private static int getYear(String str) {
        if (str.length() == 2) {
            int charAt = ((str.charAt(0) - '0') * 10) + (str.charAt(1) - '0');
            return charAt >= 70 ? charAt + AMapException.CODE_AMAP_CLIENT_UNKNOWN_ERROR : charAt + 2000;
        } else if (str.length() == 3) {
            return ((str.charAt(0) - '0') * 100) + ((str.charAt(1) - '0') * 10) + (str.charAt(2) - '0') + AMapException.CODE_AMAP_CLIENT_UNKNOWN_ERROR;
        } else {
            if (str.length() == 4) {
                return ((str.charAt(0) - '0') * 1000) + ((str.charAt(1) - '0') * 100) + ((str.charAt(2) - '0') * 10) + (str.charAt(3) - '0');
            }
            return 1970;
        }
    }

    public static long parse(String str) throws IllegalArgumentException {
        int month;
        int date;
        TimeOfDay time;
        int year;
        Matcher matcher = HTTP_DATE_RFC_PATTERN.matcher(str);
        if (matcher.find()) {
            date = getDate(matcher.group(1));
            month = getMonth(matcher.group(2));
            year = getYear(matcher.group(3));
            time = getTime(matcher.group(4));
        } else {
            Matcher matcher2 = HTTP_DATE_ANSIC_PATTERN.matcher(str);
            if (!matcher2.find()) {
                throw new IllegalArgumentException();
            }
            month = getMonth(matcher2.group(1));
            date = getDate(matcher2.group(2));
            time = getTime(matcher2.group(3));
            year = getYear(matcher2.group(4));
        }
        int i = month;
        int i2 = year;
        if (year >= 2038) {
            i2 = 2038;
            i = 0;
            date = 1;
        }
        Time time2 = new Time("UTC");
        time2.set(time.second, time.minute, time.hour, date, i, i2);
        return time2.toMillis(false);
    }
}
