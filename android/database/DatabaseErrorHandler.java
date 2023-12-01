package android.database;

import android.database.sqlite.SQLiteDatabase;

/* loaded from: source-9557208-dex2jar.jar:android/database/DatabaseErrorHandler.class */
public interface DatabaseErrorHandler {
    void onCorruption(SQLiteDatabase sQLiteDatabase);
}
