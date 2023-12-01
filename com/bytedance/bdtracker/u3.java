package com.bytedance.bdtracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/u3.class */
public final class u3 {

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f7717a;

    public u3(Context context) {
        this.f7717a = e2.a(context, "device_register_oaid_refine", 0);
    }

    public t3 a() {
        String string = this.f7717a.getString("oaid", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            return new t3(jSONObject.optString("id", null), jSONObject.optString("req_id", null), jSONObject.has("is_track_limited") ? Boolean.valueOf(jSONObject.optBoolean("is_track_limited")) : null, jSONObject.has("take_ms") ? Long.valueOf(jSONObject.optLong("take_ms", -1L)) : null, jSONObject.has("time") ? Long.valueOf(jSONObject.optLong("time", -1L)) : null, jSONObject.has("query_times") ? Integer.valueOf(jSONObject.optInt("query_times", -1)) : null, jSONObject.has("hw_id_version_code") ? Long.valueOf(jSONObject.optLong("hw_id_version_code", -1L)) : null);
        } catch (JSONException e) {
            z2.a(e);
            return null;
        }
    }

    public void a(t3 t3Var) {
        if (t3Var == null) {
            return;
        }
        this.f7717a.edit().putString("oaid", t3Var.b().toString()).apply();
    }
}
