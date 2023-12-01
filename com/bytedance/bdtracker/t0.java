package com.bytedance.bdtracker;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/t0.class */
public final class t0 extends i0 {
    public final Context e;
    public final m0 f;

    public t0(Context context, m0 m0Var) {
        super(true, false);
        this.e = context;
        this.f = m0Var;
    }

    @Override // com.bytedance.bdtracker.i0
    public boolean a(JSONObject jSONObject) {
        SharedPreferences sharedPreferences = this.f.e;
        Map a2 = k3.a(this.e);
        if (a2 != null) {
            jSONObject.put("oaid", new JSONObject(a2));
            return true;
        }
        return false;
    }
}
