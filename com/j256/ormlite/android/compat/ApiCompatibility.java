package com.j256.ormlite.android.compat;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/android/compat/ApiCompatibility.class */
public interface ApiCompatibility {

    /* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/android/compat/ApiCompatibility$CancellationHook.class */
    public interface CancellationHook {
        void cancel();
    }

    CancellationHook createCancellationHook();

    Cursor rawQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, CancellationHook cancellationHook);
}
