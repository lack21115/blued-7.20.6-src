package com.opos.acs.st.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.opos.acs.st.STManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: source-8303388-dex2jar.jar:com/opos/acs/st/a/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static ReentrantReadWriteLock f24450a = new ReentrantReadWriteLock();

    /* JADX WARN: Code restructure failed: missing block: B:15:0x006b, code lost:
        if (r4.isClosed() == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(android.content.Context r4) {
        /*
            Method dump skipped, instructions count: 208
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.acs.st.a.c.a(android.content.Context):int");
    }

    public static List<com.opos.acs.st.b.a> a(Context context, long j, int i) {
        ArrayList arrayList;
        Cursor cursor;
        if (context == null) {
            return null;
        }
        Cursor cursor2 = null;
        try {
            try {
                SQLiteDatabase a2 = a.a(context);
                f24450a.readLock().lock();
                cursor = a2.query("t_biz_entity", null, "EVENT_TIME>?", new String[]{String.valueOf(j)}, null, null, "UPDATE_TIME", String.valueOf(i));
                ArrayList arrayList2 = null;
                if (cursor != null) {
                    arrayList2 = null;
                    try {
                        try {
                            if (cursor.getCount() > 0) {
                                arrayList2 = null;
                                if (cursor.moveToFirst()) {
                                    ArrayList arrayList3 = new ArrayList();
                                    do {
                                        try {
                                            com.opos.acs.st.b.a aVar = new com.opos.acs.st.b.a();
                                            aVar.f24451a = cursor.getInt(cursor.getColumnIndex(STManager.REGION_OF_ID));
                                            aVar.b = com.opos.acs.st.b.a.b(context, cursor.getString(cursor.getColumnIndex("BIZ_DATA")));
                                            aVar.f24452c = cursor.getLong(cursor.getColumnIndex("EVENT_TIME"));
                                            aVar.d = cursor.getLong(cursor.getColumnIndex("UPDATE_TIME"));
                                            arrayList3.add(aVar);
                                        } catch (Exception e) {
                                            e = e;
                                            arrayList = arrayList3;
                                            e = e;
                                            cursor2 = cursor;
                                            com.opos.cmn.an.f.a.d("StBizUtils", "query all StBizEntity", e);
                                            f24450a.readLock().unlock();
                                            if (cursor != null && !cursor.isClosed()) {
                                                cursor.close();
                                            }
                                            return arrayList;
                                        }
                                    } while (cursor.moveToNext());
                                    arrayList2 = arrayList3;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = cursor;
                            f24450a.readLock().unlock();
                            if (cursor2 != null && !cursor2.isClosed()) {
                                cursor2.close();
                            }
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        arrayList = null;
                    }
                }
                f24450a.readLock().unlock();
                arrayList = arrayList2;
                if (cursor != null) {
                    arrayList = arrayList2;
                    if (!cursor.isClosed()) {
                        cursor.close();
                        return arrayList2;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
            arrayList = null;
            cursor = null;
        }
        return arrayList;
    }

    public static void a(Context context, long j) {
        if (context != null || j > 0) {
            try {
                try {
                    SQLiteDatabase a2 = a.a(context);
                    String concat = "EVENT_TIME < ".concat(String.valueOf(j));
                    f24450a.writeLock().lock();
                    a2.delete("t_biz_entity", concat, null);
                    com.opos.cmn.an.f.a.b("StBizUtils", "delete expired data from db!");
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.d("StBizUtils", "delete expired failed", e);
                }
                f24450a.writeLock().unlock();
            } catch (Throwable th) {
                f24450a.writeLock().unlock();
                throw th;
            }
        }
    }

    public static void a(Context context, com.opos.acs.st.b.a aVar) {
        if (context == null) {
            return;
        }
        try {
            try {
                ContentValues d = d(context, aVar);
                SQLiteDatabase a2 = a.a(context);
                f24450a.writeLock().lock();
                a2.insert("t_biz_entity", null, d);
                com.opos.cmn.an.f.a.b("StBizUtils", "saved business data to db!");
            } catch (Exception e) {
                com.opos.cmn.an.f.a.d("StBizUtils", "insert StBizEntity failed", e);
            }
            f24450a.writeLock().unlock();
        } catch (Throwable th) {
            f24450a.writeLock().unlock();
            throw th;
        }
    }

    public static void b(Context context, com.opos.acs.st.b.a aVar) {
        if (context != null) {
            try {
                if (aVar == null) {
                    return;
                }
                try {
                    aVar.d = System.currentTimeMillis();
                    int i = aVar.f24451a;
                    ContentValues d = d(context, aVar);
                    SQLiteDatabase a2 = a.a(context);
                    f24450a.writeLock().lock();
                    a2.update("t_biz_entity", d, "ID = ? ", new String[]{String.valueOf(i)});
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.d("StBizUtils", "update StBizEntity failed", e);
                }
                f24450a.writeLock().unlock();
            } catch (Throwable th) {
                f24450a.writeLock().unlock();
                throw th;
            }
        }
    }

    public static void c(Context context, com.opos.acs.st.b.a aVar) {
        if (context == null) {
            return;
        }
        try {
            try {
                SQLiteDatabase a2 = a.a(context);
                int i = aVar.f24451a;
                f24450a.writeLock().lock();
                a2.delete("t_biz_entity", "ID = ? ", new String[]{String.valueOf(i)});
                com.opos.cmn.an.f.a.b("StBizUtils", "delete business data from db!");
            } catch (Exception e) {
                com.opos.cmn.an.f.a.d("StBizUtils", "delete business failed", e);
            }
            f24450a.writeLock().unlock();
        } catch (Throwable th) {
            f24450a.writeLock().unlock();
            throw th;
        }
    }

    private static ContentValues d(Context context, com.opos.acs.st.b.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("BIZ_DATA", com.opos.acs.st.b.a.a(context, aVar.b));
        contentValues.put("EVENT_TIME", Long.valueOf(aVar.f24452c));
        contentValues.put("UPDATE_TIME", Long.valueOf(aVar.d));
        return contentValues;
    }
}
