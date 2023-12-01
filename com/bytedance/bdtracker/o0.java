package com.bytedance.bdtracker;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.umeng.analytics.pro.bh;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/o0.class */
public class o0 extends i0 {
    public final Context e;
    public final n0 f;

    public o0(Context context, n0 n0Var) {
        super(false, false);
        this.e = context;
        this.f = n0Var;
    }

    @Override // com.bytedance.bdtracker.i0
    public boolean a(JSONObject jSONObject) {
        TelephonyManager telephonyManager = (TelephonyManager) this.e.getSystemService("phone");
        if (telephonyManager != null) {
            n0.a(jSONObject, bh.P, telephonyManager.getNetworkOperatorName());
            n0.a(jSONObject, "mcc_mnc", telephonyManager.getNetworkOperator());
        }
        n0.a(jSONObject, "clientudid", ((n2) this.f.g).a());
        n0.a(jSONObject, "openudid", ((n2) this.f.g).c());
        return true;
    }
}
