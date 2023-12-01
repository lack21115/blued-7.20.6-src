package com.alibaba.mtl.log.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.alibaba.mtl.log.e.i;
import com.android.internal.util.cm.SpamFilter;
import com.anythink.core.common.c.g;
import com.anythink.core.common.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/c/b.class */
public class b implements com.alibaba.mtl.log.c.a {
    a a;
    String aa = "SELECT * FROM %s ORDER BY %s ASC LIMIT %s";
    String ab = "SELECT count(*) FROM %s";
    String ac = "DELETE FROM log where _id in ( select _id from log  ORDER BY _id ASC LIMIT %d )";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/c/b$a.class */
    public class a extends SQLiteOpenHelper {
        private SQLiteDatabase a;
        private AtomicInteger e;

        a(Context context) {
            super(context, "ut.db", (SQLiteDatabase.CursorFactory) null, 2);
            this.e = new AtomicInteger();
        }

        public void a(SQLiteDatabase sQLiteDatabase) {
            synchronized (this) {
                if (sQLiteDatabase == null) {
                    return;
                }
                try {
                    if (this.e.decrementAndGet() == 0 && this.a != null) {
                        this.a.close();
                        this.a = null;
                    }
                } catch (Throwable th) {
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public SQLiteDatabase getWritableDatabase() {
            SQLiteDatabase sQLiteDatabase;
            synchronized (this) {
                try {
                    if (this.e.incrementAndGet() == 1) {
                        this.a = super.getWritableDatabase();
                    }
                    sQLiteDatabase = this.a;
                }
            }
            return sQLiteDatabase;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS log (_id INTEGER PRIMARY KEY AUTOINCREMENT, eventId TEXT,priority TEXT, streamId TEXT, time TEXT, content TEXT, _index TEXT )");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            Cursor cursor = null;
            try {
                cursor = sQLiteDatabase.rawQuery("PRAGMA journal_mode=DELETE", null);
            } catch (Throwable th) {
            }
            b.this.a(cursor);
            super.onOpen(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i == 1 && i2 == 2) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE log ADD COLUMN _index TEXT ");
                } catch (Throwable th) {
                    i.a("UTSqliteLogStore", "DB Upgrade Error", th);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context) {
        this.a = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.alibaba.mtl.log.c.a
    public int a(List<com.alibaba.mtl.log.model.a> list) {
        boolean z;
        int i;
        boolean z2;
        int i2;
        synchronized (this) {
            if (list != null) {
                if (list.size() != 0) {
                    SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
                    if (writableDatabase != null) {
                        writableDatabase.beginTransaction();
                        int i3 = 0;
                        z = true;
                        int i4 = 0;
                        while (true) {
                            i = i4;
                            if (i3 < list.size()) {
                                long delete = writableDatabase.delete("log", "_id=?", new String[]{list.get(i3).id + ""});
                                if (delete <= 0) {
                                    i.a("UTSqliteLogStore", "[delete]  ", Integer.valueOf(list.get(i3).id), " ret:", Long.valueOf(delete));
                                    z2 = false;
                                    i2 = i;
                                } else {
                                    z2 = z;
                                    i2 = i;
                                    if (!"6005".equalsIgnoreCase(list.get(i3).T)) {
                                        i2 = i + 1;
                                        z2 = z;
                                    }
                                }
                                i3++;
                                z = z2;
                                i4 = i2;
                            } else {
                                try {
                                    break;
                                } catch (Throwable th) {
                                }
                            }
                        }
                        writableDatabase.setTransactionSuccessful();
                        try {
                            writableDatabase.endTransaction();
                        } catch (Throwable th2) {
                        }
                        this.a.a(writableDatabase);
                    } else {
                        i.a("UTSqliteLogStore", "db is null");
                        z = false;
                        i = 0;
                    }
                    i.a("UTSqliteLogStore", "delete ", Integer.valueOf(list.size()), " isSuccess:", Boolean.valueOf(z));
                    return i;
                }
            }
            return 0;
        }
    }

    @Override // com.alibaba.mtl.log.c.a
    public ArrayList<com.alibaba.mtl.log.model.a> a(String str, int i) {
        ArrayList<com.alibaba.mtl.log.model.a> arrayList;
        synchronized (this) {
            try {
            } catch (Throwable th) {
                arrayList = null;
            }
            if (i <= 0) {
                return (ArrayList) Collections.EMPTY_LIST;
            }
            ArrayList<com.alibaba.mtl.log.model.a> arrayList2 = new ArrayList<>(i);
            try {
                SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
                if (writableDatabase != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SELECT * FROM ");
                    sb.append("log");
                    if (!TextUtils.isEmpty(str)) {
                        sb.append(" WHERE ");
                        sb.append(str);
                    }
                    sb.append(" ORDER BY ");
                    sb.append(g.a.g);
                    sb.append(" ASC ");
                    sb.append(" LIMIT ");
                    sb.append(i + "");
                    String sb2 = sb.toString();
                    i.a("UTSqliteLogStore", "sql:" + sb2);
                    Cursor rawQuery = writableDatabase.rawQuery(sb2, null);
                    while (rawQuery != null && rawQuery.moveToNext()) {
                        com.alibaba.mtl.log.model.a aVar = new com.alibaba.mtl.log.model.a();
                        i.a("UTSqliteLogStore", "pos", Integer.valueOf(rawQuery.getPosition()), SpamFilter.SpamContract.NotificationTable.COUNT, Integer.valueOf(rawQuery.getCount()));
                        aVar.id = rawQuery.getInt(rawQuery.getColumnIndex("_id"));
                        aVar.T = rawQuery.getString(rawQuery.getColumnIndex("eventId"));
                        aVar.U = rawQuery.getString(rawQuery.getColumnIndex("priority"));
                        aVar.k(rawQuery.getString(rawQuery.getColumnIndex(l.y)));
                        aVar.W = rawQuery.getString(rawQuery.getColumnIndex(g.a.g));
                        try {
                            aVar.X = rawQuery.getString(rawQuery.getColumnIndex("_index"));
                        } catch (Throwable th2) {
                        }
                        arrayList2.add(aVar);
                    }
                    a(rawQuery);
                    this.a.a(writableDatabase);
                    arrayList = arrayList2;
                } else {
                    i.a("UTSqliteLogStore", "db is null");
                    arrayList = arrayList2;
                }
            } catch (Throwable th3) {
                arrayList = arrayList2;
            }
            return arrayList;
        }
    }

    @Override // com.alibaba.mtl.log.c.a
    /* renamed from: a */
    public boolean mo8613a(List<com.alibaba.mtl.log.model.a> list) {
        synchronized (this) {
            if (list != null) {
                if (list.size() != 0) {
                    SQLiteDatabase sQLiteDatabase = null;
                    boolean z = false;
                    try {
                        SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
                        if (writableDatabase != null) {
                            writableDatabase.beginTransaction();
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                z = true;
                                try {
                                    if (i2 >= list.size()) {
                                        break;
                                    }
                                    com.alibaba.mtl.log.model.a aVar = list.get(i2);
                                    if (aVar != null) {
                                        ContentValues contentValues = new ContentValues();
                                        contentValues.put("eventId", aVar.T);
                                        contentValues.put("priority", aVar.U);
                                        contentValues.put(l.y, aVar.i());
                                        contentValues.put(g.a.g, aVar.W);
                                        contentValues.put("_index", aVar.X);
                                        long insert = writableDatabase.insert("log", "", contentValues);
                                        if (insert == -1) {
                                            z = false;
                                            break;
                                        }
                                        i.a("UTSqliteLogStore", "[insert] ", aVar.X, " isSuccess:", true, "ret", Long.valueOf(insert));
                                    }
                                    i = i2 + 1;
                                } catch (Throwable th) {
                                    th = th;
                                    z = true;
                                    sQLiteDatabase = writableDatabase;
                                    i.a("UTSqliteLogStore", "insert error", th);
                                    com.alibaba.mtl.appmonitor.b.b.m8587a(th);
                                    if (sQLiteDatabase != null) {
                                        try {
                                            sQLiteDatabase.setTransactionSuccessful();
                                        } catch (Throwable th2) {
                                        }
                                        try {
                                            sQLiteDatabase.endTransaction();
                                        } catch (Throwable th3) {
                                        }
                                    }
                                    this.a.a(sQLiteDatabase);
                                    return z;
                                }
                            }
                        } else {
                            i.a("UTSqliteLogStore", "db is null");
                        }
                        if (writableDatabase != null) {
                            try {
                                writableDatabase.setTransactionSuccessful();
                            } catch (Throwable th4) {
                            }
                            try {
                                writableDatabase.endTransaction();
                            } catch (Throwable th5) {
                            }
                        }
                        this.a.a(writableDatabase);
                    } catch (Throwable th6) {
                        th = th6;
                        z = false;
                    }
                    return z;
                }
            }
            return true;
        }
    }

    @Override // com.alibaba.mtl.log.c.a
    public void c(String str, String str2) {
        synchronized (this) {
            SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
            if (writableDatabase != null) {
                writableDatabase.delete("log", str + " < ?", new String[]{String.valueOf(str2)});
                this.a.a(writableDatabase);
            } else {
                i.a("UTSqliteLogStore", "db is null");
            }
        }
    }

    @Override // com.alibaba.mtl.log.c.a
    public void clear() {
        synchronized (this) {
            SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
            if (writableDatabase != null) {
                writableDatabase.delete("log", null, null);
                this.a.a(writableDatabase);
            }
        }
    }

    @Override // com.alibaba.mtl.log.c.a
    public void e(int i) {
        if (i <= 0) {
            return;
        }
        SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
        if (writableDatabase == null) {
            i.a("UTSqliteLogStore", "db is null");
            return;
        }
        try {
            writableDatabase.execSQL(String.format(this.ac, Integer.valueOf(i)));
        } catch (Throwable th) {
        }
        this.a.a(writableDatabase);
    }

    @Override // com.alibaba.mtl.log.c.a
    public int g() {
        int i;
        synchronized (this) {
            SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
            i = 0;
            if (writableDatabase != null) {
                Cursor rawQuery = writableDatabase.rawQuery(String.format(this.ab, "log"), null);
                if (rawQuery != null) {
                    rawQuery.moveToFirst();
                    i = rawQuery.getInt(0);
                }
                a(rawQuery);
                this.a.a(writableDatabase);
            } else {
                i.a("UTSqliteLogStore", "db is null");
                i = 0;
            }
        }
        return i;
    }
}
