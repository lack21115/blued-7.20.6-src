package com.bytedance.bdtracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.media.MediaFormat;
import android.text.TextUtils;
import com.bytedance.bdtracker.s2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/d2.class */
public class d2 extends t1 {
    public String p;
    public String q;

    public d2(String str, String str2) {
        this.q = str;
        this.p = str2;
    }

    @Override // com.bytedance.bdtracker.t1
    public int a(Cursor cursor) {
        super.a(cursor);
        this.q = cursor.getString(12);
        this.p = cursor.getString(13);
        return 14;
    }

    @Override // com.bytedance.bdtracker.t1
    public t1 a(JSONObject jSONObject) {
        super.a(jSONObject);
        this.q = jSONObject.optString("event", null);
        this.p = jSONObject.optString("params", null);
        return this;
    }

    @Override // com.bytedance.bdtracker.t1
    public List<String> b() {
        List<String> b = super.b();
        ArrayList arrayList = new ArrayList(b.size());
        arrayList.addAll(b);
        arrayList.addAll(Arrays.asList("event", "varchar", "params", "varchar"));
        return arrayList;
    }

    @Override // com.bytedance.bdtracker.t1
    public void b(ContentValues contentValues) {
        super.b(contentValues);
        contentValues.put("event", this.q);
        contentValues.put("params", this.p);
    }

    @Override // com.bytedance.bdtracker.t1
    public String c() {
        return this.q;
    }

    @Override // com.bytedance.bdtracker.t1
    public void c(JSONObject jSONObject) {
        super.c(jSONObject);
        jSONObject.put("event", this.q);
        jSONObject.put("params", this.p);
    }

    @Override // com.bytedance.bdtracker.t1
    public String d() {
        return this.p;
    }

    @Override // com.bytedance.bdtracker.t1
    public String f() {
        return MediaFormat.KEY_PROFILE;
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
        jSONObject.put("event", this.q);
        a(jSONObject, this.p);
        int i = this.i;
        if (i != s2.a.UNKNOWN.f21304a) {
            jSONObject.put("nt", i);
        }
        jSONObject.put("datetime", this.l);
        if (!TextUtils.isEmpty(this.h)) {
            jSONObject.put("ab_sdk_version", this.h);
        }
        return jSONObject;
    }
}
