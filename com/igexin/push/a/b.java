package com.igexin.push.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.igexin.push.core.e;
import com.igexin.push.core.e.f;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/a/b.class */
public final class b extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9680a = "DownDBHelper";
    private static final String b = "pushsdk.db";

    /* renamed from: c  reason: collision with root package name */
    private static final int f9681c = 7;
    private static final String d = "create table if not exists config (id integer primary key,value text)";
    private static final String e = "create table if not exists runtime (id integer primary key,value text)";
    private static final String f = "create table if not exists ral (id integer primary key,data text,type integer,time integer,send_times integer)";
    private static final String g = "create table if not exists message (id integer primary key autoincrement,messageid text,taskid text,appid text,info text,msgextra blob,key text,status integer,createtime integer,expect_redisplay_time integer, redisplay_freq integer,redisplay_duration integer ,redisplay_num integer,notify_status integer ) ";
    private static final String h = "create table if not exists bidata (id integer primary key,data text,type integer,time integer)";
    private static final String i = "drop table if exists config";
    private static final String j = "drop table if exists runtime";
    private static final String k = "drop table if exists ral";
    private static final String l = "drop table if exists ca";
    private static final String m = "drop table if exists bi";
    private static final String n = "drop table if exists message";
    private static final String o = "drop table if exists st";
    private static final String p = "drop table if exists bidata";
    private SQLiteDatabase q;

    public b(Context context) {
        super(context, "pushsdk.db", null, 7);
        this.q = null;
    }

    private b(Context context, String str, int i2) {
        super(context, str, null, i2);
        this.q = null;
    }

    private Cursor a(String str, String[] strArr) {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        this.q = readableDatabase;
        try {
            return readableDatabase.rawQuery(str, strArr);
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return null;
        }
    }

    private static String a(String[] strArr, String[] strArr2, int i2) {
        StringBuilder sb = new StringBuilder(" ");
        if (strArr.length == 1) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= i2) {
                    break;
                }
                sb.append(strArr[0]);
                sb.append(" = '");
                sb.append(strArr2[i4]);
                sb.append("'");
                if (i4 < i2 - 1) {
                    sb.append(" or ");
                }
                i3 = i4 + 1;
            }
        } else {
            for (int i5 = 0; i5 < i2; i5++) {
                sb.append(strArr[i5]);
                sb.append(" = '");
                sb.append(strArr2[i5]);
                sb.append("'");
                if (i5 < i2 - 1) {
                    sb.append(" and ");
                }
            }
        }
        return sb.toString();
    }

    private static void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                if (sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
            } catch (Exception e2) {
                com.igexin.c.a.c.a.a(f9680a, "closecurrentDatabase fail");
            }
        }
    }

    private void a(String str, String str2, ContentValues contentValues) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        this.q = writableDatabase;
        try {
            writableDatabase.replace(str, str2, contentValues);
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
        }
    }

    private boolean a(String str) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        this.q = writableDatabase;
        writableDatabase.beginTransaction();
        try {
            try {
                this.q.execSQL(str);
                this.q.setTransactionSuccessful();
                b(this.q);
                return true;
            } catch (Exception e2) {
                com.igexin.c.a.c.a.a(e2);
                b(this.q);
                return false;
            }
        } catch (Throwable th) {
            b(this.q);
            throw th;
        }
    }

    private static String b(String str, String str2) {
        return "delete from " + str + " where " + str2;
    }

    private static void b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.endTransaction();
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public final int a(String str, String str2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        this.q = writableDatabase;
        writableDatabase.beginTransaction();
        int i2 = 0;
        try {
            try {
                int delete = this.q.delete(str, str2, null);
                try {
                    com.igexin.c.a.c.a.a("DownDBHelper|del " + delete + " msg", new Object[0]);
                    this.q.setTransactionSuccessful();
                    return delete;
                } catch (Exception e2) {
                    e = e2;
                    i2 = delete;
                    com.igexin.c.a.c.a.a(e);
                    b(this.q);
                    return i2;
                }
            } finally {
                b(this.q);
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public final long a(String str, ContentValues contentValues) {
        long j2;
        SQLiteDatabase writableDatabase = getWritableDatabase();
        this.q = writableDatabase;
        writableDatabase.beginTransaction();
        try {
            try {
                j2 = this.q.insert(str, null, contentValues);
                try {
                    this.q.setTransactionSuccessful();
                } catch (Exception e2) {
                }
            } catch (Throwable th) {
                b(this.q);
                throw th;
            }
        } catch (Exception e3) {
            j2 = -1;
        }
        b(this.q);
        return j2;
    }

    public final Cursor a(String str, String[] strArr, String str2) {
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            this.q = readableDatabase;
            return readableDatabase.query(str, strArr, str2, null, null, null, null);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return null;
        }
    }

    public final Cursor a(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2) {
        Cursor cursor;
        SQLiteDatabase readableDatabase = getReadableDatabase();
        this.q = readableDatabase;
        readableDatabase.beginTransaction();
        try {
            try {
                if (strArr == null) {
                    cursor = this.q.query(str, strArr3, null, null, null, null, str2);
                } else if (strArr.length != 1) {
                    cursor = this.q.query(str, strArr3, a(strArr, strArr2, strArr.length), null, null, null, str2);
                } else if (strArr2.length == 1) {
                    cursor = this.q.query(str, strArr3, strArr[0] + "= ?", strArr2, null, null, str2);
                } else {
                    cursor = this.q.query(str, strArr3, a(strArr, strArr2, strArr2.length), null, null, null, str2);
                }
                try {
                    this.q.setTransactionSuccessful();
                } catch (Exception e2) {
                }
            } catch (Throwable th) {
                b(this.q);
                throw th;
            }
        } catch (Exception e3) {
            cursor = null;
        }
        b(this.q);
        return cursor;
    }

    public final void a(String str, ContentValues contentValues, String[] strArr, String[] strArr2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        this.q = writableDatabase;
        writableDatabase.beginTransaction();
        try {
            try {
                SQLiteDatabase sQLiteDatabase = this.q;
                sQLiteDatabase.update(str, contentValues, strArr[0] + "='" + strArr2[0] + "'", null);
                this.q.setTransactionSuccessful();
            } catch (Exception e2) {
                com.igexin.c.a.c.a.a(f9680a, str + "_Update Error!");
            }
        } finally {
            b(this.q);
        }
    }

    public final void a(String str, String[] strArr, String[] strArr2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        this.q = writableDatabase;
        writableDatabase.beginTransaction();
        try {
            try {
                if (strArr2.length == 1) {
                    SQLiteDatabase sQLiteDatabase = this.q;
                    int delete = sQLiteDatabase.delete(str, strArr[0] + " = ?", strArr2);
                    com.igexin.c.a.c.a.a("DownDBHelper|del " + str + " cnt = " + delete, new Object[0]);
                } else {
                    this.q.execSQL(b(str, a(strArr, strArr2, strArr2.length)));
                }
                this.q.setTransactionSuccessful();
            } catch (Exception e2) {
                com.igexin.c.a.c.a.a(f9680a, str + "_Delete Error!");
            }
        } finally {
            b(this.q);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL(d);
            sQLiteDatabase.execSQL(e);
            sQLiteDatabase.execSQL(g);
            sQLiteDatabase.execSQL(f);
            sQLiteDatabase.execSQL(h);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception e2) {
        } finally {
            b(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        onUpgrade(sQLiteDatabase, i3, i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        f.a().b = true;
        f.d(sQLiteDatabase);
        byte[] a2 = f.a(sQLiteDatabase, 1);
        if (a2 != null) {
            try {
                String str = new String(a2);
                e.z = str.equals(com.igexin.push.core.b.l) ? 0L : Long.parseLong(str);
            } catch (Exception e2) {
                com.igexin.c.a.c.a.a(e2);
            }
            com.igexin.c.a.c.a.a(f.f9902a + "|db version changed, save session = " + e.z, new Object[0]);
        }
        byte[] a3 = f.a(sQLiteDatabase, 20);
        if (a3 != null) {
            String str2 = new String(a3);
            String str3 = str2;
            if (str2.equals(com.igexin.push.core.b.l)) {
                str3 = null;
            }
            e.B = str3;
            e.A = str3;
            com.igexin.c.a.c.a.a(f.f9902a + "|db version changed, save cid = " + str3, new Object[0]);
        }
        String b2 = f.b(sQLiteDatabase, 3);
        if (!TextUtils.isEmpty(b2)) {
            String str4 = b2;
            if (b2.equals(com.igexin.push.core.b.l)) {
                str4 = null;
            }
            e.L = str4;
        }
        String str5 = e.L;
        String b3 = f.b(sQLiteDatabase, 2);
        if (!TextUtils.isEmpty(b3)) {
            String str6 = b3;
            if (b3.equals(com.igexin.push.core.b.l)) {
                str6 = null;
            }
            e.H = str6;
        }
        String b4 = f.b(sQLiteDatabase, 46);
        if (!TextUtils.isEmpty(b4)) {
            String str7 = b4;
            if (b4.equals(com.igexin.push.core.b.l)) {
                str7 = null;
            }
            e.I = str7;
        }
        String b5 = f.b(sQLiteDatabase, 48);
        if (!TextUtils.isEmpty(b5)) {
            String str8 = b5;
            if (b5.equals(com.igexin.push.core.b.l)) {
                str8 = null;
            }
            e.K = str8;
        }
        String b6 = f.b(sQLiteDatabase, 51);
        if (!TextUtils.isEmpty(b6)) {
            if (b6.equals(com.igexin.push.core.b.l)) {
                b6 = null;
            }
            e.C = b6;
        }
        com.igexin.push.core.e.c.a().d(sQLiteDatabase);
        try {
            sQLiteDatabase.execSQL(i);
        } catch (Exception e3) {
            com.igexin.c.a.c.a.a(e3);
        }
        try {
            sQLiteDatabase.execSQL(j);
        } catch (Exception e4) {
            com.igexin.c.a.c.a.a(e4);
        }
        try {
            sQLiteDatabase.execSQL(n);
        } catch (Exception e5) {
            com.igexin.c.a.c.a.a(e5);
        }
        try {
            sQLiteDatabase.execSQL(k);
        } catch (Exception e6) {
            com.igexin.c.a.c.a.a(e6);
        }
        try {
            sQLiteDatabase.execSQL(l);
        } catch (Exception e7) {
            com.igexin.c.a.c.a.a(e7);
        }
        try {
            sQLiteDatabase.execSQL(m);
        } catch (Exception e8) {
            com.igexin.c.a.c.a.a(e8);
        }
        try {
            sQLiteDatabase.execSQL(o);
        } catch (Exception e9) {
            com.igexin.c.a.c.a.a(e9);
        }
        try {
            sQLiteDatabase.execSQL(p);
        } catch (Exception e10) {
            com.igexin.c.a.c.a.a(e10);
        }
        onCreate(sQLiteDatabase);
    }
}
