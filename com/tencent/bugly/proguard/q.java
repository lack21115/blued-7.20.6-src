package com.tencent.bugly.proguard;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.File;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/proguard/q.class */
public final class q extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    public static String f35400a = "bugly_db";
    private static int b = 15;

    /* renamed from: c  reason: collision with root package name */
    private Context f35401c;
    private List<com.tencent.bugly.a> d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(Context context, List<com.tencent.bugly.a> list) {
        super(context, f35400a + BridgeUtil.UNDERLINE_STR, null, b);
        com.tencent.bugly.crashreport.common.info.a.a(context).getClass();
        this.f35401c = context;
        this.d = list;
    }

    private boolean a(SQLiteDatabase sQLiteDatabase) {
        synchronized (this) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < 3) {
                    try {
                        String str = new String[]{"t_lr", "t_ui", "t_pf"}[i2];
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str, new String[0]);
                        i = i2 + 1;
                    } catch (Throwable th) {
                        if (!x.b(th)) {
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
                    x.d("[Database] Try to get db(count: %d).", Integer.valueOf(i));
                    if (i == 5) {
                        x.e("[Database] Failed to get db.", new Object[0]);
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
                x.d("[Database] db error delay error record 1min.", new Object[0]);
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
                sb.append(" CREATE TABLE IF NOT EXISTS t_ui");
                sb.append(" ( _id");
                sb.append(" INTEGER PRIMARY KEY");
                sb.append(" , _tm");
                sb.append(" int");
                sb.append(" , _ut");
                sb.append(" int");
                sb.append(" , _tp");
                sb.append(" int");
                sb.append(" , _dt");
                sb.append(" blob");
                sb.append(" , _pc");
                sb.append(" text");
                sb.append(" ) ");
                x.c(sb.toString(), new Object[0]);
                sQLiteDatabase.execSQL(sb.toString(), new String[0]);
                sb.setLength(0);
                sb.append(" CREATE TABLE IF NOT EXISTS t_lr");
                sb.append(" ( _id");
                sb.append(" INTEGER PRIMARY KEY");
                sb.append(" , _tp");
                sb.append(" int");
                sb.append(" , _tm");
                sb.append(" int");
                sb.append(" , _pc");
                sb.append(" text");
                sb.append(" , _th");
                sb.append(" text");
                sb.append(" , _dt");
                sb.append(" blob");
                sb.append(" ) ");
                x.c(sb.toString(), new Object[0]);
                sQLiteDatabase.execSQL(sb.toString(), new String[0]);
                sb.setLength(0);
                sb.append(" CREATE TABLE IF NOT EXISTS t_pf");
                sb.append(" ( _id");
                sb.append(" integer");
                sb.append(" , _tp");
                sb.append(" text");
                sb.append(" , _tm");
                sb.append(" int");
                sb.append(" , _dt");
                sb.append(" blob");
                sb.append(",primary key(_id");
                sb.append(",_tp");
                sb.append(" )) ");
                x.c(sb.toString(), new Object[0]);
                sQLiteDatabase.execSQL(sb.toString(), new String[0]);
                sb.setLength(0);
                sb.append(" CREATE TABLE IF NOT EXISTS t_cr");
                sb.append(" ( _id");
                sb.append(" INTEGER PRIMARY KEY");
                sb.append(" , _tm");
                sb.append(" int");
                sb.append(" , _s1");
                sb.append(" text");
                sb.append(" , _up");
                sb.append(" int");
                sb.append(" , _me");
                sb.append(" int");
                sb.append(" , _uc");
                sb.append(" int");
                sb.append(" , _dt");
                sb.append(" blob");
                sb.append(" ) ");
                x.c(sb.toString(), new Object[0]);
                sQLiteDatabase.execSQL(sb.toString(), new String[0]);
                sb.setLength(0);
                sb.append(" CREATE TABLE IF NOT EXISTS dl_1002");
                sb.append(" (_id");
                sb.append(" integer primary key autoincrement, _dUrl");
                sb.append(" varchar(100), _sFile");
                sb.append(" varchar(100), _sLen");
                sb.append(" INTEGER, _tLen");
                sb.append(" INTEGER, _MD5");
                sb.append(" varchar(100), _DLTIME");
                sb.append(" INTEGER)");
                x.c(sb.toString(), new Object[0]);
                sQLiteDatabase.execSQL(sb.toString(), new String[0]);
                sb.setLength(0);
                sb.append("CREATE TABLE IF NOT EXISTS ge_1002");
                sb.append(" (_id");
                sb.append(" integer primary key autoincrement, _time");
                sb.append(" INTEGER, _datas");
                sb.append(" blob)");
                x.c(sb.toString(), new Object[0]);
                sQLiteDatabase.execSQL(sb.toString(), new String[0]);
                sb.setLength(0);
                sb.append(" CREATE TABLE IF NOT EXISTS st_1002");
                sb.append(" ( _id");
                sb.append(" integer");
                sb.append(" , _tp");
                sb.append(" text");
                sb.append(" , _tm");
                sb.append(" int");
                sb.append(" , _dt");
                sb.append(" blob");
                sb.append(",primary key(_id");
                sb.append(",_tp");
                sb.append(" )) ");
                x.c(sb.toString(), new Object[0]);
                sQLiteDatabase.execSQL(sb.toString(), new String[0]);
                if (this.d == null) {
                    return;
                }
                for (com.tencent.bugly.a aVar : this.d) {
                    aVar.onDbCreate(sQLiteDatabase);
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        synchronized (this) {
            if (com.tencent.bugly.crashreport.common.info.b.c() >= 11) {
                x.d("[Database] Downgrade %d to %d drop tables.", Integer.valueOf(i), Integer.valueOf(i2));
                if (this.d != null) {
                    for (com.tencent.bugly.a aVar : this.d) {
                        aVar.onDbDowngrade(sQLiteDatabase, i, i2);
                    }
                }
                if (a(sQLiteDatabase)) {
                    onCreate(sQLiteDatabase);
                    return;
                }
                x.d("[Database] Failed to drop, delete db.", new Object[0]);
                File databasePath = this.f35401c.getDatabasePath(f35400a);
                if (databasePath != null && databasePath.canWrite()) {
                    databasePath.delete();
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        synchronized (this) {
            x.d("[Database] Upgrade %d to %d , drop tables!", Integer.valueOf(i), Integer.valueOf(i2));
            if (this.d != null) {
                for (com.tencent.bugly.a aVar : this.d) {
                    aVar.onDbUpgrade(sQLiteDatabase, i, i2);
                }
            }
            if (a(sQLiteDatabase)) {
                onCreate(sQLiteDatabase);
                return;
            }
            x.d("[Database] Failed to drop, delete db.", new Object[0]);
            File databasePath = this.f35401c.getDatabasePath(f35400a);
            if (databasePath != null && databasePath.canWrite()) {
                databasePath.delete();
            }
        }
    }
}
