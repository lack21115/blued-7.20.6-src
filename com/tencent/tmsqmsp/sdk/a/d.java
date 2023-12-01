package com.tencent.tmsqmsp.sdk.a;

import android.os.Build;
import com.tencent.mapsdk.internal.oj;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/a/d.class */
public class d {
    public static JSONObject a(int i) {
        String appID;
        String devId;
        String uid;
        String qImeiVer;
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(e.a(0), i);
            String a2 = e.a(1);
            appID = oj.getAppID();
            jSONObject.put(a2, appID);
            String a3 = e.a(2);
            devId = oj.getDevId();
            jSONObject.put(a3, devId);
            String a4 = e.a(3);
            uid = oj.getUid();
            jSONObject.put(a4, uid);
            String a5 = e.a(4);
            qImeiVer = oj.getQImeiVer();
            jSONObject.put(a5, qImeiVer);
            jSONObject.put(e.a(5), Build.VERSION.SDK_INT);
            jSONObject.put(e.a(6), c.c());
            jSONObject.put(e.a(7), c.e());
            jSONObject.put(e.a(8), System.currentTimeMillis());
            jSONObject.put(e.a(9), 1);
            jSONObject.put(e.a(10), c.h() ? "1" : "0");
            String a6 = e.a(11);
            str = oj.getmOAID();
            jSONObject.put(a6, str);
            return jSONObject;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
