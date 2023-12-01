package com.bytedance.bdtracker;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/k0.class */
public final class k0 extends i0 {
    public final m0 e;

    public k0(m0 m0Var) {
        super(true, false);
        this.e = m0Var;
    }

    @Override // com.bytedance.bdtracker.i0
    public boolean a(JSONObject jSONObject) {
        String a2 = k3.a(this.e.e);
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        jSONObject.put("cdid", a2);
        return true;
    }
}
