package com.kwad.components.core.i;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.kwad.sdk.core.config.d;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/i/b.class */
public final class b {
    public static boolean ac(Context context) {
        boolean z;
        if (context == null) {
            return false;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_local_ad_force_active", 0);
        a aVar = new a();
        if (sharedPreferences.contains("ksadsdk_local_ad_force_active_data")) {
            String string = sharedPreferences.getString("ksadsdk_local_ad_force_active_data", null);
            if (!TextUtils.isEmpty(string)) {
                try {
                    aVar.parseJson(new JSONObject(string));
                } catch (Exception e) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                }
            }
            z = aVar.h(d.uB(), d.uC());
            com.kwad.sdk.core.d.b.d("LocalAdForceActiveHelper", "addCount contains success: " + z);
        } else {
            com.kwad.sdk.core.d.b.d("LocalAdForceActiveHelper", "addCount not contains");
            aVar.nE();
            z = true;
        }
        if (z) {
            sharedPreferences.edit().putString("ksadsdk_local_ad_force_active_data", aVar.toJson().toString()).apply();
        }
        return z;
    }
}
