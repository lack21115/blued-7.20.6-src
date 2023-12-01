package com.bytedance.bdtracker;

import android.os.Build;
import com.bytedance.applog.InitConfig;
import com.umeng.analytics.pro.bh;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/j0.class */
public class j0 extends i0 {
    public final m0 e;

    public j0(m0 m0Var) {
        super(true, false);
        this.e = m0Var;
    }

    @Override // com.bytedance.bdtracker.i0
    public boolean a(JSONObject jSONObject) {
        InitConfig initConfig;
        jSONObject.put("platform", "Android");
        jSONObject.put("sdk_lib", "Android");
        jSONObject.put("device_model", Build.MODEL);
        jSONObject.put(bh.F, Build.BRAND);
        jSONObject.put(bh.H, Build.MANUFACTURER);
        jSONObject.put("cpu_abi", Build.CPU_ABI);
        jSONObject.put("sdk_target_version", 29);
        jSONObject.put("git_hash", "99ba6595");
        if (!w2.f21333c.b(new Object[0]).booleanValue() || (initConfig = this.e.b) == null || !initConfig.isHarmonyEnabled()) {
            jSONObject.put(bh.x, "Android");
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            return true;
        }
        jSONObject.put(bh.x, "Harmony");
        try {
            jSONObject.put("os_api", y2.a("hw_sc.build.os.apiversion"));
            jSONObject.put("os_version", y2.a("hw_sc.build.platform.version"));
            return true;
        } catch (Throwable th) {
            z2.a("loadHarmonyInfo", th);
            return true;
        }
    }
}
