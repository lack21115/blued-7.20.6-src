package android.provider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.UserInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.telecom.PhoneAccountHandle;
import android.text.TextUtils;
import com.android.internal.telephony.CallerInfo;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/provider/CallLog.class */
public class CallLog {
    public static final String AUTHORITY = "call_log";
    public static final Uri CONTENT_URI = Uri.parse("content://call_log");

    /* loaded from: source-9557208-dex2jar.jar:android/provider/CallLog$Calls.class */
    public static class Calls implements BaseColumns {
        public static final int BLACKLIST_TYPE = 8;
        public static final String CACHED_FORMATTED_NUMBER = "formatted_number";
        public static final String CACHED_LOOKUP_URI = "lookup_uri";
        public static final String CACHED_MATCHED_NUMBER = "matched_number";
        public static final String CACHED_NAME = "name";
        public static final String CACHED_NORMALIZED_NUMBER = "normalized_number";
        public static final String CACHED_NUMBER_LABEL = "numberlabel";
        public static final String CACHED_NUMBER_TYPE = "numbertype";
        public static final String CACHED_PHOTO_ID = "photo_id";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/calls";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/calls";
        public static final String COUNTRY_ISO = "countryiso";
        public static final String DATA_USAGE = "data_usage";
        public static final String DATE = "date";
        public static final String DEFAULT_SORT_ORDER = "date DESC";
        public static final String DURATION = "duration";
        public static final String DURATION_TYPE = "duration_type";
        public static final int DURATION_TYPE_ACTIVE = 0;
        public static final int DURATION_TYPE_CALLOUT = 1;
        public static final String EXTRA_CALL_TYPE_FILTER = "android.provider.extra.CALL_TYPE_FILTER";
        public static final String FEATURES = "features";
        public static final int FEATURES_VIDEO = 1;
        public static final String GEOCODED_LOCATION = "geocoded_location";
        public static final int INCOMING_IMS_TYPE = 5;
        public static final int INCOMING_TYPE = 1;
        public static final String IS_READ = "is_read";
        public static final String LIMIT_PARAM_KEY = "limit";
        private static final int MIN_DURATION_FOR_NORMALIZED_NUMBER_UPDATE_MS = 10000;
        public static final int MISSED_IMS_TYPE = 7;
        public static final int MISSED_TYPE = 3;
        public static final String NEW = "new";
        public static final String NUMBER = "number";
        public static final String NUMBER_PRESENTATION = "presentation";
        public static final String OFFSET_PARAM_KEY = "offset";
        public static final int OUTGOING_IMS_TYPE = 6;
        public static final int OUTGOING_TYPE = 2;
        public static final String PHONE_ACCOUNT_COMPONENT_NAME = "subscription_component_name";
        public static final String PHONE_ACCOUNT_ID = "subscription_id";
        public static final int PRESENTATION_ALLOWED = 1;
        public static final int PRESENTATION_PAYPHONE = 4;
        public static final int PRESENTATION_RESTRICTED = 2;
        public static final int PRESENTATION_UNKNOWN = 3;
        public static final String SUB_ID = "sub_id";
        public static final String TRANSCRIPTION = "transcription";
        public static final String TYPE = "type";
        public static final int VOICEMAIL_TYPE = 4;
        public static final String VOICEMAIL_URI = "voicemail_uri";
        public static final Uri CONTENT_URI = Uri.parse("content://call_log/calls");
        public static final Uri CONTENT_FILTER_URI = Uri.parse("content://call_log/calls/filter");
        public static final String ALLOW_VOICEMAILS_PARAM_KEY = "allow_voicemails";
        public static final Uri CONTENT_URI_WITH_VOICEMAIL = CONTENT_URI.buildUpon().appendQueryParameter(ALLOW_VOICEMAILS_PARAM_KEY, "true").build();

        public static Uri addCall(CallerInfo callerInfo, Context context, String str, int i, int i2, int i3, PhoneAccountHandle phoneAccountHandle, long j, int i4, Long l) {
            return addCall(callerInfo, context, str, i, i2, i3, phoneAccountHandle, j, i4, l, false);
        }

        public static Uri addCall(CallerInfo callerInfo, Context context, String str, int i, int i2, int i3, PhoneAccountHandle phoneAccountHandle, long j, int i4, Long l, boolean z) {
            return addCall(callerInfo, context, str, i, i2, i3, phoneAccountHandle, j, i4, l, z, 0);
        }

        public static Uri addCall(CallerInfo callerInfo, Context context, String str, int i, int i2, int i3, PhoneAccountHandle phoneAccountHandle, long j, int i4, Long l, boolean z, int i5) {
            Uri addEntryAndRemoveExpiredEntries;
            Cursor query;
            ContentResolver contentResolver = context.getContentResolver();
            int i6 = 1;
            if (i == 2) {
                i6 = 2;
            } else if (i == 4) {
                i6 = 4;
            } else if (TextUtils.isEmpty(str) || i == 3) {
                i6 = 3;
            }
            if (i6 != 1) {
                str = "";
                if (callerInfo != null) {
                    callerInfo.name = "";
                    str = "";
                }
            }
            String str2 = null;
            String str3 = null;
            if (phoneAccountHandle != null) {
                str2 = phoneAccountHandle.getComponentName().flattenToString();
                str3 = phoneAccountHandle.getId();
            }
            ContentValues contentValues = new ContentValues(6);
            contentValues.put("number", str);
            contentValues.put(NUMBER_PRESENTATION, Integer.valueOf(i6));
            contentValues.put("type", Integer.valueOf(i2));
            contentValues.put(FEATURES, Integer.valueOf(i3));
            contentValues.put("date", Long.valueOf(j));
            contentValues.put("duration", Long.valueOf(i4));
            contentValues.put(DURATION_TYPE, Integer.valueOf(i5));
            if (l != null) {
                contentValues.put(DATA_USAGE, l);
            }
            contentValues.put(PHONE_ACCOUNT_COMPONENT_NAME, str2);
            contentValues.put("subscription_id", str3);
            contentValues.put("new", (Integer) 1);
            if (i2 == 3) {
                contentValues.put("is_read", (Integer) 0);
            }
            if (callerInfo != null) {
                contentValues.put("name", callerInfo.name);
                contentValues.put(CACHED_NUMBER_TYPE, Integer.valueOf(callerInfo.numberType));
                contentValues.put(CACHED_NUMBER_LABEL, callerInfo.numberLabel);
            }
            if (callerInfo != null && callerInfo.contactIdOrZero > 0) {
                if (callerInfo.normalizedNumber != null) {
                    query = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"_id"}, "contact_id =? AND data4 =?", new String[]{String.valueOf(callerInfo.contactIdOrZero), callerInfo.normalizedNumber}, null);
                } else {
                    if (callerInfo.phoneNumber != null) {
                        str = callerInfo.phoneNumber;
                    }
                    query = contentResolver.query(Uri.withAppendedPath(ContactsContract.CommonDataKinds.Callable.CONTENT_FILTER_URI, Uri.encode(str)), new String[]{"_id"}, "contact_id =?", new String[]{String.valueOf(callerInfo.contactIdOrZero)}, null);
                }
                if (query != null) {
                    try {
                        if (query.getCount() > 0 && query.moveToFirst()) {
                            contentResolver.update(ContactsContract.DataUsageFeedback.FEEDBACK_URI.buildUpon().appendPath(query.getString(0)).appendQueryParameter("type", "call").build(), new ContentValues(), null, null);
                        }
                        query.close();
                    } catch (Throwable th) {
                        query.close();
                        throw th;
                    }
                }
            }
            Uri uri = null;
            if (z) {
                UserManager userManager = (UserManager) context.getSystemService("user");
                List<UserInfo> users = userManager.getUsers(true);
                int userHandle = userManager.getUserHandle();
                int size = users.size();
                int i7 = 0;
                while (true) {
                    addEntryAndRemoveExpiredEntries = uri;
                    if (i7 >= size) {
                        break;
                    }
                    UserInfo userInfo = users.get(i7);
                    UserHandle userHandle2 = userInfo.getUserHandle();
                    Uri uri2 = uri;
                    if (userManager.isUserRunning(userHandle2)) {
                        uri2 = uri;
                        if (!userManager.hasUserRestriction(UserManager.DISALLOW_OUTGOING_CALLS, userHandle2)) {
                            uri2 = uri;
                            if (!userInfo.isManagedProfile()) {
                                Uri addEntryAndRemoveExpiredEntries2 = addEntryAndRemoveExpiredEntries(context, ContentProvider.maybeAddUserId(CONTENT_URI, userInfo.id), contentValues);
                                uri2 = uri;
                                if (userInfo.id == userHandle) {
                                    uri2 = addEntryAndRemoveExpiredEntries2;
                                }
                            }
                        }
                    }
                    i7++;
                    uri = uri2;
                }
            } else {
                addEntryAndRemoveExpiredEntries = addEntryAndRemoveExpiredEntries(context, CONTENT_URI, contentValues);
            }
            return addEntryAndRemoveExpiredEntries;
        }

        private static Uri addEntryAndRemoveExpiredEntries(Context context, Uri uri, ContentValues contentValues) {
            ContentResolver contentResolver = context.getContentResolver();
            Uri insert = contentResolver.insert(uri, contentValues);
            int i = Settings.System.getInt(contentResolver, Settings.System.CALL_LOG_DELETE_LIMIT, 500);
            if (i != 0) {
                contentResolver.delete(uri, "_id IN (SELECT _id FROM calls ORDER BY date DESC LIMIT -1 OFFSET " + i + ")", null);
            }
            return insert;
        }

        public static String getLastOutgoingCall(Context context) {
            String str;
            ContentResolver contentResolver = context.getContentResolver();
            Cursor cursor = null;
            try {
                Cursor query = contentResolver.query(CONTENT_URI, new String[]{"number"}, "type = 2", null, "date DESC LIMIT 1");
                if (query == null || !query.moveToFirst()) {
                    str = "";
                    if (query != null) {
                        query.close();
                        str = "";
                    }
                } else {
                    cursor = query;
                    String string = query.getString(0);
                    str = string;
                    if (query != null) {
                        query.close();
                        return string;
                    }
                }
                return str;
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
    }
}
