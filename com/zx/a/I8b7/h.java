package com.zx.a.I8b7;

import android.util.Base64;
import com.umeng.analytics.pro.bh;
import com.zx.module.annotation.Java2C;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/h.class */
public class h extends e {
    @Java2C.Method2C
    public static native void a(String str);

    public static String b(String str) throws Exception {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("lid", t2.a(t2.h));
        jSONObject2.put(bh.al, t2.i);
        jSONObject.put("ctx", jSONObject2);
        jSONObject.put("code", str);
        return new String(Base64.encode(k.a(jSONObject.toString(), e.f42118a, "UDID_ENC_AUTHTAG"), 2), StandardCharsets.UTF_8);
    }
}
