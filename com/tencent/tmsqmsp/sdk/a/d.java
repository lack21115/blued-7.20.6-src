package com.tencent.tmsqmsp.sdk.a;

import android.os.Build;
import com.tencent.tmsqmsp.sdk.app.QmspSDK;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/a/d.class */
public class d {
    public static JSONObject a(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(e.a(0), i);
            jSONObject.put(e.a(1), QmspSDK.getAppID());
            jSONObject.put(e.a(2), QmspSDK.getDevId());
            jSONObject.put(e.a(3), QmspSDK.getUid());
            jSONObject.put(e.a(4), QmspSDK.getQImeiVer());
            jSONObject.put(e.a(5), Build.VERSION.SDK_INT);
            jSONObject.put(e.a(6), c.c());
            jSONObject.put(e.a(7), c.e());
            jSONObject.put(e.a(8), System.currentTimeMillis());
            jSONObject.put(e.a(9), 1);
            jSONObject.put(e.a(10), c.h() ? "1" : "0");
            jSONObject.put(e.a(11), QmspSDK.getmOAID());
            return jSONObject;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
