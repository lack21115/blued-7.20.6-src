package android.database.sqlite;

import android.database.SQLException;

/* loaded from: source-9557208-dex2jar.jar:android/database/sqlite/SQLiteException.class */
public class SQLiteException extends SQLException {
    public SQLiteException() {
    }

    public SQLiteException(String str) {
        super(str);
    }

    public SQLiteException(String str, Throwable th) {
        super(str, th);
    }
}
