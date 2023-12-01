package com.bytedance.bdtracker;

import android.content.Context;
import com.umeng.analytics.pro.bh;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/s0.class */
public class s0 extends i0 {
    public final Context e;

    public s0(Context context) {
        super(true, true);
        this.e = context;
    }

    @Override // com.bytedance.bdtracker.i0
    public boolean a(JSONObject jSONObject) {
        n0.a(jSONObject, bh.Q, s2.c(this.e));
        return true;
    }
}
