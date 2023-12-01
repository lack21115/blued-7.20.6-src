package com.getui.gtc.b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/b/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static C0340a f21893a;

    /* renamed from: com.getui.gtc.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/b/a$a.class */
    static final class C0340a extends SQLiteOpenHelper {
        C0340a(Context context) {
            super(context, "gtc.db", null, 5);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* JADX WARN: Not initialized variable reg: 12, insn: 0x00f7: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r12 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:55:0x00f7 */
    public static String a(Context context) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase2;
        byte[] blob;
        AutoCloseable autoCloseable = null;
        if (!context.getDatabasePath("gtc.db").exists()) {
            return null;
        }
        if (f21893a == null) {
            f21893a = new C0340a(context);
        }
        try {
            try {
                sQLiteDatabase = f21893a.getReadableDatabase();
            } catch (Exception e) {
                e = e;
                sQLiteDatabase = null;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                sQLiteDatabase = null;
            }
            try {
                Cursor query = sQLiteDatabase.query("i", new String[]{"b"}, "a=?", new String[]{"100"}, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToNext() && (blob = query.getBlob(0)) != null) {
                            String str = new String(com.getui.gtc.i.a.b.a(blob, com.getui.gtc.i.a.a.a(context.getPackageName())));
                            if (query != null) {
                                query.close();
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            return str;
                        }
                    } catch (Exception e2) {
                        cursor = query;
                        e = e2;
                        com.getui.gtc.i.c.a.a(e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase == null) {
                            return null;
                        }
                        sQLiteDatabase.close();
                        return null;
                    }
                }
                if (query != null) {
                    query.close();
                }
                if (sQLiteDatabase == null) {
                    return null;
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                    autoCloseable.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
            sQLiteDatabase.close();
            return null;
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabase = sQLiteDatabase2;
        }
    }
}
