package com.getui.gtc.base.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/db/AbstractDb.class */
public abstract class AbstractDb {
    private SQLiteOpenHelper helper;
    private Map<Class<? extends AbstractTable>, AbstractTable> tables = new HashMap();
    private AtomicBoolean inited = new AtomicBoolean(false);

    private void initCache() {
        for (Class<? extends AbstractTable> cls : this.tables.keySet()) {
            try {
                this.tables.get(cls).initCache();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void addTable(Class<? extends AbstractTable> cls) throws IllegalAccessException, InstantiationException {
        AbstractTable abstractTable = this.tables.get(cls);
        AbstractTable abstractTable2 = abstractTable;
        if (abstractTable == null) {
            abstractTable2 = cls.newInstance();
            this.tables.put(cls, abstractTable2);
        }
        abstractTable2.setDb(this);
    }

    public final void addTables(List<Class<? extends AbstractTable>> list) throws InstantiationException, IllegalAccessException {
        for (Class<? extends AbstractTable> cls : list) {
            addTable(cls);
        }
    }

    public abstract String getDbName();

    public final SQLiteOpenHelper getHelper() {
        SQLiteOpenHelper sQLiteOpenHelper = this.helper;
        if (sQLiteOpenHelper != null) {
            return sQLiteOpenHelper;
        }
        throw new RuntimeException("db " + getDbName() + " has not been initialized");
    }

    public final <T extends AbstractTable> T getTable(Class<T> cls) {
        T t = (T) this.tables.get(cls);
        if (t != null) {
            return t;
        }
        throw new RuntimeException("table " + cls.getSimpleName() + " has not been added to db " + getDbName());
    }

    public final Collection<AbstractTable> getTables() {
        Collection<AbstractTable> values = this.tables.values();
        if (values.size() > 0) {
            return values;
        }
        throw new RuntimeException("no table has been added to db " + getDbName());
    }

    public abstract int getVersion();

    public void init(Context context) {
        if (this.inited.getAndSet(true)) {
            return;
        }
        this.helper = new SQLiteOpenHelper(context, getDbName(), null, getVersion()) { // from class: com.getui.gtc.base.db.AbstractDb.1
            @Override // android.database.sqlite.SQLiteOpenHelper
            public void onCreate(SQLiteDatabase sQLiteDatabase) {
                try {
                    sQLiteDatabase.beginTransaction();
                    for (Class cls : AbstractDb.this.tables.keySet()) {
                        sQLiteDatabase.execSQL(((AbstractTable) AbstractDb.this.tables.get(cls)).createSql());
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // android.database.sqlite.SQLiteOpenHelper
            public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
                try {
                    sQLiteDatabase.beginTransaction();
                    for (Class cls : AbstractDb.this.tables.keySet()) {
                        ((AbstractTable) AbstractDb.this.tables.get(cls)).onDowngradle(sQLiteDatabase, i, i2);
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // android.database.sqlite.SQLiteOpenHelper
            public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
                try {
                    sQLiteDatabase.beginTransaction();
                    for (Class cls : AbstractDb.this.tables.keySet()) {
                        ((AbstractTable) AbstractDb.this.tables.get(cls)).onUpgrade(sQLiteDatabase, i, i2);
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        initCache();
    }
}
