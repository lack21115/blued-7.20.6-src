package com.tencent.bugly.idasc.proguard;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/x.class */
public final class x extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    public static String f21660a = "bugly_db";
    public static int b = 16;

    /* renamed from: c  reason: collision with root package name */
    protected Context f21661c;
    private List<o> d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(Context context, List<o> list) {
        super(context, f21660a + "_", null, b);
        aa.a(context).getClass();
        this.f21661c = context;
        this.d = list;
    }

    private boolean a(SQLiteDatabase sQLiteDatabase) {
        synchronized (this) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < 3) {
                    try {
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ".concat(String.valueOf(new String[]{"t_lr", "t_ui", "t_pf"}[i2])), new String[0]);
                        i = i2 + 1;
                    } catch (Throwable th) {
                        if (!al.b(th)) {
                            th.printStackTrace();
                        }
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this) {
            sQLiteDatabase = null;
            int i = 0;
            while (sQLiteDatabase == null && i < 5) {
                i++;
                try {
                    sQLiteDatabase = super.getReadableDatabase();
                } catch (Throwable th) {
                    al.d("[Database] Try to get db(count: %d).", Integer.valueOf(i));
                    if (i == 5) {
                        al.e("[Database] Failed to get db.", new Object[0]);
                    }
                    try {
                        Thread.sleep(200L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this) {
            sQLiteDatabase = null;
            int i = 0;
            while (sQLiteDatabase == null && i < 5) {
                i++;
                try {
                    sQLiteDatabase = super.getWritableDatabase();
                }
            }
            if (sQLiteDatabase == null) {
                al.d("[Database] db error delay error record 1min.", new Object[0]);
            }
        }
        return sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        synchronized (this) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.setLength(0);
                sb.append(" CREATE TABLE IF NOT EXISTS t_ui ( _id INTEGER PRIMARY KEY , _tm int , _ut int , _tp int , _dt blob , _pc text ) ");
                al.c(sb.toString(), new Object[0]);
                sQLiteDatabase.execSQL(sb.toString(), new String[0]);
                sb.setLength(0);
                sb.append(" CREATE TABLE IF NOT EXISTS t_lr ( _id INTEGER PRIMARY KEY , _tp int , _tm int , _pc text , _th text , _dt blob ) ");
                al.c(sb.toString(), new Object[0]);
                sQLiteDatabase.execSQL(sb.toString(), new String[0]);
                sb.setLength(0);
                sb.append(" CREATE TABLE IF NOT EXISTS t_pf ( _id integer , _tp text , _tm int , _dt blob,primary key(_id,_tp )) ");
                al.c(sb.toString(), new Object[0]);
                sQLiteDatabase.execSQL(sb.toString(), new String[0]);
                sb.setLength(0);
                sb.append(" CREATE TABLE IF NOT EXISTS t_cr ( _id INTEGER PRIMARY KEY , _tm int , _s1 text , _up int , _me int , _uc int , _dt blob ) ");
                al.c(sb.toString(), new Object[0]);
                sQLiteDatabase.execSQL(sb.toString(), new String[0]);
                sb.setLength(0);
                sb.append(" CREATE TABLE IF NOT EXISTS dl_1002 (_id integer primary key autoincrement, _dUrl varchar(100), _sFile varchar(100), _sLen INTEGER, _tLen INTEGER, _MD5 varchar(100), _DLTIME INTEGER)");
                al.c(sb.toString(), new Object[0]);
                sQLiteDatabase.execSQL(sb.toString(), new String[0]);
                sb.setLength(0);
                sb.append("CREATE TABLE IF NOT EXISTS ge_1002 (_id integer primary key autoincrement, _time INTEGER, _datas blob)");
                al.c(sb.toString(), new Object[0]);
                sQLiteDatabase.execSQL(sb.toString(), new String[0]);
                sb.setLength(0);
                sb.append(" CREATE TABLE IF NOT EXISTS st_1002 ( _id integer , _tp text , _tm int , _dt blob,primary key(_id,_tp )) ");
                al.c(sb.toString(), new Object[0]);
                sQLiteDatabase.execSQL(sb.toString(), new String[0]);
                sb.setLength(0);
                sb.append(" CREATE TABLE IF NOT EXISTS t_sla ( _id TEXT NOT NULL , _tm INTEGER NOT NULL , _dt TEXT NOT NULL , PRIMARY KEY(_id) ) ");
                String sb2 = sb.toString();
                al.c(sb2, new Object[0]);
                sQLiteDatabase.execSQL(sb2, new String[0]);
                if (this.d == null) {
                    return;
                }
                for (o oVar : this.d) {
                    oVar.onDbCreate(sQLiteDatabase);
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        synchronized (this) {
            if (ab.c() >= 11) {
                al.d("[Database] Downgrade %d to %d drop tables.", Integer.valueOf(i), Integer.valueOf(i2));
                if (this.d != null) {
                    for (o oVar : this.d) {
                        oVar.onDbDowngrade(sQLiteDatabase, i, i2);
                    }
                }
                if (a(sQLiteDatabase)) {
                    onCreate(sQLiteDatabase);
                    return;
                }
                al.d("[Database] Failed to drop, delete db.", new Object[0]);
                File databasePath = this.f21661c.getDatabasePath(f21660a);
                if (databasePath != null && databasePath.canWrite()) {
                    databasePath.delete();
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        synchronized (this) {
            al.d("[Database] Upgrade %d to %d , drop tables!", Integer.valueOf(i), Integer.valueOf(i2));
            if (this.d != null) {
                for (o oVar : this.d) {
                    oVar.onDbUpgrade(sQLiteDatabase, i, i2);
                }
            }
            if (a(sQLiteDatabase)) {
                onCreate(sQLiteDatabase);
                return;
            }
            al.d("[Database] Failed to drop, delete db.", new Object[0]);
            File databasePath = this.f21661c.getDatabasePath(f21660a);
            if (databasePath != null && databasePath.canWrite()) {
                databasePath.delete();
            }
        }
    }
}
