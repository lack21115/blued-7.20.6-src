package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.map.tools.json.JsonUtils;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/m2.class */
public class m2 extends g2 {
    public static final String i = "name";
    public static final String j = "host";
    public static final String k = "host_test";
    public static final String l = "https";
    public static final String m = "status";

    public void a(JSONObject jSONObject) {
        a().a((o2) JsonUtils.parseToModel(jSONObject, o2.class, new Object[0]));
    }

    public void b(JSONObject jSONObject) {
        j3 j3Var;
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("name", null);
        if (TextUtils.isEmpty(optString) || (j3Var = (j3) c(optString)) == null) {
            return;
        }
        int optInt = jSONObject.optInt("status", 1);
        String optString2 = jSONObject.optString("host", null);
        String optString3 = jSONObject.optString(k, null);
        boolean optBoolean = jSONObject.optBoolean("https", true);
        j3Var.setAllow(optInt != 0);
        j3Var.setUseHttps(optBoolean);
        if (!TextUtils.isEmpty(optString2)) {
            j3Var.b(optString2);
        }
        if (!TextUtils.isEmpty(optString3)) {
            j3Var.c(optString3);
        }
        j3Var.setUseTest(optInt == 2);
    }
}
