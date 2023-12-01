package com.zx.a.I8b7;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/t.class */
public class t {
    public static boolean a() {
        try {
            if (TextUtils.isEmpty(t2.y)) {
                return false;
            }
            if (System.currentTimeMillis() - t2.r < new JSONObject(t2.y).getLong("frequency") * 1000) {
                z1.a("report freq c true");
                return true;
            }
            return false;
        } catch (Exception e) {
            z1.a(e);
            return false;
        }
    }
}
