package com.tencent.bugly.idasc.proguard;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.bugly.idasc.BuglyStrategy;
import com.tencent.bugly.idasc.crashreport.common.strategy.StrategyBean;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/o.class */
public abstract class o {
    public int id;
    public String moduleName;
    public String version;
    public String versionKey;

    public abstract String[] getTables();

    public abstract void init(Context context, boolean z, BuglyStrategy buglyStrategy);

    public void onDbCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public void onDbDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            if (getTables() == null) {
                return;
            }
            String[] tables = getTables();
            int length = tables.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length) {
                    onDbCreate(sQLiteDatabase);
                    return;
                } else {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ".concat(String.valueOf(tables[i4])));
                    i3 = i4 + 1;
                }
            }
        } catch (Throwable th) {
            if (al.b(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public void onDbUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            if (getTables() == null) {
                return;
            }
            String[] tables = getTables();
            int length = tables.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length) {
                    onDbCreate(sQLiteDatabase);
                    return;
                } else {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ".concat(String.valueOf(tables[i4])));
                    i3 = i4 + 1;
                }
            }
        } catch (Throwable th) {
            if (al.b(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public void onServerStrategyChanged(StrategyBean strategyBean) {
    }
}
