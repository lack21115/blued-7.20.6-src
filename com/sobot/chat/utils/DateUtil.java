package com.sobot.chat.utils;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.sobot.chat.application.MyApplication;
import com.sobot.chat.widget.timePicker.SobotTimePickerView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/DateUtil.class */
public class DateUtil {
    public static final SimpleDateFormat DATE_FORMAT0 = new SimpleDateFormat("HH:mm", Locale.getDefault());
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    public static final SimpleDateFormat DATE_FORMAT2 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    public static final SimpleDateFormat DATE_FORMAT3 = new SimpleDateFormat("HH:mm", Locale.getDefault());
    public static final SimpleDateFormat DATE_FORMAT4 = new SimpleDateFormat("mm:ss", Locale.getDefault());
    public static final SimpleDateFormat DATE_FORMAT5 = new SimpleDateFormat("MM月dd日", Locale.getDefault());
    public static final SimpleDateFormat DATE_FORMAT6 = new SimpleDateFormat("MM-dd", Locale.getDefault());
    public static String YEAR_DATE_FORMAT = "yyyy-MM-dd";
    public static String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static String DATE_FORMAT_CHINESE = "yyyy年M月d日";

    public static String bjToLocal(long j, String str, Boolean bool) {
        Date date;
        Date date2;
        if (!bool.booleanValue()) {
            try {
                return dateToString(new SimpleDateFormat(str).parse(longToDateStr(Long.valueOf(j), "yyyy-MM-dd HH:mm:ss")), str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        try {
            date = simpleDateFormat.parse(longToDateStr(Long.valueOf(j), "yyyy-MM-dd HH:mm:ss"));
        } catch (ParseException e2) {
            e2.printStackTrace();
            date = null;
        }
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        try {
            date2 = simpleDateFormat.parse(simpleDateFormat.format(Long.valueOf(date.getTime())));
        } catch (ParseException e3) {
            e3.printStackTrace();
            date2 = null;
        }
        return dateToString(date2, str);
    }

    public static String bjToLocal(String str, String str2, Boolean bool) {
        Date date;
        Date date2;
        if (!bool.booleanValue()) {
            new SimpleDateFormat(str2);
            try {
                return dateToString(stringToDate(str, "yyyy-MM-dd HH:mm:ss"), str2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e2) {
            e2.printStackTrace();
            date = null;
        }
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        try {
            date2 = simpleDateFormat.parse(simpleDateFormat.format(Long.valueOf(date.getTime())));
        } catch (ParseException e3) {
            e3.printStackTrace();
            date2 = null;
        }
        return dateToString(date2, str2);
    }

    public static String dateToDateTime(Date date) {
        return new SimpleDateFormat(DATE_TIME_FORMAT).format(date);
    }

    public static String dateToString(Date date) {
        return new SimpleDateFormat(YEAR_DATE_FORMAT).format(date);
    }

    public static String dateToString(Date date, String str) {
        return new SimpleDateFormat(str).format(date);
    }

    public static String formatDateTime(String str, Boolean bool) {
        return formatDateTime(str, false, "", bool);
    }

    public static String formatDateTime(String str, boolean z, String str2, Boolean bool) {
        if (str == null || "".equals(str) || str.length() < 19) {
            return "";
        }
        String bjToLocal = bjToLocal(str, "yyyy-MM-dd HH:mm:ss", bool);
        Date date = null;
        try {
            date = DATE_FORMAT.parse(bjToLocal);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getDefault());
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeZone(TimeZone.getDefault());
        calendar2.set(1, calendar.get(1));
        calendar2.set(2, calendar.get(2));
        calendar2.set(5, calendar.get(5));
        calendar2.set(11, 0);
        calendar2.set(12, 0);
        calendar2.set(13, 0);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTimeZone(TimeZone.getDefault());
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
            int indexOf = bjToLocal.indexOf("-") + 1;
            return z ? bjToLocal.substring(indexOf, bjToLocal.length()).substring(0, 11) : bjToLocal.substring(indexOf, bjToLocal.length()).substring(0, 5);
        }
        return str2 + " " + bjToLocal.split(" ")[1].substring(0, 5);
    }

    public static String formatDateTime2(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.set(11, 0);
            calendar2.set(12, 0);
            calendar2.set(13, 0);
            calendar.setTime(new Date(Long.parseLong(str)));
            return calendar.before(calendar2) ? toDate(Long.parseLong(str), DATE_FORMAT5) : toDate(Long.parseLong(str), DATE_FORMAT3);
        } catch (Exception e) {
            return "";
        }
    }

    public static String getCurrentDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YEAR_DATE_FORMAT);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        return simpleDateFormat.format(new Date());
    }

    public static String getCurrentDateTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TIME_FORMAT);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        return simpleDateFormat.format(new Date());
    }

    public static String getCurrentDateTime(String str) {
        return new SimpleDateFormat(str).format(new Date());
    }

    public static String getCurrentTime() {
        return toDate(System.currentTimeMillis(), DATE_FORMAT);
    }

    public static int getDayOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(5);
    }

    public static int getMonthOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(2) + 1;
    }

    public static String getStandardDate(String str, Boolean bool) {
        StringBuffer stringBuffer = new StringBuffer();
        long currentTimeMillis = System.currentTimeMillis() - (Long.parseLong(str) * 1000);
        long ceil = (long) Math.ceil(currentTimeMillis / 1000);
        long j = currentTimeMillis / 60;
        long ceil2 = (long) Math.ceil(((float) j) / 1000.0f);
        long ceil3 = (long) Math.ceil(((float) (j / 60)) / 1000.0f);
        long ceil4 = (long) Math.ceil(((float) (((currentTimeMillis / 24) / 60) / 60)) / 1000.0f);
        int i = (ceil4 > 7L ? 1 : (ceil4 == 7L ? 0 : -1));
        if (i > 0) {
            stringBuffer.append(timeStamp2Date(str, "yyyy-MM-dd", bool));
            return stringBuffer.toString();
        }
        if (ceil4 > 1 && i <= 0) {
            stringBuffer.append(ceil4 + ResourceUtils.getResString(MyApplication.getInstance(), "sobot_time_unit_day"));
        } else if (ceil3 - 1 > 0) {
            if (ceil3 >= 24) {
                stringBuffer.append("1");
                stringBuffer.append(ResourceUtils.getResString(MyApplication.getInstance(), "sobot_time_unit_day"));
            } else {
                stringBuffer.append(ceil3 + ResourceUtils.getResString(MyApplication.getInstance(), "sobot_time_unit_hours"));
            }
        } else if (ceil2 - 1 > 0) {
            if (ceil2 == 60) {
                stringBuffer.append("1");
                stringBuffer.append(ResourceUtils.getResString(MyApplication.getInstance(), "sobot_time_unit_hours"));
            } else {
                stringBuffer.append(ceil2 + ResourceUtils.getResString(MyApplication.getInstance(), "sobot_time_unit_minute"));
            }
        } else if (ceil - 1 <= 0) {
            stringBuffer.append(ResourceUtils.getResString(MyApplication.getInstance(), "sobot_time_unit_just_now"));
        } else if (ceil == 60) {
            stringBuffer.append("1");
            stringBuffer.append(ResourceUtils.getResString(MyApplication.getInstance(), "sobot_time_unit_minute"));
        } else {
            stringBuffer.append(ceil + ResourceUtils.getResString(MyApplication.getInstance(), "sobot_time_unit_second"));
        }
        if (!stringBuffer.toString().equals(ResourceUtils.getResString(MyApplication.getInstance(), "sobot_time_unit_just_now"))) {
            stringBuffer.append(ResourceUtils.getResString(MyApplication.getInstance(), "sobot_time_unit_befor"));
        }
        return stringBuffer.toString();
    }

    public static int getWeekOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(7) - 1;
    }

    public static int getYearOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(1);
    }

    public static String longToDateStr(Long l, String str) {
        return new SimpleDateFormat(str).format(new Date(l.longValue()));
    }

    public static void main(String[] strArr) {
    }

    public static void openTimePickerView(final Context context, final View view, View view2, Date date, final int i) {
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        boolean[] zArr = new boolean[6];
        if (i == 0) {
            zArr[0] = true;
            zArr[1] = true;
            zArr[2] = true;
            zArr[3] = false;
            zArr[4] = false;
            zArr[5] = false;
        } else {
            zArr[0] = false;
            zArr[1] = false;
            zArr[2] = false;
            zArr[3] = true;
            zArr[4] = true;
            zArr[5] = false;
        }
        new SobotTimePickerView.Builder(context, new SobotTimePickerView.OnTimeSelectListener() { // from class: com.sobot.chat.utils.DateUtil.1
            @Override // com.sobot.chat.widget.timePicker.SobotTimePickerView.OnTimeSelectListener
            public void onTimeSelect(Date date2, View view3) {
                if (view3 == null || !(view3 instanceof TextView) || date2 == null) {
                    return;
                }
                ((TextView) view3).setText((i == 0 ? DateUtil.DATE_FORMAT2 : DateUtil.DATE_FORMAT0).format(date2));
                TextView textView = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "work_order_customer_field_text_lable"));
                ((LinearLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "work_order_customer_field_ll"))).setVisibility(0);
                Context context2 = context;
                textView.setTextColor(ContextCompat.getColor(context2, ResourceUtils.getResColorId(context2, "sobot_common_gray2")));
                textView.setTextSize(12.0f);
            }
        }).setType(zArr).setLabel("", "", "", "", "", "").isCenterLabel(false).setDividerColor(ResourceUtils.getResColorValue(context, "sobot_line_1dp")).setContentSize(17).setSubCalSize(17).setTitleBgColor(ResourceUtils.getResColorValue(context, "sobot_common_gray6")).setTitleColor(ResourceUtils.getResColorValue(context, "sobot_common_gray1")).setTitleText(ResourceUtils.getResString(context, i == 0 ? "sobot_title_date" : "sobot_title_time")).setCancelColor(Color.parseColor("#0DAEAF")).setSubmitColor(Color.parseColor("#FFFFFFFF")).setTextColorOut(ResourceUtils.getResColorValue(context, "sobot_common_gray2")).setTextColorCenter(ResourceUtils.getResColorValue(context, "sobot_common_wenzi_black")).setDate(calendar).setBgColor(ResourceUtils.getResColorValue(context, "sobot_common_gray6")).setBackgroundId(Integer.MIN_VALUE).setDecorView(null).setLineSpacingMultiplier(2.0f).build().show(view2);
    }

    public static Date parse(String str, SimpleDateFormat simpleDateFormat) {
        try {
            return simpleDateFormat.parse(str);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static Date stringToDate(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        new Date();
        try {
            return new SimpleDateFormat(YEAR_DATE_FORMAT).parse(str);
        } catch (ParseException e) {
            return stringToDate(str, "yyyyMMdd");
        }
    }

    public static Date stringToDate(String str, String str2) {
        Date date = new Date();
        try {
            return new SimpleDateFormat(str2).parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return date;
        }
    }

    public static String stringToFormatString(String str, String str2, Boolean bool) {
        return bjToLocal(str, str2, bool);
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

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
        if (android.text.TextUtils.isEmpty(r6) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String timeStamp2Date(java.lang.String r5, java.lang.String r6, java.lang.Boolean r7) {
        /*
            r0 = r5
            if (r0 == 0) goto L4e
            r0 = r5
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L4e
            r0 = r5
            java.lang.String r1 = "null"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L18
            goto L4e
        L18:
            r0 = r6
            if (r0 == 0) goto L25
            r0 = r6
            r8 = r0
            r0 = r6
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L28
        L25:
            java.lang.String r0 = "yyyy-MM-dd HH:mm:ss"
            r8 = r0
        L28:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r6 = r0
            r0 = r6
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            java.lang.String r1 = "000"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            java.lang.String r0 = r0.toString()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            long r0 = r0.longValue()
            r1 = r8
            r2 = r7
            java.lang.String r0 = bjToLocal(r0, r1, r2)
            return r0
        L4e:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.utils.DateUtil.timeStamp2Date(java.lang.String, java.lang.String, java.lang.Boolean):java.lang.String");
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
