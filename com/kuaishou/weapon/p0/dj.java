package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/dj.class */
public class dj {
    public static JSONObject a() {
        try {
            String str = System.getenv("LD_PRELOAD");
            String str2 = System.getenv("LD_LIBRARY_PATH");
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("0", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("1", str2);
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static int b() {
        try {
            String a2 = bj.a();
            if (TextUtils.isEmpty(a2) || a2.contains("arm64")) {
                return 0;
            }
            return !a2.contains("64") ? 1 : 0;
        } catch (Exception e) {
            return 0;
        }
    }
}
