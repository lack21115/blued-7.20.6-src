package com.bytedance.sdk.openadsdk.api.plugin;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/api/plugin/h.class */
public class h {
    private long b;
    private Map<String, Long> hj = new HashMap();
    private String mb;
    private long ox;

    private h(String str, long j) {
        this.mb = str;
        this.ox = j;
        this.b = j;
    }

    public static h mb(String str) {
        return new h(str, SystemClock.elapsedRealtime());
    }

    public long mb() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.ox;
        this.hj.put(this.mb, Long.valueOf(elapsedRealtime));
        return elapsedRealtime;
    }

    public void mb(JSONObject jSONObject, long j) {
        if (jSONObject == null) {
            return;
        }
        for (Map.Entry<String, Long> entry : this.hj.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            if (!TextUtils.isEmpty(key) && value.longValue() > j) {
                try {
                    jSONObject.put(key, value);
                } catch (JSONException e) {
                }
            }
        }
    }

    public long ox(String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.b;
        this.b = SystemClock.elapsedRealtime();
        this.hj.put(str, Long.valueOf(elapsedRealtime));
        return elapsedRealtime;
    }
}
