package com.oplus.log.c;

import android.os.Process;
import com.oplus.log.d.b;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/log/c/a.class */
public final class a {
    public final String a(String str, String str2, byte b) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("m", str2);
            jSONObject.put("t", str);
            jSONObject.put("l", (int) b);
            jSONObject.put("p", b.e(b.a()));
            jSONObject.put("pid", Process.myPid());
            return jSONObject.toString();
        } catch (JSONException e) {
            if (com.oplus.log.b.a()) {
                e.printStackTrace();
            }
            return "format exception:" + e.toString();
        }
    }
}
