package android.database.sqlite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/database/sqlite/SQLiteOpenHelper.class */
public abstract class SQLiteOpenHelper {
    private static final boolean DEBUG_STRICT_READONLY = false;
    private static final String TAG = SQLiteOpenHelper.class.getSimpleName();
    private final Context mContext;
    private SQLiteDatabase mDatabase;
    private boolean mEnableWriteAheadLogging;
    private final DatabaseErrorHandler mErrorHandler;
    private final SQLiteDatabase.CursorFactory mFactory;
    private boolean mIsInitializing;
    private final String mName;
    private final int mNewVersion;

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        this(context, str, cursorFactory, i, null);
    }

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i, DatabaseErrorHandler databaseErrorHandler) {
        if (i < 1) {
            throw new IllegalArgumentException("Version must be >= 1, was " + i);
        }
        this.mContext = context;
        this.mName = str;
        this.mFactory = cursorFactory;
        this.mNewVersion = i;
        this.mErrorHandler = databaseErrorHandler;
    }

    private SQLiteDatabase getDatabaseLocked(boolean z) {
        SQLiteDatabase openDatabase;
        SQLiteDatabase sQLiteDatabase;
        if (this.mDatabase != null) {
            if (!this.mDatabase.isOpen()) {
                this.mDatabase = null;
            } else if (!z || !this.mDatabase.isReadOnly()) {
                sQLiteDatabase = this.mDatabase;
                return sQLiteDatabase;
            }
        }
        if (this.mIsInitializing) {
            throw new IllegalStateException("getDatabase called recursively");
        }
        SQLiteDatabase sQLiteDatabase2 = this.mDatabase;
        SQLiteDatabase sQLiteDatabase3 = sQLiteDatabase2;
        try {
            this.mIsInitializing = true;
            if (sQLiteDatabase2 != null) {
                openDatabase = sQLiteDatabase2;
                if (z) {
                    openDatabase = sQLiteDatabase2;
                    if (sQLiteDatabase2.isReadOnly()) {
                        sQLiteDatabase2.reopenReadWrite();
                        openDatabase = sQLiteDatabase2;
                    }
                }
            } else if (this.mName == null) {
                openDatabase = SQLiteDatabase.create(null);
            } else {
                sQLiteDatabase3 = sQLiteDatabase2;
                try {
                    sQLiteDatabase3 = sQLiteDatabase2;
                    openDatabase = this.mContext.openOrCreateDatabase(this.mName, this.mEnableWriteAheadLogging ? 8 : 0, this.mFactory, this.mErrorHandler);
                } catch (SQLiteException e) {
                    if (z) {
                        throw e;
                    }
                    Log.e(TAG, "Couldn't open " + this.mName + " for writing (will try read-only):", e);
                    openDatabase = SQLiteDatabase.openDatabase(this.mContext.getDatabasePath(this.mName).getPath(), this.mFactory, 1, this.mErrorHandler);
                }
            }
            onConfigure(openDatabase);
            SQLiteDatabase sQLiteDatabase4 = openDatabase;
            int version = openDatabase.getVersion();
            SQLiteDatabase sQLiteDatabase5 = openDatabase;
            if (version != this.mNewVersion) {
                SQLiteDatabase sQLiteDatabase6 = openDatabase;
                if (openDatabase.isReadOnly()) {
                    SQLiteDatabase sQLiteDatabase7 = openDatabase;
                    throw new SQLiteException("Can't upgrade read-only database from version " + openDatabase.getVersion() + " to " + this.mNewVersion + ": " + this.mName);
                }
                openDatabase.beginTransaction();
                if (version == 0) {
                    onCreate(openDatabase);
                } else if (version > this.mNewVersion) {
                    onDowngrade(openDatabase, version, this.mNewVersion);
                } else {
                    onUpgrade(openDatabase, version, this.mNewVersion);
                }
                openDatabase.setVersion(this.mNewVersion);
                openDatabase.setTransactionSuccessful();
                SQLiteDatabase sQLiteDatabase8 = openDatabase;
                openDatabase.endTransaction();
            }
            SQLiteDatabase sQLiteDatabase9 = openDatabase;
            onOpen(openDatabase);
            SQLiteDatabase sQLiteDatabase10 = openDatabase;
            if (openDatabase.isReadOnly()) {
                SQLiteDatabase sQLiteDatabase11 = openDatabase;
                Log.w(TAG, "Opened " + this.mName + " in read-only mode");
            }
            SQLiteDatabase sQLiteDatabase12 = openDatabase;
            this.mDatabase = openDatabase;
            this.mIsInitializing = false;
            sQLiteDatabase = openDatabase;
            if (openDatabase != null) {
                sQLiteDatabase = openDatabase;
                if (openDatabase != this.mDatabase) {
                    openDatabase.close();
                    return openDatabase;
                }
            }
            return sQLiteDatabase;
        } catch (Throwable th) {
            this.mIsInitializing = false;
            if (sQLiteDatabase3 != null && sQLiteDatabase3 != this.mDatabase) {
                sQLiteDatabase3.close();
            }
            throw th;
        }
    }

    public void close() {
        synchronized (this) {
            if (this.mIsInitializing) {
                throw new IllegalStateException("Closed during initialization");
            }
            if (this.mDatabase != null && this.mDatabase.isOpen()) {
                this.mDatabase.close();
                this.mDatabase = null;
            }
        }
    }

    public String getDatabaseName() {
        return this.mName;
    }

    public SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase databaseLocked;
        synchronized (this) {
            databaseLocked = getDatabaseLocked(false);
        }
        return databaseLocked;
    }

    public SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase databaseLocked;
        synchronized (this) {
            databaseLocked = getDatabaseLocked(true);
        }
        return databaseLocked;
    }

    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
    }

    public abstract void onCreate(SQLiteDatabase sQLiteDatabase);

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new SQLiteException("Can't downgrade database from version " + i + " to " + i2);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
    }

    public abstract void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2);

    public void setWriteAheadLoggingEnabled(boolean z) {
        synchronized (this) {
            if (this.mEnableWriteAheadLogging != z) {
                if (this.mDatabase != null && this.mDatabase.isOpen() && !this.mDatabase.isReadOnly()) {
                    if (z) {
                        this.mDatabase.enableWriteAheadLogging();
                    } else {
                        this.mDatabase.disableWriteAheadLogging();
                    }
                }
                this.mEnableWriteAheadLogging = z;
            }
        }
    }
}
