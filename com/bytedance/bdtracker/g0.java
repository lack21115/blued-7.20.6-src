package com.bytedance.bdtracker;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.applog.util.SensitiveUtils;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/g0.class */
public class g0 extends i0 {
    public Context e;

    public g0(Context context) {
        super(true, false);
        this.e = context;
    }

    @Override // com.bytedance.bdtracker.i0
    public boolean a(JSONObject jSONObject) {
        try {
            Bundle bundle = this.e.getPackageManager().getApplicationInfo(this.e.getPackageName(), 128).metaData;
            if (bundle == null || TextUtils.isEmpty(SensitiveUtils.CHANNEL_APP_KEY)) {
                return true;
            }
            jSONObject.put("appkey", bundle.getString(SensitiveUtils.CHANNEL_APP_KEY));
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            z2.a(e);
            return true;
        }
    }
}
