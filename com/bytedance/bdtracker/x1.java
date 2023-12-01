package com.bytedance.bdtracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdtracker.s2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/x1.class */
public class x1 extends t1 {
    public String p;
    public String q;
    public String r;
    public String s;
    public long t;
    public long u;

    public x1() {
    }

    public x1(String str, String str2, String str3, String str4, long j, long j2, String str5) {
        a(0L);
        this.p = str2;
        this.q = str3;
        this.r = str4;
        this.t = j;
        this.u = j2;
        this.s = str5;
        this.j = 0;
        this.k = str;
    }

    @Override // com.bytedance.bdtracker.t1
    public int a(Cursor cursor) {
        super.a(cursor);
        this.p = cursor.getString(12);
        this.q = cursor.getString(13);
        this.t = cursor.getLong(14);
        this.u = cursor.getLong(15);
        this.s = cursor.getString(16);
        this.r = cursor.getString(17);
        return 18;
    }

    @Override // com.bytedance.bdtracker.t1
    public t1 a(JSONObject jSONObject) {
        super.a(jSONObject);
        this.f21309c = jSONObject.optLong("tea_event_index", 0L);
        this.p = jSONObject.optString("category", null);
        this.q = jSONObject.optString("tag", null);
        this.t = jSONObject.optLong("value", 0L);
        this.u = jSONObject.optLong("ext_value", 0L);
        this.s = jSONObject.optString("params", null);
        this.r = jSONObject.optString("label", null);
        return this;
    }

    @Override // com.bytedance.bdtracker.t1
    public List<String> b() {
        List<String> b = super.b();
        ArrayList arrayList = new ArrayList(b.size());
        arrayList.addAll(b);
        arrayList.addAll(Arrays.asList("category", "varchar", "tag", "varchar", "value", TypedValues.Custom.S_INT, "ext_value", TypedValues.Custom.S_INT, "params", "varchar", "label", "varchar"));
        return arrayList;
    }

    @Override // com.bytedance.bdtracker.t1
    public void b(ContentValues contentValues) {
        super.b(contentValues);
        contentValues.put("category", this.p);
        contentValues.put("tag", this.q);
        contentValues.put("value", Long.valueOf(this.t));
        contentValues.put("ext_value", Long.valueOf(this.u));
        contentValues.put("params", this.s);
        contentValues.put("label", this.r);
    }

    @Override // com.bytedance.bdtracker.t1
    public String c() {
        StringBuilder a2 = a.a("");
        a2.append(this.q);
        a2.append(", ");
        a2.append(this.r);
        return a2.toString();
    }

    @Override // com.bytedance.bdtracker.t1
    public void c(JSONObject jSONObject) {
        super.c(jSONObject);
        jSONObject.put("tea_event_index", this.f21309c);
        jSONObject.put("category", this.p);
        jSONObject.put("tag", this.q);
        jSONObject.put("value", this.t);
        jSONObject.put("ext_value", this.u);
        jSONObject.put("params", this.s);
        jSONObject.put("label", this.r);
    }

    @Override // com.bytedance.bdtracker.t1
    public String d() {
        return this.s;
    }

    @Override // com.bytedance.bdtracker.t1
    public String f() {
        return "event";
    }

    @Override // com.bytedance.bdtracker.t1
    public JSONObject i() {
        JSONObject jSONObject = !TextUtils.isEmpty(this.s) ? new JSONObject(this.s) : null;
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        jSONObject2.put("local_time_ms", this.b);
        jSONObject2.put("tea_event_index", this.f21309c);
        jSONObject2.put("session_id", this.d);
        long j = this.e;
        if (j > 0) {
            jSONObject2.put("user_id", j);
        }
        int i = this.i;
        if (i != s2.a.UNKNOWN.f21304a) {
            jSONObject2.put("nt", i);
        }
        jSONObject2.put("user_unique_id", TextUtils.isEmpty(this.f) ? JSONObject.NULL : this.f);
        if (!TextUtils.isEmpty(this.g)) {
            jSONObject2.put("ssid", this.g);
        }
        jSONObject2.put("category", this.p);
        jSONObject2.put("tag", this.q);
        jSONObject2.put("value", this.t);
        jSONObject2.put("ext_value", this.u);
        jSONObject2.put("label", this.r);
        jSONObject2.put("datetime", this.l);
        if (!TextUtils.isEmpty(this.h)) {
            jSONObject2.put("ab_sdk_version", this.h);
        }
        j1.c(this.m, jSONObject2);
        return jSONObject2;
    }
}
