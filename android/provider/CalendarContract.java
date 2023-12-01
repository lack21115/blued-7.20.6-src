package android.provider;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.CursorEntityIterator;
import android.content.Entity;
import android.content.EntityIterator;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.os.RemoteException;
import android.provider.SyncStateContract;

/* loaded from: source-9557208-dex2jar.jar:android/provider/CalendarContract.class */
public final class CalendarContract {
    public static final String ACCOUNT_TYPE_LOCAL = "LOCAL";
    public static final String ACTION_EVENT_REMINDER = "android.intent.action.EVENT_REMINDER";
    public static final String ACTION_HANDLE_CUSTOM_EVENT = "android.provider.calendar.action.HANDLE_CUSTOM_EVENT";
    public static final String AUTHORITY = "com.android.calendar";
    public static final String CALLER_IS_SYNCADAPTER = "caller_is_syncadapter";
    public static final Uri CONTENT_URI = Uri.parse("content://com.android.calendar");
    public static final String EXTRA_CUSTOM_APP_URI = "customAppUri";
    public static final String EXTRA_EVENT_ALL_DAY = "allDay";
    public static final String EXTRA_EVENT_BEGIN_TIME = "beginTime";
    public static final String EXTRA_EVENT_END_TIME = "endTime";
    private static final String TAG = "Calendar";

    /* loaded from: source-9557208-dex2jar.jar:android/provider/CalendarContract$Attendees.class */
    public static final class Attendees implements BaseColumns, AttendeesColumns, EventsColumns {
        private static final String ATTENDEES_WHERE = "event_id=?";
        public static final Uri CONTENT_URI = Uri.parse("content://com.android.calendar/attendees");

        private Attendees() {
        }

        public static final Cursor query(ContentResolver contentResolver, long j, String[] strArr) {
            return contentResolver.query(CONTENT_URI, strArr, ATTENDEES_WHERE, new String[]{Long.toString(j)}, null);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/CalendarContract$AttendeesColumns.class */
    protected interface AttendeesColumns {
        public static final String ATTENDEE_EMAIL = "attendeeEmail";
        public static final String ATTENDEE_IDENTITY = "attendeeIdentity";
        public static final String ATTENDEE_ID_NAMESPACE = "attendeeIdNamespace";
        public static final String ATTENDEE_NAME = "attendeeName";
        public static final String ATTENDEE_RELATIONSHIP = "attendeeRelationship";
        public static final String ATTENDEE_STATUS = "attendeeStatus";
        public static final int ATTENDEE_STATUS_ACCEPTED = 1;
        public static final int ATTENDEE_STATUS_DECLINED = 2;
        public static final int ATTENDEE_STATUS_INVITED = 3;
        public static final int ATTENDEE_STATUS_NONE = 0;
        public static final int ATTENDEE_STATUS_TENTATIVE = 4;
        public static final String ATTENDEE_TYPE = "attendeeType";
        public static final String EVENT_ID = "event_id";
        public static final int RELATIONSHIP_ATTENDEE = 1;
        public static final int RELATIONSHIP_NONE = 0;
        public static final int RELATIONSHIP_ORGANIZER = 2;
        public static final int RELATIONSHIP_PERFORMER = 3;
        public static final int RELATIONSHIP_SPEAKER = 4;
        public static final int TYPE_NONE = 0;
        public static final int TYPE_OPTIONAL = 2;
        public static final int TYPE_REQUIRED = 1;
        public static final int TYPE_RESOURCE = 3;
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/CalendarContract$CalendarAlerts.class */
    public static final class CalendarAlerts implements BaseColumns, CalendarAlertsColumns, EventsColumns, CalendarColumns {
        public static final Uri CONTENT_URI = Uri.parse("content://com.android.calendar/calendar_alerts");
        public static final Uri CONTENT_URI_BY_INSTANCE = Uri.parse("content://com.android.calendar/calendar_alerts/by_instance");
        private static final boolean DEBUG = false;
        private static final String SORT_ORDER_ALARMTIME_ASC = "alarmTime ASC";
        public static final String TABLE_NAME = "CalendarAlerts";
        private static final String WHERE_ALARM_EXISTS = "event_id=? AND begin=? AND alarmTime=?";
        private static final String WHERE_FINDNEXTALARMTIME = "alarmTime>=?";
        private static final String WHERE_RESCHEDULE_MISSED_ALARMS = "state=0 AND alarmTime<? AND alarmTime>? AND end>=?";

        private CalendarAlerts() {
        }

        public static final boolean alarmExists(ContentResolver contentResolver, long j, long j2, long j3) {
            Cursor query = contentResolver.query(CONTENT_URI, new String[]{CalendarAlertsColumns.ALARM_TIME}, WHERE_ALARM_EXISTS, new String[]{Long.toString(j), Long.toString(j2), Long.toString(j3)}, null);
            boolean z = false;
            if (query != null) {
                try {
                    z = false;
                    if (query.getCount() > 0) {
                        z = true;
                    }
                } finally {
                    if (query != null) {
                        query.close();
                    }
                }
            }
            return z;
        }

        public static final long findNextAlarmTime(ContentResolver contentResolver, long j) {
            String str = "alarmTime>=" + j;
            Cursor query = contentResolver.query(CONTENT_URI, new String[]{CalendarAlertsColumns.ALARM_TIME}, WHERE_FINDNEXTALARMTIME, new String[]{Long.toString(j)}, SORT_ORDER_ALARMTIME_ASC);
            long j2 = -1;
            if (query != null) {
                j2 = -1;
                try {
                    if (query.moveToFirst()) {
                        j2 = query.getLong(0);
                    }
                } finally {
                    if (query != null) {
                        query.close();
                    }
                }
            }
            return j2;
        }

        public static final Uri insert(ContentResolver contentResolver, long j, long j2, long j3, long j4, int i) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("event_id", Long.valueOf(j));
            contentValues.put("begin", Long.valueOf(j2));
            contentValues.put("end", Long.valueOf(j3));
            contentValues.put(CalendarAlertsColumns.ALARM_TIME, Long.valueOf(j4));
            contentValues.put(CalendarAlertsColumns.CREATION_TIME, Long.valueOf(System.currentTimeMillis()));
            contentValues.put(CalendarAlertsColumns.RECEIVED_TIME, (Integer) 0);
            contentValues.put(CalendarAlertsColumns.NOTIFY_TIME, (Integer) 0);
            contentValues.put("state", (Integer) 0);
            contentValues.put("minutes", Integer.valueOf(i));
            return contentResolver.insert(CONTENT_URI, contentValues);
        }

        public static final void rescheduleMissedAlarms(ContentResolver contentResolver, Context context, AlarmManager alarmManager) {
            long currentTimeMillis = System.currentTimeMillis();
            Cursor query = contentResolver.query(CONTENT_URI, new String[]{CalendarAlertsColumns.ALARM_TIME}, WHERE_RESCHEDULE_MISSED_ALARMS, new String[]{Long.toString(currentTimeMillis), Long.toString(currentTimeMillis - 86400000), Long.toString(currentTimeMillis)}, SORT_ORDER_ALARMTIME_ASC);
            if (query == null) {
                return;
            }
            long j = -1;
            while (query.moveToNext()) {
                try {
                    long j2 = query.getLong(0);
                    if (j != j2) {
                        scheduleAlarm(context, alarmManager, j2);
                        j = j2;
                    }
                } finally {
                    query.close();
                }
            }
        }

        public static void scheduleAlarm(Context context, AlarmManager alarmManager, long j) {
            AlarmManager alarmManager2 = alarmManager;
            if (alarmManager == null) {
                alarmManager2 = (AlarmManager) context.getSystemService("alarm");
            }
            Intent intent = new Intent(CalendarContract.ACTION_EVENT_REMINDER);
            intent.setData(ContentUris.withAppendedId(CalendarContract.CONTENT_URI, j));
            intent.putExtra(CalendarAlertsColumns.ALARM_TIME, j);
            alarmManager2.setExact(0, j, PendingIntent.getBroadcast(context, 0, intent, 0));
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/CalendarContract$CalendarAlertsColumns.class */
    protected interface CalendarAlertsColumns {
        public static final String ALARM_TIME = "alarmTime";
        public static final String BEGIN = "begin";
        public static final String CREATION_TIME = "creationTime";
        public static final String DEFAULT_SORT_ORDER = "begin ASC,title ASC";
        public static final String END = "end";
        public static final String EVENT_ID = "event_id";
        public static final String MINUTES = "minutes";
        public static final String NOTIFY_TIME = "notifyTime";
        public static final String RECEIVED_TIME = "receivedTime";
        public static final String STATE = "state";
        public static final int STATE_DISMISSED = 2;
        public static final int STATE_FIRED = 1;
        public static final int STATE_SCHEDULED = 0;
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/CalendarContract$CalendarCache.class */
    public static final class CalendarCache implements CalendarCacheColumns {
        public static final String KEY_TIMEZONE_INSTANCES = "timezoneInstances";
        public static final String KEY_TIMEZONE_INSTANCES_PREVIOUS = "timezoneInstancesPrevious";
        public static final String KEY_TIMEZONE_TYPE = "timezoneType";
        public static final String TIMEZONE_TYPE_AUTO = "auto";
        public static final String TIMEZONE_TYPE_HOME = "home";
        public static final Uri URI = Uri.parse("content://com.android.calendar/properties");

        private CalendarCache() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/CalendarContract$CalendarCacheColumns.class */
    protected interface CalendarCacheColumns {
        public static final String KEY = "key";
        public static final String VALUE = "value";
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/CalendarContract$CalendarColumns.class */
    protected interface CalendarColumns {
        public static final String ALLOWED_ATTENDEE_TYPES = "allowedAttendeeTypes";
        public static final String ALLOWED_AVAILABILITY = "allowedAvailability";
        public static final String ALLOWED_REMINDERS = "allowedReminders";
        public static final String CALENDAR_ACCESS_LEVEL = "calendar_access_level";
        public static final String CALENDAR_COLOR = "calendar_color";
        public static final String CALENDAR_COLOR_KEY = "calendar_color_index";
        public static final String CALENDAR_DISPLAY_NAME = "calendar_displayName";
        public static final String CALENDAR_TIME_ZONE = "calendar_timezone";
        public static final int CAL_ACCESS_CONTRIBUTOR = 500;
        public static final int CAL_ACCESS_EDITOR = 600;
        public static final int CAL_ACCESS_FREEBUSY = 100;
        public static final int CAL_ACCESS_NONE = 0;
        public static final int CAL_ACCESS_OVERRIDE = 400;
        public static final int CAL_ACCESS_OWNER = 700;
        public static final int CAL_ACCESS_READ = 200;
        public static final int CAL_ACCESS_RESPOND = 300;
        public static final int CAL_ACCESS_ROOT = 800;
        public static final String CAN_MODIFY_TIME_ZONE = "canModifyTimeZone";
        public static final String CAN_ORGANIZER_RESPOND = "canOrganizerRespond";
        public static final String IS_PRIMARY = "isPrimary";
        public static final String MAX_REMINDERS = "maxReminders";
        public static final String OWNER_ACCOUNT = "ownerAccount";
        public static final String SYNC_EVENTS = "sync_events";
        public static final String VISIBLE = "visible";
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/CalendarContract$CalendarEntity.class */
    public static final class CalendarEntity implements BaseColumns, SyncColumns, CalendarColumns {
        public static final Uri CONTENT_URI = Uri.parse("content://com.android.calendar/calendar_entities");

        /* loaded from: source-9557208-dex2jar.jar:android/provider/CalendarContract$CalendarEntity$EntityIteratorImpl.class */
        private static class EntityIteratorImpl extends CursorEntityIterator {
            public EntityIteratorImpl(Cursor cursor) {
                super(cursor);
            }

            @Override // android.content.CursorEntityIterator
            public Entity getEntityAndIncrementCursor(Cursor cursor) throws RemoteException {
                long j = cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
                ContentValues contentValues = new ContentValues();
                contentValues.put("_id", Long.valueOf(j));
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, "account_name");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, "account_type");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, "_sync_id");
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentValues, "dirty");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, SyncColumns.MUTATORS);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, CalendarSyncColumns.CAL_SYNC1);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, CalendarSyncColumns.CAL_SYNC2);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, CalendarSyncColumns.CAL_SYNC3);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, CalendarSyncColumns.CAL_SYNC4);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, CalendarSyncColumns.CAL_SYNC5);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, CalendarSyncColumns.CAL_SYNC6);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, CalendarSyncColumns.CAL_SYNC7);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, CalendarSyncColumns.CAL_SYNC8);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, CalendarSyncColumns.CAL_SYNC9);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, CalendarSyncColumns.CAL_SYNC10);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, "name");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, "calendar_displayName");
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentValues, CalendarColumns.CALENDAR_COLOR);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, CalendarColumns.CALENDAR_COLOR_KEY);
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentValues, CalendarColumns.CALENDAR_ACCESS_LEVEL);
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentValues, CalendarColumns.VISIBLE);
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentValues, CalendarColumns.SYNC_EVENTS);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, Calendars.CALENDAR_LOCATION);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, CalendarColumns.CALENDAR_TIME_ZONE);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, CalendarColumns.OWNER_ACCOUNT);
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentValues, CalendarColumns.CAN_ORGANIZER_RESPOND);
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentValues, CalendarColumns.CAN_MODIFY_TIME_ZONE);
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentValues, CalendarColumns.MAX_REMINDERS);
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentValues, SyncColumns.CAN_PARTIALLY_UPDATE);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, CalendarColumns.ALLOWED_REMINDERS);
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentValues, "deleted");
                Entity entity = new Entity(contentValues);
                cursor.moveToNext();
                return entity;
            }
        }

        private CalendarEntity() {
        }

        public static EntityIterator newEntityIterator(Cursor cursor) {
            return new EntityIteratorImpl(cursor);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/CalendarContract$CalendarMetaData.class */
    public static final class CalendarMetaData implements CalendarMetaDataColumns, BaseColumns {
        private CalendarMetaData() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/CalendarContract$CalendarMetaDataColumns.class */
    protected interface CalendarMetaDataColumns {
        public static final String LOCAL_TIMEZONE = "localTimezone";
        public static final String MAX_EVENTDAYS = "maxEventDays";
        public static final String MAX_INSTANCE = "maxInstance";
        public static final String MIN_EVENTDAYS = "minEventDays";
        public static final String MIN_INSTANCE = "minInstance";
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/CalendarContract$CalendarSyncColumns.class */
    protected interface CalendarSyncColumns {
        public static final String CAL_SYNC1 = "cal_sync1";
        public static final String CAL_SYNC10 = "cal_sync10";
        public static final String CAL_SYNC2 = "cal_sync2";
        public static final String CAL_SYNC3 = "cal_sync3";
        public static final String CAL_SYNC4 = "cal_sync4";
        public static final String CAL_SYNC5 = "cal_sync5";
        public static final String CAL_SYNC6 = "cal_sync6";
        public static final String CAL_SYNC7 = "cal_sync7";
        public static final String CAL_SYNC8 = "cal_sync8";
        public static final String CAL_SYNC9 = "cal_sync9";
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/CalendarContract$Calendars.class */
    public static final class Calendars implements BaseColumns, SyncColumns, CalendarColumns {
        public static final String DEFAULT_SORT_ORDER = "calendar_displayName";
        public static final String NAME = "name";
        public static final Uri CONTENT_URI = Uri.parse("content://com.android.calendar/calendars");
        public static final String CALENDAR_LOCATION = "calendar_location";
        public static final String[] SYNC_WRITABLE_COLUMNS = {"account_name", "account_type", "_sync_id", "dirty", SyncColumns.MUTATORS, CalendarColumns.OWNER_ACCOUNT, CalendarColumns.MAX_REMINDERS, CalendarColumns.ALLOWED_REMINDERS, CalendarColumns.CAN_MODIFY_TIME_ZONE, CalendarColumns.CAN_ORGANIZER_RESPOND, SyncColumns.CAN_PARTIALLY_UPDATE, CALENDAR_LOCATION, CalendarColumns.CALENDAR_TIME_ZONE, CalendarColumns.CALENDAR_ACCESS_LEVEL, "deleted", CalendarSyncColumns.CAL_SYNC1, CalendarSyncColumns.CAL_SYNC2, CalendarSyncColumns.CAL_SYNC3, CalendarSyncColumns.CAL_SYNC4, CalendarSyncColumns.CAL_SYNC5, CalendarSyncColumns.CAL_SYNC6, CalendarSyncColumns.CAL_SYNC7, CalendarSyncColumns.CAL_SYNC8, CalendarSyncColumns.CAL_SYNC9, CalendarSyncColumns.CAL_SYNC10};

        private Calendars() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/CalendarContract$Colors.class */
    public static final class Colors implements ColorsColumns {
        public static final Uri CONTENT_URI = Uri.parse("content://com.android.calendar/colors");
        public static final String TABLE_NAME = "Colors";

        private Colors() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/CalendarContract$ColorsColumns.class */
    protected interface ColorsColumns extends SyncStateContract.Columns {
        public static final String COLOR = "color";
        public static final String COLOR_KEY = "color_index";
        public static final String COLOR_TYPE = "color_type";
        public static final int TYPE_CALENDAR = 0;
        public static final int TYPE_EVENT = 1;
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/CalendarContract$EventDays.class */
    public static final class EventDays implements EventDaysColumns {
        public static final Uri CONTENT_URI = Uri.parse("content://com.android.calendar/instances/groupbyday");
        private static final String SELECTION = "selected=1";

        private EventDays() {
        }

        public static final Cursor query(ContentResolver contentResolver, int i, int i2, String[] strArr) {
            if (i2 < 1) {
                return null;
            }
            Uri.Builder buildUpon = CONTENT_URI.buildUpon();
            ContentUris.appendId(buildUpon, i);
            ContentUris.appendId(buildUpon, (i + i2) - 1);
            return contentResolver.query(buildUpon.build(), strArr, SELECTION, null, "startDay");
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/CalendarContract$EventDaysColumns.class */
    protected interface EventDaysColumns {
        public static final String ENDDAY = "endDay";
        public static final String STARTDAY = "startDay";
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/CalendarContract$Events.class */
    public static final class Events implements BaseColumns, SyncColumns, EventsColumns, CalendarColumns {
        private static final String DEFAULT_SORT_ORDER = "";
        public static final Uri CONTENT_URI = Uri.parse("content://com.android.calendar/events");
        public static final Uri CONTENT_EXCEPTION_URI = Uri.parse("content://com.android.calendar/exception");
        public static String[] PROVIDER_WRITABLE_COLUMNS = {"account_name", "account_type", CalendarSyncColumns.CAL_SYNC1, CalendarSyncColumns.CAL_SYNC2, CalendarSyncColumns.CAL_SYNC3, CalendarSyncColumns.CAL_SYNC4, CalendarSyncColumns.CAL_SYNC5, CalendarSyncColumns.CAL_SYNC6, CalendarSyncColumns.CAL_SYNC7, CalendarSyncColumns.CAL_SYNC8, CalendarSyncColumns.CAL_SYNC9, CalendarSyncColumns.CAL_SYNC10, CalendarColumns.ALLOWED_REMINDERS, CalendarColumns.ALLOWED_ATTENDEE_TYPES, CalendarColumns.ALLOWED_AVAILABILITY, CalendarColumns.CALENDAR_ACCESS_LEVEL, CalendarColumns.CALENDAR_COLOR, CalendarColumns.CALENDAR_TIME_ZONE, CalendarColumns.CAN_MODIFY_TIME_ZONE, CalendarColumns.CAN_ORGANIZER_RESPOND, "calendar_displayName", SyncColumns.CAN_PARTIALLY_UPDATE, CalendarColumns.SYNC_EVENTS, CalendarColumns.VISIBLE};
        public static final String[] SYNC_WRITABLE_COLUMNS = {"_sync_id", "dirty", SyncColumns.MUTATORS, EventsColumns.SYNC_DATA1, EventsColumns.SYNC_DATA2, EventsColumns.SYNC_DATA3, EventsColumns.SYNC_DATA4, EventsColumns.SYNC_DATA5, EventsColumns.SYNC_DATA6, EventsColumns.SYNC_DATA7, EventsColumns.SYNC_DATA8, EventsColumns.SYNC_DATA9, EventsColumns.SYNC_DATA10};

        private Events() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/CalendarContract$EventsColumns.class */
    protected interface EventsColumns {
        public static final int ACCESS_CONFIDENTIAL = 1;
        public static final int ACCESS_DEFAULT = 0;
        public static final String ACCESS_LEVEL = "accessLevel";
        public static final int ACCESS_PRIVATE = 2;
        public static final int ACCESS_PUBLIC = 3;
        public static final String ALL_DAY = "allDay";
        public static final String AVAILABILITY = "availability";
        public static final int AVAILABILITY_BUSY = 0;
        public static final int AVAILABILITY_FREE = 1;
        public static final int AVAILABILITY_TENTATIVE = 2;
        public static final String CALENDAR_ID = "calendar_id";
        public static final String CAN_INVITE_OTHERS = "canInviteOthers";
        public static final String CUSTOM_APP_PACKAGE = "customAppPackage";
        public static final String CUSTOM_APP_URI = "customAppUri";
        public static final String DESCRIPTION = "description";
        public static final String DISPLAY_COLOR = "displayColor";
        public static final String DTEND = "dtend";
        public static final String DTSTART = "dtstart";
        public static final String DURATION = "duration";
        public static final String EVENT_COLOR = "eventColor";
        public static final String EVENT_COLOR_KEY = "eventColor_index";
        public static final String EVENT_END_TIMEZONE = "eventEndTimezone";
        public static final String EVENT_LOCATION = "eventLocation";
        public static final String EVENT_TIMEZONE = "eventTimezone";
        public static final String EXDATE = "exdate";
        public static final String EXRULE = "exrule";
        public static final String GUESTS_CAN_INVITE_OTHERS = "guestsCanInviteOthers";
        public static final String GUESTS_CAN_MODIFY = "guestsCanModify";
        public static final String GUESTS_CAN_SEE_GUESTS = "guestsCanSeeGuests";
        public static final String HAS_ALARM = "hasAlarm";
        public static final String HAS_ATTENDEE_DATA = "hasAttendeeData";
        public static final String HAS_EXTENDED_PROPERTIES = "hasExtendedProperties";
        public static final String IS_ORGANIZER = "isOrganizer";
        public static final String LAST_DATE = "lastDate";
        public static final String LAST_SYNCED = "lastSynced";
        public static final String ORGANIZER = "organizer";
        public static final String ORIGINAL_ALL_DAY = "originalAllDay";
        public static final String ORIGINAL_ID = "original_id";
        public static final String ORIGINAL_INSTANCE_TIME = "originalInstanceTime";
        public static final String ORIGINAL_SYNC_ID = "original_sync_id";
        public static final String RDATE = "rdate";
        public static final String RRULE = "rrule";
        public static final String SELF_ATTENDEE_STATUS = "selfAttendeeStatus";
        public static final String STATUS = "eventStatus";
        public static final int STATUS_CANCELED = 2;
        public static final int STATUS_CONFIRMED = 1;
        public static final int STATUS_TENTATIVE = 0;
        public static final String SYNC_DATA1 = "sync_data1";
        public static final String SYNC_DATA10 = "sync_data10";
        public static final String SYNC_DATA2 = "sync_data2";
        public static final String SYNC_DATA3 = "sync_data3";
        public static final String SYNC_DATA4 = "sync_data4";
        public static final String SYNC_DATA5 = "sync_data5";
        public static final String SYNC_DATA6 = "sync_data6";
        public static final String SYNC_DATA7 = "sync_data7";
        public static final String SYNC_DATA8 = "sync_data8";
        public static final String SYNC_DATA9 = "sync_data9";
        public static final String TITLE = "title";
        public static final String UID_2445 = "uid2445";
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/CalendarContract$EventsEntity.class */
    public static final class EventsEntity implements BaseColumns, SyncColumns, EventsColumns {
        public static final Uri CONTENT_URI = Uri.parse("content://com.android.calendar/event_entities");

        /* loaded from: source-9557208-dex2jar.jar:android/provider/CalendarContract$EventsEntity$EntityIteratorImpl.class */
        private static class EntityIteratorImpl extends CursorEntityIterator {
            private static final int COLUMN_ATTENDEE_EMAIL = 1;
            private static final int COLUMN_ATTENDEE_IDENTITY = 5;
            private static final int COLUMN_ATTENDEE_ID_NAMESPACE = 6;
            private static final int COLUMN_ATTENDEE_NAME = 0;
            private static final int COLUMN_ATTENDEE_RELATIONSHIP = 2;
            private static final int COLUMN_ATTENDEE_STATUS = 4;
            private static final int COLUMN_ATTENDEE_TYPE = 3;
            private static final int COLUMN_ID = 0;
            private static final int COLUMN_METHOD = 1;
            private static final int COLUMN_MINUTES = 0;
            private static final int COLUMN_NAME = 1;
            private static final int COLUMN_VALUE = 2;
            private static final String WHERE_EVENT_ID = "event_id=?";
            private final ContentProviderClient mProvider;
            private final ContentResolver mResolver;
            private static final String[] REMINDERS_PROJECTION = {"minutes", "method"};
            private static final String[] ATTENDEES_PROJECTION = {AttendeesColumns.ATTENDEE_NAME, AttendeesColumns.ATTENDEE_EMAIL, AttendeesColumns.ATTENDEE_RELATIONSHIP, AttendeesColumns.ATTENDEE_TYPE, AttendeesColumns.ATTENDEE_STATUS, AttendeesColumns.ATTENDEE_IDENTITY, AttendeesColumns.ATTENDEE_ID_NAMESPACE};
            private static final String[] EXTENDED_PROJECTION = {"_id", "name", "value"};

            public EntityIteratorImpl(Cursor cursor, ContentProviderClient contentProviderClient) {
                super(cursor);
                this.mResolver = null;
                this.mProvider = contentProviderClient;
            }

            public EntityIteratorImpl(Cursor cursor, ContentResolver contentResolver) {
                super(cursor);
                this.mResolver = contentResolver;
                this.mProvider = null;
            }

            @Override // android.content.CursorEntityIterator
            public Entity getEntityAndIncrementCursor(Cursor cursor) throws RemoteException {
                long j = cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
                ContentValues contentValues = new ContentValues();
                contentValues.put("_id", Long.valueOf(j));
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentValues, EventsColumns.CALENDAR_ID);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, "title");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, "description");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, EventsColumns.EVENT_LOCATION);
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentValues, EventsColumns.STATUS);
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentValues, EventsColumns.SELF_ATTENDEE_STATUS);
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentValues, EventsColumns.DTSTART);
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentValues, EventsColumns.DTEND);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, "duration");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, EventsColumns.EVENT_TIMEZONE);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, EventsColumns.EVENT_END_TIMEZONE);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, "allDay");
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentValues, EventsColumns.ACCESS_LEVEL);
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentValues, EventsColumns.AVAILABILITY);
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentValues, EventsColumns.EVENT_COLOR);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, EventsColumns.EVENT_COLOR_KEY);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, EventsColumns.HAS_ALARM);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, EventsColumns.HAS_EXTENDED_PROPERTIES);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, EventsColumns.RRULE);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, EventsColumns.RDATE);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, EventsColumns.EXRULE);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, EventsColumns.EXDATE);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, EventsColumns.ORIGINAL_SYNC_ID);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, EventsColumns.ORIGINAL_ID);
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentValues, EventsColumns.ORIGINAL_INSTANCE_TIME);
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentValues, EventsColumns.ORIGINAL_ALL_DAY);
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentValues, EventsColumns.LAST_DATE);
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentValues, EventsColumns.HAS_ATTENDEE_DATA);
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentValues, EventsColumns.GUESTS_CAN_INVITE_OTHERS);
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentValues, EventsColumns.GUESTS_CAN_MODIFY);
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentValues, EventsColumns.GUESTS_CAN_SEE_GUESTS);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, EventsColumns.CUSTOM_APP_PACKAGE);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, "customAppUri");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, EventsColumns.UID_2445);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, EventsColumns.ORGANIZER);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, EventsColumns.IS_ORGANIZER);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, "_sync_id");
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentValues, "dirty");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, SyncColumns.MUTATORS);
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentValues, EventsColumns.LAST_SYNCED);
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentValues, "deleted");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, EventsColumns.SYNC_DATA1);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, EventsColumns.SYNC_DATA2);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, EventsColumns.SYNC_DATA3);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, EventsColumns.SYNC_DATA4);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, EventsColumns.SYNC_DATA5);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, EventsColumns.SYNC_DATA6);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, EventsColumns.SYNC_DATA7);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, EventsColumns.SYNC_DATA8);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, EventsColumns.SYNC_DATA9);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, EventsColumns.SYNC_DATA10);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, CalendarSyncColumns.CAL_SYNC1);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, CalendarSyncColumns.CAL_SYNC2);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, CalendarSyncColumns.CAL_SYNC3);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, CalendarSyncColumns.CAL_SYNC4);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, CalendarSyncColumns.CAL_SYNC5);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, CalendarSyncColumns.CAL_SYNC6);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, CalendarSyncColumns.CAL_SYNC7);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, CalendarSyncColumns.CAL_SYNC8);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, CalendarSyncColumns.CAL_SYNC9);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, CalendarSyncColumns.CAL_SYNC10);
                Entity entity = new Entity(contentValues);
                Cursor query = this.mResolver != null ? this.mResolver.query(Reminders.CONTENT_URI, REMINDERS_PROJECTION, WHERE_EVENT_ID, new String[]{Long.toString(j)}, null) : this.mProvider.query(Reminders.CONTENT_URI, REMINDERS_PROJECTION, WHERE_EVENT_ID, new String[]{Long.toString(j)}, null);
                while (query.moveToNext()) {
                    try {
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("minutes", Integer.valueOf(query.getInt(0)));
                        contentValues2.put("method", Integer.valueOf(query.getInt(1)));
                        entity.addSubValue(Reminders.CONTENT_URI, contentValues2);
                    } finally {
                    }
                }
                query.close();
                query = this.mResolver != null ? this.mResolver.query(Attendees.CONTENT_URI, ATTENDEES_PROJECTION, WHERE_EVENT_ID, new String[]{Long.toString(j)}, null) : this.mProvider.query(Attendees.CONTENT_URI, ATTENDEES_PROJECTION, WHERE_EVENT_ID, new String[]{Long.toString(j)}, null);
                while (query.moveToNext()) {
                    try {
                        ContentValues contentValues3 = new ContentValues();
                        contentValues3.put(AttendeesColumns.ATTENDEE_NAME, query.getString(0));
                        contentValues3.put(AttendeesColumns.ATTENDEE_EMAIL, query.getString(1));
                        contentValues3.put(AttendeesColumns.ATTENDEE_RELATIONSHIP, Integer.valueOf(query.getInt(2)));
                        contentValues3.put(AttendeesColumns.ATTENDEE_TYPE, Integer.valueOf(query.getInt(3)));
                        contentValues3.put(AttendeesColumns.ATTENDEE_STATUS, Integer.valueOf(query.getInt(4)));
                        contentValues3.put(AttendeesColumns.ATTENDEE_IDENTITY, query.getString(5));
                        contentValues3.put(AttendeesColumns.ATTENDEE_ID_NAMESPACE, query.getString(6));
                        entity.addSubValue(Attendees.CONTENT_URI, contentValues3);
                    } finally {
                    }
                }
                query.close();
                query = this.mResolver != null ? this.mResolver.query(ExtendedProperties.CONTENT_URI, EXTENDED_PROJECTION, WHERE_EVENT_ID, new String[]{Long.toString(j)}, null) : this.mProvider.query(ExtendedProperties.CONTENT_URI, EXTENDED_PROJECTION, WHERE_EVENT_ID, new String[]{Long.toString(j)}, null);
                while (query.moveToNext()) {
                    try {
                        ContentValues contentValues4 = new ContentValues();
                        contentValues4.put("_id", query.getString(0));
                        contentValues4.put("name", query.getString(1));
                        contentValues4.put("value", query.getString(2));
                        entity.addSubValue(ExtendedProperties.CONTENT_URI, contentValues4);
                    } finally {
                    }
                }
                query.close();
                cursor.moveToNext();
                return entity;
            }
        }

        private EventsEntity() {
        }

        public static EntityIterator newEntityIterator(Cursor cursor, ContentProviderClient contentProviderClient) {
            return new EntityIteratorImpl(cursor, contentProviderClient);
        }

        public static EntityIterator newEntityIterator(Cursor cursor, ContentResolver contentResolver) {
            return new EntityIteratorImpl(cursor, contentResolver);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/CalendarContract$EventsRawTimes.class */
    public static final class EventsRawTimes implements BaseColumns, EventsRawTimesColumns {
        private EventsRawTimes() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/CalendarContract$EventsRawTimesColumns.class */
    protected interface EventsRawTimesColumns {
        public static final String DTEND_2445 = "dtend2445";
        public static final String DTSTART_2445 = "dtstart2445";
        public static final String EVENT_ID = "event_id";
        public static final String LAST_DATE_2445 = "lastDate2445";
        public static final String ORIGINAL_INSTANCE_TIME_2445 = "originalInstanceTime2445";
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/CalendarContract$ExtendedProperties.class */
    public static final class ExtendedProperties implements BaseColumns, ExtendedPropertiesColumns, EventsColumns {
        public static final Uri CONTENT_URI = Uri.parse("content://com.android.calendar/extendedproperties");

        private ExtendedProperties() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/CalendarContract$ExtendedPropertiesColumns.class */
    protected interface ExtendedPropertiesColumns {
        public static final String EVENT_ID = "event_id";
        public static final String NAME = "name";
        public static final String VALUE = "value";
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/CalendarContract$Instances.class */
    public static final class Instances implements BaseColumns, EventsColumns, CalendarColumns {
        public static final String BEGIN = "begin";
        private static final String DEFAULT_SORT_ORDER = "begin ASC";
        public static final String END = "end";
        public static final String END_DAY = "endDay";
        public static final String END_MINUTE = "endMinute";
        public static final String EVENT_ID = "event_id";
        public static final String START_DAY = "startDay";
        public static final String START_MINUTE = "startMinute";
        private static final String WHERE_CALENDARS_SELECTED = "visible=?";
        private static final String[] WHERE_CALENDARS_ARGS = {"1"};
        public static final Uri CONTENT_URI = Uri.parse("content://com.android.calendar/instances/when");
        public static final Uri CONTENT_BY_DAY_URI = Uri.parse("content://com.android.calendar/instances/whenbyday");
        public static final Uri CONTENT_SEARCH_URI = Uri.parse("content://com.android.calendar/instances/search");
        public static final Uri CONTENT_SEARCH_BY_DAY_URI = Uri.parse("content://com.android.calendar/instances/searchbyday");

        private Instances() {
        }

        public static final Cursor query(ContentResolver contentResolver, String[] strArr, long j, long j2) {
            Uri.Builder buildUpon = CONTENT_URI.buildUpon();
            ContentUris.appendId(buildUpon, j);
            ContentUris.appendId(buildUpon, j2);
            return contentResolver.query(buildUpon.build(), strArr, WHERE_CALENDARS_SELECTED, WHERE_CALENDARS_ARGS, DEFAULT_SORT_ORDER);
        }

        public static final Cursor query(ContentResolver contentResolver, String[] strArr, long j, long j2, String str) {
            Uri.Builder buildUpon = CONTENT_SEARCH_URI.buildUpon();
            ContentUris.appendId(buildUpon, j);
            ContentUris.appendId(buildUpon, j2);
            return contentResolver.query(buildUpon.appendPath(str).build(), strArr, WHERE_CALENDARS_SELECTED, WHERE_CALENDARS_ARGS, DEFAULT_SORT_ORDER);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/CalendarContract$Reminders.class */
    public static final class Reminders implements BaseColumns, RemindersColumns, EventsColumns {
        public static final Uri CONTENT_URI = Uri.parse("content://com.android.calendar/reminders");
        private static final String REMINDERS_WHERE = "event_id=?";

        private Reminders() {
        }

        public static final Cursor query(ContentResolver contentResolver, long j, String[] strArr) {
            return contentResolver.query(CONTENT_URI, strArr, REMINDERS_WHERE, new String[]{Long.toString(j)}, null);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/CalendarContract$RemindersColumns.class */
    protected interface RemindersColumns {
        public static final String EVENT_ID = "event_id";
        public static final String METHOD = "method";
        public static final int METHOD_ALARM = 4;
        public static final int METHOD_ALERT = 1;
        public static final int METHOD_DEFAULT = 0;
        public static final int METHOD_EMAIL = 2;
        public static final int METHOD_SMS = 3;
        public static final String MINUTES = "minutes";
        public static final int MINUTES_DEFAULT = -1;
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/CalendarContract$SyncColumns.class */
    protected interface SyncColumns extends CalendarSyncColumns {
        public static final String ACCOUNT_NAME = "account_name";
        public static final String ACCOUNT_TYPE = "account_type";
        public static final String CAN_PARTIALLY_UPDATE = "canPartiallyUpdate";
        public static final String DELETED = "deleted";
        public static final String DIRTY = "dirty";
        public static final String MUTATORS = "mutators";
        public static final String _SYNC_ID = "_sync_id";
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/CalendarContract$SyncState.class */
    public static final class SyncState implements SyncStateContract.Columns {
        private static final String CONTENT_DIRECTORY = "syncstate";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(CalendarContract.CONTENT_URI, "syncstate");

        private SyncState() {
        }
    }

    private CalendarContract() {
    }
}
