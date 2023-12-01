package com.igexin.push.core.e;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.service.notification.Condition;
import com.igexin.push.core.b.j;
import com.igexin.push.core.d;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/e/c.class */
public class c implements a {

    /* renamed from: c  reason: collision with root package name */
    private static c f23499c;
    private ArrayList<j> d;
    private boolean e;
    private String b = "MessageDataManager";

    /* renamed from: a  reason: collision with root package name */
    public int f23500a = -1;

    public static c a() {
        if (f23499c == null) {
            synchronized (c.class) {
                try {
                    if (f23499c == null) {
                        f23499c = new c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f23499c;
    }

    public static void a(int i, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(i));
        d.a.f23474a.i.a("message", contentValues, new String[]{"taskid"}, new String[]{str});
    }

    private void a(ContentValues contentValues) {
        try {
            if (this.f23500a == -1) {
                this.f23500a = b();
            }
            if (this.f23500a < 1000) {
                if (d.a.f23474a.i.a("message", contentValues) != -1) {
                    this.f23500a++;
                    return;
                }
                return;
            }
            int a2 = d.a.f23474a.i.a("message", "id IN (SELECT id from message where status IS NULL or status=1 or status=2 order by id asc limit 250)");
            this.f23500a -= a2;
            if (a2 < 250) {
                this.f23500a -= d.a.f23474a.i.a("message", "id IN (SELECT id from message where status=0 order by id asc limit " + (250 - a2) + ")");
            }
            if (d.a.f23474a.i.a("message", contentValues) != -1) {
                this.f23500a++;
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private static void a(SQLiteDatabase sQLiteDatabase, ArrayList<j> arrayList) {
        try {
            Iterator<j> it = arrayList.iterator();
            while (it.hasNext()) {
                j next = it.next();
                byte[] bArr = next.e;
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", Long.valueOf(next.f23444a));
                contentValues.put("messageid", next.b);
                contentValues.put("taskid", next.f23445c);
                contentValues.put("appid", next.d);
                if (bArr != null) {
                    contentValues.put("info", bArr);
                }
                if (next.f != null) {
                    contentValues.put("msgextra", next.f);
                }
                contentValues.put("key", next.g);
                contentValues.put("status", Integer.valueOf(next.h));
                contentValues.put("createtime", Long.valueOf(next.i));
                sQLiteDatabase.insert("message", null, contentValues);
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        arrayList.clear();
    }

    public static void a(String str, int i, int i2) {
        if (i2 == 0) {
            return;
        }
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("notify_status", Integer.valueOf(i));
            if (i == com.igexin.push.core.b.af) {
                Cursor a2 = d.a.f23474a.i.a("message", new String[]{DBDefinition.TASK_ID}, new String[]{str}, new String[]{"redisplay_num", "redisplay_duration", "redisplay_freq"}, null);
                if (a2 != null && a2.getCount() != 0) {
                    cursor = a2;
                    if (a2.moveToFirst()) {
                        int i3 = a2.getInt(a2.getColumnIndex("redisplay_num"));
                        long j = a2.getLong(a2.getColumnIndex("redisplay_duration"));
                        contentValues.put("redisplay_num", Integer.valueOf(i3 + 1));
                        contentValues.put("expect_redisplay_time", Long.valueOf((System.currentTimeMillis() / 1000) + j));
                        cursor = a2;
                    }
                }
                if (a2 != null) {
                    a2.close();
                    return;
                }
                return;
            }
            d.a.f23474a.i.a("message", contentValues, new String[]{"taskid"}, new String[]{str});
            cursor2 = cursor;
            com.igexin.push.e.e.c().d();
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
                if (cursor2 != null) {
                    cursor2.close();
                }
            } catch (Throwable th2) {
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th2;
            }
        }
    }

    public static boolean a(String str) {
        Cursor cursor = null;
        try {
            Cursor a2 = d.a.f23474a.i.a("message", new String[]{"taskid"}, new String[]{str}, null, null);
            boolean z = false;
            if (a2 != null) {
                cursor = a2;
                z = false;
                if (a2.getCount() > 0) {
                    z = true;
                }
            }
            if (a2 != null) {
                a2.close();
            }
            return z;
        } catch (Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
                if (cursor != null) {
                    cursor.close();
                    return false;
                }
                return false;
            } catch (Throwable th2) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th2;
            }
        }
    }

    public static int b() {
        Cursor a2;
        Cursor cursor = null;
        try {
            a2 = d.a.f23474a.i.a("message", null, null, null, null);
        } catch (Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
                if (cursor == null) {
                    return 0;
                }
            } catch (Throwable th2) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th2;
            }
        }
        if (a2 != null) {
            cursor = a2;
            int count = a2.getCount();
            if (a2 != null) {
                a2.close();
            }
            return count;
        } else if (a2 != null) {
            cursor = a2;
            cursor.close();
            return 0;
        } else {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(Condition.SCHEME);
            if (jSONObject2.has("wifi") || jSONObject2.has("screenOn") || jSONObject2.has("ssid") || jSONObject2.has("duration")) {
                return false;
            }
            return !jSONObject2.has("netConnected");
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return true;
        }
    }

    private static void e() {
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        try {
            cursor = sQLiteDatabase.query("message", null, "status =?", new String[]{"0"}, null, null, null, null);
            if (cursor != null) {
                ArrayList<j> arrayList = new ArrayList<>();
                while (true) {
                    cursor2 = cursor;
                    if (!cursor.moveToNext()) {
                        try {
                            break;
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                com.igexin.c.a.c.a.a(th);
                                if (cursor != null) {
                                    cursor.close();
                                    return;
                                }
                                return;
                            } catch (Throwable th3) {
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th3;
                            }
                        }
                    }
                    arrayList.add(new j(cursor.getInt(cursor.getColumnIndex("id")), cursor.getString(cursor.getColumnIndex("messageid")), cursor.getString(cursor.getColumnIndex("taskid")), cursor.getString(cursor.getColumnIndex("appid")), cursor.getBlob(cursor.getColumnIndexOrThrow("info")), cursor.getBlob(cursor.getColumnIndex("msgextra")), cursor.getString(cursor.getColumnIndex("key")), cursor.getInt(cursor.getColumnIndex("status")), cursor.getLong(cursor.getColumnIndex("createtime"))));
                }
                this.d = arrayList;
                arrayList.size();
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th4) {
            cursor = cursor2;
            th = th4;
        }
    }

    @Override // com.igexin.push.core.e.a
    public final void a(SQLiteDatabase sQLiteDatabase) {
        ArrayList<j> arrayList;
        if (!this.e || (arrayList = this.d) == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList<j> arrayList2 = this.d;
        try {
            Iterator<j> it = arrayList2.iterator();
            while (it.hasNext()) {
                j next = it.next();
                byte[] bArr = next.e;
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", Long.valueOf(next.f23444a));
                contentValues.put("messageid", next.b);
                contentValues.put("taskid", next.f23445c);
                contentValues.put("appid", next.d);
                if (bArr != null) {
                    contentValues.put("info", bArr);
                }
                if (next.f != null) {
                    contentValues.put("msgextra", next.f);
                }
                contentValues.put("key", next.g);
                contentValues.put("status", Integer.valueOf(next.h));
                contentValues.put("createtime", Long.valueOf(next.i));
                sQLiteDatabase.insert("message", null, contentValues);
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        arrayList2.clear();
    }

    @Override // com.igexin.push.core.e.a
    public final void b(SQLiteDatabase sQLiteDatabase) {
    }

    public final void c() {
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.a.d() { // from class: com.igexin.push.core.e.c.1
            @Override // com.igexin.push.a.d
            public final void a_() throws Exception {
                Cursor cursor = null;
                try {
                    com.igexin.push.a.b bVar = d.a.f23474a.i;
                    Cursor a2 = bVar.a("message", new String[]{"status"}, new String[]{"0"}, null, null);
                    if (a2 != null) {
                        while (true) {
                            cursor = a2;
                            if (!a2.moveToNext()) {
                                break;
                            }
                            byte[] blob = a2.getBlob(a2.getColumnIndex("info"));
                            long j = a2.getLong(a2.getColumnIndex("createtime"));
                            JSONObject jSONObject = new JSONObject(new String(com.igexin.c.b.a.c(blob)));
                            String string = jSONObject.getString("taskid");
                            if (jSONObject.has(Condition.SCHEME) && !c.b(jSONObject) && System.currentTimeMillis() - j > 259200000) {
                                String unused = c.this.b;
                                com.igexin.c.a.c.a.a(c.this.b + "|del condition taskid = " + string, new Object[0]);
                                bVar.a("message", new String[]{"taskid"}, new String[]{string});
                            }
                        }
                    }
                    if (a2 != null) {
                        a2.close();
                    }
                } catch (Throwable th) {
                    try {
                        com.igexin.c.a.c.a.a(th);
                        if (cursor != null) {
                            cursor.close();
                        }
                    } catch (Throwable th2) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th2;
                    }
                }
            }
        }, false, true);
    }

    @Override // com.igexin.push.core.e.a
    public final void c(SQLiteDatabase sQLiteDatabase) {
    }

    public final void d() {
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.a.d() { // from class: com.igexin.push.core.e.c.2
            @Override // com.igexin.push.a.d
            public final void a_() throws Exception {
                d.a.f23474a.i.a("message", "createtime <= ".concat(String.valueOf(System.currentTimeMillis() - 604800000)));
            }
        }, false, true);
    }

    public final void d(SQLiteDatabase sQLiteDatabase) {
        this.e = true;
        Cursor cursor = null;
        try {
            Cursor query = sQLiteDatabase.query("message", null, "status =?", new String[]{"0"}, null, null, null, null);
            if (query != null) {
                ArrayList<j> arrayList = new ArrayList<>();
                while (query.moveToNext()) {
                    arrayList.add(new j(query.getInt(query.getColumnIndex("id")), query.getString(query.getColumnIndex("messageid")), query.getString(query.getColumnIndex("taskid")), query.getString(query.getColumnIndex("appid")), query.getBlob(query.getColumnIndexOrThrow("info")), query.getBlob(query.getColumnIndex("msgextra")), query.getString(query.getColumnIndex("key")), query.getInt(query.getColumnIndex("status")), query.getLong(query.getColumnIndex("createtime"))));
                }
                this.d = arrayList;
                cursor = query;
                arrayList.size();
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th2) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th2;
            }
        }
    }
}
