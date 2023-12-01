package com.blued.android.framework.web;

import androidx.collection.ArrayMap;
import com.anythink.core.common.b.g;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/web/DownloaderJSCallback.class */
public class DownloaderJSCallback {
    private Map<String, String> a = new ArrayMap();
    private JSExecutor b;

    public DownloaderJSCallback(JSExecutor jSExecutor) {
        this.b = jSExecutor;
    }

    public void a(int i, String str, String str2, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("option", str2);
            jSONObject.put(g.c.b, str);
            jSONObject.put("progress", i2);
            for (String str3 : this.a.keySet()) {
                String str4 = this.a.get(str3);
                JSExecutor jSExecutor = this.b;
                jSExecutor.a(str3, BridgeUtil.JAVASCRIPT_STR + str4 + "('" + i + "'," + jSONObject.toString() + ")");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void a(String str, String str2) {
        this.a.put(str, str2);
    }
}
