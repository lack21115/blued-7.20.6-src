package android.provider;

import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.provider.BrowserContract;
import android.util.Log;
import android.webkit.WebIconDatabase;
import com.android.internal.R;

/* loaded from: source-9557208-dex2jar.jar:android/provider/Browser.class */
public class Browser {
    public static final String EXTRA_APPLICATION_ID = "com.android.browser.application_id";
    public static final String EXTRA_CREATE_NEW_TAB = "create_new_tab";
    public static final String EXTRA_HEADERS = "com.android.browser.headers";
    public static final String EXTRA_SHARE_FAVICON = "share_favicon";
    public static final String EXTRA_SHARE_SCREENSHOT = "share_screenshot";
    public static final int HISTORY_PROJECTION_BOOKMARK_INDEX = 4;
    public static final int HISTORY_PROJECTION_DATE_INDEX = 3;
    public static final int HISTORY_PROJECTION_FAVICON_INDEX = 6;
    public static final int HISTORY_PROJECTION_ID_INDEX = 0;
    public static final int HISTORY_PROJECTION_THUMBNAIL_INDEX = 7;
    public static final int HISTORY_PROJECTION_TITLE_INDEX = 5;
    public static final int HISTORY_PROJECTION_TOUCH_ICON_INDEX = 8;
    public static final int HISTORY_PROJECTION_URL_INDEX = 1;
    public static final int HISTORY_PROJECTION_VISITS_INDEX = 2;
    public static final String INITIAL_ZOOM_LEVEL = "browser.initialZoomLevel";
    private static final String LOGTAG = "browser";
    private static final int MAX_HISTORY_COUNT = 250;
    public static final int SEARCHES_PROJECTION_DATE_INDEX = 2;
    public static final int SEARCHES_PROJECTION_SEARCH_INDEX = 1;
    public static final int TRUNCATE_HISTORY_PROJECTION_ID_INDEX = 0;
    public static final int TRUNCATE_N_OLDEST = 5;
    public static final Uri BOOKMARKS_URI = Uri.parse("content://browser/bookmarks");
    public static final String[] HISTORY_PROJECTION = {"_id", "url", "visits", "date", "bookmark", "title", "favicon", "thumbnail", "touch_icon", "user_entered"};
    public static final String[] TRUNCATE_HISTORY_PROJECTION = {"_id", "date"};
    public static final Uri SEARCHES_URI = Uri.parse("content://browser/searches");
    public static final String[] SEARCHES_PROJECTION = {"_id", "search", "date"};

    /* loaded from: source-9557208-dex2jar.jar:android/provider/Browser$BookmarkColumns.class */
    public static class BookmarkColumns implements BaseColumns {
        public static final String BOOKMARK = "bookmark";
        public static final String CREATED = "created";
        public static final String DATE = "date";
        public static final String FAVICON = "favicon";
        public static final String THUMBNAIL = "thumbnail";
        public static final String TITLE = "title";
        public static final String TOUCH_ICON = "touch_icon";
        public static final String URL = "url";
        public static final String USER_ENTERED = "user_entered";
        public static final String VISITS = "visits";
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/Browser$SearchColumns.class */
    public static class SearchColumns implements BaseColumns {
        public static final String DATE = "date";
        public static final String SEARCH = "search";
        @Deprecated
        public static final String URL = "url";
    }

    private static final void addOrUrlEquals(StringBuilder sb) {
        sb.append(" OR url = ");
    }

    public static final void addSearchUrl(ContentResolver contentResolver, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("search", str);
        contentValues.put("date", Long.valueOf(System.currentTimeMillis()));
        contentResolver.insert(BrowserContract.Searches.CONTENT_URI, contentValues);
    }

    public static final boolean canClearHistory(ContentResolver contentResolver) {
        boolean z = null;
        Cursor cursor = null;
        boolean z2 = false;
        try {
            try {
                Cursor query = contentResolver.query(BrowserContract.History.CONTENT_URI, new String[]{"_id", "visits"}, null, null, null);
                cursor = query;
                z = query;
                boolean z3 = query.getCount() > 0;
                z2 = z3;
                if (query != null) {
                    query.close();
                    z2 = z3;
                }
            } catch (IllegalStateException e) {
                z = cursor;
                Log.e(LOGTAG, "canClearHistory", e);
                if (cursor != null) {
                    cursor.close();
                    return false;
                }
            }
            return z;
        } finally {
            if (z != null) {
                z.close();
            }
        }
    }

    public static final void clearHistory(ContentResolver contentResolver) {
        deleteHistoryWhere(contentResolver, null);
    }

    public static final void clearSearches(ContentResolver contentResolver) {
        try {
            contentResolver.delete(BrowserContract.Searches.CONTENT_URI, null, null);
        } catch (IllegalStateException e) {
            Log.e(LOGTAG, "clearSearches", e);
        }
    }

    public static final void deleteFromHistory(ContentResolver contentResolver, String str) {
        contentResolver.delete(BrowserContract.History.CONTENT_URI, "url=?", new String[]{str});
    }

    public static final void deleteHistoryTimeFrame(ContentResolver contentResolver, long j, long j2) {
        String str;
        if (-1 != j) {
            str = -1 == j2 ? "date >= " + Long.toString(j) : "date >= " + Long.toString(j) + " AND date < " + Long.toString(j2);
        } else if (-1 == j2) {
            clearHistory(contentResolver);
            return;
        } else {
            str = "date < " + Long.toString(j2);
        }
        deleteHistoryWhere(contentResolver, str);
    }

    private static final void deleteHistoryWhere(ContentResolver contentResolver, String str) {
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            try {
                Cursor query = contentResolver.query(BrowserContract.History.CONTENT_URI, new String[]{"url"}, str, null, null);
                if (query.moveToFirst()) {
                    cursor2 = query;
                    cursor = query;
                    contentResolver.delete(BrowserContract.History.CONTENT_URI, str, null);
                }
                if (query != null) {
                    query.close();
                }
            } catch (IllegalStateException e) {
                cursor = cursor2;
                Log.e(LOGTAG, "deleteHistoryWhere", e);
                if (cursor2 != null) {
                    cursor2.close();
                }
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static final Cursor getAllBookmarks(ContentResolver contentResolver) throws IllegalStateException {
        return contentResolver.query(BrowserContract.Bookmarks.CONTENT_URI, new String[]{"url"}, "folder = 0", null, null);
    }

    public static final Cursor getAllVisitedUrls(ContentResolver contentResolver) throws IllegalStateException {
        return contentResolver.query(BrowserContract.Combined.CONTENT_URI, new String[]{"url"}, null, null, "created ASC");
    }

    public static final String[] getVisitedHistory(ContentResolver contentResolver) {
        String[] strArr;
        Cursor query;
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            try {
                query = contentResolver.query(BrowserContract.History.CONTENT_URI, new String[]{"url"}, "visits > 0", null, null);
            } catch (IllegalStateException e) {
                Log.e(LOGTAG, "getVisitedHistory", e);
                cursor = cursor2;
                String[] strArr2 = new String[0];
                strArr = strArr2;
                if (cursor2 != null) {
                    cursor2.close();
                    strArr = strArr2;
                }
            }
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                return new String[0];
            }
            String[] strArr3 = new String[query.getCount()];
            int i = 0;
            while (true) {
                int i2 = i;
                cursor2 = query;
                cursor = query;
                if (!query.moveToNext()) {
                    break;
                }
                strArr3[i2] = query.getString(0);
                i = i2 + 1;
            }
            strArr = strArr3;
            if (query != null) {
                query.close();
                strArr = strArr3;
            }
            return strArr;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private static final Cursor getVisitedLike(ContentResolver contentResolver, String str) {
        String str2;
        StringBuilder sb;
        boolean z = false;
        if (str.startsWith("http://")) {
            str2 = str.substring(7);
        } else {
            str2 = str;
            if (str.startsWith("https://")) {
                str2 = str.substring(8);
                z = true;
            }
        }
        String str3 = str2;
        if (str2.startsWith("www.")) {
            str3 = str2.substring(4);
        }
        if (z) {
            sb = new StringBuilder("url = ");
            DatabaseUtils.appendEscapedSQLString(sb, "https://" + str3);
            addOrUrlEquals(sb);
            DatabaseUtils.appendEscapedSQLString(sb, "https://www." + str3);
        } else {
            sb = new StringBuilder("url = ");
            DatabaseUtils.appendEscapedSQLString(sb, str3);
            addOrUrlEquals(sb);
            String str4 = "www." + str3;
            DatabaseUtils.appendEscapedSQLString(sb, str4);
            addOrUrlEquals(sb);
            DatabaseUtils.appendEscapedSQLString(sb, "http://" + str3);
            addOrUrlEquals(sb);
            DatabaseUtils.appendEscapedSQLString(sb, "http://" + str4);
        }
        return contentResolver.query(BrowserContract.History.CONTENT_URI, new String[]{"_id", "visits"}, sb.toString(), null, null);
    }

    public static final void requestAllIcons(ContentResolver contentResolver, String str, WebIconDatabase.IconListener iconListener) {
    }

    public static final void saveBookmark(Context context, String str, String str2) {
        Intent intent = new Intent("android.intent.action.INSERT", BOOKMARKS_URI);
        intent.putExtra("title", str);
        intent.putExtra("url", str2);
        context.startActivity(intent);
    }

    public static final void sendString(Context context, String str) {
        sendString(context, str, context.getString(R.string.sendText));
    }

    public static final void sendString(Context context, String str, String str2) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, str);
        try {
            Intent createChooser = Intent.createChooser(intent, str2);
            createChooser.setFlags(268435456);
            context.startActivity(createChooser);
        } catch (ActivityNotFoundException e) {
        }
    }

    public static final void truncateHistory(ContentResolver contentResolver) {
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            try {
                Cursor query = contentResolver.query(BrowserContract.History.CONTENT_URI, new String[]{"_id", "url", "date"}, null, null, "date ASC");
                if (query.moveToFirst() && query.getCount() >= 250) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= 5) {
                            break;
                        }
                        cursor2 = query;
                        cursor = query;
                        contentResolver.delete(ContentUris.withAppendedId(BrowserContract.History.CONTENT_URI, query.getLong(0)), null, null);
                        if (!query.moveToNext()) {
                            break;
                        }
                        i = i2 + 1;
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (IllegalStateException e) {
                cursor = cursor2;
                Log.e(LOGTAG, "truncateHistory", e);
                if (cursor2 != null) {
                    cursor2.close();
                }
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static final void updateVisitedHistory(ContentResolver contentResolver, String str, boolean z) {
        int i;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        AutoCloseable autoCloseable = null;
        AutoCloseable autoCloseable2 = null;
        try {
            try {
                Cursor visitedLike = getVisitedLike(contentResolver, str);
                if (visitedLike.moveToFirst()) {
                    ContentValues contentValues = new ContentValues();
                    if (z) {
                        contentValues.put("visits", Integer.valueOf(visitedLike.getInt(1) + 1));
                    } else {
                        contentValues.put("user_entered", (Integer) 1);
                    }
                    contentValues.put("date", Long.valueOf(currentTimeMillis));
                    contentResolver.update(ContentUris.withAppendedId(BrowserContract.History.CONTENT_URI, visitedLike.getLong(0)), contentValues, null, null);
                } else {
                    truncateHistory(contentResolver);
                    ContentValues contentValues2 = new ContentValues();
                    if (z) {
                        i = 1;
                        i2 = 0;
                    } else {
                        i = 0;
                        i2 = 1;
                    }
                    contentValues2.put("url", str);
                    contentValues2.put("visits", Integer.valueOf(i));
                    contentValues2.put("date", Long.valueOf(currentTimeMillis));
                    contentValues2.put("title", str);
                    contentValues2.put("created", (Integer) 0);
                    contentValues2.put("user_entered", Integer.valueOf(i2));
                    contentResolver.insert(BrowserContract.History.CONTENT_URI, contentValues2);
                }
                if (visitedLike != null) {
                    visitedLike.close();
                }
            } catch (IllegalStateException e) {
                Log.e(LOGTAG, "updateVisitedHistory", e);
                if (0 != 0) {
                    autoCloseable2.close();
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                autoCloseable.close();
            }
            throw th;
        }
    }
}
