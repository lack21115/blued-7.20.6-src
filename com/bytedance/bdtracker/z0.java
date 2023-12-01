package com.bytedance.bdtracker;

import android.content.Context;
import android.telephony.TelephonyManager;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/z0.class */
public class z0 extends i0 {
    public final Context e;

    public z0(Context context) {
        super(true, false);
        this.e = context;
    }

    @Override // com.bytedance.bdtracker.i0
    public boolean a(JSONObject jSONObject) {
        n0.a(jSONObject, "sim_region", ((TelephonyManager) this.e.getSystemService("phone")).getSimCountryIso());
        return true;
    }
}
