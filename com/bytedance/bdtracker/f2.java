package com.bytedance.bdtracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/f2.class */
public class f2 extends t1 {
    public long p;
    public long q;
    public String r;

    @Override // com.bytedance.bdtracker.t1
    public int a(Cursor cursor) {
        z2.c("U SHALL NOT PASS!", (Throwable) null);
        return 0;
    }

    @Override // com.bytedance.bdtracker.t1
    public t1 a(JSONObject jSONObject) {
        z2.c("U SHALL NOT PASS!", (Throwable) null);
        return this;
    }

    @Override // com.bytedance.bdtracker.t1
    public List<String> b() {
        return null;
    }

    @Override // com.bytedance.bdtracker.t1
    public void b(ContentValues contentValues) {
        z2.c("U SHALL NOT PASS!", (Throwable) null);
    }

    @Override // com.bytedance.bdtracker.t1
    public String c() {
        return String.valueOf(this.p);
    }

    @Override // com.bytedance.bdtracker.t1
    public void c(JSONObject jSONObject) {
        z2.c("U SHALL NOT PASS!", (Throwable) null);
    }

    @Override // com.bytedance.bdtracker.t1
    public String f() {
        return "terminate";
    }

    @Override // com.bytedance.bdtracker.t1
    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.b);
        jSONObject.put("tea_event_index", this.f21309c);
        jSONObject.put("session_id", this.d);
        jSONObject.put("stop_timestamp", this.q / 1000);
        jSONObject.put("duration", this.p / 1000);
        jSONObject.put("datetime", this.l);
        long j = this.e;
        if (j > 0) {
            jSONObject.put("user_id", j);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.f) ? JSONObject.NULL : this.f);
        if (!TextUtils.isEmpty(this.g)) {
            jSONObject.put("ssid", this.g);
        }
        if (!TextUtils.isEmpty(this.h)) {
            jSONObject.put("ab_sdk_version", this.h);
        }
        if (!TextUtils.isEmpty(this.r)) {
            jSONObject.put("uuid_changed", true);
            if (!TextUtils.equals(this.r, this.d)) {
                jSONObject.put("original_session_id", this.r);
            }
        }
        return jSONObject;
    }
}
