package com.bytedance.bdtracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/y1.class */
public class y1 extends t1 {
    public String p;
    public String q;

    public y1(String str, String str2, JSONObject jSONObject) {
        this.q = str2;
        this.p = jSONObject.toString();
        this.j = 0;
        this.k = str;
    }

    @Override // com.bytedance.bdtracker.t1
    public int a(Cursor cursor) {
        super.a(cursor);
        this.p = cursor.getString(12);
        this.q = cursor.getString(13);
        return 14;
    }

    @Override // com.bytedance.bdtracker.t1
    public t1 a(JSONObject jSONObject) {
        super.a(jSONObject);
        this.p = jSONObject.optString("params", null);
        this.q = jSONObject.optString("log_type", null);
        return this;
    }

    @Override // com.bytedance.bdtracker.t1
    public List<String> b() {
        List<String> b = super.b();
        ArrayList arrayList = new ArrayList(b.size());
        arrayList.addAll(b);
        arrayList.addAll(Arrays.asList("params", "varchar", "log_type", "varchar"));
        return arrayList;
    }

    @Override // com.bytedance.bdtracker.t1
    public void b(ContentValues contentValues) {
        super.b(contentValues);
        contentValues.put("params", this.p);
        contentValues.put("log_type", this.q);
    }

    @Override // com.bytedance.bdtracker.t1
    public String c() {
        StringBuilder a2 = a.a("param:");
        a2.append(this.p);
        a2.append(" logType:");
        a2.append(this.q);
        return a2.toString();
    }

    @Override // com.bytedance.bdtracker.t1
    public void c(JSONObject jSONObject) {
        super.c(jSONObject);
        jSONObject.put("params", this.p);
        jSONObject.put("log_type", this.q);
    }

    @Override // com.bytedance.bdtracker.t1
    public String d() {
        return this.p;
    }

    @Override // com.bytedance.bdtracker.t1
    public String f() {
        return "event_misc";
    }

    @Override // com.bytedance.bdtracker.t1
    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.b);
        jSONObject.put("tea_event_index", this.f21309c);
        jSONObject.put("session_id", this.d);
        long j = this.e;
        if (j > 0) {
            jSONObject.put("user_id", j);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.f) ? JSONObject.NULL : this.f);
        if (!TextUtils.isEmpty(this.g)) {
            jSONObject.put("ssid", this.g);
        }
        jSONObject.put("log_type", this.q);
        try {
            JSONObject jSONObject2 = new JSONObject(this.p);
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject2.get(next);
                if (jSONObject.opt(next) != null) {
                    z2.b("misc事件存在重复的key", (Throwable) null);
                }
                jSONObject.put(next, obj);
            }
        } catch (Exception e) {
            z2.a("解析 event misc 失败", e);
        }
        j1.c(this.m, jSONObject);
        return jSONObject;
    }
}
