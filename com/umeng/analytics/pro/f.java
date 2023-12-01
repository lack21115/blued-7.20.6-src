package com.umeng.analytics.pro;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.umeng.analytics.pro.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/f.class */
public class f extends SQLiteOpenHelper {
    private static Context b;

    /* renamed from: a  reason: collision with root package name */
    private String f40745a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/f$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final f f40746a = new f(f.b, h.b(f.b), e.b, null, 2);

        private a() {
        }
    }

    private f(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, TextUtils.isEmpty(str) ? e.b : str, cursorFactory, i);
        this.f40745a = null;
        a();
    }

    private f(Context context, String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        this(new c(context, str), str2, cursorFactory, i);
    }

    public static f a(Context context) {
        if (b == null) {
            b = context.getApplicationContext();
        }
        return a.f40746a;
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f40745a = "create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)");
        } catch (SQLException e) {
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        } catch (SQLException e) {
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f40745a = "create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)");
        } catch (SQLException e) {
        }
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f40745a = "create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException e) {
        }
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f40745a = "create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException e) {
        }
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        if (!h.a(sQLiteDatabase, e.d.f40740a, "__av")) {
            h.a(sQLiteDatabase, e.d.f40740a, "__sp", "TEXT");
            h.a(sQLiteDatabase, e.d.f40740a, "__pp", "TEXT");
            h.a(sQLiteDatabase, e.d.f40740a, "__av", "TEXT");
            h.a(sQLiteDatabase, e.d.f40740a, "__vc", "TEXT");
        }
        if (!h.a(sQLiteDatabase, e.b.f40730a, "__av")) {
            h.a(sQLiteDatabase, e.b.f40730a, "__av", "TEXT");
            h.a(sQLiteDatabase, e.b.f40730a, "__vc", "TEXT");
        }
        if (h.a(sQLiteDatabase, e.a.f40725a, "__av")) {
            return;
        }
        h.a(sQLiteDatabase, e.a.f40725a, "__av", "TEXT");
        h.a(sQLiteDatabase, e.a.f40725a, "__vc", "TEXT");
    }

    private void f(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, e.d.f40740a);
        a(sQLiteDatabase, e.b.f40730a);
        a(sQLiteDatabase, e.a.f40725a);
        a();
    }

    public void a() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (!h.a(e.d.f40740a, writableDatabase)) {
                c(writableDatabase);
            }
            if (!h.a(e.c.f40735a, writableDatabase)) {
                d(writableDatabase);
            }
            if (!h.a(e.b.f40730a, writableDatabase)) {
                b(writableDatabase);
            }
            if (h.a(e.a.f40725a, writableDatabase)) {
                return;
            }
            a(writableDatabase);
        } catch (Exception e) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            c(sQLiteDatabase);
            d(sQLiteDatabase);
            b(sQLiteDatabase);
            a(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            if (sQLiteDatabase == null) {
                return;
            }
        } catch (SQLiteDatabaseCorruptException e) {
            try {
                h.a(b);
                if (sQLiteDatabase == null) {
                    return;
                }
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable th2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            if (sQLiteDatabase == null) {
                return;
            }
        }
        try {
            sQLiteDatabase.endTransaction();
        } catch (Throwable th4) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 <= i || i != 1) {
            return;
        }
        try {
            e(sQLiteDatabase);
        } catch (Exception e) {
            try {
                e(sQLiteDatabase);
            } catch (Exception e2) {
                f(sQLiteDatabase);
            }
        }
    }
}
