package android.database.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/* loaded from: source-9557208-dex2jar.jar:android/database/sqlite/SQLiteCursorDriver.class */
public interface SQLiteCursorDriver {
    void cursorClosed();

    void cursorDeactivated();

    void cursorRequeried(Cursor cursor);

    Cursor query(SQLiteDatabase.CursorFactory cursorFactory, String[] strArr);

    void setBindArguments(String[] strArr);
}
