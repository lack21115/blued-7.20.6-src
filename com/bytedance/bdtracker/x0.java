package com.bytedance.bdtracker;

import android.content.Context;
import android.content.SharedPreferences;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/x0.class */
public class x0 extends i0 {
    public final m0 e;

    public x0(Context context, m0 m0Var, n0 n0Var) {
        super(true, false, false);
        this.e = m0Var;
    }

    @Override // com.bytedance.bdtracker.i0
    public boolean a(JSONObject jSONObject) {
        SharedPreferences sharedPreferences = this.e.e;
        String string = sharedPreferences.getString("bd_did", null);
        n0.a(jSONObject, "bd_did", string);
        String string2 = sharedPreferences.getString("install_id", null);
        String string3 = sharedPreferences.getString(this.e.h(), null);
        n0.a(jSONObject, "install_id", string2);
        n0.a(jSONObject, "ssid", string3);
        long j = 0;
        long j2 = sharedPreferences.getLong("register_time", 0L);
        if ((j1.a(string2) && ((j1.a((String) null) || j1.a(string)) && j1.a(string3))) || j2 == 0) {
            j = j2;
        } else {
            this.e.e.edit().putLong("register_time", 0L).apply();
        }
        jSONObject.put("register_time", j);
        return true;
    }
}
