package com.bytedance.bdtracker;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.sdk.api.ArticleInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/b2.class */
public class b2 extends t1 {
    public JSONArray A;
    public long B;
    public JSONArray C;
    public byte[] p;
    public int q;
    public int r;
    public JSONArray s;
    public long t;
    public JSONArray u;
    public long v;
    public a2 w;
    public JSONArray x;
    public f2 y;
    public JSONObject z;

    public static byte[] a(c cVar, ArrayList<t1> arrayList, JSONObject jSONObject) {
        JSONArray jSONArray;
        try {
            b2 b2Var = new b2();
            JSONArray[] jSONArrayArr = new JSONArray[3];
            jSONArrayArr[0] = new JSONArray();
            jSONArrayArr[1] = new JSONArray();
            jSONArrayArr[2] = null;
            long[] jArr = new long[3];
            Iterator<t1> it = arrayList.iterator();
            while (it.hasNext()) {
                t1 next = it.next();
                if ("event".equals(next.f())) {
                    jSONArray = jSONArrayArr[0];
                } else if ("eventv3".equals(next.f())) {
                    jSONArray = jSONArrayArr[1];
                }
                jSONArray.put(next.i());
            }
            b2Var.a(cVar.l, jSONObject, null, null, null, jSONArrayArr, jArr, null, 0);
            return b2Var.h().toString().getBytes();
        } catch (Throwable th) {
            z2.a("U SHALL NOT PASS!", th);
            return null;
        }
    }

    @Override // com.bytedance.bdtracker.t1
    public int a(Cursor cursor) {
        this.f7702a = cursor.getLong(0);
        this.b = cursor.getLong(1);
        this.p = cursor.getBlob(2);
        this.q = cursor.getInt(3);
        this.j = cursor.getInt(4);
        this.k = cursor.getString(5);
        this.d = "";
        this.z = null;
        this.w = null;
        this.y = null;
        this.x = null;
        this.s = null;
        this.u = null;
        this.A = null;
        this.C = null;
        return 6;
    }

    @Override // com.bytedance.bdtracker.t1
    public t1 a(JSONObject jSONObject) {
        z2.c("U SHALL NOT PASS!", (Throwable) null);
        return null;
    }

    public void a(String str, JSONObject jSONObject, a2 a2Var, f2 f2Var, JSONArray jSONArray, JSONArray[] jSONArrayArr, long[] jArr, JSONArray jSONArray2, int i) {
        a(0L);
        this.z = jSONObject;
        this.w = a2Var;
        this.y = f2Var;
        this.x = jSONArray;
        this.s = jSONArrayArr[0];
        this.t = jArr[0];
        this.u = jSONArrayArr[1];
        this.v = jArr[1];
        this.A = jSONArrayArr[2];
        this.B = jArr[2];
        this.C = jSONArray2;
        this.k = str;
        this.j = i;
    }

    @Override // com.bytedance.bdtracker.t1
    public List<String> b() {
        return Arrays.asList("_id", "integer primary key autoincrement", "local_time_ms", TypedValues.Custom.S_INT, "_data", "blob", "_fail", TypedValues.Custom.S_INT, "event_type", TypedValues.Custom.S_INT, "_app_id", "varchar");
    }

    @Override // com.bytedance.bdtracker.t1
    public void b(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.b));
        contentValues.put("_data", l());
        contentValues.put("event_type", Integer.valueOf(this.j));
        contentValues.put("_app_id", this.k);
    }

    @Override // com.bytedance.bdtracker.t1
    public String c() {
        return String.valueOf(this.f7702a);
    }

    @Override // com.bytedance.bdtracker.t1
    public void c(JSONObject jSONObject) {
        z2.c("U SHALL NOT PASS!", (Throwable) null);
    }

    @Override // com.bytedance.bdtracker.t1
    public String f() {
        return "pack";
    }

    @Override // com.bytedance.bdtracker.t1
    public JSONObject i() {
        int i;
        c a2 = b.a(this.k);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", this.z);
        jSONObject.put("time_sync", q1.e);
        jSONObject.put("local_time", System.currentTimeMillis() / 1000);
        if (this.w != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.w.h());
            jSONObject.put("launch", jSONArray);
        }
        f2 f2Var = this.y;
        if (f2Var != null) {
            JSONObject h = f2Var.h();
            JSONArray jSONArray2 = this.x;
            int length = jSONArray2 != null ? jSONArray2.length() : 0;
            JSONArray jSONArray3 = new JSONArray();
            int i2 = 0;
            long j = 0;
            while (true) {
                long j2 = j;
                if (i2 >= length) {
                    break;
                }
                JSONArray jSONArray4 = new JSONArray();
                JSONObject jSONObject2 = new JSONObject(this.x.optString(i2));
                JSONObject jSONObject3 = new JSONObject(jSONObject2.optString("params"));
                jSONArray4.put(0, jSONObject3.optString("page_key", ""));
                jSONArray4.put(1, (jSONObject3.optInt("duration", 0) + 999) / 1000);
                jSONArray3.put(jSONArray4);
                long optLong = jSONObject2.optLong("local_time_ms", 0L);
                long j3 = j2;
                if (optLong > j2) {
                    h.put("$page_title", jSONObject3.optString(ArticleInfo.PAGE_TITLE, ""));
                    h.put("$page_key", jSONObject3.optString("page_key", ""));
                    j3 = optLong;
                }
                i2++;
                j = j3;
            }
            if (length > 0) {
                h.put("activites", jSONArray3);
            }
            if (a2 != null && (i = a2.k) > 0) {
                h.put("launch_from", i);
                a2.k = 0;
            }
            JSONArray jSONArray5 = new JSONArray();
            jSONArray5.put(h);
            jSONObject.put("terminate", jSONArray5);
        }
        int i3 = 0;
        JSONArray jSONArray6 = this.s;
        int length2 = jSONArray6 != null ? jSONArray6.length() : 0;
        if (length2 > 0) {
            jSONObject.put("event", this.s);
        }
        JSONArray jSONArray7 = this.x;
        int length3 = jSONArray7 != null ? jSONArray7.length() : 0;
        if (a2 != null && a2.isBavEnabled()) {
            if (this.u == null) {
                this.u = this.x;
            } else if (length3 > 0) {
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= length3) {
                        break;
                    }
                    this.u.put(this.x.get(i5));
                    i4 = i5 + 1;
                }
            }
        }
        JSONArray jSONArray8 = this.u;
        int length4 = jSONArray8 != null ? jSONArray8.length() : 0;
        if (length4 > 0) {
            jSONObject.put("event_v3", this.u);
        }
        JSONArray jSONArray9 = this.A;
        int length5 = jSONArray9 != null ? jSONArray9.length() : 0;
        if (length5 > 0) {
            jSONObject.put(com.igexin.c.a.c.a.d.d, this.A);
        }
        JSONArray jSONArray10 = this.C;
        if (jSONArray10 != null) {
            i3 = jSONArray10.length();
        }
        if (i3 > 0) {
            jSONObject.put("item_impression", this.C);
        }
        StringBuilder a3 = a.a("pack {ts:");
        a3.append(this.b);
        a3.append(", la:");
        a2 a2Var = this.w;
        if (a2Var == null) {
            a2Var = "0";
        }
        a3.append(a2Var);
        a3.append(", te:");
        f2 f2Var2 = this.y;
        a3.append(f2Var2 != null ? f2Var2 : "0");
        a3.append(", p:");
        a3.append(length3);
        a3.append(", v1:");
        a3.append(length2);
        a3.append(", v3:");
        a3.append(length4);
        a3.append(", m:");
        a3.append(length5);
        a3.append(", imp:");
        a3.append(i3);
        a3.append("}");
        z2.a(a3.toString());
        return jSONObject;
    }

    public byte[] l() {
        this.p = null;
        if (b.c(this.k)) {
            try {
                this.p = ((c) Objects.requireNonNull(b.a(this.k))).j.f7685c.b(h().toString());
            } catch (OutOfMemoryError e) {
                throw new RuntimeException("to bytes error", e);
            }
        }
        return this.p;
    }
}
