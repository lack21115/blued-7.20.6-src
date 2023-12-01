package com.blued.android.module.live.base.utils;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.expressad.d.a.b;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.module.live.base.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/utils/LiveTimeAndDateUtils.class */
public class LiveTimeAndDateUtils {
    public static long a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            return Long.parseLong(str) * 1000;
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static String a(long j) {
        StringBuffer stringBuffer = new StringBuffer();
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTimeInMillis(j);
        if (BlueAppLocal.d()) {
            stringBuffer.append(new SimpleDateFormat("yyyy-MM-dd", BlueAppLocal.c()).format(calendar.getTime()));
        } else {
            stringBuffer.append(new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH).format(calendar.getTime()));
        }
        return stringBuffer.toString();
    }

    public static String a(long j, boolean z) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        long j2 = j / b.P;
        if (j2 > 9) {
            sb = new StringBuilder();
            sb.append(j2);
            sb.append("");
        } else {
            sb = new StringBuilder();
            sb.append("0");
            sb.append(j2);
        }
        String sb5 = sb.toString();
        long j3 = j % b.P;
        long j4 = j3 / 60;
        if (j4 > 9) {
            sb2 = new StringBuilder();
            sb2.append(j4);
            sb2.append("");
        } else {
            sb2 = new StringBuilder();
            sb2.append("0");
            sb2.append(j4);
        }
        String sb6 = sb2.toString();
        long j5 = j3 % 60;
        if (j5 > 9) {
            sb3 = new StringBuilder();
            sb3.append(j5);
            sb3.append("");
        } else {
            sb3 = new StringBuilder();
            sb3.append("0");
            sb3.append(j5);
        }
        String sb7 = sb3.toString();
        if (z) {
            sb4 = new StringBuilder();
            sb4.append(sb5);
            sb4.append(":");
        } else {
            sb4 = new StringBuilder();
        }
        sb4.append(sb6);
        sb4.append(":");
        sb4.append(sb7);
        return sb4.toString();
    }

    public static String a(Context context, long j) {
        if (j > 1827590400000L) {
            return context.getString(R.string.never_expires);
        }
        StringBuffer stringBuffer = new StringBuffer();
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTimeInMillis(j);
        stringBuffer.append(context.getString(R.string.valid_to));
        if (BlueAppLocal.d()) {
            stringBuffer.append(new SimpleDateFormat("yyyy/MM/dd", BlueAppLocal.c()).format(calendar.getTime()));
        } else {
            stringBuffer.append(new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH).format(calendar.getTime()));
        }
        return stringBuffer.toString();
    }

    public static String b(long j) {
        StringBuffer stringBuffer = new StringBuffer();
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTimeInMillis(j);
        if (BlueAppLocal.d()) {
            stringBuffer.append(new SimpleDateFormat("yyyy.MM.dd", BlueAppLocal.c()).format(calendar.getTime()));
        } else {
            stringBuffer.append(new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH).format(calendar.getTime()));
        }
        return stringBuffer.toString();
    }

    public static String b(Context context, long j) {
        new StringBuffer();
        long currentTimeMillis = j - System.currentTimeMillis();
        if (currentTimeMillis <= 0) {
            return "已过期";
        }
        if (currentTimeMillis < 3600000) {
            return "1小时内到期";
        }
        if (currentTimeMillis < 86400000) {
            long j2 = currentTimeMillis / 3600000;
            return j2 + "小时后到期";
        }
        long j3 = currentTimeMillis / 86400000;
        return j3 + "天后到期";
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new SimpleDateFormat("HH:mm:ss", BlueAppLocal.c()).format(Long.valueOf(Long.parseLong(str) * 1000));
        } catch (Exception e) {
            return null;
        }
    }

    public static String c(long j) {
        StringBuffer stringBuffer = new StringBuffer();
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTimeInMillis(j);
        if (BlueAppLocal.d()) {
            stringBuffer.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", BlueAppLocal.c()).format(calendar.getTime()));
        } else {
            stringBuffer.append(new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH).format(calendar.getTime()));
        }
        return stringBuffer.toString();
    }

    public static String d(long j) {
        StringBuffer stringBuffer = new StringBuffer();
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTimeInMillis(j);
        stringBuffer.append(new SimpleDateFormat("yyyyMMdd", Locale.CHINA).format(calendar.getTime()));
        return stringBuffer.toString();
    }
}
