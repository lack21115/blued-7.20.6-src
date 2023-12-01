package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMRTLog;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/q.class */
public class q {
    public static long a(JSONArray jSONArray) {
        return jSONArray.toString().getBytes().length;
    }

    public static long a(JSONObject jSONObject) {
        return jSONObject.toString().getBytes().length;
    }

    public static JSONObject a(Context context, long j, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = jSONObject2;
        JSONObject jSONObject4 = jSONObject2;
        try {
            if (jSONObject.has("content")) {
                JSONObject jSONObject5 = jSONObject.getJSONObject("content");
                if (jSONObject5.has("analytics")) {
                    JSONObject jSONObject6 = jSONObject5.getJSONObject("analytics");
                    if (jSONObject6.has("ekv")) {
                        jSONObject6.remove("ekv");
                    }
                    if (jSONObject6.has(d.T)) {
                        jSONObject6.remove(d.T);
                    }
                    if (jSONObject6.has("error")) {
                        jSONObject6.remove("error");
                    }
                    jSONObject5.put("analytics", jSONObject6);
                }
                jSONObject2.put("content", jSONObject5);
                if (jSONObject.has("header")) {
                    jSONObject2.put("header", jSONObject.getJSONObject("header"));
                }
                jSONObject3 = jSONObject2;
                if (a(jSONObject2) > j) {
                    jSONObject3 = null;
                    i.a(context).i();
                    i.a(context).h();
                    i.a(context).b(true, false);
                    i.a(context).a();
                    jSONObject4 = null;
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> u-app packet overload !!! ");
                }
            }
            return jSONObject3;
        } catch (Throwable th) {
            return jSONObject4;
        }
    }
}
