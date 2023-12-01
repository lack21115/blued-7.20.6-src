package android.app;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.Downloads;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import com.cdo.oaps.ad.OapsWrapper;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/app/DownloadManager.class */
public class DownloadManager {
    public static final String ACTION_DOWNLOAD_COMPLETE = "android.intent.action.DOWNLOAD_COMPLETE";
    public static final String ACTION_NOTIFICATION_CLICKED = "android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED";
    public static final String ACTION_VIEW_DOWNLOADS = "android.intent.action.VIEW_DOWNLOADS";
    public static final String COLUMN_ALLOW_WRITE = "allow_write";
    public static final String COLUMN_BYTES_DOWNLOADED_SO_FAR = "bytes_so_far";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_LAST_MODIFIED_TIMESTAMP = "last_modified_timestamp";
    public static final String COLUMN_LOCAL_FILENAME = "local_filename";
    public static final String COLUMN_LOCAL_URI = "local_uri";
    public static final String COLUMN_MEDIAPROVIDER_URI = "mediaprovider_uri";
    public static final String COLUMN_MEDIA_TYPE = "media_type";
    public static final String COLUMN_REASON = "reason";
    public static final String COLUMN_STATUS = "status";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_TOTAL_SIZE_BYTES = "total_size";
    public static final String COLUMN_URI = "uri";
    public static final int ERROR_BLOCKED = 1010;
    public static final int ERROR_CANNOT_RESUME = 1008;
    public static final int ERROR_DEVICE_NOT_FOUND = 1007;
    public static final int ERROR_FILE_ALREADY_EXISTS = 1009;
    public static final int ERROR_FILE_ERROR = 1001;
    public static final int ERROR_HTTP_DATA_ERROR = 1004;
    public static final int ERROR_INSUFFICIENT_SPACE = 1006;
    public static final int ERROR_TOO_MANY_REDIRECTS = 1005;
    public static final int ERROR_UNHANDLED_HTTP_CODE = 1002;
    public static final int ERROR_UNKNOWN = 1000;
    public static final String EXTRA_DOWNLOAD_ID = "extra_download_id";
    public static final String EXTRA_NOTIFICATION_CLICK_DOWNLOAD_IDS = "extra_click_download_ids";
    public static final String INTENT_EXTRAS_SORT_BY_SIZE = "android.app.DownloadManager.extra_sortBySize";
    private static final String NON_DOWNLOADMANAGER_DOWNLOAD = "non-dwnldmngr-download-dont-retry2download";
    public static final int PAUSED_BY_APP = 5;
    public static final int PAUSED_QUEUED_FOR_WIFI = 3;
    public static final int PAUSED_UNKNOWN = 4;
    public static final int PAUSED_WAITING_FOR_NETWORK = 2;
    public static final int PAUSED_WAITING_TO_RETRY = 1;
    public static final int STATUS_FAILED = 16;
    public static final int STATUS_PAUSED = 4;
    public static final int STATUS_PENDING = 1;
    public static final int STATUS_RUNNING = 2;
    public static final int STATUS_SUCCESSFUL = 8;
    public static final String[] UNDERLYING_COLUMNS = {"_id", "_data AS local_filename", "mediaprovider_uri", "destination", "title", "description", "uri", "status", Downloads.Impl.COLUMN_FILE_NAME_HINT, "mimetype AS media_type", "total_bytes AS total_size", "lastmod AS last_modified_timestamp", "current_bytes AS bytes_so_far", "allow_write", "'placeholder' AS local_uri", "'placeholder' AS reason"};
    private Uri mBaseUri = Downloads.Impl.CONTENT_URI;
    private String mPackageName;
    private ContentResolver mResolver;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/DownloadManager$CursorTranslator.class */
    public static class CursorTranslator extends CursorWrapper {
        static final /* synthetic */ boolean $assertionsDisabled;
        private Uri mBaseUri;

        static {
            $assertionsDisabled = !DownloadManager.class.desiredAssertionStatus();
        }

        public CursorTranslator(Cursor cursor, Uri uri) {
            super(cursor);
            this.mBaseUri = uri;
        }

        private long getErrorCode(int i) {
            if ((400 > i || i >= 488) && (500 > i || i >= 600)) {
                switch (i) {
                    case 198:
                        return 1006L;
                    case 199:
                        return 1007L;
                    case 488:
                        return 1009L;
                    case 489:
                        return 1008L;
                    case Downloads.Impl.STATUS_FILE_ERROR /* 492 */:
                        return 1001L;
                    case Downloads.Impl.STATUS_UNHANDLED_REDIRECT /* 493 */:
                    case 494:
                        return 1002L;
                    case 495:
                        return 1004L;
                    case 497:
                        return 1005L;
                    default:
                        return 1000L;
                }
            }
            return i;
        }

        private String getLocalUri() {
            long j = getLong(getColumnIndex("destination"));
            if (j != 4 && j != 0 && j != 6) {
                return ContentUris.withAppendedId(this.mBaseUri, getLong(getColumnIndex("_id"))).toString();
            }
            String string = getString(getColumnIndex(DownloadManager.COLUMN_LOCAL_FILENAME));
            if (string == null) {
                return null;
            }
            return Uri.fromFile(new File(string)).toString();
        }

        private long getPausedReason(int i) {
            switch (i) {
                case 193:
                    return 5L;
                case 194:
                    return 1L;
                case 195:
                    return 2L;
                case 196:
                    return 3L;
                default:
                    return 4L;
            }
        }

        private long getReason(int i) {
            switch (translateStatus(i)) {
                case 4:
                    return getPausedReason(i);
                case 16:
                    return getErrorCode(i);
                default:
                    return 0L;
            }
        }

        private int translateStatus(int i) {
            switch (i) {
                case 190:
                    return 1;
                case 191:
                case 197:
                case 198:
                case 199:
                default:
                    if ($assertionsDisabled || Downloads.Impl.isStatusError(i)) {
                        return 16;
                    }
                    throw new AssertionError();
                case 192:
                    return 2;
                case 193:
                case 194:
                case 195:
                case 196:
                    return 4;
                case 200:
                    return 8;
            }
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public int getInt(int i) {
            return (int) getLong(i);
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public long getLong(int i) {
            return getColumnName(i).equals("reason") ? getReason(super.getInt(getColumnIndex("status"))) : getColumnName(i).equals("status") ? translateStatus(super.getInt(getColumnIndex("status"))) : super.getLong(i);
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public String getString(int i) {
            return getColumnName(i).equals(DownloadManager.COLUMN_LOCAL_URI) ? getLocalUri() : super.getString(i);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/DownloadManager$Query.class */
    public static class Query {
        public static final int ORDER_ASCENDING = 1;
        public static final int ORDER_DESCENDING = 2;
        private long[] mIds = null;
        private Integer mStatusFlags = null;
        private String mOrderByColumn = Downloads.Impl.COLUMN_LAST_MODIFICATION;
        private int mOrderDirection = 2;
        private boolean mOnlyIncludeVisibleInDownloadsUi = false;

        private String joinStrings(String str, Iterable<String> iterable) {
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (String str2 : iterable) {
                if (!z) {
                    sb.append(str);
                }
                sb.append(str2);
                z = false;
            }
            return sb.toString();
        }

        private String statusClause(String str, int i) {
            return "status" + str + "'" + i + "'";
        }

        public Query orderBy(String str, int i) {
            if (i == 1 || i == 2) {
                if (str.equals(DownloadManager.COLUMN_LAST_MODIFIED_TIMESTAMP)) {
                    this.mOrderByColumn = Downloads.Impl.COLUMN_LAST_MODIFICATION;
                } else if (!str.equals(DownloadManager.COLUMN_TOTAL_SIZE_BYTES)) {
                    throw new IllegalArgumentException("Cannot order by " + str);
                } else {
                    this.mOrderByColumn = "total_bytes";
                }
                this.mOrderDirection = i;
                return this;
            }
            throw new IllegalArgumentException("Invalid direction: " + i);
        }

        Cursor runQuery(ContentResolver contentResolver, String[] strArr, Uri uri) {
            ArrayList arrayList = new ArrayList();
            String[] strArr2 = null;
            if (this.mIds != null) {
                arrayList.add(DownloadManager.getWhereClauseForIds(this.mIds));
                strArr2 = DownloadManager.getWhereArgsForIds(this.mIds);
            }
            if (this.mStatusFlags != null) {
                ArrayList arrayList2 = new ArrayList();
                if ((this.mStatusFlags.intValue() & 1) != 0) {
                    arrayList2.add(statusClause("=", 190));
                }
                if ((this.mStatusFlags.intValue() & 2) != 0) {
                    arrayList2.add(statusClause("=", 192));
                }
                if ((this.mStatusFlags.intValue() & 4) != 0) {
                    arrayList2.add(statusClause("=", 193));
                    arrayList2.add(statusClause("=", 194));
                    arrayList2.add(statusClause("=", 195));
                    arrayList2.add(statusClause("=", 196));
                }
                if ((this.mStatusFlags.intValue() & 8) != 0) {
                    arrayList2.add(statusClause("=", 200));
                }
                if ((this.mStatusFlags.intValue() & 16) != 0) {
                    arrayList2.add("(" + statusClause(SimpleComparison.GREATER_THAN_EQUAL_TO_OPERATION, 400) + " AND " + statusClause(SimpleComparison.LESS_THAN_OPERATION, 600) + ")");
                }
                arrayList.add(joinStrings(" OR ", arrayList2));
            }
            if (this.mOnlyIncludeVisibleInDownloadsUi) {
                arrayList.add("is_visible_in_downloads_ui != '0'");
            }
            arrayList.add("deleted != '1'");
            return contentResolver.query(uri, strArr, joinStrings(" AND ", arrayList), strArr2, this.mOrderByColumn + " " + (this.mOrderDirection == 1 ? "ASC" : "DESC"));
        }

        public Query setFilterById(long... jArr) {
            this.mIds = jArr;
            return this;
        }

        public Query setFilterByStatus(int i) {
            this.mStatusFlags = Integer.valueOf(i);
            return this;
        }

        public Query setOnlyIncludeVisibleInDownloadsUi(boolean z) {
            this.mOnlyIncludeVisibleInDownloadsUi = z;
            return this;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/DownloadManager$Request.class */
    public static class Request {
        static final /* synthetic */ boolean $assertionsDisabled;
        public static final int NETWORK_BLUETOOTH = 4;
        public static final int NETWORK_MOBILE = 1;
        public static final int NETWORK_WIFI = 2;
        private static final int SCANNABLE_VALUE_NO = 2;
        private static final int SCANNABLE_VALUE_YES = 0;
        public static final int VISIBILITY_HIDDEN = 2;
        public static final int VISIBILITY_VISIBLE = 0;
        public static final int VISIBILITY_VISIBLE_NOTIFY_COMPLETED = 1;
        public static final int VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION = 3;
        private CharSequence mDescription;
        private Uri mDestinationUri;
        private String mMimeType;
        private CharSequence mTitle;
        private Uri mUri;
        private List<Pair<String, String>> mRequestHeaders = new ArrayList();
        private int mAllowedNetworkTypes = -1;
        private boolean mRoamingAllowed = true;
        private boolean mMeteredAllowed = true;
        private boolean mIsVisibleInDownloadsUi = true;
        private boolean mScannable = false;
        private boolean mUseSystemCache = false;
        private int mNotificationVisibility = 0;

        static {
            $assertionsDisabled = !DownloadManager.class.desiredAssertionStatus();
        }

        public Request(Uri uri) {
            if (uri == null) {
                throw new NullPointerException();
            }
            String scheme = uri.getScheme();
            if (scheme == null || !(scheme.equals("http") || scheme.equals("https"))) {
                throw new IllegalArgumentException("Can only download HTTP/HTTPS URIs: " + uri);
            }
            this.mUri = uri;
        }

        Request(String str) {
            this.mUri = Uri.parse(str);
        }

        private void encodeHttpHeaders(ContentValues contentValues) {
            int i = 0;
            for (Pair<String, String> pair : this.mRequestHeaders) {
                contentValues.put(Downloads.Impl.RequestHeaders.INSERT_KEY_PREFIX + i, pair.first + ": " + pair.second);
                i++;
            }
        }

        private void putIfNonNull(ContentValues contentValues, String str, Object obj) {
            if (obj != null) {
                contentValues.put(str, obj.toString());
            }
        }

        private void setDestinationFromBase(File file, String str) {
            if (str == null) {
                throw new NullPointerException("subPath cannot be null");
            }
            this.mDestinationUri = Uri.withAppendedPath(Uri.fromFile(file), str);
        }

        public Request addRequestHeader(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("header cannot be null");
            }
            if (str.contains(":")) {
                throw new IllegalArgumentException("header may not contain ':'");
            }
            String str3 = str2;
            if (str2 == null) {
                str3 = "";
            }
            this.mRequestHeaders.add(Pair.create(str, str3));
            return this;
        }

        public void allowScanningByMediaScanner() {
            this.mScannable = true;
        }

        public Request setAllowedNetworkTypes(int i) {
            this.mAllowedNetworkTypes = i;
            return this;
        }

        public Request setAllowedOverMetered(boolean z) {
            this.mMeteredAllowed = z;
            return this;
        }

        public Request setAllowedOverRoaming(boolean z) {
            this.mRoamingAllowed = z;
            return this;
        }

        public Request setDescription(CharSequence charSequence) {
            this.mDescription = charSequence;
            return this;
        }

        public Request setDestinationInExternalFilesDir(Context context, String str, String str2) {
            File externalFilesDir = context.getExternalFilesDir(str);
            if (externalFilesDir == null) {
                throw new IllegalStateException("Failed to get external storage files directory");
            }
            if (externalFilesDir.exists()) {
                if (!externalFilesDir.isDirectory()) {
                    throw new IllegalStateException(externalFilesDir.getAbsolutePath() + " already exists and is not a directory");
                }
            } else if (!externalFilesDir.mkdirs()) {
                throw new IllegalStateException("Unable to create directory: " + externalFilesDir.getAbsolutePath());
            }
            setDestinationFromBase(externalFilesDir, str2);
            return this;
        }

        public Request setDestinationInExternalPublicDir(String str, String str2) {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(str);
            if (externalStoragePublicDirectory == null) {
                throw new IllegalStateException("Failed to get external storage public directory");
            }
            if (externalStoragePublicDirectory.exists()) {
                if (!externalStoragePublicDirectory.isDirectory()) {
                    throw new IllegalStateException(externalStoragePublicDirectory.getAbsolutePath() + " already exists and is not a directory");
                }
            } else if (!externalStoragePublicDirectory.mkdirs()) {
                throw new IllegalStateException("Unable to create directory: " + externalStoragePublicDirectory.getAbsolutePath());
            }
            setDestinationFromBase(externalStoragePublicDirectory, str2);
            return this;
        }

        public Request setDestinationToSystemCache() {
            this.mUseSystemCache = true;
            return this;
        }

        public Request setDestinationUri(Uri uri) {
            this.mDestinationUri = uri;
            return this;
        }

        public Request setMimeType(String str) {
            this.mMimeType = str;
            return this;
        }

        public Request setNotificationVisibility(int i) {
            this.mNotificationVisibility = i;
            return this;
        }

        @Deprecated
        public Request setShowRunningNotification(boolean z) {
            return z ? setNotificationVisibility(0) : setNotificationVisibility(2);
        }

        public Request setTitle(CharSequence charSequence) {
            this.mTitle = charSequence;
            return this;
        }

        public Request setVisibleInDownloadsUi(boolean z) {
            this.mIsVisibleInDownloadsUi = z;
            return this;
        }

        ContentValues toContentValues(String str) {
            ContentValues contentValues = new ContentValues();
            if ($assertionsDisabled || this.mUri != null) {
                contentValues.put("uri", this.mUri.toString());
                contentValues.put(Downloads.Impl.COLUMN_IS_PUBLIC_API, (Boolean) true);
                contentValues.put(Downloads.Impl.COLUMN_NOTIFICATION_PACKAGE, str);
                if (this.mDestinationUri != null) {
                    contentValues.put("destination", (Integer) 4);
                    contentValues.put(Downloads.Impl.COLUMN_FILE_NAME_HINT, this.mDestinationUri.toString());
                } else {
                    contentValues.put("destination", Integer.valueOf(this.mUseSystemCache ? 5 : 2));
                }
                int i = 2;
                if (this.mScannable) {
                    i = 0;
                }
                contentValues.put(Downloads.Impl.COLUMN_MEDIA_SCANNED, Integer.valueOf(i));
                if (!this.mRequestHeaders.isEmpty()) {
                    encodeHttpHeaders(contentValues);
                }
                putIfNonNull(contentValues, "title", this.mTitle);
                putIfNonNull(contentValues, "description", this.mDescription);
                putIfNonNull(contentValues, "mimetype", this.mMimeType);
                contentValues.put("visibility", Integer.valueOf(this.mNotificationVisibility));
                contentValues.put(Downloads.Impl.COLUMN_ALLOWED_NETWORK_TYPES, Integer.valueOf(this.mAllowedNetworkTypes));
                contentValues.put(Downloads.Impl.COLUMN_ALLOW_ROAMING, Boolean.valueOf(this.mRoamingAllowed));
                contentValues.put("allow_metered", Boolean.valueOf(this.mMeteredAllowed));
                contentValues.put(Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, Boolean.valueOf(this.mIsVisibleInDownloadsUi));
                return contentValues;
            }
            throw new AssertionError();
        }
    }

    public DownloadManager(ContentResolver contentResolver, String str) {
        this.mResolver = contentResolver;
        this.mPackageName = str;
    }

    public static long getActiveNetworkWarningBytes(Context context) {
        return -1L;
    }

    public static Long getMaxBytesOverMobile(Context context) {
        try {
            return Long.valueOf(Settings.Global.getLong(context.getContentResolver(), Settings.Global.DOWNLOAD_MAX_BYTES_OVER_MOBILE));
        } catch (Settings.SettingNotFoundException e) {
            return null;
        }
    }

    public static Long getRecommendedMaxBytesOverMobile(Context context) {
        try {
            return Long.valueOf(Settings.Global.getLong(context.getContentResolver(), Settings.Global.DOWNLOAD_RECOMMENDED_MAX_BYTES_OVER_MOBILE));
        } catch (Settings.SettingNotFoundException e) {
            return null;
        }
    }

    static String[] getWhereArgsForIds(long[] jArr) {
        String[] strArr = new String[jArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= jArr.length) {
                return strArr;
            }
            strArr[i2] = Long.toString(jArr[i2]);
            i = i2 + 1;
        }
    }

    static String getWhereClauseForIds(long[] jArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= jArr.length) {
                sb.append(")");
                return sb.toString();
            }
            if (i2 > 0) {
                sb.append("OR ");
            }
            sb.append("_id");
            sb.append(" = ? ");
            i = i2 + 1;
        }
    }

    public static boolean isActiveNetworkExpensive(Context context) {
        return false;
    }

    private static void validateArgumentIsNonEmpty(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException(str + " can't be null");
        }
    }

    public long addCompletedDownload(String str, String str2, boolean z, String str3, String str4, long j, boolean z2) {
        return addCompletedDownload(str, str2, z, str3, str4, j, z2, false);
    }

    public long addCompletedDownload(String str, String str2, boolean z, String str3, String str4, long j, boolean z2, boolean z3) {
        validateArgumentIsNonEmpty("title", str);
        validateArgumentIsNonEmpty("description", str2);
        validateArgumentIsNonEmpty(OapsWrapper.KEY_PATH, str4);
        validateArgumentIsNonEmpty(DBDefinition.MIME_TYPE, str3);
        if (j < 0) {
            throw new IllegalArgumentException(" invalid value for param: totalBytes");
        }
        ContentValues contentValues = new Request(NON_DOWNLOADMANAGER_DOWNLOAD).setTitle(str).setDescription(str2).setMimeType(str3).toContentValues(null);
        contentValues.put("destination", (Integer) 6);
        contentValues.put("_data", str4);
        contentValues.put("status", (Integer) 200);
        contentValues.put("total_bytes", Long.valueOf(j));
        contentValues.put(Downloads.Impl.COLUMN_MEDIA_SCANNED, Integer.valueOf(z ? 0 : 2));
        contentValues.put("visibility", Integer.valueOf(z2 ? 3 : 2));
        contentValues.put("allow_write", Integer.valueOf(z3 ? 1 : 0));
        Uri insert = this.mResolver.insert(Downloads.Impl.CONTENT_URI, contentValues);
        if (insert == null) {
            return -1L;
        }
        return Long.parseLong(insert.getLastPathSegment());
    }

    public long enqueue(Request request) {
        return Long.parseLong(this.mResolver.insert(Downloads.Impl.CONTENT_URI, request.toContentValues(this.mPackageName)).getLastPathSegment());
    }

    public Uri getDownloadUri(long j) {
        return ContentUris.withAppendedId(this.mBaseUri, j);
    }

    public String getMimeTypeForDownloadedFile(long j) {
        String str;
        Cursor cursor = null;
        try {
            Cursor query = query(new Query().setFilterById(j));
            if (query == null) {
                str = null;
                if (query != null) {
                    query.close();
                    str = null;
                }
            } else if (query.moveToFirst()) {
                cursor = query;
                String string = query.getString(query.getColumnIndexOrThrow("media_type"));
                str = string;
                if (query != null) {
                    query.close();
                    return string;
                }
            } else {
                str = null;
                if (query != null) {
                    query.close();
                    return null;
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

    public Uri getUriForDownloadedFile(long j) {
        Uri uri;
        AutoCloseable autoCloseable = null;
        try {
            Cursor query = query(new Query().setFilterById(j));
            if (query == null) {
                uri = null;
                if (query != null) {
                    query.close();
                    uri = null;
                }
            } else if (query.moveToFirst() && 8 == query.getInt(query.getColumnIndexOrThrow("status"))) {
                int i = query.getInt(query.getColumnIndexOrThrow("destination"));
                if (i == 1 || i == 5 || i == 3 || i == 2) {
                    Uri withAppendedId = ContentUris.withAppendedId(Downloads.Impl.CONTENT_URI, j);
                    uri = withAppendedId;
                    if (query != null) {
                        query.close();
                        return withAppendedId;
                    }
                } else {
                    Uri fromFile = Uri.fromFile(new File(query.getString(query.getColumnIndexOrThrow(COLUMN_LOCAL_FILENAME))));
                    uri = fromFile;
                    if (query != null) {
                        query.close();
                        return fromFile;
                    }
                }
            } else {
                uri = null;
                if (query != null) {
                    query.close();
                    return null;
                }
            }
            return uri;
        } catch (Throwable th) {
            if (0 != 0) {
                autoCloseable.close();
            }
            throw th;
        }
    }

    public int markRowDeleted(long... jArr) {
        if (jArr == null || jArr.length == 0) {
            throw new IllegalArgumentException("input param 'ids' can't be null");
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("deleted", (Integer) 1);
        return jArr.length == 1 ? this.mResolver.update(ContentUris.withAppendedId(this.mBaseUri, jArr[0]), contentValues, null, null) : this.mResolver.update(this.mBaseUri, contentValues, getWhereClauseForIds(jArr), getWhereArgsForIds(jArr));
    }

    public ParcelFileDescriptor openDownloadedFile(long j) throws FileNotFoundException {
        return this.mResolver.openFileDescriptor(getDownloadUri(j), "r");
    }

    public void pauseDownload(long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Downloads.Impl.COLUMN_CONTROL, (Integer) 1);
        this.mResolver.update(ContentUris.withAppendedId(this.mBaseUri, j), contentValues, null, null);
    }

    public Cursor query(Query query) {
        Cursor runQuery = query.runQuery(this.mResolver, UNDERLYING_COLUMNS, this.mBaseUri);
        if (runQuery == null) {
            return null;
        }
        return new CursorTranslator(runQuery, this.mBaseUri);
    }

    public int remove(long... jArr) {
        return markRowDeleted(jArr);
    }

    public void restartDownload(long... jArr) {
        Cursor query = query(new Query().setFilterById(jArr));
        try {
            query.moveToFirst();
            while (!query.isAfterLast()) {
                int i = query.getInt(query.getColumnIndex("status"));
                if (i != 8 && i != 16) {
                    throw new IllegalArgumentException("Cannot restart incomplete download: " + query.getLong(query.getColumnIndex("_id")));
                }
                query.moveToNext();
            }
            query.close();
            ContentValues contentValues = new ContentValues();
            contentValues.put(Downloads.Impl.COLUMN_CURRENT_BYTES, (Integer) 0);
            contentValues.put("total_bytes", (Integer) (-1));
            contentValues.putNull("_data");
            contentValues.put("status", (Integer) 190);
            contentValues.put(Downloads.Impl.COLUMN_FAILED_CONNECTIONS, (Integer) 0);
            this.mResolver.update(this.mBaseUri, contentValues, getWhereClauseForIds(jArr), getWhereArgsForIds(jArr));
        } catch (Throwable th) {
            query.close();
            throw th;
        }
    }

    public void resumeDownload(long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Downloads.Impl.COLUMN_CONTROL, (Integer) 0);
        this.mResolver.update(ContentUris.withAppendedId(this.mBaseUri, j), contentValues, null, null);
    }

    public void setAccessAllDownloads(boolean z) {
        if (z) {
            this.mBaseUri = Downloads.Impl.ALL_DOWNLOADS_CONTENT_URI;
        } else {
            this.mBaseUri = Downloads.Impl.CONTENT_URI;
        }
    }
}
