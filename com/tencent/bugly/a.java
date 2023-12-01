package com.tencent.bugly;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.x;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/a.class */
public abstract class a {
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
                }
                String str = tables[i4];
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
                i3 = i4 + 1;
            }
        } catch (Throwable th) {
            if (x.b(th)) {
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
                }
                String str = tables[i4];
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
                i3 = i4 + 1;
            }
        } catch (Throwable th) {
            if (x.b(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public void onServerStrategyChanged(StrategyBean strategyBean) {
    }
}
