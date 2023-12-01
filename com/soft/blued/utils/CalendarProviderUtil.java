package com.soft.blued.utils;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.das.guy.GuyProtos;
import com.huawei.hms.ads.fw;
import com.soft.blued.log.track.EventTrackGuy;
import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/CalendarProviderUtil.class */
public class CalendarProviderUtil {

    /* renamed from: a  reason: collision with root package name */
    private static String f21036a = "content://com.android.calendar/calendars";
    private static String b = "content://com.android.calendar/events";

    /* renamed from: c  reason: collision with root package name */
    private static String f21037c = "content://com.android.calendar/reminders";
    private static String d = "BluedCalendars";
    private static String e = "BluedAccount";
    private static String f = "com.soft.blued";
    private static String g = "Blued";

    /* renamed from: com.soft.blued.utils.CalendarProviderUtil$2  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/CalendarProviderUtil$2.class */
    class AnonymousClass2 implements PermissionCallbacks {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f21040a;
        final /* synthetic */ String b;

        public void U_() {
            CalendarProviderUtil.a(this.f21040a, this.b);
        }

        public void a(String[] strArr) {
        }
    }

    private static int a(Context context) {
        int b2 = b(context);
        if (b2 >= 0) {
            return b2;
        }
        if (c(context) >= 0) {
            return b(context);
        }
        return -1;
    }

    public static void a(Context context, String str) {
        if (context == null) {
            return;
        }
        Cursor query = context.getContentResolver().query(Uri.parse(b), null, null, null, null);
        if (query == null) {
            if (query != null) {
                return;
            }
            return;
        }
        try {
            if (query.getCount() > 0) {
                query.moveToFirst();
                while (!query.isAfterLast()) {
                    String string = query.getString(query.getColumnIndex("title"));
                    if (!TextUtils.isEmpty(str) && str.equals(string)) {
                        if (context.getContentResolver().delete(ContentUris.withAppendedId(Uri.parse(b), query.getInt(query.getColumnIndex("_id"))), null, null) == -1) {
                            if (query != null) {
                                query.close();
                                return;
                            }
                            return;
                        }
                    }
                    query.moveToNext();
                }
            }
            if (query != null) {
                query.close();
            }
        } finally {
            if (query != null) {
                query.close();
            }
        }
    }

    public static void a(final Context context, final String str, final String str2, final long j, final long j2, final long j3, int i, int i2, int i3) {
        final StringBuilder sb = new StringBuilder();
        if (i == 1) {
            sb.append("FREQ=DAILY");
        } else if (i == 2) {
            sb.append("FREQ=WEEKLY");
        } else if (i == 3) {
            sb.append("FREQ=MONTHLY");
        } else if (i == 4) {
            sb.append("FREQ=YEARLY");
        }
        if (sb.length() > 0) {
            if (i2 > 0) {
                sb.append(";INTERVAL=");
                sb.append(i2);
            }
            if (i3 > 0) {
                sb.append(";COUNT=");
                sb.append(i3);
            }
        }
        PermissionUtils.a(new PermissionCallbacks() { // from class: com.soft.blued.utils.CalendarProviderUtil.1
            public void U_() {
                EventTrackGuy.b(GuyProtos.Event.CHECK_IN_REMIND_STATUS, true);
                try {
                    CalendarProviderUtil.a(Context.this, str, str2, j, j2, j3, sb.toString());
                } catch (Exception e2) {
                }
            }

            public void a(String[] strArr) {
                EventTrackGuy.b(GuyProtos.Event.CHECK_IN_REMIND_STATUS, false);
            }
        });
    }

    public static void a(Context context, String str, String str2, long j, long j2, long j3, String str3) {
        if (context == null) {
            if (AppInfo.m()) {
                AppMethods.a("Error 1");
                return;
            }
            return;
        }
        int a2 = a(context);
        if (a2 < 0) {
            if (AppInfo.m()) {
                AppMethods.a("Error 2");
                return;
            }
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        long time = calendar.getTime().getTime();
        if (j2 >= j) {
            calendar.setTimeInMillis(j2);
        }
        long time2 = calendar.getTime().getTime();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", str);
        contentValues.put("description", str2);
        contentValues.put(CalendarContract.EventsColumns.CALENDAR_ID, Integer.valueOf(a2));
        contentValues.put(CalendarContract.EventsColumns.DTSTART, Long.valueOf(time));
        contentValues.put(CalendarContract.EventsColumns.DTEND, Long.valueOf(time2));
        contentValues.put(CalendarContract.EventsColumns.HAS_ALARM, (Integer) 1);
        contentValues.put(CalendarContract.EventsColumns.RRULE, str3);
        contentValues.put(CalendarContract.EventsColumns.EVENT_TIMEZONE, "Asia/Shanghai");
        Uri insert = context.getContentResolver().insert(Uri.parse(b), contentValues);
        if (insert == null) {
            if (AppInfo.m()) {
                AppMethods.a("Error 3");
                return;
            }
            return;
        }
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("event_id", Long.valueOf(ContentUris.parseId(insert)));
        contentValues2.put("minutes", Long.valueOf(j3));
        contentValues2.put("method", (Integer) 1);
        if (context.getContentResolver().insert(Uri.parse(f21037c), contentValues2) == null && AppInfo.m()) {
            AppMethods.a("Error 4");
        }
    }

    private static int b(Context context) {
        Cursor query = context.getContentResolver().query(Uri.parse(f21036a), null, null, null, null);
        if (query == null) {
        }
        try {
            if (query.getCount() <= 0) {
                if (query != null) {
                    query.close();
                    return -1;
                }
                return -1;
            }
            query.moveToFirst();
            int i = query.getInt(query.getColumnIndex("_id"));
            if (query != null) {
                query.close();
            }
            return i;
        } finally {
            if (query != null) {
                query.close();
            }
        }
    }

    private static long c(Context context) {
        TimeZone timeZone = TimeZone.getDefault();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", d);
        contentValues.put("account_name", e);
        contentValues.put("account_type", f);
        contentValues.put("calendar_displayName", g);
        contentValues.put(CalendarContract.CalendarColumns.VISIBLE, (Integer) 1);
        contentValues.put(CalendarContract.CalendarColumns.CALENDAR_COLOR, Integer.valueOf((int) Color.BLUE));
        contentValues.put(CalendarContract.CalendarColumns.CALENDAR_ACCESS_LEVEL, (Integer) 700);
        contentValues.put(CalendarContract.CalendarColumns.SYNC_EVENTS, (Integer) 1);
        contentValues.put(CalendarContract.CalendarColumns.CALENDAR_TIME_ZONE, timeZone.getID());
        contentValues.put(CalendarContract.CalendarColumns.OWNER_ACCOUNT, e);
        contentValues.put(CalendarContract.CalendarColumns.CAN_ORGANIZER_RESPOND, (Integer) 0);
        Uri insert = context.getContentResolver().insert(Uri.parse(f21036a).buildUpon().appendQueryParameter("caller_is_syncadapter", fw.Code).appendQueryParameter("account_name", e).appendQueryParameter("account_type", f).build(), contentValues);
        if (insert == null) {
            return -1L;
        }
        return ContentUris.parseId(insert);
    }
}
