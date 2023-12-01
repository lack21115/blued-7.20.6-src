package android.media;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Environment;
import android.provider.DrmStore;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import com.android.internal.R;
import com.android.internal.database.SortCursor;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/media/RingtoneManager.class */
public class RingtoneManager {
    public static final String ACTION_RINGTONE_PICKER = "android.intent.action.RINGTONE_PICKER";
    private static final String[] DRM_COLUMNS = null;
    public static final String EXTRA_RINGTONE_DEFAULT_URI = "android.intent.extra.ringtone.DEFAULT_URI";
    public static final String EXTRA_RINGTONE_DIALOG_THEME = "android.intent.extra.ringtone.DIALOG_THEME";
    public static final String EXTRA_RINGTONE_EXISTING_URI = "android.intent.extra.ringtone.EXISTING_URI";
    public static final String EXTRA_RINGTONE_INCLUDE_DRM = "android.intent.extra.ringtone.INCLUDE_DRM";
    public static final String EXTRA_RINGTONE_PICKED_URI = "android.intent.extra.ringtone.PICKED_URI";
    public static final String EXTRA_RINGTONE_SHOW_DEFAULT = "android.intent.extra.ringtone.SHOW_DEFAULT";
    public static final String EXTRA_RINGTONE_SHOW_SILENT = "android.intent.extra.ringtone.SHOW_SILENT";
    public static final String EXTRA_RINGTONE_TITLE = "android.intent.extra.ringtone.TITLE";
    public static final String EXTRA_RINGTONE_TYPE = "android.intent.extra.ringtone.TYPE";
    public static final int ID_COLUMN_INDEX = 0;
    private static final String[] INTERNAL_COLUMNS = null;
    private static final String[] MEDIA_COLUMNS = null;
    private static final String TAG = "RingtoneManager";
    public static final int TITLE_COLUMN_INDEX = 1;
    public static final int TYPE_ALARM = 4;
    public static final int TYPE_ALL = 7;
    public static final int TYPE_NOTIFICATION = 2;
    public static final int TYPE_RINGTONE = 1;
    public static final int URI_COLUMN_INDEX = 2;
    private Activity mActivity;
    private Context mContext;
    private Cursor mCursor;
    private String mExcludedExternalStorageDir;
    private boolean mIncludeDrm;
    private Ringtone mPreviousRingtone;
    private int mType = 1;
    private final List<String> mFilterColumns = new ArrayList();
    private boolean mStopPreviousRingtone = true;

    static {
        String[] strArr = new String[4];
        strArr[0] = "_id";
        strArr[1] = "title";
        new StringBuilder();
        throw new VerifyError("bad dex opcode");
    }

    public RingtoneManager(Activity activity) {
        this.mExcludedExternalStorageDir = null;
        this.mActivity = activity;
        this.mContext = activity;
        setType(this.mType);
        this.mExcludedExternalStorageDir = getExcludedExternalStorageDir();
    }

    public RingtoneManager(Context context) {
        this.mExcludedExternalStorageDir = null;
        this.mContext = context;
        setType(this.mType);
        this.mExcludedExternalStorageDir = getExcludedExternalStorageDir();
    }

    private static String constructBooleanTrueWhereClause(List<String> list, boolean z) {
        if (list == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        int size = list.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                break;
            }
            sb.append(list.get(i)).append("=1 or ");
            size = i;
        }
        if (list.size() > 0) {
            sb.setLength(sb.length() - 4);
        }
        sb.append(")");
        if (!z) {
            sb.append(" and ");
            sb.append(MediaStore.MediaColumns.IS_DRM);
            sb.append("=0");
        }
        return sb.toString();
    }

    /* JADX WARN: Finally extract failed */
    public static Uri getActualDefaultRingtoneUri(Context context, int i) {
        Uri uri;
        String settingForType = getSettingForType(i);
        if (settingForType == null) {
            return null;
        }
        String string = Settings.System.getString(context.getContentResolver(), settingForType);
        if (string == null || (i & 1) == 0) {
            if (string != null) {
                return Uri.parse(string);
            }
            return null;
        }
        Uri staticDefaultRingtoneUri = getStaticDefaultRingtoneUri(context);
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            try {
                Cursor query = context.getContentResolver().query(Uri.parse(string), null, null, null, null);
                Uri uri2 = staticDefaultRingtoneUri;
                if (query != null) {
                    uri2 = staticDefaultRingtoneUri;
                    if (query.getCount() > 0) {
                        cursor2 = query;
                        cursor = query;
                        uri2 = Uri.parse(string);
                    }
                }
                uri = uri2;
                if (query != null) {
                    query.close();
                    uri = uri2;
                }
            } catch (SQLiteException e) {
                cursor = cursor2;
                Log.e(TAG, "ex " + e);
                uri = staticDefaultRingtoneUri;
                if (cursor2 != null) {
                    cursor2.close();
                    uri = staticDefaultRingtoneUri;
                }
            }
            return uri;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static Uri getActualRingtoneUriBySubId(Context context, int i) {
        Uri uri = null;
        if (i >= 0) {
            if (i >= 3) {
                uri = null;
            } else {
                String string = Settings.System.getString(context.getContentResolver(), i == 0 ? Settings.System.RINGTONE : "ringtone_" + (i + 1));
                uri = null;
                if (string != null) {
                    Uri staticDefaultRingtoneUri = getStaticDefaultRingtoneUri(context);
                    Cursor cursor = null;
                    Cursor cursor2 = null;
                    try {
                        try {
                            Cursor query = context.getContentResolver().query(Uri.parse(string), null, null, null, null);
                            Uri uri2 = staticDefaultRingtoneUri;
                            if (query != null) {
                                uri2 = staticDefaultRingtoneUri;
                                if (query.getCount() > 0) {
                                    cursor2 = query;
                                    cursor = query;
                                    uri2 = Uri.parse(string);
                                }
                            }
                            uri = uri2;
                            if (query != null) {
                                query.close();
                                return uri2;
                            }
                        } catch (SQLiteException e) {
                            cursor = cursor2;
                            Log.e(TAG, "ex " + e);
                            uri = staticDefaultRingtoneUri;
                            if (cursor2 != null) {
                                cursor2.close();
                                return staticDefaultRingtoneUri;
                            }
                        }
                    } catch (Throwable th) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            }
        }
        return uri;
    }

    public static int getDefaultRingtoneSubIdByUri(Uri uri) {
        int parseInt;
        if (uri == null) {
            return -1;
        }
        if (uri.equals(Settings.System.DEFAULT_RINGTONE_URI)) {
            return 0;
        }
        String uri2 = uri.toString();
        if (!uri2.startsWith(Settings.System.DEFAULT_RINGTONE_URI.toString()) || (parseInt = Integer.parseInt(uri2.substring(uri2.lastIndexOf(BridgeUtil.UNDERLINE_STR) + 1))) <= 0 || parseInt > 3) {
            return -1;
        }
        return parseInt - 1;
    }

    public static Uri getDefaultRingtoneUriBySubId(int i) {
        if (i < 0 || i >= 3) {
            return null;
        }
        return i == 0 ? Settings.System.DEFAULT_RINGTONE_URI : Uri.parse(Settings.System.DEFAULT_RINGTONE_URI.toString() + BridgeUtil.UNDERLINE_STR + (i + 1));
    }

    public static int getDefaultType(Uri uri) {
        if (uri == null) {
            return -1;
        }
        if (uri.equals(Settings.System.DEFAULT_RINGTONE_URI) || uri.equals(Settings.System.DEFAULT_RINGTONE_URI_2) || uri.equals(Settings.System.DEFAULT_RINGTONE_URI_3)) {
            return 1;
        }
        if (uri.equals(Settings.System.DEFAULT_NOTIFICATION_URI)) {
            return 2;
        }
        return uri.equals(Settings.System.DEFAULT_ALARM_ALERT_URI) ? 4 : -1;
    }

    public static Uri getDefaultUri(int i) {
        if ((i & 1) != 0) {
            return Settings.System.DEFAULT_RINGTONE_URI;
        }
        if ((i & 2) != 0) {
            return Settings.System.DEFAULT_NOTIFICATION_URI;
        }
        if ((i & 4) != 0) {
            return Settings.System.DEFAULT_ALARM_ALERT_URI;
        }
        return null;
    }

    private Cursor getDrmRingtones() {
        return query(DrmStore.Audio.CONTENT_URI, DRM_COLUMNS, null, null, "title");
    }

    private String getExcludedExternalStorageDir() {
        if (this.mContext.getResources().getBoolean(R.bool.config_excludeRingtonesFromRemovableStorage)) {
            File secondaryStorageDirectory = Environment.getSecondaryStorageDirectory();
            if (Environment.isExternalStorageEmulated(secondaryStorageDirectory)) {
                return null;
            }
            return secondaryStorageDirectory.getAbsolutePath();
        }
        return null;
    }

    private Cursor getInternalRingtones() {
        return query(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, INTERNAL_COLUMNS, constructBooleanTrueWhereClause(this.mFilterColumns, this.mIncludeDrm), null, "title_key");
    }

    private Cursor getMediaRingtones() {
        Cursor cursor = null;
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState.equals(Environment.MEDIA_MOUNTED) || externalStorageState.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
            String constructBooleanTrueWhereClause = constructBooleanTrueWhereClause(this.mFilterColumns, this.mIncludeDrm);
            String str = constructBooleanTrueWhereClause;
            if (this.mExcludedExternalStorageDir != null) {
                str = constructBooleanTrueWhereClause + " AND _data NOT LIKE '" + this.mExcludedExternalStorageDir + "%'";
            }
            cursor = query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, MEDIA_COLUMNS, str, null, "title_key");
        }
        return cursor;
    }

    public static Ringtone getRingtone(Context context, Uri uri) {
        return getRingtone(context, uri, -1);
    }

    private static Ringtone getRingtone(Context context, Uri uri, int i) {
        try {
            Ringtone ringtone = new Ringtone(context, true);
            if (i >= 0) {
                ringtone.setStreamType(i);
            }
            ringtone.setUri(uri);
            return ringtone;
        } catch (Exception e) {
            Log.e(TAG, "Failed to open ringtone " + uri + ": " + e);
            return null;
        }
    }

    private static String getSettingForType(int i) {
        if ((i & 1) != 0) {
            return Settings.System.RINGTONE;
        }
        if ((i & 2) != 0) {
            return Settings.System.NOTIFICATION_SOUND;
        }
        if ((i & 4) != 0) {
            return Settings.System.ALARM_ALERT;
        }
        return null;
    }

    public static Uri getStaticDefaultRingtoneUri(Context context) {
        String string = Settings.System.getString(context.getContentResolver(), Settings.System.DEFAULT_RINGTONE.toString());
        if (string != null) {
            return Uri.parse(string);
        }
        return null;
    }

    private static Uri getUriFromCursor(Cursor cursor) {
        return ContentUris.withAppendedId(Uri.parse(cursor.getString(2)), cursor.getLong(0));
    }

    public static Uri getValidRingtoneUri(Context context) {
        RingtoneManager ringtoneManager = new RingtoneManager(context);
        Uri validRingtoneUriFromCursorAndClose = getValidRingtoneUriFromCursorAndClose(context, ringtoneManager.getInternalRingtones());
        Uri uri = validRingtoneUriFromCursorAndClose;
        if (validRingtoneUriFromCursorAndClose == null) {
            uri = getValidRingtoneUriFromCursorAndClose(context, ringtoneManager.getMediaRingtones());
        }
        Uri uri2 = uri;
        if (uri == null) {
            uri2 = getValidRingtoneUriFromCursorAndClose(context, ringtoneManager.getDrmRingtones());
        }
        return uri2;
    }

    private static Uri getValidRingtoneUriFromCursorAndClose(Context context, Cursor cursor) {
        if (cursor != null) {
            Uri uri = null;
            if (cursor.moveToFirst()) {
                uri = getUriFromCursor(cursor);
            }
            cursor.close();
            return uri;
        }
        return null;
    }

    public static boolean isDefault(Uri uri) {
        return getDefaultType(uri) != -1;
    }

    private Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.mActivity != null ? this.mActivity.managedQuery(uri, strArr, str, strArr2, str2) : this.mContext.getContentResolver().query(uri, strArr, str, strArr2, str2);
    }

    public static void setActualDefaultRingtoneUri(Context context, int i, Uri uri) {
        String settingForType = getSettingForType(i);
        if (settingForType == null) {
            return;
        }
        Settings.System.putString(context.getContentResolver(), settingForType, uri != null ? uri.toString() : null);
    }

    public static void setActualRingtoneUriBySubId(Context context, int i, Uri uri) {
        if (i < 0 || i >= 3) {
            return;
        }
        Settings.System.putString(context.getContentResolver(), i == 0 ? Settings.System.RINGTONE : "ringtone_" + (i + 1), uri != null ? uri.toString() : null);
    }

    private void setFilterColumnsList(int i) {
        List<String> list = this.mFilterColumns;
        list.clear();
        if ((i & 1) != 0) {
            list.add(MediaStore.Audio.AudioColumns.IS_RINGTONE);
        }
        if ((i & 2) != 0) {
            list.add(MediaStore.Audio.AudioColumns.IS_NOTIFICATION);
        }
        if ((i & 4) != 0) {
            list.add(MediaStore.Audio.AudioColumns.IS_ALARM);
        }
    }

    public Cursor getCursor() {
        if (this.mCursor == null || !this.mCursor.requery()) {
            SortCursor sortCursor = new SortCursor(new Cursor[]{getInternalRingtones(), this.mIncludeDrm ? getDrmRingtones() : null, getMediaRingtones()}, "title_key");
            this.mCursor = sortCursor;
            return sortCursor;
        }
        return this.mCursor;
    }

    public boolean getIncludeDrm() {
        return this.mIncludeDrm;
    }

    public Ringtone getRingtone(int i) {
        if (this.mStopPreviousRingtone && this.mPreviousRingtone != null) {
            this.mPreviousRingtone.stop();
        }
        this.mPreviousRingtone = getRingtone(this.mContext, getRingtoneUri(i), inferStreamType());
        return this.mPreviousRingtone;
    }

    public int getRingtonePosition(Uri uri) {
        int i;
        if (uri == null) {
            i = -1;
        } else {
            Cursor cursor = getCursor();
            int count = cursor.getCount();
            if (!cursor.moveToFirst()) {
                return -1;
            }
            Uri uri2 = null;
            Object obj = null;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= count) {
                    return -1;
                }
                String string = cursor.getString(2);
                if (uri2 == null || !string.equals(obj)) {
                    uri2 = Uri.parse(string);
                }
                i = i3;
                if (uri.equals(ContentUris.withAppendedId(uri2, cursor.getLong(0)))) {
                    break;
                }
                cursor.move(1);
                obj = string;
                i2 = i3 + 1;
            }
        }
        return i;
    }

    public Uri getRingtoneUri(int i) {
        if (this.mCursor == null || !this.mCursor.moveToPosition(i)) {
            return null;
        }
        return getUriFromCursor(this.mCursor);
    }

    public boolean getStopPreviousRingtone() {
        return this.mStopPreviousRingtone;
    }

    public int inferStreamType() {
        switch (this.mType) {
            case 2:
                return 5;
            case 3:
            default:
                return 2;
            case 4:
                return 4;
        }
    }

    public void setIncludeDrm(boolean z) {
        this.mIncludeDrm = z;
    }

    public void setStopPreviousRingtone(boolean z) {
        this.mStopPreviousRingtone = z;
    }

    public void setType(int i) {
        if (this.mCursor != null) {
            throw new IllegalStateException("Setting filter columns should be done before querying for ringtones.");
        }
        this.mType = i;
        setFilterColumnsList(i);
    }

    public void stopPreviousRingtone() {
        if (this.mPreviousRingtone != null) {
            this.mPreviousRingtone.stop();
        }
    }
}
