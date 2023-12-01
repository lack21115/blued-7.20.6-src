package android.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.Semaphore;

/* loaded from: source-9557208-dex2jar.jar:android/provider/SearchRecentSuggestions.class */
public class SearchRecentSuggestions {
    private static final String LOG_TAG = "SearchSuggestions";
    private static final int MAX_HISTORY_COUNT = 250;
    public static final int QUERIES_PROJECTION_DATE_INDEX = 1;
    public static final int QUERIES_PROJECTION_DISPLAY1_INDEX = 3;
    public static final int QUERIES_PROJECTION_DISPLAY2_INDEX = 4;
    public static final int QUERIES_PROJECTION_QUERY_INDEX = 2;
    private final String mAuthority;
    private final Context mContext;
    private final Uri mSuggestionsUri;
    private final boolean mTwoLineDisplay;
    public static final String[] QUERIES_PROJECTION_1LINE = {"_id", "date", "query", SuggestionColumns.DISPLAY1};
    public static final String[] QUERIES_PROJECTION_2LINE = {"_id", "date", "query", SuggestionColumns.DISPLAY1, SuggestionColumns.DISPLAY2};
    private static final Semaphore sWritesInProgress = new Semaphore(0);

    /* loaded from: source-9557208-dex2jar.jar:android/provider/SearchRecentSuggestions$SuggestionColumns.class */
    private static class SuggestionColumns implements BaseColumns {
        public static final String DATE = "date";
        public static final String DISPLAY1 = "display1";
        public static final String DISPLAY2 = "display2";
        public static final String QUERY = "query";

        private SuggestionColumns() {
        }
    }

    public SearchRecentSuggestions(Context context, String str, int i) {
        if (TextUtils.isEmpty(str) || (i & 1) == 0) {
            throw new IllegalArgumentException();
        }
        this.mTwoLineDisplay = (i & 2) != 0;
        this.mContext = context;
        this.mAuthority = new String(str);
        this.mSuggestionsUri = Uri.parse("content://" + this.mAuthority + "/suggestions");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveRecentQueryBlocking(String str, String str2) {
        ContentResolver contentResolver = this.mContext.getContentResolver();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(SuggestionColumns.DISPLAY1, str);
            if (this.mTwoLineDisplay) {
                contentValues.put(SuggestionColumns.DISPLAY2, str2);
            }
            contentValues.put("query", str);
            contentValues.put("date", Long.valueOf(currentTimeMillis));
            contentResolver.insert(this.mSuggestionsUri, contentValues);
        } catch (RuntimeException e) {
            Log.e(LOG_TAG, "saveRecentQuery", e);
        }
        truncateHistory(contentResolver, 250);
    }

    public void clearHistory() {
        truncateHistory(this.mContext.getContentResolver(), 0);
    }

    public void saveRecentQuery(final String str, final String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.mTwoLineDisplay && !TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException();
        }
        new Thread("saveRecentQuery") { // from class: android.provider.SearchRecentSuggestions.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                SearchRecentSuggestions.this.saveRecentQueryBlocking(str, str2);
                SearchRecentSuggestions.sWritesInProgress.release();
            }
        }.start();
    }

    protected void truncateHistory(ContentResolver contentResolver, int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        String str = null;
        if (i > 0) {
            try {
                str = "_id IN (SELECT _id FROM suggestions ORDER BY date DESC LIMIT -1 OFFSET " + String.valueOf(i) + ")";
            } catch (RuntimeException e) {
                Log.e(LOG_TAG, "truncateHistory", e);
                return;
            }
        }
        contentResolver.delete(this.mSuggestionsUri, str, null);
    }

    void waitForSave() {
        do {
            sWritesInProgress.acquireUninterruptibly();
        } while (sWritesInProgress.availablePermits() > 0);
    }
}
