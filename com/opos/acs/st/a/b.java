package com.opos.acs.st.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.opos.acs.st.STManager;
import com.opos.acs.st.utils.h;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/opos/acs/st/a/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final ReentrantReadWriteLock f10762a = new ReentrantReadWriteLock();
    private static final ReentrantReadWriteLock b = new ReentrantReadWriteLock();

    public static int a(Context context, String str, long j) {
        ReentrantReadWriteLock.WriteLock writeLock;
        int i = -1;
        if (context == null && j <= 0 && h.a(str)) {
            return -1;
        }
        String str2 = "EVENT_ID in (" + str + ") AND EVENT_TIME < " + j;
        try {
            SQLiteDatabase a2 = a.a(context);
            try {
                f10762a.writeLock().lock();
                int delete = a2.delete("t_acs_st_db_cache", str2, null);
                writeLock = f10762a.writeLock();
                i = delete;
            } catch (Exception e) {
                writeLock = f10762a.writeLock();
            } catch (Throwable th) {
                f10762a.writeLock().unlock();
                throw th;
            }
            writeLock.unlock();
            return i;
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.d("STDBUtils", "DeleteStatItemEntityByEventTime", e2);
            return -1;
        }
    }

    private static ContentValues a(com.opos.acs.st.b.b bVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("BATCH_ID", bVar.b);
        contentValues.put("ACS_POS_IDS", bVar.f10767c);
        contentValues.put("EFFECTIVE_TAG", Integer.valueOf(bVar.d));
        return contentValues;
    }

    private static com.opos.acs.st.b.c a(Context context, Cursor cursor) {
        com.opos.acs.st.b.c cVar = new com.opos.acs.st.b.c();
        cVar.f10768a = cursor.getInt(cursor.getColumnIndex(STManager.REGION_OF_ID));
        cVar.b = cursor.getString(cursor.getColumnIndex("EVENT_ID"));
        cVar.f10769c = cursor.getString(cursor.getColumnIndex("ACS_ID"));
        cVar.d = cursor.getString(cursor.getColumnIndex("URL"));
        cVar.h = cursor.getString(cursor.getColumnIndex("BATCH_ID"));
        cVar.i = cursor.getLong(cursor.getColumnIndex("EVENT_TIME"));
        cVar.e = com.opos.acs.st.b.a.b(context, cursor.getString(cursor.getColumnIndex("HEAD_JSON_STRING")));
        cVar.f = com.opos.acs.st.b.a.b(context, cursor.getString(cursor.getColumnIndex("BODY_JSON_STRING")));
        cVar.g = com.opos.acs.st.b.a.b(context, cursor.getString(cursor.getColumnIndex("EVENT_JSON_STRING")));
        cVar.j = cursor.getInt(cursor.getColumnIndex("UPLOAD_TYPE"));
        if (cVar.j == 1) {
            try {
                cVar.k = new JSONObject(cVar.e);
                cVar.l = new JSONObject(cVar.f);
                return cVar;
            } catch (JSONException e) {
                com.opos.cmn.an.f.a.d("STDBUtils", "getStatItemEntityFromCursor error!");
            }
        }
        return cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.opos.acs.st.b.c a(android.content.Context r7, java.lang.String r8, java.lang.String r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 218
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.acs.st.a.b.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String):com.opos.acs.st.b.c");
    }

    public static Integer a(Context context, String str) {
        String str2 = "select count(*) from t_acs_st_db_cache where EVENT_ID = '" + str + "'";
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            try {
                SQLiteDatabase a2 = a.a(context);
                f10762a.writeLock().lock();
                Cursor rawQuery = a2.rawQuery(str2, null);
                rawQuery.moveToFirst();
                cursor = rawQuery;
                cursor2 = rawQuery;
                int i = rawQuery.getInt(0);
                f10762a.writeLock().unlock();
                a(rawQuery);
                return Integer.valueOf(i);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.d("STDBUtils", "queryAllStatItemEntityCount", e);
                f10762a.writeLock().unlock();
                a(cursor2);
                return 0;
            }
        } catch (Throwable th) {
            f10762a.writeLock().unlock();
            a(cursor);
            throw th;
        }
    }

    private static String a(List<String> list) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            sb.append("(");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                sb.append(list.get(i2));
                if (i2 != list.size() - 1) {
                    sb.append(",");
                }
                i = i2 + 1;
            }
            sb.append(")");
        }
        return sb.toString();
    }

    private static String a(Integer[] numArr) {
        StringBuilder sb = new StringBuilder();
        if (numArr != null) {
            sb.append("(");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= numArr.length) {
                    break;
                }
                sb.append(numArr[i2]);
                if (i2 != numArr.length - 1) {
                    sb.append(",");
                }
                i = i2 + 1;
            }
            sb.append(")");
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<java.lang.String> a(android.content.Context r5) {
        /*
            Method dump skipped, instructions count: 204
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.acs.st.a.b.a(android.content.Context):java.util.List");
    }

    public static List<com.opos.acs.st.b.c> a(Context context, String str, String str2) {
        ArrayList arrayList;
        Cursor cursor;
        ArrayList arrayList2 = null;
        if (context != null) {
            arrayList2 = null;
            if (str != null) {
                arrayList2 = null;
                if (str2 != null) {
                    Cursor cursor2 = null;
                    try {
                        try {
                            SQLiteDatabase a2 = a.a(context);
                            try {
                                f10762a.readLock().lock();
                                cursor = a2.rawQuery("select * from t_acs_st_db_cache where EVENT_ID = ? AND URL = ? ", new String[]{str, str2});
                                try {
                                    try {
                                        f10762a.readLock().unlock();
                                        ArrayList arrayList3 = null;
                                        if (cursor != null) {
                                            arrayList3 = null;
                                            if (cursor.getCount() > 0) {
                                                arrayList3 = null;
                                                if (cursor.moveToFirst()) {
                                                    ArrayList arrayList4 = new ArrayList();
                                                    do {
                                                        try {
                                                            arrayList4.add(a(context, cursor));
                                                        } catch (Exception e) {
                                                            e = e;
                                                            arrayList = arrayList4;
                                                            com.opos.cmn.an.f.a.d("STDBUtils", "queryAllStatItemEntity", e);
                                                            if (cursor != null) {
                                                                a(cursor);
                                                            }
                                                            return arrayList;
                                                        }
                                                    } while (cursor.moveToNext());
                                                    arrayList3 = arrayList4;
                                                }
                                            }
                                        }
                                        arrayList2 = arrayList3;
                                        if (cursor != null) {
                                            a(cursor);
                                            return arrayList3;
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        cursor2 = cursor;
                                        if (cursor2 != null) {
                                            a(cursor2);
                                        }
                                        throw th;
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    arrayList = null;
                                }
                            } finally {
                            }
                        } catch (Exception e3) {
                            e = e3;
                            arrayList = null;
                            cursor = null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
        }
        return arrayList2;
    }

    private static void a(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return;
        }
        cursor.close();
    }

    public static boolean a(Context context, com.opos.acs.st.b.b bVar) {
        boolean z = false;
        boolean z2 = false;
        if (context != null) {
            ContentValues a2 = a(bVar);
            z = false;
            try {
                SQLiteDatabase a3 = a.a(context);
                b.writeLock().lock();
                if (-1 != a3.insert("t_stat_batch_entity", null, a2)) {
                    z2 = true;
                }
                z = z2;
                b.writeLock().unlock();
                return z2;
            } catch (Exception e) {
                com.opos.cmn.an.f.a.d("STDBUtils", "insertStatBatchEntity", e);
            }
        }
        return z;
    }

    public static boolean a(Context context, com.opos.acs.st.b.c cVar) {
        boolean z = false;
        boolean z2 = false;
        if (context != null) {
            z2 = false;
            if (cVar != null) {
                ContentValues c2 = c(context, cVar);
                z2 = false;
                try {
                    SQLiteDatabase a2 = a.a(context);
                    f10762a.writeLock().lock();
                    if (-1 != a2.insert("t_acs_st_db_cache", null, c2)) {
                        z = true;
                    }
                    z2 = z;
                    f10762a.writeLock().unlock();
                    return z;
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.d("STDBUtils", "insertStatItemEntity", e);
                }
            }
        }
        return z2;
    }

    public static boolean a(Context context, List<String> list) {
        String str;
        boolean z = true;
        if (context == null) {
            return false;
        }
        if (list == null || list.size() == 0) {
            str = "delete from t_stat_batch_entity";
        } else {
            str = "delete from t_stat_batch_entity where BATCH_ID in " + a(list);
        }
        try {
            SQLiteDatabase a2 = a.a(context);
            try {
                b.writeLock().lock();
                a2.execSQL(str);
                try {
                    b.writeLock().unlock();
                    return true;
                } catch (Exception e) {
                    e = e;
                    com.opos.cmn.an.f.a.d("STDBUtils", "deleteStatBatchEntitysByBatchIds", e);
                    return z;
                }
            } catch (Exception e2) {
                b.writeLock().unlock();
                return false;
            } catch (Throwable th) {
                b.writeLock().unlock();
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
        }
    }

    public static boolean a(Context context, Integer[] numArr) {
        String str;
        boolean z = true;
        if (context != null) {
            if (numArr == null || numArr.length == 0) {
                str = "delete from t_acs_st_db_cache";
            } else {
                str = "delete from t_acs_st_db_cache where ID in " + a(numArr);
            }
            try {
                SQLiteDatabase a2 = a.a(context);
                try {
                    f10762a.writeLock().lock();
                    a2.execSQL(str);
                } catch (Exception e) {
                    f10762a.writeLock().unlock();
                    return false;
                } catch (Throwable th) {
                    f10762a.writeLock().unlock();
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                z = false;
            }
            try {
                f10762a.writeLock().unlock();
                return true;
            } catch (Exception e3) {
                e = e3;
                com.opos.cmn.an.f.a.d("STDBUtils", "deleteStatItemEntityByIds", e);
                return z;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.opos.acs.st.b.b b(android.content.Context r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.acs.st.a.b.b(android.content.Context, java.lang.String):com.opos.acs.st.b.b");
    }

    public static boolean b(Context context, com.opos.acs.st.b.b bVar) {
        boolean z = false;
        if (context != null) {
            z = false;
            if (bVar != null) {
                int i = bVar.f10766a;
                ContentValues a2 = a(bVar);
                try {
                    SQLiteDatabase a3 = a.a(context);
                    b.writeLock().lock();
                    a3.update("t_stat_batch_entity", a2, "ID = ? ", new String[]{String.valueOf(i)});
                } catch (Exception e) {
                    e = e;
                    z = false;
                }
                try {
                    b.writeLock().unlock();
                    return true;
                } catch (Exception e2) {
                    e = e2;
                    z = true;
                    com.opos.cmn.an.f.a.d("STDBUtils", "updateStatBatchEntity", e);
                    return z;
                }
            }
        }
        return z;
    }

    public static boolean b(Context context, com.opos.acs.st.b.c cVar) {
        boolean z = false;
        if (context != null) {
            z = false;
            if (cVar != null) {
                int i = cVar.f10768a;
                ContentValues c2 = c(context, cVar);
                try {
                    SQLiteDatabase a2 = a.a(context);
                    f10762a.writeLock().lock();
                    a2.update("t_acs_st_db_cache", c2, "ID = ? ", new String[]{String.valueOf(i)});
                } catch (Exception e) {
                    e = e;
                    z = false;
                }
                try {
                    f10762a.writeLock().unlock();
                    return true;
                } catch (Exception e2) {
                    e = e2;
                    z = true;
                    com.opos.cmn.an.f.a.d("STDBUtils", "updateStatItemEntity", e);
                    return z;
                }
            }
        }
        return z;
    }

    private static ContentValues c(Context context, com.opos.acs.st.b.c cVar) {
        if (cVar.j == 1) {
            if (cVar.k != null) {
                cVar.e = cVar.k.toString();
            }
            if (cVar.l != null) {
                cVar.f = cVar.l.toString();
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("EVENT_ID", cVar.b);
        contentValues.put("ACS_ID", cVar.f10769c);
        contentValues.put("URL", cVar.d);
        contentValues.put("BATCH_ID", cVar.h);
        contentValues.put("EVENT_TIME", Long.valueOf(cVar.i));
        contentValues.put("HEAD_JSON_STRING", com.opos.acs.st.b.a.a(context, cVar.e));
        contentValues.put("BODY_JSON_STRING", com.opos.acs.st.b.a.a(context, cVar.f));
        contentValues.put("EVENT_JSON_STRING", com.opos.acs.st.b.a.a(context, cVar.g));
        contentValues.put("UPLOAD_TYPE", Integer.valueOf(cVar.j));
        return contentValues;
    }
}
