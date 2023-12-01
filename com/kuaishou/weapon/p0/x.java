package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.push.AttributionReporter;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/x.class */
public class x {
    public JSONArray a(Context context) {
        try {
            JSONArray jSONArray = new JSONArray();
            String d = bg.d();
            if (TextUtils.isEmpty(d) || d.startsWith("RISK")) {
                return null;
            }
            JSONArray jSONArray2 = new JSONArray(d);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray2.length()) {
                    return jSONArray;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("1", jSONArray2.getJSONObject(i2).getString("appName"));
                jSONObject.put("2", jSONArray2.getJSONObject(i2).getString("pkgName"));
                jSONObject.put("3", jSONArray2.getJSONObject(i2).getString(AttributionReporter.APP_VERSION));
                jSONObject.put("5", jSONArray2.getJSONObject(i2).getString("system_app"));
                jSONObject.put("6", jSONArray2.getJSONObject(i2).getString("firstInstallTime"));
                jSONObject.put("7", jSONArray2.getJSONObject(i2).getString("lastUpdateTime"));
                jSONArray.put(jSONObject);
                i = i2 + 1;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
