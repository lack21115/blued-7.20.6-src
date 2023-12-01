package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/database/sqlite/SQLiteDatabaseKt.class */
public final class SQLiteDatabaseKt {
    public static final <T> T transaction(SQLiteDatabase sQLiteDatabase, boolean z, Function1<? super SQLiteDatabase, ? extends T> body) {
        Intrinsics.e(sQLiteDatabase, "<this>");
        Intrinsics.e(body, "body");
        if (z) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            T invoke = body.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            InlineMarker.b(1);
            sQLiteDatabase.endTransaction();
            InlineMarker.c(1);
            return invoke;
        } catch (Throwable th) {
            InlineMarker.b(1);
            sQLiteDatabase.endTransaction();
            InlineMarker.c(1);
            throw th;
        }
    }

    public static /* synthetic */ Object transaction$default(SQLiteDatabase sQLiteDatabase, boolean z, Function1 body, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        Intrinsics.e(sQLiteDatabase, "<this>");
        Intrinsics.e(body, "body");
        if (z) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            Object invoke = body.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            InlineMarker.b(1);
            sQLiteDatabase.endTransaction();
            InlineMarker.c(1);
            return invoke;
        } catch (Throwable th) {
            InlineMarker.b(1);
            sQLiteDatabase.endTransaction();
            InlineMarker.c(1);
            throw th;
        }
    }
}
