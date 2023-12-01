package com.bytedance.bdtracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.MediaFormat;
import android.text.TextUtils;
import com.bytedance.applog.event.EventPolicy;
import com.bytedance.applog.event.EventType;
import com.bytedance.applog.event.IEventHandler;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/w1.class */
public class w1 {
    public static final int[] f = {1};

    /* renamed from: a  reason: collision with root package name */
    public final t1[] f7723a = t1.k();
    public final HashMap<String, t1> b = t1.j();

    /* renamed from: c  reason: collision with root package name */
    public final a f7724c;
    public String d;
    public final v e;

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/w1$a.class */
    public class a extends SQLiteOpenHelper {
        public a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
            super(context, str, cursorFactory, i);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.beginTransaction();
                for (t1 t1Var : w1.this.b.values()) {
                    String a2 = t1Var.a();
                    if (a2 != null) {
                        sQLiteDatabase.execSQL(a2);
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                try {
                } finally {
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            onUpgrade(sQLiteDatabase, i, i2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            z2.b("onUpgrade, " + i + ", " + i2);
            try {
                sQLiteDatabase.beginTransaction();
                for (t1 t1Var : w1.this.b.values()) {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + t1Var.f());
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                try {
                    j1.a(sQLiteDatabase);
                    onCreate(sQLiteDatabase);
                } catch (Throwable th) {
                }
            }
            j1.a(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }
    }

    public w1(v vVar, String str) {
        this.f7724c = new a(vVar.a(), str, null, 44);
        this.e = vVar;
    }

    public static String c(String str) {
        return "SELECT * FROM launch WHERE _app_id='" + str + "' ORDER BY _id LIMIT 5";
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00f7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0026 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(java.lang.String r9, int r10, android.database.sqlite.SQLiteDatabase r11, java.lang.String r12, boolean r13, int r14, org.json.JSONArray[] r15, long[] r16) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.w1.a(java.lang.String, int, android.database.sqlite.SQLiteDatabase, java.lang.String, boolean, int, org.json.JSONArray[], long[]):int");
    }

    public final EventPolicy a(IEventHandler iEventHandler, int i, String str, t1 t1Var, JSONObject jSONObject) {
        t1Var.h();
        String d = t1Var.d();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = jSONObject2;
        if (!TextUtils.isEmpty(d)) {
            try {
                jSONObject3 = new JSONObject(d);
            } catch (Throwable th) {
                z2.b("Param: [" + d + "] is not a json string.", (Throwable) null);
                jSONObject3 = jSONObject2;
            }
        }
        if (jSONObject != null) {
            j1.c(jSONObject, jSONObject3);
        }
        EventPolicy onReceive = iEventHandler.onReceive(i, str, jSONObject3);
        t1Var.m = jSONObject3;
        return onReceive;
    }

    public final String a(String str, t1 t1Var, String str2, boolean z, int i, int i2) {
        StringBuilder a2 = com.bytedance.bdtracker.a.a("SELECT * FROM ");
        a2.append(t1Var.f());
        a2.append(" WHERE ");
        a2.append("_app_id");
        a2.append("='");
        a2.append(str);
        a2.append("' AND ");
        a2.append("session_id");
        a2.append(z ? "='" : "!='");
        a2.append(str2);
        a2.append("' AND ");
        a2.append("event_type");
        a2.append("='");
        a2.append(i2);
        a2.append("' ORDER BY ");
        a2.append("_id");
        a2.append(" LIMIT ");
        a2.append(i);
        return a2.toString();
    }

    public final String a(String str, String str2, int i, String str3, boolean z, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append(str2);
        sb.append(" WHERE ");
        sb.append("_app_id");
        sb.append("='");
        sb.append(str);
        sb.append("' AND ");
        sb.append("session_id");
        sb.append(z ? "='" : "!='");
        sb.append(str3);
        sb.append("' AND ");
        sb.append("event_type");
        sb.append("='");
        sb.append(i);
        sb.append("' AND ");
        sb.append("_id");
        sb.append(SimpleComparison.LESS_THAN_EQUAL_TO_OPERATION);
        sb.append(j);
        return sb.toString();
    }

    public ArrayList<b2> a(String str, JSONObject jSONObject) {
        ArrayList<b2> arrayList;
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        JSONArray[] jSONArrayArr;
        long[] jArr;
        HashMap<String, JSONObject> hashMap;
        Cursor rawQuery;
        Cursor cursor2;
        SQLiteDatabase sQLiteDatabase2;
        String str2;
        boolean z;
        JSONObject jSONObject2;
        Throwable th;
        synchronized (this) {
            a2 a2Var = (a2) this.b.get("launch");
            f2 f2Var = (f2) this.b.get("terminate");
            c2 c2Var = (c2) this.b.get(WBPageConstants.ParamKey.PAGE);
            b2 b2Var = (b2) this.b.get("pack");
            arrayList = new ArrayList<>();
            try {
                jSONArrayArr = new JSONArray[3];
                jArr = new long[3];
                hashMap = new HashMap<>();
                sQLiteDatabase = this.f7724c.getWritableDatabase();
                try {
                    a(str, sQLiteDatabase, hashMap);
                    sQLiteDatabase.beginTransaction();
                    rawQuery = sQLiteDatabase.rawQuery(c(str), null);
                    cursor2 = rawQuery;
                    sQLiteDatabase2 = sQLiteDatabase;
                    try {
                        z zVar = this.e.m;
                        str2 = zVar.e;
                        z = zVar.i;
                        jSONObject2 = jSONObject;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = cursor2;
                        sQLiteDatabase = sQLiteDatabase2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor = null;
                }
            } catch (Throwable th4) {
                th = th4;
                cursor = null;
                sQLiteDatabase = null;
            }
            while (true) {
                cursor2 = rawQuery;
                sQLiteDatabase2 = sQLiteDatabase;
                if (!rawQuery.moveToNext()) {
                    break;
                }
                a2Var.a(rawQuery);
                b2Var.d = a2Var.d;
                jSONObject2 = a(a2Var, jSONObject);
                if (TextUtils.equals(a2Var.d, str2)) {
                    try {
                        a2Var.r = !z;
                    } catch (Throwable th5) {
                        th = th5;
                    }
                    try {
                        a(str, jSONObject2, a2Var, b2Var, sQLiteDatabase, jSONArrayArr, jArr, arrayList, hashMap);
                    } catch (Throwable th6) {
                        th = th6;
                        cursor = rawQuery;
                        z2.a("U SHALL NOT PASS!", th);
                        j1.a(cursor);
                        j1.a(sQLiteDatabase);
                        return arrayList;
                    }
                } else {
                    try {
                        a(str, jSONObject2, a2Var, b2Var, c2Var, f2Var, sQLiteDatabase, jSONArrayArr, jArr, hashMap);
                        sQLiteDatabase.execSQL("DELETE FROM launch WHERE _id=?", new String[]{String.valueOf(a2Var.f7702a)});
                    } catch (Throwable th7) {
                        th = th7;
                        cursor = rawQuery;
                    }
                }
                SQLiteDatabase sQLiteDatabase3 = sQLiteDatabase;
                try {
                    a(str, jSONObject2, true, b2Var, sQLiteDatabase3);
                    sQLiteDatabase = sQLiteDatabase3;
                } catch (Throwable th8) {
                    cursor = th8;
                    th = th;
                }
                cursor = th8;
                th = th;
                z2.a("U SHALL NOT PASS!", th);
                j1.a(cursor);
                j1.a(sQLiteDatabase);
            }
            SQLiteDatabase sQLiteDatabase4 = sQLiteDatabase;
            if (rawQuery.getCount() < 5 && !TextUtils.isEmpty(str2)) {
                a(str, jSONObject2, a2Var, f2Var, c2Var, b2Var, sQLiteDatabase4, str2, jSONArrayArr, jArr);
                a(str, jSONObject2, false, b2Var, sQLiteDatabase4);
            }
            sQLiteDatabase4.setTransactionSuccessful();
            j1.a(rawQuery);
            j1.a(sQLiteDatabase4);
        }
        return arrayList;
    }

    public final JSONArray a(a2 a2Var, HashMap hashMap) {
        JSONObject jSONObject = (JSONObject) hashMap.get(a2Var.d);
        JSONArray jSONArray = null;
        if (jSONObject != null) {
            jSONArray = jSONObject.optJSONArray("item_impression");
            if (jSONArray != null && jSONArray.length() == 0) {
                return null;
            }
        }
        return jSONArray;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x02e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final org.json.JSONArray a(java.lang.String r6, com.bytedance.bdtracker.a2 r7, boolean r8, com.bytedance.bdtracker.f2 r9, com.bytedance.bdtracker.c2 r10, android.database.sqlite.SQLiteDatabase r11) {
        /*
            Method dump skipped, instructions count: 967
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.w1.a(java.lang.String, com.bytedance.bdtracker.a2, boolean, com.bytedance.bdtracker.f2, com.bytedance.bdtracker.c2, android.database.sqlite.SQLiteDatabase):org.json.JSONArray");
    }

    public final JSONObject a(a2 a2Var, JSONObject jSONObject) {
        if (!TextUtils.equals(a2Var.q, this.e.h.m()) || a2Var.p != this.e.h.l()) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                j1.a(jSONObject2, jSONObject);
                jSONObject2.put("app_version", a2Var.q);
                jSONObject2.put("version_code", a2Var.p);
                return jSONObject2;
            } catch (JSONException e) {
                z2.c("U SHALL NOT PASS!", e);
            }
        }
        return jSONObject;
    }

    public final void a(String str, SQLiteDatabase sQLiteDatabase, HashMap<String, JSONObject> hashMap) {
        a2 a2Var = (a2) this.b.get("launch");
        Cursor cursor = null;
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery(c(str), null);
            while (true) {
                cursor = rawQuery;
                if (!rawQuery.moveToNext()) {
                    j1.a(rawQuery);
                    j1.a(rawQuery);
                    return;
                }
                a2Var.a(rawQuery);
                JSONObject jSONObject = new JSONObject();
                this.e.f7719c.b.onSessionBatchEvent(a2Var.f7702a, a2Var.d, jSONObject);
                hashMap.put(a2Var.d, jSONObject);
            }
        } catch (Throwable th) {
            try {
                z2.a("U SHALL NOT PASS!", th);
                j1.a(cursor);
                j1.a(cursor);
            } catch (Throwable th2) {
                j1.a(cursor);
                j1.a(cursor);
                throw th2;
            }
        }
    }

    public void a(String str, b2 b2Var, boolean z, SQLiteDatabase sQLiteDatabase, boolean z2) {
        boolean z3;
        boolean z4;
        if (sQLiteDatabase == null) {
            sQLiteDatabase = this.f7724c.getWritableDatabase();
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            try {
                sQLiteDatabase.beginTransaction();
            } catch (Throwable th) {
                try {
                    z2.a("U SHALL NOT PASS!", th);
                    if (!z3) {
                        return;
                    }
                } finally {
                    if (z3) {
                        j1.a(sQLiteDatabase);
                    }
                }
            }
        }
        if (z2 && sQLiteDatabase.insert("pack", null, b2Var.a((ContentValues) null)) < 0) {
            if (b2Var.w != null) {
                a((String) null);
            }
            if (z4) {
                return;
            }
            return;
        }
        if (b2Var.t > 0) {
            sQLiteDatabase.execSQL(a(str, "event", b2Var.j, b2Var.d, z, b2Var.t));
        }
        long j = b2Var.v;
        if (j > 0) {
            sQLiteDatabase.execSQL(a(str, "eventv3", b2Var.j, b2Var.d, z, j));
        }
        long j2 = b2Var.B;
        if (j2 > 0) {
            sQLiteDatabase.execSQL(a(str, "event_misc", b2Var.j, b2Var.d, z, j2));
        }
        if (z3) {
            sQLiteDatabase.setTransactionSuccessful();
        }
        if (!z3) {
            return;
        }
        j1.a(sQLiteDatabase);
    }

    public void a(String str, ArrayList<b2> arrayList, ArrayList<b2> arrayList2, ArrayList<b2> arrayList3) {
        SQLiteDatabase sQLiteDatabase;
        Iterator<b2> it = arrayList2.iterator();
        while (it.hasNext()) {
            b2 next = it.next();
            if (!arrayList3.contains(next) && Math.abs(System.currentTimeMillis() - next.b) > 864000000) {
                arrayList.add(next);
                it.remove();
            }
        }
        try {
            SQLiteDatabase writableDatabase = this.f7724c.getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                Iterator<b2> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    b2 next2 = it2.next();
                    if (arrayList3.contains(next2)) {
                        a(str, next2, true, writableDatabase, false);
                    } else {
                        writableDatabase.execSQL("DELETE FROM pack WHERE _id=?", new String[]{String.valueOf(next2.f7702a)});
                    }
                }
                Iterator<b2> it3 = arrayList2.iterator();
                while (it3.hasNext()) {
                    b2 next3 = it3.next();
                    if (next3.w != null) {
                        a((String) null);
                    }
                    if (!arrayList3.contains(next3)) {
                        long j = next3.f7702a;
                        int i = next3.q + 1;
                        next3.q = i;
                        writableDatabase.execSQL("UPDATE pack SET _fail=" + i + " WHERE _id=" + j);
                    }
                }
                writableDatabase.setTransactionSuccessful();
                sQLiteDatabase = writableDatabase;
            } catch (Throwable th) {
                th = th;
                sQLiteDatabase = writableDatabase;
                try {
                    z2.c("U SHALL NOT PASS!", th);
                    j1.a(sQLiteDatabase);
                } catch (Throwable th2) {
                    j1.a(sQLiteDatabase);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabase = null;
        }
        j1.a(sQLiteDatabase);
    }

    public final void a(String str, JSONObject jSONObject, a2 a2Var, b2 b2Var, SQLiteDatabase sQLiteDatabase, JSONArray[] jSONArrayArr, long[] jArr, ArrayList<b2> arrayList, HashMap<String, JSONObject> hashMap) {
        boolean a2 = a(a2Var.d);
        int a3 = a(str, 0, sQLiteDatabase, a2Var.d, true, 0, jSONArrayArr, jArr);
        JSONArray a4 = a(a2Var, hashMap);
        if (a2 || a(jArr) || a4 != null) {
            b2Var.a(str, jSONObject, a2 ? a2Var : null, null, null, jSONArrayArr, jArr, a4, 0);
            if (a4 != null || a3 < this.f7723a.length) {
                a(str, b2Var, true, sQLiteDatabase, true);
            } else {
                b2 b2Var2 = (b2) b2Var.m2745clone();
                b2Var2.l();
                arrayList.add(b2Var2);
            }
        }
        while (a3 < this.f7723a.length) {
            a3 = a(str, a3, sQLiteDatabase, a2Var.d, true, 0, jSONArrayArr, jArr);
            if (a(jArr)) {
                b2Var.a(str, jSONObject, a(a2Var.d) ? a2Var : null, null, null, jSONArrayArr, jArr, null, 0);
                a(str, b2Var, true, sQLiteDatabase, true);
            }
        }
    }

    public final void a(String str, JSONObject jSONObject, a2 a2Var, b2 b2Var, c2 c2Var, f2 f2Var, SQLiteDatabase sQLiteDatabase, JSONArray[] jSONArrayArr, long[] jArr, HashMap<String, JSONObject> hashMap) {
        int a2;
        JSONArray a3 = a(str, a2Var, true, f2Var, c2Var, sQLiteDatabase);
        a2Var.r = a3.length() == 0;
        int a4 = a(str, 0, sQLiteDatabase, a2Var.d, true, 0, jSONArrayArr, jArr);
        JSONArray a5 = a(a2Var, hashMap);
        if (a2Var.r) {
            b2Var.a(str, jSONObject, a(a2Var.d) ? a2Var : null, null, null, jSONArrayArr, jArr, a5, 0);
        } else {
            b2Var.a(str, jSONObject, a(a2Var.d) ? a2Var : null, f2Var, a3, jSONArrayArr, jArr, a5, 0);
        }
        while (true) {
            a(str, b2Var, true, sQLiteDatabase, true);
            while (a4 < this.f7723a.length) {
                a2 = a(str, a4, sQLiteDatabase, a2Var.d, true, 0, jSONArrayArr, jArr);
                a4 = a2;
                if (a(jArr)) {
                    break;
                }
            }
            return;
            b2Var.a(str, jSONObject, null, null, null, jSONArrayArr, jArr, null, 0);
            a4 = a2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a7  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x008f -> B:22:0x009d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.String r12, org.json.JSONObject r13, com.bytedance.bdtracker.a2 r14, com.bytedance.bdtracker.f2 r15, com.bytedance.bdtracker.c2 r16, com.bytedance.bdtracker.b2 r17, android.database.sqlite.SQLiteDatabase r18, java.lang.String r19, org.json.JSONArray[] r20, long[] r21) {
        /*
            Method dump skipped, instructions count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.w1.a(java.lang.String, org.json.JSONObject, com.bytedance.bdtracker.a2, com.bytedance.bdtracker.f2, com.bytedance.bdtracker.c2, com.bytedance.bdtracker.b2, android.database.sqlite.SQLiteDatabase, java.lang.String, org.json.JSONArray[], long[]):void");
    }

    public final void a(String str, JSONObject jSONObject, boolean z, b2 b2Var, SQLiteDatabase sQLiteDatabase) {
        int[] iArr = f;
        int length = iArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            b2 b2Var2 = b2Var;
            if (i2 >= length) {
                return;
            }
            int i3 = iArr[i2];
            JSONArray[] jSONArrayArr = new JSONArray[3];
            long[] jArr = new long[3];
            int a2 = a(str, 0, sQLiteDatabase, b2Var2.d, z, i3, jSONArrayArr, jArr);
            if (a(jArr)) {
                b2Var.a(str, jSONObject, null, null, null, jSONArrayArr, jArr, null, i3);
                a(str, b2Var, z, sQLiteDatabase, true);
                while (a2 < this.f7723a.length) {
                    a2 = a(str, a2, sQLiteDatabase, b2Var2.d, z, i3, jSONArrayArr, jArr);
                    if (a(jArr)) {
                        b2Var.a(str, jSONObject, null, null, null, jSONArrayArr, jArr, null, i3);
                        a(str, b2Var, z, sQLiteDatabase, true);
                    }
                    b2Var2 = b2Var;
                }
            }
            i = i2 + 1;
        }
    }

    public void a(ArrayList<t1> arrayList) {
        synchronized (this) {
            SQLiteDatabase writableDatabase = this.f7724c.getWritableDatabase();
            writableDatabase.beginTransaction();
            Iterator<t1> it = arrayList.iterator();
            while (it.hasNext()) {
                writableDatabase.execSQL("DELETE FROM profile WHERE _id=?", new String[]{String.valueOf(it.next().f7702a)});
            }
            writableDatabase.setTransactionSuccessful();
            j1.a(writableDatabase);
        }
    }

    public final boolean a(IEventHandler iEventHandler, t1 t1Var) {
        EventPolicy eventPolicy;
        String str;
        if (iEventHandler == null || t1Var == null) {
            return true;
        }
        int acceptType = iEventHandler.acceptType();
        if (t1Var instanceof v1) {
            eventPolicy = null;
            if (EventType.a(acceptType, 8)) {
                eventPolicy = a(iEventHandler, 8, "bav2b_click", t1Var, t1Var.m);
            }
        } else {
            int i = 2;
            if (t1Var instanceof z1) {
                eventPolicy = null;
                if (EventType.a(acceptType, 1)) {
                    str = ((z1) t1Var).r;
                    i = 1;
                    eventPolicy = a(iEventHandler, i, j1.a((Object) str), t1Var, t1Var.m);
                }
            } else if (t1Var instanceof c2) {
                eventPolicy = null;
                if (EventType.a(acceptType, 4)) {
                    eventPolicy = a(iEventHandler, 4, "bav2b_page", t1Var, t1Var.m);
                }
            } else {
                eventPolicy = null;
                if (t1Var instanceof d2) {
                    eventPolicy = null;
                    if (EventType.a(acceptType, 2)) {
                        str = ((d2) t1Var).q;
                        eventPolicy = a(iEventHandler, i, j1.a((Object) str), t1Var, t1Var.m);
                    }
                }
            }
        }
        return eventPolicy != EventPolicy.DENY;
    }

    public final boolean a(String str) {
        if (TextUtils.equals(str, this.d)) {
            return false;
        }
        this.d = str;
        return true;
    }

    public final boolean a(long[] jArr) {
        boolean z = false;
        if (jArr[0] > 0 || jArr[1] > 0 || jArr[2] > 0) {
            z = true;
        }
        return z;
    }

    public ArrayList<t1> b(String str) {
        ArrayList<t1> arrayList;
        Cursor cursor;
        SQLiteDatabase writableDatabase;
        Cursor cursor2;
        synchronized (this) {
            d2 d2Var = (d2) this.b.get(MediaFormat.KEY_PROFILE);
            arrayList = new ArrayList<>();
            SQLiteDatabase sQLiteDatabase = null;
            try {
                writableDatabase = this.f7724c.getWritableDatabase();
                cursor2 = null;
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
                writableDatabase.beginTransaction();
                StringBuilder sb = new StringBuilder();
                sb.append("SELECT * FROM profile WHERE _app_id='");
                sb.append(str);
                sb.append("'  ORDER BY ");
                sb.append("_id");
                sb.append(" DESC LIMIT ");
                sb.append(200);
                Cursor rawQuery = writableDatabase.rawQuery(sb.toString(), null);
                while (rawQuery.moveToNext()) {
                    d2Var.a(rawQuery);
                    arrayList.add(d2Var.m2745clone());
                }
                cursor2 = rawQuery;
                writableDatabase.setTransactionSuccessful();
                j1.a(rawQuery);
                j1.a(writableDatabase);
            } catch (Throwable th2) {
                cursor = cursor2;
                sQLiteDatabase = writableDatabase;
                th = th2;
                z2.c("U SHALL NOT PASS!", th);
                j1.a(cursor);
                j1.a(sQLiteDatabase);
                return arrayList;
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0175 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(java.util.ArrayList<com.bytedance.bdtracker.t1> r11) {
        /*
            Method dump skipped, instructions count: 608
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.w1.b(java.util.ArrayList):void");
    }
}
