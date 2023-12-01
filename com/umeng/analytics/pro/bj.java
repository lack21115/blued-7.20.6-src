package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.debug.UMRTLog;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/bj.class */
public class bj extends SQLiteOpenHelper {
    private static final Object b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static bj f26970c;
    private static final String d = "CREATE TABLE IF NOT EXISTS stf(_id INTEGER PRIMARY KEY AUTOINCREMENT, _tp TEXT, _hd TEXT, _bd TEXT, _ts TEXT, _uuid TEXT, _re1 TEXT, _re2 TEXT)";
    private static final String e = "DROP TABLE IF EXISTS stf";
    private static final String f = "DELETE FROM stf WHERE _id IN( SELECT _id FROM stf ORDER BY _id LIMIT 1)";

    /* renamed from: a  reason: collision with root package name */
    private final Context f26971a;

    private bj(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
        this.f26971a = context;
    }

    public static final int a() {
        return 1;
    }

    public static bj a(Context context) {
        bj bjVar;
        synchronized (b) {
            if (f26970c == null) {
                f26970c = new bj(context, bl.b, null, 1);
            }
            bjVar = f26970c;
        }
        return bjVar;
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(e);
            sQLiteDatabase.execSQL(d);
        } catch (SQLException e2) {
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(d);
        } catch (SQLiteDatabaseCorruptException e2) {
            a(sQLiteDatabase);
        } catch (Throwable th) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]创建二级缓存数据库失败: " + th.getMessage());
        }
    }

    private void d() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            try {
                writableDatabase.execSQL(f);
                if (writableDatabase == null) {
                    return;
                }
            } catch (Throwable th) {
                if (writableDatabase == null) {
                    return;
                }
            }
            writableDatabase.close();
        } catch (Throwable th2) {
        }
    }

    public Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            Cursor cursor = null;
            if (writableDatabase != null) {
                cursor = null;
                if (writableDatabase.isOpen()) {
                    cursor = writableDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
                }
            }
            return cursor;
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x00b5, code lost:
        if (r12 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00b8, code lost:
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00bf, code lost:
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00cb, code lost:
        if (r12 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00d2, code lost:
        return r13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.umeng.analytics.pro.bk a(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.bj.a(java.lang.String):com.umeng.analytics.pro.bk");
    }

    public void a(String str, ContentValues contentValues) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            try {
                writableDatabase.beginTransaction();
                writableDatabase.insert(str, null, contentValues);
                writableDatabase.setTransactionSuccessful();
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]插入二级缓存数据记录 成功。");
                if (writableDatabase == null) {
                    return;
                }
            } catch (Throwable th) {
                if (writableDatabase == null) {
                    return;
                }
            }
            writableDatabase.endTransaction();
            writableDatabase.close();
        } catch (Throwable th2) {
        }
    }

    public void a(String str, String str2) {
        a(str, "_uuid=?", new String[]{str2});
    }

    public void a(String str, String str2, String[] strArr) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            try {
                writableDatabase.beginTransaction();
                writableDatabase.delete(str, str2, strArr);
                writableDatabase.setTransactionSuccessful();
                if (writableDatabase == null) {
                    return;
                }
            } catch (Throwable th) {
                if (writableDatabase == null) {
                    return;
                }
            }
            writableDatabase.endTransaction();
            writableDatabase.close();
        } catch (Throwable th2) {
        }
    }

    public void b() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            writableDatabase.close();
        } catch (Throwable th) {
        }
    }

    public boolean b(String str) {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase writableDatabase;
        Cursor cursor = null;
        try {
            writableDatabase = getWritableDatabase();
            Cursor cursor2 = null;
            if (writableDatabase != null) {
                cursor2 = null;
                cursor = null;
                try {
                    if (writableDatabase.isOpen()) {
                        cursor2 = writableDatabase.query(str, null, null, null, null, null, null, null);
                    }
                } catch (Throwable th) {
                    sQLiteDatabase = writableDatabase;
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase == null) {
                        return false;
                    }
                    sQLiteDatabase.close();
                    return false;
                }
            }
            if (cursor2 != null) {
                cursor = cursor2;
                if (cursor2.getCount() > 0) {
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (writableDatabase != null) {
                        writableDatabase.close();
                        return true;
                    }
                    return true;
                }
            }
            if (cursor2 != null) {
                cursor2.close();
            }
        } catch (Throwable th2) {
            sQLiteDatabase = null;
        }
        if (writableDatabase != null) {
            sQLiteDatabase = writableDatabase;
            sQLiteDatabase.close();
            return false;
        }
        return false;
    }

    public boolean c() {
        return !b(bl.f26975c);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
