package com.blued.android.module.common.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.anythink.expressad.d.a.b;
import com.blued.android.core.AppInfo;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.R;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.igexin.push.config.c;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/TimeAndDateUtils.class */
public class TimeAndDateUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal<SimpleDateFormat> f10913a = new ThreadLocal<SimpleDateFormat>() { // from class: com.blued.android.module.common.utils.TimeAndDateUtils.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd", BlueAppLocal.c());
        }
    };
    public static final ThreadLocal<SimpleDateFormat> b = new ThreadLocal<SimpleDateFormat>() { // from class: com.blued.android.module.common.utils.TimeAndDateUtils.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy", BlueAppLocal.c());
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public static final ThreadLocal<SimpleDateFormat> f10914c = new ThreadLocal<SimpleDateFormat>() { // from class: com.blued.android.module.common.utils.TimeAndDateUtils.3
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("HH:mm:ss", BlueAppLocal.c());
        }
    };
    public static final ThreadLocal<SimpleDateFormat> d = new ThreadLocal<SimpleDateFormat>() { // from class: com.blued.android.module.common.utils.TimeAndDateUtils.4
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("MM-dd HH:mm", BlueAppLocal.c());
        }
    };
    public static final ThreadLocal<SimpleDateFormat> e = new ThreadLocal<SimpleDateFormat>() { // from class: com.blued.android.module.common.utils.TimeAndDateUtils.5
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm", BlueAppLocal.c());
        }
    };
    public static final ThreadLocal<SimpleDateFormat> f = new ThreadLocal<SimpleDateFormat>() { // from class: com.blued.android.module.common.utils.TimeAndDateUtils.6
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("HH:mm", BlueAppLocal.c());
        }
    };
    public static final ThreadLocal<SimpleDateFormat> g = new ThreadLocal<SimpleDateFormat>() { // from class: com.blued.android.module.common.utils.TimeAndDateUtils.7
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("MM-dd", BlueAppLocal.c());
        }
    };
    public static final ThreadLocal<SimpleDateFormat> h = new ThreadLocal<SimpleDateFormat>() { // from class: com.blued.android.module.common.utils.TimeAndDateUtils.8
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("MM-dd HH:mm", BlueAppLocal.c());
        }
    };
    public static final ThreadLocal<SimpleDateFormat> i = new ThreadLocal<SimpleDateFormat>() { // from class: com.blued.android.module.common.utils.TimeAndDateUtils.9
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", BlueAppLocal.c());
        }
    };
    public static final ThreadLocal<SimpleDateFormat> j = new ThreadLocal<SimpleDateFormat>() { // from class: com.blued.android.module.common.utils.TimeAndDateUtils.10
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy/MM/dd", BlueAppLocal.c());
        }
    };
    public static final ThreadLocal<SimpleDateFormat> k = new ThreadLocal<SimpleDateFormat>() { // from class: com.blued.android.module.common.utils.TimeAndDateUtils.11
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("mm:ss", BlueAppLocal.c());
        }
    };
    public static final ThreadLocal<SimpleDateFormat> l = new ThreadLocal<SimpleDateFormat>() { // from class: com.blued.android.module.common.utils.TimeAndDateUtils.12
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy.MM.dd HH:mm", BlueAppLocal.c());
        }
    };
    public static final ThreadLocal<SimpleDateFormat> m = new ThreadLocal<SimpleDateFormat>() { // from class: com.blued.android.module.common.utils.TimeAndDateUtils.13
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy.MM.dd", BlueAppLocal.c());
        }
    };

    public static int a(long j2, long j3) {
        int i2;
        int i3;
        int i4;
        int i5;
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTimeInMillis(j2);
        calendar2.setTimeInMillis(j3);
        int i6 = calendar.get(6);
        int i7 = calendar2.get(6);
        int i8 = calendar.get(1);
        int i9 = calendar2.get(1);
        if (i8 > i9) {
            i2 = i9;
            i9 = i8;
            i3 = i7;
        } else {
            i2 = i8;
            i6 = i7;
            i3 = i6;
        }
        if (i2 == i9) {
            return Math.abs(i6 - i3);
        }
        int i10 = 0;
        for (int i11 = i2; i11 < i9; i11++) {
            if ((i11 % 4 != 0 || i11 % 100 == 0) && i11 % 400 != 0) {
                i4 = i10;
                i5 = 365;
            } else {
                i4 = i10;
                i5 = 366;
            }
            i10 = i4 + i5;
        }
        return i10 + (i6 - i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0063, code lost:
        if (r0 < r0) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(java.util.Date r4) {
        /*
            r0 = r4
            if (r0 != 0) goto L6
            r0 = 0
            return r0
        L6:
            java.util.Calendar r0 = java.util.Calendar.getInstance()     // Catch: java.lang.Exception -> L73
            r11 = r0
            r0 = r11
            r1 = r4
            boolean r0 = r0.before(r1)     // Catch: java.lang.Exception -> L73
            if (r0 != 0) goto L69
            r0 = r11
            r1 = 1
            int r0 = r0.get(r1)     // Catch: java.lang.Exception -> L73
            r5 = r0
            r0 = r11
            r1 = 2
            int r0 = r0.get(r1)     // Catch: java.lang.Exception -> L73
            r1 = 1
            int r0 = r0 + r1
            r7 = r0
            r0 = r11
            r1 = 5
            int r0 = r0.get(r1)     // Catch: java.lang.Exception -> L73
            r8 = r0
            r0 = r11
            r1 = r4
            r0.setTime(r1)     // Catch: java.lang.Exception -> L73
            r0 = r11
            r1 = 1
            int r0 = r0.get(r1)     // Catch: java.lang.Exception -> L73
            r6 = r0
            r0 = r11
            r1 = 2
            int r0 = r0.get(r1)     // Catch: java.lang.Exception -> L73
            r1 = 1
            int r0 = r0 + r1
            r9 = r0
            r0 = r11
            r1 = 5
            int r0 = r0.get(r1)     // Catch: java.lang.Exception -> L73
            r10 = r0
            r0 = r5
            r1 = r6
            int r0 = r0 - r1
            r6 = r0
            r0 = r6
            r5 = r0
            r0 = r7
            r1 = r9
            if (r0 > r1) goto L7e
            r0 = r7
            r1 = r9
            if (r0 != r1) goto L7a
            r0 = r6
            r5 = r0
            r0 = r8
            r1 = r10
            if (r0 >= r1) goto L7e
            goto L7a
        L69:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch: java.lang.Exception -> L73
            r1 = r0
            java.lang.String r2 = "The birthDay is before Now.It's unbelievable!"
            r1.<init>(r2)     // Catch: java.lang.Exception -> L73
            throw r0     // Catch: java.lang.Exception -> L73
        L73:
            r4 = move-exception
            r0 = r4
            r0.printStackTrace()
            r0 = 0
            return r0
        L7a:
            r0 = r6
            r1 = 1
            int r0 = r0 - r1
            r5 = r0
        L7e:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.utils.TimeAndDateUtils.a(java.util.Date):int");
    }

    public static long a() {
        return a(System.currentTimeMillis());
    }

    public static long a(long j2) {
        Date date = new Date(j2);
        return (date.getYear() * 10000) + ((date.getMonth() + 1) * 100) + date.getDate();
    }

    public static String a(long j2, boolean z) {
        StringBuilder sb;
        StringBuilder sb2;
        String str;
        StringBuilder sb3;
        long j3 = j2 / b.P;
        if (j3 > 9) {
            sb = new StringBuilder();
            sb.append(j3);
            sb.append("");
        } else {
            sb = new StringBuilder();
            sb.append("0");
            sb.append(j3);
        }
        String sb4 = sb.toString();
        long j4 = j2 % b.P;
        long j5 = j4 / 60;
        if (j5 > 9) {
            sb2 = new StringBuilder();
            sb2.append(j5);
            sb2.append("");
        } else {
            sb2 = new StringBuilder();
            sb2.append("0");
            sb2.append(j5);
        }
        String sb5 = sb2.toString();
        long j6 = j4 % 60;
        if (j6 > 9) {
            str = j6 + "";
        } else {
            str = "0" + j6;
        }
        if (z || j2 >= b.P) {
            sb3 = new StringBuilder();
            sb3.append(sb4);
            sb3.append(":");
        } else {
            sb3 = new StringBuilder();
        }
        sb3.append(sb5);
        sb3.append(":");
        sb3.append(str);
        return sb3.toString();
    }

    public static String a(Context context, long j2) {
        StringBuffer stringBuffer = new StringBuffer();
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = currentTimeMillis - j2;
        long j4 = j3 / 86400000;
        long j5 = (j3 / 3600000) - (24 * j4);
        if (j3 <= 0) {
            return "";
        }
        if (j3 <= 60000) {
            stringBuffer.append(context.getResources().getString(R.string.now));
        } else if (j3 < 3600000) {
            if (j3 < c.l) {
                String string = context.getResources().getString(R.string.befor_minute_single);
                stringBuffer.append(String.format(string, ((j3 / 60) / 1000) + ""));
            } else {
                String string2 = context.getResources().getString(R.string.befor_minute);
                stringBuffer.append(String.format(string2, ((j3 / 60) / 1000) + ""));
            }
        } else if (j3 >= 86400000) {
            Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
            calendar.setTimeInMillis(currentTimeMillis);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            long timeInMillis = calendar.getTimeInMillis();
            calendar.set(6, 1);
            calendar.setTimeInMillis(j2);
            if (j2 > timeInMillis - 86400000) {
                stringBuffer.append(context.getResources().getString(R.string.yesterday));
            } else if (j4 < 8) {
                String string3 = context.getResources().getString(R.string.befor_day);
                stringBuffer.append(String.format(string3, j4 + ""));
            } else if (BlueAppLocal.d()) {
                if (g(j2)) {
                    stringBuffer.append(new SimpleDateFormat("MM-dd HH:mm", BlueAppLocal.c()).format(calendar.getTime()));
                } else {
                    stringBuffer.append(new SimpleDateFormat("yyyy-MM-dd HH:mm", BlueAppLocal.c()).format(calendar.getTime()));
                }
            } else if (g(j2)) {
                stringBuffer.append(new SimpleDateFormat("MMM dd HH:mm", Locale.ENGLISH).format(calendar.getTime()));
            } else {
                stringBuffer.append(new SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.ENGLISH).format(calendar.getTime()));
            }
        } else if (j3 < 7200000) {
            String string4 = context.getResources().getString(R.string.befor_hour_single);
            stringBuffer.append(String.format(string4, j5 + ""));
        } else {
            String string5 = context.getResources().getString(R.string.befor_hour);
            stringBuffer.append(String.format(string5, j5 + ""));
        }
        return stringBuffer.toString();
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new SimpleDateFormat("HH:mm:ss", BlueAppLocal.c()).format(Long.valueOf(Long.parseLong(str) * 1000));
        } catch (Exception e2) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
        if (r7.isEmpty() != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r6, java.lang.String r7) {
        /*
            r0 = r6
            if (r0 == 0) goto L5b
            r0 = r6
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L5b
            r0 = r6
            java.lang.String r1 = "null"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L18
            goto L5b
        L18:
            r0 = r7
            if (r0 == 0) goto L25
            r0 = r7
            r8 = r0
            r0 = r7
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L29
        L25:
            java.lang.String r0 = "yyyy-MM-dd HH:mm"
            r8 = r0
        L29:
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
            long r3 = java.lang.Long.parseLong(r3)
            r2.<init>(r3)
            java.lang.String r0 = r0.format(r1)
            return r0
        L5b:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.utils.TimeAndDateUtils.a(java.lang.String, java.lang.String):java.lang.String");
    }

    public static String a(String str, boolean z) {
        return b(CommonStringUtils.c(str) * 1000, z);
    }

    public static boolean a(long j2, long j3, int i2) {
        return i2 > 0 && j3 - j2 > (((((long) i2) * 60) * 60) * 24) * 1000;
    }

    public static long b() {
        Date date = new Date(System.currentTimeMillis());
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setFirstDayOfWeek(2);
        gregorianCalendar.setTime(date);
        return (date.getYear() * 10000) + gregorianCalendar.get(3);
    }

    public static String b(long j2) {
        StringBuffer stringBuffer = new StringBuffer();
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTimeInMillis(j2);
        if (BlueAppLocal.d()) {
            stringBuffer.append(new SimpleDateFormat("yyyy-MM-dd HH:mm", BlueAppLocal.c()).format(calendar.getTime()));
        } else {
            stringBuffer.append(new SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.ENGLISH).format(calendar.getTime()));
        }
        return stringBuffer.toString();
    }

    public static String b(long j2, boolean z) {
        new StringBuffer();
        long currentTimeMillis = System.currentTimeMillis() - j2;
        long j3 = (currentTimeMillis / 3600000) - ((currentTimeMillis / 86400000) * 24);
        Resources resources = AppInfo.d().getResources();
        return currentTimeMillis < 3600000 ? z ? String.format(resources.getString(R.string.sign_feed_update_time_mins), String.valueOf(Math.max((currentTimeMillis / 60) / 1000, 1L))) : String.format(resources.getString(R.string.befor_minute_single), String.valueOf(Math.max((currentTimeMillis / 60) / 1000, 1L))) : currentTimeMillis < 86400000 ? z ? String.format(resources.getString(R.string.sign_feed_update_time_hours), String.valueOf(Math.max(j3, 1L))) : String.format(resources.getString(R.string.befor_hour_single), String.valueOf(Math.max(j3, 1L))) : !z ? new SimpleDateFormat("MM-dd", BlueAppLocal.c()).format(new Date(j2)) : "";
    }

    public static String b(Context context, long j2) {
        StringBuffer stringBuffer = new StringBuffer();
        long currentTimeMillis = System.currentTimeMillis() - j2;
        long j3 = (currentTimeMillis / 3600000) - ((currentTimeMillis / 86400000) * 24);
        if (currentTimeMillis <= 60000) {
            stringBuffer.append(context.getResources().getString(R.string.now));
        } else if (currentTimeMillis < 3600000) {
            if (currentTimeMillis < c.l) {
                String string = context.getResources().getString(R.string.befor_minute_single);
                stringBuffer.append(String.format(string, ((currentTimeMillis / 60) / 1000) + ""));
            } else {
                String string2 = context.getResources().getString(R.string.befor_minute);
                stringBuffer.append(String.format(string2, ((currentTimeMillis / 60) / 1000) + ""));
            }
        } else if (currentTimeMillis >= 86400000) {
            stringBuffer.append("");
        } else if (currentTimeMillis < 7200000) {
            String string3 = context.getResources().getString(R.string.befor_hour_single);
            stringBuffer.append(String.format(string3, j3 + ""));
        } else {
            String string4 = context.getResources().getString(R.string.befor_hour);
            stringBuffer.append(String.format(string4, j3 + ""));
        }
        return stringBuffer.toString();
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return (BlueAppLocal.d() ? new SimpleDateFormat("yyyy-MM-dd", BlueAppLocal.c()) : new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH)).format(Long.valueOf(Long.parseLong(str) * 1000));
        } catch (Exception e2) {
            return null;
        }
    }

    public static String b(String str, String str2) {
        try {
            return String.valueOf(new SimpleDateFormat(str2).parse(str).getTime() / 1000);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static long c(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            return Long.parseLong(str) * 1000;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static String c() {
        Date date = new Date();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        return new SimpleDateFormat("yyyy.MM.dd", BlueAppLocal.c()).format(gregorianCalendar.getTime());
    }

    public static String c(long j2) {
        StringBuffer stringBuffer = new StringBuffer();
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTimeInMillis(j2);
        if (BlueAppLocal.d()) {
            stringBuffer.append(new SimpleDateFormat("yyyy-MM-dd", BlueAppLocal.c()).format(calendar.getTime()));
        } else {
            stringBuffer.append(new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH).format(calendar.getTime()));
        }
        return stringBuffer.toString();
    }

    public static String c(long j2, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTimeInMillis(j2);
        if (g(j2) || z) {
            stringBuffer.append(new SimpleDateFormat("M月d日", BlueAppLocal.c()).format(calendar.getTime()));
        } else {
            stringBuffer.append(new SimpleDateFormat("yyyy年M月d日", BlueAppLocal.c()).format(calendar.getTime()));
        }
        return stringBuffer.toString();
    }

    public static String c(Context context, long j2) {
        StringBuffer stringBuffer = new StringBuffer();
        String b2 = b(context, j2);
        if (TextUtils.isEmpty(b2)) {
            Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(6, 1);
            calendar.setTimeInMillis(j2);
            if (BlueAppLocal.d()) {
                if (g(j2)) {
                    stringBuffer.append(new SimpleDateFormat("MM-dd", BlueAppLocal.c()).format(calendar.getTime()));
                } else {
                    stringBuffer.append(new SimpleDateFormat("yyyy-MM-dd", BlueAppLocal.c()).format(calendar.getTime()));
                }
            } else if (g(j2)) {
                stringBuffer.append(new SimpleDateFormat("MMM dd", Locale.ENGLISH).format(calendar.getTime()));
            } else {
                stringBuffer.append(new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH).format(calendar.getTime()));
            }
        } else {
            stringBuffer.append(b2);
        }
        return stringBuffer.toString();
    }

    public static Date c(String str, String str2) {
        try {
            return new SimpleDateFormat(str2).parse(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Long d() {
        Calendar calendar;
        Calendar.getInstance().setTime(new Date());
        String str = calendar.get(5) + "";
        String str2 = (calendar.get(2) + 1) + "";
        return Long.valueOf(StringUtils.a((calendar.get(1) + "") + str2 + str, 0L));
    }

    public static String d(long j2) {
        StringBuffer stringBuffer = new StringBuffer();
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTimeInMillis(j2);
        if (BlueAppLocal.d()) {
            stringBuffer.append(new SimpleDateFormat("yyyy年MM月dd日", BlueAppLocal.c()).format(calendar.getTime()));
        } else {
            stringBuffer.append(new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH).format(calendar.getTime()));
        }
        return stringBuffer.toString();
    }

    public static String d(Context context, long j2) {
        StringBuffer stringBuffer = new StringBuffer();
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(6, 1);
        calendar.setTimeInMillis(j2);
        if (BlueAppLocal.d()) {
            stringBuffer.append(new SimpleDateFormat("MM-dd HH:mm", BlueAppLocal.c()).format(calendar.getTime()));
        } else {
            stringBuffer.append(new SimpleDateFormat("MMM dd HH:mm", Locale.ENGLISH).format(calendar.getTime()));
        }
        return stringBuffer.toString();
    }

    public static String d(String str) {
        try {
            return String.valueOf(new SimpleDateFormat("yyyy年MM月").parse(str).getTime());
        } catch (Exception e2) {
            return null;
        }
    }

    public static boolean d(String str, String str2) {
        Date date;
        Date date2;
        Date date3;
        Date date4;
        Calendar calendar;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        try {
            date3 = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
            try {
                date = simpleDateFormat.parse(str);
            } catch (ParseException e2) {
                date = null;
                date2 = date3;
                e = e2;
            }
        } catch (ParseException e3) {
            e = e3;
            date = null;
            date2 = null;
        }
        try {
            date4 = simpleDateFormat.parse(str2);
        } catch (ParseException e4) {
            date2 = date3;
            e = e4;
            e.printStackTrace();
            date3 = date2;
            date4 = null;
            calendar = Calendar.getInstance();
            calendar.setTime(date3);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(date);
            Calendar calendar3 = Calendar.getInstance();
            calendar3.setTime(date4);
            return !calendar.after(calendar2) ? false : false;
        }
        calendar = Calendar.getInstance();
        calendar.setTime(date3);
        Calendar calendar22 = Calendar.getInstance();
        calendar22.setTime(date);
        Calendar calendar32 = Calendar.getInstance();
        calendar32.setTime(date4);
        if (!calendar.after(calendar22) && calendar.before(calendar32)) {
            return true;
        }
    }

    public static String e(long j2) {
        StringBuffer stringBuffer = new StringBuffer();
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTimeInMillis(j2);
        if (BlueAppLocal.d()) {
            if (g(j2)) {
                stringBuffer.append(new SimpleDateFormat("MM-dd", BlueAppLocal.c()).format(calendar.getTime()));
            } else {
                stringBuffer.append(new SimpleDateFormat("yyyy-MM-dd", BlueAppLocal.c()).format(calendar.getTime()));
            }
        } else if (g(j2)) {
            stringBuffer.append(new SimpleDateFormat("MMM dd", Locale.ENGLISH).format(calendar.getTime()));
        } else {
            stringBuffer.append(new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH).format(calendar.getTime()));
        }
        return stringBuffer.toString();
    }

    public static String e(Context context, long j2) {
        StringBuffer stringBuffer = new StringBuffer();
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(6, 1);
        calendar.setTimeInMillis(j2);
        if (BlueAppLocal.d()) {
            if (g(j2)) {
                stringBuffer.append(new SimpleDateFormat("MM-dd HH:mm", BlueAppLocal.c()).format(calendar.getTime()));
            } else {
                stringBuffer.append(new SimpleDateFormat("yyyy-MM-dd HH:mm", BlueAppLocal.c()).format(calendar.getTime()));
            }
        } else if (g(j2)) {
            stringBuffer.append(new SimpleDateFormat("MMM dd HH:mm", Locale.ENGLISH).format(calendar.getTime()));
        } else {
            stringBuffer.append(new SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.ENGLISH).format(calendar.getTime()));
        }
        return stringBuffer.toString();
    }

    public static String e(String str) {
        return (BlueAppLocal.d() ? new SimpleDateFormat("yyyy年MM月", BlueAppLocal.c()) : new SimpleDateFormat("MMM. yyyy", Locale.ENGLISH)).format(new Date(Long.valueOf(str).longValue()));
    }

    public static String f(Context context, long j2) {
        StringBuffer stringBuffer = new StringBuffer();
        long abs = Math.abs(System.currentTimeMillis() - j2);
        long j3 = abs / 86400000;
        long j4 = abs / 3600000;
        long j5 = 24 * j3;
        long j6 = j4 - j5;
        long j7 = abs / 60000;
        long j8 = j5 * 60;
        long j9 = j6 * 60;
        long j10 = (((abs / 1000) - (j8 * 60)) - (j9 * 60)) - (((j7 - j8) - j9) * 60);
        if (context != null) {
            if (abs < 60000) {
                if (abs < 2000) {
                    String string = context.getResources().getString(R.string.befor_second_single);
                    stringBuffer.append(String.format(string, j10 + ""));
                } else {
                    String string2 = context.getResources().getString(R.string.befor_second);
                    stringBuffer.append(String.format(string2, j10 + ""));
                }
            } else if (abs < 3600000) {
                if (abs < c.l) {
                    String string3 = context.getResources().getString(R.string.befor_minute_single);
                    stringBuffer.append(String.format(string3, ((abs / 60) / 1000) + ""));
                } else {
                    String string4 = context.getResources().getString(R.string.befor_minute);
                    stringBuffer.append(String.format(string4, ((abs / 60) / 1000) + ""));
                }
            } else if (abs < 86400000) {
                if (abs < 7200000) {
                    String string5 = context.getResources().getString(R.string.befor_hour_single);
                    stringBuffer.append(String.format(string5, j6 + ""));
                } else {
                    String string6 = context.getResources().getString(R.string.befor_hour);
                    stringBuffer.append(String.format(string6, j6 + ""));
                }
            } else if (j3 == 1) {
                String string7 = context.getResources().getString(R.string.befor_day_single);
                stringBuffer.append(String.format(string7, j3 + ""));
            } else if (j3 <= 30) {
                String string8 = context.getResources().getString(R.string.befor_day);
                stringBuffer.append(String.format(string8, j3 + ""));
            } else {
                stringBuffer.append(String.format(context.getResources().getString(R.string.befor_day), BaseWrapper.ENTER_ID_TOOLKIT));
            }
            return stringBuffer.toString();
        }
        return "";
    }

    public static String f(String str) {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm", BlueAppLocal.c()).format(new Date(Long.valueOf(str).longValue() * 1000));
    }

    public static boolean f(long j2) {
        return f10913a.get().format(new Date()).equals(f10913a.get().format(new Date(j2)));
    }

    public static String g(Context context, long j2) {
        StringBuffer stringBuffer = new StringBuffer();
        long currentTimeMillis = System.currentTimeMillis() - j2;
        long j3 = currentTimeMillis / 86400000;
        long j4 = currentTimeMillis / 3600000;
        long j5 = 24 * j3;
        long j6 = j4 - j5;
        long j7 = currentTimeMillis / 60000;
        long j8 = j5 * 60;
        long j9 = j6 * 60;
        long j10 = (((currentTimeMillis / 1000) - (j8 * 60)) - (j9 * 60)) - (((j7 - j8) - j9) * 60);
        if (currentTimeMillis < 60000) {
            if (j10 < 0) {
                j10 = 0;
            }
            if (currentTimeMillis < 2000) {
                stringBuffer.append(String.format(context.getResources().getString(R.string.befor_second_single), j10 + ""));
            } else {
                stringBuffer.append(String.format(context.getResources().getString(R.string.befor_second), j10 + ""));
            }
        } else if (currentTimeMillis < 3600000) {
            if (currentTimeMillis < c.l) {
                stringBuffer.append(String.format(context.getResources().getString(R.string.befor_minute_single), ((currentTimeMillis / 60) / 1000) + ""));
            } else {
                stringBuffer.append(String.format(context.getResources().getString(R.string.befor_minute), ((currentTimeMillis / 60) / 1000) + ""));
            }
        } else if (currentTimeMillis < 86400000) {
            if (currentTimeMillis < 7200000) {
                stringBuffer.append(String.format(context.getResources().getString(R.string.befor_hour_single), j6 + ""));
            } else {
                stringBuffer.append(String.format(context.getResources().getString(R.string.befor_hour), j6 + ""));
            }
        } else if (j3 == 1) {
            stringBuffer.append(String.format(context.getResources().getString(R.string.befor_day_single), j3 + ""));
        } else if (j3 >= 30) {
            int floor = (int) Math.floor(((float) j3) / 30.0f);
            if (floor == 1) {
                stringBuffer.append(String.format(context.getResources().getString(R.string.befor_month_single), floor + ""));
            } else if (floor < 12) {
                stringBuffer.append(String.format(context.getResources().getString(R.string.befor_month), floor + ""));
            } else if (floor == 12) {
                stringBuffer.append(String.format(context.getResources().getString(R.string.before_year_single), Math.ceil(floor / 12.0d) + ""));
            } else {
                stringBuffer.append(String.format(context.getResources().getString(R.string.before_years), Math.ceil(floor / 12.0d) + ""));
            }
        } else {
            stringBuffer.append(String.format(context.getResources().getString(R.string.befor_day), j3 + ""));
        }
        return stringBuffer.toString();
    }

    public static String g(String str) {
        return new SimpleDateFormat("yyyy/MM/dd", BlueAppLocal.c()).format(new Date(Long.valueOf(str).longValue() * 1000));
    }

    public static boolean g(long j2) {
        return b.get().format(new Date()).equals(b.get().format(new Date(j2)));
    }

    public static String h(Context context, long j2) {
        StringBuffer stringBuffer = new StringBuffer();
        long abs = Math.abs(System.currentTimeMillis() - j2);
        long j3 = abs / 86400000;
        long j4 = (abs / 3600000) - (24 * j3);
        long j5 = abs / 60000;
        long j6 = abs / 1000;
        if (context != null) {
            if (abs < 3600000) {
                if (abs < 60000) {
                    stringBuffer.append(context.getResources().getString(R.string.now));
                } else if (abs < c.l) {
                    String string = context.getResources().getString(R.string.befor_minute_single);
                    stringBuffer.append(String.format(string, (((abs / 60) / 1000) + 1) + ""));
                } else {
                    String string2 = context.getResources().getString(R.string.befor_minute);
                    stringBuffer.append(String.format(string2, ((abs / 60) / 1000) + ""));
                }
            } else if (abs < 86400000) {
                if (abs < 7200000) {
                    String string3 = context.getResources().getString(R.string.befor_hour_single);
                    stringBuffer.append(String.format(string3, j4 + ""));
                } else {
                    String string4 = context.getResources().getString(R.string.befor_hour);
                    stringBuffer.append(String.format(string4, j4 + ""));
                }
            } else if (j3 == 1) {
                String string5 = context.getResources().getString(R.string.befor_day_single);
                stringBuffer.append(String.format(string5, j3 + ""));
            } else if (j3 > 7) {
                return e(j2);
            } else {
                String string6 = context.getResources().getString(R.string.befor_day);
                stringBuffer.append(String.format(string6, j3 + ""));
            }
            return stringBuffer.toString();
        }
        return "";
    }

    public static boolean h(long j2) {
        Date date = new Date(j2);
        Date date2 = new Date();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date2);
        gregorianCalendar.add(5, -1);
        return f10913a.get().format(date).equals(f10913a.get().format(gregorianCalendar.getTime()));
    }

    public static long i(long j2) {
        if (j2 == 0) {
            return 0L;
        }
        try {
            return j2 / 1000;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static long j(long j2) {
        if (j2 == 0) {
            return 0L;
        }
        return j2 * 1000;
    }
}
